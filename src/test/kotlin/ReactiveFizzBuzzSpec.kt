import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object ReactiveFizzBuzzSpec : Spek({
    describe("FizzBuzz") {
        val fizzbuzz = listOf("1", "2", "fizz", "4", "buzz",
                              "fizz", "7", "8", "fizz", "buzz",
                              "11", "fizz", "13", "14", "fizzbuzz")
        
        1.rangeTo(fizzbuzz.size).forEach { n ->
            it("should generate ${n}-element fizzbuzz sequence") {
                assertThat(fizzbuzz(n)).containsExactlyElementsOf(fizzbuzz.subList(0, n))
            }
        }
    }
})

fun fizzbuzz(i: Int): Iterable<String> {
    val ints = Observable.range(1, i)

    val fizz = ints.map(multiplesToWord(3, "fizz"))
    val buzz = ints.map(multiplesToWord(5, "buzz"))
    val fizzbuzz = Observable.zip(fizz, buzz, concatenate())

    val fizzBuzzedNumbers = ints.zipWith(fizzbuzz, wordElseNumber())
    
    return fizzBuzzedNumbers.blockingIterable()
}

private fun concatenate() = BiFunction<String, String, String> { f, b -> f + b }
private fun multiplesToWord(factor: Int, word: String): (Int) -> String = { if (it % factor == 0) word else "" }
private fun wordElseNumber() = BiFunction<Int, String, String> { num, word -> if (word.isNullOrEmpty()) num.toString() else word }



