import React, { Component } from 'react';
import MessageBubbleContainer from "./Message/MessageBubbleContainer";
import MessageQuestion from "./MessageQuestion";

class MessageView extends Component {
    render(){
        return (
            <div id="message-view">
				<MessageQuestion />
                <MessageBubbleContainer/>
            </div>
        )
    }
}

export default MessageView;