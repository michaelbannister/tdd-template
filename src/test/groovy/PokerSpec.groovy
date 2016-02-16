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
        def winningHands = findHighestHands(Hand.of(4,4), Hand.of(4,5))

        then:
        winningHands == [Hand.of(4,5)]
    }

    private List<Hand> findHighestHands(Hand handA, Hand handB) {
        game.getWinningHand([handA, handB])
    }

}
