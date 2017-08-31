import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import registerServiceWorker from './registerServiceWorker';
import {
    BrowserRouter as Router,
    Route,
    Link
} from 'react-router-dom'

import Login from './Login';
import  Register from './Component/Register/Register';
import App from './App';

ReactDOM.render(
    <Router>
        <div>
            <Route exact path="/" component={Login}/>
            <Route exact path="/register" component={Register}/>
        </div>
    </Router>
    ,
    document.getElementById('root'));
registerServiceWorker();
