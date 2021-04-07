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
import mundo.Factura;
import mundo.Fecha;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class PanelCliente extends JPanel implements ActionListener{
	public final static String GUARDAR = "Guardar";
	private final static String ACTUALIZAR = "Actualizar";
	public final static String EDITAR = "Editar";
	private final static String ELIMINAR= "Eliminar";
	
	JPanel panelCabezera;
	InterfazPrincipal interfaz;
	JPanel panelDatos;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JPanel panel;
	private JTable tableClientes;
	private JLabel lblErrorCedula;
	private JLabel lblErrorNombre;
	private JLabel lblErrorApellido;
	private JLabel lblErrorTelefono;
	private JButton btnGuardar;
	private JButton btnEliminar;
	private JButton btnEditar;
	private JButton btnActualizar;
	private DefaultTableModel modelo; 
	public PanelCliente(InterfazPrincipal interfaz){
		this.interfaz = interfaz;
		setSize(900, 650);
		setLayout(null);
		
		panelCabezera = new JPanel();
		panelCabezera.setBackground(new Color(64, 64, 64));
		panelCabezera.setBounds(0, 0, 900, 100);
		add(panelCabezera);
		panelCabezera.setLayout(null);
		
		JLabel lblCabecera = new JLabel("Registrar Cliente");
		lblCabecera.setHorizontalAlignment(SwingConstants.CENTER);
		lblCabecera.setToolTipText("");
		lblCabecera.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblCabecera.setForeground(Color.WHITE);
		lblCabecera.setBounds(10, 5, 880, 67);
		panelCabezera.add(lblCabecera);
		
		panelDatos = new JPanel();
		panelDatos.setBackground(new Color(255, 200, 0));
		panelDatos.setBounds(0, 100, 900, 600);
		add(panelDatos);
		panelDatos.setLayout(null);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(57, 35, 77, 13);
		panelDatos.add(lblCedula);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(143, 35, 171, 19);
		panelDatos.add(txtCedula);
		txtCedula.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(57, 80, 77, 13);
		panelDatos.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(143, 80, 171, 19);
		panelDatos.add(txtNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(57, 125, 77, 13);
		panelDatos.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(143, 125, 171, 19);
		panelDatos.add(txtApellido);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(57, 170, 77, 13);
		panelDatos.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(143, 170, 171, 19);
		panelDatos.add(txtTelefono);
		
		panel = new JPanel();
		panel.setBackground(new Color(64,64,64));
		panel.setBounds(0, 217, 900, 326);
		panelDatos.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 82, 840, 207);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		panel.add(scrollPane);
		String[] columnNames = { "Cedula", "Nombre", "Apellido", "Telefono"};
		Object[][] data = { };
		modelo = new DefaultTableModel(data, columnNames);
		tableClientes = new JTable(modelo);
		tableClientes.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	        	habiliarBotones();
	        }
	    });
		scrollPane.setViewportView(tableClientes);
		
		 btnEditar = new JButton("Editar");
		btnEditar.setBounds(30, 51, 132, 21);
		btnEditar.addActionListener(this);
		panel.add(btnEditar);
		
		 btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(186, 51, 132, 21);
		btnEliminar.addActionListener(this);
		panel.add(btnEliminar);
		
		 btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(366, 22, 132, 21);
		btnGuardar.addActionListener(this);
		panelDatos.add(btnGuardar);
		
		 btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(366, 49, 132, 21);
		btnActualizar.addActionListener(this);
		panelDatos.add(btnActualizar);
		
		lblErrorCedula = new JLabel("");
		lblErrorCedula.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblErrorCedula.setForeground(new Color(165, 42, 42));
		lblErrorCedula.setBounds(57, 12, 257, 13);
		panelDatos.add(lblErrorCedula);
		
		lblErrorNombre = new JLabel("");
		lblErrorNombre.setForeground(new Color(165, 42, 42));
		lblErrorNombre.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblErrorNombre.setBounds(57, 58, 257, 13);
		panelDatos.add(lblErrorNombre);
		
		lblErrorApellido = new JLabel("");
		lblErrorApellido.setForeground(new Color(165, 42, 42));
		lblErrorApellido.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblErrorApellido.setBounds(57, 103, 257, 13);
		panelDatos.add(lblErrorApellido);
		
		lblErrorTelefono = new JLabel("");
		lblErrorTelefono.setForeground(new Color(165, 42, 42));
		lblErrorTelefono.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblErrorTelefono.setBounds(57, 148, 257, 13);
		panelDatos.add(lblErrorTelefono);
		desHabiliarBotones();
	}
	
	public void actionPerformed(ActionEvent pEvento) {

		String comando = pEvento.getActionCommand();

		if (comando.equals(GUARDAR)) {
			String cedula = txtCedula.getText();
			String nombre = txtNombre.getText();
			String apellido = txtApellido.getText();
			String telefono = txtTelefono.getText();
			/* Errores*/
			String errorCedula = interfaz.validarCampoCedula(cedula);
			String errorNombre= interfaz.validarCampoTexto(nombre);
			String errorApellido= interfaz.validarCampoTexto(apellido);
			String errorTelefono= interfaz.validarCampoNumeroEntero(telefono);
			lblErrorCedula.setText(errorCedula);
			lblErrorNombre.setText(errorNombre);
			lblErrorApellido.setText(errorApellido);
			lblErrorTelefono.setText(errorTelefono);
			if(errorCedula.equals("") && errorNombre.equals("") && errorApellido.equals("") && errorTelefono.equals("")) {
				Calendar c = new GregorianCalendar();
				Fecha fecha = new Fecha(c.get(Calendar.DATE) ,c.get(Calendar.MONTH), c.get(Calendar.YEAR));
				if(interfaz.sistema().ingresarNuevoCliente(new Cliente(cedula, nombre, apellido, telefono, fecha))==null) {
			        modelo.addRow(new Object[] {cedula,nombre, apellido,telefono}); 
			        desHabiliarBotones() ;
					 limpiar();
				}else {
					lblErrorCedula.setText("Cedula ya existente");
				}
			}
			
		} else if (comando.equals(ACTUALIZAR)) {
			String cedula = txtCedula.getText();
			String nombre = txtNombre.getText();
			String apellido = txtApellido.getText();
			String telefono = txtTelefono.getText();
			/* Errores*/
			String errorCedula = interfaz.validarCampoCedula(cedula);
			String errorNombre= interfaz.validarCampoTexto(nombre);
			String errorApellido= interfaz.validarCampoTexto(apellido);
			String errorTelefono= interfaz.validarCampoNumeroEntero(telefono);
			lblErrorCedula.setText(errorCedula);
			lblErrorNombre.setText(errorNombre);
			lblErrorApellido.setText(errorApellido);
			lblErrorTelefono.setText(errorTelefono);
			if(errorCedula.equals("") && errorNombre.equals("") && errorApellido.equals("") && errorTelefono.equals("")) {
				Calendar c = new GregorianCalendar();
				Fecha fecha = new Fecha(c.get(Calendar.DATE) ,c.get(Calendar.MONTH), c.get(Calendar.YEAR));
				if(interfaz.sistema().actualizarCliente(new Cliente(cedula, nombre, apellido, telefono, fecha))!=null) {
			        boolean salir = true;
			        for (int i = 0; i < tableClientes.getRowCount() && salir; i++)
			        if (tableClientes.getValueAt(i, 0).equals(cedula)) {
			        	tableClientes.setValueAt(nombre, i, 1);
			        	tableClientes.setValueAt(apellido, i, 2);
			        	tableClientes.setValueAt(telefono, i, 3);
			        	desHabiliarBotones() ;
						 limpiar();
						 salir = false;
			        }
			        
				}else {
					lblErrorCedula.setText("Cedula no existente");
				}
			}
	
		}else if (comando.equals(EDITAR)) {
			txtCedula.setText(tableClientes.getValueAt(tableClientes.getSelectedRow(), 0).toString());
			txtNombre.setText(tableClientes.getValueAt(tableClientes.getSelectedRow(), 1).toString());
			txtApellido.setText(tableClientes.getValueAt(tableClientes.getSelectedRow(), 2).toString());
			txtTelefono.setText(tableClientes.getValueAt(tableClientes.getSelectedRow(), 3).toString());
			desHabiliarBotones() ;
			btnActualizar.setEnabled(true);
			txtCedula.setEditable(false);
			btnGuardar.setEnabled(false);
		}else if (comando.equals(ELIMINAR)) {
			if(interfaz.sistema().eliminarCliente(tableClientes.getValueAt(tableClientes.getSelectedRow(), 0).toString())){
				modelo.removeRow(tableClientes.getSelectedRow());
				desHabiliarBotones();

			}else {
				lblErrorCedula.setText("Cedula no existente");
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
		txtCedula.setEditable(true);
		tableClientes.clearSelection();
	}
	public void limpiar() {
		txtCedula.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtTelefono.setText("");
	}
	public void refrescar() {
		modelo.setRowCount(0);
		
		for (Cliente cliente: interfaz.sistema().getClientes()) {
			modelo.addRow(new Object[] {cliente.getCedula(),cliente.getNombre(),cliente.getApellido(),cliente.getTelefono()}); 
		}
	}
}
