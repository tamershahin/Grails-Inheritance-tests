package com.grailsurfing.step1

class Albatros extends FlyingObject {

    static constraints = {
    }

    def doFly(){
        return super.doFly() + " like a bird!"
    }
}
