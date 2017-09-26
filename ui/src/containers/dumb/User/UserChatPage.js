import React, { Component } from 'react';
import './UserChatPage.css';
import HorizontalNavBar from "../../../components/horizontalNavigation/HorizontalNavBar";
import MessengerLeftColumn from "../../../components/messenger/LeftTab/MessengerLeftColumn";
import MessageViewSmart from "../../smart/User/Messenger/MessageView";
import MessageWindow from "../../../components/messenger/MessengerBox/MessageWindow";

class UserChat extends Component{
    render() {
        console.log("Userchat")
        return (
            <div id="whole-page" class="canvas">
                <HorizontalNavBar/>
                <div id="content">
                    <MessengerLeftColumn/>
                    <div id="user-message-window">
                        <MessageWindow/>
                    </div>
                </div>
            </div>
        );
    }
}

export default UserChat;
