import { connect } from 'react-redux'
import MessengerTextComponent from "../../../components/messenger/MessengerBox/MessengerTextComponent";

const mapStateToProps = ({messengerInfo}) => {
    return {
        conversation_id: messengerInfo.conversation_id
    }
}

const MessengerSendText = connect(mapStateToProps)(MessengerTextComponent)

export default MessengerSendText