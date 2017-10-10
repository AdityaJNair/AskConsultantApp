import React, { Component } from 'react';
import MessageView from "./MessageView";
import './stylesheet/MessageWindow.css'
import MessengerSendText from '../../../containers/smart/Messenger/MessengerSendText'
import { connect } from 'react-redux'


class MessageWindow extends Component {
    componentWillMount () {
        console.log("Message windows did mount")

    }
    render(){
        console.log(`Render And Get the activeConvo: ${this.props.activeConvo}`)
        return (
            // If the activeConve is available, then the messenger view will display messages
            // in the active conversation. 
            this.props.activeConvo !== '' ?
                <div id="user-message-window">
                    <MessageView/>
                    <MessengerSendText/>
                </div> :
                <div>
                    Hello World!
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
