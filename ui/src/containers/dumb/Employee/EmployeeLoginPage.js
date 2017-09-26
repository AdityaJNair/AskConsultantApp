import React, { Component } from 'react';
import './EmployeeLoginPage.css';
import Button from 'react-md/lib/Buttons/Button';
import TextField from 'react-md/lib/TextFields';
import { fetchPosts, resetErrorMsg} from '../../../actions/loginActions';
import {
    BrowserRouter as Router,
    Route,
    Link
} from 'react-router-dom'
import 'whatwg-fetch';


let useridInput, passwordInput

const loginSubmit = (e, dispatch, history) => {
    e.preventDefault()
    console.log(`in the login Submit`)
    if (!useridInput.value.trim() || !passwordInput.value.trim()) {
        return
    }

    dispatch(fetchPosts(useridInput.value, passwordInput.value, true))
        .then((success) => {
            //uses status returned by action creator
            console.log(success + '')
            if(success)
                history.push('/consultants_messenger')
        })

}


class Employee_Login_input extends Component {
    componentWillMount(){
        this.props.dispatch(resetErrorMsg())
    }
    render() {
        return (
            <form action="">
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
                    <label id='error_msg'>{this.props.errorMsg}</label>
                    <div id="login_buttons">
                        <Button raised label="Login" onClick={e => loginSubmit(e, this.props.dispatch, this.props.history)} />
                        <br />
                        <a>Forgot my password</a>
                    </div>
                </div>
            </form>
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
                <Employee_Login_input {...this.props}/>
            </div>

        );
    }
}

export default EmployeeLoginPage;
