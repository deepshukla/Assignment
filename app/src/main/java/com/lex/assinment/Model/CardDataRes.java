package com.lex.assinment.Model;


import java.util.List;

public class CardDataRes{
    /**
     * url : https://pbs.twimg.com/profile_images/572905100960485376/GK09QnNG.jpeg
     * name : Sofia
     * age : 20
     * location : New York
     * Details : ["I can be stubborn","I'm not always a great listener","I don't like asking for help","I'm not always a great listener","I eat out all the time","I love getting compliments","I can be emotional at times","I love getting compliments"]
     * bodyType : I am tall
     *
     * userDesire : I'm looking for dating
     */

    private String url;
    private String name;
    private String age;
    private String location;
    private String bodyType;
    private String userDesire;
    private List<String> Details;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getUserDesire() {
        return userDesire;
    }

    public void setUserDesire(String userDesire) {
        this.userDesire = userDesire;
    }

    public List<String> getDetails() {
        return Details;
    }

    public void setDetails(List<String> Details) {
        this.Details = Details;
    }
}

