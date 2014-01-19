package com.grailsurfing.step1

import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.*

@Transactional(readOnly = true)
class EagleController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Eagle.list(params), model: [eagleInstanceCount: Eagle.count()]
    }

    def show(Eagle eagleInstance) {
        respond eagleInstance
    }

    def create() {
        respond new Eagle(params)
    }

    @Transactional
    def save(Eagle eagleInstance) {
        if (eagleInstance == null) {
            notFound()
            return
        }

        if (eagleInstance.hasErrors()) {
            respond eagleInstance.errors, view: 'create'
            return
        }

        eagleInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'eagleInstance.label', default: 'Eagle'), eagleInstance.id])
                redirect eagleInstance
            }
            '*' { respond eagleInstance, [status: CREATED] }
        }
    }

    def edit(Eagle eagleInstance) {
        respond eagleInstance
    }

    @Transactional
    def update(Eagle eagleInstance) {
        if (eagleInstance == null) {
            notFound()
            return
        }

        if (eagleInstance.hasErrors()) {
            respond eagleInstance.errors, view: 'edit'
            return
        }

        eagleInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Eagle.label', default: 'Eagle'), eagleInstance.id])
                redirect eagleInstance
            }
            '*' { respond eagleInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Eagle eagleInstance) {

        if (eagleInstance == null) {
            notFound()
            return
        }

        eagleInstance.delete flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Eagle.label', default: 'Eagle'), eagleInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'eagleInstance.label', default: 'Eagle'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
