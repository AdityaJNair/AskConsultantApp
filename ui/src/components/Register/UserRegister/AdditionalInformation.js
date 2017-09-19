import React, { Component } from 'react';
import TextField from 'react-md/lib/TextFields';
import SelectField from 'react-md/lib/SelectFields';
import '../../../containers/dumb/User/RegisterPage.css';

const occupationOptions = ["Undergraduate Student", "Accounting"];
const industryOptions = ["Accounting", "Consulting"];

export let occupation, industry, interest, source;

export class AdditionalInformation extends Component {
    render() {
        return (
            <div class="canvas">
                <h2>Additional Information</h2>
                <SelectField ref={node => {occupation = node}}
                    label="Current Occupation"
                    placeholder="Select occupation"
                    menuItems={occupationOptions}
                    itemLabel="name"
                    itemValue="abbreviation"
                    className="md-cell"
                    helpOnFocus
                    helpText="Select occupation"
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
                />

                <TextField ref={node => {interest = node}}
                    id="floatingCenterTitle"
                    label="Why are you interested in this app?"
                    lineDirection="center"
                    className="md-cell md-cell--bottom"
                />

                <TextField ref={node => {source = node}}
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