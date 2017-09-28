import React, { Component } from 'react';
import SearchFilter from "./SearchFilter";
import ChatListSmart from "../../../containers/smart/User/Messenger/ChatList";

class EmployeeMessengerLeft extends Component {
    render(){
        return (
            <div id="messenger-left-column">
                <SearchFilter/>
                <ChatListSmart/>
            </div>
        )
    }
}

export default EmployeeMessengerLeft;
