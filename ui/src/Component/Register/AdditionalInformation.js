import React, { Component } from 'react';
import TextField from 'react-md/lib/TextFields';
import SelectField from 'react-md/lib/SelectFields';
import './Register.css';

const occupation = ["Undergraduate Student", "Accounting"];
const industry = ["Accounting", "Consulting"];

class AdditionalInformation extends Component {
    render() {
        return (
            <div class="canvas">
                <h2>Additional Information</h2>
                <SelectField
                    label="Current Occupation"
                    placeholder="Select occupation"
                    menuItems={occupation}
                    itemLabel="name"
                    itemValue="abbreviation"
                    className="md-cell"
                    helpOnFocus
                    helpText="Select occupation"
                /><br />

                <SelectField
                    label="What industry are you interested in?"
                    placeholder="Select your interested industry"
                    menuItems={industry}
                    itemLabel="name"
                    itemValue="abbreviation"
                    className="md-cell"
                    helpOnFocus
                    helpText="Select your interested industry"
                />

                <TextField
                    id="floatingCenterTitle"
                    label="Why are you interested in this app?"
                    lineDirection="center"
                    className="md-cell md-cell--bottom"
                />

                <TextField
                    id="floatingCenterTitle"
                    label="How did you get to know about Deloitte?"
                    lineDirection="center"
                    className="md-cell md-cell--bottom"
                />


            </div>

        );
    }
}

export default AdditionalInformation;