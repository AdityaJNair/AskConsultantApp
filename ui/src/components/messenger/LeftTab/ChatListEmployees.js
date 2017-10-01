import React, { Component } from 'react';
import ChatItem from "./ChatItem";
import Style from "./stylesheet/ChatList.css"
import {updateEmployeeConversations, setActiveConversation} from "../../../actions/leftTabActions";


class ChatListEmployee extends Component {

    componentWillMount(){
        console.log("updating convos")
        setTimeout(this.refresh, 0);
    }
    refresh = () => {
        // make Ajax call here, inside the callback call:
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
                    console.log("SUCCESS");
                } else {
                    console.log("FAILED");
                }
            })
        setTimeout(this.refresh, 5000);
        // ...
    }


    render(){
        return (
            <div id="chat-list" style = {{}}>
                {Object.entries(this.props.conversations).map((item) =>(
                    <ChatItem {...this.props} convoDetails={item} userID={this.props.userID}/>
                ))}

            </div>
        )
    }


}


export default ChatListEmployee;
