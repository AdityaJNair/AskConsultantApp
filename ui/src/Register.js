import React, { Component } from 'react';
import './Register.css';
import { withRouter } from 'react-router-dom'

class PersonalInfo extends Component {
    render() {
        return (
            <div id="personal_info">
                <h1>Personal Information</h1>
                <div id="info_row">
                    <div id="info_option"><p>Full Name:</p></div>
                    <div id="info_input"><input name="fullname" /></div>
                </div>

                <div id="info_row">
                    <div id="info_option"><p>User Name:</p></div>
                    <div id="info_input"><input  name="username" /></div>
                </div>

                <div id="info_row">
                    <div id="info_option"><p>Date of Birth:</p></div>
                    <div id="info_input"><input name="dateofbirth" /></div>
                </div>

                <div id="info_row">
                    <div id="info_option"><p>Email:</p></div>
                    <div id="info_input"><input  name="email" /></div>
                </div>

                <div id="info_row">
                    <div id="info_option"><p>Gender:</p></div>
                    <div id="info_input">
                        <select name="gender">
                            <option value="male">Male</option>
                            <option value="female">Female</option>
                            <option value="diverse">Gender diverse</option>
                        </select>
                    </div>
                </div>

                <div id="info_row">
                    <div id="info_option"><p>Password:</p></div>
                    <div id="info_input" ><input type="password" name="password" /></div>
                </div>

                <div id="info_row">
                    <div id="info_option"><p>Confirm Password:</p></div>
                    <div id="info_input" type="password"><input type="password" name="confirmpassword" /></div>
                </div>

            </div>

        );
    }
}

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
                    <PersonalInfo />
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