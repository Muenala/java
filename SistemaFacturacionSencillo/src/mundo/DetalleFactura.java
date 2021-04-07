package mundo;

import java.io.Serializable;

public class DetalleFactura implements Serializable{
	private static final long serialVersionUID = 1L;
	private Productos producto;
	private int cantidad;
	
	public DetalleFactura(Productos producto, int cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}
	

	public Productos getProducto() {
		return producto;
	}


	public int getCantidad() {
		return cantidad;
	}

	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	
}
