package logica;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Pablo y Mateo.
 * Clase que guarda y muestra el historial de partidas.
 */

public class Historial {
    private ArrayList<Combate> historial;
    private Scanner scanner = new Scanner(System.in);

    /**
     * Constructor por defecto.
     */
    
    public Historial() {
        this.historial = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

 /**
  * 
  * @param historial Una array list historial para guardar los elementos de la clase Combate.
  * @param scanner Un objeto Scanner para leer la entrada del usuario.
  */
    
    public Historial(ArrayList<Combate> historial, Scanner scanner) {
        this.historial = historial;
        this.scanner = scanner;
    }
    
    /**
     * Método para agregar los datos de cada partida a la array list historial.
     * @param combate Un objeto combate para guardar los datos de cada partida.
     */
    
	public void agregarPartida(Combate combate) {
        historial.add(combate);
    }

	/**
	 * Método que muestra los detalles de la partida que desee ver el usuario (Ganador, tipo de partida, fecha y eventos.)
	 */
	
    public void mostrarDetallePartida() {
        System.out.println("¿Qué partida desea ver en detalle?");
        int opcion = scanner.nextInt();
        if (opcion > 0 && opcion <= historial.size()) {
            historial.get(opcion - 1).mostrarDetalle();
        } else {
            System.out.println("Opción inválida.");
        }
    }

    /**
     * Método que elimina del historial la partida que el usuario quiera.
     */
    
    public void eliminarPartida() {
        System.out.println("¿Qué partida desa elimienar?");
        int opcion = scanner.nextInt();
        if (opcion > 0 && opcion <= historial.size()) {
            historial.remove(opcion - 1);
            System.out.println("Partida eliminada del historial.");
        } else {
            System.out.println("Opción inválida.");
        }
    }
    
    /**
     * Método que muestra un resúmen de todas las partidas jugadas y le pregunta al usuario qué es lo que quiere hacer con estas.
     */
    
    public void mostrarHistorialResumido() {
        if (historial.isEmpty()) {
            System.out.println("No hay partidas registradas.");
          
        } else {
            System.out.println("Historial de Partidas:");
            for (int i = 0; i < historial.size(); i++) {
                System.out.println((i + 1) + ". " + historial.get(i).getResumen());
            }
                System.out.println("|==========================|");
				System.out.println("|    1.  Ver a detalle     |");
				System.out.println("|    2. Eliminar partida   |");
				System.out.println("|    3. Salir              |");
				System.out.println("|==========================|");
		  int opcc = scanner.nextInt();
		  		  switch (opcc) {
   			 case 1:
       			 mostrarDetallePartida();
        			break;
  			  case 2:
       			 eliminarPartida();
      			  break;
 			   case 3:
   			     System.out.println("Volviendo al menú...");		  
	                break;
   			 default:
       			 System.out.println("Opción no válida");
      			  break;
		     }
            }
        }
    }

