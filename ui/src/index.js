import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import registerServiceWorker from './registerServiceWorker';
import {
    BrowserRouter as Router,
    Route,
    Link
} from 'react-router-dom'
import RegisterPage from './containers/RegisterPage';
import LoginPage from './containers/LoginPage';
import UserChatPage from './containers/UserChatPage';
import App from './containers/App';
import UserChat from "./containers/UserChatPage";

ReactDOM.render(
    <Router>
        <div>
            <Route exact path="/" component={LoginPage}/>
            <Route path="/register" component={RegisterPage}/>
            <Route path="/messenger" component={UserChatPage}/>
        </div>
    </Router>
    ,
    document.getElementById('root'));
registerServiceWorker();
