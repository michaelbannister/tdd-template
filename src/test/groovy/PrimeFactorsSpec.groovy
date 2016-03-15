import spock.lang.Specification
import spock.lang.Unroll

class PrimeFactorsSpec extends Specification {

    @Unroll
    def "prime factors of #n are #factors"() {
        expect:
        new PrimeFactors().generate(n) == factors

        where:
        n  | factors
        1  | []
        2  | [2]
        4  | [2, 2]
        8  | [2, 2, 2]
        9  | [3, 3]
        12 | [2, 2, 3]
        18 | [2, 3, 3]
        60 | [2, 2, 3, 5]
    }

}
