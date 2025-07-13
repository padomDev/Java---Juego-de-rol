package logica;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Pepe y Feli.
 * Clase que gestiona un combate entre un personaje controlado por el jugador y un personaje bot en un entorno PvE.
 */
public class CombatePvE extends Combate {
	Random random = new Random();
	Scanner entrada = new Scanner (System.in);
	
    /**
     * Constructor por defecto de la clase CombatePvE.
     */
	   public CombatePvE() {
	    	setJugador1(null);
	    	setJugador2(null);
	    	setFecha(null);
	    	setTipoPartida("PvE");
	    	setJugador1(null);
	    	setEventos( new ArrayList<String>()) ;
	    }
	
    /**
     * Crea un personaje bot con atributos aleatorios basados en los puntos totales proporcionados.
     *
     * @param puntosTotales Los puntos totales disponibles para asignar a los atributos del bot.
     * @return Un personaje bot con atributos asignados aleatoriamente.
     */
	public Personaje crearPersonajeBot(double puntosTotales) {
		double puntosLibres = puntosTotales; // Inicializacion y definicion de variables y atributos genericos de Personaje
		double vitalidadBot, ataqueBot, randomAtributoPorcentaje;
		
        switch(random.nextInt(4)+1) {
        case 1: // Construccion arquero
        	double evasionBot; // Inicializacion y definicion de variables y atributos especificos de Arquero
        	
        	randomAtributoPorcentaje = random.nextDouble(99.0)+1.0; // Asigna porcentaje de double puntosLibres al atributo double vitalidadBot
        	vitalidadBot = puntosLibres*(randomAtributoPorcentaje/100);
        	puntosLibres = puntosLibres - vitalidadBot; // Re-define double puntosLibres en base al resultado de lineas 25 y 26
        	
        	randomAtributoPorcentaje = random.nextDouble(99.0)+1.0; // Repite proceso previo para atributo double ataqueBot
        	ataqueBot = puntosLibres*(randomAtributoPorcentaje/100);
        	puntosLibres = puntosLibres - ataqueBot;
        	
        	evasionBot = puntosLibres; // Asigna los puntos libres restantes al ultimo atributo
        	puntosLibres = puntosLibres - evasionBot;
        	
        	if (puntosLibres != 0.0) { // Checkea si hay exceso o falta de puntos alocados a atributos, en caso de haber los asigna al ultimo atributo
        		evasionBot = evasionBot + puntosLibres;
        		puntosLibres = 0;
        	}
        	
        	Personaje botArquero = new Arquero("Bot Arquero", vitalidadBot, ataqueBot, evasionBot);
        	return botArquero;
        	
        case 2: // Construccion asesino
        	double ataqueCriticoBot, probabilidadCriticoBot; // Inicializacion y definicion de variables y atributos especificos de Asesino
        	
        	randomAtributoPorcentaje = random.nextDouble(99.0)+1.0; // Asigna porcentaje de double puntosLibres al atributo double vitalidadBot
        	vitalidadBot = puntosLibres*(randomAtributoPorcentaje/100);
        	puntosLibres = puntosLibres - vitalidadBot; // Re-define double puntosLibres en base al resultado previo
        	
        	randomAtributoPorcentaje = random.nextDouble(99.0)+1.0; // Repite proceso previo para atributo double ataqueBot
        	ataqueBot = puntosLibres*(randomAtributoPorcentaje/100);
        	puntosLibres = puntosLibres - ataqueBot;
        	
        	randomAtributoPorcentaje = random.nextDouble(99.0)+1.0; // Repite proceso previo para atributo double ataqueCriticoBot
        	ataqueCriticoBot = puntosLibres*(randomAtributoPorcentaje/100);
        	puntosLibres = puntosLibres - ataqueCriticoBot;
        	
        	probabilidadCriticoBot = puntosLibres; // Asigna los puntos libres restantes al ultimo atributo
        	puntosLibres = puntosLibres - probabilidadCriticoBot;
        	
        	if (puntosLibres != 0.0) { // Checkea si hay exceso o falta de puntos alocados a atributos, en caso de haber los asigna al ultimo atributo
        		probabilidadCriticoBot = probabilidadCriticoBot + puntosLibres;
        		puntosLibres = 0;
        	}
        	
        	Personaje botAsesino = new Asesino("Bot Asesino", vitalidadBot, ataqueBot, probabilidadCriticoBot, ataqueCriticoBot);
        	return botAsesino;
            
        case 3: // Construccion paladin
        	double resistenciaBot; // Inicializacion y definicion de variables y atributos especificos de Paladin
        	
        	randomAtributoPorcentaje = random.nextDouble(99.0)+1.0; // Asigna porcentaje de double puntosLibres al atributo double vitalidadBot
        	vitalidadBot = puntosLibres*(randomAtributoPorcentaje/100);
        	puntosLibres = puntosLibres - vitalidadBot; // Re-define double puntosLibres en base al resultado de lineas 25 y 26
        	
        	randomAtributoPorcentaje = random.nextDouble(99.0)+1.0; // Repite proceso previo para atributo double ataqueBot
        	ataqueBot = puntosLibres*(randomAtributoPorcentaje/100);
        	puntosLibres = puntosLibres - ataqueBot;
        	
        	resistenciaBot = puntosLibres; // Asigna los puntos libres restantes al ultimo atributo
        	puntosLibres = puntosLibres - resistenciaBot;
        	
        	if (puntosLibres != 0.0) { // Checkea si hay exceso o falta de puntos alocados a atributos, en caso de haber los asigna al ultimo atributo
        		resistenciaBot = resistenciaBot + puntosLibres;
        		puntosLibres = 0;
        	}
        	
        	Personaje botPaladin = new Paladin("Bot Paladin", vitalidadBot, ataqueBot, resistenciaBot);
        	return botPaladin;
            
        case 4: // Construccion curandero
        	double curacionBot; // Inicializacion y definicion de variables y atributos especificos de Paladin
        	
        	randomAtributoPorcentaje = random.nextDouble(99.0)+1.0; // Asigna porcentaje de double puntosLibres al atributo double vitalidadBot
        	vitalidadBot = puntosLibres*(randomAtributoPorcentaje/100);
        	puntosLibres = puntosLibres - vitalidadBot; // Re-define double puntosLibres en base al resultado de lineas 25 y 26
        	
        	randomAtributoPorcentaje = random.nextDouble(99.0)+1.0; // Repite proceso previo para atributo double ataqueBot
        	ataqueBot = puntosLibres*(randomAtributoPorcentaje/100);
        	puntosLibres = puntosLibres - ataqueBot;
        	
        	curacionBot = puntosLibres; // Asigna los puntos libres restantes al ultimo atributo
        	puntosLibres = puntosLibres - curacionBot;
        	
        	if (puntosLibres != 0.0) { // Checkea si hay exceso o falta de puntos alocados a atributos, en caso de haber los asigna al ultimo atributo
        		curacionBot = curacionBot + puntosLibres;
        		puntosLibres = 0;
        	}
        	
        	Personaje botCurandero = new Curandero("Bot Curandero", vitalidadBot, ataqueBot, curacionBot);
        	return botCurandero;
            
        default: // Error
            return null;
        }
    }
	
