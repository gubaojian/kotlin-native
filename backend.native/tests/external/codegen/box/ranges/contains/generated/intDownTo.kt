// Auto-generated by GenerateInRangeExpressionTestData. Do not edit!
// WITH_RUNTIME



val range0 = 3 downTo 1
val range1 = 1 downTo 3

val element0 = 1

fun box(): String {
    testR0xE0()
    testR1xE0()
    return "OK"
}

fun testR0xE0() {
    // with possible local optimizations
    if (1 in 3 downTo 1 != range0.contains(1)) throw AssertionError()
    if (1 !in 3 downTo 1 != !range0.contains(1)) throw AssertionError()
    if (!(1 in 3 downTo 1) != !range0.contains(1)) throw AssertionError()
    if (!(1 !in 3 downTo 1) != range0.contains(1)) throw AssertionError()
    // no local optimizations
    if (element0 in 3 downTo 1 != range0.contains(element0)) throw AssertionError()
    if (element0 !in 3 downTo 1 != !range0.contains(element0)) throw AssertionError()
    if (!(element0 in 3 downTo 1) != !range0.contains(element0)) throw AssertionError()
    if (!(element0 !in 3 downTo 1) != range0.contains(element0)) throw AssertionError()
}

fun testR1xE0() {
    // with possible local optimizations
    if (1 in 1 downTo 3 != range1.contains(1)) throw AssertionError()
    if (1 !in 1 downTo 3 != !range1.contains(1)) throw AssertionError()
    if (!(1 in 1 downTo 3) != !range1.contains(1)) throw AssertionError()
    if (!(1 !in 1 downTo 3) != range1.contains(1)) throw AssertionError()
    // no local optimizations
    if (element0 in 1 downTo 3 != range1.contains(element0)) throw AssertionError()
    if (element0 !in 1 downTo 3 != !range1.contains(element0)) throw AssertionError()
    if (!(element0 in 1 downTo 3) != !range1.contains(element0)) throw AssertionError()
    if (!(element0 !in 1 downTo 3) != range1.contains(element0)) throw AssertionError()
}

