import React, { Component } from 'react';
import ChatItem from "./ChatItem";
import Style from "./stylesheet/ChatList.css"

class ChatList extends Component {
    render(){
        return (
            <div id="chat-list">
                <ChatItem/>
                <ChatItem/>
            </div>
        )
        chatlistSize();
    }


}

function chatlistSize() {
    var h = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);
    document.getElementById("chat-list").style.height = h - 120 + "px";
}

export default ChatList;