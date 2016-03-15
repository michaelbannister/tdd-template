class PrimeFactors {
    List<Integer> generate(int n) {
        def factors = []
        while (n > 1) {
            def factor = (2..n).iterator().find { n % it == 0 }
            if (factor) {
                factors << factor
                n = n / factor
            } else {
                factors << n
                break
            }
        }
        factors
    }
}
