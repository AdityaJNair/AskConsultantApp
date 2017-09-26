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
import reducers from './reducers/groupedReducer'
import MessageRoute from './routes/MessageRoute'
import RegisterPage from './containers/smart/User/RegisterPage';
import LoginPage from './containers/smart/User/LoginPage';
import UserChatPage from './containers/dumb/User/UserChatPage';
import EmployeeLoginPage from "./containers/smart/Employee/EmployeeLoginPage";
import EmployeeChatPage from "./containers/dumb/Employee/EmployeeChatPage.js";
import ConsultantAccountInformation from "./containers/smart/Admin/ConsultantAccountInformation";

const store = createStore(
    reducers,
    applyMiddleware(thunkMiddleware)
)
store.subscribe(() => {
    console.log(store.getState());
})

ReactDOM.render(
    <Provider store={store}>
        <BrowserRouter>
            <Switch>
                <Route path="/" exact component={LoginPage}/>
                <Route path="/register" component={RegisterPage}/>
                <MessageRoute path="/messenger" component={UserChatPage}/>
                {/* The employees/consultants need to access this directly. No direct click to this place*/}
                <Route path="/consultants" component={EmployeeLoginPage}/>
                <Route path="/consultants_messenger" component={EmployeeChatPage}/>
                {/*Admin create consultant*/}
                <Route path="/register_new_consultant" component={ConsultantAccountInformation}/>

            </Switch>
        </BrowserRouter>
    </Provider>
    ,
    document.getElementById('root'));
registerServiceWorker();
