import java.util.*

class Menu(val contentCreatorAndChooiser: ContentCreatorAndChooiser) {

    fun archiveMenuPrint() {
        while (true) {
            println(
                "Начало программы - \n" +
                        "0. Выбор архива\n" +
                        "1. Создать Архив\n" +
                        "2. Выход\n" +
                        "---"
            )
            print("введите команду: ")
            val command = Scanner(System.`in`).nextLine()
            if (InputChecker.checkInt(command)) {
                when (command) {
                    "0" -> contentCreatorAndChooiser.chooseArchive()
                    "1" -> contentCreatorAndChooiser.archives.add(contentCreatorAndChooiser.createArchive())
                    "2" -> break
                    else -> println("такого пункта не существует, выберите существующий пункт")
                }
            }
        }
    }

    fun noteMenuPrint() {
        println(
            "0. Выбор заметки\n" +
                    "1. Создать заметку\n" +
                    "2. Назад\n" +
                    "---"
        )
        print("введите команду: ")

        val scanner = Scanner(System.`in`)
        val command = scanner.nextLine()

        if (InputChecker.checkInt(command)) {
            when (command) {
                "0" -> contentCreatorAndChooiser.chooseNote()
                "1" -> contentCreatorAndChooiser.createNote()
                "2" -> return
            }
        } else {
            noteMenuPrint()
        }
    }
}

