class RecentlyUsedList {

    var items = Nil as CList<String>
    var size = 0

    fun add(value: String) {
        if (items.contains(value)) {
            val index = items.indexOf(value)
            val listExcludingValue = items.subList(0, index) + items.subList(index + 1, items.size)
            items = Cons(value, listExcludingValue)
        } else {
            items = Cons(value, items)
            size++
        }
    }

    fun get(index: Int): String = items.get(index)
}