import React, { Component } from 'react';
import Avatar from 'react-md/lib/Avatars';
import "./stylesheet/ProfileImageBox.css"

class ProfileImageBox extends Component {
    render(){
        return (
            <div id="profile_box">
                <div id="avatar-container"><Avatar random role="presentation" id="profile-avatar"></Avatar></div>

                <div id="user-name">User Name</div>
                <div id="role">Role/Occupation</div>
            </div>
        )
    }
}

export default ProfileImageBox;