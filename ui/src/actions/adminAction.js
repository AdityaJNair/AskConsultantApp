const successfulRegistration = () => {
    return {
        type: 'SUCCESSFUL_REGISTRATION',
        registrationStatus: true
    }
}
const failedRegistration = (error) => {
    return {
        type: 'BAD_REGISTRATION',
        registrationStatus: false,
        registrationErrorMsg: error
    }
}

const resetErrorMsg = () => {
    return {
        type: 'RESET_ERROR_MSG',
        registrationErrorMsg: ''
    }
}

const resetSuccessfullCreation = () => {
  return {
    type: 'RESET',
  }
}


export const postRegDetails = (name,
  email,
  password,
  role,
  primaryTopic,
  primarySubTopic) => {

  return dispatch => {
    const url = "https://45.76.113.175:8443/askconsultant/rest/admin/employee"
    const regDetails = {
      name,
      email,
      password,
      role,
      primaryTopic,
      primarySubTopic,
    }

    return fetch(url, {
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(regDetails)
    })
    .then(
        response => {
          console.log(response);
          return response
        },
        error => {
            console.log('An error occured.', error)
            dispatch(failedRegistration("Server Error"))
        }
    )
    .then(
        response => {
            console.log(response)
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
