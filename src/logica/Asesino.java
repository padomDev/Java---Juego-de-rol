package logica;

import java.util.Random;

/**
 * @author Mateo, Pepe, Feli y Pablo.
 * La clase {@code Asesino} representa un personaje de tipo asesino en el juego.
 * Hereda de la clase {@code Personaje} y añade características específicas
 * como la probabilidad de realizar un ataque crítico y el daño del ataque crítico.
 */
public class Asesino extends Personaje {

    /** El daño adicional que realiza el asesino durante un ataque crítico. */
	private double ataqueCritico;

    /** La probabilidad de que el asesino realice un ataque crítico. */
	private double probabilidadCritico;

    /** Generador de números aleatorios utilizado para calcular los ataques críticos. */
    Random random = new Random();

    /**
     * Constructor por defecto que inicializa un asesino con valores predeterminados.
     * La probabilidad de crítico y el daño crítico se inicializan en -1, y la clase se establece como "Asesino".
     */
    public Asesino() {
        super();
        ataqueCritico = -1;
        probabilidadCritico = -1;
        setClase("Asesino");
    }

    /**
     * Constructor que inicializa un asesino con los valores proporcionados.
     * 
     * @param nombre El nombre del asesino.
     * @param vitalidad La vitalidad del asesino.
     * @param ataque El valor de ataque del asesino.
     * @param probabilidadCritico La probabilidad de realizar un ataque crítico.
     * @param ataqueCritico El daño adicional del ataque crítico.
     */
    public Asesino(String nombre, double vitalidad, double ataque, double probabilidadCritico, double ataqueCritico) {
        super(nombre, vitalidad, ataque);
        this.ataqueCritico = ataqueCritico;
        this.probabilidadCritico = probabilidadCritico;
        setPuntosTotales(vitalidad + ataque + probabilidadCritico + ataqueCritico);
        setVidaActual(vitalidad*4);
        setAccion("");
        setClase("Asesino");
    }

    /**
     * Realiza un ataque al oponente. El ataque puede ser crítico dependiendo de la probabilidad de crítico.
     * 
     * @param oponente El personaje objetivo del ataque.
     * @return El daño causado al oponente.
     */
    public boolean atacar(Personaje oponente) {
        double randomCritico = random.nextDouble(101.0);
        double porcentajeCriticoProbabilidad = (probabilidadCritico*100)/getPuntosTotales();
        if (randomCritico <= porcentajeCriticoProbabilidad*1.25) {
        	double porcentajeCriticoDanio = (ataqueCritico*100)/getPuntosTotales();
            double danioCritico = getAtaque() + getAtaque()*(porcentajeCriticoDanio/100);
            return oponente.recibirAtaque(danioCritico);
        } else {
            return oponente.recibirAtaque(getAtaque());
        }
    }

    /**
     * Muestra la información detallada del asesino en la consola.
     */
    public void mostrarInfo() {
        System.out.println("|=====> " + getNombre() + " <=====|");
        System.out.println("|       Clase: " + getClase() +"   |");
        System.out.println("|       Vitalidad: " + getVitalidad() + " (" + getVitalidad()*4 + ")   |");
        System.out.println("|          Ataque: " + getAtaque() + " (" + getAtaque() + ")   |");
        System.out.println("| Probabilidad Critico: " + probabilidadCritico + " (" + ((probabilidadCritico*100)/getPuntosTotales())*1.25 + "%)   |");
        System.out.println("|    Ataque Critico: " + ataqueCritico + " (" + (ataqueCritico*100)/getPuntosTotales() + "%)   |");
        System.out.println("|==================================|");
    }

    /**
     * Devuelve el valor del daño crítico del asesino.
     * 
     * @return El daño adicional del ataque crítico.
     */
    public double getAtaqueCritico() {
        return ataqueCritico;
    }

    /**
     * Establece el valor del daño crítico del asesino.
     * 
     * @param ataqueCritico El nuevo valor de daño crítico.
     */
    public void setAtaqueCritico(double ataqueCritico) {
        this.ataqueCritico = ataqueCritico;
    }

    /**
     * Devuelve el valor de la probabilidad de ataque crítico del asesino.
     * 
     * @return La probabilidad de realizar un ataque crítico.
     */
    public double getProbabilidadCritico() {
        return probabilidadCritico;
    }

    /**
     * Establece el valor de la probabilidad de ataque crítico del asesino.
     * 
     * @param probabilidadCritico La nueva probabilidad de realizar un ataque crítico.
     */
    public void setProbabilidadCritico(double probabilidadCritico) {
        this.probabilidadCritico = probabilidadCritico;
    }
}