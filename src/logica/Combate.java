package logica;

import java.util.Date;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

/**
 * @author Pepe y Feli.
 * Clase abstracta que representa un combate entre dos personajes.
 */
public abstract class Combate {
	private Personaje jugador1;
	private Personaje jugador2;
	private String fecha;
    private String tipoPartida;
    private String ganador;
    private ArrayList<String> eventos;
    
    /**
     * Constructor por defecto que inicializa los atributos con valores predeterminados.
     */
    Combate() {
    	jugador1 = null;
    	jugador2 = null;
    	fecha = null;
    	tipoPartida = "Defecto";
    	ganador = "Empate";
    	eventos = new ArrayList<String>();
    }
    
    /**
     * Constructor que inicializa la fecha y el tipo de partida.
     * 
     * @param fecha La fecha del combate.
     * @param tipoPartida El tipo de partida.
     */
    Combate(String tipoPartida) {
        this.tipoPartida = tipoPartida;
        this.eventos = new ArrayList<String>(eventos);
    }
    
    /**
     * Asigna un nombre a un personaje.
     * 
     * @param entrada Un objeto Scanner para leer la entrada del usuario.
     * @return El nombre asignado al personaje.
     */
	public String asignarNombrePersonaje(Scanner entrada) {
		System.out.println("|==> Asignar nombre de personaje <==|");
		getEventos().add("|==> Asignar nombre de personaje <==|");
		String nombrePersonaje = entrada.next();
		getEventos().add(nombrePersonaje);
		return nombrePersonaje;
	}
	
    /**
     * Asigna puntos libres a un atributo del personaje.
     * 
     * @param atributoNombre El nombre del atributo al que se asignarán los puntos.
     * @param entrada Un objeto Scanner para leer la entrada del usuario.
     * @return La cantidad de puntos asignados.
     */
	public double asignarPuntosPersonaje(String atributoNombre, Scanner entrada) {
		System.out.println("|=> Asignar puntos libres a " + atributoNombre + " <=|");
		getEventos().add("|=> Asignar puntos libres a " + atributoNombre + " <=|");
		double pla = entrada.nextDouble();
		getEventos().add(String.valueOf(pla));
		System.out.println("| " + pla + " puntos libres han sido asignados a " + atributoNombre + " |");
		getEventos().add("| " + pla + " puntos libres han sido asignados a " + atributoNombre + " |");
		return pla;
	}
	
    /**
     * Crea un personaje basado en la elección del usuario.
     * 
     * @param entrada Un objeto Scanner para leer la entrada del usuario.
     * @return El personaje creado.
     */
	public Personaje crearPersonaje(Scanner entrada) {
		String nombre;
		double ataque, vitalidad;
		System.out.println("|==>  Creacion de Personaje <==|");
		getEventos().add("|==>  Creacion de Personaje <==|");
		System.out.println("|           1. Paladin         |");
		getEventos().add("|           1. Paladin         |");
		System.out.println("|           2. Arquero         |");
		getEventos().add("|           2. Arquero         |");
		System.out.println("|           3. Asesino         |");
		getEventos().add("|           3. Asesino         |");
		System.out.println("|          4. Curandero        |");
		getEventos().add("|          4. Curandero        |");
		System.out.println("|==============================|");
		getEventos().add("|==============================|");
		int clop = entrada.nextInt();
		getEventos().add(String.valueOf(clop));
		switch(clop) {
		// ------------------------------- Paladin -------------------------------
			case 1:
				double resistencia;
				
				
				nombre = asignarNombrePersonaje(entrada);
				
				vitalidad = asignarPuntosPersonaje("vitalidad", entrada);
				ataque = asignarPuntosPersonaje("ataque", entrada);
				resistencia = asignarPuntosPersonaje("resistencia", entrada);
				
				Personaje paladin = new Paladin(nombre, vitalidad, ataque, resistencia);
			return paladin;
			// ------------------------------- Arquero -------------------------------
			case 2:
				double evasion;
				
				nombre = asignarNombrePersonaje(entrada);
				vitalidad = asignarPuntosPersonaje("vitalidad", entrada);
				ataque = asignarPuntosPersonaje("ataque", entrada);
				evasion = asignarPuntosPersonaje("evasion", entrada);
				
				Personaje arquero = new Arquero(nombre, vitalidad, ataque, evasion);
				arquero.mostrarInfo();
			return arquero;
			// ------------------------------- Asesino -------------------------------
			case 3:
				double probabilidadCritico, ataqueCritico;
				
				nombre = asignarNombrePersonaje(entrada);
				vitalidad = asignarPuntosPersonaje("vitalidad", entrada);
				ataque = asignarPuntosPersonaje("ataque", entrada);
				probabilidadCritico = asignarPuntosPersonaje("probabilidad critico", entrada);
				ataqueCritico = asignarPuntosPersonaje("ataque critico", entrada);
				
				Personaje asesino = new Asesino(nombre, vitalidad, ataque, probabilidadCritico, ataqueCritico);
			return asesino;
			// ------------------------------- Curandero -------------------------------
			case 4:
				double curacion;
				
				nombre = asignarNombrePersonaje(entrada);
				vitalidad = asignarPuntosPersonaje("vitalidad", entrada);
				ataque = asignarPuntosPersonaje("ataque", entrada);
				curacion = asignarPuntosPersonaje("curacion", entrada);
				
				Personaje curandero = new Curandero(nombre, vitalidad, ataque, curacion);
			return curandero;
			// ------------------------------- Default (Paladin) -------------------------------
			default:
				double resistenciaD;
				
				nombre = asignarNombrePersonaje(entrada);
				vitalidad = asignarPuntosPersonaje("vitalidad", entrada);
				ataque = asignarPuntosPersonaje("ataque", entrada);
				resistenciaD = asignarPuntosPersonaje("resistencia", entrada);
				
				Personaje paladinD = new Paladin(nombre, vitalidad, ataque, resistenciaD);
			return paladinD;
		}
	}
	
