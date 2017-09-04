import React, { Component } from 'react';
import MessageTextBubble from "./MessageTextBubble";
import ProfileImageBox from "./ProfileImageBox";
import Paper from 'react-md/lib/Papers';
import "./stylesheet/MessageBubbleContainer.css"


class MessageBubbleContainer extends Component {
    render(){
        return (
            <div id="message_bubble_container">
                <ProfileImageBox/>
                <MessageTextBubble/>
            </div>
        )
    }
}

export default MessageBubbleContainer;