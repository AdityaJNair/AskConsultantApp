import { connect } from 'react-redux'
import MessengerTextComponent from "../../../components/messenger/MessengerBox/MessengerTextComponent";
import {receiveMessage} from "../../../actions/messengerAction";

const mapStateToProps = ({loginInfo, messengerInfo}) => {
    return {
        userid: loginInfo.userid,
        sentbydisplayname: loginInfo.preferredname,
        conversationid: messengerInfo.activeConvo
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        receiveMessage: (message) => {
            dispatch(receiveMessage(message))
        }
    }
}

const MessengerSendText = connect(mapStateToProps, mapDispatchToProps)(MessengerTextComponent)

export default MessengerSendText