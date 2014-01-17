package com.grailsurfing.step1

class FlyingObject {

    Integer flyingTimeMin = 0

    Integer dummyProperty

    //all property names listed in transients will not be persisted
    static transients = ['dummyProperty']

    //when you extends an other class with FlyingObject this constraints will be shared
    static constraints = {
        flyingTimeMin nullable: false, min: 0
    }


    def doFly(){
        return "I'm flying "
    }
}
