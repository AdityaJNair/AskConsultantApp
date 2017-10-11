//This action file is in charge of changing the states for user registration
const successfulRegistration = () => {
    return {
        type: 'SUCCESSFUL_REGISTRATION',
        registrationStatus: true
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

export const postRegDetails = (firstName,
                               lastName,
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
            "firstname" : firstName,
            "lastname" : lastName,
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
        dispatch(resetErrorMsg())
        return fetch(url, {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(regDetails)
        })
            .then(
                response => {
                    return response;
                },
                error => {
                    console.log('An error occured.', error)
                    dispatch(failedRegistration(error))
                }
            )
            .then(
                response => {
                    if (response.status == 201) {
                        dispatch(successfulRegistration())
                        return true;
                    }
                    else {
                        dispatch(failedRegistration("Error: please check that you have input all mandatory fields."))
                        return false;
                    }
                }
            )
    }


}