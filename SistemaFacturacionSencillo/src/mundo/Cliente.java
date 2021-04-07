package mundo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	//Atributos
	private String cedula;
	private String nombre;
	private String apellido;
	private String telefono;
	private Fecha fecha;
	
	//Constructor
	public Cliente(String pCedula, String pNombre, String pApellido, String pTelefono, Fecha pFecha) {
		cedula = pCedula;
		nombre = pNombre;
		apellido = pApellido;
		telefono = pTelefono;
		fecha = pFecha; 
	}
	//Metodos setter y getter
	public String getCedula() {
		return cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getTelefono() {
		return telefono;
	}
	//Fecha 
	public Fecha darFechaActual() {
		GregorianCalendar gc = new GregorianCalendar( );
        int dia = gc.get( Calendar.DAY_OF_MONTH );
        int mes = gc.get( Calendar.MONTH ) + 1;
        int anio = gc.get( Calendar.YEAR );
        Fecha hoy = new Fecha( dia, mes, anio );

        return hoy;
	}

}
