package testapp

import grails.transaction.Transactional

@Transactional
class BarService {

    static transactional = 'mongo'

    def createBar(String name, String value) {
        new Bar(name: name, value: value).save(failOnError: true)
    }
}
