import EmployeeLoginPage from '../../dumb/Employee/EmployeeLoginPage'
import { connect } from 'react-redux'
import {fetchPosts} from "../../../actions/loginActions";

const mapStateToProps = ({loginInfo}) => {
    return {
        logged: loginInfo.token !== '',
        errorMsg: loginInfo.errorMsg
    }
}

const EmpLoginPage = connect(mapStateToProps)(EmployeeLoginPage)
export default EmpLoginPage