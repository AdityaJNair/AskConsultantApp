import Login from '../../dumb/User/LoginPage'
import { connect } from 'react-redux'
import {fetchPosts} from "../../../actions/loginActions";

const mapDispatchToProps = (dispatch) => {
    return {
        handleSumbit: () => {
            dispatch(fetchPosts(userid, password, false))
        }
    }
}