    /**
     * Permite al jugador elegir una acción durante el combate.
     * 
     * @param personaje El personaje que debe elegir una acción.
     * @param entrada Un objeto Scanner para leer la entrada del usuario.
     */
	public void jugadorCombateOpcion(Personaje personaje, Scanner entrada) {
		if (personaje.getClase() == "Curandero") {
			System.out.println("|=====> Elegir Accion <====|");
			getEventos().add("|=====> Elegir Accion <====|");
			System.out.println("|         1. Atacar        |");
			getEventos().add("|         1. Atacar        |");
			System.out.println("|        2. Bloquear       |");
			getEventos().add("|        2. Bloquear       |");
			System.out.println("|         3. Curar         |");
			getEventos().add("|         3. Curar         |");
			System.out.println("|==========================|");
			getEventos().add("|==========================|");
			int swop = entrada.nextInt();
			getEventos().add(String.valueOf(swop));
			switch(swop) {
				case 1:
					personaje.setAccion("Atacar");
				break;
				case 2:
					personaje.setAccion("Bloquear");
				break;
				case 3:
					personaje.setAccion("Curar");
				break;
				default:
					personaje.setAccion("Bloquear");
				break;
			}
		} else {
			System.out.println("|=====> Elegir Accion <====|");
			getEventos().add("|=====> Elegir Accion <====|");
			System.out.println("|         1. Atacar        |");
			getEventos().add("|         1. Atacar        |");
			System.out.println("|        2. Bloquear       |");
			getEventos().add("|        2. Bloquear       |");
			System.out.println("|==========================|");
			getEventos().add("|==========================|");
			int swop = entrada.nextInt();
			getEventos().add(String.valueOf(swop));
			switch(swop) {
			case 1:
				personaje.setAccion("Atacar");
			break;
			case 2:
				personaje.setAccion("Bloquear");
			break;
			default:
				personaje.setAccion("Bloquear");
			break;
			}
		}
	}
	
	/**
	 * Método que genera un random para utilizar un switch que muestra distintos tipos de mensajes
	 * para simplemente darle un toque de carisma a las partidas.
	 * @param jugador1 Nombre del jugador 1.
	 * @param jugador2 Nombre del jugador 2.
	 * @param random Un objeto Random para generar un número entre 1 y 5.
	 */
	
