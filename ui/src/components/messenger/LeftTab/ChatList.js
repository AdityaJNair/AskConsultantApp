import React, { Component } from 'react';
import ChatItem from "./ChatItem";
import Style from "./stylesheet/ChatList.css"

class ChatList extends Component {
    render(){
        return (
            <div id="chat-list" style = {{}}>
                <ChatItem/>
                <ChatItem/><ChatItem/>
                <ChatItem/><ChatItem/>
                <ChatItem/><ChatItem/>
                <ChatItem/>
            </div>
        )
    }


}


export default ChatList;