package InterfazPrincipal;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import mundo.Cliente;
import mundo.DetalleFactura;
import mundo.Factura;
import mundo.Productos;
import mundo.Productos.TipoProductos;

import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class PanelFactura extends JPanel implements ActionListener {
	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------
	/**
	 * Comando para buscar cliente
	 */
	public final static String BUSCAR_CLIENTE = "Buscar Cliente";
	/**
	 * Comando para registrar cliente.
	 */
	private final static String REGISTRAR_CLIENTE = "Registrar Cliente";
	/**
	 * Comando para buscar producto.
	 */
	private final static String BUSCAR_PRODUCTO = "Buscar Producto";
	/**
	 * Comando para buscar producto.
	 */
	private final static String AGREGAR_PRODUCTO = "Agregar Producto";
	/**
	 * Comando para buscar producto.
	 */
	private final static String REGISTRAR_FACTURA= "Registrar factura";
	/**
	 * Comando para buscar producto.
	 */
	private final static String CANCELAR_FACTURA= "Cancelar";

	/* Atributos Encabezado */
	private JTextField txtNumeroFactura;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtCedula;
	private JPanel panelEncabezado;
	private JLabel lblNumeroFactura;
	private JLabel lblDireccionEmpresa;
	private JLabel lblNombreEmpresa;
	private JLabel lblTelefonoEmpresa;

	private JPanel panelDatosCliente;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblEmpresa;
	private JButton btnBuscarCliente;
	private JLabel lblCedula;

	/* Atributos Detalle */
	private JTable tableDetalles;
	private JTextField txtIva;
	private JTextField txtSubTotal;
	private JTextField txtTotal;
	private JTextField txtCodigo;
	private JTextField txtCantidad;
	private JPanel panelDetalles;
	private JScrollPane scrollPane;
	private JLabel lblIva;
	private JLabel lblSubtotal;
	private JLabel lblTotal;
	private JButton btnAgregarProducto;
	private JLabel lblCodigo;
	private JLabel lblCantidad;
	private JButton btnFacturar;
	private JButton btnCancelar;
	private InterfazPrincipal interfaz;
	private DefaultTableModel modelo; 
	private ArrayList<DetalleFactura> detalles;

	public PanelFactura(InterfazPrincipal interfaz ) {
		detalles = new ArrayList<DetalleFactura>();
		this.interfaz = interfaz;
		setSize(900, 650);
		setLayout(null);
		/* Encabezado */
		panelEncabezado = new JPanel();
		panelEncabezado.setBackground(new Color(255, 200, 0));
		panelEncabezado.setBounds(0, 0, 900, 210);
		add(panelEncabezado);
		panelEncabezado.setLayout(null);

		lblNumeroFactura = new JLabel("N\u00B0 Factura:");
		lblNumeroFactura.setBounds(597, 72, 78, 13);
		panelEncabezado.add(lblNumeroFactura);

		txtNumeroFactura = new JTextField();
		txtNumeroFactura.setEditable(false);
		txtNumeroFactura.setBounds(685, 69, 167, 19);
		panelEncabezado.add(txtNumeroFactura);
		txtNumeroFactura.setColumns(10);
		
		
		Toolkit tool = Toolkit.getDefaultToolkit();
		Image image = tool.createImage(this.getClass().getResource("/img/logo.png"));

		lblDireccionEmpresa = new JLabel("[DIRECCION]");
		lblDireccionEmpresa.setBounds(22, 28, 415, 13);
		panelEncabezado.add(lblDireccionEmpresa);

		lblNombreEmpresa = new JLabel("[NOMBRE]");
		lblNombreEmpresa.setBounds(22, 10, 415, 13);
		panelEncabezado.add(lblNombreEmpresa);

		lblTelefonoEmpresa = new JLabel("[TELEFONO]");
		lblTelefonoEmpresa.setBounds(22, 51, 415, 13);
		panelEncabezado.add(lblTelefonoEmpresa);
		/* Encabezado Datos CLiente */
		panelDatosCliente = new JPanel();
		panelDatosCliente.setBackground(new Color(255, 200, 0));
		panelDatosCliente.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Datos del cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDatosCliente.setBounds(10, 95, 868, 100);
		panelEncabezado.add(panelDatosCliente);
		panelDatosCliente.setLayout(null);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 54, 55, 13);
		panelDatosCliente.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(75, 51, 284, 19);
		panelDatosCliente.add(txtNombre);
		txtNombre.setColumns(10);

		lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(10, 74, 55, 13);
		panelDatosCliente.add(lblApellido);

		txtApellido = new JTextField();
		txtApellido.setEditable(false);
		txtApellido.setBounds(75, 71, 284, 19);
		panelDatosCliente.add(txtApellido);
		txtApellido.setColumns(10);

		lblEmpresa = new JLabel("Telefono:");
		lblEmpresa.setBounds(386, 71, 55, 13);
		panelDatosCliente.add(lblEmpresa);

		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(451, 68, 284, 19);
		panelDatosCliente.add(txtTelefono);

		btnBuscarCliente = new JButton("Buscar Cliente");
		btnBuscarCliente.setBounds(10, 20, 141, 21);
		btnBuscarCliente.addActionListener(this);
		panelDatosCliente.add(btnBuscarCliente);

		lblCedula = new JLabel("CI/RUC:");
		lblCedula.setBounds(386, 51, 55, 13);
		panelDatosCliente.add(lblCedula);

		txtCedula = new JTextField();
		txtCedula.setEditable(false);
		txtCedula.setColumns(10);
		txtCedula.setBounds(451, 48, 284, 19);
		panelDatosCliente.add(txtCedula);
		/* Detalles */
		panelDetalles = new JPanel();
		panelDetalles.setBackground(new Color(64, 64, 64));
		panelDetalles.setBounds(0, 210, 900, 438);
		add(panelDetalles);
		panelDetalles.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 53, 855, 250);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelDetalles.add(scrollPane);
		String[] columnNames = { "Codigo", "Detalle", "cantidad.", "valor U.", "Valor T." };
		Object[][] data = { };
		modelo = new DefaultTableModel(data, columnNames);
		tableDetalles = new JTable(modelo);
		tableDetalles.getColumnModel().getColumn(0).setPreferredWidth(10);
		tableDetalles.getColumnModel().getColumn(1).setPreferredWidth(400);
		tableDetalles.getColumnModel().getColumn(2).setPreferredWidth(10);
		tableDetalles.getColumnModel().getColumn(3).setPreferredWidth(10);
		tableDetalles.getColumnModel().getColumn(4).setPreferredWidth(10);
		scrollPane.setViewportView(tableDetalles);

		lblIva = new JLabel("iva: ");
		lblIva.setForeground(Color.WHITE);
		lblIva.setBounds(685, 305, 45, 13);
		panelDetalles.add(lblIva);

		txtIva = new JTextField();
		txtIva.setText("");
		txtIva.setBounds(761, 302, 96, 19);
		panelDetalles.add(txtIva);
		txtIva.setColumns(10);

		txtSubTotal = new JTextField();
		txtSubTotal.setText("");
		txtSubTotal.setColumns(10);
		txtSubTotal.setBounds(761, 321, 96, 19);
		panelDetalles.add(txtSubTotal);

		lblSubtotal = new JLabel("Sub Total: ");
		lblSubtotal.setForeground(Color.WHITE);
		lblSubtotal.setBounds(685, 324, 66, 13);
		panelDetalles.add(lblSubtotal);

		lblTotal = new JLabel("Total: ");
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setBounds(685, 343, 66, 13);
		panelDetalles.add(lblTotal);

		txtTotal = new JTextField();
		txtTotal.setText("");
		txtTotal.setColumns(10);
		txtTotal.setBounds(761, 340, 96, 19);
		panelDetalles.add(txtTotal);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(90, 24, 143, 19);
		panelDetalles.add(txtCodigo);
		txtCodigo.setColumns(10);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(329, 24, 143, 19);
		panelDetalles.add(txtCantidad);
		txtCantidad.setColumns(10);

		btnAgregarProducto = new JButton("Agregar Producto");
		btnAgregarProducto.setBounds(493, 23, 143, 21);
		btnAgregarProducto.addActionListener(this);
		panelDetalles.add(btnAgregarProducto);

		lblCodigo = new JLabel("Codigo:");
		lblCodigo.setForeground(Color.WHITE);
		lblCodigo.setBounds(35, 27, 45, 13);
		panelDetalles.add(lblCodigo);

		lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setForeground(Color.WHITE);
		lblCantidad.setBounds(250, 27, 69, 13);
		panelDetalles.add(lblCantidad);

		btnFacturar = new JButton("Registrar factura");
		btnFacturar.setBounds(699, 395, 171, 21);
		btnFacturar.addActionListener(this);
		panelDetalles.add(btnFacturar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(433, 395, 198, 21);
		panelDetalles.add(btnCancelar);
		UIManager um=new UIManager();
		 um.put("OptionPane.background",new Color(255, 200, 0));
		 um.put("Panel.background",new Color(255, 200, 0));
		String id = txtCodigo.getText();
		limpiar();
	}
	
	public void actionPerformed(ActionEvent pEvento) {
		String comando = pEvento.getActionCommand();

		if (comando.equals(BUSCAR_CLIENTE)) {
			 String cedula = JOptionPane.showInputDialog(null,"Ingrese cedula a buscar: ","Buscar cédula",
			   JOptionPane.DEFAULT_OPTION);
			 if(cedula!=null) {
				 String ErrorCedula = interfaz.validarCampoCedula(cedula);
				 if(ErrorCedula.equals("")) {
					 Cliente cliente = interfaz.sistema().buscarClientePorCedula(cedula);
					 if(cliente != null) {
						 txtCedula.setText(cliente.getCedula());
						 txtNombre.setText(cliente.getNombre());
						 txtApellido.setText(cliente.getApellido());
						 txtTelefono.setText(cliente.getTelefono());
					 }else {
						 JOptionPane.showMessageDialog(null, "Cliente no existe");
					 }
					 
				 }else {
					 JOptionPane.showMessageDialog(null, ErrorCedula);
				 }
			 } 
		}else if(comando.equals(AGREGAR_PRODUCTO)) {
			String id = txtCodigo.getText();
			String cantidad = txtCantidad.getText();
			/* Errores*/
			String errorId = interfaz.validarCampoNumeroEntero(id);
			String errorCantidad = interfaz.validarCampoNumeroEntero(cantidad);
			if(errorId.equals("") && errorCantidad.equals("")) {
					int Id = Integer.parseInt(id);
					int Cantidad = Integer.parseInt(cantidad);
					Productos producto = interfaz.sistema().buscarProductosPorCodigo(Id);
					if(producto!=null) {
			        boolean salir = true;
			        for (int i = 0; i < tableDetalles.getRowCount() && salir; i++)
			        if (tableDetalles.getValueAt(i, 0).equals(id)) {
			        	int cantidadAux = Integer.parseInt(tableDetalles.getValueAt(i, 2).toString());
			        	Cantidad += cantidadAux;
			        	tableDetalles.setValueAt(producto.getNombreProductos(), i, 1);
			        	tableDetalles.setValueAt(Cantidad, i, 2);
			        	tableDetalles.setValueAt(producto.getPrecio(), i, 3);
			        	tableDetalles.setValueAt(producto.getPrecio()*Cantidad, i, 3);

						for (DetalleFactura detalleFactura : detalles) {
							if(detalleFactura.getProducto().getIdProductos() == Id) {
								detalleFactura.setCantidad(Cantidad);
							}
						}
						salir = false;
			        }
			        if(salir) {
			        	detalles.add(new DetalleFactura(producto, Cantidad));
			        	 modelo.addRow(new Object[] {id,producto.getNombreProductos(), cantidad,producto.getPrecio(), producto.getPrecio()*Cantidad}); 
			        }
			        txtCantidad.setText("");
			        txtCodigo.setText("");
			        refrescar();
				}else {
					
					JOptionPane.showMessageDialog(null,"El producto no existes");
				}
			}else {
				JOptionPane.showMessageDialog(null, errorId+"\n"+errorCantidad);
			}
		} else if(comando.equals(CANCELAR_FACTURA)) {
			
			limpiar();
			txtNumeroFactura.setText(String.valueOf(interfaz.sistema().getFacuras().size()+1));

		}else if(comando.equals(REGISTRAR_FACTURA)) {
			String cedula = txtCedula.getText();
			String ErrorCedula = interfaz.validarCampoCedula(cedula);
			 if(ErrorCedula.equals("")) {
				 Cliente cliente = interfaz.sistema().buscarClientePorCedula(cedula);
				 if(cliente != null) {
					 if(detalles.size()>0) {
						 Factura factura = new Factura(txtNumeroFactura.getText(), cliente, detalles);
							interfaz.sistema().agregarFactura(factura);
							limpiar();
							interfaz.refrescar();
							
					 }else {
						 JOptionPane.showMessageDialog(null, "No puede ingresar una factura vacia");
					 }
					
				 }else {
					 JOptionPane.showMessageDialog(null, "Cliente no existe");
				 }
				 
			 }else {
				 JOptionPane.showMessageDialog(null, ErrorCedula);
			 }
		 } 
			

		}
		
	public void refrescar() {
		double subtotal = 0;
		for (DetalleFactura detalleFactura : detalles) {
			subtotal += detalleFactura.getCantidad()* detalleFactura.getProducto().getPrecio();
		}
		txtSubTotal.setText(String.valueOf(Math.round(subtotal*100.0)/100.0));
		txtIva.setText(String.valueOf(Math.round((subtotal*0.12)*100.0)/100.0));
		txtTotal.setText(String.valueOf(Math.round((subtotal*1.12)*100.0)/100.0));
	}
	
	public void limpiar() {
		txtApellido.setText("");
		txtCedula.setText("");
		txtIva.setText("");
		txtNombre.setText("");
		txtSubTotal.setText("");
		txtTelefono.setText("");
		txtTotal.setText("");
		txtCodigo.setText("");
		txtCantidad.setText("");
		for (int i = 0; i < detalles.size(); i++) {
			modelo.removeRow(0);	
		}
		detalles = new ArrayList<DetalleFactura>();
		int totalFacturas = interfaz.sistema().getFacuras().size()+1;
		txtNumeroFactura.setText(String.valueOf(totalFacturas));
		
	}
}
