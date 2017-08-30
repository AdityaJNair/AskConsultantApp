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
import Mdtest from './Component/Register/Mdtest'

ReactDOM.render(
    <Register />
    ,
    document.getElementById('root'));
registerServiceWorker();
