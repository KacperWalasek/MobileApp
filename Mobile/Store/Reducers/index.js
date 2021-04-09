import { combineReducers } from "redux";
import userReducer from './UserReducer';
import activeMemberReducer from './ActivePartyMemberReducer';
import activePartyReducer from './ActivePartyReducer';

export default combineReducers({
  user: userReducer,
  activeMember: activeMemberReducer,
  activeParty: activePartyReducer
})