const initialState = {
    status: '',
    pending: false,
    registrationStatus: false,
    registrationErrorMsg: '',
    successfulRegMsg: ''
}

const registrationReducer = (state = initialState, action) => {
    switch (action.type){
        case 'SUCCESSFUL_REGISTRATION':
            console.log("SUCCESSFUL_REGISTRATION")
            return Object.assign({}, state, {
                registrationStatus: action.registrationStatus,
                registrationErrorMsg: action.registrationErrorMsg

            })
            break;
        case 'BAD_REGISTRATION':

            console.log("BAD_REGISTRATION", action.registrationErrorMsg)
            return Object.assign({}, state, {
                registrationStatus: action.registrationStatus,
                registrationErrorMsg: action.registrationErrorMsg
            })
            break;
        case 'COMPLETE_REGISTRATION':
            console.log("COMPLETE_REGISTRATION")
            return Object.assign({}, state, {
                registrationStatus: action.registrationStatus,
                successfulRegMsg: action.successfulRegMsg
            })
            break;
        case 'RESET_ERROR_MSG':
            console.log('reset error msg')
            return Object.assign({}, state, {
                registrationErrorMsg: action.registrationErrorMsg
            })
            break;
        case 'RESET_SUCCESS_MSG':
            console.log('RESET_SUCCESS_MSG')
            return Object.assign({}, state, {
                successfulRegMsg: action.successfulRegMsg
            })
            break;
        default:
            return state
    }
}

export default registrationReducer