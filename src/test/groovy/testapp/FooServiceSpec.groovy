package testapp

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(FooService)
@Mock(Foo)
class FooServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test collection find"() {
        def results
        given:
            results = service.collectionFoo()
        expect:
            results
    }

    void "test list find"() {
        def results
        given:
            results = service.listFoo()
        expect:
            results.size() == 0
    }
}
