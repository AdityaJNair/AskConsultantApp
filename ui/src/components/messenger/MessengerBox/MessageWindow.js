import React, { Component } from 'react';
import MessageView from "./MessageView";
import './stylesheet/MessengerTextComponent.css'
import MessengerSendText from '../../../containers/smart/Messenger/MessengerSendText'

class MessageWindow extends Component {
    componentWillMount () {
        console.log("Message windows did mount")
    }
    render(){
        return (
            <div>
                <MessageView/>
                <MessengerSendText/>
            </div>
        )
    }
}

export default MessageWindow;