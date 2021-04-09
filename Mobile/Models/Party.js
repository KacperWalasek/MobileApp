export class Party {
    constructor(name = '', address = '', longitude = 0, latitude = 0, isPublic = true){
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.address = address;
        this.public = isPublic;
    }

    id = '';
    name = '';
    longitude = 0;
    latitude = 0;
    address = '';
    public = true;
}