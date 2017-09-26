import { combineReducers } from 'redux'
import registrationReducer from "./registrationReducer";
import loginReducer from "./loginReducer";

const reducers = combineReducers({
    loginInfo: loginReducer,
    registrationInfo: registrationReducer
})

export default reducers
