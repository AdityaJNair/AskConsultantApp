import React, { Component } from 'react';
import './RegisterPage.css';
import { withRouter } from 'react-router-dom'
import PersonalInformation from '../../components/Register/UserRegister/PersonalInformation.js';
import AdditionalInformation from '../../components/Register/UserRegister/AdditionalInformation.js';
import Submit from '../../components/Register/UserRegister/Submit.js'

class RegisterPanel extends Component {
    render() {
        return (
            <div id="register_panel">
                <h2>Register</h2>
                <form>
                    <PersonalInformation />
                    <AdditionalInformation />
                    <Submit/>
                </form>
            </div>

        );
    }
}

class Register extends Component {
    render() {
        return (
            <div class="canvas">
                <RegisterPanel />
            </div>

        );
    }
}

export default Register;