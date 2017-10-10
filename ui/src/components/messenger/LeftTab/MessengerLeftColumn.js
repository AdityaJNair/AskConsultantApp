import React, { Component } from 'react';
import SearchFilter from "./SearchFilter";
import ChatList from "./ChatList";
import ChatListSmart from "../../../containers/smart/User/Messenger/ChatList";
import CreateConvoSmart from "../../../containers/smart/User/CreateConvoSmart"

class MessengerLeftColumn extends Component {
    render(){
        return (
            <div id="messenger-left-column">
                <ChatListSmart/>
                <CreateConvoSmart/>
            </div>
        )
    }
}

export default MessengerLeftColumn;
