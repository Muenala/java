package mundo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Factura implements Serializable{
	private static final long serialVersionUID = 1L;
	//Atributos
	private String idFactura;
	private Cliente clienta;
	private ArrayList<DetalleFactura> descripcion;
	
	//Constructor
	public Factura(String pIdFactura, Cliente clienta, ArrayList<DetalleFactura> descripcion) {
		idFactura = pIdFactura;
		this.clienta = clienta;
		this.descripcion = descripcion;
	}

	//Metodos
	public void ageregarProducto(Productos producto,int cantidad ) {
		if(existeProducto(producto)) {
			DetalleFactura nuevoDetalle = new DetalleFactura(producto, cantidad);
			descripcion.add(nuevoDetalle);
		}else {
			DetalleFactura detalle = buscarDetalle(producto);
			if(detalle!=null) {
				detalle.setCantidad(detalle.getCantidad() + cantidad);
			}
			
		}
		
	}

	public boolean existeProducto(Productos producto) {
		boolean existe = false;
		if(buscarDetalle(producto)!=null){
			existe = true;
		}else {
			existe = false;
		}
		return existe;
	}
	public DetalleFactura buscarDetalle(Productos producto) {
		DetalleFactura detalle = null;

		for (DetalleFactura detalleFactura : descripcion) {
			if(detalleFactura.getProducto().equals(producto)) {
				System.out.print(detalle.getProducto().getNombreProductos());
				detalle = detalleFactura;
			}
		}
		return detalle;
	}
	
	
	//Metodos Getter
	public String getIdFactura() {
		return idFactura;
	}
	
	public Cliente getCliente() {
		return clienta;
	}

	public ArrayList<DetalleFactura> getDescripcion() {
		return descripcion;
	}
	
	

}
