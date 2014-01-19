package com.grailsurfing.step1

class Eagle {

    // importing a DC as delegate allow you to use its properties and method in the current one. just remember to
    // instantiate them with new key
    @Delegate
    FlyingObject flyingObject = new FlyingObject()

    static embedded = ['flyingObject']

    static transients = ['flyingObject', 'dummyProperty']

    //when you extends an other class with FlyingObject this constraints will be shared
    static constraints = {
        importFrom(FlyingObject, include: ['flyingTimeMin'])
    }

    def doFlyLikeAnEagle() {
        return doFly() + " like an eagle!"
    }
}
