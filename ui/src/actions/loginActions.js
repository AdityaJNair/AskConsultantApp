// Use the login reducer to test.
export const login = (userid, password, isEmployee) => {
    return {
        type: 'USER_LOGIN',
        status: 'test',
        token: '',
        pending: false
    }
}

const requestPosts =  () => {
    return {
        type: 'REQUEST_POST',
        pending: true
    }
}

const receivePosts = (json) => {
    return {
        type: 'RECEIVE_POST',
        pending: false,
        status: 'ok',
        token: json.token,
        userid: json.userid,
        firstName: json.firstName,
        lastName: json.lastName
    }
}

const badPosts = () => {
    return {
        type: 'BAD_POST',
        pending: false,
        status: 'bad',
    }
}

export const fetchPosts = (userid, password, isEmployee) => {
    return dispatch => {
        dispatch(requestPosts())
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
                    dispatch(badPosts())
                }
            )
            .then(
                json => {
                    if (json === undefined ) {
                        dispatch(badPosts())
                    }
                    else if (json.error !== undefined) {
                        dispatch(badPosts())
                    }
                    else {
                        dispatch(receivePosts(json))
                    }
                }
            )
    }
}