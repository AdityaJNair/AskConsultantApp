import React, { Component } from 'react';
import '../../../containers/dumb/User/RegisterPage.css';

import Checkbox from 'react-md/lib/SelectionControls/Checkbox';
import Button from 'react-md/lib/Buttons/Button';
import {Link} from 'react-router-dom'

class Submit extends Component {
    render() {
        return (
            <div id="canvas">
                <Checkbox
                    id="readDocumentationPage"
                    name="simpleCheckboxes"
                    label="I accept the Terms and Conditions"
                />
                <Link to="/"><Button raised label="Submit" /></Link>

            </div>

        );
    }
}

export default Submit;