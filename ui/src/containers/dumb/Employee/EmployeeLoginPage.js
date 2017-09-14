import React, { Component } from 'react';
import './EmployeeLoginPage.css';
import Button from 'react-md/lib/Buttons/Button';
import TextField from 'react-md/lib/TextFields';
import {
    BrowserRouter as Router,
    Route,
    Link
} from 'react-router-dom'
import 'whatwg-fetch';

class Employee_Login_buttons extends Component {
    render() {
        return (
            <div id="login_buttons">
                <Link to="/consultants_messenger"><Button raised label="Login" /></Link><br />
                <Link to="/consultants_register"><Button raised label="Register" /></Link><br />
                <a>Forgot my password</a>
            </div>
        );
    }
}

class Employee_Login_input extends Component {
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

class EmployeeLoginPage extends Component {
    render() {
        return (
            <div id="login_panel">
                <div id="header">
                    <h1>Consultant Login Page</h1>
                </div>
                <Employee_Login_input/>
                <Employee_Login_buttons />
            </div>

        );
    }
}

export default EmployeeLoginPage;