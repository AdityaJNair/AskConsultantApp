import { connect } from 'react-redux'
import CreateConversationButton from "../../../components/messenger/LeftTab/CreateConversationButton";

const mapStateToProps = ({loginInfo}) => {
    return{
        userid: loginInfo.userid
    }
}

const CreateConvoSmart = connect(mapStateToProps)(CreateConversationButton)
export default CreateConvoSmart