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

export const setActiveTopics =  (primaryTopic, secondaryTopic) => {
    return {
        type: 'SET_ACTIVE_TOPICS_EMPLOYEE',
        primaryTopic,
        secondaryTopic
    }
}

export const setActiveConversation = (id) =>{
    return {
        type: 'CHANGE_ACTIVE_CONVERSATION',
        convoID: id
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

export const updateEmployeeConversations = (employeeId, primaryTopic, secondaryTopic) => {
    return dispatch => {
        const url = "https://45.76.113.175:8443/askconsultant/rest/users/"+ employeeId +"/conversation"
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

                        var filteredJson = json.filter(function (row){
                            if(row.category === primaryTopic && row.subcategory === secondaryTopic){
                                return row;
                            } else {
                                return false;
                            }
                        })
                        dispatch(setConversations(filteredJson))
                        return true;
                    }
                }
            )
    }
}
