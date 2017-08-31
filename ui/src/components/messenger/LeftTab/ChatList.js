import React, { Component } from 'react';
import ChatItem from "./ChatItem";
import Style from "./ChatList.css"

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