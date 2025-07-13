package logica;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Mateo y Pablo.
 * Clase que gestiona un combate entre dos personajes controlados por dos jugadores.
 */

public class CombatePvP extends Combate {
	Random random = new Random();
	Scanner entrada = new Scanner (System.in);
	
	/**
	 * Constructor por defecto.
	 */
	
   public CombatePvP() {
    	setJugador1(null);
    	setJugador2(null);
    	setFecha(null);
    	setTipoPartida("PvP");
    	setJugador1(null);
    	setEventos( new ArrayList<String>()) ;
    }

    /**
     * Permite elegir entre cara o cruz en una moneda y determina si la elección fue correcta.
     * 
     * @param entrada Un objeto Scanner para leer la entrada del usuario.
     * @param random Un objeto Random para generar un resultado aleatorio.
     * @return true si la elección del usuario es correcta, false en caso contrario.
     */
	public boolean chanceMoneda(Scanner entrada, Random random) {
		System.out.println("|==> Jugador 1, Elija Cara Moneda <==|");
		getEventos().add("|==> Jugador 1, Elija Cara Moneda <==|");
		System.out.println("|              1. Cara               |");
		getEventos().add("|              1. Cara               |");
		System.out.println("|              2. Cruz               |");
		getEventos().add("|              2. Cruz               |");
		System.out.println("|====================================|");
		getEventos().add("|====================================|");
		int mdop = entrada.nextInt();
		getEventos().add(String.valueOf(mdop));
		int caraMoneda = random.nextInt(2)+1;
		if (caraMoneda == mdop) {
			System.out.println("|======> Jugador 1 Empieza <======|");
			getEventos().add("|======> Jugador 1 Empieza <======|");
			return true;
		} else {
			System.out.println("|======> Jugador 2 Empieza <======|");
			getEventos().add("|======> Jugador 2 Empieza <======|");
			return false;
		}
	}

	/**
	 * Inicia el combate entre los dos jugadores.
	 */
	
