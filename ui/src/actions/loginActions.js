//This action file changes the states for logging in both users and employees
export const login = (userid, password, isEmployee) => {
    return {
        type: 'USER_LOGIN',
        status: 'test',
        token: '',
        pending: false
    }
}

// 'REQUEST_POST' is waiting for fetching POST method, and assign true to pending
const requestPosts =  () => {
    return {
        type: 'REQUEST_POST',
        pending: true
    }
}

// 'RECEIVE_POST' will be dispatched after POST method received successful response.
const receivePosts = (json) => {
    return {
        type: 'RECEIVE_POST',
        pending: false,
        status: 'ok',
        token: json.token,
        userid: json.userid,
        preferredname: json.preferredname
    }
}


// If the POST method returns error or rejected response, 'BAD_POST' will be dispatched.
const badPosts = (error) => {
    return {
        type: 'BAD_POST',
        pending: false,
        status: 'bad',
        errorMsg: error
    }
}

export const resetErrorMsg =()=>{
    return {
        type: 'RESET_ERROR_MSG',
        errorMsg: ''
    }
}

// The core action in the loginAction, this action will dispatch other dispatch funtion according
// to callback results of fetch function. 
export const fetchPosts = (userid, password, isEmployee) => {
    return dispatch => {
        dispatch(requestPosts())
        // The url address for the login API
        const url = "https://45.76.113.175:8443/askconsultant/rest/session"
        const user = {
            userid,
            password,
            isEmployee
        }
        return fetch(url, {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(user)
        })
            .then(
                response => {
                    return response.json()
                },
                error => {
                    console.log('An error occured.', error)
                    dispatch(badPosts("Server Error"))
                }
            )
            .then(
                json => {
                    if (json === undefined ) {
                        dispatch(badPosts("Server Error"))
                        return false;
                    }
                    else if (json.error !== undefined) {
                        dispatch(badPosts("Error: Your combination of email and password is invalid, please try again"))
                        return false;
                    }
                    else {
                        dispatch(receivePosts(json))
                        return true;
                    }
                }
            )
    }
}