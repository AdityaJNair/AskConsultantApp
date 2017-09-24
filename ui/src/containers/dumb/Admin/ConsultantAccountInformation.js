import React, { Component } from 'react';
import TextField from 'react-md/lib/TextFields';
import SelectField from 'react-md/lib/SelectFields';
import Button from 'react-md/lib/Buttons/Button';

import {consultantsTopics,development,strategyAndOperations,everydayDeloitte,humanCapital,technology,other} from './topics.js';

export let name, email, password,role,primaryTopic,primarySubTopic,secondaryTopic,secondarySubTopic;

class RegistrationAccount extends Component {
  render() {
    return (
      <div class="canvas">
          <h2>Register New Consultant</h2>
          <TextField ref={node => {name = node}}
              id="floatingCenterTitle"
              label="Name"
              lineDirection="center"
              className="md-cell md-cell--bottom"
          />
          <TextField ref={node => {email = node}}
              id="floatingCenterTitle"
              label="Email"
              lineDirection="center"
              className="md-cell md-cell--bottom"
          />
          <TextField ref={node => {password = node}}
              id="floatingCenterTitle"
              label="Temporary Password"
              lineDirection="center"
              placeholder="Enter your password"
              type="password"
              className="md-cell md-cell--bottom"
          />
          <TextField
              id="floatingCenterTitle"
              label="Confirm Temporary Password"
              lineDirection="center"
              placeholder="Confirm your password"
              type="password"
              className="md-cell md-cell--bottom"
          />
      </div>
    );
  }
}

class RegistrationExtraDetails extends Component {
  render() {
    return (
      <div class="canvas">
          <h2>Additional Information</h2>
          <TextField ref={node => {role = node}}
              id="floatingCenterTitle"
              label="Role"
              lineDirection="center"
              placeholder="role in Deloitte"
              className="md-cell md-cell--bottom"
          />
          <SelectField ref={node => {primaryTopic = node}}
              label="Primary Topic"
              placeholder="Select a State"
              menuItems={consultantsTopics}
              itemLabel="name"
              itemValue="abbreviation"
              className="md-cell"
              helpOnFocus
              helpText="Select primary topic"
          />
          <SelectField ref={node => {primarySubTopic = node}}
              label="Sub Topic for Primary"
              placeholder="Select a State"
              menuItems={consultantsTopics}
              itemLabel="name"
              itemValue="abbreviation"
              className="md-cell"
              helpOnFocus
              helpText="Select primary sub topic"
          />
          <SelectField ref={node => {secondaryTopic = node}}
              label="Secondary Topic"
              placeholder="Select a State"
              menuItems={consultantsTopics}
              itemLabel="name"
              itemValue="abbreviation"
              className="md-cell"
              helpOnFocus
              helpText="Select secondary topic"
          />
          <SelectField ref={node => {secondarySubTopic = node}}
              label="Secondary Topic"
              placeholder="Select a State"
              menuItems={consultantsTopics}
              itemLabel="name"
              itemValue="abbreviation"
              className="md-cell"
              helpOnFocus
              helpText="Select secondary sub topic"
          />
      </div>
    );
  }
}

class SubmitRegistration extends Component {
  render(){
    return(
      <div class="canvas">
        <Button>Submit</Button>
      </div>
    );
  }
}

class consultantRegistration extends Component  {
  render(){
    return(
      <div class="canvas">
        <RegistrationAccount/>
        <RegistrationExtraDetails/>
        <SubmitRegistration/>
      </div>
    );
  }
}

export default consultantRegistration;
