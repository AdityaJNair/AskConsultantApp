import React, { Component } from 'react';
import Avatar from 'react-md/lib/Avatars';

class ProfileImageBox extends Component {
    render(){
        return (
            <div id="profile_image">
                <Avatar random role="presentation" ></Avatar>
                <div>User Name</div>
                <div>Role/Occupation</div>
            </div>
        )
    }
}

export default ProfileImageBox;