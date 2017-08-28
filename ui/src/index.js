import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import registerServiceWorker from './registerServiceWorker';

import Login from './Login';
import  Register from './Register';
import App from './App';

ReactDOM.render(<Register />, document.getElementById('root'));
registerServiceWorker();
