import com.google.common.collect.ForwardingList

class PokerGame {

    List<Hand> getWinningHand(List<Hand> hands) {
        def sortedHands = hands.collect { hand -> hand.sort(false).reverse()}
        def (handA, handB) = sortedHands
        def (cardA, cardB) = sortedHands*.first()

        if (cardA == cardB) {
            return hands
        } else if (cardA > cardB) {
            return [hands[0]]
        } else {
            return [hands[1]]
        }
    }

}

class Hand extends ForwardingList<Integer> {
    private list = []
    @Override
    protected List<Integer> delegate() {
        return list
    }

    static Hand of(Integer... cards) {
        def hand = new Hand()
        hand.addAll(cards)
        hand
    }
}