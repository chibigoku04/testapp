import grails.test.mixin.TestFor
import grails.test.mixin.integration.Integration
import spock.lang.Specification
import testapp.Foo
import testapp.FooService

@TestFor(FooService)
@Integration
class FooServiceIntegrationSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test create valid foo"() {
        when:
        service.createFoo('foo', 'someVal')

        then:
        Foo.count == 1
    }
}
