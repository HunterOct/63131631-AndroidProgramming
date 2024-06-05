package thi.Tuong_63131631.Dethi1;
public class Notes {
    int NoteId;
    String NoteName;
    String Description;
    //Tạo getter, setter, constructor

    public Notes(int noteId, String noteName, String description) {
        NoteId = noteId;
        NoteName = noteName;
        Description = description;
    }

    public Notes() {
    }

    public int getNoteId() {
        return NoteId;
    }

    public void setNoteId(int noteId) {
        NoteId = noteId;
    }

    public String getNoteName() {
        return NoteName;
    }

    public void setNoteName(String noteName) {
        NoteName = noteName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}

