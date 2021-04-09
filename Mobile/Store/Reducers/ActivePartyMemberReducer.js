export const SET_ACTIVE_MEMBER = "SET_ACTIVE_MEMBER";
export const RESET_ACTIVE_MEMBER = "RESET_ACTIVE_MEMBER";

const initialState = {
    userId: "",
}
export default function userReducer(state = initialState, action) {
    switch (action.type) {
        case SET_ACTIVE_MEMBER:
            return {
                id: action.payload.userId,
            }
        case RESET_ACTIVE_MEMBER:
            return initialState
        default:
            return state
    }
  }