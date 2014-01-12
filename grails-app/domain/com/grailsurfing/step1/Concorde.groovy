package com.grailsurfing.step1

class Concorde extends FlyingObject{

    Integer currentPassengerNb

    //static properties are not persisted
    static int maxSpeed = 2172

    //if you need a field editable but not interested in persisting it declare it
    //as private and create getter+setter
    Object getPublicId() {
        return id + "-public"
    }
    void setPublicId(Object id) {
        this.id = id
    }
    private Object publicId


    static constraints = {
        currentPassengerNb nullable: false, min: 0, max: 200
    }
}
