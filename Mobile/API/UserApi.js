import {urls} from '../constants';
import { USER_LOGIN } from '../Store/Reducers/UserReducer';
import store from './../Store/index'
import setLoginData from '../Store/ActionCreators/SetLoginData';
import {authFetch} from './ApiFunctions';

export function login(loginData){
    const requestOptions = {
        method: 'POST',
        headers: {
            'Content-Type': "application/json"
        },
        body: JSON.stringify(loginData),
        redirect: 'follow'
    };

    return fetch(`${urls.userUrl}/login`, requestOptions)
        .catch(error => console.log('error', error));
}

export function refreshToken(){
    if(!store.getState().user.refreshToken)
        return 0;
    console.log('refreshToken');
    return fetch(`${urls.userUrl}/refreshToken/${store.getState().user.refreshToken}`,{method: 'GET'})
        .then(response=>{
            if(!response.ok)
                return 0;
            return response.json()
        })
        .then(result=>{
            if(result)
                store.dispatch(setLoginData(result))
            return result;
        })
        .catch(error=>handleError(error));
}

export function getMemberships(){
    userId = store.getState().user?.userId;
    if(!userId)
        return new Promise(()=>[]);
    return authFetch(`${urls.userUrl}/memberships/${userId}`, { method: 'GET' })
        .then(response=>{
            if(!response.ok)
                return [];
            return response.json();
        });
}

export function getOrganized(){
    userId = store.getState().user?.userId;
    if(!userId)
        return new Promise(()=>[]);
    return authFetch(`${urls.userUrl}/organize/${userId}`, { method: 'GET' })
        .then(response=>{
            if(!response.ok)
                return [];
            return response.json();
        });
}
export function getAllUsers(){
    return authFetch(`${urls.userUrl}`, { method: 'GET' })
        .then(response=>{
            if(!response.ok)
                return [];
            return response.json();
        });
}