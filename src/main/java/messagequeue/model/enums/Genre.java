package messagequeue.model.enums;

public enum Genre {

    FANTASY, // Fantasy
    FICTION,   // Fiction
    ROMANCE;  // Romance

    public String getGenre() {
        return this.name();
    }
}