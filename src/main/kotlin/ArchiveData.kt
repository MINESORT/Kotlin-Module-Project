class ArchiveData(val name: String) {
    private val notes = mutableListOf<NoteData>()
    fun addNote(note: NoteData) {
        notes.add(note)
    }
    fun takeNotes(): List<NoteData> {
        return notes.toList()
    }
}