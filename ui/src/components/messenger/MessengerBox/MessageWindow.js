import React, { Component } from 'react';
import MessageView from "./MessageView";
import MessengerTextComponent from "./MessengerTextComponent";


class MessageWindow extends Component {
    render(){
        return (
            <div id="message-window">
                <MessageView/>
                <MessengerTextComponent/>
            </div>
        )
    }
}

export default MessageWindow;