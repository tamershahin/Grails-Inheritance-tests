package com.grailsurfing.step1

class Eagle {

    FlyingObject flyingObject

    static embedded = ['flyingObject']

    static constraints = {
    }

    def doFly(){
        return flyingObject.doFly() + " like an eagle!"
    }
}
