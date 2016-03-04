import spock.lang.Specification

class PokerSpec extends Specification {
    private PokerGame game

    void setup() {
        game = new PokerGame()
    }

    def "two equal single-card hands will draw"() {
        when:
        def winningHands = findHighestHands(Hand.of(4), Hand.of(4))

        then:
        winningHands == [Hand.of(4), Hand.of(4)]
    }

    def 'two non-equal single-card hands return hand with the higher card'(){
        when:
        def winningHands = findHighestHands(Hand.of(4), Hand.of(5))

        then:
        winningHands == [Hand.of(5)]
    }

    def 'two identical two-card hands will draw, returning both hands'() {
        when:
        def winningHands = findHighestHands(Hand.of(4, 5), Hand.of(5, 4))

        then:
        winningHands == [Hand.of(4, 5), Hand.of(5, 4)]
    }

    def 'two two-card hands where one hand is clearly higher returns the higher hand'(){
        when:
        def winningHands = findHighestHands(Hand.of(3,4), Hand.of(3,5))

        then:
        winningHands == [Hand.of(3,5)]
    }

    def 'two hands whose highest cards are equal should compare next-highest cards to determine winner'() {
        when:
        def winningHands = findHighestHands(Hand.of(5,4), Hand.of(5, 3))

        then:
        winningHands == [Hand.of(5,4)]
    }

    def 'hand with pair wins over hand without pair'(){
        when:
        def winningHands = findHighestHands(Hand.of(2,3,2), Hand.of(2,4,6))

        then:
        winningHands == [Hand.of(2,3,2)]
    }

    def 'hand with pair wins over hand without pair (part 2)'(){
        when:
        def winningHands = findHighestHands(Hand.of(2,4,6), Hand.of(2,3,2))

        then:
        winningHands == [Hand.of(2,3,2)]
    }

//    def 'hands both with one pair, hand with highest pair wins'() {
//        when:
//        def winningHands = findHighestHands(Hand.of(2,2,4), Hand.of(3,3,1))
//
//        then:
//        winningHands == [Hand.of(3,3,1)]
//    }


    private List<Hand> findHighestHands(Hand handA, Hand handB) {
        game.getWinningHand([handA, handB])
    }

}
