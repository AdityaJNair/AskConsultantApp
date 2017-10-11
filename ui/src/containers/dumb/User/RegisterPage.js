import React, { Component } from 'react';
import './RegisterPage.css';
import { withRouter } from 'react-router-dom'
import DatePicker from 'react-md/lib/Pickers/DatePickerContainer';
import TextField from 'react-md/lib/TextFields';
import SelectField from 'react-md/lib/SelectFields';
import Checkbox from 'react-md/lib/SelectionControls/Checkbox';
import Button from 'react-md/lib/Buttons/Button';
import Submit from '../../../components/Register/UserRegister/Submit.js'
import logo from '../../../images/Deloitte_white.svg'

import {postRegDetails, completedRegistration} from "../../../actions/registrationActions";

export let firstName, lastName, userName, dob, email, gender, password,passwordConfirm, occupation, industry, interest, source, checkbox;
const occupationOptions = ["Undergraduate Student", "Accounting"];
const industryOptions = ["Accounting", "Consulting"];
const genderOptions = ["Male", "Female", "Gender diverse"];

//Registers user by sending the values added by the user.
const registrationSubmit = (e, dispatch, history) => {
    e.preventDefault();
    let dobtest = dob;

    dispatch(postRegDetails(firstName.value,
        lastName.value,
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
            if(updatedStatus)
                history.push('/')
        })
        .then(() =>
            dispatch(completedRegistration())
    );


}

//Holds all the UI for the registration panel
class RegisterPanel extends Component {
  constructor () {
    super();
    this.state = {
      firstNameError : false,
      secondNameError : false,
      userNameError : false,
      dobError: false,
      emailError : false,
      genderError : false,
      occupationError : false,
      industryError : false,
      interestError : false,
      sourceError : false,
      passwordError : false,
      passwordConfirmError : false,
      checkError : false,
      checkValue : false,
      termErrorMessage : "",
      passwordErrorMessage : "This field is required.",
      passwordConfirmErrorMessage : "This field is required.",
      emailErrorMessage : "This field is required.",
    }
  }

  //Makes sure that all the fields are not left empty and are valid
  verifyFields = (event) => {
    if(firstName.value !== "" && lastName.value !== ""  && email.value !== "" &&
        dob.state.value !== "" && industry.value !== "" && interest.value !== "" &&
        source.value !== "" && userName.value !== "" && gender.value !== "" &&
        password.value !== "" && passwordConfirm.value !== "" && this.state.checkValue &&
        password.value === passwordConfirm.value){
         this.setState({
           firstNameError : false,
           secondNameError : false,
           userNameError : false,
           dobError: false,
           emailError : false,
           genderError : false,
           occupationError : false,
           industryError : false,
           interestError : false,
           sourceError : false,
           passwordError : false,
           passwordConfirmError : false,
           checkError : false,
         });
        registrationSubmit(event, this.props.dispatch, this.props.history, this.props.regStatus);
    } else {
      if(firstName.value === ""){
        this.setState({
          firstNameError : true,
        })
      } else {
        this.setState({
          firstNameError : false,
        })
      }
      if(lastName.value === ""){
        this.setState({
          lastNameError : true,
        })
      } else {
        this.setState({
          lastNameError : false,
        })
      }
     if(email.value === ""){
        this.setState({
          emailError : true,
          emailErrorMessage : "This field is required.",
        })
      } else {
        if(this.ValidateEmail(email.value)){
          this.setState({
            emailError : false,
          })
        } else {
          this.setState({
            emailError : true,
            emailErrorMessage : "Enter a valid email.",
          })
        }
      }
      if(gender.value === ""){
        this.setState({
          genderError : true,
        })
      } else {
        this.setState({
          genderError : false,
        })
      }
      if(userName.value === ""){
        this.setState({
          userNameError : true,
        })
      } else {
        this.setState({
          userNameError : false,
        })
      }
      if(dob.state.value === ""){
        this.setState({
          dobError : true,
        })
      } else {
        this.setState({
          dobError : false,
        })
      }
      if(occupation.value === ""){
        this.setState({
          occupationError : true,
        })
      } else {
        this.setState({
          occupationError : false,
        })
      }
      if(industry.value === ""){
        this.setState({
          industryError : true,
        })
      } else {
        this.setState({
          industryError : false,
        })
      }
      if(interest.value === ""){
        this.setState({
          interestError : true,
        })
      } else {
        this.setState({
          interestError : false,
        })
      }
      if(source.value === ""){
        this.setState({
          sourceError : true,
        })
      } else {
        this.setState({
          sourceError : false,
        })
      }
      if(!this.state.checkValue){
        this.setState({
          termErrorMessage : "You have to agree to the terms and conditions to use the service.",
        })
      } else {
        this.setState({
          termErrorMessage : "",
        })
      }
      if(password.value === ""){
        this.setState({
          passwordError : true,
        })
      } else {
        this.setState({
          passwordError : false,
        })
      }
      if(passwordConfirm.value === ""){
        this.setState({
          passwordConfirmError : true,
        })
      } else {
        this.setState({
          passwordConfirmError : false,
        })
      }
      if(password.value !== "" && passwordConfirm.value !== "" && password.value !== passwordConfirm.value){
        this.setState({
          passwordError : true,
          passwordConfirmError : true,
          passwordErrorMessage : "Passwords do not match.",
          passwordConfirmErrorMessage : "Passwords do not match.",
        })
      } else if(password.value !== "" && passwordConfirm.value !== "" && password.value === passwordConfirm.value){
        this.setState({
          passwordError : false,
          passwordConfirmError : false,
          passwordErrorMessage : "This field is required.",
          passwordConfirmErrorMessage : "This field is required.",
        })
      }
    }
  }

