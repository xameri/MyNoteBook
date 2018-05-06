package com.example.xusenweli.notebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class DetailActivity extends AppCompatActivity {


    EditText editTextNotes, editTextTitle, tvDate;
    NotesDataSource notesDataSource;
    Menu menuSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle bundle = getIntent().getExtras();
        Notes notes = (Notes)   bundle.getSerializable("Notes");


        editTextNotes.setText(notes.getnotes());
        editTextTitle.setText(notes.gettitles());
        tvDate.setText(notes.getDateCaught());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else if (id == R.id.action_save){

            // link each editText variable to the xml layout
            editTextNotes = (EditText) findViewById(R.id.etNotes);
            editTextTitle = (EditText) findViewById(R.id.etTitle);
            tvDate = (EditText) findViewById(R.id.editTextDate);


            String notes = editTextNotes.getText().toString();
            String titles = editTextTitle.getText().toString();
            String dateCaught = tvDate.getText().toString();
            notesDataSource.createNotes(notes, titles, dateCaught);


        // Start up the add notes activity with an intent
            Intent detailActIntent = new Intent(getBaseContext(), InsertActivity.class);
            finish();
            startActivity(detailActIntent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }




}
