import React, { Component } from 'react';
import Style from "./stylesheet/CreateConversationButton.css"
import Button from 'react-md/lib/Buttons/Button';
import Divider from 'react-md/lib/Dividers/Divider'
import DialogContainer from 'react-md/lib/Dialogs'
import List from 'react-md/lib/Lists/List';
import ListItem from 'react-md/lib/Lists/ListItem';
import TextField from 'react-md/lib/TextFields';
import SelectField from 'react-md/lib/SelectFields';

var MENU_ITEMS= ["Accounting", "Tax Evasion", "Poop"];


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
    change = (e,value) =>{
        console.log("TESTER");
    }

    render() {
        const { visible } = this.state;
        const actions = [];
        actions.push({ secondary: true, children: 'Cancel', onClick: this.hide });
        actions.push(<Button flat primary onClick={this.hide}>Confirm</Button>);

        return (
            <div id="conversation-button-container" class="conversationDialog">
                <Button id="create-conversation-button" raised onClick={this.show}>Create Conversation</Button>
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
                        rows={4}
                        placeholder="First Message..."
                    />
                    <div id="create-conversation-topics">
                        <SelectField
                            id="topic_field"
                            label="Topic"
                            placeholder="Choose a Topic.."
                            itemLabel="title"
                            menuItems={MENU_ITEMS}
                            className="md-cell"
                            required
                            value = {"TEST"}
                            onChange={(e, index, value) => {console.log(value);this.onChange(value)}}
                        />
                        <SelectField
                            id="subtopic_field"
                            label="SubTopic"
                            placeholder="Choose a SubTopic.."
                            itemLabel="title"
                            menuItems={MENU_ITEMS}
                            className="md-cell"
                            disabled

                        />
                    </div>

                </DialogContainer>
            </div>
        );
    }
}

export default  CreateConversationButton;

