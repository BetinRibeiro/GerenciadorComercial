package br.com.Janela.Cadastro;

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
import br.com.Bin.Funcionario.*;
import br.com.Bin.Produto.CFOP;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JTextArea;

public class JFrmCadastroCFOP extends JDialog implements ActionListener {

	private JPanel contentPane;
	private JTextField txtPesquisaNome;
	private JButton btnBuscar;
	private JButton btnSair;
	private JButton btnApagar;
	private JButton btnDeletar;
	private JButton btnSalvar;
	private JTextField txtCodigoInt;
	private Banco banco = new Banco();
	private JTextArea txtDescricao;
	private JTextField txtCodExt;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrmCadastroCFOP frame = new JFrmCadastroCFOP(0);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @param idCFOP
	 */
	public JFrmCadastroCFOP(Integer idCFOP) {
		setTitle("Cadastro de CFOP dos Produtos");
		setType(Type.UTILITY);
		// setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 277);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);

		JPanel panel = new JPanel();
		panel.setBorder((Border) new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 40, 374, 202);
		contentPane.add(panel);
		panel.setLayout(null);
		contentPane.setLayout(null);

		JLabel lblCdigo = new JLabel("C\u00F3digo interno");
		lblCdigo.setBounds(10, 10, 120, 20);
		panel.add(lblCdigo);

		txtCodigoInt = new JTextField();
		txtCodigoInt.setEnabled(false);
		txtCodigoInt.setBounds(10, 30, 120, 20);
		panel.add(txtCodigoInt);
		txtCodigoInt.setColumns(10);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(10, 55, 93, 20);
		panel.add(lblDescrio);

		

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 171, 80, 20);
		panel.add(btnSalvar);

		btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(100, 171, 80, 20);
		panel.add(btnDeletar);

		btnApagar = new JButton("Apagar");
		btnApagar.setBounds(195, 171, 80, 20);
		panel.add(btnApagar);

		btnSair = new JButton("Sair");
		btnSair.setBounds(285, 171, 80, 20);
		panel.add(btnSair);

		JLabel lblPesquisarNM = new JLabel("C\u00F3digo do CFOP");
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

		JLabel lblCdigoExterno = new JLabel("C\u00F3digo Externo");
		lblCdigoExterno.setBounds(185, 13, 107, 14);
		panel.add(lblCdigoExterno);

		txtCodExt = new JTextField();
		txtCodExt.setColumns(10);
		txtCodExt.setBounds(184, 30, 120, 20);
		panel.add(txtCodExt);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 78, 354, 82);
		panel.add(scrollPane);
		
		txtDescricao = new JTextArea();
		scrollPane.setViewportView(txtDescricao);


		if (idCFOP != 0) {
			txtPesquisaNome.setText(String.valueOf(idCFOP));
			buscar();
		}
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
		int a = JOptionPane.showConfirmDialog(contentPane,
				"Tem certeza que deseja deletar?");
		System.out.println(a);
		CFOP c = (CFOP) banco.buscarPorId(CFOP.class,
				Integer.parseInt(txtCodigoInt.getText()));
		if (a == 0) {
			JOptionPane.showMessageDialog(contentPane,
					"classeficação " + c.getDescricao()
							+ " foi deletada com sucesso!");
			banco.deletarObjeto(c);
			apagar();
			btnDeletar.setEnabled(false);
		}
		setVisible(true);
	}

	private void apagar() {
		txtCodigoInt.setText("");
		txtCodExt.setText("");
		txtDescricao.setText("");
		txtPesquisaNome.setText("");
		setVisible(false);
		JOptionPane.showMessageDialog(contentPane,
				"Pode salvar um CFOP novo agora!");
		setVisible(true);
		btnDeletar.setEnabled(false);
	}

	private void buscar() {
		try {
			CFOP c = (CFOP) banco.buscarPorId(CFOP.class,
					Integer.parseInt(txtPesquisaNome.getText()));
			System.out.println(c);
			if (c != null) {
				txtCodigoInt.setText(String.valueOf(c.getId()));
				txtDescricao.setText(c.getDescricao());
				txtCodExt.setText(String.valueOf(c.getCod()));
				btnDeletar.setEnabled(true);
			}
			if (c == null) {
				setVisible(false);
				JOptionPane.showMessageDialog(contentPane,
						"Código Inexistente!");
				setVisible(true);
			}
		} catch (Exception e) {
			setVisible(false);
			JOptionPane.showMessageDialog(contentPane,
					"Preencha codigo valido para buscar ");
			setVisible(true);
		}
	}

	private void salvar() {
		try {
			CFOP c = new CFOP();
			c.setDescricao(txtDescricao.getText());
			c.setCod(Integer.parseInt(txtCodExt.getText()));
			if (txtCodigoInt.getText().equalsIgnoreCase("")
					&& !txtDescricao.getText().equalsIgnoreCase("")) {
				banco.salvarOuAtualizarObjeto(c);
				JOptionPane.showMessageDialog(contentPane,
						"Você acabou de criar um CFOP \n com a descrição : "
								+ txtDescricao.getText());
				dispose();
			}
			if (!txtCodigoInt.getText().equalsIgnoreCase("")
					&& !txtDescricao.getText().equalsIgnoreCase("")) {
				c.setId(Integer.parseInt(txtCodigoInt.getText()));
				banco.salvarOuAtualizarObjeto(c);
				JOptionPane
						.showMessageDialog(
								contentPane,
								"Você acabou de atualizar um CFOP \n com a descrição : "
										+ txtDescricao.getText()
										+ "\n Agora todos os Produtos que tinham a antigo CFOP terão essa novo");
				dispose();
			}
			if (txtDescricao.getText().equalsIgnoreCase("")) {

				JOptionPane
						.showMessageDialog(contentPane,
								"Não deixe campos vazios \n refaça novamente preenchendo todos os compos!");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, "ERRO - " + e);
		}
	}
}
