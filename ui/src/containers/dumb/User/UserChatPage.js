import React, { Component } from 'react';
import './UserChatPage.css';
import HorizontalNavBar from "../../../components/horizontalNavigation/HorizontalNavBar";
import MessengerLeftColumn from "../../../components/messenger/LeftTab/MessengerLeftColumn";
import MessageWindow from "../../../components/messenger/MessengerBox/MessageWindow";

class UserChat extends Component{
    componentDidMount () {
        console.log("Userchat windows did mount")
    }
    render() {
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
