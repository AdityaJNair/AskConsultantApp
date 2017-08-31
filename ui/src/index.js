import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import registerServiceWorker from './registerServiceWorker';
import {
    BrowserRouter as Router,
    Route,
    Link
} from 'react-router-dom'

import UserChat from "./containers/UserChatPage";

ReactDOM.render(
    <Router>
        <div>
            <UserChat/>
            {/*
            <Route exact path="/" component={Login}/>
            <Route path="/about" component={Register}/>
            */}
        </div>
    </Router>
    ,
    document.getElementById('root'));
registerServiceWorker();
