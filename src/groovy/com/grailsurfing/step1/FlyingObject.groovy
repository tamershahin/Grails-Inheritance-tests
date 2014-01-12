package com.grailsurfing.step1

class FlyingObject {

    Integer flyingTimeMin = 0

    Integer seatsNb

    Integer dummyProperty

    //all property names listed in transients will not be persisted
    static transients = ['dummyProperty']

    //when you extends an other class with FlyingObject this constraints will be shared
    static constraints = {
        flyingTimeMin nullable: false, min: 0
        seatsNb nullable: false, min: 1
    }

    static mapping = {
        // if false 2 different table will be created
        // if true only one table will be created with a 'class' column used by hibernate to cast the record to the right
        // domain class
        tablePerHierarchy false
    }

    def doFly(){
       return "I'm flying "
    }
}
