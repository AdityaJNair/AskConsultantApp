const successfulRegistration = () => {
    return {
        type: 'SUCCESSFUL_REGISTRATION',
        registrationStatus: true,
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


export const postRegDetails = (fullName,
                               userName,
                               dob,
                               email,
                               gender,
                               password,
                               occupation,
                               industry,
                               interest,
                               source) => {
    return dispatch => {
        const url = "https://45.76.113.175:8443/askconsultant/rest/user"
        const regDetails = {
            "firstname" : fullName,
            "lastname" : fullName,
            "preferedname" : userName,
            dob,
            email,
            gender,
            password,
            occupation,
            industry,
            interest,
            source


        }
        console.log(regDetails)
        return fetch(url, {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(regDetails)
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
                    if (response.status == 201) {
                        dispatch(successfulRegistration())
                    }
                    else {
                        dispatch(failedRegistration("Your Registration failed, please check that you have input all mandatory fields."))
                    }
                }
            )
    }


}