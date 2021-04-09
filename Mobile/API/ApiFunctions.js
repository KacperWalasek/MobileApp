import store from '../Store';
import {refreshToken} from '../API/UserApi';

export function handleError(error){
    console.log("error: ", error, Object.keys(error), error.toString());
    if(error.status=='403')
        console.log('token');
}

export function authFetch(url, options){
    if(!store.getState().user.validationToken)
        return new Promise((resolve, reject) => {
            resolve(0);
          });
    const headers = options.headers? new Headers(options.headers) : new Headers();
    headers.append('Authorization', store.getState().user.validationToken);
    options = {...options, headers: headers};
    return fetch(url, options)
        .then(response=>{
            if(response.status==403) 
                return refreshToken()
                    .then(result=>{
                        console.log(result)
                        if(result){
                            options.headers.set('Authorization', result.token);
                            return fetch(url, options);
                        }
                        return response;
                    });
            return response;
        })
        .catch(error=>handleError(error));
}