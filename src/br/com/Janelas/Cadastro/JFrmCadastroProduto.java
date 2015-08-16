package br.com.Janelas.Cadastro;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Window.Type;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrmCadastroProduto extends JDialog implements ActionListener {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnSalvar;
	private JButton btnDeletar;
	private JButton btnApagar;
	private JButton btnSair;
	private JButton btnBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrmCadastroProduto frame = new JFrmCadastroProduto();
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
	public JFrmCadastroProduto() {
		setType(Type.UTILITY);
		// setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 41, 374, 250);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(10, 10, 60, 20);
		panel.add(lblCdigo);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(10, 30, 120, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(10, 55, 93, 20);
		panel.add(lblDescrio);

		textField = new JTextField();
		textField.setBounds(10, 75, 355, 20);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setBounds(10, 150, 81, 20);
		panel.add(lblPreo);

		textField_1 = new JTextField();
		textField_1.setBounds(10, 125, 120, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblEstMinimo = new JLabel("Est. Minimo");
		lblEstMinimo.setBounds(10, 105, 93, 20);
		panel.add(lblEstMinimo);

		textField_2 = new JTextField();
		textField_2.setBounds(10, 170, 120, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblClassificao = new JLabel("Classifica\u00E7\u00E3o");
		lblClassificao.setBounds(160, 150, 100, 20);
		panel.add(lblClassificao);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(160, 125, 204, 20);
		panel.add(comboBox);

		JLabel lblLocalizao = new JLabel("Localiza\u00E7\u00E3o");
		lblLocalizao.setBounds(160, 105, 81, 20);
		panel.add(lblLocalizao);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(160, 170, 205, 20);
		panel.add(comboBox_1);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 210, 80, 20);
		panel.add(btnSalvar);

		btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(100, 210, 80, 20);
		panel.add(btnDeletar);

		btnApagar = new JButton("Apagar");
		btnApagar.setBounds(195, 210, 80, 20);
		panel.add(btnApagar);

		btnSair = new JButton("Sair");
		btnSair.setBounds(285, 210, 80, 20);
		panel.add(btnSair);

		JLabel lblPesquisarCdigo = new JLabel("Pesquisar C\u00F3digo");
		lblPesquisarCdigo.setBounds(10, 11, 128, 20);
		contentPane.add(lblPesquisarCdigo);

		textField_3 = new JTextField();
		textField_3.setBounds(122, 10, 145, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(294, 10, 89, 20);
		contentPane.add(btnBuscar);
		
		btnApagar.addActionListener(this);
		btnBuscar.addActionListener(this);
		btnDeletar.addActionListener(this);
		btnSair.addActionListener(this);
		btnSalvar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		System.out.println(acao);

		switch (acao) {
		case "Buscar":
			// TODO - Falta implementar
			break;
		case "Salvar":
			// TODO - Falta implementar

			break;
		case "Deletar":
			// TODO - Falta implementar

			break;
		case "Apagar":
			// TODO - Falta implementar

			break;
		case "Sair":
			dispose();

			break;

		default:
			break;
		}

	}
}
