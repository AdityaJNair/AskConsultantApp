import { connect } from 'react-redux'
import ChatList from "../../../../components/messenger/LeftTab/ChatList";

const mapStateToProps = ({loginInfo, messengerInfo}) => {
    return {
        userID: loginInfo.userid,
        conversations: messengerInfo.conversations
    }
}

const ChatListSmart = connect(mapStateToProps)(ChatList)

export default ChatListSmart
