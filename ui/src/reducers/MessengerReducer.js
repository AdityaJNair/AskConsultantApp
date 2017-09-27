const initialState = {
    messages: []
}

const messengerReducer = (state = initialState, action) => {
    switch (action.type) {
        case 'RECEIVE_MESSAGE':
            return Object.assign({}, state, {
                messages: [...state.messages, action.message]
            })
        case 'INIT_MESSAGE':
            return Object.assign({}, state, {
                messages: action.messages
            })
        default:
            return state
    }
}

export default messengerReducer