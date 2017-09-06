import React, { PropTypes } from 'react';
import TextField from 'react-md/lib/TextFields';
import Paper from 'react-md/lib/Papers';
import "./stylesheet/MessageTextBubble.css"
import Divider from 'react-md/lib/Dividers/Divider'
import injectTooltip from 'react-md/lib/Tooltips'


// class MessageTextBubble extends Component {
//     render(){
//         return (
//             <div id="message_text_bubble">
//                 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec finibus, sapien ut faucibus facilisis, dolor lorem vestibulum nisi, vel accumsan elit dolor at lacus. Sed et gravida nisi. Pellentesque egestas luctus lectus. Pellentesque egestas hendrerit magna, et eleifend nulla pellentesque in. Nullam a odio iaculis tortor tempus tempus ut eget ligula. Phasellus diam purus, dignissim nec commodo eu, fringilla eget orci. Etiam nec fermentum dui, vitae dapibus purus. Quisque facilisis felis tempor elit dapibus efficitur. In interdum ac massa ac molestie. Donec at felis massa
//                 <Divider/>
//                 7:00 pm
//
//             </div>
//         )
//     }
// }

const MessageTextBubble = injectTooltip(({ children, className, tooltip, ...props}) => (
    <div
        {...props}
        className="message-text-bubble"
    >
        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec finibus, sapien ut faucibus facilisis, dolor lorem vestibulum nisi, vel accumsan elit dolor at lacus. Sed et gravida nisi. Pellentesque egestas luctus lectus. Pellentesque egestas hendrerit magna, et eleifend nulla pellentesque in. Nullam a odio iaculis tortor tempus tempus ut eget ligula. Phasellus diam purus, dignissim nec commodo eu, fringilla eget orci. Etiam nec fermentum dui, vitae dapibus purus. Quisque facilisis felis tempor elit dapibus efficitur. In interdum ac massa ac molestie. Donec at felis massa
        {tooltip}
        {children}
    </div>
));

MessageTextBubble.propTypes = {
    tooltip: PropTypes.node,
    className: PropTypes.string,
    children: PropTypes.node,
}

export default MessageTextBubble;