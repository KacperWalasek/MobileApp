import { USER_LOGIN } from "../Reducers/UserReducer";

export default function setLoginData(loginResult){
    return {
        type: USER_LOGIN,
        payload: loginResult
    }
}