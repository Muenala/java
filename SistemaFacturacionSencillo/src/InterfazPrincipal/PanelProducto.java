package InterfazPrincipal;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import mundo.Cliente;
import mundo.Fecha;
import mundo.Productos;
import mundo.Productos.TipoProductos;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class PanelProducto extends JPanel implements ActionListener{
	public final static String GUARDAR = "Guardar";
	private final static String ACTUALIZAR = "Actualizar";
	public final static String EDITAR = "Editar";
	private final static String ELIMINAR= "Eliminar";
	
	JPanel panelCabezera;
	private JPanel panelDatos;
	private JLabel lblId;
	private JTextField txtID;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JLabel lblStock;
	private JTextField txtStock;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JButton btnGuardar;
	private JButton btnActualizar;
	private JLabel lblErrorId;
	private JLabel lblErrorNombre;
	private JLabel lblErrorPrecio;
	private JLabel lblErrorStock;
	private JComboBox cbTipo;
	private JLabel lblErrorCb;
	private JTable tableProductos;
	private DefaultTableModel modelo; 
	InterfazPrincipal interfaz;
	public PanelProducto(InterfazPrincipal interfaz){
		this.interfaz = interfaz;
		setSize(900, 650);
		setLayout(null);
		
		panelCabezera = new JPanel();
		panelCabezera.setBackground(new Color(64, 64, 64));
		panelCabezera.setBounds(0, 0, 900, 100);
		add(panelCabezera);
		panelCabezera.setLayout(null);
		
		JLabel lblCabecera = new JLabel("Registrar Producto");
		lblCabecera.setHorizontalAlignment(SwingConstants.CENTER);
		lblCabecera.setToolTipText("");
		lblCabecera.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblCabecera.setForeground(Color.WHITE);
		lblCabecera.setBounds(10, 5, 880, 67);
		panelCabezera.add(lblCabecera);
		
		panelDatos = new JPanel();
		panelDatos.setLayout(null);
		panelDatos.setBackground(Color.ORANGE);
		panelDatos.setBounds(0, 100, 900, 600);
		add(panelDatos);
		
		lblId = new JLabel("Id:");
		lblId.setBounds(57, 35, 77, 13);
		panelDatos.add(lblId);
		
		txtID = new JTextField();
		txtID.setEditable(true);
		txtID.setColumns(10);
		txtID.setBounds(143, 35, 171, 19);
		panelDatos.add(txtID);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(57, 80, 77, 13);
		panelDatos.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(143, 80, 171, 19);
		panelDatos.add(txtNombre);
		
		lblPrecio = new JLabel("Precio::");
		lblPrecio.setBounds(57, 125, 77, 13);
		panelDatos.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(143, 125, 171, 19);
		panelDatos.add(txtPrecio);
		
		lblStock = new JLabel("Stock::");
		lblStock.setBounds(57, 170, 77, 13);
		panelDatos.add(lblStock);
		
		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(143, 170, 171, 19);
		panelDatos.add(txtStock);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 217, 900, 326);
		panelDatos.add(panel);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(30, 82, 840, 207);
		panel.add(scrollPane);
		
		String[] columnNames = { "Id", "Nombre", "Precio", "Stock","Tipo"};
		Object[][] data = { };
		modelo = new DefaultTableModel(data, columnNames);
		tableProductos = new JTable(modelo);
		tableProductos.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	            // do some actions here, for example
	            // print first column value from selected row
	        	habiliarBotones();
	        }
	    });
		scrollPane.setViewportView(tableProductos);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(30, 51, 132, 21);
		btnEditar.addActionListener(this);
		panel.add(btnEditar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(186, 51, 132, 21);
		btnEliminar.addActionListener(this);
		panel.add(btnEliminar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(353, 76, 132, 21);
		btnGuardar.addActionListener(this);
		panelDatos.add(btnGuardar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(495, 76, 132, 21);
		btnActualizar.addActionListener(this);
		panelDatos.add(btnActualizar);
		
		lblErrorId = new JLabel("");
		lblErrorId.setForeground(new Color(165, 42, 42));
		lblErrorId.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblErrorId.setBounds(57, 12, 257, 13);
		panelDatos.add(lblErrorId);
		
		lblErrorNombre = new JLabel("");
		lblErrorNombre.setForeground(new Color(165, 42, 42));
		lblErrorNombre.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblErrorNombre.setBounds(57, 58, 257, 13);
		panelDatos.add(lblErrorNombre);
		
		lblErrorPrecio = new JLabel("");
		lblErrorPrecio.setForeground(new Color(165, 42, 42));
		lblErrorPrecio.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblErrorPrecio.setBounds(57, 103, 257, 13);
		panelDatos.add(lblErrorPrecio);
		
		lblErrorStock = new JLabel("");
		lblErrorStock.setForeground(new Color(165, 42, 42));
		lblErrorStock.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblErrorStock.setBounds(57, 148, 257, 13);
		panelDatos.add(lblErrorStock);
		
		cbTipo = new JComboBox();
		cbTipo.setModel(new DefaultComboBoxModel<TipoProductos>(TipoProductos.values()));
		cbTipo.setBounds(355, 31, 272, 21);
		panelDatos.add(cbTipo);
		
		lblErrorCb = new JLabel("");
		lblErrorCb.setForeground(new Color(165, 42, 42));
		lblErrorCb.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblErrorCb.setBounds(353, 12, 257, 13);
		panelDatos.add(lblErrorCb);
		desHabiliarBotones();
	}
	
	public void actionPerformed(ActionEvent pEvento) {

		String comando = pEvento.getActionCommand();

		if (comando.equals(GUARDAR)) {
			String id = txtID.getText();
			String nombre = txtNombre.getText();
			String precio = txtPrecio.getText();
			String stock = txtStock.getText();
			TipoProductos tipo =(TipoProductos) cbTipo.getSelectedItem();
			/* Errores*/
			String errorId = interfaz.validarCampoNumeroEntero(id);
			String errorNombre= interfaz.validarCampoTexto(nombre);
			String errorPrecio= interfaz.validarCampoNumeroDouble(precio);
			String errorStock= interfaz.validarCampoNumeroEntero(stock);
			lblErrorId.setText(errorId);
			lblErrorNombre.setText(errorNombre);
			lblErrorPrecio.setText(errorPrecio);
			lblErrorStock.setText(errorStock);
			if(errorId.equals("") && errorNombre.equals("") && errorPrecio.equals("") && errorStock.equals("")) {
				int Id = Integer.parseInt(id);
				double Precio = Double.parseDouble(precio);
				int Stock = Integer.parseInt(stock);
				if(interfaz.sistema().ingresarNuevoProducto(new Productos(Id, nombre, Precio, Stock,tipo))==null) {
			        modelo.addRow(new Object[] {id,nombre, precio,stock,tipo}); 
			        desHabiliarBotones() ;
					 limpiar();
				}else {
					lblErrorId.setText("Id ya existente");
				}
			}
			
		} else if (comando.equals(ACTUALIZAR)) {
			String id = txtID.getText();
			String nombre = txtNombre.getText();
			String precio = txtPrecio.getText();
			String stock = txtStock.getText();
			TipoProductos tipo =(TipoProductos) cbTipo.getSelectedItem();
			/* Errores*/
			String errorId = interfaz.validarCampoNumeroEntero(id);
			String errorNombre= interfaz.validarCampoTexto(nombre);
			String errorPrecio= interfaz.validarCampoNumeroDouble(precio);
			String errorStock= interfaz.validarCampoNumeroEntero(stock);
			
			lblErrorId.setText(errorId);
			lblErrorNombre.setText(errorNombre);
			lblErrorPrecio.setText(errorPrecio);
			lblErrorStock.setText(errorStock);
			if(errorId.equals("") && errorNombre.equals("") && errorPrecio.equals("") && errorStock.equals("")) {
					int Id = Integer.parseInt(id);
					double Precio = Double.parseDouble(precio);
					int Stock = Integer.parseInt(stock);
					if(interfaz.sistema().actualizarProducto(new Productos(Id, nombre, Precio, Stock,tipo))!=null) {
			        boolean salir = true;
			        for (int i = 0; i < tableProductos.getRowCount() && salir; i++)
			        if (tableProductos.getValueAt(i, 0).equals(id)) {
			        	tableProductos.setValueAt(nombre, i, 1);
			        	tableProductos.setValueAt(Precio, i, 2);
			        	tableProductos.setValueAt(Stock, i, 3);
			        	tableProductos.setValueAt(tipo, i, 3);
			        	desHabiliarBotones() ;
						 limpiar();
						 salir = false;
			        }
			        
				}else {
					lblErrorId.setText("Id no existente");
				}
			}
	
		}else if (comando.equals(EDITAR)) {
			
			txtID.setText(tableProductos.getValueAt(tableProductos.getSelectedRow(), 0).toString());
			txtNombre.setText(tableProductos.getValueAt(tableProductos.getSelectedRow(), 1).toString());
			txtPrecio.setText(tableProductos.getValueAt(tableProductos.getSelectedRow(), 2).toString());
			txtStock.setText(tableProductos.getValueAt(tableProductos.getSelectedRow(), 3).toString());
			cbTipo.setSelectedItem(tableProductos.getValueAt(tableProductos.getSelectedRow(), 4));
			desHabiliarBotones();
			btnEditar.setEnabled(false);
			btnEliminar.setEnabled(false);
			btnActualizar.setEnabled(true);
			txtID.setEditable(false);
			btnGuardar.setEnabled(false);
		}else if (comando.equals(ELIMINAR)) {
			if(interfaz.sistema().eliminarProducto(Integer.parseInt(tableProductos.getValueAt(tableProductos.getSelectedRow(), 0).toString()))){
				modelo.removeRow(tableProductos.getSelectedRow());
				desHabiliarBotones();
			}else {
				lblErrorId.setText("Id no existente");
			}
		}
	}
	public void habiliarBotones() {
		btnEditar.setEnabled(true);
		btnEliminar.setEnabled(true);

	}
	
	public void desHabiliarBotones() {
		btnEditar.setEnabled(false);
		btnEliminar.setEnabled(false);
		btnActualizar.setEnabled(false);
		btnGuardar.setEnabled(true);
		txtID.setEditable(true);
		tableProductos.clearSelection();
	}
	public void limpiar() {
		txtID.setText("");
		txtNombre.setText("");
		txtPrecio.setText("");
		txtStock.setText("");
	}
	
public void refrescar() {
		modelo.setRowCount(0);


		for (Productos productos: interfaz.sistema().getCatalogo()) {
			  modelo.addRow(new Object[] {productos.getIdProductos(),productos.getNombreProductos(), productos.getPrecio(),productos.getStock(),productos.getTipo()}); 
		}
	}
}
