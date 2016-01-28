package com.properdom.tddworkshop

import spock.lang.Specification
import spock.lang.Subject

class ClassUnderTestSpec extends Specification {

    @Subject
    ClassUnderTest classUnderTest

    DependencyClass dependencyClass = Stub()

    def setup() {
        classUnderTest = new ClassUnderTest(dependencyClass)
        dependencyClass.method(_) >> {int arg ->
            return 'The value is ' + String.valueOf(arg)
        }
    }

    def 'expect syntax'() {
        expect:
        'The value is 3' == classUnderTest.method(1, 2);
    }

    def 'when then syntax'() {
        when:
        def result = classUnderTest.method(1, 2);

        then:
        result == 'The value is 3'
    }

    def 'where syntax'() {
        expect:
        result == classUnderTest.method(x, y)

        where:
        x | y  || result
        1 | 2  || 'The value is 3'
        2 | -1 || 'The value is 1'
        2 | -2 || 'The value is 0'
        2 | -4 || 'The value is -2'
    }

}
