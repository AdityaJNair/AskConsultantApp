import React, { Component } from 'react';
import MessageBubbleContainer from "./Message/MessageBubbleContainer";

class MessageView extends Component {
    componentDidMount() {
        console.log(this.props.conversation_id)
    }
    render(){
        return (
            <div id="message_view">
                <MessageBubbleContainer/>
            </div>
        )
    }
}

export default MessageView;