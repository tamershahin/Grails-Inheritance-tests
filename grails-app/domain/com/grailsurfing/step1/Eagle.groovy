package com.grailsurfing.step1

class Eagle extends FlyingObject {

    static constraints = {
    }

    def doFly(){
        return super.doFly() + " like an eagle!"
    }
}
