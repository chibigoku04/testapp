package testapp

import grails.transaction.Transactional

@Transactional
class BarService {

    def createBar(String name, String value) {
        new Bar(name: name, value: value).save(failOnError: true)
    }
}
