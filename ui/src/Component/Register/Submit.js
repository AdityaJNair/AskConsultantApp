import React, { Component } from 'react';
import './Register.css';

import Checkbox from 'react-md/lib/SelectionControls/Checkbox';
import Button from 'react-md/lib/Buttons/Button';

class Submit extends Component {
    render() {
        return (
            <div id="canvas">
                <Checkbox
                    id="readDocumentationPage"
                    name="simpleCheckboxes"
                    label="I accept the Terms and Conditions"
                />
                <Button raised label="Submit" />

            </div>

        );
    }
}

export default Submit;