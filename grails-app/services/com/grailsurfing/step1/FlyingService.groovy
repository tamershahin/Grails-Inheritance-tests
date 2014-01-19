package com.grailsurfing.step1

import grails.transaction.Transactional

@Transactional
class FlyingService {

    def testMethod() {
        println 'service is working!'
    }
}
