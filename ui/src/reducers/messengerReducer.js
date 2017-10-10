const initialState = {
    order : '',
    activeConvo: '',
    conversations: JSON.stringify("{}"),
    messages: [],
    primaryTopic: 'Development',
    secondaryTopic: 'Oracle practice',
    activeQuestion: ''

}

const messengerReducer = (state = initialState, action) => {
    switch (action.type) {
        case 'UPDATE_CONVERSATIONS':
            if(state.activeConvo!='' || action.conversations.length===0){
                return Object.assign({},state,{
                    conversations:action.conversations
                });
            }
            else
                return Object.assign({}, state, {
                    conversations: action.conversations,
                    activeConvo: action.conversations[0].id,
                    activeQuestion: action.conversations[0].question
                })
            break;
        case 'CHANGE_ACTIVE_CONVERSATION':
            return Object.assign({}, state, {
                activeConvo: action.convoID,
                activeQuestion: action.question
            })
        case 'ARCHIVED_CONVERSATION':
            return Object.assign({}, state, {
                activeConvo: "",
                activeQuestion: "",
                messages: []
            })
        case 'RECEIVE_MESSAGE':
            return Object.assign({}, state, {
                messages: [ action.message, ...state.messages]
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
        case 'SET_DEFAULT_CONVERSATIONS':
            if(action.conversations.length===0){
                return Object.assign({},state,{
                    conversations:action.conversations,
                    activeConvo:''
                });
            }
            else
            {
                return Object.assign({}, state, {
                    conversations: action.conversations,
                    activeConvo: action.conversations[0].id,
                    activeQuestion: action.conversations[0].question
                });
            }
            break;
        default:
            return state;
    }
}

export default messengerReducer;
