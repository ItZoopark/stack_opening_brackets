import java.util.*

fun checkBalancedBrackets(input: String): Boolean {
    val openingBrackets = "([{"
    val closingBrackets = ")]}"
    val matches = mapOf("(" to ")", "[" to "]", "{" to "}")
    val stack = Stack<Char>()

    for (bracket in input) {
        if (openingBrackets.contains(bracket)) {
            stack.add(bracket)
        } else if (closingBrackets.contains(bracket)) {
            if (stack.empty()) return false
            if (stack.peek() != bracket) stack.pop() else false
        }
    }
    return (stack.size == 0)
}

fun main(args: Array<String>) {

//    val direction = "EAST"

    val h = listOf(3, 5, 4, 4, 3, 1, 3, 2)
    val direction = "WEST"
    val hRes = Stack<Int>()
    when(direction){
        "EAST" -> {
            hRes.push(h.size-1)
            for (i in (h.size - 1) downTo 1 ){
                if (h[i-1] > h[hRes.peek()]){
                    hRes.push(i-1)
                }
            }
            val final = MutableList(hRes.size){0}
            var i = 0
            while (hRes.isNotEmpty()){
                final[i++] = hRes.pop()
            }
            println(final)
        }
        "WEST" -> {
            hRes.push(0)
            for (i in 0 until (h.size-1)){
                if (h[i+1] > h[hRes.peek()]){
                    hRes.push(i+1)
                }
            }
            val final = MutableList(hRes.size){0}
            while (hRes.isNotEmpty()){
                final[hRes.size-1] = hRes.pop()
            }
            println(final)
        }

    }

//    hRes.push(0)
//    for (i in 0 until h.size-1){
//        if (h[i] > h[i+1]){
//            hRes.push(i+1)
//        }else{
//            var k = i + 1
//            while (hRes.isNotEmpty() && h[k] >= h[hRes.peek()]) {
//                hRes.pop()
//            }
//            hRes.push(i+1)
//        }
//    }
//
//    val final = MutableList(hRes.size){0}
//    while (hRes.isNotEmpty()){
//        final[hRes.size-1] = hRes.pop()
//    }
//    println(final)

}