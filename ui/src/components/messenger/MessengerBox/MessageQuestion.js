import React, { Component } from 'react';
import MessageBubbleContainer from "./Message/MessageBubbleContainer";
import './stylesheet/MessageWindow.css'
import { connect } from 'react-redux'


class MessageQuestion extends Component {
    render(){
        return (
            <div id="message-quetion">
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

