import React, { Component } from 'react';
import Style from "./stylesheet/MessageWindow.css"
import MessageView from "./MessageView";
import MessengerTextComponent from "./MessengerTextComponent";
import NewConversationPage from "./NewConversationPage";


class MessageWindow extends Component {
    render(){
        return (
            <div id="message-window">
                <MessageView/>
                <MessengerTextComponent/>
                <NewConversationPage/>
            </div>
        )
    }
}

export default MessageWindow;