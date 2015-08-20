package br.com.Janelas.Cadastro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import br.com.Persistence.*;
import br.com.Bin.*;


public class JFrmCadastroCargo extends JDialog implements ActionListener {

	private JPanel contentPane;
	private JTextField txtPesquisaNome;
	private JButton btnBuscar;
	private JButton btnSair;
	private JButton btnApagar;
	private JButton btnDeletar;
	private JButton btnSalvar;
	private JTextField txtCodigo;
	private Banco banco = new Banco();
	private JTextField txtDescricao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrmCadastroCargo frame = new JFrmCadastroCargo();
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
	public JFrmCadastroCargo() {
		setTitle("Cadastro de Cargo dos Funcinarios");
		setType(Type.UTILITY);
		// setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 215);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);

		JPanel panel = new JPanel();
		panel.setBorder((Border) new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 40, 374, 140);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(10, 10, 60, 20);
		panel.add(lblCdigo);

		txtCodigo = new JTextField();
		txtCodigo.setEnabled(false);
		txtCodigo.setBounds(10, 30, 120, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(10, 55, 93, 20);
		panel.add(lblDescrio);

		txtDescricao = new JTextField();
		txtDescricao.setBounds(10, 75, 355, 20);
		panel.add(txtDescricao);
		txtDescricao.setColumns(10);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 105, 80, 20);
		panel.add(btnSalvar);

		btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(100, 105, 80, 20);
		panel.add(btnDeletar);

		btnApagar = new JButton("Apagar");
		btnApagar.setBounds(195, 105, 80, 20);
		panel.add(btnApagar);

		btnSair = new JButton("Sair");
		btnSair.setBounds(285, 105, 80, 20);
		panel.add(btnSair);

		JLabel lblPesquisarNM = new JLabel("C\u00F3digo do Cargo");
		lblPesquisarNM.setBounds(10, 10, 128, 20);
		contentPane.add(lblPesquisarNM);

		txtPesquisaNome = new JTextField();
		txtPesquisaNome.setBounds(122, 10, 145, 20);
		contentPane.add(txtPesquisaNome);
		txtPesquisaNome.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(294, 10, 89, 20);
		contentPane.add(btnBuscar);

		btnApagar.addActionListener(this);
		btnBuscar.addActionListener(this);
		btnDeletar.addActionListener(this);
		btnSair.addActionListener(this);
		btnSalvar.addActionListener(this);
		btnDeletar.setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		System.out.println(acao);

		switch (acao) {
		case "Buscar":
			buscar();
			break;
		case "Salvar":
			salvar();
			break;
		case "Deletar":
			deletar();
			break;
		case "Apagar":
			apagar();
			break;
		case "Sair":
			dispose();
			break;

		default:
			break;
		}

	}

	private void deletar() {
		setVisible(false);
		int a = JOptionPane.showConfirmDialog(null,
				"Tem certeza que deseja deletar?");
		System.out.println(a);
		Cargo c = (Cargo) banco.buscarPorId(Cargo.class,
				Integer.parseInt(txtCodigo.getText()));
		if (a == 0) {
			JOptionPane.showMessageDialog(null,
					"classeficação " + c.getDescricao()
							+ " foi deletada com sucesso!");
			banco.deletarObjeto(c);
			apagar();
			btnDeletar.setEnabled(false);
		}
		setVisible(true);
	}

	private void apagar() {
		txtCodigo.setText("");
		txtDescricao.setText("");
		txtPesquisaNome.setText("");
		setVisible(false);
		JOptionPane.showMessageDialog(null, "Pode salvar um cargo novo agora!");
		setVisible(true);
		btnDeletar.setEnabled(false);
	}

	private void buscar() {
		try {
			Cargo c = (Cargo) banco.buscarPorId(Cargo.class,
					Integer.parseInt(txtPesquisaNome.getText()));
			System.out.println(c);
			if (c != null) {
				txtCodigo.setText(String.valueOf(c.getId()));
				txtDescricao.setText(c.getDescricao());
				btnDeletar.setEnabled(true);
			}
			if (c == null) {
				setVisible(false);
				JOptionPane.showMessageDialog(null, "Código Inexistente!");
				setVisible(true);
			}
		} catch (Exception e) {
			setVisible(false);
			JOptionPane.showMessageDialog(null,
					"Preencha codigo valido para buscar ");
			setVisible(true);
		}
	}

	private void salvar() {
		try {
			Cargo c = new Cargo();
			c.setDescricao(txtDescricao.getText());
			if (txtCodigo.getText().equalsIgnoreCase("")
					&& !txtDescricao.getText().equalsIgnoreCase("")) {
				banco.salvarOuAtualizarObjeto(c);
				this.setVisible(false);
				JOptionPane.showMessageDialog(null,
						"Você acabou de criar um cargo \n com a descrição : "
								+ txtDescricao.getText());
				dispose();
			}
			if (!txtCodigo.getText().equalsIgnoreCase("")
					&& !txtDescricao.getText().equalsIgnoreCase("")) {
				c.setId(Integer.parseInt(txtCodigo.getText()));
				banco.salvarOuAtualizarObjeto(c);
				this.setVisible(false);
				JOptionPane
						.showMessageDialog(
								null,
								"Você acabou de atualizar um cargo \n com a descrição : "
										+ txtDescricao.getText()
										+ "\n Agora todos os funcionario que tinham a antigo cargo terão essa novo");
				dispose();
			}
			if (txtDescricao.getText().equalsIgnoreCase("")) {

				this.setVisible(false);
				JOptionPane
						.showMessageDialog(null,
								"Não deixe campos vazios \n refaça novamente preenchendo todos os compos!");
				this.setVisible(true);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO - " + e);
		}
	}

}
