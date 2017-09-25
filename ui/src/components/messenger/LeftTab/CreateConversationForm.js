import React, { PureComponent } from 'react';
import CreateConversationButton from './CreateConversationButton'
import Button from 'react-md/lib/Buttons/Button'
import TextField from 'react-md/lib/TextFields/TextField'
import Dialog from 'react-md/lib/Dialogs/Dialog'
import './stylesheet/CreateConversationDialog.css'

class CreateConversationForm extends PureComponent {
    constructor(props) {
        super(props);
        this.state = { visible: false };
    }

    openDialog = () => {
        this.setState({ visible: true });
    };

    closeDialog = () => {
        this.setState({ visible: false });
    };

    render(){
        const { visible } = this.state;

        return (
            <div id="create-conversation-dialog">
                <CreateConversationButton onClick={this.openDialog} />
                <Dialog
                    id="createConversationDialog"
                    visible={visible}
                    title="Create Conversation"
                    onHide={this.closeDialog}
                >
                    <form>
                        <TextField
                            id="conversationTitle"
                            placeholder="Title"
                            block
                            paddedBlock
                        />
                        <TextField
                            id="conversationMessage"
                            placeholder="Message"
                            block
                            paddedBlock
                        />
                    </form>
                    <Button raised label="Save" onClick={this.closeDialog} />
                </Dialog>
            </div>
            )
        }
    }
export default CreateConversationForm;