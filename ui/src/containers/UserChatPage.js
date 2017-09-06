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
                <MessengerLeftColumn/>
                <MessageWindow/>
            </div>

        );
    }
}
/*
* <div class="canvas">

                <MessengerLeftColumn/>
                <MessageWindow/>
            </div>
* */

export default UserChat;
