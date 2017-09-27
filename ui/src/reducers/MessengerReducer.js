const initialState = {
    order : '',
    activeConvo: '',
    conversations: JSON.stringify("{}"),
    messages: []
}

const messengerReducer = (state = initialState, action) => {
    switch (action.type) {
        case 'UPDATE_CONVERSATIONS':
            if(state.activeConvo !== '')
                return Object.assign({}, state, {
                    conversations: action.conversations
                })
            else
                return Object.assign({}, state, {
                    conversations: action.conversations,
                    activeConvo: action.conversations[0].id
                })
            break;
        case 'CHANGE_ACTIVE_CONVERSATION':
            return Object.assign({}, state, {
                activeConvo: action.convoID
            })
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

export default messengerReducer;
