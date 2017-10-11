import React, { Component } from 'react';
import ChatItem from "./ChatItem";
import Style from "./stylesheet/ChatList.css"
import {updateEmployeeConversations, refreshConversationsAfterArchive} from "../../../actions/leftTabActions";

//This component holds the chat list for employees
class ChatListEmployee extends Component {

    componentWillMount(){
        setTimeout(this.refresh, 0);
    }

    //The chat list refreshes every 5 seconds to check for new conversations
    refresh = () => {
        // make Ajax call here, inside the callback call:
        this.updateConversationList(false);
        setTimeout(this.refresh, 5000);
    }

    //The conversation list should archive and remove the chat from the list when a chat has been archived
    //However archiving is optional in this method and is mainly used for updating the conversation list
    updateConversationList =(archiving)=>{
        var secondaryTopic = "";
        if(typeof(this.props.secondaryTopic)==="string"){
            secondaryTopic = this.props.secondaryTopic;
        } else{
            secondaryTopic = this.props.secondaryTopic.item;
        }
        this.props.dispatch(updateEmployeeConversations(this.props.userID,this.props.primaryTopic,secondaryTopic))
            .then((success) => {
                //uses status returned by action creator
                if(success){
                    if(archiving)
                        this.archiveConvo();
                } else {
                    console.log("FAILED TO ARCHIVE");
                }
            })
    }

    archiveConvo = () =>{
        this.props.dispatch(refreshConversationsAfterArchive());
    }

    render(){
        return (
            <div id="chat-list-employee" style = {{}}>
                {Object.entries(this.props.conversations).map((item) =>(
                    <ChatItem {...this.props} convoDetails={item} userID={this.props.userID} isEmployee={true}
                              updateConversations={() =>{this.updateConversationList(true)}}
                              archiveConvo={() =>{this.archiveConvo()}}/>
                ))}

            </div>
        )
    }
}
export default ChatListEmployee;
