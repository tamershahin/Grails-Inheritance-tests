package com.grailsurfing.step1

import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.*

@Transactional(readOnly = true)
class ConcordeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Concorde.list(params), model: [concordeInstanceCount: Concorde.count()]
    }

    def show(Concorde concordeInstance) {
        respond concordeInstance
    }

    def create() {
        respond new Concorde(params)
    }

    @Transactional
    def save(Concorde concordeInstance) {
        if (concordeInstance == null) {
            notFound()
            return
        }

        if (concordeInstance.hasErrors()) {
            respond concordeInstance.errors, view: 'create'
            return
        }

        concordeInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'concordeInstance.label', default: 'Concorde'), concordeInstance.id])
                redirect concordeInstance
            }
            '*' { respond concordeInstance, [status: CREATED] }
        }
    }

    def edit(Concorde concordeInstance) {
        respond concordeInstance
    }

    @Transactional
    def update(Concorde concordeInstance) {
        if (concordeInstance == null) {
            notFound()
            return
        }

        if (concordeInstance.hasErrors()) {
            respond concordeInstance.errors, view: 'edit'
            return
        }

        concordeInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Concorde.label', default: 'Concorde'), concordeInstance.id])
                redirect concordeInstance
            }
            '*' { respond concordeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Concorde concordeInstance) {

        if (concordeInstance == null) {
            notFound()
            return
        }

        concordeInstance.delete flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Concorde.label', default: 'Concorde'), concordeInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'concordeInstance.label', default: 'Concorde'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
