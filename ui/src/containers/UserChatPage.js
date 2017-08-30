import React, { Component } from 'react';
import logo from '../images/logo.svg';
import './UserChatPage.css';
import { withRouter } from 'react-router-dom'
import ChatItem from "../component/messenger/LeftTab/ChatItem";
import CreateConversationButton from "../component/messenger/LeftTab/CreateConversationButton";
import ChatList from "../component/messenger/LeftTab/ChatList";
import MessengerLeftColumn from "../component/messenger/LeftTab/MessengerLeftColumn";
import MessengerView from "../component/messenger/MessengerBox/MessageView";
import SearchFilter from "../component/messenger/LeftTab/SearchFilter";
import MessengerTextComponent from "../component/messenger/MessengerBox/MessengerTextComponent";
import HorizontalNavBar from "../component/messenger/HorizontalNavBar";
import MessageWindow from "../component/messenger/MessengerBox/MessageWindow";

class UserChat extends Component{
    render() {
        return (
            <div class="canvas">
                <HorizontalNavBar/>
                <MessengerLeftColumn/>
                <MessageWindow/>
            </div>

        );
    }
}


export default UserChat;
