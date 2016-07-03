fun Int.toRoman(): String {
    if (this >= 100) {
        return "C".repeat(this / 100)
    } else if (this >= 10) {
        return "X".repeat(this / 10)
    } else {
        return "I".repeat(this)
    }
}