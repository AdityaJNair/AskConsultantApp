import React, { Component } from 'react';
import Avatar from 'react-md/lib/Avatars';
import "./stylesheet/ProfileImageBox.css"
import { connect } from 'react-redux'

class ProfileImageBoxUser extends Component {
    render(){
        return (
            <div id="profile_box_user">
                <div id="avatar-container"><Avatar random role="presentation" id="profile-avatar"></Avatar></div>

                <div id="user-name">{this.props.sentbyuserid}</div>
                {/*//TODO get the role of the user.*/}
                {/*<div id="role">Role/Occupation</div>*/}
            </div>
        )
    }
}

const mapStateToProps = ({loginInfo}) => {
    return {
        currenUserid: loginInfo.userid,
    }
}

export default connect(mapStateToProps)(ProfileImageBoxUser);

