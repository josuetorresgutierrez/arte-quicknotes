package com.arte.quicknotes.adapters;


import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arte.quicknotes.R;
import com.arte.quicknotes.models.Note;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by arte on 27/04/2016.
 */
public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    public interface Events{
        void onNoteClicked(Note note);

    }
    private Events mEvents;
    private List<Note> mNoteList;

    public NotesAdapter (List<Note> notes, Events events) {
        mEvents = events;
        mNoteList = notes;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
// create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(NotesAdapter.ViewHolder holder, int position) {
        final Note note = mNoteList.get(position);
        holder.noteTitle.setText(note.getTitulo());
        holder.noteExcerpt.setText(note.getContenido());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(NotesAdapter.class.getSimpleName(), "Click en nota "+ note.getTitulo() );
                mEvents.onNoteClicked(note);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNoteList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView noteTitle;
        public TextView noteExcerpt;

        public ViewHolder(View itemView) {
            super(itemView);
            noteTitle = (TextView) itemView.findViewById(R.id.note_titulo);
            noteExcerpt = (TextView) itemView.findViewById(R.id.note_contenido);
        }
    }
}
