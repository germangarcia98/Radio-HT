/**
* Clase principal de la radio
* @author Jose Martinez 15163, Diego Hurtarte 15022, German Garcia 15008
* @version 12.07.2016
*/
import java.util.Scanner;

public class RadioPrincipal {
    
    public static void main(String[] args){

    	Scanner teclado = new Scanner(System.in);

    	Radio radio = new Radio();

    	String emisora = String.valueOf(radio.getPositionAM());
    	Boolean salir = false;
    	String opcionSeleccionada = "";

    	while(salir == false){

    		System.out.println("\n\nEstado de la radio:\n-Radio " + (radio.isOn()) +"\n-Frecuencia Radio: " + (radio.getFrecuency()) + "\n-Emisora Actual: " + (emisora));

    		System.out.println("\n\nOpciones de la radio:\n1) Boton On/Off\n2) Cambiar a AM/FM\n3) Subir emisora\n4) Bajar emisora: \n5) Guardar emisora:\n6) Emisoras Guardadas: \n7) Salir radio");

    		opcionSeleccionada = teclado.nextLine();

    		if (opcionSeleccionada.equals("1")){
    			if (radio.isOn()==false) {
    				radio.OnOff();
    			} else if (radio.isOn()==true) {
    				radio.OnOff();
    			}

    		} else if (opcionSeleccionada.equals("2")&&radio.isOn()==true){
    			if (radio.getFrecuency().equals("AM")){
    				radio.setFrecuency("FM");
    				emisora = String.valueOf(radio.getPositionFM());

    			} else if (radio.getFrecuency().equals("FM")){
    				radio.setFrecuency("AM");
    				emisora = String.valueOf(radio.getPositionAM());
    			}

    		} else if (opcionSeleccionada.equals("3")&&radio.isOn()==true){
    			radio.forward();

    			if (radio.getFrecuency().equals("AM")){
    				emisora = String.valueOf(radio.getPositionAM());

    			} else if (radio.getFrecuency().equals("FM")){
    				emisora = String.valueOf(radio.getPositionFM());
    			}

    		} else if (opcionSeleccionada.equals("4")&&radio.isOn()==true){
    			radio.backward();

    			if (radio.getFrecuency().equals("AM")){
    				emisora = String.valueOf(radio.getPositionAM());

    			} else if (radio.getFrecuency().equals("FM")){
    				emisora = String.valueOf(radio.getPositionFM());
    			}

    		} else if (opcionSeleccionada.equals("5")&&radio.isOn()==true){
    			System.out.println("Escoja la posición en la que desea guardar esta emisora: \n1)\n2)\n3)\n4)\n5)\n6)\n7)\n8)\n9)\n10)\n11)\n12)");
    			String posicionAGuardar = teclado.nextLine();
    			int posicionInt = Integer.parseInt(posicionAGuardar);
    			radio.setMemory(posicionInt);
    		} else if (opcionSeleccionada.equals("6")&&radio.isOn()==true){
    			String listaEmisoras = "";
    			int numeroEnLista = 0;

    			if (radio.getFrecuency().equals("AM")){
    				int[] emisorasGuardadas = radio.getMemoryAM();

    				for(int a : emisorasGuardadas){
    					numeroEnLista = numeroEnLista + 1;
    					if (a != 0){
    						listaEmisoras = listaEmisoras + "\n" + numeroEnLista + ") " + a;
    						
    					} else {
    					listaEmisoras = listaEmisoras + "\n" + numeroEnLista + ") No hay emisora guardada";
						}
    				}

    				System.out.println(listaEmisoras);

    				String emisoraSeleccionada = teclado.nextLine();

    				int emisoraSeleccionadaInt = Integer.parseInt(emisoraSeleccionada) - 1;

    				radio.setPositionAM(emisorasGuardadas[emisoraSeleccionadaInt]);
    				emisora = String.valueOf(radio.getPositionAM());
    			} else {
    				Double[] emisorasGuardadas = radio.getMemoryFM();

    				for(Double a : emisorasGuardadas){
    					numeroEnLista = numeroEnLista + 1;
    					if (a != null){
    						listaEmisoras = listaEmisoras + "\n" + numeroEnLista + ") " + a;
    						
    					} else {
    					listaEmisoras = listaEmisoras + "\n" + numeroEnLista + ") No hay emisora guardada";
						}
    				}

    				System.out.println(listaEmisoras);

    				String emisoraSeleccionada = teclado.nextLine();

    				int emisoraSeleccionadaInt = Integer.parseInt(emisoraSeleccionada) - 1;

    				radio.setPositionFM(emisorasGuardadas[emisoraSeleccionadaInt]);
    				emisora = String.valueOf(radio.getPositionFM());
    			}

    		} else if (opcionSeleccionada.equals("7")){
    			salir = true;
    		} else {
    			System.out.println("'" + (opcionSeleccionada) + "' NO ES UNA OPCION DE LA RADIO O LA RADIO ESTA APAGADA");
    		}

    	}
    }
}
