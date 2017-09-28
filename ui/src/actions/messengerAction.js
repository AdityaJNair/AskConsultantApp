export const receiveMessage = (message) => {
    return {
        type: 'RECEIVE_MESSAGE',
        message: message
    }
}

export const initMessages = (messages) => {
    return {
        type: 'INIT_MESSAGE',
        messages: messages
    }
}

