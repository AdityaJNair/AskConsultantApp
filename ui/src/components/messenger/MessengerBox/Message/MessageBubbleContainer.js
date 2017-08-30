import React, { Component } from 'react';
import MessageTextBubble from "./MessageTextBubble";
import ProfileImageBox from "./ProfileImageBox";


class MessageBubbleContainer extends Component {
    render(){
        return (
            <div id="message_bubble_container">
                <MessageTextBubble/>
                <ProfileImageBox/>
            </div>
        )
    }
}

export default MessageBubbleContainer;