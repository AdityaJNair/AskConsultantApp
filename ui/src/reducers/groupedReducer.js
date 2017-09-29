import { combineReducers } from 'redux'
import registrationReducer from "./registrationReducer";
import loginReducer from "./loginReducer";
<<<<<<< HEAD
import  messengerReducer from "./messengerReducer";
=======
import messengerReducer from "./messengerReducer";
>>>>>>> master

const reducers = combineReducers({
    loginInfo: loginReducer,
    registrationInfo: registrationReducer,
    messengerInfo: messengerReducer

})

export default reducers