	public void mostrarMensajeInicioCombate(Personaje jugador1, Personaje jugador2, Random random) {
		int swop = random.nextInt(5)+1;
		switch(swop) {
			case 1:
				System.out.println(jugador1.getNombre() + " avanzó en la penumbra del bosque marchito, cuando de repente " + jugador2.getNombre() + ", una sombra de ojos brillantes y dientes afilados, emergió entre los árboles muertos, hambriento de carne fresca.");
				getEventos().add(jugador1.getNombre() + " avanzó en la penumbra del bosque marchito, cuando de repente " + jugador2.getNombre() + ", una sombra de ojos brillantes y dientes afilados, emergió entre los árboles muertos, hambriento de carne fresca.");
			break;
			case 2:
				System.out.println(jugador1.getNombre() + " sintió una presencia detrás al cruzar el puente roto sobre el abismo. Girándose lentamente, descubrió a " + jugador2.getNombre() + ", un caballero caído cuya armadura oxidada goteaba con el eco de maldiciones antiguas.");
				getEventos().add(jugador1.getNombre() + " sintió una presencia detrás al cruzar el puente roto sobre el abismo. Girándose lentamente, descubrió a " + jugador2.getNombre() + ", un caballero caído cuya armadura oxidada goteaba con el eco de maldiciones antiguas.");
			break;
			case 3:
				System.out.println(jugador1.getNombre() + " caminaba entre las ruinas de un pueblo desierto, cuando " + jugador2.getNombre() + ", un ser compuesto de huesos reanimados y retorcidos, se alzó de las cenizas, con el odio de mil almas atrapadas en su mirada.");
				getEventos().add(jugador1.getNombre() + " caminaba entre las ruinas de un pueblo desierto, cuando " + jugador2.getNombre() + ", un ser compuesto de huesos reanimados y retorcidos, se alzó de las cenizas, con el odio de mil almas atrapadas en su mirada.");
			break;
			case 4:
				System.out.println("La caverna oscura y húmeda retumbó con un gruñido profundo, y " + jugador1.getNombre() + " apenas tuvo tiempo de desenvainar su espada antes de que " + jugador2.getNombre() + ", un lobo humanoide y demoníaco con ojos carmesí, se abalanzara desde las sombras.");
				getEventos().add("La caverna oscura y húmeda retumbó con un gruñido profundo, y " + jugador1.getNombre() + " apenas tuvo tiempo de desenvainar su espada antes de que " + jugador2.getNombre() + ", un lobo humanoide y demoníaco con ojos carmesí, se abalanzara desde las sombras.");
			break;
			case 5:
				System.out.println("Al abrir la puerta de la antigua cripta, " + jugador1.getNombre() + " se encontró cara a cara con " + jugador2.getNombre() + ", una figura encapuchada cuya piel se descomponía lentamente, mientras una risa maldita escapaba de su garganta.");
				getEventos().add("Al abrir la puerta de la antigua cripta, " + jugador1.getNombre() + " se encontró cara a cara con " + jugador2.getNombre() + ", una figura encapuchada cuya piel se descomponía lentamente, mientras una risa maldita escapaba de su garganta.");
			break;
			default:
				System.out.println(jugador1.getNombre() + " descendió a las catacumbas, donde el aire estaba cargado de podredumbre. Al fondo del pasillo oscuro, " + jugador2.getNombre() + " se levantaba lentamente, una aberración de carne y sombras que susurraba antiguas maldiciones en lenguas olvidadas.");
				getEventos().add(jugador1.getNombre() + " descendió a las catacumbas, donde el aire estaba cargado de podredumbre. Al fondo del pasillo oscuro, " + jugador2.getNombre() + " se levantaba lentamente, una aberración de carne y sombras que susurraba antiguas maldiciones en lenguas olvidadas.");
			break;
		}
		System.out.println("|=================> La batalla comienza <=================|");
		getEventos().add("|=================> La batalla comienza <=================|");
		System.out.println(jugador1.getNombre() + " se enfrenta en batalla contra " + jugador2.getNombre());
		getEventos().add(jugador1.getNombre() + " se enfrenta en batalla contra " + jugador2.getNombre());
		System.out.println("|=========================================================|");
		getEventos().add("|=========================================================|");
	}
	
	/**
	 * Método que muestra la vida de cada jugador en determinado momento de la partida.
	 * @param jugador1 Nombre de jugador 1.
	 * @param jugador2 Nombre de jugador 2.
	 * @param turnoN Número del turno.
	 */
	
