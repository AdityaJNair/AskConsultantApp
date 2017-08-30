import React, { Component } from 'react';

class MessengerTextComponent extends Component {
    render(){
        return (
            <div id="messenger_text_area">
                <div>Write message here</div>
                <button>Send message</button>
            </div>
        )
    }
}

export default MessengerTextComponent;