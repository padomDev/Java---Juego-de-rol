package logica;

/**
 * @author Mateo, Pepe, Pablo y Feli.
 * La clase {@code Paladin} representa un personaje de tipo paladín en el juego.
 * Hereda de la clase {@code Personaje} y añade características específicas
 * como la resistencia, la cual reduce el daño recibido.
 */
public class Paladin extends Personaje {

    /** La resistencia del paladín, que reduce el daño recibido. */
    private double resistencia;

    /**
     * Constructor por defecto que inicializa un paladín con valores predeterminados.
     * La resistencia se inicializa en -1 y la clase se establece como "Paladín".
     */
    public Paladin() {
        super();
        resistencia = -1;
        setClase("Paladin");
    }

    /**
     * Constructor que inicializa un paladín con los valores proporcionados.
     * 
     * @param nombre El nombre del paladín.
     * @param vitalidad La vitalidad del paladín.
     * @param ataque El valor de ataque del paladín.
     * @param resistencia La resistencia del paladín que reduce el daño recibido.
     */
    public Paladin(String nombre, double vitalidad, double ataque, double resistencia) {
        super(nombre, vitalidad, ataque);
        this.resistencia = resistencia;
        setPuntosTotales(vitalidad + ataque + resistencia);
        setVidaActual(vitalidad*4);
        setClase("Paladin");
        setAccion("");
    }
    
	/**
     * Recibe un ataque y calcula el daño sufrido aplicando la resistencia.
     * 
     * @param Danio La cantidad de daño que el paladín podría recibir.
     * @return {@code true} siempre, ya que el paladín no esquiva el daño.
     */
    public boolean recibirAtaque(double Danio) {
    	double porcentajeResistencia = (resistencia*100)/getPuntosTotales();
        Danio = Danio - Danio*(porcentajeResistencia/100);
        setVidaActual(getVidaActual() - Danio);
        return true;
    }

    /**
     * Muestra la información detallada del paladín en la consola.
     */
    public void mostrarInfo() {
        System.out.println("|=====> " + getNombre() + " <=====|");
        System.out.println("|       Clase: " + getClase() + "   |");
        System.out.println("|   Vitalidad: " + getVitalidad() + " (" + getVitalidad()*4 + ")   |");
        System.out.println("|      Ataque: " + getAtaque() + " (" + getAtaque() + ")   |");
        System.out.println("| Resistencia: "+ getResistencia() + " (" + (getResistencia()*100)/getPuntosTotales() + "%)   |");
        System.out.println("|==================================|");
    }

    /**
     * Devuelve el valor de la resistencia del paladín.
     * 
     * @return El valor de resistencia del paladín.
     */
    public double getResistencia() {
        return resistencia;
    }

    /**
     * Establece el valor de la resistencia del paladín.
     * 
     * @param resistencia El nuevo valor de resistencia para el paladín.
     */
    public void setResistencia(double resistencia) {
        this.resistencia = resistencia;
    }
}