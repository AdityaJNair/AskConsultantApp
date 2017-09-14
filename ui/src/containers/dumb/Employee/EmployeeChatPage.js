import React, { Component } from 'react';
import './EmployeeChatPage.css';
import HorizontalNavBar from "../../../components/horizontalNavigation/HorizontalNavBar";
import MessengerLeftColumn from "../../../components/messenger/LeftTab/MessengerLeftColumn";
import MessageWindow from "../../../components/messenger/MessengerBox/MessageWindow";

class EmployeeChatPage extends Component {
    render() {
        return (
            <div id="whole-page" class="canvas">
                <HorizontalNavBar/>
                <div id="content">
                    <MessengerLeftColumn/>
                    <MessageWindow/>
                </div>
            </div>

        );
    }
}

export default EmployeeChatPage;