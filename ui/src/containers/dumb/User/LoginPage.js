import React, { Component } from 'react';
import { connect } from 'react-redux'
import './LoginPage.css';
import TextField from 'react-md/lib/TextFields';
import Button from 'react-md/lib/Buttons/Button';
import { Link, Redirect } from 'react-router-dom'
import { fetchPosts} from '../../../actions/loginActions';
import history from "../../../history";

let useridInput, passwordInput

const loginSumbit = (e, dispatch, history) => {
    e.preventDefault()
    console.log(`in the login Submit`)
    if (!useridInput.value.trim() || !passwordInput.value.trim()) {
        return
    }
    dispatch(fetchPosts(useridInput.value, passwordInput.value, false))
    history.push('/messenger')
}

class Login_panel extends Component {
    componentDidMount(){
        console.log(`panel`)
        //console.log(this.props.history)
    }
    render() {
        const {dispatch, history} = this.props
        return (
            <div id="login_panel">
                <div id="header">
                    <h1>Login</h1>
                </div>
                <Login_input />
                <Login_buttons {...this.props}/>
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
                <Link to="/messenger"><Button onClick={e => loginSumbit(e, this.props.dispatch, this.props.history)} label="Login" /></Link><br />
                <Link to="/register"><Button raised label="Register" /></Link><br />
                <a>Forgot my password</a>
            </div>
        );
    }
}

class Login extends Component {
    componentDidMount(){
        console.log(`Login: ${this.props.logged}`)
        if (this.props.history !== undefined) {
            console.log("history existing!")
            //console.log(this.props.history)
        }
    }
    // due to the hierarchies of the component, the smart/User/LoginPage is the parent of Login,
    // Login is the parent of Login_panel, Login_panel is the parent of Login_button
    // So when we use the props from the smart/User/LoginPage, we should delivery via props one level of hierarchy after one
    // Similarly, if we use dispatch, we should delivery this function as test.
    render() {
         return (
            <div class="canvas">
                <Login_panel {...this.props}/>
            </div>

        )
    }
}

export default Login;
