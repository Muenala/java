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
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class JDialogFactura extends JDialog  {
	
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
	private JLabel lblCedula;

	/* Atributos Detalle */
	private JTable tableDetalles;
	private JTextField txtIva;
	private JTextField txtSubTotal;
	private JTextField txtTotal;
	private JPanel panelDetalles;
	private JScrollPane scrollPane;
	private JLabel lblIva;
	private JLabel lblSubtotal;
	private JLabel lblTotal;
	private InterfazPrincipal interfaz;
	private DefaultTableModel modelo; 
	private ArrayList<DetalleFactura> detalles;
	public JDialogFactura(InterfazPrincipal interfaz,  boolean modal, Cliente cliente, Factura factura) {
		super(interfaz, modal);
		this.interfaz = interfaz;
		
		setSize(900, 650);
		getContentPane().setLayout(null);
		detalles = factura.getDescripcion();
		/* Encabezado */
		panelEncabezado = new JPanel();
		panelEncabezado.setBackground(new Color(255, 200, 0));
		panelEncabezado.setBounds(0, 0, 900, 210);
		getContentPane().add(panelEncabezado);
		panelEncabezado.setLayout(null);

		lblNumeroFactura = new JLabel("N\u00B0 Factura:");
		lblNumeroFactura.setBounds(597, 72, 78, 13);
		panelEncabezado.add(lblNumeroFactura);

		txtNumeroFactura = new JTextField(factura.getIdFactura());
		txtNumeroFactura.setEditable(false);
		txtNumeroFactura.setBounds(685, 69, 167, 19);
		panelEncabezado.add(txtNumeroFactura);
		txtNumeroFactura.setColumns(10);
		
		
		Toolkit tool = Toolkit.getDefaultToolkit();
		Image image = tool.createImage(this.getClass().getResource("/img/logo.png"));

		lblDireccionEmpresa = new JLabel("[DIRECCION]");
		lblDireccionEmpresa.setBounds(22, 28, 415, 13);
		panelEncabezado.add(lblDireccionEmpresa);

		lblNombreEmpresa = new JLabel("[NOMBRE[");
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
		lblNombre.setBounds(10, 35, 55, 13);
		panelDatosCliente.add(lblNombre);

		txtNombre = new JTextField(cliente.getNombre());
		txtNombre.setEditable(false);
		txtNombre.setBounds(75, 32, 284, 19);
		panelDatosCliente.add(txtNombre);
		txtNombre.setColumns(10);

		lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(10, 55, 55, 13);
		panelDatosCliente.add(lblApellido);

		txtApellido = new JTextField(cliente.getApellido());
		txtApellido.setEditable(false);
		txtApellido.setBounds(75, 52, 284, 19);
		panelDatosCliente.add(txtApellido);
		txtApellido.setColumns(10);

		lblEmpresa = new JLabel("Telefono:");
		lblEmpresa.setBounds(386, 52, 55, 13);
		panelDatosCliente.add(lblEmpresa);

		txtTelefono = new JTextField(cliente.getTelefono());
		txtTelefono.setEditable(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(451, 49, 284, 19);
		panelDatosCliente.add(txtTelefono);

		lblCedula = new JLabel("CI/RUC:");
		lblCedula.setBounds(386, 32, 55, 13);
		panelDatosCliente.add(lblCedula);

		txtCedula = new JTextField(cliente.getCedula());
		txtCedula.setEditable(false);
		txtCedula.setColumns(10);
		txtCedula.setBounds(451, 29, 284, 19);
		panelDatosCliente.add(txtCedula);
		/* Detalles */
		panelDetalles = new JPanel();
		panelDetalles.setBackground(new Color(64, 64, 64));
		panelDetalles.setBounds(0, 210, 900, 438);
		getContentPane().add(panelDetalles);
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
		refrescar();
		setVisible(true);
	}
	
		
	public void refrescar() {
		double subtotal = 0;
		for (DetalleFactura detalleFactura : detalles) {
			Productos producto = detalleFactura.getProducto();
			 modelo.addRow(new Object[] {producto.getIdProductos(),producto.getNombreProductos(),detalleFactura.getCantidad(),producto.getPrecio(), producto.getPrecio()*detalleFactura.getCantidad()}); 
			subtotal += detalleFactura.getCantidad()* detalleFactura.getProducto().getPrecio();
		}
		txtSubTotal.setText(String.valueOf(Math.round(subtotal*100.0)/100.0));
		txtIva.setText(String.valueOf(Math.round((subtotal*0.12)*100.0)/100.0));
		txtTotal.setText(String.valueOf(Math.round((subtotal*1.12)*100.0)/100.0));
	}


	

}
