package study.step2

enum class Operator(
    val expression: String
) {

    PLUS("+") {
        override fun apply(left: Operand, right: Operand): Int {
            return left.value + right.value
        }
    },
    MINUS("-") {
        override fun apply(left: Operand, right: Operand): Int {
            return left.value - right.value
        }
    },
    MULTIPLY("*") {
        override fun apply(left: Operand, right: Operand): Int {
            return left.value * right.value
        }
    },
    DIVIDE("/") {
        override fun apply(left: Operand, right: Operand): Int {
            if (right.value == 0) {
                throw IllegalArgumentException()
            }
            return left.value / right.value
        }
    };

    abstract fun apply(left: Operand, right: Operand): Int
    companion object {
        fun of(value: String): Operator {
            return values().first { it.expression == value }
        }
    }
}
