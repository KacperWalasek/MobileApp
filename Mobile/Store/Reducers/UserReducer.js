export const USER_LOGIN = "USER_LOGIN";
export const USER_REFRESH_TOKEN = "USER_REFRESH_TOKEN";
export const USER_LOGOUT = "USER_LOGOUT";
const initialState =  {
  userId: "", 
  username: "", 
  validationToken: "", 
  refreshToken: ""
}
export default function userReducer(state = initialState, action) {
    switch (action.type) {
      case USER_LOGIN:
        return { 
            ...state,
            username: action.payload.username, 
            userId: action.payload.userId, 
            validationToken: action.payload.token, 
            refreshToken: action.payload.refreshToken 
        };
      case USER_REFRESH_TOKEN:
        return{
          ...state,
          validationToken: action.payload.token,
          refreshToken: action.payload.refreshToken
        }
      case USER_LOGOUT:
        return initialState;
      default:
        return state
    }
  }