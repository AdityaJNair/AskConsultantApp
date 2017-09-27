import { connect } from 'react-redux'
import UserChat from "../../dumb/User/UserChatPage";

const mapStateToProps = ({loginInfo}) => {
    return {
        userID: loginInfo.userid
    }
}

const UserChatPage = connect(mapStateToProps)(UserChat)

export default UserChatPage