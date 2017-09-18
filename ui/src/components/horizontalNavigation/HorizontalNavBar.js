import React, { Component } from 'react';
import './stylesheet/HorizontalNavBar.css';
import FontIcon from 'react-md/lib/FontIcons';

class HorizontalNavBar extends Component {
    render(){
        return (
            <div id="horizontal_nav">
                <div id="nav_logo" style = {{width: 'calc(100% - 180px)'}}>Navigation Bar</div>
                <div id="nav_container">
                    <div id="nav_item">
                        <FontIcon id = "nav_icons">notifications none</FontIcon>
                    </div>
                    <div id="nav_item">
                        <FontIcon id = "nav_icons">sms</FontIcon>
                    </div>
                    <div id="nav_item">
                        <FontIcon id = "nav_icons">settings</FontIcon>
                    </div>
                </div>
            </div>
        )
    }
}

export default HorizontalNavBar;