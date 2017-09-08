import React, { Component } from 'react';
import './EmployeeLoginPage.css';
import Button from 'react-md/lib/Buttons/Button';

import {
    BrowserRouter as Router,
    Route,
    Link
} from 'react-router-dom'

class EmployeeLoginPage extends Component {
    render() {
        return (
            <div class="canvas">
                Employee login page
                <Link to="/consultants_register"><Button raised label="Go to registration" /></Link><br />
            </div>

        );
    }
}

export default EmployeeLoginPage;