package InterfazPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import mundo.SistemaFacturacion;
import mundo.Usuario;


public class InterfazPrincipal extends JFrame implements ActionListener{
	public final static String GUARDAR = "Guardar";
	private final static String RECUPERAR = "Recuperar";
	/* Atributos conexion*/
	private static Connection mySQL;
	/* Atributos*/
	private static Usuario usuario;
	private static boolean salir = true;
	/* Atributos de menu*/
	private JTabbedPane menuPrincipal;
	private PanelFactura panelFactura;
	private PanelCliente panelCliente;
	private PanelProducto panelProducto;
	private PanelUsuarios panelUsuarios ;
	private PanelFacturas panelFacturas;
	private static InterfazInicio inicio;
	private SistemaFacturacion sistema;
	private JMenuBar barra;
	private JMenu archivo;
	private JMenuItem recuperar;
	private JMenuItem guardar;
	public InterfazPrincipal() {
		if(usuario !=null){
			sistema = new SistemaFacturacion();
			panelFactura = new PanelFactura(this);
			panelCliente = new PanelCliente(this);
			panelProducto = new PanelProducto(this);
			panelFacturas = new PanelFacturas(this);
			//panelUsuarios = new PanelUsuarios();
			/** Configuracion de menu **/
			 barra=new JMenuBar();
			   archivo=new JMenu("Archivo");
			   guardar=new JMenuItem("Guardar");
				  guardar.addActionListener(this);
			   recuperar=new JMenuItem("Recuperar");
			  recuperar.addActionListener(this);
			  barra.add(archivo);
			  archivo.add(recuperar);
			  archivo.add(guardar);
			  setJMenuBar(barra);
			 
			menuPrincipal = new JTabbedPane();
			menuPrincipal.addTab("Factura",  panelFactura);
			menuPrincipal.addTab("cliente", panelCliente);
			menuPrincipal.addTab("productos", panelProducto);
			menuPrincipal.addTab("facturas", panelFacturas);
			menuPrincipal.setBounds(0, 0, 900, 700);
			
			setSize(915, 725);
			setTitle("Sistema de facturacion PANADERIA");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			getContentPane().setLayout(null);
			getContentPane().add(menuPrincipal);
			
			setVisible(true);
		}
	}
	public static void main(String[] args) {
		mySQL = null;
		usuario = null;
		InterfazPrincipal interfaz = new InterfazPrincipal();
		do {
			inicio = new InterfazInicio(interfaz,true);
		}while(usuario == null && salir);
		interfaz = new InterfazPrincipal();
	}
	
	 /*public static Connection conectar() {
	    	Connection conn = null;
	    	try {
	    	    conn =
	    	       DriverManager.getConnection("jdbc:mysql://localhost/panaderia?" +
	    	                                   "user=root&password=kovi123maU");
	    	    // Do something with the Connection
	    	} catch (SQLException ex) {
	    	    // handle any errors
	    	    System.out.println("SQLException: " + ex.getMessage());
	    	    System.out.println("SQLState: " + ex.getSQLState());
	    	    System.out.println("VendorError: " + ex.getErrorCode());
	    	}
	    	return conn;
	    }*/
	 public void iniciarSesion(Usuario usuario) {
		 this.usuario= usuario;
	 }
	 public void cerrar() {
		 salir = false;
		 dispose();
	 }
	 public String validarCampoTexto(String cadena) {
		 String mensaje = "";
		 if(cadena.length()>0) {
			 for (int i = 0; i < cadena.length() && mensaje == ""; i++) {
					if(cadena.charAt(i) > 64 && cadena.charAt(i)<91 || cadena.charAt(i) > 96 && cadena.charAt(i) <123 || cadena.charAt(i)==32) {
						
					}else {
					mensaje = "El campo debe ser solo texto";
				}
			 }
		 }else {
			 mensaje = "Campo vacio";
		 }
		 
		return mensaje;
	 }
	 
	 public String validarCampoNumeroEntero(String cadena) {
		 String mensaje = "";
		 if(cadena.length()>0) {
			 try {
				 Integer.parseInt(cadena);
			 }catch(NumberFormatException error) {
				 mensaje = "El campo debe ser solo entero";
			 }
		 }else {
			 mensaje = "Campo vacio";
		 }
		 
		return mensaje;
	 }
	 public String validarCampoNumeroDouble(String cadena) {
		 String mensaje = "";
		 if(cadena.length()>0) {
			 try {
				 Double.parseDouble(cadena);
			 }catch(NumberFormatException error) {
				 mensaje = "El campo debe ser solo numerico";
			 }
		 }else {
			 mensaje = "Campo vacio";
		 }
		 
		return mensaje;
	 }
	 
	 public String validarCampoCedula(String cadena) {
		 String mensaje = "";
		 if(cadena.length()>0) {
			 if(!(cadena.length()==10)) {
				 mensaje = "Cedula debe tener 10 digitos";
			 }else {
				 mensaje ="";
			 }
		 }else {
			 mensaje = "Campo vacio";
		 }
		 
		return mensaje;
	 }
	 public void actionPerformed(ActionEvent pEvento) {

			String comando = pEvento.getActionCommand();

			if (comando.equals(GUARDAR)) {
				sistema().guardar();
			}else if (comando.equals(RECUPERAR)) {
				try {
					sistema().recuperar();
					refrescar();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	 public SistemaFacturacion sistema() {
		 return sistema;
	 }
	 public void refrescar() {
		 panelFacturas.refrescar();
		 panelCliente.refrescar();
		 panelProducto.refrescar();
		 panelFactura.limpiar();
	 }
}
