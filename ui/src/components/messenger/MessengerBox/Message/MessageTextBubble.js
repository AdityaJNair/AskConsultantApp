import React, { Component } from 'react';
import TextField from 'react-md/lib/TextFields';
import Paper from 'react-md/lib/Papers';


class MessageTextBubble extends Component {
    render(){
        return (
            <div id="message_text_bubble">
                <Paper
                    key={5}
                    zDepth={5}
                    raiseOnHover={5 === 0}
                    className="paper-example"
                >
                    <TextField
                        id="helpMultiline"
                        placeholder="Filler message"
                        rows={0}
                        disabled={true}
                        helpText="timestamp"
                        className="md-cell md-cell--top"
                    >Filler Text
                    </TextField>
                </Paper>
            </div>
        )
    }
}

export default MessageTextBubble;