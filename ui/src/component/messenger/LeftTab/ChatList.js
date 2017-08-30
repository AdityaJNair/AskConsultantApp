import React, { Component } from 'react';
import ChatItem from "./ChatItem";

class ChatList extends Component {
    render(){
        return (
            <div id="chat_list">
                <ChatItem/>
            </div>
        )
    }
}

export default ChatList;