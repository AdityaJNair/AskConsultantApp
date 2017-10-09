import React, { Component } from 'react';
import MessageBubbleContainer from "./Message/MessageBubbleContainer";

class MessageView extends Component {
    render(){
        return (
            <div id="message-view">
                <MessageBubbleContainer/>
            </div>
        )
    }
}

export default MessageView;