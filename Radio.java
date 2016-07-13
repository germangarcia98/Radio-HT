/**
*@author German Garcia 15008, Jose Martinez 15163, Diego Hurtarte 15022
*@version 14.07.16
*/


/**
* Universidad del Valle de Guatemala, Estructura de Datos, Seccion 20
* Esta clase crea los metodos utilizados por el main y sus atributos 
*/

public class Radio implements iRadio{

	// Se crean los atributos y los arrays utilizados
	private String onOff;
	private String frecuency;
	private String station;
	private int positionAM;
	private Double positionFM; 
	private int[] memoryAM;
	private Double[] memoryFM;


	// Se crea el constructor
	public Radio(){
		this.onOff = "Apagada";
		this.frecuency = "AM";
		this.station = "530";
		this.positionAM = 530;
		this.positionFM = 89.7;
		this.memoryAM = new int[12];
		this.memoryFM = new Double[12];
		}


	// on establece que onOff es igual a Encendida	
	public void on(){
		onOff = "Encendida";
	}

	// off establece que onOff es igual a Apagada	
	public void off(){
		onOff = "Apagada";
	}

	// isOn devuelve el atributo onOff
	public String isOn(){
		return onOff;
	}

	// getFrecuency devuelve el atributo frecuency
	public String getFrecuency(){
		return frecuency;
	}

	// setFrecuency declara o establece a frecuency para poder cambiar su valor
	public void setFrecuency(String frecuency){
		this.frecuency = frecuency;
	}

	// getStation devuelve el atributo station
	public String getStation(){
		return station;
	}

	// setStation declara o establece a station para poder cambiar su valor
	public void setStation(String station){
		this.station = station;
	}

	// getPositionAM devuelve como entero positionAM
	public int getPositionAM(){
		return positionAM;
	}

	// setPositionAM cambia el valor de positionAM
	public void setPositionAM(int positionAM){
		this.positionAM = positionAM;
	}

	// Devuelve positionFM como un Double
	public Double getPositionFM(){
		return positionFM;
	}

	// Cambia el valor de positonFM
	public void setPositionFM(Double positionFM){
		this.positionFM = positionFM;
	}

	// devuelve el valor de memoryAM como un entero
	public int[] getMemoryAM(){
		return memoryAM;
	}

	// Se utiliza para cambiar los valores para memoryAM
	public void setMemoryAM(int[] memoryAM){
		this.memoryAM = memoryAM;
	}

	// devuelve el valor de memoryFM como un entero
	public Double[] getMemoryFM(){
		return memoryFM;
	}

	// Se utiliza para cambiar los valores para memoryFM
	public void setMemoryFM(Double[] memoryAM){
		this.memoryFM = memoryFM;
	}


	// se compara si la frecuencia es am o fm, dependiendo del tipo se suma 10 o 0.2, 
	// y se compara si ya se ha llegado al limite para reiniciar la posicion
	public void forward(){
		String frecuencia = getFrecuency();
		if (frecuencia.equals("AM")){
			positionAM = positionAM + 10;
			if (positionAM > 1610){
				positionAM = 530;
			} 
		} else if (frecuencia.equals("FM")){
			positionFM = positionFM + 0.2;
			if (positionFM > 108.0){
				positionFM = 89.7;
			}
		}

	}

	// se compara si la frecuencia es am o fm, dependiendo del tipo se resta 10 o 0.2, 
	// y se compara si ya se ha llegado al limite para reiniciar la posicion en la final
	public void backward(){
		String frecuencia = getFrecuency();
		if (frecuencia.equals("AM")){
			positionAM = positionAM - 10;
			if (positionAM < 530){
				positionAM = 1610;
			} 
		} else if (frecuencia.equals("FM")){
			positionFM = positionFM - 0.2;
			if (positionFM < 89.7){
				positionFM = 107.9;
			}
		}

	}

	// Se guardan los valores de positionAM y positionFM, en los arreglos establecidos, 
	// segun el valor de posion, con lo cual se le resta 1, ya que inicializa con 0
	public void setMemory(int position){
		String frecuencia = getFrecuency();
		if (frecuencia.equals("AM")){
			memoryAM[position-1] = positionAM;
		} else if (frecuencia.equals("FM")){
			memoryFM[position-1] = positionFM;
		}


	}

	// se crea para poder dar los valores para mostrar en pantalla
	public String toString(String frecuency, String station){
		String st = station + " " + frecuency;
		return st;
	}



}