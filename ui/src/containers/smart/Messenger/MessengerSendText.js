import { connect } from 'react-redux'
import MessengerTextComponent from "../../../components/messenger/MessengerBox/MessengerTextComponent";
import {receiveMessage} from "../../../actions/messengerAction";

const mapStateToProps = ({loginInfo}) => {
    return {
        userid: loginInfo.userid
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