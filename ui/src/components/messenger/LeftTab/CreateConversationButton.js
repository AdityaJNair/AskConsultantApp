import React, { Component } from 'react';
import Button from 'react-md/lib/Buttons/Button';
import Divider from 'react-md/lib/Dividers/Divider'
import DialogContainer from 'react-md/lib/Dialogs'
import List from 'react-md/lib/Lists/List';
import ListItem from 'react-md/lib/Lists/ListItem';
import TextField from 'react-md/lib/TextFields';
import SelectField from 'react-md/lib/SelectFields';
import {postConvoDetails} from "../../../actions/CreateConvoAction"

var MENU_ITEMS= ["Accounting", "Tax Evasion", "Poop"];
export let question, message, topic, subTopic;

const postCon = (e, dispatch, quest, mess, top, sub, userid) => {
    e.preventDefault();
    console.log(`in the convo create`)
    dispatch(postConvoDetails(quest,mess,top,sub,userid))
        .then((success) => {
            //uses status returned by action creator
            console.log(success + '')
            if(success)
                console.log("Successful");
        })
}


class CreateConversationButton extends Component {
    constructor () {
        super();
        this.state = {

        }
    }

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


    confirm= (e) => {
        if(question.value.trim() !== "" && topic.value !== "" && subTopic.value !== "" ){
            var testString = message.value.trim();
            if(message.value.trim()!==""){
                testString = "Hi. I have a question: " + question.value.trim();
            }
            console.log("USERID: ")
            console.log(this.props.userid);
            postCon(e,this.props.dispatch, question.value.trim(), message.value.trim(), topic.value, subTopic.value, this.props.userid);

        }
        console.log(question.value);

        if(true){

        }
        console.log(message.value);
        console.log(topic.value);
    }

    render() {
        const { visible } = this.state;
        const actions = [];
        actions.push({ secondary: true, children: 'Cancel', onClick: this.hide });
        actions.push(<Button flat primary
                             onClick={this.confirm.bind(this)}>Confirm</Button>);



        return (
            <div id="conversation-button-container" class="conversationDialog">
                <Button id="create-conversation-button" raised primary onClick={this.show}>Create Conversation</Button>
                <DialogContainer
                    id="simple-list-dialog"
                    visible={visible}
                    title="Create Conversation"
                    actions={actions}
                    onHide={this.hide}
                >
                    <TextField ref={node => {question = node}}
                        id="simple-action-dialog-field"
                        label="Question"
                        placeholder="Type Question Here..."
                    />
                    <TextField ref={node => {message = node}}
                        id="floating-multiline"
                        label="Optional Message"
                        rows={4}
                        placeholder="First Message..."
                    />
                    <div id="create-conversation-topics">
                        <SelectField ref={node => {topic = node}}
                            id="topic_field"
                            label="Topic"
                            placeholder="Choose a Topic.."
                            itemLabel="title"
                            menuItems={MENU_ITEMS}
                            className="md-cell"
                            required
                        />
                        <SelectField ref = {node => {subTopic = node}}
                            id="subtopic_field"
                            label="SubTopic"
                            placeholder="Choose a SubTopic.."
                            itemLabel="title"
                            menuItems={MENU_ITEMS}
                            className="md-cell"


                        />
                    </div>

                </DialogContainer>
            </div>
        );
    }
}

export default CreateConversationButton;
