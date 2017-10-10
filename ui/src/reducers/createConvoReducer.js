const initialState = {
    status: '',
    pending: false,
    createConvoStatus: false,
    createConvoErrorMsg: ''
}

const createConvoReducer = (state = initialState, action) => {
    switch (action.type){
        case 'SUCCESSFUL_CONVO':
            console.log("SUCCESSFUL_CONVO")
            return Object.assign({}, state, {
                createConvoStatus: action.createConvoStatus,
                createConvoErrorMsg: action.createConvoErrorMsg

            })
            break;
        case 'BAD_CONVO':
            console.log("BAD_CONVO", action.createConvoErrorMsg)
            return Object.assign({}, state, {
                createConvoStatus: action.createConvoStatus,
                createConvoErrorMsg: action.createConvoErrorMsg
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

export default createConvoReducer