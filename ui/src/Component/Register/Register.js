import React, { Component } from 'react';
import './Register.css';
import { withRouter } from 'react-router-dom'
import PersonalInformation from './PersonalInformation.js';

class AdditionalInfo extends Component {
    render() {
        return (
            <div id="additional_info">
                <h1>Additional Information</h1>

                <div id="info_row">
                    <div id="info_option"><p>Current Occupation:</p></div>
                    <div id="info_input">
                        <select name="occupation">
                            <option value="student">Student</option>
                        </select>
                    </div>
                </div>

                <div id="info_row">
                    <div id="info_option"><p>What industry are you interested in?</p></div>
                    <div id="info_input">
                        <select name="interest">
                            <option value="accounting">Accounting</option>
                        </select>
                    </div>
                </div>

                <div id="info_row">
                    <div id="info_option"><p>Why are you interested in this app?</p></div>
                    <div id="info_input"><input /></div>
                </div>

                <div id="info_row">
                    <div id="info_option"><p>How did you get to know about Deloitte?</p></div>
                    <div id="info_input"><input /></div>
                </div>
            </div>

        );
    }
}

class Submit extends Component {
    render() {
        return (
            <div id="submit">
                <div id="info_row">
                    <div id="info_option">
                        <input id="checkBox" type="checkbox" />I accept the <a>Terms and Conditions</a>
                    </div>
                    <div id="info_input">
                        <button>Submit</button>
                    </div>
                </div>

            </div>

        );
    }
}

class RegisterPanel extends Component {
    render() {
        return (
            <div id="register_panel">
                <h2>Register</h2>
                <form>
                    <PersonalInformation />
                    <AdditionalInfo />
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