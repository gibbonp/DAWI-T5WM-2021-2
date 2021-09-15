package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Producto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class FrmManteProducto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql8");
	EntityManager em = fabrica.createEntityManager();
	private JTextArea txtSalida;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManteProducto frame = new FrmManteProducto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmManteProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrar();
			}
		});
		btnRegistrar.setBounds(335, 11, 89, 23);
		contentPane.add(btnRegistrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 87, 414, 140);
		contentPane.add(scrollPane);
		
		txtSalida = new JTextArea();
		scrollPane.setViewportView(txtSalida);
		
		JButton btnListar = new JButton("Listado");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listar();
			}
		});
		btnListar.setBounds(174, 235, 89, 23);
		contentPane.add(btnListar);
	}
	
	void listar() {
		List<Producto> lstProducto = em.createQuery("select p from Producto p", Producto.class).getResultList();
		txtSalida.setText(">>> Listado de Productos <<<\n");
		System.out.println("Nro de Produtos : "+ lstProducto.size());
		for (Producto p : lstProducto) {
			txtSalida.append(p.getCodigo() + "\t" + p.getDescripcion() + "\t" + p.getPrecio() + "\n");
		}
		txtSalida.append("--------------------------------------------\n");
	}
	
	void registrar() {
				
		Producto p = new Producto();
		p.setCodigo("P0032");
		p.setDescripcion("TapsinMigrol");
		p.setStock(10);
		p.setPrecio(2.50);
		p.setIdcategoria(5);
		p.setEstado(1);
		
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		
		System.out.println("Producto Registrado");
		
	}
}
