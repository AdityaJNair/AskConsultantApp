import React, { Component } from 'react';
import MessageTextBubble from "./MessageTextBubble";
import ProfileImageBox from "./ProfileImageBox";
import Paper from 'react-md/lib/Papers';
import "./stylesheet/MessageBubbleContainer.css"
import {initMessages} from "../../../../actions/messengerAction";
import { connect } from 'react-redux'




class MessageBubbleContainer extends Component {

    messageInfo1 = {
        tooltipLabel: "1:00 pm",
        tooltipPosition: "right",
        message: "Text Message1"
    }
    messageInfo2 = {
        tooltipLabel: "2:00 pm",
        tooltipPosition: "right",
        message: "Text Message2"
    }
    messageInfo3 = {
        tooltipLabel: "3:00 pm",
        tooltipPosition: "right",
        message: "Text Message3"
    }
    messages = [this.messageInfo1, this.messageInfo2, this.messageInfo3]
    componentWillMount () {
        this._loadMessages()
    }
    _loadMessages() {
        //TODO Fetch message history from the server using conversation_id
        let messages = this.messages
        this.props.initMessage(messages)
        console.log('loadMessages')
    }

    render(){
        const bubbles =
            this.props.messages.map( messageInfo => (
                <div>
                    <ProfileImageBox/>
                    <MessageTextBubble {...messageInfo}/>
                </div>
                )
            )
        return (
            <div>
                {bubbles}
            </div>
        )


    }
}

const mapStateToProps = ({messengerInfo}) => {
    return {
        messages: messengerInfo.messages
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        initMessage: (messages) => {
            dispatch(initMessages(messages))
        }
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(MessageBubbleContainer)