	public void mostrarJugadoresVida(Personaje jugador1, Personaje jugador2, int turnoN) {
		System.out.println("|============> Turno " + turnoN + " <============|");
		getEventos().add("|============> Turno " + turnoN + " <============|");
		System.out.println("|== " + jugador1.getNombre() + ": " + jugador1.getVidaActual() + "HP ==|");
		getEventos().add("|== " + jugador1.getNombre() + ": " + jugador1.getVidaActual() + "HP ==|");
		System.out.println("|== " + jugador2.getNombre() + ": " + jugador2.getVidaActual() + "HP ==|");
		getEventos().add("|== " + jugador2.getNombre() + ": " + jugador2.getVidaActual() + "HP ==|");
		System.out.println("|================================================|");
		getEventos().add("|================================================|");
	}
	
	/**
	 * Método que setea al jugador que gana la partida y muestra un mensaje para darle carisma al programa.
	 * @param ganador El ganador de la partida.
	 * @param turnoN Número del turno.
	 */
	
	public void definirGanador(String ganador, int turnoN) {
		setGanador(ganador);
	    System.out.println("|============> FIN DE LA BATALLA - TURNO " + turnoN + " <============|");
	    System.out.println(ganador + " supo defenderse de la tiranía de su enemigo. Reinará sobre el mundo durante generaciones.");
	    getEventos().add("|============> FIN DE LA BATALLA - TURNO " + turnoN + " <============|");
	    getEventos().add(ganador + " supo defenderse de la tiranía de su enemigo. Reinará sobre el mundo durante generaciones.");
	    System.out.println("|==           " + ganador + " HA SALIDO VICTORIOSO           ==|");
	    getEventos().add("|==           " + ganador + " HA SALIDO VICTORIOSO           ==|");
	    System.out.println("|====================================================================|");
	    getEventos().add("|====================================================================|");
	}
 
	/**
	 * @return Devuelve la fecha.
	 */
	
	public String getFecha() {
		return fecha;
	}

	/**
	 * Setea la fecha de la partida.
	 * @param fecha Atributo de tipo String que guarda la fecha de la partida.
	 */
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * Devuelve el tipo de la partida.
	 * @return PvE o PvP.
	 */
	
	public String getTipoPartida() {
		return tipoPartida;
	}

	/**
	 * Setea el tipo de partida.
	 * @param tipoPartida Guarda el tipo de partida.
	 */
	
	public void setTipoPartida(String tipoPartida) {
		this.tipoPartida = tipoPartida;
	}
	
	/**
	 * @return Devuelve el ganador de la partida.
	 */

	public String getGanador() {
		return ganador;
	}
	
	/**
	 * Setea el ganador de la partida.
	 * @param ganador Guarda el ganador de la partida.
	 */

	public void setGanador(String ganador) {
		this.ganador = ganador;
	}
	
    /**
     * Obtiene la lista de eventos del combate.
     * 
     * @return La lista de eventos.
     */
	public ArrayList<String> getEventos() {
		return eventos;
	}

	/**
	 * Setea la lista de eventos de la partida.
	 * @param eventos Guarda los eventos de la partida.
	 */
	
	public void setEventos(ArrayList<String> eventos) {
		this.eventos = eventos;
	}
	
	/**
	 * @return Devuelve al jugador 1.
	 */

	public Personaje getJugador1() {
		return jugador1;
	}
	
	/**
	 * Setea al jugador 1.
	 * @param jugador1 Guarda al jugador 1.
	 */

	public void setJugador1(Personaje jugador1) {
		this.jugador1 = jugador1;
	}
	
	/**
	 * @return Devuelve al jugador 2.
	 */

	public Personaje getJugador2() {
		return jugador2;
	}
	
	/**
	 * Setea al jugador 2.
	 * @param jugador2 Guarda al jugador 2.
	 */

	public void setJugador2(Personaje jugador2) {
		this.jugador2 = jugador2;
	}
	
	/**
	 * Método para mostrar un resumen de cada partida jugada.
	 * @return Devuelve la fecha, el tipo de partida y el ganador.
	 */
	
    public String getResumen() {
        return fecha + " - " + tipoPartida + " - " + ganador;
    }
    
    /**
     * Simplica y genera la fecha de la partida.
     */

    public void establecerFecha() {
    	 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    	    Date date = new Date();
    	    setFecha(formatter.format(date));
    }
    
   /**
    * Muestra a detalle la partida que quiera el usuario.
    */

    public void mostrarDetalle() {
        System.out.println("Fecha: " + fecha);
        System.out.println("Tipo de Partida: " + tipoPartida);
        System.out.println("Resultado: " + ganador);
        System.out.println("Eventos:");
        for (String evento : eventos) {
            System.out.println(evento);
        }
    }
}
