import React, { Component } from 'react';
import MessageTextBubble from "./MessageTextBubble";
import ProfileImageBox from "./ProfileImageBox";
import Paper from 'react-md/lib/Papers';
import "./stylesheet/MessageBubbleContainer.css"
import {initMessageFromServer, initMessages} from "../../../../actions/messengerAction";
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
    fakemessages = [this.messageInfo1, this.messageInfo2, this.messageInfo3]
    componentWillMount () {
        this._loadMessages(this.props.userid, this.props.conversationid)
    }
    _loadMessages(userid, conversationid) {
        //TODO Fetch message history from the server using conversationid
        //this.props.initMessages(this.fakemessages)
        this.props.initMessageFromServer(userid, conversationid)
        console.log('loadMessages')
    }

    render(){
        console.log("MessageBubbleContainer render  ")
        //this._loadMessages(this.props.userid, this.props.conversationid)
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

const mapStateToProps = ({loginInfo, messengerInfo}) => {
    return {
        userid: loginInfo.userid,
        messages: messengerInfo.messages,
        //TODO: fix the looping error!
        conversationid: messengerInfo.activeConvo
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        initMessageFromServer: (userid, conversationid) => {
            dispatch(initMessageFromServer(userid, conversationid))
        },
        initMessages: (messages) => {
            dispatch(initMessages(messages))
        }
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(MessageBubbleContainer)