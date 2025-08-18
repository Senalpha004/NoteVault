package noteVault;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class NoteManager {
    //fields
    //creating a list to save the details and the title of each note
    private List<Note> notes;
    private final File file = new File("note.json");
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    //constructor to load notes on startup
    public NoteManager() {
        notes = new ArrayList<>();
        loadNotesFromFile();
    }

    //core methods of note vault (creating method classes for each function)
    //adding a note
    public void addNote(Note note) {
        notes.add(note);
        saveNotesToFile();
    }

    //view all notes
    public List<Note> getAllNotes() {
        return notes;
    }

    //Search notes by keyword
    public List<Note> searchNotes(String keyword) {
        return notes.stream().filter(
                n -> n.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                        n.getContent().toLowerCase().contains(keyword.toLowerCase())
        ).toList();
    }

    //delete notes by the title
    public boolean deleteNote(String title) {
        boolean removed = notes.removeIf(n -> n.getTitle().equalsIgnoreCase(title));
        if (removed) {
            saveNotesToFile();
            System.out.println("Note Deleted");
        } else System.out.println("Note Not Found to Delete. Maybe Check Spellings");
        return removed;
    }

    //file handling of saving and loading notes
    public void saveNotesToFile() {
        try(FileWriter writer = new FileWriter(file)){
            gson.toJson(notes, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadNotesFromFile(){
        if (!file.exists()) return;

        try (FileReader reader = new FileReader(file)){
            Type noteListType = new TypeToken<List<Note>>() {}.getType();
            notes = gson.fromJson(reader,noteListType);
            if (notes == null) notes = new ArrayList<>();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
