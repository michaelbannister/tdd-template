class Hand implements List<Integer> {

    Hand() {
        // default empty hand
    }

    Hand(List<Integer> cards) {
        this.cards.addAll(cards)
    }

    @Delegate
    private List<Integer> cards = []

    static Hand of(Integer... cards) {
        def hand = new Hand()
        hand.addAll(cards)
        hand
    }

    HighCard getHighCard() {
        new HighCard(cards)
    }

    boolean containsPair() {
        def pairs = findPairs()
        pairs.size() == 1
    }

    private List findPairs() {
        cards.findAll { cards.count(it) == 2 }.unique()
    }
}


class HighCard implements Comparable<HighCard> {
    List<Integer> cards

    HighCard(List<Integer> cards) {
        this.cards = cards.sort(false).reverse()
    }

    @Override
    int compareTo(HighCard other) {
        for (int i = 0; i < cards.size(); i++) {
            def cardA = cards.get(i)
            def cardB = other.cards.get(i)

            if (cardA < cardB) {
                return -1
            } else if (cardA > cardB) {
                return 1
            }
        }
        return 0
    }
}

class Pair implements Comparable<Pair> {
    int card

    Pair(card) {
        this.card = card
    }

    int compareTo(Pair other) {
        return this.card <=> other.card
    }
}