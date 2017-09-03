import React, { Component } from 'react';
import TextField from 'react-md/lib/TextFields';
import SelectField from 'react-md/lib/SelectFields';
import DatePicker from 'react-md/lib/Pickers/DatePickerContainer';
import './stylesheet/Register.css';

const gender = ["Male", "Female", "Gender diverse"];

class PersonalInformation extends Component {
    render() {
        return (
            <div class="canvas">
                <h2>Personal Information</h2>
                <TextField
                    id="floatingCenterTitle"
                    label="Full Name"
                    lineDirection="center"
                    placeholder="Enter your full name"
                    className="md-cell md-cell--bottom"
                />
                <TextField
                    id="floatingCenterTitle"
                    label="User Name"
                    lineDirection="center"
                    placeholder="Enter your user name"
                    className="md-cell md-cell--bottom"
                />
                <DatePicker
                    id="appointment"
                    label="Date of Birth"
                    className="md-cell"
                    maxDate={new Date()}
                />

                <TextField
                    id="floatingCenterTitle"
                    label="Email"
                    lineDirection="center"
                    placeholder="Enter your Email"
                    className="md-cell md-cell--bottom"
                />

                <SelectField
                    label="Gender"
                    placeholder="Select a State"
                    menuItems={gender}
                    itemLabel="name"
                    itemValue="abbreviation"
                    className="md-cell"
                    helpOnFocus
                    helpText="Select some state for me"
                />

                <TextField
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