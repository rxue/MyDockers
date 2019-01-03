# Terminologies
* Vanilla js
* ES6 - EcmaScript 6

# ES6
## Class
**Classes are heavy** => try to avoid the use of classes as always


# `create-react-app`
After creating a ReactJS project, the relevant code for developers are in the `public` and `src` directory, where the most important files are `public/index.html` and `src/index.js`, meaning other files in these two directories can be removed and developers can add their own customed js/css files.

# Basics of ReactJS  
## Components
There are two main types of components, *functional components* and *class based components*.

**Functional components are stateless**

### Class Based Components
Class based components have the ability to know what's happening on the application. They could have a record of data that could be changing in the applicaiton.
 
#### Tips of Using Class Based Components
**You should always avoid using the class based components with `state`**, because it is a little bit harder to maintain

## `import`
You cannot import from `public` directory but `src`

## `state`
`state` is an object that serves us like a database to
 
* store values
* check for events

# References
[`create-react-app`](https://github.com/facebook/create-react-app)

# Touble shooting
* [System limit for number of file watchers reached] (https://github.com/guard/listen/wiki/Increasing-the-amount-of-inotify-watchers) when running `npm start`
