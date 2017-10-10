// After receice a single message
export const receiveMessage = (response) => {
    console.log('receive message action')
    console.log(response)
    let message = {
        message: response.message,
        user: response.user,
        sentat: response.sentat,
        sentbyuserid: response.sentbyuserid
    }
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

 export const initMessageFromServer = (userid, conversationid) => {
    return dispatch => {
        console.log('START requesting messages')
        const url = `https://45.76.113.175:8443/askconsultant/rest/users/${userid}/conversation/${conversationid}/messages`
        console.log(url)
        return fetch(url, {
            method: "GET",
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then(
                response => {
                    console.log(response)
                    return response.json()
                },
                error => {
                    console.log('An error occured when fetching the messages of conversationid.' + conversationid, error)
                }
            )
            .then(
                json => {
                    if (json === undefined) {
                        console.log('Empty json when fetching messages')
                    }
                    else {
                        dispatch(initMessages(json))
                    }
                }
            )
    }
 }