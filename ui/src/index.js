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
import EmployeeLoginPage from "./containers/Employee/EmployeeLoginPage";
import EmployeeRegistrationPage from "./containers/Employee/EmployeeRegistrationPage";
import EmployeeChatPage from "./containers/Employee/EmployeeChatPage";

ReactDOM.render(
    <Router>
        <div>
            <Route exact path="/" component={LoginPage}/>
            <Route path="/register" component={RegisterPage}/>
            <Route path="/messenger" component={UserChatPage}/>

            {/* The employees/consultants need to access this directly. No direct click to this place*/}
            <Route path="/consultants" component={EmployeeLoginPage}/>
            <Route path="/consultants_register" component={EmployeeRegistrationPage}/>
            <Route path="/consultants_messenger" component={EmployeeChatPage}/>
        </div>
    </Router>
    ,
    document.getElementById('root'));
registerServiceWorker();
