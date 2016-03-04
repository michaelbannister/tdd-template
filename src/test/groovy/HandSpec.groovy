import spock.lang.Specification

class HandSpec extends Specification {

    def "Hand contains Pair"() {
        expect:
        Hand.of(2,5,7,3,2).containsPair() == true
    }
}
