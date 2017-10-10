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

    // before component will mount, this page will load messsages.
    componentWillMount () {
        this._loadMessages(this.props.userid, this.props.conversationid)
    }

    render(){
        console.log("MessageBubbleContainer render  ")
        console.log(this.props.messages)
        // if the messenage is sent by the current user, it will return a div with className
        // called message_bubble_container_user. Otherwise, it will return a div with calsseName
        // called message_bubble_container. 
        const bubbles =
            // Due to the order of messages, before messages unload they should reverse first. 
            this.props.messages.slice().reverse().map( messageInfo => (
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
                                           tooltipPosition="left"/>
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