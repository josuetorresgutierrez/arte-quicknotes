package com.arte.quicknotes.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.arte.quicknotes.R;
import com.arte.quicknotes.models.Note;
import com.arte.quicknotes.models.NoteListMock;

import java.util.List;

public class NoteActivity extends AppCompatActivity {
    private Note mNote;
    private EditText mTitle;
    private EditText mContent;
    private static List<Note> noteList;
    public static final String PARAM_NOTE = "param_note";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        loadNote();
        setupActivity();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_note, menu);
        if(mNote == null) {
            MenuItem delete = menu.findItem(R.id.action_delete);
            delete.setVisible(false);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void loadNote() {
        Note note = (Note) getIntent().getSerializableExtra(PARAM_NOTE);
        if (note == null) {
            return;
        }
        mTitle.setText(note.getTitulo());
        mContent.setText(note.getContenido());
        mNote = note;
    }

    private void saveNote() {
        if (mNote == null) {
            Note note = new Note();
            String title = mTitle.getText().toString();
            String content = mContent.getText().toString();
            note.setTitulo(title);
            note.setContenido(content);
            NoteListMock.addNote(note);
        } else {
            String title = mTitle.getText().toString();
            String content = mContent.getText().toString();
            mNote.setTitulo(title);
            mNote.setContenido(content);
            NoteListMock.updateNote(mNote);
        }
        finish();
    }



    private void setupActivity() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mTitle = (EditText) findViewById(R.id.et_title);
        mContent = (EditText) findViewById(R.id.et_content);
    }
}
