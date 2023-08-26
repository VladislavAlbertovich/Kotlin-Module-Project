import java.util.Scanner

class ContentCreatorAndChooiser {

    private val menu: Menu = Menu(this)
    private var archiveNumber: Int? = null
    val archives: MutableList<Archive> = mutableListOf<Archive>()

    fun createArchive(): Archive {
        println(
            "введите название нового архива\n" +
                    "---"
        )
        var name = Scanner(System.`in`).nextLine()
        while (name.isEmpty()) {
            println(
                "название архива не может быть пустым\n" +
                        "---"
            )
            name = Scanner(System.`in`).nextLine()
        }
        println(
            "архив $name успешно создан\n" +
                    "---"
        )
        return Archive(name)
    }

    fun chooseArchive() {
        if (archives.isNotEmpty()) {
            println(
                "выберите архив или назад\n" +
                        "---"
            )
            for (archive in archives) {
                println("${archives.indexOf(archive)}. ${archive.title}")
            }
            println("${archives.size}. назад")


            val input = Scanner(System.`in`).nextLine()

            if (InputChecker.checkInt(input)) {
                archiveNumber = input.toInt()
                if (input.toInt() >= 0 && input.toInt() < archives.size) {
                    menu.noteMenuPrint()
                } else if (input.toInt() == archives.size) {
                    return
                } else {
                    println(
                        "такого архива не существует, выберите существующий архив\n" +
                                "---"
                    )
                    chooseArchive()
                }
            }
        } else {
            println(
                "Нет созданных архивов\n" +
                        "---"
            )
        }
    }

    fun createNote() {
        println(
            "Создание заметки, введите название\n" +
                    "---"
        )
        var title = Scanner(System.`in`).nextLine()
        while (title.isEmpty()) {
            println(
                "Название заметки не может быть пустым\n" +
                        "---"
            )
            title = Scanner(System.`in`).nextLine()
        }
        println(
            "Введите текст заметки\n" +
                    "---"
        )
        var text = Scanner(System.`in`).nextLine()
        while (text.isEmpty()) {
            println(
                "Текст заметки не может быть пустым\n" +
                        "---"
            )
            text = Scanner(System.`in`).nextLine()
        }
        val note = Note(title, text)
        putNoteToArchive(note)
        println(
            "Заметка $title успешно создана и добавлена в архив ${archives[archiveNumber!!].title}\n" +
                    "---"
        )
        menu.noteMenuPrint()
    }

    fun putNoteToArchive(note: Note) {
        archives[archiveNumber!!].notes.add(note)
    }

    fun chooseNote() {
        archiveNumber?.let {
            if (archives[archiveNumber!!].notes.isNotEmpty()) {
                println(
                    "выберите заметку или назад\n" +
                            "---"
                )
                for (note in archives[archiveNumber!!].notes) {
                    println("${archives[archiveNumber!!].notes.indexOf(note)}. ${note.title}")

                }
                println("${archives[archiveNumber!!].notes.size}. назад")

                val input = Scanner(System.`in`).nextLine()
                if (InputChecker.checkInt(input)) {
                    if (input.toInt() == archives[archiveNumber!!].notes.size) {
                        menu.noteMenuPrint()
                    } else if (input.toInt() >= 0 && input.toInt() <= archives[archiveNumber!!].notes.size) {
                        openNote(archives[archiveNumber!!].notes[input.toInt()])
                    } else {
                        println(
                            "такой заметки не существует\n" +
                                    "---"
                        )
                        menu.noteMenuPrint()
                    }

                }
            } else {
                println(
                    "список заметок пустой\n" +
                            "---"
                )
                menu.noteMenuPrint()
            }
        }

    }

    fun openNote(note: Note) {
        println(
            "Название заметки: ${note.title}\n" +
                    "Текст заметки: ${note.text}\n" +
                    "---"
        )
        chooseNote()
    }
}
