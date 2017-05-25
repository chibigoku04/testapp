package testapp

import grails.transaction.Transactional

@Transactional
class FooService {

    def collectionFoo() {
        Foo.collection.find().collect()
    }

    def listFoo() {
        Foo.list().collect()
    }
}
