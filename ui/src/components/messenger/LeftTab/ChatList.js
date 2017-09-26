import React, { Component } from 'react';
import ChatItem from "./ChatItem";
import Style from "./stylesheet/ChatList.css"
import {updateConversations} from "../../../actions/leftTabActions";
class ChatList extends Component {

    componentWillMount(){
        console.log("updating convos")
        this.props.dispatch(updateConversations(this.props.userID))
    }

    render(){
        return (
            <div id="chat-list" style = {{}}>
                {Object.entries(this.props.conversations).map((item) =>(
                    <ChatItem convoDetails={item}/>
                ))}

            </div>
        )
    }


}


export default ChatList;