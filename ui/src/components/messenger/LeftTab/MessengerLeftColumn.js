import React, { Component } from 'react';
import SearchFilter from "./SearchFilter";
import ChatList from "./ChatList";
import CreateConvoSmart from "../../../containers/smart/User/CreateConvoSmart"

class MessengerLeftColumn extends Component {
    render(){
        return (
            <div id="messenger-left-column">
                <SearchFilter/>
                <ChatList/>
                <CreateConvoSmart/>
            </div>
        )
    }
}

export default MessengerLeftColumn;