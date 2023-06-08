package study.step2

class Operation private constructor(
    val operands: MutableList<Operand>,
    val operators: MutableList<Operator>,
) {

    fun pollOperand(): Operand {
        return operands.removeFirst()
    }

    fun pollOperator(): Operator {
        return operators.removeFirst()
    }

    companion object {
        fun parse(expression: String? = null): Operation {
            if (expression.isNullOrBlank()) {
                throw IllegalArgumentException()
            }

            val splitted = expression.split(" ")

            val operands: MutableList<Operand> = mutableListOf()
            val operators: MutableList<Operator> = mutableListOf()

            splitted.forEachIndexed { index, it ->
                if (index % 2 == 0) {
                    operands.add(Operand.of(it))
                } else {
                    operators.add(Operator.of(it))
                }
            }
            if (operators.size + 1 != operands.size) {
                throw IllegalArgumentException()
            }

            return Operation(operands, operators)
        }
    }
}
