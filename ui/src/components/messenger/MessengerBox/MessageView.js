import React, { Component } from 'react';
import MessageBubbleContainer from "./Message/MessageBubbleContainer";
import "./stylesheet/MessageView.css"

class MessageView extends Component {
    render(){
        return (
            <div id="message_view">
                <MessageBubbleContainer/>
            </div>
        )
    }
}

export default MessageView;