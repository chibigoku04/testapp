package testapp

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Foo)
class FooSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test save"() {
        given:
        new Foo(name: 'foo1', value: 'val1').save(flush:true, failOnError:true)

        expect:
            Foo.count == 1
    }
}
