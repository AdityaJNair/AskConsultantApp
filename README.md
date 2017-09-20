# AskConsultantApp
Deloitte AskConsultantApp

This project is related to Softeng 761 Agile

We set up our directories like this:
```
AskConsultantApp
└── askconsultant
└── mobile
└── ui
```
*askconsultant* directory is the module of back end service; Mobile module is in the *mobile* directory.; *ui* directory is for the web application.

The directory structure of web application is following:
```
ui
└── node_modules
└── public
└── src
```
*node_modules* holds the dependencies of npm packages installed through "npm install" command.
*public* folder is generated through "npm ceate-react-app" command. *src* is where we put our web application code.

The directory structure of *src* is below:
```
src
├── actions
├── components
├── containers
│   ├── dumb
│   └── smart
├── images
├── reducers
├── routes
├── index.css
├── registerServiceWorker.js    
└── index.js
 ```
 All the action files are placed in the *actions* folders. Actions are payloads of information that send data from the application to the store.(http://redux.js.org/docs/basics/Actions.html) *components* folder holds the reusable components which the containers in dumb subfolder will import to reuse. The dumb word means the containers is not equipped with the function to update the store and view. In contrast, the smart container provides functions to modify the store and then update view, like the controller layer in the MVC framework. There is no magic in the *image* folder, since it is normal folder storing images. The \*Rreducer.js file in *reducers* folder deals with dispatched action and current state to return a new state. All the route files of router is placed in the *routes* folder. *index.js* is the index page of the whole web app and the top hierarchy component.
