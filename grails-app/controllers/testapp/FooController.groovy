package testapp

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class FooController {

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Foo.list(params), model:[fooCount: Foo.count()]
    }

    def show(Foo foo) {
        println "current foo is: $session.foo"
        session.foo = foo
        println "set session foo to: $session.foo"

        respond foo
    }

    @Transactional
    def save(Foo foo) {
        if (foo == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (foo.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond foo.errors, view:'create'
            return
        }

        foo.save flush:true

        respond foo, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Foo foo) {
        if (foo == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (foo.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond foo.errors, view:'edit'
            return
        }

        foo.save flush:true

        respond foo, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Foo foo) {

        if (foo == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        foo.delete flush:true

        render status: NO_CONTENT
    }
}
