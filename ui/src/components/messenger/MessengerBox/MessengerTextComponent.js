import React, { Component } from 'react';
import Button from 'react-md/lib/Buttons/Button';
import TextField from 'react-md/lib/TextFields';
import Paper from 'react-md/lib/Papers';
import './stylesheet/MessengerTextComponent.css'
class MessengerTextComponent extends Component {
    render(){
        return (
            <div id="messenger_text_area">
                <TextField
                    id="helpMultiline"
                    placeholder="Type a message..."
                    rows={1}
                    maxRows={7}
                    fullwidth={false}
                    className="md-cell md-cell--top"
                />
                <div id="buttonsend" >
                    <Button Button icon secondary>send</Button>
                </div>
            </div>
        )
    }
}

export default MessengerTextComponent;