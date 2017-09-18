import React, { Component } from 'react';
import './EmployeeChatPage.css';
import HorizontalNavBar from "../../../components/horizontalNavigation/HorizontalNavBar";
import MessengerLeftColumn from "../../../components/messenger/LeftTab/MessengerLeftColumn";
import MessageWindow from "../../../components/messenger/MessengerBox/MessageWindow";
import EmployeeTopicColumn from "../../../components/messenger/TopicColumn/EmployeeTopicColumn"


class EmployeeChatPage extends Component {
    render() {
        return (
            <div id="whole-page" class="canvas">
                <HorizontalNavBar/>
                <div id="content">
                    <EmployeeTopicColumn/>
                    <MessengerLeftColumn/>
                    <MessageWindow/>
                </div>
            </div>

        );
    }
}

export default EmployeeChatPage;