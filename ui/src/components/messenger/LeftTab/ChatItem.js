import React, { Component } from 'react';
import './stylesheet/ChatItem.css'

import Avatar from 'react-md/lib/Avatars/Avatar'
import Chip from 'react-md/lib/Chips'
import ListItem from 'react-md/lib/Lists/ListItem'
import MenuButton from 'react-md/lib/Menus/MenuButton'
import {setActiveConversation, archiveConvo, refreshConversationsAfterArchive} from "../../../actions/leftTabActions";
import {initMessageFromServer} from "../../../actions/messengerAction";

let ws;
class ChatItem extends Component {

    openConversation = (userID, conversationid) => {
        console.log(`convo clicked: ${conversationid}`);
        this.props.dispatch(setActiveConversation(conversationid))
        this.props.dispatch(initMessageFromServer(userID, conversationid))

    }

    //only for employees
    archiveConversation = () =>{
        this.openSocket(this.props.userID, this.props.convoDetails[1].id);
        this.archiveAndSendCloseMsg(this.sendClosingMessage, [this.props.userID, this.props.convoDetails[1].id])

            // .then((archived) => {
            //     if(archived)
            //         this.props.dispatch(refreshConversationsAfterArchive());
            // })/

    }
    render(){

        let menuOptions = null
        if(this.props.isEmployee == true){
            menuOptions = <div id = "question_menu">
                <MenuButton
                    className="chat-item-menu"
                    icon
                    buttonChildren="more_vert"
                    tooltipLabel="Open some menu"
                >
                    <ListItem primaryText="Archive" onClick={() => {this.archiveConversation()}} />
                </MenuButton>
            </div>;
        }else{
            menuOptions = <span></span>
        }


        return (
            <div className="chat-item" onClick={() => {this.openConversation(this.props.userID, this.props.convoDetails[1].id)}}>
                <div id="chatItem_top">
                    <div id = "question_title">
                        <h1>{this.props.convoDetails[1].question}</h1>
                    </div>
                    {menuOptions}
                </div>


                <div id="chatItem_mid">
                    <div id = "question_content">
                        <p>{this.props.convoDetails[1].latestmessage}</p>
                    </div>
                    <div id = "latest_message_owner">
                        <p>{this.props.convoDetails[1].latestmessagesentby}</p>
                    </div>
                    <div id = "question_timestamp">
                        <p>{this.props.convoDetails[1].lastupdate}</p>
                    </div>
                </div>
                <div id="chatItem_bottom">
                    <div id = "question_hashtag">
                        <Chip className="chat-item-hashtags" label={"#"+this.props.convoDetails[1].category}  />
                        <Chip className="chat-item-hashtags" label={"#"+this.props.convoDetails[1].subcategory}  />

                    </div>
                </div>



            </div>
        )
    }

    //------ Below are WebSocket functions which are needed to send the final closing message when archiving ----------

    openSocket(userid, conversationid) {
        const uri = `wss://45.76.113.175:8443/askconsultant/interactive/users/${userid}/conversations/${conversationid}/chat`
        console.log(uri)
        ws = new WebSocket(uri);
        ws.onopen = function() {
            console.log('open');
        };
        ws.onclose = function() {
            console.log('close');
        };
        ws.onmessage = function(e) {
            let response = JSON.parse(e.data);
            console.log(response)
            // There shouldnt be any response
        };
        ws.onerror = function() {
            console.log('error');
        };

    }



    archiveAndSendCloseMsg = function (callback,args) {
        if (ws.readyState === 1) {
            console.log('hit............')
            //sends closing message
            callback.apply(this,args);

            //archives and removes conversation from list
            this.props.dispatch(archiveConvo(this.props.userID, this.props.convoDetails[1].id))
                .then((response) => {
                    if (response) {
                        this.props.updateConversations(true);

                        return true;
                        console.log('convo archived..')
                    }
                    else {
                        return false;
                    }
                })
            this.closeSocket();
            return true;

        } else {
            var that = this;
            console.log('waiting ............')
            setTimeout(()=> {
                return that.sendCloseMsg(callback,args);
            }, 100);
        }
    };

    closeSocket() {
        console.log('closing');
        if (ws !== undefined) {
            ws.close();
        }
    }

    sendClosingMessage(userid, conversationid) {
        console.log("Click");
        let jsonString = { "message": "This conversation has now been closed, all further messages " +
        "wont be read or saved. Please create a new" +
        " conversation if you have further enquires, Thanks!", "userid": userid,  "conversationid": conversationid};
        let myJSON = JSON.stringify(jsonString);
        console.log('sending: ' + myJSON);
        ws.send(myJSON);
    }
}
/*
<div id = "avatar">
    <a className="chat-avatar" href="#"><Avatar random>J</Avatar></a>
</div>
<div id = "question_title">
    <h1>Title</h1>
</div>
<div id = "question_menu">
    <MenuButton
        className="chat-item-menu"
        icon
        buttonChildren="more_vert"
        tooltipLabel="Open some menu"
    >
        <ListItem primaryText="Item One" />
        <ListItem primaryText="Item Two" />
        <ListItem primaryText="Item Three" />
        <ListItem primaryText="Item Four" />
    </MenuButton>
    </div>
    <div id = "question_content">
        <p>Question content</p>

        <div id = "question_timestamp">
            <p>8:15 04/09/2017</p>
        </div>
    </div>

    <div id = "question_hashtag">
    <Chip className="chat-item-hashtags" label="#hashtag" />
    </div>*/
export default ChatItem;
