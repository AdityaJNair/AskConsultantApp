import React, { Component } from 'react';
import MessageTextBubble from "./MessageTextBubble";
import ProfileImageBox from "./ProfileImageBox";
import "./stylesheet/MessageBubbleContainer.css"
import {initMessageFromServer} from "../../../../actions/messengerAction";
import { connect } from 'react-redux'




class MessageBubbleContainer extends Component {

    _loadMessages(userid, conversationid) {
        this.props.initMessageFromServer(userid, conversationid)
        console.log('loadMessages')
    }

    // componentWillMount () {
    //     this._loadMessages(this.props.userid, this.props.conversationid)
    // }

    render(){
        console.log("MessageBubbleContainer render  ")
        const bubbles =
            this.props.messages.map( messageInfo => (
                <div>
                    <ProfileImageBox/>
                    <MessageTextBubble message={messageInfo.message}
                                       tooltipLabel={messageInfo.sentat}
                                       tooltipPosition="right"/>
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
        conversationid: messengerInfo.activeConvo
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        initMessageFromServer: (userid, conversationid) => {
            dispatch(initMessageFromServer(userid, conversationid))
        }
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(MessageBubbleContainer)