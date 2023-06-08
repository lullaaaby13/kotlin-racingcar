package study.step2

import java.util.NoSuchElementException

class Calculator {

    fun execute(expression: String? = null): Int {
        val operation = Operation.parse(expression)
        var result = 0

        var left: Operand = operation.pollOperand()
        var right: Operand = operation.pollOperand()
        var operator: Operator = operation.pollOperator()

        while (true) {
            result = operator.apply(left, right)

            left = Operand.of(result.toString())
            try {
                right = operation.pollOperand()
            } catch (ignore: NoSuchElementException) {
                break
            }
            operator = operation.pollOperator()
        }

        return result
    }
}
