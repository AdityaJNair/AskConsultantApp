import { connect } from 'react-redux'
import EmployeeTopicColumn from "../../../../components/messenger/TopicColumn/EmployeeTopicColumn";

const mapStateToProps = ({loginInfo, messengerInfo}) => {
    return {
        userID: loginInfo.userid,
        conversationid: messengerInfo.activeConvo
    }
}

const EmployeeTopicColumnSmart = connect(mapStateToProps)(EmployeeTopicColumn)

export default EmployeeTopicColumnSmart
