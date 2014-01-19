package com.grailsurfing.step1

class FlyingObject {

    // services injected in classes used in DC with @Delegate are 100% valid
    def flyingService

    Integer flyingTimeMin = 0

    Integer dummyProperty

    //when you extends an other class with FlyingObject this constraints will be shared
    static constraints = {
        flyingTimeMin nullable: false, min: 0
    }


    def doFly() {
        return "I'm flying "
    }
}
