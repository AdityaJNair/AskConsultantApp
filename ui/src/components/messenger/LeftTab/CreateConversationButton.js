import React, { Component } from 'react';
import Style from "./stylesheet/CreateConversationButton.css"
import Button from 'react-md/lib/Buttons/Button';
import Divider from 'react-md/lib/Dividers/Divider'
import DialogContainer from 'react-md/lib/Dialogs'
import List from 'react-md/lib/Lists/List';
import ListItem from 'react-md/lib/Lists/ListItem';
import TextField from 'react-md/lib/TextFields';
import SelectField from 'react-md/lib/SelectFields';
import {postConvoDetails} from "../../../actions/CreateConvoAction"
import {consultantsTopics, development, strategyAndOperations, everydayDeloitte, humanCapital, technology} from "../../../containers/dumb/Admin/topics";

var MENU_ITEMS= ["Development", "Everyday Deloitte", "Human Capital", "Strategy & Operations", "Technology"];
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
            primarySubTopicList : [],
            primarySubTopicListDisabled:true,
            nameError:false,
            questionError : false,
            topicError : false,
            subTopicError : false,
            questionErrorMessage : "This field is required.",
            topicErrorMessage: "This field is required.",
            subTopicErrorMessage : "This field is required"
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


    verifyFields= (e) => {
        if(question.value.trim() !== "" && topic.value !== "" && subTopic.value !== "" ){
            var defaultString = message.value.trim();
            if(message.value.trim()==""){
                defaultString = "Hi. I have a question: " + question.value.trim();
            }
            postCon(e,this.props.dispatch, question.value.trim(), defaultString, topic.value, subTopic.value, this.props.userid);
            this.hide();

        } else{
            if(question.value.trim() === ""){
                this.setState({
                    questionTitleError :true,
                    questionErrorMessage: "This field is required."
                })
            } else {
                this.setState({
                    questionTitleError :false
                })
            }
            if(topic.value===""){
                this.setState({
                    topicError: true,
                    topicErrorMessage: "This field is required."
                })
            } else {
                this.setState({
                    topicError: false
                })
            }
            if(subTopic.value===""){
                this.setState({
                    subTopicError: true,
                    subTopicErrorMessage: "This field is required."
                })
            } else {
                this.setState({
                    subTopicError: false
                })
            }
        }

    }
    updatePrimaryList= (event, index, value) => {
        switch(event){
            case 'Development':
                this.setState({
                    primarySubTopicList : development,
                    primarySubTopicListDisabled : false,
                })
                break;
            case 'Everyday Deloitte':
                this.setState({
                    primarySubTopicList : everydayDeloitte,
                    primarySubTopicListDisabled : false,
                })
                break;
            case 'Human Capital':
                this.setState({
                    primarySubTopicList : humanCapital,
                    primarySubTopicListDisabled : false,
                })
                break;
            case 'Strategy & Operations':
                this.setState({
                    primarySubTopicList : strategyAndOperations,
                    primarySubTopicListDisabled : false,
                })
                break;
            case 'Technology':
                this.setState({
                    primarySubTopicList : technology,
                    primarySubTopicListDisabled : false,
                })
                break;
            default:
                this.setState({
                    primarySubTopicList : [],
                    primarySubTopicListDisabled : true
                })
        }
    }
    render() {
        const { visible } = this.state;
        const actions = [];
        actions.push({ secondary: true, children: 'Cancel', onClick: this.hide });
        actions.push(<Button flat primary
                             onClick={this.verifyFields.bind(this)}>Confirm</Button>);



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
                    <TextField ref={node => {question = node}}
                        id="simple-action-dialog-field"
                        label="Question"
                        placeholder="Type Question Here..."
                               errorText="This field is required."
                               error={this.state.questionError}
                               required
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
                                     errorText="This field is required."
                                     error={this.state.topicError}
                                     onChange={this.updatePrimaryList.bind(this)}
                                     required
                        />
                        <SelectField ref = {node => {subTopic = node}}
                            id="subtopic_field"
                            label="SubTopic"
                            placeholder="Choose a SubTopic.."
                            itemLabel="title"
                            menuItems={this.state.primarySubTopicList}
                            className="md-cell"
                                     error={this.state.subTopicError}
                                     disabled={this.state.primarySubTopicListDisabled}
                                     errorText="This field is required."
                                     required


                        />
                    </div>

                </DialogContainer>
            </div>
        );
    }
}

export default  CreateConversationButton;

