import React, { Component } from 'react';
import './stylesheet/HorizontalNavBar.css';
import FontIcon from 'react-md/lib/FontIcons';
import MenuButton from 'react-md/lib/Menus/MenuButton';
import ListItem from 'react-md/lib/Lists/ListItem';
import logo from "../../images/deloitte_logo.png";

class HorizontalNavBar extends Component {
    render(){
        return (
            <div id="horizontal_nav">
                <div id="nav_logo" style = {{width: 'calc(100% - 180px)'}}>
                    <img src={logo} />
                </div>
                <div id="nav_container">
                        {/*<div class="nav_item">*/}
                            {/*<FontIcon id = "nav_icon_notification">notifications none</FontIcon>*/}
                        {/*</div>*/}
                        {/*<div class="nav_item">*/}
                            {/*<FontIcon id = "nav_icon_sms">sms</FontIcon>*/}
                        {/*</div>*/}
                    <div id="nav_item">
                        <MenuButton
                        id="nav_icons"
                        icon
                        menuItems={['Logout']}
                        >
                            settings
                        </MenuButton>
                    </div>
                </div>
            </div>
        )
    }
}

export default HorizontalNavBar;