    /**
     * Determina la acción que tomará el bot durante el combate.
     *
     * @param personaje El personaje controlado por el bot.
     */
	public void botCombateOpcion(Personaje personaje) {
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
	        int swop = random.nextInt(3) + 1;
	        System.out.println(swop);
	        getEventos().add(String.valueOf(swop));

	        switch (swop) {
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
	        int swop = random.nextInt(2) + 1;
	        System.out.println(swop);
	        getEventos().add(String.valueOf(swop));
	        switch (swop) {
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
     * Inicia el combate entre el jugador y el bot.
     */
	public void iniciarCombate() {
		int turnoN = 1;
		establecerFecha();
		setJugador1(crearPersonaje(entrada));
		setJugador2(crearPersonajeBot(getJugador1().getPuntosTotales()));
		getJugador1().mostrarInfo();
		getJugador2().mostrarInfo();
		System.out.println("");
		getEventos().add("");
		System.out.println("");
		getEventos().add("");
		mostrarMensajeInicioCombate(getJugador1(), getJugador2(), random);
		
		while (getJugador1().getVidaActual() > 0.0 && getJugador2().getVidaActual() > 0.0) {
			System.out.println("");
			getEventos().add("");
			System.out.println("");
			getEventos().add("");
			mostrarJugadoresVida(getJugador1(), getJugador2(), turnoN);
			jugadorCombateOpcion(getJugador1(), entrada);
			botCombateOpcion(getJugador2());
			System.out.println(getJugador1().getAccion());
			getEventos().add(getJugador1().getAccion());
			System.out.println(getJugador2().getAccion());
			getEventos().add(getJugador2().getAccion());
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
		}

	}
}