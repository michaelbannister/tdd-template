class PokerGame {

    List<Hand> getWinningHand(List<Hand> hands) {
        def handsWithPair = hands.findAll { it.containsPair() }
        if (handsWithPair.size() == 1) {
            return [handsWithPair.first()]
        }
        return highestCardWins(hands)
    }

    private List<Hand> highestCardWins(List<Hand> hands) {
        def (handA, handB) = hands

        switch (handA.highCard.compareTo(handB.highCard)) {
            case 1:
                return [handA]
            case -1:
                return [handB]
            case 0:
                return hands
        }
    }

}

