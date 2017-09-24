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
  primarySubTopic,
  secondaryTopic,
  secondarySubTopic) => {
  return dispatch => {
    const url = "FILLER"

    const regDetails = {
      name,
      email,
      password,
      role,
      primaryTopic,
      primarySubTopic,
      secondaryTopic,
      secondarySubTopic
    }

    console.log(regDetails)
    dispatch(resetErrorMsg())

    /**
    Do stuff here
    */

  }
}
