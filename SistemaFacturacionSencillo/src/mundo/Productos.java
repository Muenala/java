package mundo;

import java.io.Serializable;

public class Productos implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public enum TipoProductos {
		PAN, LACTEOS, BEBIDAS, SNACKS
	}
	//Atributos
	private int idProductos;
	private String nombreProductos;
	private double precio;
	private int stock;
	private TipoProductos tipo;
	
	//Constructor
	public Productos(int pIdProductos, String pNombreProductos, double pPrecio, int pStock,TipoProductos tipo) {
		this.idProductos = pIdProductos;
		this.nombreProductos = pNombreProductos;
		this.precio = pPrecio;
		this.stock = pStock;
		this.tipo = tipo;
	}

	//Metodos getters
	public int getIdProductos() {
		return idProductos;
	}

	public String getNombreProductos() {
		return nombreProductos;
	}

	public double getPrecio() {
		return precio;
	}

	public int getStock() {
		return stock;
	}

	public TipoProductos getTipo() {
		return tipo;
	}

	
	
}
