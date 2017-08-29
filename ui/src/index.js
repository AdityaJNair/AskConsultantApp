import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import Login from './containers/LoginPage';
import App from './containers/App';
import registerServiceWorker from './registerServiceWorker';
import UserChat from "./containers/UserChatPage";

ReactDOM.render(<UserChat/>, document.getElementById('root'));
registerServiceWorker();
