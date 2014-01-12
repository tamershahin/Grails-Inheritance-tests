package com.grailsurfing.step1



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class FlyingObjectController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond FlyingObject.list(params), model: [flyingObjectInstanceCount: FlyingObject.count()]
    }

    def show(FlyingObject flyingObjectInstance) {
        respond flyingObjectInstance
    }

    def create() {
        respond new FlyingObject(params)
    }

    @Transactional
    def save(FlyingObject flyingObjectInstance) {
        if (flyingObjectInstance == null) {
            notFound()
            return
        }

        if (flyingObjectInstance.hasErrors()) {
            respond flyingObjectInstance.errors, view: 'create'
            return
        }

        flyingObjectInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'flyingObjectInstance.label', default: 'FlyingObject'), flyingObjectInstance.id])
                redirect flyingObjectInstance
            }
            '*' { respond flyingObjectInstance, [status: CREATED] }
        }
    }

    def edit(FlyingObject flyingObjectInstance) {
        respond flyingObjectInstance
    }

    @Transactional
    def update(FlyingObject flyingObjectInstance) {
        if (flyingObjectInstance == null) {
            notFound()
            return
        }

        if (flyingObjectInstance.hasErrors()) {
            respond flyingObjectInstance.errors, view: 'edit'
            return
        }

        flyingObjectInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'FlyingObject.label', default: 'FlyingObject'), flyingObjectInstance.id])
                redirect flyingObjectInstance
            }
            '*' { respond flyingObjectInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(FlyingObject flyingObjectInstance) {

        if (flyingObjectInstance == null) {
            notFound()
            return
        }

        flyingObjectInstance.delete flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'FlyingObject.label', default: 'FlyingObject'), flyingObjectInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'flyingObjectInstance.label', default: 'FlyingObject'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
