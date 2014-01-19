package com.grailsurfing.step1

public class Vehicle {

    // in this example app Vehicle is used both to define a composition (in Car DC) and a regular DC (in Concorde DC),
    // don't mix the meaning of this different usage.

    Integer seatsNb
    String vehicleName

    //when you extends an other class with FlyingObject this constraints will be shared
    static constraints = {
        seatsNb nullable: false, min: 1
        vehicleName nullable: false, maxSize: 100
    }

}
