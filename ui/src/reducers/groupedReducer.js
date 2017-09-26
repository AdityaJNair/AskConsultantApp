import { combineReducers } from 'redux'
import registrationReducer from "./registrationReducer";
import loginReducer from "./loginReducer";
import  messengerReducer from "./messengerReducer";

const reducers = combineReducers({
    loginInfo: loginReducer,
    registrationInfo: registrationReducer,
    messengerInfo: messengerReducer

})

export default reducers
