package com.grailsurfing.step1

public class Vehicle  {

    Integer seatsNb

    //when you extends an other class with FlyingObject this constraints will be shared
    static constraints = {
        seatsNb nullable: false, min: 1
    }

    static mapping = {
        // if false 2 different table will be created
        // if true only one table will be created with a 'class' column used by hibernate to cast the record to the right
        // domain class
        tablePerHierarchy false
    }
}
