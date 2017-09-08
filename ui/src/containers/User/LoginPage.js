import React, { Component } from 'react';
import logo from '../../images/logo.svg';
import './LoginPage.css';
import TextField from 'react-md/lib/TextFields';
import Button from 'react-md/lib/Buttons/Button';
import {
    BrowserRouter as Router,
    Route,
    Link
} from 'react-router-dom'
import 'whatwg-fetch';

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
    handleSubmit(){
        var user =
            { "userid": "dom1@gmail", "password": "password", "isEmployee":"false" }


        var url = "https://45.76.113.175:8443/askconsultant/rest/session"
        fetch(url, {
            method: "POST",
            mode: "no-cors",
            headers: {
                //'Access-Control-Allow-Origin': "*",
                'Content-Type': 'application/json'
                // 'Accept': 'application/json, text/plain, /'
            },
            body: JSON.stringify(user)
        })
            .then(function(response) {
                if (response.ok) {
                    console.log("Perfect! Your settings are saved.");
                    //return response.json()
                } else if (response.status === 401) {
                    console.log("Oops! You are not authorized.");
                }

            }, function(e) {
                console.log("Error submitting form!");

            })
            .then(function(json) {
                // console.log(json.token)
            })
    }

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
                <Link to="/messenger"><Button raised label="Login" /></Link><br />
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
