import React, { Component } from 'react';
import logo from '../images/logo.svg';
import './UserChatPage.css';
import { withRouter } from 'react-router-dom'
import ChatItem from "../component/messenger/ChatItem";
import CreateConversationButton from "../component/messenger/CreateConversationButton";
import ChatList from "../component/messenger/ChatList";
import MessengerLeftColumn from "../component/messenger/MessengerLeftColumn";
import MessengerView from "../component/messenger/MessengerView";
import SearchFilter from "../component/messenger/SearchFilter";
import MessengerTextComponent from "../component/messenger/MessengerTextComponent";
import HorizontalNavBar from "../component/messenger/HorizontalNavBar";

class UserChat extends Component{
    render() {
        return (

            <div class="canvas">
                <ChatList/>
                <MessengerLeftColumn/>
                <MessengerView/>
                <SearchFilter/>
                <MessengerTextComponent/>
                <MessengerLeftColumn/>
                <HorizontalNavBar/>
                <CreateConversationButton/>
                <ChatItem/>
            </div>

        );
    }
}


export default UserChat;
