package testapp

import grails.transaction.Transactional

@Transactional
class FooBarService {

    FooService fooService
    BarService barService

    def createAFooAndABar(String fooName, String fooVal, String barName, String barVal) {
        new Foo(name: fooName, value: fooVal).save(failOnError: true)
        new Bar(name: barName, value: barVal).save(failOnError: true)
    }

    def createAFooAndABarSeparateServices(String fooName, String fooVal, String barName, String barVal) {
        fooService.createFoo(fooName, fooVal)
        barService.createBar(barName, barVal)
    }
}
