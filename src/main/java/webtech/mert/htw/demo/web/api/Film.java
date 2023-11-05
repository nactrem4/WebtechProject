package webtech.mert.htw.demo.web.api;

public class Film {

    private long id;
    private String filmName;
    private String filmBeschreibung;

    public Film(long id, String filmname, String filmBeschreibung) {
        this.id = id;
        this.filmBeschreibung = filmBeschreibung;
        this.filmName = filmname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmBeschreibung() {
        return filmBeschreibung;
    }

    public void setFilmBeschreibung(String filmBeschreibung) {
        this.filmBeschreibung = filmBeschreibung;
    }
}
