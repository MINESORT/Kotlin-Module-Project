class Menu: ArchiveWork() {
    fun mainMenu() {
        while (true) {
            println("Выберите действие:\n1. Выбрать архив\n2. Создать архив\n3. Выход\n")
            val input = readLine()?.toIntOrNull()
            when (input) {
                1 -> {
                    selectArchive()
                }
                2 -> {
                    createArchive()
                }
                3 -> {
                    return
                }
                else -> {
                    println("Некорректный ввод. Напишите ещё раз. (вводите только те цифры, которые есть на экране)\n")
                }
            }
        }
    }

}