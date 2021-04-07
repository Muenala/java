package mundo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JFileChooser;


public class SistemaFacturacion implements Serializable{
	private static final long serialVersionUID = 1L;
	//Atributos
	private ArrayList<Cliente> clientes;
	private ArrayList<Productos> catalogo;
	private ArrayList<Factura> facturas;
	
	//Constructor
	public SistemaFacturacion() {
		clientes = new ArrayList<Cliente>();
		catalogo = new ArrayList<Productos>();
		facturas = new ArrayList<Factura>();
	}
	
	//Metodos
	public void agregarFactura(Factura factura) {
		facturas.add(factura);
	}
	
	public ArrayList<Factura> getFacturasCliente(Cliente cliente) {
		ArrayList<Factura> facturasCliente = new ArrayList<Factura>();
		for (Factura factura : facturasCliente) {
			if(factura.getCliente().equals(cliente)) {
				facturasCliente.add(factura);
				break;
			}
		}
		return facturasCliente;
	}
	
	public Cliente buscarClientePorCedula(String cedula) {
		Cliente cli = null;
		
		for (Cliente cliente : clientes) {
			
			if(cedula.equals(cliente.getCedula())) {
				cli = cliente;
			}
		}
		return cli;
	}
	public boolean eliminarProducto(int id) {
		boolean eliminado = false;
		Productos producto = buscarProductosPorCodigo(id);
		if(producto != null) {
			catalogo.remove(producto);
			eliminado = true;
		}
		return eliminado;
	}
	public boolean eliminarCliente(String cedula) {
		boolean eliminado = false;
		Cliente cliente = buscarClientePorCedula(cedula);
		if(cliente != null) {
			clientes.remove(cliente);
			eliminado = true;
		}
		return eliminado;
	}
	
	public Productos buscarProductosPorCodigo(int codigo) {
		Productos pro = null;
		for (Productos producto : catalogo) {
			
			if(producto.getIdProductos() == codigo) {
				pro = producto;
			}
		}
		
		return pro;
	}
	
	public Factura buscarFacturaPorId(String id) {
		Factura fac = null;
		for (Factura factura: facturas) {
			
			if(factura.getIdFactura().equals(id)) {
				fac = factura;
			}
		}
		
		return fac;
	}
	
	public Productos actualizarProducto(Productos producto) {
		Productos pro = null;
		for (int i = 0; i < catalogo.size() && pro == null; i++) {
			if(producto.getIdProductos()== catalogo.get(i).getIdProductos()) {
				catalogo.set(i,producto);
				pro = producto;
			}
		}
		return pro;
	}
	
	public Productos ingresarNuevoProducto(Productos producto) {
		Productos pro = buscarProductosPorCodigo(producto.getIdProductos());
		
		if( pro == null) {
			catalogo.add(producto);	
		}
		return pro;
	}
	
	public Cliente ingresarNuevoCliente(Cliente cliente) {
		Cliente cli = buscarClientePorCedula(cliente.getCedula());
	
		if( cli == null) {
			clientes.add(cliente);	
		}
		return cli;
	}
	public Cliente actualizarCliente(Cliente cliente) {
		Cliente cli = null;
		for (int i = 0; i < clientes.size(); i++) {
			if(cliente.getCedula().equals(clientes.get(i).getCedula())) {
				clientes.set(i,cliente);
				cli = cliente;
			}
		}
		return cli;
	}
	
	
	public boolean guardar() {
		boolean guardado = false;
    	JFileChooser selectorArchivos = new JFileChooser();
    	selectorArchivos.setDialogTitle("Especifique el archivo a guardar");  
    	selectorArchivos.showSaveDialog(null);
    	File archivo = selectorArchivos.getSelectedFile();
        try {
            ObjectOutputStream ficheroSalida = new ObjectOutputStream(new FileOutputStream(archivo));
            
            ficheroSalida.writeObject(this);
            ficheroSalida.flush();
            ficheroSalida.close();
            guardado=true;
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error: El fichero no existe. ");
        } catch (IOException ioe) {
            System.out.println("Error: Fallo en la escritura en el fichero. ");
        }
 
		return guardado;
	}
	
	public void recuperar() throws ClassNotFoundException{
		SistemaFacturacion sistema;
		JFileChooser selectorArchivos = new JFileChooser();
    	selectorArchivos.showOpenDialog(null);
    	File archivo = selectorArchivos.getSelectedFile();
        try {
            ObjectInputStream ficheroSalida = new ObjectInputStream(new FileInputStream(archivo));
            sistema = (SistemaFacturacion) ficheroSalida.readObject();
            this.setCatalogo(sistema.getCatalogo());
            this.setClientes(sistema.getClientes());
            this.setFacturas(sistema.getFacturas());
            ficheroSalida.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error: El fichero no existe. ");
        } catch (IOException ioe) {
            System.out.println("Error: Fallo en la lectura en el fichero. "+ioe);
        }
	}
	//Metodos getters
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public ArrayList<Productos> getCatalogo() {
		return catalogo;
	}
	
	public ArrayList<Factura> getFacuras() {
		return facturas;
	}

	public ArrayList<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public void setCatalogo(ArrayList<Productos> catalogo) {
		this.catalogo = catalogo;
	}
	

	

}
