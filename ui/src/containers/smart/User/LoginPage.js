import Login from '../../dumb/User/LoginPage'
import { connect } from 'react-redux'
import {fetchPosts} from "../../../actions/loginActions";

const mapStateToProps = ({loginInfo, registrationInfo}) => {
    return {
        logged: loginInfo.token !== '',
        errorMsg: loginInfo.errorMsg,
        successfulRegMsg: registrationInfo.successfulRegMsg
    }
}

const LoginPage = connect(mapStateToProps)(Login)
export default LoginPage