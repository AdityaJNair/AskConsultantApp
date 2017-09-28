import React, { Component } from 'react';
import Button from 'react-md/lib/Buttons/Button';
import TextField from 'react-md/lib/TextFields';
import './stylesheet/MessengerTextComponent.css'

//const uri = 'wss://45.76.113.175:8443/askconsultant/interactive/users/test@test.com/conversations/2/chat'
let ws, messageInput

class MessengerTextComponent extends Component {
    openSocket(userid, conversationid, receiveMessage) {
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
            console.log('receive:' + response)
            let message = {
                message: response.message
            }
            receiveMessage(message)
        };
        ws.onerror = function() {
            console.log('error');
        };
    }

    closeSocket() {
        console.log('closing');
        ws.close();
    }

    sendText(userid, conversationid) {
        console.log("Click");
        let message = messageInput.value;
        let jsonString = { "message": message, "userid": userid,  "conversationid": conversationid};
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
        const receiveMessage = this.props.receiveMessage
        const userid = this.props.userid
        const conversationid = this.props.conversationid
        console.log(`conversationid: ${conversationid}`)
        //TODO: where to get the conersation_id
        this.openSocket(userid, conversationid, receiveMessage)
        console.log("MesengerTextComponent: render" + this.props.conversationid)
        return (
            <div id="messenger_text_area">
                <div id="textFieldEnter">
                    <TextField
                        ref={node => {messageInput = node}}
                        id="helpMultiline"
                        placeholder="Type a message..."
                        rows={1}
                        maxRows={7}
                        fullwidth={false}
                        className="md-cell md-cell--top"
                    />
                </div>
                <div id="buttonsend" onClick={this.sendText.bind(this, userid, conversationid)} >
                    <Button Button icon secondary >send</Button>
                </div>
            </div>
        )
    }
}

export default MessengerTextComponent;