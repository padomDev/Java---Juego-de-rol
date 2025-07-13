package logica;

import java.util.Random;

/**
 * @author Mateo, Feli, Pablo y Pepe.
 * La clase {@code Arquero} representa un personaje de tipo arquero en el juego.
 * Hereda de la clase {@code Personaje} y añade características específicas
 * como la evasión y la probabilidad de esquivar ataques.
 */
public class Arquero extends Personaje {

    /** La probabilidad de evasión del arquero. */
	private double evasion;

    /** Generador de números aleatorios utilizado para calcular la evasión. */
    Random random = new Random();

    /**
     * Constructor por defecto que inicializa un arquero con valores predeterminados.
     * La evasión se inicializa en -1 y la clase se establece como "Arquero".
     */
    public Arquero() {
        super();
        evasion = -1;
        setClase("Arquero");
    }

    /**
     * Constructor que inicializa un arquero con los valores proporcionados.
     * 
     * @param nombre El nombre del arquero.
     * @param vitalidad La vitalidad del arquero.
     * @param ataque El valor de ataque del arquero.
     * @param evasion La probabilidad de evasión del arquero.
     */
    public Arquero(String nombre, double vitalidad, double ataque, double evasion) {
        super(nombre, vitalidad, ataque);
        this.evasion = evasion;
        setPuntosTotales(vitalidad + ataque + evasion);
        setVidaActual(vitalidad*4);
        setAccion("");
        setClase("Arquero");
    }

    /**
     * Determina si el arquero recibe daño o esquiva un ataque basado en su evasión.
     * 
     * @param Danio La cantidad de daño que el arquero podría recibir.
     * @return {@code true} si el arquero recibe el ataque, {@code false} si lo esquiva.
     */
    public boolean recibirAtaque(double Danio) {
        double probabilidadEsquivar = random.nextDouble(101.0);
        double porcentajeEvasion = (evasion*100)/getPuntosTotales();
        if (probabilidadEsquivar <= porcentajeEvasion) {
        	 return false;
        } else {
            setVidaActual(getVidaActual() - Danio);
            return true;
        }
    }

    /**
     * Muestra la información detallada del arquero en la consola.
     */
    public void mostrarInfo() {
        System.out.println("|=====> " + getNombre() + " <=====|");
        System.out.println("|       Clase: " + getClase() + "   |");
        System.out.println("|   Vitalidad: " + getVitalidad() + " (" + getVitalidad()*4 + ")   |");
        System.out.println("|      Ataque: " + getAtaque() + " (" + getAtaque() + ")   |");
        System.out.println("|     Evasion: "+ evasion + " (" + (evasion*100)/getPuntosTotales() + "%)   |");
        System.out.println("|==================================|");
    }

    /**
     * Devuelve la probabilidad de evasión del arquero.
     * 
     * @return El valor de evasión del arquero.
     */
    public double getEvasion() {
        return evasion;
    }

    /**
     * Establece la probabilidad de evasión del arquero.
     * 
     * @param evasion El nuevo valor de evasión para el arquero.
     */
    public void setEvasion(double evasion) {
        this.evasion = evasion;
    }
}