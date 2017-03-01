package testapp

import grails.transaction.Transactional

@Transactional
class FooBarService {

    static transactional = 'mongo'

    FooService fooService
    BarService barService

    def createAFooAndABar(String fooName, String fooVal, String barName, String barVal) {
        new Foo(name: fooName, value: fooVal).save(failOnError: true)
        new Bar(name: barName, value: barVal).save(failOnError: true)
    }

    def createAFooAndABarSeparateMethods(String fooName, String fooVal, String barName, String barVal) {
        createFoo(fooName, fooVal)
        createBar(barName, barVal)
    }

    def createAFooAndABarSeparateServices(String fooName, String fooVal, String barName, String barVal) {
        fooService.createFoo(fooName, fooVal)
        barService.createBar(barName, barVal)
    }

    def createFoo(String fooName, String fooVal) {
        new Foo(name: fooName, value: fooVal).save(failOnError: true)
    }

    def createBar(String barName, String barVal) {
        new Bar(name: barName, value: barVal).save(failOnError: true)
    }
}
