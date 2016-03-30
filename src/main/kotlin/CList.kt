interface CList<T> {
    val size: Int
    fun get(index: Int): T
    fun contains(value: T): Boolean
    fun indexOf(value: T): Int
    fun subList(fromIndex: Int, toIndex: Int): CList<T>
    operator fun plus(list: CList<T>): CList<T>
}

object Nil : CList<Any> {
    override val size = 0
    override fun get(index: Int) = throw IndexOutOfBoundsException()
    override fun contains(value: Any) = false
    override fun indexOf(value: Any) = -1

    override fun subList(fromIndex: Int, toIndex: Int) =
            if (fromIndex == 0 && toIndex == 0)
                Nil
            else
                throw IndexOutOfBoundsException()

    override fun plus(list: CList<Any>) = list

}

data class Cons<T>(val head: T, val tail: CList<T>) : CList<T> {
    override val size = 1 + tail.size
    override fun get(index: Int) = when (index) {
        0 -> head
        else -> tail.get(index - 1)
    }

    override fun contains(value: T): Boolean = (value == head) || tail.contains(value)
    override fun indexOf(value: T): Int {
        if (value == head) {
            return 0
        } else {
            val tailIndex = tail.indexOf(value)
            if (tailIndex < 0) {
                return tailIndex
            } else {
                return 1 + tailIndex
            }
        }
    }

    override fun subList(fromIndex: Int, toIndex: Int): CList<T> =
            if (fromIndex == 0) {
                if (toIndex == 0) {
                    Nil as CList<T>
                } else {
                    Cons(head, tail.subList(0, toIndex - 1))
                }
            } else {
                tail.subList(fromIndex - 1, toIndex - 1)
            }

    override fun plus(list: CList<T>) =
        if (tail == Nil) {
            Cons(head, list)
        } else {
            Cons(head, tail + list)
        }
}

fun <T> consListOf(vararg items: T): CList<T> = items.foldRight(Nil as CList<T>, { item, list -> Cons(item, list) })