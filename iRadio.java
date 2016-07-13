/**
*@author German Garcia 15008, Jose Martinez 15163, Diego Hurtarte 15022
*@version 14.07.16
*/
/**
* Universidad del Valle de Guatemala, Estructura de Datos, Seccion 20
*/

/*
* iRadio es la encargada de definir los metodos que seran utilizados, crea la interface
*/

public interface iRadio {

	public void OnOff();
	public boolean isOn();
	public String getFrecuency();
	public void setFrecuency(String frecuency);
	public String getStation();
	public void setStation(String station);
	public void forward();
	public void backward();
	public void setMemory(int position);
	public String toString();
}

