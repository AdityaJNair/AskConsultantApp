const initialState = {
    status: '',
    pending: false,
    registrationStatus: false,
    registrationErrorMsg: ''
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
            })
            break;
        case 'RESET_ERROR_MSG':
            console.log('rest error msg')
            return Object.assign({}, state, {
                registrationErrorMsg: action.registrationErrorMsg
            })
            break;
        default:
            return state
    }
}

export default registrationReducer