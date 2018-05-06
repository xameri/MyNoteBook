package com.example.xusenweli.notebook;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InsertActivity extends AppCompatActivity {

    EditText editTextNotes, editTextTitle, tvDate;
    NotesDataSource notesDataSource;
    Menu menuSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        notesDataSource = new NotesDataSource(this);
        notesDataSource.open();

        // link each editText variable to the xml layout
        editTextNotes = (EditText) findViewById(R.id.etNotes);
        editTextTitle = (EditText) findViewById(R.id.etTitle);
        tvDate = (EditText) findViewById(R.id.editTextDate);

                // Add the notes to the database
                String notes = editTextNotes.getText().toString();
                String titles = editTextTitle.getText().toString();
                String dateCaught = tvDate.getText().toString();
                notesDataSource.createNotes(notes, titles, dateCaught);

                //notesDataSource.createNotes(species, weight, dateCaught, lattitude.toString(), longiture.toString());
             /*   Intent mainActIntent = new Intent(view.getContext(), MainActivity.class);
                finish();
                startActivity(mainActIntent);*/


    }

    @Override
    protected void onResume() {
        notesDataSource.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        notesDataSource.close();
        super.onPause();
    }
}

