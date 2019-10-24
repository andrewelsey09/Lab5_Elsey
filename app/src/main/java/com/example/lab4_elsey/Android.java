package com.example.lab4_elsey;

public class Android {
    int logo;
    String name,version,date,APILevel;

    public Android(int logo, String name, String version, String APILevel, String date) {
        this.logo = logo;
        this.name = name;
        this.version = version;
        this.date = date;
        this.APILevel=APILevel;
    }

    public int getLogo() {
        return logo;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getDate() {
        return date;
    }

    public String getAPILevel(){
        return APILevel;
    }
}
