package eam.desarrollo.hospital.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import eam.desarollo.hospital.vistas.VentanaMedicamentoProvedor;
import eam.desarrollo.hospital.entidades.Cama;
import eam.desarrollo.hospital.entidades.EstadoCama;
import eam.desarrollo.hospital.entidades.Habitacion;
import eam.desarrollo.hospital.entidades.Medicamento;
import eam.desarrollo.hospital.entidades.MedicamentoProveedor;
import eam.desarrollo.hospital.entidades.Proveedor;
import eam.desarrollo.hospital.DAO.DAOMedicamentoProveedor;

public class controladorMedicamentoProveedor implements ActionListener {
	public VentanaMedicamentoProvedor ventanamedicamentoproveedor;
	public MedicamentoProveedor nuevo_medicamento_proveedor;
	public DAOMedicamentoProveedor Midao = new DAOMedicamentoProveedor();
	public ArrayList<Medicamento> listaMedicamento;
	public ArrayList<Proveedor> listaProveedor;
	
	
	
	
	public controladorMedicamentoProveedor(VentanaMedicamentoProvedor ventanamedicamentoproveedor) {
		super();
		this.ventanamedicamentoproveedor = ventanamedicamentoproveedor;
		listenerbotones();
		listarMedicamento();
		listarProveedor();
		
	}
	

	private void listenerbotones() {
		// TODO Auto-generated method stub
		try {
			this.ventanamedicamentoproveedor.btnRegistrar.addActionListener(this);
			this.ventanamedicamentoproveedor.btnBuscar.addActionListener(this);
			this.ventanamedicamentoproveedor.btnEliminar.addActionListener(this);
			this.ventanamedicamentoproveedor.btnModificar.addActionListener(this);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	


	@Override
	public void actionPerformed(ActionEvent e) {
	
		switch (e.getActionCommand()) {
		case "REGISTRAR":
			if (verificarformulario()) {

				String proveedor = ventanamedicamentoproveedor.JCBProveedor.getSelectedItem().toString();

				String id = ventanamedicamentoproveedor.JTFId.getText();
				String lote=ventanamedicamentoproveedor.JTFLote.getText();
				String cantidad=ventanamedicamentoproveedor.JTFCantidad.getText();
				String medicamento= ventanamedicamentoproveedor.JCBMedicamento.getSelectedItem().toString();
				estado_cama = new EstadoCama(
						Integer.toString(ventanacama.JCBEstado.getSelectedIndex()), estado);
				habitacion = new Habitacion(Integer.toString(ventanacama.JCBHabitacion.getSelectedIndex()),habitaciones,null);
						
				nueva_cama = new Cama(id,estado_cama,habitacion);
				System.out.println(nueva_cama.getIdCama());

				try {
					Midao.crear(nueva_cama);
				} catch (Exception e1) {

				}
				ventanacama.JCBEstado.setSelectedIndex(0);
				// ventanapaciente.dateChooser.setDate(null);
				Limpiarformulario();
				
			} else {
				JOptionPane.showMessageDialog(null, "Por favor ingrese sus datos", "Info",
						JOptionPane.INFORMATION_MESSAGE);
			}

			break;

		case "ELIMINAR":
			try {
				if (!verificarVacio()) {
					Midao.eliminar(ventanacama.JTFId.getText());
					ventanacama.JCBEstado.setSelectedIndex(0);
					ventanacama.JCBHabitacion.setSelectedIndex(0);
			
					Limpiarformulario();
					JOptionPane.showMessageDialog(null, "Cama eliminada", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Llene el campo requerido");
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

		case "ACTUALIZAR":
			String estado = ventanacama.JCBEstado.getSelectedItem().toString();
			String habitaciones= ventanacama.JCBHabitacion.getSelectedItem().toString();
			String id = ventanacama.JTFId.getText();
			
			
			estado_cama = new EstadoCama(Integer.toString(ventanacama.JCBEstado.getSelectedIndex()),
					estado);
			habitacion = new Habitacion(Integer.toString(ventanacama.JCBHabitacion.getSelectedIndex()),habitaciones,null);
			
			nueva_cama = new Cama(id,estado_cama,habitacion);
			try {
				Midao.actualizar(nueva_cama);
				ventanacama.JCBEstado.setSelectedIndex(0);
				Limpiarformulario();
				JOptionPane.showMessageDialog(null, "Cama actualizada", "Info", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
			
		case "BUSCAR":
			try {
				nueva_cama = Midao.buscar(ventanacama.JTFId.getText());
				if (nueva_cama != null) {
					ventanacama.JCBEstado.setSelectedIndex(
							Integer.parseInt(nueva_cama.getEstadoCama().getIdEstadoCama()));
					ventanacama.JCBHabitacion.setSelectedIndex(Integer.parseInt(nueva_cama.getHabitacion().getIdHabitacion()));
					
					JOptionPane.showMessageDialog(null, "Cama encontrada", "Info", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Cama no encontrada", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			break;
			/**
		case "Actualizar tabla":
			try {
			CargarTabla();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			break;
**/
		}
	}
	
	public boolean verificarformulario() {

		if (this.ventanamedicamentoproveedor.JTFId.getText().equals("") || this.ventanamedicamentoproveedor.JCBMedicamento.getSelectedItem()=="SELECCIONE OPCION" || this.ventanamedicamentoproveedor.JCBProveedor.getSelectedItem()=="SELECCIONE OPCION"||this.ventanamedicamentoproveedor.JTFCantidad.getText().equals("")||this.ventanamedicamentoproveedor.JTFLote.getText().equals("")) {
			return false;
		}
		return true;
	}

	public boolean verificarVacio() {

		if (this.ventanamedicamentoproveedor.JTFId.getText().equals("") ) {
			return true;
		}
		return false;
	}
	

}
