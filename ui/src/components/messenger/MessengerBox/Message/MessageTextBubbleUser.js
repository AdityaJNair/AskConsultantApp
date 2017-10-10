import React from 'react';
import "./stylesheet/MessageTextBubble.css"
import injectTooltip from 'react-md/lib/Tooltips'


const MessageTextBubbleUser = injectTooltip(({message, tooltip}) => (
    <div className="message-text-bubble-user">
        {message}
        {tooltip}
    </div>));



export default MessageTextBubbleUser;