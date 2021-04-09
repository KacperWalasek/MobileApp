import {handleError} from '../../API/ApiFunctions';
import {login} from './../../API/UserApi';
import setLoginData from './SetLoginData';

export default function createLoginAction(loginData){
    return function(dispatch){
        return login(loginData)
            .then(response =>{
                if (!response.ok) {
                    throw Error(response.status);
                }
                return response.json()
            })
            .then(loginResult =>{ console.log(loginResult); dispatch(setLoginData(loginResult))})
    }
}