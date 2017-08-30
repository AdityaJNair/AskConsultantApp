import React, { Component } from 'react';
import './Register.css';
import { withRouter } from 'react-router-dom'
import PersonalInformation from './PersonalInformation.js';
import AdditionalInformation from './AdditionalInformation.js';
import Submit from './Submit.js'

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