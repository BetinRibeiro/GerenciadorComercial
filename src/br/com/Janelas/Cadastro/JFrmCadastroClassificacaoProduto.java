package br.com.Janelas.Cadastro;

import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import br.com.Bin.Produto.ClassificacaoProduto;
import br.com.Persistence.Banco;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class JFrmCadastroClassificacaoProduto extends JDialog implements
		ActionListener {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtDescricao;
	private JTextField txtCodFiscal;
	private JTextField txtPesquisaNome;
	private JButton btnSalvar;
	private JButton btnDeletar;
	private JButton btnApagar;
	private JButton btnSair;
	private JButton btnBuscar;
	private Banco banco = new Banco();

	
	/**
	 * Create the frame.
	 */
	public JFrmCadastroClassificacaoProduto(int idClassAlterar) {
		setTitle("Cadastro da Classifica\u00E7\u00E3o dos Produtos");
		setType(Type.UTILITY);
		// setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 40, 374, 190);
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

		txtCodFiscal = new JTextField();
		txtCodFiscal.setBounds(10, 120, 355, 20);
		panel.add(txtCodFiscal);
		txtCodFiscal.setColumns(10);

		JLabel lblc = new JLabel("Cod. Fiscal");
		lblc.setBounds(10, 100, 93, 20);
		panel.add(lblc);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 155, 80, 20);
		panel.add(btnSalvar);

		btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(100, 155, 80, 20);
		panel.add(btnDeletar);

		btnApagar = new JButton("Apagar");
		btnApagar.setBounds(195, 155, 80, 20);
		panel.add(btnApagar);

		btnSair = new JButton("Sair");
		btnSair.setBounds(285, 155, 80, 20);
		panel.add(btnSair);

		JLabel lblPesquisarNM = new JLabel("C\u00F3digo da Classe");
		lblPesquisarNM.setBounds(10, 10, 128, 20);
		contentPane.add(lblPesquisarNM);

		txtPesquisaNome = new JTextField("Código para pesquisar");
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
		if (idClassAlterar!=0) {
			txtPesquisaNome.setText(String.valueOf(idClassAlterar));
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
		int a = JOptionPane.showConfirmDialog(contentPane, "Tem certeza que deseja deletar?");
		System.out.println(a);
		ClassificacaoProduto c = (ClassificacaoProduto) banco.buscarPorId(ClassificacaoProduto.class, Integer.parseInt(txtCodigo.getText()));
		if (a==0) {
			JOptionPane.showMessageDialog(contentPane, "classeficação "+c.getDescricao()+" foi deletada com sucesso!");
			banco.deletarObjeto(c);
			apagar();
			btnDeletar.setEnabled(false);
		}
		setVisible(true);
	}

	private void apagar() {
		txtCodFiscal.setText("");
		txtCodigo.setText("");
		txtDescricao.setText("");
		txtPesquisaNome.setText("");
		setVisible(false);
		JOptionPane.showMessageDialog(contentPane,
				"Pode salvar uma classificação nova agora!");
		setVisible(true);
		btnDeletar.setEnabled(false);
	}

	private void buscar() {
		try {
		ClassificacaoProduto c = (ClassificacaoProduto) banco.buscarPorId(ClassificacaoProduto.class, Integer.parseInt(txtPesquisaNome.getText()));
		System.out.println(c);
		if (c!=null) {
			txtCodFiscal.setText(c.getCodFiscal());
			txtCodigo.setText(String.valueOf(c.getId()));
			txtDescricao.setText(c.getDescricao());
			btnDeletar.setEnabled(true);
		}if (c==null) {
			setVisible(false);
			JOptionPane.showMessageDialog(contentPane, "Código Inexistente!");
			setVisible(true);
		}
		} catch (Exception e) {
			setVisible(false);
			JOptionPane.showMessageDialog(contentPane, "Preencha codigo valido para buscar " );
			setVisible(true);
		}
	}

	private void salvar() {
		try {
			ClassificacaoProduto c = new ClassificacaoProduto();
			c.setCodFiscal(txtCodFiscal.getText());
			c.setDescricao(txtDescricao.getText());
			if (txtCodigo.getText().equalsIgnoreCase("")
					&& !txtDescricao.getText().equalsIgnoreCase("")) {
				banco.salvarOuAtualizarObjeto(c);
				this.setVisible(false);
				JOptionPane.showMessageDialog(contentPane,
						"Você acabou de criar uma classe \n com a descrição : "
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
								contentPane,
								"Você acabou de atualizar uma classe \n com a descrição : "
										+ txtDescricao.getText()
										+ "\n Agora todos os produtos que tinham a antiga descrição terão essa nova");
				dispose();
			}
			if (txtDescricao.getText().equalsIgnoreCase("")) {

				this.setVisible(false);
				JOptionPane
						.showMessageDialog(contentPane,
								"Não deixe campos vazios \n refaça novamente preenchendo todos os compos!");
				this.setVisible(true);
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, "ERRO - "+e);
		}
	}
}
