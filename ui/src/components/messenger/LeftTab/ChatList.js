import React, { Component } from 'react';
import ChatItem from "./ChatItem";
import Style from "./stylesheet/ChatList.css"
import {updateConversations} from "../../../actions/leftTabActions";
class ChatList extends Component {

    componentWillMount(){
        console.log("updating convos")
        setTimeout(this.refresh, 0);
    }
    refresh = () => {
        // make Ajax call here, inside the callback call:
        this.props.dispatch(updateConversations(this.props.userID))
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
                    <ChatItem convoDetails={item}/>
                ))}

            </div>
        )
    }


}


export default ChatList;
