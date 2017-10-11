// Use the login reducer to test.
export const login = (userid, password, isEmployee) => {
    return {
        type: 'USER_LOGIN',
        status: 'test',
        token: '',
        pending: false
    }
}

const setConversations =  (json) => {
    return {
        type: 'UPDATE_CONVERSATIONS',
        conversations: json
    }
}

const setDefaultConversations = (json) =>{
    return {
        type: 'SET_DEFAULT_CONVERSATIONS',
        conversations: json
    }
}

export const refreshConversationsAfterArchive = () => {
    return {
        type: 'ARCHIVED_CONVERSATION'
    }
}


export const setActiveTopics =  (primaryTopic, secondaryTopic) => {
    return {
        type: 'SET_ACTIVE_TOPICS_EMPLOYEE',
        primaryTopic,
        secondaryTopic
    }
}

export const setActiveConversation = (id, question) =>{
    return {
        type: 'CHANGE_ACTIVE_CONVERSATION',
        convoID: id,
        question
    }
}

export const setEmployeePrefTopics = (userid) => {

    return dispatch => {
        const url = "https://45.76.113.175:8443/askconsultant/rest/employees/"+userid+"/categories";

        return fetch(url, {
            method: "GET",
            headers:{
                'Content-type': 'application/json'
            }
        })
            .then(
                response => {
                    return response.json();
                },
                error =>{
                    console.log('An error occured.', error)
                    console.log("serverError?")
                }
            )
            .then(
                json => {
                    if(json === undefined){
                        console.log("serverError?");
                        return false;
                    }
                    else if (json.error !== undefined) {
                        console.log(json.error)
                        return false;
                    }
                    else {
                        console.log("THIS IS RESPONSE");
                        console.log(userid);
                        console.log(json.primaryTopic);
                        console.log(json.primarySubtopic);
                        dispatch(setActiveTopics(json.primaryTopic,json.primarySubtopic))
                        dispatch(updateEmployeeConversations(userid,json.primaryTopic,json.primarySubtopic))
                        return true;
                    }
                }
            )

    }
}

export const archiveConvo = (userID, conversationID) =>{
    return dispatch => {

        const url = "https://45.76.113.175:8443/askconsultant/rest/employees/"+ userID +"/conversation/" +conversationID;

        return fetch(url, {
            method: "DELETE",
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then(
                response => {
                    return response
                },
                error => {
                    console.log('An error occured.', error)
                    console.log("serverError?")
                }
            )
            .then(
                response => {
                    if (response.json === undefined ) {
                        console.log("serverError?")
                        return false;
                    }
                    else if (response.json.error !== undefined) {
                        console.log(response.json.error)
                        return false;
                    }
                    else {
                        return true;
                    }
                }
            )
    }
}

export const updateConversations = (userid) => {
    return dispatch => {
        const url = "https://45.76.113.175:8443/askconsultant/rest/users/"+ userid +"/conversation"

        return fetch(url, {
            method: "GET",
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then(
                response => {
                    return response.json()
                },
                error => {
                    console.log('An error occured.', error)
                    console.log("serverError?")
                }
            )
            .then(
                json => {
                    if (json === undefined ) {
                        console.log("serverError?")
                        return false;
                    }
                    else if (json.error !== undefined) {
                        console.log(json.error)
                        return false;
                    }
                    else {
                        dispatch(setConversations(json))
                        return true;
                    }
                }
            )
    }
}

export const updateEmployeeConversations = (employeeId, primaryTopic, secondaryTopic, isDefaultConversation=false) => {
    return dispatch => {
        var url;
        if(primaryTopic=='All')
            url = "https://45.76.113.175:8443/askconsultant/rest/employees/"+ employeeId +"/conversation/topics?all=true"
        else
            url = "https://45.76.113.175:8443/askconsultant/rest/employees/"+ employeeId +"/conversation/topics?topic="
                + primaryTopic+"&subtopic="+secondaryTopic;

        if(primaryTopic !== '' && secondaryTopic !== '')
            dispatch(setActiveTopics(primaryTopic, secondaryTopic))
        //const url = ""
        return fetch(url, {
            method: "GET",
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then(
                response => {
                    return response.json()
                },
                error => {
                    console.log('An error occured.', error)
                    console.log("serverError?")
                }
            )
            .then(
                json => {
                    if (json === undefined ) {
                        console.log("serverError?")
                        return false;
                    }
                    else if (json.error !== undefined) {
                        console.log(json.error)
                        return false;
                    }
                    else {
                        console.log("the json file")

                        if(isDefaultConversation)
                            dispatch(setDefaultConversations(json))
                        else
                            dispatch(setConversations(json))
                        return true;
                    }
                }
            )
    }
}
