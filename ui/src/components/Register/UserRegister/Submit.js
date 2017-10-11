import React, { Component } from 'react';
import '../../../containers/dumb/User/RegisterPage.css';

import Checkbox from 'react-md/lib/SelectionControls/Checkbox';
import Button from 'react-md/lib/Buttons/Button';
import {Link} from 'react-router-dom'

//Holds the submit button UI section for user registration
class Submit extends Component {
    render() {
        return (
            <div id="canvas">
                <a><p id="terms">Terms and Conditions</p></a>
                <Checkbox
                    id="readDocumentationPage"
                    name="simpleCheckboxes"
                    label="I accept the Terms and Conditions"
                />

                <Button raised label="Submit"  onClick={e => this.props.registrationSubmit(e, this.props.dispatch, this.props.history, this.props.regStatus)}/>

            </div>

        );
    }
}

export default Submit;