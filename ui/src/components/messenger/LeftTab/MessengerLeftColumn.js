import React, { Component } from 'react';
import Divider from 'react-md/lib/Dividers/Divider'
import CreateConversationDialog from "./CreateConversationDialog";
import CreateConversationButton from "./CreateConversationButton";
import SearchFilter from "./SearchFilter";
import ChatList from "./ChatList";
import ChatListSmart from "../../../containers/smart/User/Messenger/ChatList";

class MessengerLeftColumn extends Component {
    render(){
        return (
            <div id="messenger-left-column">
                <SearchFilter/>
                <ChatListSmart/>
                <CreateConversationButton/>
            </div>
        )
    }
}

export default MessengerLeftColumn;