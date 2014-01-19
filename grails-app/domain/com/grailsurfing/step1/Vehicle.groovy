package com.grailsurfing.step1

public class Vehicle {

    // in this example app Vehicle is used both to define a regular DC, a composition (in Car DC) and inheritance (in Concorde DC)
    // don't mix the meaning of this different usage!

    Integer seatsNb
    String vehicleName

    //when you extends an other class with FlyingObject this constraints will be shared
    static constraints = {
        seatsNb nullable: false, min: 1
        vehicleName nullable: false, maxSize: 100
    }

    static mapping = {
        // if false 2 different table will be created
        // if true only one table will be created with a 'class' column
        //used by hibernate to cast the record to the right
        // domain class
        tablePerHierarchy false
    }

}
