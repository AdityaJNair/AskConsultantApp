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
                    className="paper-example">
                    <TextField
                        id="applicationDescription"
                        rows={2}
                        disabled={true}
                        defaultValue="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec finibus, sapien ut faucibus facilisis, dolor lorem vestibulum nisi, vel accumsan elit dolor at lacus. Sed et gravida nisi. Pellentesque egestas luctus lectus. Pellentesque egestas hendrerit magna, et eleifend nulla pellentesque in. Nullam a odio iaculis tortor tempus tempus ut eget ligula. Phasellus diam purus, dignissim nec commodo eu, fringilla eget orci. Etiam nec fermentum dui, vitae dapibus purus. Quisque facilisis felis tempor elit dapibus efficitur. In interdum ac massa ac molestie. Donec at felis massa"
                        className="md-cell md-cell--12"/>
                    <TextField id="timestamp" placeholder="7:00 pm" className="md-cell md-cell--bottom" disabled={true}/>
                </Paper>
            </div>
        )
    }
}

export default MessageTextBubble;