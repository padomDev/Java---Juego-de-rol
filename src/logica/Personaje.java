package logica;

/**
 * @author Felipe, Pepe, Mateo y Pablo.
 * La clase {@code Personaje} es una clase abstracta que representa un personaje en el juego.
 * Proporciona atributos básicos y métodos para gestionar la vitalidad, el ataque, y otras propiedades
 * comunes a todos los personajes del juego.
 */
public abstract class Personaje {

    /** El nombre del personaje. */
    private String nombre;

    /** La clase del personaje. */
    private String clase;
    
	/** La vitalidad del personaje. */
    private double vitalidad;

    /** El valor de ataque del personaje. */
    private double ataque;

    /** El total de puntos del personaje, calculado como la suma de vitalidad, ataque y otros atributos. */
    private double puntosTotales = 200;

    /** La vida actual del personaje. */
    private double vidaActual;

    /** La acción que está realizando el personaje. */
    private String accion;

    /**
     * Constructor por defecto que inicializa el personaje con valores predeterminados.
     * El nombre, clase, vitalidad, ataque, vida actual, y puntos totales se inicializan en valores predeterminados.
     */
    public Personaje() {
        nombre = "Defecto";
        clase = "Defecto";
        vitalidad = -1;
        ataque = -1;
        vidaActual = -1;
        accion = "";
        puntosTotales = -1;
    }

    /**
     * Constructor que inicializa un personaje con los valores proporcionados.
     * 
     * @param nombre El nombre del personaje.
     * @param vitalidad La vitalidad del personaje.
     * @param ataque El valor de ataque del personaje.
     */
    public Personaje(String nombre, double vitalidad, double ataque) {
        this.nombre = nombre;
        this.vitalidad = vitalidad;
        this.ataque = ataque;
        clase = "Defecto";
        vidaActual = vitalidad * 4;
        puntosTotales = vitalidad + ataque;
        accion = "";
    }

    /**
     * Recibe un ataque y reduce la vida actual del personaje en función del daño recibido.
     * 
     * @param Danio La cantidad de daño que el personaje recibe.
     * @return {@code true} siempre, ya que el personaje siempre recibe el daño.
     */
    public boolean recibirAtaque(double Danio) {
        vidaActual = vidaActual - Danio;
        return true;
    }

    /**
     * Realiza un ataque a otro personaje.
     * 
     * @param oponente El personaje objetivo del ataque.
     * @return {@code true} si el ataque se realiza correctamente, {@code false} si no (en este caso siempre {@code true}).
     */
    public boolean atacar(Personaje oponente) {
        return oponente.recibirAtaque(ataque);
    }

    /**
     * Muestra la información detallada del personaje en la consola.
     */
    public void mostrarInfo() {
        System.out.println("|=====> " + nombre + " <=====|");
        System.out.println("|       Clase: " + clase + "   |");
        System.out.println("|   Vitalidad: " + vitalidad + "   |");
        System.out.println("|      Ataque: " + ataque + "   |");
        System.out.println("|==================================|");
    }
    
    /**
     * Metodo para curar vacio, para override en Curandero.
     */
    public void curar() {}

    /**
     * Devuelve el nombre del personaje.
     * 
     * @return El nombre del personaje.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del personaje.
     * 
     * @param nombre El nuevo nombre del personaje.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la vitalidad del personaje.
     * 
     * @return La vitalidad del personaje.
     */
    public double getVitalidad() {
        return vitalidad;
    }

    /**
     * Establece la vitalidad del personaje.
     * 
     * @param vitalidad La nueva vitalidad del personaje.
     */
    public void setVitalidad(double vitalidad) {
        this.vitalidad = vitalidad;
    }

    /**
     * Devuelve el valor de ataque del personaje.
     * 
     * @return El valor de ataque del personaje.
     */
    public double getAtaque() {
        return ataque;
    }

    /**
     * Establece el valor de ataque del personaje.
     * 
     * @param ataque El nuevo valor de ataque del personaje.
     */
    public void setAtaque(double ataque) {
        this.ataque = ataque;
    }

    /**
     * Devuelve la vida actual del personaje.
     * 
     * @return La vida actual del personaje.
     */
    public double getVidaActual() {
        return vidaActual;
    }

    /**
     * Establece la vida actual del personaje.
     * 
     * @param vidaActual La nueva vida actual del personaje.
     */
    public void setVidaActual(double vidaActual) {
        this.vidaActual = vidaActual;
    }

    /**
     * Devuelve la acción que está realizando el personaje.
     * 
     * @return La acción actual del personaje.
     */
    public String getAccion() {
        return accion;
    }

    /**
     * Establece la acción que está realizando el personaje.
     * 
     * @param accion La nueva acción que el personaje está realizando.
     */
    public void setAccion(String accion) {
        this.accion = accion;
    }
    
    /**
     * Devuelve la clase del personaje.
     * 
     * @return La clase del personaje.
     */
    public String getClase() {
        return clase;
    }

    /**
     * Establece la clase del personaje.
     * 
     * @param clase La nueva clase del personaje.
     */
    public void setClase(String clase) {
        this.clase = clase;
    }
    
    /**
     * Devuelve los puntos totales del personaje.
     * 
     * @return Los puntos totales del personaje.
     */
	public double getPuntosTotales() {
		return puntosTotales;
	}
	
    /**
     * Establece la cantidad de puntos totales del personaje.
     * 
     * @param puntosTotales La nueva cantidad de puntos totales del personaje.
     */
	public void setPuntosTotales(double puntosTotales) {
		this.puntosTotales = puntosTotales;
	}
}