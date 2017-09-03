import React, { Component } from 'react';
import ChatItem from "./ChatItem";
import Style from "./stylesheet/ChatList.css"

class ChatList extends Component {
    render(){
        return (
            <div id="chat-list">
                <ChatItem/>
            </div>
        )
    }
}

export default ChatList;