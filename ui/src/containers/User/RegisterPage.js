import React, { Component } from 'react';
import './RegisterPage.css';
import { withRouter } from 'react-router-dom'
import PersonalInformation from '../../components/Register/PersonalInformation.js';
import AdditionalInformation from '../../components/Register/AdditionalInformation.js';
import Submit from '../../components/Register/Submit.js'

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