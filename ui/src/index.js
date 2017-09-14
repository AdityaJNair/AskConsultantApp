import React from 'react';
import ReactDOM from 'react-dom';
import {Provider} from 'react-redux'
import {createStore, applyMiddleware} from 'redux'
import thunkMiddleware from 'redux-thunk'
import './index.css';
import registerServiceWorker from './registerServiceWorker';
import {
    BrowserRouter,
    Route,
    Link
} from 'react-router-dom'
import RegisterPage from './containers/dumb/User/RegisterPage';
import LoginPage from './containers/dumb/User/LoginPage';
import UserChatPage from './containers/dumb/User/UserChatPage';
import EmployeeLoginPage from "./containers/dumb/Employee/EmployeeLoginPage";
import EmployeeRegistrationPage from "./containers/dumb/Employee/EmployeeRegistrationPage";
import EmployeeChatPage from "./containers/dumb/Employee/EmployeeChatPage";

const store = createStore(
    reducers,
    applyMiddleware(thunkMiddleware)
)

ReactDOM.render(
    <Provider>
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
    </Provider>
    ,
    document.getElementById('root'));
registerServiceWorker();
