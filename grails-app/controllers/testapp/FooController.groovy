package testapp

import grails.rest.RestfulController

class FooController extends RestfulController<Foo> {
	static responseFormats = ['json', 'xml']

    FooController() {
        super(Foo)
    }
}