	public void iniciarCombate() {
		int turnoN = 1;
		establecerFecha();
		boolean monedaResultado = chanceMoneda(entrada, random);
		if (monedaResultado == true) {
			System.out.println("|======> Jugador 1 Cree su personaje <======|");
			getEventos().add("|======> Jugador 1 Cree su personaje <======|");
			setJugador1(crearPersonaje(entrada));
			System.out.println("|======> Jugador 2 Cree su personaje <======|");
			getEventos().add("|======> Jugador 2 Cree su personaje <======|");
			setJugador2(crearPersonaje(entrada));
		} else {
			System.out.println("|======> Jugador 2 Cree su personaje <======|");
			getEventos().add("|======> Jugador 2 Cree su personaje <======|");
			setJugador2(crearPersonaje(entrada));
			System.out.println("|======> Jugador 1 Cree su personaje <======|");
			getEventos().add("|======> Jugador 1 Cree su personaje <======|");
			setJugador1(crearPersonaje(entrada));
		}
		getJugador1().mostrarInfo();
		getJugador2().mostrarInfo();
		System.out.println("");
		getEventos().add("");
		System.out.println("");
		getEventos().add("");
		if (monedaResultado == true) {
			mostrarMensajeInicioCombate(getJugador1(), getJugador2(), random);
		} else {
			mostrarMensajeInicioCombate(getJugador2(), getJugador1(), random);
		}
		while (getJugador1().getVidaActual() > 0.0 && getJugador2().getVidaActual() > 0.0) {
			System.out.println("");
			getEventos().add("");
			System.out.println("");
			getEventos().add("");
			mostrarJugadoresVida(getJugador1(), getJugador2(), turnoN);
			if (monedaResultado == true) {
				jugadorCombateOpcion(getJugador1(), entrada);
				jugadorCombateOpcion(getJugador2(), entrada);
				System.out.println(getJugador1().getNombre() + ": " + getJugador1().getAccion());
				getEventos().add(getJugador1().getNombre() + ": " + getJugador1().getAccion());
				System.out.println(getJugador2().getNombre() + ": " + getJugador2().getAccion());
				getEventos().add(getJugador2().getNombre() + ": " + getJugador2().getAccion());
			} else {
				jugadorCombateOpcion(getJugador2(), entrada);
				jugadorCombateOpcion(getJugador1(), entrada);
				System.out.println(getJugador2().getNombre() + ": " + getJugador2().getAccion());
				getEventos().add(getJugador2().getNombre() + ": " + getJugador2().getAccion());
				System.out.println(getJugador1().getNombre() + ": " + getJugador1().getAccion());
				getEventos().add(getJugador1().getNombre() + ": " + getJugador1().getAccion());
			}
			
			if (getJugador1().getAccion() == "Bloquear" && getJugador2().getAccion() == "Atacar") {
			    System.out.println("| " + getJugador2().getNombre() + " ha atacado a " + getJugador1().getNombre() + ", pero " + getJugador1().getNombre() + " ha bloqueado el ataque  |");
			    getEventos().add("| " + getJugador2().getNombre() + " ha atacado a " + getJugador1().getNombre() + ", pero " + getJugador1().getNombre() + " ha bloqueado el ataque  |");
			} else if (getJugador1().getAccion() == "Atacar" && getJugador2().getAccion() == "Bloquear") {
			    System.out.println("| " + getJugador1().getNombre() + " ha atacado a " + getJugador2().getNombre() + ", pero " + getJugador2().getNombre() + " ha bloqueado el ataque  |");
			    getEventos().add("| " + getJugador1().getNombre() + " ha atacado a " + getJugador2().getNombre() + ", pero " + getJugador2().getNombre() + " ha bloqueado el ataque  |");
			} else if (getJugador1().getAccion() == "Atacar" && getJugador2().getAccion() == "Atacar") {
			    boolean ataqueJ1 = getJugador1().atacar(getJugador2());
			    boolean ataqueJ2 = getJugador2().atacar(getJugador1());
			    
			    if (ataqueJ1 == true && ataqueJ2 == true) {
			        System.out.println("| " + getJugador1().getNombre() + " y " + getJugador2().getNombre() + " se han atacado al mismo tiempo |");
			        getEventos().add("| " + getJugador1().getNombre() + " y " + getJugador2().getNombre() + " se han atacado al mismo tiempo |");
			    } else if (ataqueJ1 == true && ataqueJ2 == false) {
			        System.out.println("| " + getJugador1().getNombre() + " y " + getJugador2().getNombre() + " se han atacado al mismo tiempo, pero " + getJugador1().getNombre() + " ha esquivado el ataque |");
			        getEventos().add("| " + getJugador1().getNombre() + " y " + getJugador2().getNombre() + " se han atacado al mismo tiempo, pero " + getJugador1().getNombre() + " ha esquivado el ataque |");
			    } else if (ataqueJ1 == false && ataqueJ2 == true) {
			        System.out.println("| " + getJugador1().getNombre() + " y " + getJugador2().getNombre() + " se han atacado al mismo tiempo, pero " + getJugador2().getNombre() + " ha esquivado el ataque |");
			        getEventos().add("| " + getJugador1().getNombre() + " y " + getJugador2().getNombre() + " se han atacado al mismo tiempo, pero " + getJugador2().getNombre() + " ha esquivado el ataque |");
			    } else if (ataqueJ1 == false && ataqueJ2 == false) {
			        System.out.println("| " + getJugador1().getNombre() + " y " + getJugador2().getNombre() + " se han atacado al mismo tiempo, pero ambos han esquivado el ataque |");
			        getEventos().add("| " + getJugador1().getNombre() + " y " + getJugador2().getNombre() + " se han atacado al mismo tiempo, pero ambos han esquivado el ataque |");
			    }
			} else if (getJugador1().getAccion() == "Bloquear" && getJugador2().getAccion() == "Bloquear") {
			    System.out.println("| " + getJugador1().getNombre() + " y " + getJugador2().getNombre() + " han bloqueado al mismo tiempo |");
			    getEventos().add("| " + getJugador1().getNombre() + " y " + getJugador2().getNombre() + " han bloqueado al mismo tiempo |");
			} else if (getJugador1().getAccion() == "Bloquear" && getJugador2().getAccion() == "Curar") {
			    getJugador2().curar();
			    System.out.println("| " + getJugador1().getNombre() + " ha bloqueado y " + getJugador2().getNombre() + " ha utilizado sus poderes curativos |");
			    getEventos().add("| " + getJugador1().getNombre() + " ha bloqueado y " + getJugador2().getNombre() + " ha utilizado sus poderes curativos |");
			} else if (getJugador1().getAccion() == "Atacar" && getJugador2().getAccion() == "Curar") {
			    getJugador1().atacar(getJugador2());
			    getJugador2().curar();
			    System.out.println("| " + getJugador1().getNombre() + " ha atacado y " + getJugador2().getNombre() + " ha utilizado sus poderes curativos |");
			    getEventos().add("| " + getJugador1().getNombre() + " ha atacado y " + getJugador2().getNombre() + " ha utilizado sus poderes curativos |");
			} else if (getJugador1().getAccion() == "Curar" && getJugador2().getAccion() == "Bloquear") {
			    getJugador1().curar();
			    System.out.println("| " + getJugador1().getNombre() + " ha utilizado sus poderes curativos y " + getJugador2().getNombre() + " ha bloqueado |");
			    getEventos().add("| " + getJugador1().getNombre() + " ha utilizado sus poderes curativos y " + getJugador2().getNombre() + " ha bloqueado |");
			} else if (getJugador1().getAccion() == "Curar" && getJugador2().getAccion() == "Atacar") {
			    getJugador1().curar();
			    getJugador2().atacar(getJugador1());
			    System.out.println("| " + getJugador1().getNombre() + " ha utilizado sus poderes curativos y " + getJugador2().getNombre() + " ha atacado |");
			    getEventos().add("| " + getJugador1().getNombre() + " ha utilizado sus poderes curativos y " + getJugador2().getNombre() + " ha atacado |");
			} else if (getJugador1().getAccion() == "Curar" && getJugador2().getAccion() == "Curar") {
			    getJugador1().curar();
			    getJugador2().curar();
			    System.out.println("| " + getJugador1().getNombre() + " y " + getJugador2().getNombre() + " han utilizado sus poderes curativos |");
			    getEventos().add("| " + getJugador1().getNombre() + " y " + getJugador2().getNombre() + " han utilizado sus poderes curativos |");
			}
			getJugador1().setAccion("");
			getJugador2().setAccion("");
			turnoN = turnoN + 1;
		}
		
		if (getJugador1().getVidaActual() > 0.0) {
			definirGanador(getJugador1().getNombre(), turnoN);
		} else if (getJugador2().getVidaActual() > 0.0) {
			definirGanador(getJugador2().getNombre(), turnoN);
		} else {
			System.out.println(getJugador1().getNombre() + " falleció en el campo de batalla, no sin antes librar al mundo del malvado " + getJugador2().getNombre() + ", el combate ha resultado en un empate que será recordado por milenios.");
		}
	}
}
