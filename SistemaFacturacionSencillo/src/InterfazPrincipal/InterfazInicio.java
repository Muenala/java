package InterfazPrincipal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import mundo.Cliente;
import mundo.Usuario;

public class InterfazInicio extends JDialog implements ActionListener {
	/** Atributos */
	InterfazPrincipal principal;
	/** Zona de texto para el nombre */
	private JTextField txtUser;

	/** Zona de texto para la contrase�a */
	private JPasswordField txtPassword;

	/** Zona de texto para la imagen contrase�a */
	private JLabel labImagenPassword;

	/** Zona de texto para el usuario */
	private JLabel labUsuario;

	/** Zona de texto para la contrase�a */
	private JLabel labPassword;

	Color color;
	public final static String INGRESAR = "Ingresar";

	/**
	 * Comando para cancelar o salir del sistema.
	 */
	private final static String CANCELAR = "Cancelar";
	private JButton butIniciarSesion;



	/** Bot�n para cancelar */
	private JButton butCancelar;
	private JPanel panelIngreso;
	private JPanel panelBotones;

	public InterfazInicio( JFrame parent, boolean modal) {
		super(parent, modal);
		principal = (InterfazPrincipal) parent;

		setTitle("Iniciar Sesi�n");
		setSize(500, 300);

		color = new Color(255, 200, 0);
		getContentPane().setLayout(null);

		panelBotones = new JPanel();
		panelBotones.setBackground(new Color(64, 64, 64));
		panelBotones.setBounds(0, 167, 486, 96);
		getContentPane().add(panelBotones);
		panelBotones.setLayout(null);

		panelIngreso = new JPanel();
		panelIngreso.setBackground(new Color(255, 200, 0));
		panelIngreso.setBounds(0, 0, 486, 166);
		getContentPane().add(panelIngreso);
		panelIngreso.setLayout(null);

		txtUser = new JTextField("");
		txtUser.setBounds(157, 33, 233, 27);
		txtUser.setEditable(true);
		txtUser.setBackground(Color.BLACK);
		txtUser.setForeground(Color.WHITE);
		

		txtPassword = new JPasswordField("");
		txtPassword.setBounds(157, 84, 233, 27);
		txtPassword.setEditable(true);
		txtPassword.setBackground(Color.BLACK);
		txtPassword.setForeground(Color.WHITE);

		labUsuario = new JLabel("User");
		labUsuario.setBounds(53, 33, 94, 37);

		labPassword = new JLabel("Password");
		labPassword.setBounds(53, 60, 94, 74);

		/** distribuidor de graficos */
		panelIngreso.setLayout(null);
		panelIngreso.add(labUsuario);
		panelIngreso.add(txtUser);
		
		panelIngreso.add(labPassword);
		panelIngreso.add(txtPassword);

		butIniciarSesion = new JButton("Ingresar");
		butIniciarSesion.addActionListener(this);
		butIniciarSesion.setActionCommand(INGRESAR);
		butIniciarSesion.setForeground(Color.BLACK);
		butIniciarSesion.setBackground(Color.WHITE);
		butIniciarSesion.setBounds(10, 37, 200, 30);

		

		butCancelar = new JButton("Cancelar");
		butCancelar.addActionListener(this);
		butCancelar.setActionCommand(CANCELAR);
		butCancelar.setForeground(Color.BLACK);
		butCancelar.setBackground(Color.WHITE);
		butCancelar.setBounds(256, 37, 200, 30);
		panelBotones.add(butIniciarSesion);
		panelBotones.add(butCancelar);
		
		/** Para el fondo */
		setVisible(true);
		
	}

	/** Metodos **/
	public void iniciarSesion() {

		String usuario = txtUser.getText();
		String contrasenia = new String(txtPassword.getPassword());
		if (usuario.equals("") && contrasenia.equals("")) {
			principal.iniciarSesion(new Usuario("", "", ""));
			dispose();
		}
		/*
		 * Statement s = mySQL.createStatement(); ResultSet rs =
		 * s.executeQuery("select * from usuario where nombre_usu='" + usuario + "'");
		 * while (rs.next()) { principal.iniciarSesion(new Usuario(rs.getString(2),
		 * rs.getString(3), rs.getString(4))); dispose(); } } catch (SQLException e) {
		 * e.printStackTrace(); }
		 */
	}

	public void actionPerformed(ActionEvent pEvento) {

		String comando = pEvento.getActionCommand();

		if (comando.equals(INGRESAR)) {
			iniciarSesion();

		} else if (comando.equals(CANCELAR)) {
			principal.cerrar();
			// InterfazInicio inicio = new InterfazInicio();
			// inicio.dispose();

		}
	}
}

