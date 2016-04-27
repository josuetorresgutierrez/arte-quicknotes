package com.arte.quicknotes.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arte on 27/04/2016.
 */
public class NoteListMock {
    private static List<Note> noteList;

    public static List<Note> getNote() {
        createList();
        return noteList;
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
}

