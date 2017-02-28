import grails.test.mixin.integration.Integration
import grails.validation.ValidationException
import spock.lang.Specification
import testapp.Bar
import testapp.Foo
import testapp.FooBarService

@Integration
class FooBarServiceIntegrationSpec extends Specification {

    static transactional = false

    FooBarService fooBarService

    def setup() {
    }

    def cleanup() {
        Foo.withTransaction {
            def foos = Foo.findAll()
            foos.each { it.delete() }
            assert Foo.count == 0
        }

        Bar.withTransaction {
            def bars = Bar.findAll()
            bars.each { it.delete() }
            assert Bar.count == 0
        }
    }

    void "test create valid foo and valid bar in same transaction in single service"() {
        when:
        fooBarService.createAFooAndABar('foo', 'fooVal', 'bar', 'barVal')

        then:
        Foo.withTransaction {
            Foo.count == 1
        }

        Bar.withTransaction {
            Bar.count == 1
        }
    }

    void "test create valid foo and invalid bar in same transaction in single service"() {
        when:
        fooBarService.createAFooAndABar('foo', 'fooVal', 'bar', null)

        then:
        thrown(ValidationException)

        Foo.withTransaction {
            Foo.count == 0
        }

        Bar.withTransaction {
            Bar.count == 0
        }
    }

    void "test create valid foo and valid bar in same transaction in 2 services"() {
        when:
        fooBarService.createAFooAndABarSeparateServices('foo', 'fooVal', 'bar', 'barVal')

        then:
        Foo.withTransaction {
            Foo.count == 1
        }

        Bar.withTransaction {
            Bar.count == 1
        }
    }

    void "test create valid foo and invalid bar in same transaction in 2 services"() {
        when:
        fooBarService.createAFooAndABarSeparateServices('foo', 'fooVal', 'bar', null)

        then:
        thrown(ValidationException)
        Foo.withTransaction {
            Foo.count == 0
        }

        Bar.withTransaction {
            Bar.count == 0
        }
    }
}
