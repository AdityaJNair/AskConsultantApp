import React, { Component } from 'react';
import MessageTextBubble from "./MessageTextBubble";
import ProfileImageBox from "./ProfileImageBox";
import Paper from 'react-md/lib/Papers';


class MessageBubbleContainer extends Component {
    render(){
        return (
            <div id="message_bubble_container">
                <Paper
                    key={5}
                    zDepth={5}
                    raiseOnHover={5 === 0}
                    className="paper-example"
                >
                    <MessageTextBubble/>
                    <ProfileImageBox/>
                </Paper>


            </div>
        )
    }
}

export default MessageBubbleContainer;