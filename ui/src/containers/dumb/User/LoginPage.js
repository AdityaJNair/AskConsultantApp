import React, { Component } from 'react';
import { connect } from 'react-redux'
import './LoginPage.css';
import TextField from 'react-md/lib/TextFields';
import Button from 'react-md/lib/Buttons/Button';
import { Link, Redirect } from 'react-router-dom'
import { fetchPosts, resetErrorMsg} from '../../../actions/loginActions';
import { resetSuccessMsg} from '../../../actions/registrationActions';
import Paper from 'react-md/lib/Papers/Paper'

let useridInput, passwordInput

const loginSumbit = (e, dispatch, history) => {
    e.preventDefault()
    console.log(`in the login Submit`)
    if (!useridInput.value.trim() || !passwordInput.value.trim()) {
        return
    }
    dispatch(resetSuccessMsg())
    dispatch(fetchPosts(useridInput.value, passwordInput.value, false))
        .then((success) => {
            //uses status returned by action creator
            console.log(success + '')
            if(success)
                history.push('/messenger')
        })

}

//Holds all the UI for user login page
class Login_panel extends Component {
    componentWillMount(){
        this.props.dispatch(resetErrorMsg())
    }

    componentWillUnMount(){
        this.props.dispatch(resetSuccessMsg())
    }

    render() {
        const {dispatch, history} = this.props
        return (
            <div id="login-background">
                <img
                    id="login-logo"
                    src={require('../../../images/Deloitte_white.svg')} />
                <Paper
                    id="login-paper"
                    zDepth={3}>
                    <div id="login_panel">
                        <div id="login-header">
                            <img
                                id="ask-consulting-logo"
                                src={require('../../../images/AskConsultingLogo.png')}/>
                            <h2>Login</h2>
                        </div>
                        <label id='success_msg'>{this.props.successfulRegMsg}</label>
                        <Login_input />
                        <label id='error_msg'>{this.props.errorMsg}</label>
                        <Login_buttons {...this.props}/>
                    </div>
                </Paper>
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
                    label="Email"
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
                <Link to="/messenger"><Button primary raised onClick={e => loginSumbit(e, this.props.dispatch, this.props.history)} label="Login" /></Link><br />
                <Link to="/register"><Button raised label="Register" /></Link><br />
            </div>
        );
    }
}

class Login extends Component {
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
