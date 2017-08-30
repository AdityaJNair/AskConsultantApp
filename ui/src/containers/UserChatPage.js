import React, { Component } from 'react';
import logo from '../images/logo.svg';
import './UserChatPage.css';
import { withRouter } from 'react-router-dom'
import ChatItem from "../components/messenger/ChatItem";
import CreateConversationButton from "../components/messenger/CreateConversationButton";
import ChatList from "../components/messenger/ChatList";
import MessengerLeftColumn from "../components/messenger/MessengerLeftColumn";
import MessengerView from "../components/messenger/MessengerView";
import SearchFilter from "../components/messenger/SearchFilter";
import MessengerTextComponent from "../components/messenger/MessengerTextComponent";
import HorizontalNavBar from "../components/messenger/HorizontalNavBar";

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
