import React, { Component } from 'react';
import CreateConversationButton from "./CreateConversationButton";
import SearchFilter from "./SearchFilter";
import ChatList from "./ChatList";

class MessengerLeftColumn extends Component {
    render(){
        return (
            <div id="messenger_left_column">
                <SearchFilter/>
                <ChatList/>
                <CreateConversationButton/>
            </div>
        )
    }
}

export default MessengerLeftColumn;