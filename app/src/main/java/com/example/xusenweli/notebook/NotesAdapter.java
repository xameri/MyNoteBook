package com.example.xusenweli.notebook;

/**
 * Created by Xusenweli on 5/6/2018.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class NotesAdapter extends ArrayAdapter<Notes> {

    private List<Notes> notesList;            // The list of Notes to display
    private Context context;                // The original activity that displays this
    private int layoutResource;                   // the layout to use

    /**
     *   Basic constructo
     * @param context - The activity calling this
     * @param resource  The layout to use to display
     * @param notesList  The list of Notes to display
     */
    public NotesAdapter(Context context, int resource, List<Notes> notesList) {
        super(context, resource, notesList);
        this.context = context;
        this.layoutResource = resource;
        this.notesList = notesList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the notes we are displaying
        Notes notes = notesList.get(position);
        View view;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        //view = inflater.inflate(R.layout.notes_row_layout, null);
        view = inflater.inflate(R.layout.activity_insert, null);

        EditText etextMoNotes=(EditText) view.findViewById(R.id.etNotes);
        EditText etextTitles=(EditText) view.findViewById(R.id.etTitle);
        EditText tvDate=(EditText)view.findViewById(R.id.editTextDate);
        etextMoNotes.setText(notes.getnotes());
        etextTitles.setText(notes.gettitles());
        tvDate.setText(notes.getDateCaught());

        return(view);
    }
}