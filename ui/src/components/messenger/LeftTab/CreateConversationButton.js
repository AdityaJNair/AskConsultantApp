import React, { Component } from 'react';
import Style from "./stylesheet/CreateConversationButton.css"
import Button from 'react-md/lib/Buttons/Button';
import Divider from 'react-md/lib/Dividers/Divider'
import DialogContainer from 'react-md/lib/Dialogs'
import List from 'react-md/lib/Lists/List';
import ListItem from 'react-md/lib/Lists/ListItem';
import TextField from 'react-md/lib/TextFields';
import SelectField from 'react-md/lib/SelectFields';

const MENU_ITEMS= ["Accounting", "Tax Evasion", "Poop"];
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
        const actions = [];
        actions.push({ secondary: true, children: 'Cancel', onClick: this.hide });
        actions.push(<Button flat primary onClick={this.hide}>Confirm</Button>);

        return (
            <div id="conversation-button-container" class="conversationDialog">
                <Button id="create-conversation-button" raised onClick={this.show}>Open the dialog</Button>
                <DialogContainer
                    id="simple-list-dialog"
                    visible={visible}
                    title="Create Conversation"
                    actions={actions}
                    onHide={this.hide}
                >
                    <TextField
                        id="simple-action-dialog-field"
                        label="Question"
                        placeholder="Type Question Here..."
                    />
                    <TextField
                        id="floating-multiline"
                        label="Details"
                        lineDirection="right"
                        rows={4}
                        placeholder="First Message..."
                        className="md-cell md-cell--bottom"
                    />
                    <SelectField
                        id="topic_field"
                        label="Topic"
                        placeholder="Choose a Topic.."
                        itemLabel="title"
                        menuItems={MENU_ITEMS}
                        className="md-cell"
                    />

                </DialogContainer>
            </div>
        );
    }
}

export default  CreateConversationButton;

