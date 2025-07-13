package presentacion;

import logica.CombatePvP;
import logica.CombatePvE;
import logica.Historial;
import logica.Combate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * @author Mateo
 * Clase para mostrar el menú.
 */
public class MenuPrincipal {
	
	Scanner entrada = new Scanner (System.in);
	private boolean continuar=true;
	private ArrayList<Combate> historial = new ArrayList<>();
	
	/**
	 * Método que muestra el menú principal y llama distintos métodos de otras clases según el usuario lo requiera.
	 */
	
	public void mostrarMenu() {
		while (continuar) {
		System.out.println("|==========================|");
		System.out.println("|=>      Bienvenido      <=|");
		System.out.println("|==========================|");
		System.out.println("|   1. Jugar partida PvP   |");
		System.out.println("|   2. Jugar Partida PvE   |");
		System.out.println("| 3. Historial de Partidas |");
		System.out.println("|         4. Salir         |");
		System.out.println("|==========================|");
		int op;
		entrada = new Scanner(System.in);
			try {
				
				op = entrada.nextInt();
				 switch (op) {
		            case 1:
		                CombatePvP pvp = new CombatePvP();
		                pvp.iniciarCombate();
		                historial.add(pvp);
		                break;
		            case 2:
		            	CombatePvE pve = new CombatePvE();
		                pve.iniciarCombate();
		                historial.add(pve);
		                break;
		            case 3:
		            	Historial historia = new Historial(historial, entrada);
		                historia.mostrarHistorialResumido();		
		                break;
		            case 4:
		                 System.out.println("¡Gracias por jugar!");
						 continuar = !continuar;
						 break;
		            default:
		                 System.out.println("Opción no válida");
		                 break;
		        }

			}catch (InputMismatchException ex){ 
				System.out.println("Error");
			}
		 
		
	}
}
}