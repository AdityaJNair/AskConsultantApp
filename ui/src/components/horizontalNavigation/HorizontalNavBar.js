import React, { Component } from 'react';
import './stylesheet/HorizontalNavBar.css';
import FontIcon from 'react-md/lib/FontIcons';
import logo from "../../images/deloitte_logo.png";
import { connect } from 'react-redux'
import {logout} from '../../actions/logoutActions'

class HorizontalNavBar extends Component {
    render(){
        return (
            <div id="horizontal_nav">
                <div id="nav_logo" style = {{width: 'calc(100% - 180px)'}}>
                    <img src={logo} />
                </div>
                <div id="nav_container">
                    <div id="nav_item">
                        <FontIcon id = "nav_icons">notifications none</FontIcon>
                    </div>
                    <div id="nav_item">
                        <FontIcon id = "nav_icons">sms</FontIcon>
                    </div>
                    <div id="nav_item" onClick={this.props.logout}>
                        <p>Log Out</p>
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