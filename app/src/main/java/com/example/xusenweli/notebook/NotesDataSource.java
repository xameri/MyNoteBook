package com.example.xusenweli.notebook;

/**
 * Created by Xusenweli on 5/6/2018.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tgibons on 4/20/2017.
 *
 * Provide methods for CRUD functions on the SQLite databse for the notes object
 */

public class NotesDataSource {

    // Database fields
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;

    /*
    * This method creates a new database helper that is a new MySQLHelper object with the parameter context.
    *
    * @param context This parameter is a handle to the system. Helps obtain access to databases,
    * preferences, and helps resolve resources.
     */
    public NotesDataSource(Context context) {
        dbHelper = MySQLiteHelper.getInstance(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Notes createNotes( String notes, String titles, String dateCaught) {           //Added String rating as a parameter
        ContentValues values = new ContentValues();                         // Create a new ContentValue Object
        values.put(MySQLiteHelper.COLUMN_NOTES, notes);                 // Insert a species into the COLUMN_SPECIES field using MYSQLiteHelper
        values.put(MySQLiteHelper.COLUMN_TITLES, titles);               // Insert weightInOz into the COLUMN_WEIGHT field using MYSQLiteHelper
        values.put(MySQLiteHelper.COLUMN_DATECAUGHT, dateCaught);

        long insertId = database.insert(MySQLiteHelper.TABLE_NOTES, null, values);         //  Instert the Notes into the database using the parameters above
        Notes newNotes = new Notes(insertId, notes, titles, dateCaught);
        return newNotes;
    }

   /* public Notes createNotes( String notes, String titles, String dateCaught) {           //Added String rating as a parameter
        ContentValues values = new ContentValues();                         // Create a new ContentValue Object
        values.put(MySQLiteHelper.COLUMN_NOTES, notes);                 // Insert a species into the COLUMN_SPECIES field using MYSQLiteHelper
        values.put(MySQLiteHelper.COLUMN_TITLES, titles);               // Insert weightInOz into the COLUMN_WEIGHT field using MYSQLiteHelper
        values.put(MySQLiteHelper.COLUMN_DATECAUGHT, dateCaught);


        long insertId = database.insert(MySQLiteHelper.TABLE_NOTES, null, values);         //  Instert the fish into the database using the parameters above
        Notes newNotes = new Notes(insertId, notes, titles, dateCaught);
        return newNotes;
    }*/

    public void deleteNotes(Notes notes) {
        long id = notes.getId();
        System.out.println("Notes deleted with id: " + id);
        database.delete(MySQLiteHelper.TABLE_NOTES, MySQLiteHelper.COLUMN_ID
                + " = " + id, null);
    }

    public List<Notes> getAllFotes() {
        List<Notes> notesList = new ArrayList<Notes>();

        Cursor cursor = database.query(MySQLiteHelper.TABLE_NOTES,       //Modified to return all database fields
                null, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Notes notes = cursorToNotes(cursor);
            notesList.add(notes);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        //cursor.close();
        return notesList;
    }

    /**
     *  Converts the current row in the database cursor into a notes object
     * @param cursor points to the current row in the databsae cursor
     * @return a notes object created from that row
     */
    private Notes cursorToNotes(Cursor cursor) {
        Notes notes = new Notes();
        notes.setId(cursor.getLong(cursor.getColumnIndex(MySQLiteHelper.COLUMN_ID)));
        notes.setnotes(cursor.getString(cursor.getColumnIndex(MySQLiteHelper.COLUMN_NOTES)));
        notes.settitles(cursor.getString(cursor.getColumnIndex(MySQLiteHelper.COLUMN_TITLES)));
        notes.setDateCaught(cursor.getString(cursor.getColumnIndex(MySQLiteHelper.COLUMN_DATECAUGHT)));

        return notes;
    }

}
