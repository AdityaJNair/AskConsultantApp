import React, { Component } from 'react';
import './RegisterPage.css';
import { withRouter } from 'react-router-dom'
import {PersonalInformation, fullName, userName, dob, email, gender, password} from '../../../components/Register/UserRegister/PersonalInformation.js';
import {AdditionalInformation, occupation, industry, interest, source} from '../../../components/Register/UserRegister/AdditionalInformation.js';
import Submit from '../../../components/Register/UserRegister/Submit.js'
import {postRegDetails, completedRegistration} from "../../../actions/registrationActions";

const registrationSubmit = (e, dispatch, history) => {
    e.preventDefault();
    let dobtest = dob;
    console.log("in reg submit: " + fullName.value +
        "\n user name: " + userName.value +
        "\n dob: " + dob.state.value +
        "\n email: " + email.value +
        "\n gender: " + gender.value +
        "\n password: " + password.value +
        "\n gender: " + occupation.value +
        "\n gender: " + industry.value +
        "\n gender: " + interest.value +
        "\n gender: " + source.value
    )
    dispatch(postRegDetails(fullName.value,
        userName.value,
        dob.state.value,
        email.value,
        gender.value,
        password.value,
        occupation.value,
        industry.value,
        interest.value,
        source.value))
        .then((updatedStatus) => {
        //uses status returned by action creator
            console.log(updatedStatus + '')
            if(updatedStatus)
                history.push('/')
        })
        .then(() =>
            dispatch(completedRegistration())
    );


}


class RegisterPanel extends Component {
    render() {
        return (
            <div id="register_panel">
                <h2>Register</h2>
                <form>
                    <PersonalInformation />
                    <AdditionalInformation />
                    <label id='error_message'>{this.props.errorMsg}</label>
                    <Submit {...this.props} registrationSubmit={registrationSubmit}/>

                </form>
            </div>

        );
    }
}

class Register extends Component {
    render() {
        return (
            <div class="canvas">
                <RegisterPanel {...this.props}/>
            </div>

        );
    }
}



export default Register;