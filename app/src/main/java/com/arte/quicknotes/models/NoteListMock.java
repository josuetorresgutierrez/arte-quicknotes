package com.arte.quicknotes.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arte on 27/04/2016.
 */
public class NoteListMock {
    private static List<Note> noteList;
    private static int nextId = 0;
    public static List<Note> getNote() {
        createList();
        return noteList;
    }
    public static void addNote(Note note) {
        note.setId(nextId);
        noteList.add(note);
        nextId += 1;
    }
    private static void createList() {
        noteList = new ArrayList<Note>();
        for (int i = 0; i < 5; i++)  {
            Note note = new Note();
            note.setTitulo("NOte  " + (i));
            note.setContenido("que pasa eh, que pasa eh, que pasa eh, que pasa eh, que pasa eh, q" +
                    "que pasa eh, que pasa eh, que pasa eh, que pasa eh, que pasa eh, que pasa eh, " +
                    "que pasa eh, que pasa eh, que pasa eh, que pasa eh, que pasa eh, que pasa eh, " +
                    "que pasa eh, que pasa eh, que pasa eh, que pasa eh, que pasa eh, que pasa eh, " +
                    "que pasa eh, que pasa eh, que pasa eh, que pasa eh, que pasa eh, que pasa eh, " +
                    "que pasa eh, que pasa eh, que pasa eh, que pasa eh, que pasa eh, que pasa eh, ");
            noteList.add(note);
        }
    }

    public static void updateNote(Note updateNote) {
        for(int i=0; i < noteList.size(); i++) {
            Note note = noteList.get(i);
            if(note.getId() == updateNote.getId()) {
                note.setTitulo(updateNote.getTitulo());
                note.setContenido(updateNote.getContenido());
            }
        }
    }

    public static void deleteNote (Note noteDelete){
        for(int i=0; i < noteList.size(); i++) {
            Note note = noteList.get(i);
            if(note.getId() == noteDelete.getId()) {
                note.setTitulo(noteDelete.getTitulo());
                note.setContenido(noteDelete.getContenido());
            }
        }
    }
}

