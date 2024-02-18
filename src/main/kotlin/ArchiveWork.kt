import java.util.Scanner

open class ArchiveWork: NoteWork(){
    fun selectArchive() {
        val scanner = Scanner(System.`in`)
        println("Доступные архивы:\n0. Создать архив")

        for (i in archives.indices) {
            val currentArchive = archives[i]
            println("${i + 1}. ${currentArchive.name}")
        }
        println("${archives.size + 1}. Назад")
        val limitIndex = scanner.nextLine()
        val input = limitIndex.toIntOrNull()
        if (input == 0) createArchive()
        else if (input?.let { it in 1..archives.size } == true) {
            browseArchive(archives[input - 1])
        } else if(input  == archives.size+1){return}else println("Некорректный ввод.(Введите цифру которая есть на экране). Напишите ещё раз.\n")

    }

     fun createArchive() {
        println("Введите имя архива:")
        val fileName = readLine()?.trim()

        if (fileName.isNullOrBlank()) {
            println("Некорректное имя архива.(строка не должна быть пустой)\n")
        } else {
            val newArchive = ArchiveData(fileName)
            archives.add(newArchive)
            println("Создан архив с именем '$fileName'!\n")
        }
    }

    private fun browseArchive(archive: ArchiveData) {
        while (true) {
            println("Выберите действие для архива '${archive.name}':\n1. Добавить заметку\n2. Просмотреть все заметки\n3. Назад")
            val userInput = readlnOrNull()
            var inputInt: Int

            try {
                inputInt = userInput!!.toInt()
            } catch (e: NumberFormatException) {
                println("Некорректный ввод. Введите целое число.\n")
                continue
            }

            when(inputInt){
                1 -> {
                    addNote(archive)
                }
                2 -> {
                    browseNotes(archive)
                }
                3 -> {
                    return
                }
                else -> {
                    println("Некорректный ввод. Попробуйте ещё раз.\n")
                }
            }
        }
    }
}