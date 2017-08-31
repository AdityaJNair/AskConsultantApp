import React, { Component } from 'react';
import Button from 'react-md/lib/Buttons/Button';
import TextField from 'react-md/lib/TextFields';
import Paper from 'react-md/lib/Papers';

class MessengerTextComponent extends Component {
    render(){
        return (
            <div id="messenger_text_area">
                <Paper
                    key={5}
                    zDepth={5}
                    raiseOnHover={5 === 0}
                    className="paper-example"
                >
                    <TextField
                        id="helpMultiline"
                        placeholder="Type a message..."
                        rows={1}
                        maxRows={7}
                        fullWidth={true}
                        className="md-cell md-cell--top"
                    />
                    <Button Button icon secondary>send</Button>
                </Paper>
            </div>
        )
    }
}

export default MessengerTextComponent;