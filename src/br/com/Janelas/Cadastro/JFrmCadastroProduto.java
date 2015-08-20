package br.com.Janelas.Cadastro;

import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import br.com.Bins.Produto.ClassificacaoProduto;
import br.com.Bins.Produto.LocalizacaoProduto;
import br.com.Bins.Produto.Produto;
import br.com.Persistence.Banco;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class JFrmCadastroProduto extends JDialog implements ActionListener {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtDescr;
	private JTextField txtEstMin;
	private JTextField txtPrec;
	private JTextField txtCodPesqu;
	private JButton btnSalvar;
	private JButton btnDeletar;
	private JButton btnApagar;
	private JButton btnSair;
	private JButton btnBuscar;
	// private Ba
	private JComboBox boxLocal;
	private JComboBox boxClass;
	private Banco banco = new Banco();

	// gambiarra que salva a lista de ids, por que nao consegui buscar por nome
	// no banco de dados
	// verificar onde estou usando que eu entenderei
	private ArrayList<Integer> listaLocal = new ArrayList<Integer>();
	private ArrayList<Integer> listaClass = new ArrayList<Integer>();

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
		setTitle("Cadastro de Produto");
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

		txtCodigo = new JTextField("");
		txtCodigo.setEnabled(false);
		txtCodigo.setBounds(10, 30, 120, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(10, 55, 93, 20);
		panel.add(lblDescrio);

		txtDescr = new JTextField();
		txtDescr.setBounds(10, 75, 355, 20);
		panel.add(txtDescr);
		txtDescr.setColumns(10);

		JLabel lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setBounds(10, 150, 81, 20);
		panel.add(lblPreo);

		txtEstMin = new JTextField();
		txtEstMin.setBounds(10, 125, 120, 20);
		panel.add(txtEstMin);
		txtEstMin.setColumns(10);

		JLabel lblEstMinimo = new JLabel("Est. Minimo");
		lblEstMinimo.setBounds(10, 105, 93, 20);
		panel.add(lblEstMinimo);

		txtPrec = new JTextField();
		txtPrec.setBounds(10, 170, 120, 20);
		panel.add(txtPrec);
		txtPrec.setColumns(10);

		JLabel lblClassificao = new JLabel("Classifica\u00E7\u00E3o");
		lblClassificao.setBounds(160, 150, 100, 20);
		panel.add(lblClassificao);

		boxLocal = new JComboBox(listaLocal());
		boxLocal.setBounds(160, 125, 204, 20);
		panel.add(boxLocal);

		JLabel lblLocalizao = new JLabel("Localiza\u00E7\u00E3o");
		lblLocalizao.setBounds(160, 105, 81, 20);
		panel.add(lblLocalizao);

		boxClass = new JComboBox(listaClass());
		boxClass.setBounds(160, 170, 205, 20);
		panel.add(boxClass);

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

		JLabel lblPesquisarCdigo = new JLabel("C\u00F3digo do Produto");
		lblPesquisarCdigo.setBounds(10, 11, 128, 20);
		contentPane.add(lblPesquisarCdigo);

		txtCodPesqu = new JTextField("");
		txtCodPesqu.setBounds(122, 10, 145, 20);
		contentPane.add(txtCodPesqu);
		txtCodPesqu.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(294, 10, 89, 20);
		contentPane.add(btnBuscar);

		btnApagar.addActionListener(this);
		btnBuscar.addActionListener(this);
		btnDeletar.addActionListener(this);
		btnSair.addActionListener(this);
		btnSalvar.addActionListener(this);

		txtCodigo.setText("");
	}

	private String[] listaClass() {
		@SuppressWarnings("unchecked")
		List<Object> listaObj = (List<Object>) banco.listarObjetos(
				ClassificacaoProduto.class, "descricao");
		String[] lista = new String[listaObj.size()];
		for (int i = 0; i < listaObj.size(); i++) {
			ClassificacaoProduto listProdut = (ClassificacaoProduto) listaObj
					.get(i);
			lista[i] = listProdut.getDescricao();
			listaClass.add(listProdut.getId());
		}
		return lista;
	}

	private String[] listaLocal() {

		@SuppressWarnings("unchecked")
		List<Object> listaObj = (List<Object>) banco.listarObjetos(
				LocalizacaoProduto.class, "descricao");
		String[] lista = new String[listaObj.size()];
		for (int i = 0; i < listaObj.size(); i++) {
			LocalizacaoProduto listProdut = (LocalizacaoProduto) listaObj
					.get(i);
			lista[i] = listProdut.getDescricao();
			listaLocal.add(listProdut.getId());
		}
		return lista;
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
		Produto c = (Produto) banco.buscarPorId(Produto.class,
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
		txtCodPesqu.setText("");
		txtDescr.setText("");
		txtEstMin.setText("");
		txtPrec.setText("");
		setVisible(false);
		JOptionPane.showMessageDialog(null,
				"Pode salvar um produto novo agora!");
		setVisible(true);

		btnDeletar.setEnabled(false);
	}

	private void buscar() {
		try {

			Produto c = (Produto) banco.buscarPorId(Produto.class,
					Integer.parseInt(txtCodPesqu.getText()));
			for (int i = 0; i < listaClass.size(); i++) {
				if (listaClass.get(i).equals(c.getClassificacao().getId())) {
					boxClass.getModel().setSelectedItem(
							c.getClassificacao().getDescricao());
				}
			}
			for (int i = 0; i < listaLocal.size(); i++) {
				if (listaLocal.get(i).equals(c.getLocalizacao().getId())) {
					boxLocal.getModel().setSelectedItem(
							c.getLocalizacao().getDescricao());
				}
			}
			System.out.println(c);
			if (c != null) {
				txtCodigo.setText(String.valueOf(c.getId()));
				txtDescr.setText(c.getDescricao());
				txtEstMin.setText(String.valueOf(c.getEstoqueMin()));
				txtPrec.setText(String.valueOf(c.getPreco()));
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
			Produto p = new Produto();
			LocalizacaoProduto l = (LocalizacaoProduto) banco.buscarPorId(
					LocalizacaoProduto.class,
					listaLocal.get(boxLocal.getSelectedIndex()));
			ClassificacaoProduto c = (ClassificacaoProduto) banco.buscarPorId(
					ClassificacaoProduto.class,
					listaClass.get(boxClass.getSelectedIndex()));
			p.setLocalizacao(l);
			p.setClassificacao(c);
			p.setCusto(0);
			p.setQuantidade(0);
			p.setDescricao(txtDescr.getText());
			p.setEstoqueMin(Float.parseFloat(txtEstMin.getText().replace(",",
					".")));
			p.setPreco(Float.parseFloat(txtPrec.getText().replace(",", ".")));
			p.setEstoqueMin(0);
			p.setPreco(0);
			if (!txtCodigo.getText().equalsIgnoreCase("")) {
				p.setId(Integer.valueOf(txtCodigo.getText()));
			}
			if (p.getDescricao() == "") {
				p.setDescricao(txtDescr.getText());
				setVisible(false);
				JOptionPane.showMessageDialog(null, "Descrição invalida");
				setVisible(true);
			}

			if (p.getDescricao() == "") {
				setVisible(false);
				JOptionPane.showMessageDialog(null,
						"Descreva alguma coisa na descrição.");
				setVisible(true);
			}
			if (p.getDescricao() != "") {
				setVisible(false);
				banco.salvarOuAtualizarObjeto(p);
				JOptionPane.showMessageDialog(null,
						"Produto salvo com sucesso!");
				setVisible(true);
				apagar();
			}
		} catch (Exception e) {
			setVisible(false);
			JOptionPane
					.showMessageDialog(null, "Erro ao cadastrar o produto, ");
			setVisible(true);
		}
	}
}
