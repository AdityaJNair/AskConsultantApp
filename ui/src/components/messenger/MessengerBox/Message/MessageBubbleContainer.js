import React, { Component } from 'react';
import MessageTextBubble from "./MessageTextBubble";
import ProfileImageBox from "./ProfileImageBox";
import Paper from 'react-md/lib/Papers';
import "./stylesheet/MessageBubbleContainer.css"



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
    render(){
        const bubbles =
            this.messages.map( messageInfo => (
                <div>
                    {console.log(messageInfo)}
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

export default MessageBubbleContainer;