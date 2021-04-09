export const SET_ACTIVE_PARTY = "SET_ACTIVE_PARTY";
export const RESET_ACTIVE_PARTY = "RESET_ACTIVE_PARTY";

const initialState = {
    id: "",
    name: "",
    address: "",
    latitude: "",
    longitude: "",
    public: "",
}
export default function userReducer(state = initialState, action) {
    switch (action.type) {
        case SET_ACTIVE_PARTY:
            return {
                id: action.payload.id,
                name: action.payload.name,
                address: action.payload.address,
                latitude: action.payload.latitude,
                longitude: action.payload.longitude,
                public: action.payload.public,
            }
        case RESET_ACTIVE_PARTY:
            return initialState;
        default:
            return state
    }
  }