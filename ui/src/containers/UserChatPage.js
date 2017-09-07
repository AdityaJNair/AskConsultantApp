import React, { Component } from 'react';
import './UserChatPage.css';
import HorizontalNavBar from "../components/horizontalNavigation/HorizontalNavBar";
import MessengerLeftColumn from "../components/messenger/LeftTab/MessengerLeftColumn";
import MessageWindow from "../components/messenger/MessengerBox/MessageWindow";

class UserChat extends Component{
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

export default UserChat;
