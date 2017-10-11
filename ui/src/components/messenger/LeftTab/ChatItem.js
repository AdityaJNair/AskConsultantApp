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

    openConversation = () => {
        this.props.dispatch(setActiveConversation(this.props.convoDetails[1].id, this.props.convoDetails[1].question))
        this.props.dispatch(initMessageFromServer(this.props.userID, this.props.convoDetails[1].id))

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
        let title = null
        if(this.props.isEmployee == true){
            menuOptions = <div id = "question-menu">
                <MenuButton
                    className="chat-item-menu"
                    icon
                    buttonChildren="more_vert"
                    tooltipLabel="Open some menu"
                >
                    <ListItem primaryText="Archive" onClick={() => {this.archiveConversation()}} />
                </MenuButton>
            </div>;
            title = <div id = "employee-question-title">
                <h1>{this.props.convoDetails[1].question}</h1>
            </div>;
        }else{
            menuOptions = <span></span>;
            title = <div id = "user-question-title">
                <h1>{this.props.convoDetails[1].question}</h1>
            </div>
        }


        return (
            <div className="chat-item" onClick={() => {this.openConversation()}}>
                <div id="chatItem_top">
                    {title}
                    {menuOptions}
                </div>


                <div id="chatItem_mid">
                    <div id="latest-message">
                        <div id = "latest-message-owner">
                            <text id="owner-text">{this.props.convoDetails[1].latestmessagesentby}:</text>
                        </div>
                        <div id = "latest-message-content">
                            <p>{this.props.convoDetails[1].latestmessage}</p>
                        </div>
                    </div>
                    <div id="question-info">
                        <div id = "question_timestamp">
                            <p>{this.props.convoDetails[1].latestmessagesentat}</p>
                        </div>
                    </div>
                </div>
                <div id="chatItem-bottom">
                    <div id = "question-hashtag">
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
                return that.archiveAndSendCloseMsg(callback,args);
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
