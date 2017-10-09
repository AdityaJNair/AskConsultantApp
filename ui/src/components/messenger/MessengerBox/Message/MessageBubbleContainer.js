import React, { Component } from 'react';
import MessageTextBubble from "./MessageTextBubble";
import MessageTextBubbleUser from "./MessageTextBubbleUser";
import ProfileImageBox from "./ProfileImageBox";
import ProfileImageBoxUser from "./ProfileImageBoxUser";
import "./stylesheet/MessageBubbleContainer.css"
import {initMessageFromServer} from "../../../../actions/messengerAction";
import { connect } from 'react-redux'
import {message} from "../../LeftTab/CreateConversationButton";




class MessageBubbleContainer extends Component {
    _loadMessages(userid, conversationid) {
        this.props.initMessageFromServer(userid, conversationid)
        console.log('loadMessages')
    }

    componentWillMount () {
        this._loadMessages(this.props.userid, this.props.conversationid)
    }

    render(){
        console.log("MessageBubbleContainer render  ")
        console.log(this.props.messages)
        const bubbles =
            this.props.messages.reverse().map( messageInfo => (
                this.props.userid !== messageInfo.sentbyuserid
                    ?
                        <div className="message_bubble_container">
                            <ProfileImageBox sentbydisplayname={messageInfo.user} />
                            <MessageTextBubble message={messageInfo.message}
                                               tooltipLabel={messageInfo.sentat}
                                               tooltipPosition="right"/>
                        </div>
                    :
                    <div className="message_bubble_container_user">
                        <ProfileImageBoxUser sentbydisplayname={messageInfo.user} />
                        <MessageTextBubbleUser message={messageInfo.message}
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