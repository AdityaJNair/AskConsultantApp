# AskConsultantApp
Deloitte AskConsultantApp

This project is related to Softeng 761 Agile

More details can be found in the Github Wiki

## Directory Structure

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

## Installation

To use the app, you need node.js to be installed.

Using node.js command prompt, change directory to the ui folder in your askconsultant repo and run "npm install" to set up react on your repository.

To then open the app run "npm start". This will start the development server and open the app on your default browser.

### Setup

Inorder to successfully send and recieve data from the server you first have to successfully visit (https://45.76.113.175:8443/askconsultant/rest/session) by bypassing the certificate error.

Secondly you have to have a "CORS" extension on your browser enabled (for Chrome use: https://chrome.google.com/webstore/detail/allow-control-allow-origi/nlfbmbojpeacfghkpbjhddihlkkiljbi)

### UI web interface

To view the consultants pages add http://localhost:3000/consultants '/consultants' path to the end of url after running NPM START
By default it should be on the user chat.


