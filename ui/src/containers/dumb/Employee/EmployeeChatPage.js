import React, { Component } from 'react';
import './EmployeeChatPage.css';
import HorizontalNavBar from "../../../components/horizontalNavigation/HorizontalNavBar";
import MessengerLeftColumn from "../../../components/messenger/LeftTab/MessengerLeftColumn";
import MessageWindow from "../../../components/messenger/MessengerBox/MessageWindow";
import EmployeeTopicColumnSmart from "../../smart/Employee/Messenger/EmployeeTopicColumnSmart"
import EmployeeMessengerLeft from "../../../components/messenger/LeftTab/EmployeeMessengerLeft";


class EmployeeChatPage extends Component {
    render() {
        return (
            <div id="whole-page" class="canvas">
                <HorizontalNavBar/>
                <div id="content">
                    <EmployeeTopicColumnSmart/>
                    <EmployeeMessengerLeft/>
                    <div id="employee-message-window">
                        <MessageWindow/>
                    </div>
                </div>
            </div>

        );
    }
}

export default EmployeeChatPage;
