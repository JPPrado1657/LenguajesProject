package ventas;

import java.util.Date;

public class Init {
    private int n;
    private Sala[] salas;
    private static Funcion[] funciones;
    private static Init instance = null;

    private Init() {
        n = 5;
        salas = new Sala[n];
        for (int i = 0; i < n; i++) {
            salas[i] = new Sala(5, 5, i);
        }
        Pelicula[] peliculas = new Pelicula[n];
        peliculas[0] = new Pelicula("Batman", 180);
        peliculas[1] = new Pelicula("The boy and the beast", 90);
        peliculas[2] = new Pelicula("Howl's Moving Castle", 160);
        peliculas[3] = new Pelicula("New Hope", 210);
        peliculas[4] = new Pelicula("Los Locos Adams", 67);
        Date date = new Date();
        funciones = new Funcion[n];
        for (int i = 0; i < n; i++) {
            funciones[i] = new Funcion(salas[i], peliculas[i], date);
        }
    }

    public Sala[] getSalas() {
        return salas;
    }

    public static Funcion[] getFunciones() {
        return funciones;
    }

    public static Init getInstance() {
        if (instance == null) {
            synchronized (Init.class) {
                if (instance == null) {
                    instance = new Init();
                }
            }
        }
        return instance;
    }
}