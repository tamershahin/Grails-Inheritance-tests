package com.grailsurfing.step1

class Car {

    String brand

    // importing a DC as delegate allow you to use its properties and method in the current one. just remember to
    // instantiate them with new key
    @Delegate
    Vehicle vehicle = new Vehicle()

    // we must point out that we are not interested in saving the vehicle instance itself
    static transients = ['vehicle']

    // we must indicate to GORM to use the properties list from vehicle to create/manipulate Car instances
    static embedded = ['vehicle']

    // the current class must be aware of the constraint coming from Vehicle DC
    static constraints = {
        importFrom(Vehicle, include: ['seatsNb', 'vehicleName'])
        brand nullable: false, maxSize: 100
    }
}
