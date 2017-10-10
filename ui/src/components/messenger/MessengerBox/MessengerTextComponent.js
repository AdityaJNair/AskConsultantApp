import React, { Component } from 'react';
import './stylesheet/MessengerTextComponent.css'
import MessengerInput from "./MessengerInput";

//const uri = 'wss://45.76.113.175:8443/askconsultant/interactive/users/test@test.com/conversations/2/chat'
let ws

class MessengerTextComponent extends Component {

    openSocket(userid, conversationid, receiveMessage) {
        // The websocket address for current user to when enter a conversation. 
        const uri = `wss://45.76.113.175:8443/askconsultant/interactive/users/${userid}/conversations/${conversationid}/chat`
        console.log(uri)
        ws = new WebSocket(uri);
        ws.onopen = function() {
            console.log('open');
        };
        ws.onclose = function() {
            console.log('close');
        };
        // After receive a new message, the new message will add to the messages array. 
        ws.onmessage = function(e) {
            console.log("Looking! here")
            let response = JSON.parse(e.data);
            response.user = response.sentbydisplayname
            console.log(response)
            // let message = {
            //     message: response.message
            // }
            receiveMessage(response)
        };
        ws.onerror = function() {
            console.log('error');
        };
    }

    closeSocket() {
        console.log('closing');
        if (ws !== undefined) {
            ws.close();
        }
    }

    sendText(userid, conversationid, message, sentbydisplayname) {
        console.log("Click");
        let jsonString = {
                            "message": message,
                            "userid": userid,
                            "conversationid": conversationid,
                        }
        let myJSON = JSON.stringify(jsonString);
        console.log('sending: ' + myJSON);
        ws.send(myJSON);
    }

    componentDidMount () {
        console.log("MesengerTextComponent: Did")
    }
    componentWillUnmount () {
        this.closeSocket()
    }
    render(){
        console.log("text render.")
        this.closeSocket()
        this.openSocket(this.props.userid, this.props.conversationid, this.props.receiveMessage)
        return (
            <MessengerInput sendText={this.sendText} {...this.props}/>
        )
    }
}

export default MessengerTextComponent;