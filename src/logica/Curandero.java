package logica;

/**
 * @author Pepe, Pablo, Feli y Mateo.
 * La clase {@code Curandero} representa un personaje de tipo curandero en el juego.
 * Hereda de la clase {@code Personaje} y añade una capacidad de curación para restaurar vida.
 */
public class Curandero extends Personaje {

    /** La cantidad de vida que el curandero puede restaurar. */
    private double curacion;

    /**
     * Constructor por defecto que inicializa un curandero con valores predeterminados.
     * La curación se inicializa en -1 y la clase se establece como "Curandero".
     */
    public Curandero() {
        super();
        curacion = -1;
        setClase("Curandero");
    }

    /**
     * Constructor que inicializa un curandero con los valores proporcionados.
     * 
     * @param nombre El nombre del curandero.
     * @param vitalidad La vitalidad del curandero.
     * @param ataque El valor de ataque del curandero.
     * @param curacion La cantidad de vida que el curandero puede restaurar.
     */
    public Curandero(String nombre, double vitalidad, double ataque, double curacion) {
        super(nombre, vitalidad, ataque);
        this.curacion = curacion;
        setPuntosTotales(vitalidad + ataque + curacion);
        setVidaActual(getVitalidad()*4);
        setClase("Curandero");
        setAccion("");
    }

    /**
     * Restaura la vida del curandero en función de su capacidad de curación.
     */
    public void curar() {
        setVidaActual(getVidaActual() + curacion);
    }

    /**
     * Muestra la información detallada del curandero en la consola.
     */
    public void mostrarInfo() {
        System.out.println("|=====> " + getNombre() + " <=====|");
        System.out.println("|       Clase: " + getClase() + "   |");
        System.out.println("|   Vitalidad: " + getVitalidad() + " (" + getVitalidad()*4 + ")   |");
        System.out.println("|      Ataque: " + getAtaque() + " (" + getAtaque() + ")   |");
        System.out.println("|    Curacion: "+ getCuracion() + " (" + getCuracion() + ")   |");
        System.out.println("|==================================|");
    }

    /**
     * Devuelve el valor de curación del curandero.
     * 
     * @return El valor de curación del curandero.
     */
    public double getCuracion() {
        return curacion;
    }

    /**
     * Establece el valor de curación del curandero.
     * 
     * @param curacion El nuevo valor de curación para el curandero.
     */
    public void setCuracion(double curacion) {
        this.curacion = curacion;
    }
}