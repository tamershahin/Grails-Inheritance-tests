package com.grailsurfing.step1

class Concorde {

    Integer currentPassengerNb

    // importing a DC as delegate allow you to use its properties and method in the current one. just remember to
    // instantiate them with new key
    @Delegate
    FlyingObject flyingObject = new FlyingObject()

    // in Concorde class we are using vehicle like a normal DC, referring to it as usual
    Vehicle vehicle

    // we must point out that we are not interested in saving the vehicle instance itself. in this list must appear
    // all properties imported from @Delegate classes that we don't want to persist
    static transients = ['flyingObject', 'dummyProperty']

    static hasOne = ['vehicle']

    //static properties are not persisted
    static int maxSpeed = 2172

    // the current class must be aware of the constraint coming from FlyingObject DC. in this DC vehicle is normal
    // object that can be nullable or not
    static constraints = {
        importFrom(FlyingObject, include: ['flyingTimeMin'])
        currentPassengerNb nullable: false, min: 0, max: 200
        vehicle nullable: false
    }

    // mixed usage of properties imported with @Delegate and as usual
    def printProperties() {
        vehicle.vehicleName + " now flying from " + flyingTimeMin + "minutes,  with " + currentPassengerNb + " occupied seats on " + vehicle.seatsNb
    }

    def doFlyLikeAnAirplane() {
        return doFly() + " like an Airplane!"
    }
}
