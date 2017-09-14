import React, { Component } from 'react';
import './LoginPage.css';
import TextField from 'react-md/lib/TextFields';
import Button from 'react-md/lib/Buttons/Button';
import { Link } from 'react-router-dom'
import { fetchPosts} from '../../../actions/loginActions';

let useridInput, passwordInput

const loginSumbit = (e, dispatch) => {
    e.preventDefault()
    if (!useridInput.value.trim() || !passwordInput.value.trim()) {
        return
    }
    dispatch(fetchPosts(useridInput.value, passwordInput.value, false))
    useridInput.value = ''
    passwordInput.value = ''
}

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
    constructor(){
        super()
    }

    render() {
        return (
            <div id="login_input">
                <TextField ref={node => {useridInput = node}}
                    id="floatingCenterTitle"
                    label="User Name"
                    lineDirection="center"
                    placeholder="Enter your user name"
                    className="md-cell md-cell--bottom"
                />
                <TextField ref={node => {passwordInput = node}}
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
                <Link to="/messenger"><Button onClick={e => loginSumbit(e, this.props.dispatch)} label="Login" /></Link><br />
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
