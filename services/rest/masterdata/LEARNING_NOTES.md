## TODO:
* default error page: try to use the `ErrorAttributes` of Spring Boot

## Rationale of Exception Handling
### With Configuration

* configured with minimal `web.xml`
* The `WebMvcConfigurer`'s pertinent methods are kept unchanged as default, meaning neither `configureHandlerExceptionResolvers` nor `extendHandlerExceptionResolvers` is overridden

#### Control Flow
When a `MethodArgumentNotValidException` is thrown, `processHandlerException` in `DispatcherServlet` is called. The instance varaible `handlerExceptionResolvers` of the `DispatcherServlet` is a list with only one element, an instance of `HandlerExceptionResolverComposite`. The list of `HandlerExceptionResolver`, i.e. the `HandlerExceptionResolverComposite`, is looped through by invoking the `resolveException` method:

```
@Nullable
  protected ModelAndView processHandlerException(HttpServletRequest request, HttpServletResponse response,
      @Nullable Object handler, Exception ex) throws Exception {

    // Success and error responses may use different content types
    request.removeAttribute(HandlerMapping.PRODUCIBLE_MEDIA_TYPES_ATTRIBUTE);

    // Check registered HandlerExceptionResolvers...
    ModelAndView exMv = null;
    if (this.handlerExceptionResolvers != null) {
      for (HandlerExceptionResolver resolver : this.handlerExceptionResolvers) {
        exMv = resolver.resolveException(request, response, handler, ex);//IMPORTANT!
        if (exMv != null) {
          break;
        }
      }
    }
```    

##### The Source Code of `HandlerExceptionResolverComposite.resolveException`

```
@Override
  @Nullable
  public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
      @Nullable Object handler,Exception ex) {

    if (this.resolvers != null) {
      for (HandlerExceptionResolver handlerExceptionResolver : this.resolvers) {
        ModelAndView mav = handlerExceptionResolver.resolveException(request, response, handler, ex);
        if (mav != null) {
          return mav;
        }
      }
    }
    return null;
  }
```
The instance variable, `this.resolvers`, is the list of `HandlerExceptionResolver` configured by the `configureHandlerExceptionResolver` or `extendsHandlerExceptionResolver` of the `WebMvcConfigurer`. Based of the [documentation of `HandlerExceptionResolver.configureHandlerExceptionResolver`](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/config/annotation/WebMvcConfigurer.html#configureHandlerExceptionResolvers-java.util.List-):

> If it is left empty, the framework configures a default set of resolvers, see [WebMvcConfigurationSupport.addDefaultHandlerExceptionResolvers(List)](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/config/annotation/WebMvcConfigurationSupport.html#addDefaultHandlerExceptionResolvers-java.util.List-)

Then based on the documentation of [WebMvcConfigurationSupport.addDefaultHandlerExceptionResolvers(List)](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/config/annotation/WebMvcConfigurationSupport.html#addDefaultHandlerExceptionResolvers-java.util.List-), the default list of `HandlerExceptionResolver`s are the following:

* `ExceptionHandlerExceptionResolver` for handling exceptions through ExceptionHandler methods.
* `ResponseStatusExceptionResolver` for exceptions annotated with ResponseStatus.
* `DefaultHandlerExceptionResolver` for resolving known Spring exception types

The `ExceptionHandlerExceptionResolver.resolveException` invokes the *exception handling* method in `ResponseEntityExceptionHandler` indirectly and, as `ExceptionHandlerExceptionResolver.resolveException` returns an instance of `ModelAndView`, the loop through `this.resolvers` in `handlerExceptionResolverComposite.resolveException` terminates instead of continuing to `resolveException` with `ResponseStatusExceptionResolver`.

##### Design Patterns Applied in `HandlerExceptionResolverComposite.resolveException`

Inside the `HandlerExceptionResolverComposite.resolveException`, the looping through the list of `HandlerExceptionResolver` is a *variant of chain of responsibility*.



