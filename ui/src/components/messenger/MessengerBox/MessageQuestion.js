import React, { Component } from 'react';
import MessageBubbleContainer from "./Message/MessageBubbleContainer";
import './stylesheet/MessageWindow.css'
import { connect } from 'react-redux'

//UI for the question title on the messenger, it depends on the chat
class MessageQuestion extends Component {
    render(){
        return (
            <div id="message-question">
                <h2>{this.props.question}</h2>
            </div>
        )
    }
}

const mapStateToProps = ({messengerInfo}) => {
    return {
        question : messengerInfo.activeQuestion,
    }
}

export default connect(mapStateToProps)(MessageQuestion)

