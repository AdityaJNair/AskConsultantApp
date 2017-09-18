import Login from '../../dumb/User/LoginPage'
import { connect } from 'react-redux'
import {fetchPosts} from "../../../actions/loginActions";

const mapStateToProps = ({loginInfo}) => {
    return {
        logged: loginInfo.token !== ''
    }
}

const LoginPage = connect(mapStateToProps)(Login)
export default LoginPage