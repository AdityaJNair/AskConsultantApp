import React, { Component } from 'react';
import MessageView from "./MessageView";
import './stylesheet/MessageWindow.css'
import MessengerSendText from '../../../containers/smart/Messenger/MessengerSendText'
import { connect } from 'react-redux'


class MessageWindow extends Component {
    componentWillMount () {
        console.log("Message windows did mount")

    }
    render(){
        // return (
        //     <div>
        //         <MessageView/>
        //         <MessengerSendText/>
        //     </div>
        // )
        console.log(`Render And Get the activeConvo: ${this.props.activeConvo}`)
        return (
            this.props.activeConvo !== '' ?
                <div id="user-message-window">
                    <MessageView/>
                    <MessengerSendText/>
                </div> :
                <div>
                    Hello World!
                </div>
        )
    }
}

const mapStateToProps = ({messengerInfo}) => {
    return {
        activeConvo: messengerInfo.activeConvo
    }
}

// const mapDispatchToProps = (dispatch) => {
//     return {
//         initMessage: (messages) => {
//             dispatch(initMessages(messages))
//         }
//     }
// }

export default connect(mapStateToProps)(MessageWindow)
