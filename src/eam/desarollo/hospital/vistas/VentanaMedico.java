package eam.desarollo.hospital.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import eam.desarrollo.hospital.controladores.controladorMedico;
import eam.desarrollo.hospital.controladores.controladorPaciente;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;

public class VentanaMedico {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMedico window = new VentanaMedico();
					window.frmMedico.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaMedico() {
		initialize();
		micontroladormedico =  new controladorMedico(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMedico = new JFrame();
		frmMedico.setTitle("Medico");
		frmMedico.setBounds(100, 100, 712, 377);
		frmMedico.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel lblIdmedico = new JLabel("Id medico:");
		lblIdmedico.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JTFIdmedico.setColumns(10);

		JLabel lblNombreMedico = new JLabel("Nombre medico:");
		lblNombreMedico.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JTFNombremedico.setColumns(10);

		JLabel lblApellidoMedico = new JLabel("Apellido medico:");
		lblApellidoMedico.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JTFApellidomedico.setColumns(10);

		JLabel lblTelefonoMedico = new JLabel("Telefono medico:");
		lblTelefonoMedico.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JTFTelefonomedico.setColumns(10);

		JLabel lblDireccionMedico = new JLabel("Direccion medico:");
		lblDireccionMedico.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JTFDireccionmedico.setColumns(10);

		JLabel lblEmailMedico = new JLabel("Email medico:");
		lblEmailMedico.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JTFEmailmedico.setColumns(10);

		JLabel lblTelefonoEmergencia = new JLabel("Telefono emergencia:");
		lblTelefonoEmergencia.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JTFTelefonoemergencia.setColumns(10);

		JLabel lblFechaNacimiento = new JLabel("Fecha nacimiento:");
		lblFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblLicenciaMedicaN = new JLabel("Numero de documento: ");
		lblLicenciaMedicaN.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JTFNumerodocumento.setColumns(10);

		JCBTipodocumentomedico.setModel(new DefaultComboBoxModel(new String[] { "SELECCIONE" }));

		JLabel lblTipoDocumento = new JLabel("Tipo documento:");
		lblTipoDocumento.setFont(new Font("Tahoma", Font.PLAIN, 14));

		GroupLayout groupLayout = new GroupLayout(frmMedico.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(21)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblIdmedico)
						.addComponent(lblLicenciaMedicaN).addComponent(lblNombreMedico).addComponent(lblTelefonoMedico)
						.addComponent(lblEmailMedico))
				.addPreferredGap(ComponentPlacement.RELATED, 5, Short.MAX_VALUE)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(JTFEmailmedico, 151, 151, 151)
						.addComponent(JTFTelefonomedico, 151, 151, 151)
						.addComponent(JTFNombremedico, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(JTFNumerodocumento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(JTFIdmedico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblTelefonoEmergencia)
						.addComponent(lblDireccionMedico).addComponent(lblApellidoMedico).addComponent(lblTipoDocumento)
						.addComponent(lblFechaNacimiento))
				.addGap(18)
				.addGroup(
						groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(JTFDireccionmedico, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
								.addComponent(JTFApellidomedico, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
								.addComponent(JTFTelefonoemergencia, 132, 132, Short.MAX_VALUE)
								.addComponent(JCBTipodocumentomedico, 0, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
				.addGap(84))
				.addGroup(groupLayout.createSequentialGroup().addGap(40)
						.addComponent(btnRegistrar, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
						.addGap(44).addComponent(btnBuscar).addGap(70).addComponent(btnEliminar).addGap(43)
						.addComponent(btnActualizar).addContainerGap(52, Short.MAX_VALUE)));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
						.createSequentialGroup().addGap(31).addGroup(groupLayout
								.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
										.createSequentialGroup().addGroup(groupLayout
												.createParallelGroup(Alignment.BASELINE).addComponent(lblIdmedico)
												.addComponent(JTFIdmedico, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblFechaNacimiento))
										.addGap(18)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblLicenciaMedicaN).addComponent(JTFNumerodocumento,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
										.addGap(25)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup().addGap(3)
														.addComponent(lblNombreMedico))
												.addComponent(JTFNombremedico, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblTelefonoMedico).addComponent(JTFTelefonomedico,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(JTFEmailmedico, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblEmailMedico)))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblTipoDocumento)
												.addComponent(JCBTipodocumentomedico, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(25)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(JTFApellidomedico, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblApellidoMedico))
										.addGap(18)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblDireccionMedico).addComponent(JTFDireccionmedico,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblTelefonoEmergencia).addComponent(JTFTelefonoemergencia,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))))
						.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnRegistrar, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 32,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBuscar, Alignment.TRAILING)
								.addComponent(btnEliminar, Alignment.TRAILING)
								.addComponent(btnActualizar, Alignment.TRAILING))
						.addGap(43)));
		groupLayout.linkSize(SwingConstants.VERTICAL,
				new Component[] { btnRegistrar, btnActualizar, btnEliminar, btnBuscar });
		groupLayout.linkSize(SwingConstants.HORIZONTAL,
				new Component[] { btnRegistrar, btnActualizar, btnEliminar, btnBuscar });
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] { JTFDireccionmedico, JTFTelefonoemergencia });
		groupLayout.linkSize(SwingConstants.HORIZONTAL,
				new Component[] { JTFIdmedico, JTFNombremedico, JTFTelefonomedico, JTFNumerodocumento });
		frmMedico.getContentPane().setLayout(groupLayout);
	}

	private JFrame frmMedico;
	public JTextField JTFIdmedico = new JTextField();
	public JTextField JTFNombremedico = new JTextField();
	public JTextField JTFApellidomedico = new JTextField();
	public JTextField JTFTelefonomedico = new JTextField();
	public JTextField JTFDireccionmedico = new JTextField();
	public JTextField JTFEmailmedico = new JTextField();
	public JTextField JTFTelefonoemergencia = new JTextField();
	public JTextField JTFNumerodocumento = new JTextField();
	public JComboBox JCBTipodocumentomedico = new JComboBox();
	public JDateChooser dateChooser = new JDateChooser();
	public JButton btnRegistrar = new JButton("REGISTRAR");
	public JButton btnActualizar = new JButton("ACTUALIZAR");
	public JButton btnEliminar = new JButton("ELIMINAR");
	public JButton btnBuscar = new JButton("BUSCAR");
	public static controladorMedico micontroladormedico;
}