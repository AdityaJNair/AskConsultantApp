import { connect } from 'react-redux'
import ChatList from "../../../../components/messenger/LeftTab/ChatList";

const mapStateToProps = ({loginInfo}) => {
    return {
        userID: loginInfo.userid
    }
}

const ChatListSmart = connect(mapStateToProps)(ChatList)

export default ChatListSmart