import Register from "../../dumb/User/RegisterPage"
import { connect } from 'react-redux'
import {fetchPosts} from "../../../actions/loginActions";

const mapStateToProps = ({registrationInfo}) => {
    return {
        errorMsg: registrationInfo.registrationErrorMsg,
        regStatus: registrationInfo.registrationStatus
    }
}

const RegisterPage = connect(mapStateToProps)(Register)
export default RegisterPage