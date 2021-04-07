package InterfazPrincipal;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import mundo.Cliente;
import mundo.DetalleFactura;
import mundo.Factura;
import mundo.Productos;

public class PanelFacturas extends JPanel {
	private InterfazPrincipal principal;
	 private JTable tableFacturas;
		private DefaultTableModel modelo;
		private ArrayList<Factura> facturas;
	 public PanelFacturas(InterfazPrincipal principal) {
		 this.principal = principal;
		this.facturas = principal.sistema().getFacuras();
		 setSize(900, 650);
			setLayout(null);
			
			JPanel panelDatos = new JPanel();
			panelDatos.setLayout(null);
			panelDatos.setBackground(Color.ORANGE);
			panelDatos.setBounds(0, 100, 900, 560);
			add(panelDatos);
			
			JLabel lblErrorCedula = new JLabel("");
			lblErrorCedula.setForeground(new Color(165, 42, 42));
			lblErrorCedula.setFont(new Font("Tahoma", Font.BOLD, 10));
			lblErrorCedula.setBounds(57, 12, 257, 13);
			panelDatos.add(lblErrorCedula);
			
			JLabel lblErrorNombre = new JLabel("");
			lblErrorNombre.setForeground(new Color(165, 42, 42));
			lblErrorNombre.setFont(new Font("Tahoma", Font.BOLD, 10));
			lblErrorNombre.setBounds(57, 58, 257, 13);
			panelDatos.add(lblErrorNombre);
			
			JLabel lblErrorApellido = new JLabel("");
			lblErrorApellido.setForeground(new Color(165, 42, 42));
			lblErrorApellido.setFont(new Font("Tahoma", Font.BOLD, 10));
			lblErrorApellido.setBounds(57, 103, 257, 13);
			panelDatos.add(lblErrorApellido);
			
			JLabel lblErrorTelefono = new JLabel("");
			lblErrorTelefono.setForeground(new Color(165, 42, 42));
			lblErrorTelefono.setFont(new Font("Tahoma", Font.BOLD, 10));
			lblErrorTelefono.setBounds(57, 148, 257, 13);
			panelDatos.add(lblErrorTelefono);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(22, 23, 840, 474);
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			
			panelDatos.add(scrollPane);
			String[] columnNames = { "n° Factura", "cedula cliente"};
			Object[][] data = { };
			modelo = new DefaultTableModel(data, columnNames);
			tableFacturas = new JTable(modelo);
			tableFacturas.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
		        public void valueChanged(ListSelectionEvent event) {
		        	String cedula = tableFacturas.getValueAt(tableFacturas.getSelectedRow(), 1).toString();
		        	String idFactura = tableFacturas.getValueAt(tableFacturas.getSelectedRow(), 0).toString();
		        	Cliente cliente = principal.sistema().buscarClientePorCedula(cedula);
		        	Factura factura = principal.sistema().buscarFacturaPorId(idFactura);
		        	JDialogFactura vistaFactura = new JDialogFactura(principal, true, cliente, factura);
		        	
		        }
		    });
			scrollPane.setViewportView(tableFacturas);
			
			JPanel panelCabezera = new JPanel();
			panelCabezera.setLayout(null);
			panelCabezera.setBackground(Color.DARK_GRAY);
			panelCabezera.setBounds(0, 0, 900, 100);
			add(panelCabezera);
			
			JLabel lblFacturas = new JLabel("FACTURAS");
			lblFacturas.setToolTipText("");
			lblFacturas.setHorizontalAlignment(SwingConstants.CENTER);
			lblFacturas.setForeground(Color.WHITE);
			lblFacturas.setFont(new Font("Tahoma", Font.BOLD, 26));
			lblFacturas.setBounds(10, 5, 880, 67);
			panelCabezera.add(lblFacturas);
			
			refrescar();
			
	 }
	 
	 public void refrescar() {
		 modelo.setRowCount(0);
			for (Factura factura : principal.sistema().getFacturas()) {
				Cliente cliente = factura.getCliente();
				 modelo.addRow(new Object[] {factura.getIdFactura(),cliente.getCedula()}); 
			}
		}

}
