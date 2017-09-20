import { combineReducers } from 'redux'
import registrationReducer from "./registrationReducer";
const initialState = {
    status: '',
    token: '',
    pending: false,
    userid: '',
    firstName: '',
    lastName: '',
}

const loginReducer = (state = initialState, action) => {
    switch (action.type) {
        case 'USER_LOGIN':
            return Object.assign({}, state, {
                status: action.status,
                token: action.token
            })
        case 'REQUEST_POST':
            return Object.assign({}, state, {
                pending: action.pending
            })
        case 'RECEIVE_POST':
            console.log("RECEIVE_POST")
            return Object.assign({}, state, {
                status: action.status,
                token: action.token,
                pending: false,
                userid: action.userid,
                firstName: action.firstName,
                lastName: action.lastName
            })
        case 'BAD_POST':
            console.log("BAD_POST")
            return Object.assign({}, state, {
                status: action.status,
                pending: false,
                errorMsg: action.errorMsg
            })
        case 'RESET_ERROR_MSG':
            console.log("RESET_ERROR_MSG")
            return Object.assign({}, state, {
                errorMsg: action.errorMsg
            })
        default:
            return state
    }
}


const reducers = combineReducers({
    loginInfo: loginReducer,
    registrationInfo: registrationReducer
})

export default reducers