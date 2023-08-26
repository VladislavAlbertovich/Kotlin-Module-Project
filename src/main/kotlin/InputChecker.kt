class InputChecker {

    companion object {
        fun checkInt(input: String): Boolean{
            return if (input.toIntOrNull() == null) {
                println("Некорректная команда. Пожалуйста, введите число")
                 false
            } else {
                true
            }
        }
    }
}