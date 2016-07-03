fun Int.toRoman(): String {
    if (this < 10) {
        return "I".repeat(this)
    } else {
        return "X"
    }
}