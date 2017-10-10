import React from 'react';
import "./stylesheet/MessageTextBubble.css"
import injectTooltip from 'react-md/lib/Tooltips'

// message argument is displayed message, tooltip is used for message sent time. 
const MessageTextBubble = injectTooltip(({message, tooltip}) => (
    <div className="message-text-bubble">
        {message}
        {tooltip}
    </div>));



export default MessageTextBubble;