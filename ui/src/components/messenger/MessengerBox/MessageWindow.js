import React, { Component } from 'react';
import MessageView from "./MessageView";
import './stylesheet/MessageWindow.css'
import MessengerSendText from '../../../containers/smart/Messenger/MessengerSendText'
import { connect } from 'react-redux'
import MessageQuestion from './MessageQuestion'

//This class is holds all the UI for the messenger section
class MessageWindow extends Component {

    render(){
        return (
            // If the activeConvo is available, then the messenger view will display messages
            // in the active conversation.
            this.props.activeConvo !== '' ?
                <div id="message-window">
                    <MessageQuestion/>
                    <MessageView/>
                    <MessengerSendText/>
                </div> :
                <div>
                
                </div>
        )
    }
}

const mapStateToProps = ({messengerInfo}) => {
    return {
        activeConvo: messengerInfo.activeConvo
    }
}

export default connect(mapStateToProps)(MessageWindow)
