import consultantReg from '../../dumb/Admin/ConsultantAccountInformation'
import { connect } from 'react-redux'
import {fetchPosts} from "../../../actions/loginActions";

const consultantRegistration = connect()(consultantReg)
export default consultantRegistration
