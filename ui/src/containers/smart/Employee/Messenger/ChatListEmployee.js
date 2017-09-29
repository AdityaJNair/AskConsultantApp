import { connect } from 'react-redux'
import ChatListEmployees from "../../../../components/messenger/LeftTab/ChatListEmployees";

const mapStateToProps = ({loginInfo, messengerInfo}) => {
    return {
        userID: loginInfo.userid,
        conversations: messengerInfo.conversations
    }
}

const ChatListEmployeeSmart = connect(mapStateToProps)(ChatListEmployees)

export default ChatListEmployeeSmart
