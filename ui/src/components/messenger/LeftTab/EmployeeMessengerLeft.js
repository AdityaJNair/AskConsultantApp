import React, { Component } from 'react';
import SearchFilter from "./SearchFilter";
import ChatListEmployeeSmart from "../../../containers/smart/Employee/Messenger/ChatListEmployee";

class EmployeeMessengerLeft extends Component {
    render(){
        return (
            <div id="messenger-left-column">
                <SearchFilter/>
                <ChatListEmployeeSmart/>
            </div>
        )
    }
}

export default EmployeeMessengerLeft;