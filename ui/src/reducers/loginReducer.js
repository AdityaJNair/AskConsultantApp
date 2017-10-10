const initialState = {
    status: '',
    token: '',
    pending: false,
    userid: '',
    preferredname: ''

}

const loginReducer = (state = initialState, action) => {
    switch (action.type) {
        case 'USER_LOGIN':
            return Object.assign({}, state, {
                status: action.status,
                token: action.token,
                preferredname: action.preferredname
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
                preferredname: action.preferredname
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
        case 'USER_LOGOUT':
            console.log("USER_LOGOUT")
            return Object.assign({}, state, {
                token: action.token
            })
        default:
            return state
    }
}

export default loginReducer
