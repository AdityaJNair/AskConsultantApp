import React, { Component } from 'react';
import Style from "./stylesheet/CreateConversationButton.css"
import Button from 'react-md/lib/Buttons/Button';
import Divider from 'react-md/lib/Dividers/Divider'
import DialogContainer from 'react-md/lib/Dialogs'
import List from 'react-md/lib/Lists/List';
import ListItem from 'react-md/lib/Lists/ListItem';


class CreateConversationButton extends Component {
    state = { visible: false };

    show = () => {
        this.setState({ visible: true });
    };

    hide = () => {
        this.setState({ visible: false });
    };

    handleKeyDown = (e) => {
        const key = e.which || e.keyCode;
        if (key === 13 || key === 32) {
            // also close on enter or space keys
            this.hide();
        }
    };

    render() {
        const { visible } = this.state;

        return (
            <div id="conversation-button-container">
                <Button id="create-conversation-button" raised onClick={this.show}>Open the dialog</Button>
                <DialogContainer
                    id="simple-list-dialog"
                    visible={visible}
                    title="Simple List Dialog"
                    onHide={this.hide}
                >
                    <List onClick={this.hide} onKeyDown={this.handleKeyDown}>
                        <ListItem primaryText="Single line text goes here" />
                        <ListItem primaryText="Two line wrapped text goes here making it wrap to the next line" />
                        <ListItem primaryText="Single line text goes here" />
                        <ListItem primaryText="Three line wrapped text goes here making it wrap to the next line and continues longer to be here" />
                    </List>
                </DialogContainer>
            </div>
        );
    }
}

export default  CreateConversationButton;

