import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import registerServiceWorker from './registerServiceWorker';
import {
    BrowserRouter as Router,
    Route,
    Link
} from 'react-router-dom'
import RegisterPage from './containers/User/RegisterPage';
import LoginPage from './containers/User/LoginPage';
import UserChatPage from './containers/User/UserChatPage';
import App from './containers/App';
import UserChat from "./containers/User/UserChatPage";
import EmployeeLoginPage from "./containers/Employee/EmployeeLoginPage";

ReactDOM.render(
    <Router>
        <div>
            <Route exact path="/" component={LoginPage}/>
            <Route path="/register" component={RegisterPage}/>
            <Route path="/messenger" component={UserChatPage}/>
            <Route path="/consultants" component={EmployeeLoginPage}/>

        </div>
    </Router>
    ,
    document.getElementById('root'));
registerServiceWorker();
