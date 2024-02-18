open class NoteWork {
    val archives = mutableListOf<ArchiveData>()
     fun addNote(archive: ArchiveData) {
        var noteName: String
        var content : String
        do{
            println("Введите название заметки:")
             noteName = readln().trim()
            if (noteName.isBlank()){
                println("Некорректный ввод. Заметка не должна быть пустой.\n")
            }
        }
        while(noteName.isBlank())

        do{
            println("Введите содержимое заметки:")
            content = readln().trim()
            if (content.isBlank()){
                println("Некорректный ввод. Содержимое заметки не должна быть пустой.\n")
            }
        }
        while(content.isBlank())

        val note = NoteData(noteName, content)
        archive.addNote(note)
        println("Заметка '$noteName' и текстом '$content' добавлена в архив '${archive.name}'.\n")
    }

     fun browseNotes(archive: ArchiveData) {
        val notes = archive.takeNotes()

        if (notes.isEmpty()) {
            println("В архиве '${archive.name}' нет заметок.\n")
        } else {
            println("Примечания в архиве '${archive.name}':")
            notes.forEachIndexed { i, note ->
                println("${i + 1}. Заметка: ${note.noteName}, а также ее содержимое: ${note.content}")
            }
        }
        println("")
    }
}