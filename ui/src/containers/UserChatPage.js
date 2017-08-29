import React, { Component } from 'react';
import logo from '../images/logo.svg';
import './UserChatPage.css';
import { withRouter } from 'react-router-dom'

class UserChat extends Component{
    render() {
        return (

            <div class="canvas">
                <CreateConversationButton />
            </div>

        );
    }
}

class CreateConversationButton extends Component {
    render() {
        return (
            <button>Create Conversation</button>
        );
    }
}

export default UserChat;
