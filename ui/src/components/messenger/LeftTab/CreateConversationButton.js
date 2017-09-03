import React, { Component } from 'react';
import Style from "./stylesheet/CreateConversationButton.css"
import Button from 'react-md/lib/Buttons/Button';
import Divider from 'react-md/lib/Dividers/Divider'

class CreateConversationButton extends Component {
    render() {
        return (
            <div id="conversation-button-container">
                <Divider/>
                <Button className="button" id="create-conversation-button" raised secondary iconBefore={false} label="Create Conversation">add</Button>
            </div>
        );
    }
}

export default  CreateConversationButton;

