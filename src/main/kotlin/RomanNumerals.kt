fun Int.toRoman(): String {
    if (this >= 100) {
        return "C"
    } else if (this >= 10) {
        return "X".repeat(this / 10)
    } else {
        return "I".repeat(this)
    }
}