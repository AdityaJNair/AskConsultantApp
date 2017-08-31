import React, { Component } from 'react';
import Button from 'react-md/lib/Buttons/Button';

class CreateConversationButton extends Component {
    render() {
        return (
            <div>
                <Button raised secondary iconBefore={false} label="Create Conversation">add</Button>
            </div>
        );
    }
}

export default  CreateConversationButton;

