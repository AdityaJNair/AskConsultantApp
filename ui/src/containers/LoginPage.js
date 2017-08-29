import React, { Component } from 'react';
import logo from './../images/logo.svg';
import './LoginPage.css';
import { withRouter } from 'react-router-dom'
import {
    BrowserRouter as Router,
    Route,
    Link
} from 'react-router-dom'

class Header extends Component {
    render() {
        return (
            <div id="header">
                <h1>Ask Consultant</h1>
            </div>
        );
    }
}

class Login_panel extends Component {
    render() {
        return (
            <div id="login_panel">
                <span id = "title"><h1>Login</h1></span>
                <Login_input />
            </div>
        );
    }
}

class Login_p extends Component {
    render() {
        return (
            <div id="login_panel">

            </div>
        );
    }
}

class Login_input extends Component {
    render() {
        return (
            <div id="login_input">
                <form>
                    <label><b>Username : </b></label><input/> <br />
                    <label><b>Password &nbsp;:&nbsp;</b></label><input type="password" /> <br />
                    <button>Login</button>
                    <Link to="/about"><button>Register</button></Link><br />
                    <a>Forgot my password</a>
                </form>

            </div>
        );
    }
}

class Login extends Component {
    render() {
        return (

            <div class="canvas">
                <Header />
                <Login_panel />
            </div>

        );
    }
}

export default Login;
