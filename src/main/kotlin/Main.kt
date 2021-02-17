

fun main(args: Array<String>) {
    var isRunning = true
    println("Hello World!")
    println("What is your name?")
    val name = readLine()
    println("Hello $name!")

    val menu = HashMap<Int, String>().apply {
        put(1, "Print Hello")
        put(2, "Print Goodbye")
        put(3, "Add a new choice.")
        put(0, "Quit")
    }

    while (isRunning) {
        for (option in menu) {
            println("${option.key}. ${option.value}")
        }

        when (readLine()?.toIntOrNull()) {
            null -> println("Invalid Choice.")
            1 -> println("Hello!")
            2 -> println("Goodbye!")
            3 -> {
                menu.run { put(4, "Greet You Again") }
                println("A new menu option is added.")
            }
            4 -> {
                when(name.isNullOrEmpty()) {
                    true -> greet("Unknown")
                    false -> greet(name)
                }
            }
            0 -> {
                println("Egress.")
                isRunning = false
            }
            else -> println("Your input is not mapped to a choice.")
        }
    }
}

fun greet(person: String) {
    println("Hello $person!")
}
