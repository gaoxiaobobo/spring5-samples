package com.gupaoedu.vip.pattern.builder.level1;

public class PersonDirector {
    private PersonBuilder pb;

    public PersonBuilder getPb() {
        return pb;
    }

    public void setPb(PersonBuilder pb) {
        this.pb = pb;
    }

    public  PersonDirector(PersonBuilder pb){
        this.pb = pb;
    }
    public void CreatePerson(){
        pb.buildHead();
        pb.buildBody();
        pb.buildArmLeft();
        pb.buildArmRight();
        pb.buildLegLeft();
        pb.buildLegRight();
    }
}
