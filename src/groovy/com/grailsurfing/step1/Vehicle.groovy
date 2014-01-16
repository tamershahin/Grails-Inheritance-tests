package com.grailsurfing.step1

public class Vehicle extends FlyingObject {

    Integer seatsNb

    //when you extends an other class with FlyingObject this constraints will be shared
    static constraints = {
        seatsNb nullable: false, min: 1
    }
}
