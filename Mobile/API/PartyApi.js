import {urls} from '../constants';
import store from './../Store/index'
import {handleError, authFetch} from './ApiFunctions';

export function getParties(){
    return authFetch(urls.partyUrl, {method: 'GET'})
        .then(response=>{
            if(!response.ok)
                return [];
            return response.json();
        });
}

export function addParty(party){
    delete party.id;
    party.ownerId = store.getState().user.userId;
    return authFetch(urls.partyUrl, {
        method: 'POST', 
        headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(party), 
    });
}
export function getMembers(partyId){
    return authFetch(`${urls.memberUrl}/${partyId}`, { method: 'GET' })
        .then(response=>{
            if(!response.ok)
                return [];
            return response.json();
        });
}
export function postMembers(members){
    console.log('m',members);
    return authFetch(`${urls.partyUrl}/members`, {
        method: 'POST', 
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(members)
    });
}
