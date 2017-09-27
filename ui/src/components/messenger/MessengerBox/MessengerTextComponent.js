import React, { Component } from 'react';
import Button from 'react-md/lib/Buttons/Button';
import TextField from 'react-md/lib/TextFields';
import Paper from 'react-md/lib/Papers';
import './stylesheet/MessengerTextComponent.css'

//const uri = 'wss://45.76.113.175:8443/askconsultant/interactive/users/test@test.com/conversations/2/chat'
let ws, messageInput

class MessengerTextComponent extends Component {
    openSocket(userid, receiveMessage) {
        const uri = `wss://45.76.113.175:8443/askconsultant/interactive/users/${userid}/conversations/2/chat`
        console.log(uri)
        ws = new WebSocket(uri);
        ws.onopen = function() {
            console.log('open');
        };
        ws.onclose = function() {
            console.log('close');
        };
        ws.onmessage = function(e) {
            let resp = JSON.parse(e.data);
            console.log(resp)
            let msg = resp.message
            // dispatch()
            //　TODO add the message from the user self on the messageView
            console.log('received: ' + msg);
            let message = {
                tooltipLabel: "3:00 pm",
                tooltipPosition: "right",
                message: msg
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

    sendText() {
        console.log("Click");
        let message = messageInput.value;
        let jsonString = { "message": message, "userid":"test@test.com", "conversationid":"3"};
        let myJSON = JSON.stringify(jsonString);
        console.log('sending: ' + myJSON);
        ws.send(myJSON);
    }

    componentDidMount () {
        console.log("Text did mount")
        const receiveMessage = this.props.receiveMessage
        const userid = this.props.userid
        //const conversation_id = this.props
        //TODO: where to get the conersation_id
        this.openSocket(userid, receiveMessage)

    }
    componentWillUnmount () {
        this.closeSocket()
    }
    render(){
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
                <div id="buttonsend" onClick={this.sendText.bind(this)} >
                    <Button Button icon secondary >send</Button>
                </div>
            </div>
        )
    }
}

export default MessengerTextComponent;