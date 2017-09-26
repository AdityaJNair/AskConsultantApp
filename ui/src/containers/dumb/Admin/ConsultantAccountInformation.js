import React, { Component } from 'react';
import TextField from 'react-md/lib/TextFields';
import SelectField from 'react-md/lib/SelectFields';
import Button from 'react-md/lib/Buttons/Button';
import {consultantsTopics,development,strategyAndOperations,everydayDeloitte,humanCapital,technology} from './topics.js';
import {postRegDetails} from '../../../actions/adminAction';

export let name, email, password,passwordConfirm,role,primaryTopic,primarySubTopic;

class RegistrationAccount extends Component {

  constructor () {
    super();
    this.state = {
      primarySubTopicList : [],
      primarySubTopicListDisabled : true,
      nameError : false,
      emailError : false,
      passwordError : false,
      passwordConfirmError : false,
      roleError : false,
      primaryTopicError : false,
      primarySubTopicError : false,
      passwordErrorMessage : "This field is required.",
      passwordConfirmErrorMessage : "This field is required.",
      emailErrorMessage : "This field is required.",
      created : ""
    }
  }

  verifyFields = () => {
    this.setState({
      created: "",
    })
    if(name.value !== "" && email.value !== "" && role.value !== "" &&
        primaryTopic.value !== "" && primarySubTopic.value !== "" && password.value !== ""
       && passwordConfirm.value !== "" && password.value === passwordConfirm.value){
         this.setState({
           nameError : false,
           emailError : false,
           passwordError : false,
           passwordConfirmError : false,
           roleError : false,
           primaryTopicError : false,
           primarySubTopicError : false,
         })
         //DO GOOD WORK HERE
         console.log("CLICKED");
         this.props.dispatch(postRegDetails(name.value, email.value, password.value,role.value,primaryTopic.value,primarySubTopic.value))
             .then((success) => {
                 //uses status returned by action creator
                 if(success){
                   this.setState({
                     created : "Employee has been successfully added.",
                   })
                 } else {
                   this.setState({
                     created : "The employee email already exists.",
                   })

                 }

             })
    } else {
      if(name.value === ""){
        this.setState({
          nameError : true,
        })
      } else {
        this.setState({
          nameError : false,
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
      if(role.value === ""){
        this.setState({
          roleError : true,
        })
      } else {
        this.setState({
          roleError : false,
        })
      }
      if(primaryTopic.value === ""){
        this.setState({
          primaryTopicError : true,
        })
      } else {
        this.setState({
          primaryTopicError : false,
        })
      }
      if(primarySubTopic.value === ""){
        this.setState({
          primarySubTopicError : true,
        })
      } else {
        this.setState({
          primarySubTopicError : false,
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

  updatePrimaryList= (event, index, value) => {
    switch(event){
      case 'Development':
        this.setState({
            primarySubTopicList : development,
            primarySubTopicListDisabled : false,
        })
        break;
      case 'Everyday Deloitte':
        this.setState({
          primarySubTopicList : everydayDeloitte,
          primarySubTopicListDisabled : false,
        })
        break;
      case 'Human Capital':
        this.setState({
          primarySubTopicList : humanCapital,
          primarySubTopicListDisabled : false,
        })
        break;
      case 'Strategy & Operations':
        this.setState({
          primarySubTopicList : strategyAndOperations,
          primarySubTopicListDisabled : false,
        })
        break;
      case 'Technology':
        this.setState({
          primarySubTopicList : technology,
          primarySubTopicListDisabled : false,
        })
      break;
      default:
        this.setState({
          primarySubTopicList : [],
          primarySubTopicListDisabled : true
        })
    }
  }



  render() {
    return (
      <div class="canvas">
          <h2>Register New Consultant</h2>
          <form>
            <TextField ref={node => {name = node}}
                id="floatingCenterTitle"
                required
                label="Name"
                lineDirection="center"
                className="md-cell md-cell--bottom"
                error= {this.state.nameError}
                errorText="This field is required."
            />
            <TextField ref={node => {email = node}}
                id="floatingCenterTitle"
                required
                label="Email"
                lineDirection="center"
                className="md-cell md-cell--bottom"
                error= {this.state.emailError}
                errorText={this.state.emailErrorMessage}
            />
            <TextField ref={node => {password = node}}
                id="floatingCenterTitle"
                required
                label="Temporary Password"
                lineDirection="center"
                placeholder="Enter your password"
                type="password"
                className="md-cell md-cell--bottom"
                error= {this.state.passwordError}
                errorText={this.state.passwordErrorMessage}
            />
            <TextField ref={node => {passwordConfirm = node}}
                id="floatingCenterTitle"
                required
                label="Confirm Temporary Password"
                lineDirection="center"
                placeholder="Confirm your password"
                type="password"
                className="md-cell md-cell--bottom"
                error= {this.state.passwordConfirmError}
                errorText={this.state.passwordErrorMessage}
            />
            <h2>Additional Information</h2>
            <TextField ref={node => {role = node}}
                id="floatingCenterTitle"
                required
                label="Role"
                lineDirection="center"
                placeholder="role in Deloitte"
                className="md-cell md-cell--bottom"
                error= {this.state.roleError}
                errorText="This field is required."
            />
            <SelectField ref={node => {primaryTopic = node}}
                label="Primary Topic"
                required
                placeholder="Select a State"
                menuItems={consultantsTopics}
                onChange={this.updatePrimaryList.bind(this)}
                itemLabel="name"
                itemValue="abbreviation"
                className="md-cell"
                helpOnFocus
                helpText="Select primary topic"
                error= {this.state.primaryTopicError}
                errorText="This field is required."
            />
            <SelectField ref={node => {primarySubTopic = node}}
                label="Sub Topic for Primary"
                required
                placeholder="Select a State"
                menuItems={this.state.primarySubTopicList}
                disabled={this.state.primarySubTopicListDisabled}
                itemLabel="name"
                itemValue="abbreviation"
                className="md-cell"
                helpOnFocus
                helpText="Select sub topic"
                error= {this.state.primarySubTopicError}
                errorText="This field is required."
            />
            <Button onClick={this.verifyFields.bind(this)} >Submit</Button>
            <p>{this.state.created}</p>
        </form>
      </div>
    );
  }
}


class consultantRegistration extends Component  {
  render(){
    return(
      <div class="canvas">
        <RegistrationAccount {...this.props}/>
      </div>
    );
  }
}

export default consultantRegistration;
