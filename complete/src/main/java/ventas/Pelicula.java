package ventas;

public class Pelicula {
    private String name;
    private int duration;

    public Pelicula(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }
}

