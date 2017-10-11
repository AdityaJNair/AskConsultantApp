import React, { Component } from 'react';
import SearchFilter from "./SearchFilter";
import ChatListEmployeeSmart from "../../../containers/smart/Employee/Messenger/ChatListEmployee";

//Holds the chat list for employees
class EmployeeMessengerLeft extends Component {
    render(){
        return (
            <div id="messenger-left-column">
                <ChatListEmployeeSmart/>
            </div>
        )
    }
}

export default EmployeeMessengerLeft;
