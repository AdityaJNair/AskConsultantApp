import React, { Component } from 'react';
import logo from '../images/logo.svg';
import './UserChatPage.css';
import { withRouter } from 'react-router-dom'
import ChatItem from "../component/ChatItem";
import CreateConversationButton from "../component/CreateConversationButton";
import ChatList from "../component/ChatList";
import MessengerLeftColumn from "../component/MessengerLeftColumn";
import MessengerView from "../component/MessengerView";
import SearchFilter from "../component/SearchFilter";
import MessengerTextComponent from "../component/MessengerTextComponent";
import HorizontalNavBar from "../component/HorizontalNavBar";

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