  ValidateEmail = (mail) =>  {
   if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(mail))
    {
      return (true)
    }
      return (false)
  }

  onCheckClick = () => {
    this.setState({
      checkValue : !this.state.checkValue
    })
  }

    render() {
        return (
            <div id="register_container">
                <div id="register_panel">
                    <h1>Register</h1>
                      <form>
                        <h2>Personal Information</h2>
                        <TextField ref={node => {firstName = node}}
                            required
                            id="floatingCenterTitle"
                            label="First Name"
                            lineDirection="center"
                            placeholder="Enter your first name"
                            className="md-cell md-cell--bottom"
                            error= {this.state.firstNameError}
                            errorText="This field is required."
                        />
                        <TextField ref={node => {lastName = node}}
                             required
                             id="floatingCenterTitle"
                             label="Last Name"
                             lineDirection="center"
                             placeholder="Enter your last name"
                             className="md-cell md-cell--bottom"
                             error= {this.state.lastNameError}
                             errorText="This field is required."
                        />
                        <TextField ref={node => {userName = node}}
                            required
                            id="floatingCenterTitle"
                            label="Preferred Name"
                            lineDirection="center"
                            placeholder="Enter your user name"
                            className="md-cell md-cell--bottom"
                            error= {this.state.userNameError}
                            errorText="This field is required."
                        />
                        <DatePicker ref={node => {dob = node}}
                            required
                            id="appointment"
                            label="Date of Birth"
                            className="md-cell"
                            maxDate={new Date()}
                            error= {this.state.dobError}
                            errorText="This field is required."
                        />

                        <TextField ref={node => {email = node}}
                            required
                            id="floatingCenterTitle"
                            label="Email"
                            lineDirection="center"
                            placeholder="Enter your Email"
                            className="md-cell md-cell--bottom"
                            error= {this.state.emailError}
                            errorText={this.state.emailErrorMessage}
                        />

                        <SelectField ref={node => {gender = node}}
                            required
                            label="Gender"
                            placeholder="Select a State"
                            menuItems={genderOptions}
                            itemLabel="name"
                            itemValue="abbreviation"
                            className="md-cell"
                            helpOnFocus
                            helpText="Select your gender"
                            error= {this.state.genderError}
                            errorText="This field is required."
                        />

                        <TextField ref={node => {password = node}}
                            required
                            id="floatingCenterTitle"
                            label="Password"
                            lineDirection="center"
                            placeholder="Enter your password"
                            type="password"
                            className="md-cell md-cell--bottom"
                            error= {this.state.passwordError}
                            errorText={this.state.passwordErrorMessage}
                        />

                        <TextField ref={node => {passwordConfirm = node}}
                            required
                            id="floatingCenterTitle"
                            label="Confirm Password"
                            lineDirection="center"
                            placeholder="Confirm your password"
                            type="password"
                            className="md-cell md-cell--bottom"
                            error= {this.state.passwordConfirmError}
                            errorText={this.state.passwordErrorMessage}
                        />
                        <h2>Additional Information</h2>
                        <SelectField ref={node => {occupation = node}}
                            required
                            label="Current Occupation"
                            placeholder="Select occupation"
                            menuItems={occupationOptions}
                            itemLabel="name"
                            itemValue="abbreviation"
                            className="md-cell"
                            helpOnFocus
                            helpText="Select occupation"
                            error= {this.state.occupationError}
                            errorText="This field is required."
                        /><br />

                        <SelectField ref={node => {industry = node}}
                            label="What industry are you interested in?"
                            placeholder="Select your interested industry"
                            menuItems={industryOptions}
                            itemLabel="name"
                            itemValue="abbreviation"
                            className="md-cell"
                            helpOnFocus
                            helpText="Select your interested industry"
                            error= {this.state.industryError}
                            errorText="This field is required."
                        />

                        <TextField ref={node => {interest = node}}
                            id="floatingCenterTitle"
                            label="Why are you interested in this app?"
                            lineDirection="center"
                            className="md-cell md-cell--bottom"
                            error= {this.state.interestError}
                            errorText="This field is required."
                        />

                        <TextField ref={node => {source = node}}
                            id="floatingCenterTitle"
                            label="How did you get to know about Deloitte?"
                            lineDirection="center"
                            className="md-cell md-cell--bottom"
                            error= {this.state.sourceError}
                            errorText="This field is required."
                        />
                        <label id='error_message'>{this.props.errorMsg}</label>
                        <a><p id="terms">Terms and Conditions</p></a>
                        <Checkbox ref={node => {checkbox = node}}
                            id="readDocumentationPage"
                            name="simpleCheckboxes"
                            label="I accept the Terms and Conditions"
                            checked = {!!this.state.checkValue}
                            onChange={this.onCheckClick.bind(this)}
                        />
                        <p id="termsAccepted">{this.state.termErrorMessage}</p>
                        <Button raised label="Submit"  onClick={this.verifyFields.bind(this)}/>
                    </form>
                </div>
            </div>
        );
    }
}

class Register extends Component {
    render() {
        return (
            <div class="canvas">
                <div>
                    <img src={logo} id="register-logo"/>
                </div>
                <RegisterPanel {...this.props}/>
            </div>

        );
    }
}



export default Register;
