import { Roles } from "../../constants";

export class PartyMemberDTO{
    constructor(partyId, userId, role=Roles.MEMBER){
        this.partyId = partyId;
        this.userId = userId;
        this.role = role;
    }
    partyId;
    userId;
    role;
}