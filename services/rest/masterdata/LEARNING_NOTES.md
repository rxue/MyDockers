## TODO:
* default error page: try to use the `ErrorAttributes` of Spring Boot

## Rationale of Exception Handling
### With Configuration

* configured with minimal `web.xml`
* The `WebMvcConfigurer`'s pertinent methods are kept unchanged as default, meaning neither `configureHandlerExceptionResolvers` nor `extendHandlerExceptionResolvers` is overridden

#### Control Flow
When a `MethodArgumentNotValidException` is thrown, `processHandlerException` in `DispatcherServlet` is called. The instance varaible `handlerExceptionResolvers` of the `DispatcherServlet` is a list with only one element, an instance of `HandlerExceptionResolverComposite`. The `HandlerExceptionResolverComposite` contains the configured list of `HandlerExceptionResolver`s, i.e. the `resolvers` instance variable of `HandlerExceptionResolverComposite`.

Back to the `HandlerExceptionResolverComposite.processHandlerException`, inside which the list of `HandlerExceptionResolver`, i.e. the `HandlerExceptionResolverComposite`, is looped through by invoking the `resolveException`:

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
        exMv = resolver.resolveException(request, response, handler, ex);
        if (exMv != null) {
          break;
        }
      }
    }
```    

