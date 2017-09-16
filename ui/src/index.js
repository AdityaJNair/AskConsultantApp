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
    Switch
} from 'react-router-dom'
import reducers from './reducers/loginReducer'
import MessageRoute from './routes/MessageRoute'
import RegisterPage from './containers/dumb/User/RegisterPage';
import LoginPage from './containers/smart/User/LoginPage';
import UserChatPage from './containers/dumb/User/UserChatPage';
import EmployeeLoginPage from "./containers/dumb/Employee/EmployeeLoginPage";
import EmployeeRegistrationPage from "./containers/dumb/Employee/EmployeeRegistrationPage";
import EmployeeChatPage from "./containers/dumb/Employee/EmployeeChatPage";

const store = createStore(
    reducers,
    applyMiddleware(thunkMiddleware)
)

ReactDOM.render(
    <Provider store={store}>
        <BrowserRouter>
            <Switch>
                <Route path="/" exact component={LoginPage}/>
                <Route path="/register" component={RegisterPage}/>
                <MessageRoute path="/messenger" component={UserChatPage}/>
                {/* The employees/consultants need to access this directly. No direct click to this place*/}
                <Route path="/consultants" component={EmployeeLoginPage}/>
                <Route path="/consultants_register" component={EmployeeRegistrationPage}/>
                <Route path="/consultants_messenger" component={EmployeeChatPage}/>
            </Switch>
        </BrowserRouter>
    </Provider>
    ,
    document.getElementById('root'));
registerServiceWorker();
