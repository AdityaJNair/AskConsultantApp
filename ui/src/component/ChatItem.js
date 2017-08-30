import React, { Component } from 'react';

class ChatItem extends Component {
    render(){
        return (
            <div id="chat_item">
                <div>Question</div>
                <div>Hamburger</div>
                <div>Last Message</div>
                <div>Hashtag</div>
                <div>Last time message sent</div>
            </div>
        )
    }
}

export default ChatItem;