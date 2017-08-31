import React, { Component } from 'react';
import Style from "./MessengerLeftColumn.css"
import Divider from 'react-md/lib/Dividers/Divider'
import CreateConversationButton from "./CreateConversationButton";
import SearchFilter from "./SearchFilter";
import ChatList from "./ChatList";

class MessengerLeftColumn extends Component {
    render(){
        return (
            <div id="messenger-left-column">
                <SearchFilter/>
                <Divider/>
                <ChatList/>
                <CreateConversationButton/>
            </div>
        )
    }
}

export default MessengerLeftColumn;