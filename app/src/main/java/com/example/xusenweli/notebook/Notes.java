package com.example.xusenweli.notebook;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by cssuser on 4/20/2017.
 */

public class Notes implements Serializable {
    private long id;
    private String notes;
    private String titles;
    private String dateCaught;

    public Notes() {
    }

  /*  public Notes(long id, String notes, String titles, String dateCaught) {
        this.id = id;
        this.notes = notes;
        this.titles = titles;
        this.dateCaught = dateCaught;

    }*/

    public Notes(String notes, String titles, String dateCaught) {
        this.notes = notes;
        this.titles = titles;
        this.dateCaught = dateCaught;

    }

    public Notes(long id, String notes, String titles, String dateCaught) {
        this.id = id;
        this.notes = notes;
        this.titles = titles;
        this.dateCaught = dateCaught;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getnotes() {
        return notes;
    }

    public void setnotes(String notes) {
        this.notes = notes;
    }

    public String gettitles() {
        return titles;
    }

    public void settitles(String titles) {
        this.titles = titles;
    }

    public String getDateCaught() {
        return dateCaught;
    }

    public void setDateCaught(String dateCaught) {
        this.dateCaught = dateCaught;
    }



    @Override
    public String toString() {
        return "Note{" +
                "notes='" + notes + '\'' +
                ", titles='" + titles + '\'' +
                ", dateCaught='" + dateCaught + '\'' +
                '}';
    }
}
