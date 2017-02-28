package testapp

import grails.transaction.Transactional

@Transactional
class FooService {

    def createFoo(String name, String value) {
        new Foo(name: name, value: value).save(failOnError: true)
    }
}
