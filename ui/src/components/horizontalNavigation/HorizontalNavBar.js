import React, { Component } from 'react';
import './stylesheet/HorizontalNavBar.css';
import FontIcon from 'react-md/lib/FontIcons';
import { connect } from 'react-redux'
import {logout} from '../../actions/logoutActions'
import Button from 'react-md/lib/Buttons/Button';
import logo from "../../images/deloitte_logo_transparent_small.png";

class HorizontalNavBar extends Component {
    render(){
        return (
            <div id="horizontal_nav">
                <div id="nav_logo" style = {{width: 'calc(100% - 180px)'}}>
                    <img src={logo} width="230px" height="60px"/>
                </div>
                <div id="nav_container">
                        {/*<div class="nav_item">*/}
                            {/*<FontIcon id = "nav_icon_notification">notifications none</FontIcon>*/}
                        {/*</div>*/}
                        {/*<div class="nav_item">*/}
                            {/*<FontIcon id = "nav_icon_sms">sms</FontIcon>*/}
                        {/*</div>*/}
                    <div id="nav_item" >
                        <Button floating primary onClick={() => {this.props.logout()}}><FontIcon>exit_to_app</FontIcon></Button>
                    </div>
                </div>
            </div>
        )
    }
}

const mapStateToProps = ({loginInfo}) => {
    return {
        logged: loginInfo.token
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        logout: () => {
            dispatch(logout())
        }
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(HorizontalNavBar)