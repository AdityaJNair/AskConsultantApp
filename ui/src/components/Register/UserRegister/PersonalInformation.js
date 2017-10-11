import React, { Component } from 'react';
import TextField from 'react-md/lib/TextFields';
import SelectField from 'react-md/lib/SelectFields';
import DatePicker from 'react-md/lib/Pickers/DatePickerContainer';
import '../../../containers/dumb/User/RegisterPage.css';

const genderOptions = ["Male", "Female", "Gender diverse"];

export let firstName, lastName, userName, dob, email, gender, password;

//Holds the personal info UI for registration for users
export class PersonalInformation extends Component {
    render() {
        return (
            <div class="canvas">
                <h2>Personal Information</h2>
                <TextField ref={node => {firstName = node}}
                    id="floatingCenterTitle"
                    label="First Name"
                    lineDirection="center"
                    placeholder="Enter your first name"
                    className="md-cell md-cell--bottom"
                />
                <TextField ref={node => {lastName = node}}
                           id="floatingCenterTitle"
                           label="Last Name"
                           lineDirection="center"
                           placeholder="Enter your last name"
                           className="md-cell md-cell--bottom"
                />
                <TextField ref={node => {userName = node}}
                    id="floatingCenterTitle"
                    label="User Name"
                    lineDirection="center"
                    placeholder="Enter your user name"
                    className="md-cell md-cell--bottom"
                />
                <DatePicker ref={node => {dob = node}}
                    id="appointment"
                    label="Date of Birth"
                    className="md-cell"
                    maxDate={new Date()}
                />

                <TextField ref={node => {email = node}}
                    id="floatingCenterTitle"
                    label="Email"
                    lineDirection="center"
                    placeholder="Enter your Email"
                    className="md-cell md-cell--bottom"
                />

                <SelectField ref={node => {gender = node}}
                    label="Gender"
                    placeholder="Select a State"
                    menuItems={genderOptions}
                    itemLabel="name"
                    itemValue="abbreviation"
                    className="md-cell"
                    helpOnFocus
                    helpText="Select your gender"
                />

                <TextField ref={node => {password = node}}
                    id="floatingCenterTitle"
                    label="Password"
                    lineDirection="center"
                    placeholder="Enter your password"
                    type="password"
                    className="md-cell md-cell--bottom"
                />

                <TextField
                    id="floatingCenterTitle"
                    label="Confirm Password"
                    lineDirection="center"
                    placeholder="Confirm your password"
                    type="password"
                    className="md-cell md-cell--bottom"
                />



            </div>

        );
    }
}

export default PersonalInformation;