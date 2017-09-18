import React, { Component } from 'react';
import Divider from 'react-md/lib/Dividers/Divider'
import CreateConversationDialog from "./CreateConversationDialog";
import SearchFilter from "./SearchFilter";
import ChatList from "./ChatList";

class MessengerLeftColumn extends Component {
    render(){
        return (
            <div id="messenger-left-column">
                <SearchFilter/>
                <ChatList/>
                <CreateConversationDialog/>
            </div>
        )
    }
}

export default MessengerLeftColumn;