const initialState = {
    order : '',
    activeConvo: '',
    conversations: JSON.stringify("{}"),
    messages: [],
    primaryTopic: 'Development',
    secondaryTopic: 'Oracle practice'

}

const messengerReducer = (state = initialState, action) => {
    switch (action.type) {
        case 'UPDATE_CONVERSATIONS':
            if(state.activeConvo !== '' || action.conversations.length === 0){
                return Object.assign({}, state, {
                    conversations: action.conversations
                });}
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
        case 'SET_ACTIVE_TOPICS_EMPLOYEE':
            return Object.assign({}, state, {
                primaryTopic: action.primaryTopic,
                secondaryTopic: action.secondaryTopic
            })
        default:
            return state
    }
}

export default messengerReducer;
