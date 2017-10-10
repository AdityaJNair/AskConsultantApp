const successfulConversation = () => {
    return{
        type: 'SUCCESSFUL_CONVERSATION',
        conversationStatus: true
    }
}


const resetErrorMsg = () => {
    return {
        type: 'RESET_ERROR_MSG',
        registrationErrorMsg: ''
    }
}

const failedRegistration = (error) => {
    return {
        type: 'BAD_REGISTRATION',
        registrationStatus: false,
        registrationErrorMsg: error
    }
}

export const completedRegistration = () => {
    return {
        type: 'COMPLETE_REGISTRATION',
        registrationStatus: false,
        registrationErrorMsg: '',
        successfulRegMsg: 'You have successfully registered!'
    }
}

export const resetSuccessMsg = () => {
    return {
        type: 'RESET_SUCCESS_MSG',
        successfulRegMsg: ''
    }
}

export const postConvoDetails = (question,
                                 firstmessage,
                                 topic,
                                 subtopic,


                                 userid) => {
    return dispatch => {
        const url = "https://45.76.113.175:8443/askconsultant/rest/users/"+userid+"/conversation";
        console.log(url);

        const convoDetails = {
            question : question,
            firstmessage : firstmessage,
            topic : topic,
            subtopic : subtopic
        }
        console.log(convoDetails)
        dispatch(resetErrorMsg())
        return fetch(url, {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(convoDetails)
        })
            .then(
                response => {
                    console.log(response.status)
                    return response;
                },
                error => {
                    console.log('An error occured.', error)
                    dispatch(failedRegistration(error))
                }
            )
            .then(
                response => {
                    console.log(response)
                    if (response.status === 201) {
                        dispatch(successfulConversation())
                        return response.json();
                    }
                    else {
                        dispatch(failedRegistration("Error: please check that you have input all mandatory fields."))
                        return '';
                    }
                }
            )
    }
}