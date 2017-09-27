const initialState = {
    order : '',
    activeConvo: JSON.stringify("{}"),
    conversations: JSON.stringify("{}")

}

const messengerReducer = (state = initialState, action) => {
    switch (action.type) {
        case 'UPDATE_CONVERSATIONS':
            return Object.assign({}, state, {
                conversations: action.conversations
            })

        default:
            return state
    }
}

export default messengerReducer;