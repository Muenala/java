package InterfazPrincipal;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;

public class PanelUsuarios extends JPanel{
	JPanel panelCabezera;
	private JPanel panelDatos;
	private JLabel lblCorreo;
	private JTextField txtCorreo;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblContrasenia;
	private JTextField txtContrasenia;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JButton btnGuardar;
	private JButton btnActualizar;
	private JLabel lblErrorCedula;
	private JLabel lblErrorNombre;
	private JLabel lblErrorApellido;
	private JLabel lblErrorTelefono;
	public PanelUsuarios(){
		setSize(900, 650);
		setLayout(null);
		
		panelCabezera = new JPanel();
		panelCabezera.setBackground(new Color(64, 64, 64));
		panelCabezera.setBounds(0, 0, 900, 100);
		add(panelCabezera);
		panelCabezera.setLayout(null);
		
		JLabel lblCabecera = new JLabel("Usuarios");
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
		
		lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(57, 35, 77, 13);
		panelDatos.add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setEditable(true);
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(143, 35, 171, 19);
		panelDatos.add(txtCorreo);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(57, 80, 77, 13);
		panelDatos.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(143, 80, 171, 19);
		panelDatos.add(txtNombre);
		
		lblContrasenia = new JLabel("Contrase\u00F1a:");
		lblContrasenia.setBounds(57, 125, 77, 13);
		panelDatos.add(lblContrasenia);
		
		txtContrasenia = new JTextField();
		txtContrasenia.setColumns(10);
		txtContrasenia.setBounds(143, 125, 171, 19);
		panelDatos.add(txtContrasenia);
		
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
		
		btnEditar = new JButton("Editar");
		btnEditar.setEnabled(false);
		btnEditar.setBounds(30, 51, 132, 21);
		panel.add(btnEditar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(186, 51, 132, 21);
		panel.add(btnEliminar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setEnabled(true);
		btnGuardar.setBounds(366, 22, 132, 21);
		panelDatos.add(btnGuardar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setEnabled(false);
		btnActualizar.setBounds(366, 49, 132, 21);
		panelDatos.add(btnActualizar);
		
		lblErrorCedula = new JLabel("");
		lblErrorCedula.setForeground(new Color(165, 42, 42));
		lblErrorCedula.setFont(new Font("Tahoma", Font.BOLD, 10));
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
	}
}
