import React, { Component } from 'react';
import {Link} from 'react-router-dom'
import TextField from 'react-md/lib/TextFields';
import Button from 'react-md/lib/Buttons/Button';

class Login_panel extends Component {
    render() {
        return (
            <div id="login_panel">
                <div id="header">
                    <h1>Login</h1>
                </div>
                <Login_input />
                <Login_buttons />

            </div>
        );
    }
}

class Login_input extends Component {
    render() {
        return (
            <div id="login_input">
                <TextField
                    id="floatingCenterTitle"
                    label="User Name"
                    lineDirection="center"
                    placeholder="Enter your user name"
                    className="md-cell md-cell--bottom"
                />
                <TextField
                    id="floatingCenterTitle"
                    label="Password"
                    lineDirection="center"
                    placeholder="Enter your password"
                    type="password"
                    className="md-cell md-cell--bottom"
                />
            </div>
        );
    }
}

class Login_buttons extends Component {
    render() {
        return (
            <div id="login_buttons">
                <Button raised label="Login" />
                <Link to="/register"><Button raised label="Register" /></Link><br />
                <a>Forgot my password</a>
            </div>
        );
    }
}


class Login extends Component {
    render() {
        return (

            <div class="canvas">
                <Login_panel />
            </div>

        );
    }
}

export default Login;
