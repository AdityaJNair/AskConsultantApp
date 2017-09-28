const initialState = {
    status: '',
}

const consultantRegistration = (state = initialState, action) => {
  switch(action.type){

    case 'SUCCESSFUL_REGISTRATION':
      return ()
      break;

    case 'BAD_REGISTRATION':
      return ()
      break;

    case 'RESET_ERROR_MSG':
      return ()
      break;

      case 'RESET':
      return ()
      break;

    default:
      return state
  }
}

export default consultantRegistration
