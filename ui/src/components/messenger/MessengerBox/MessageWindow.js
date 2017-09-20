import React, { Component } from 'react';
import MessageView from "./MessageView";
import MessengerTextComponent from "./MessengerTextComponent";
import './stylesheet/MessengerTextComponent.css'


class MessageWindow extends Component {
    render(){
        return (
            <div>
                <MessageView/>
                <MessengerTextComponent/>
            </div>
        )
    }
}

export default MessageWindow;