import React, { Component } from 'react';
import './UserChatPage.css';
import HorizontalNavBar from "../../../components/horizontalNavigation/HorizontalNavBar";
import MessengerLeftColumn from "../../../components/messenger/LeftTab/MessengerLeftColumn";
import MessageViewSmart from "../../smart/Messenger/MessageView";

class UserChat extends Component{
    render() {
        console.log("Userchat")
        return (
            <div id="whole-page" class="canvas">
                <HorizontalNavBar/>
                <div id="content">
                    <MessengerLeftColumn/>
                    <div id="user-message-window">
                        <MessageViewSmart/>
                    </div>
                </div>
            </div>
        );
    }
}

export default UserChat;
