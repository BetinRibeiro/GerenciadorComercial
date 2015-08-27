package br.com.Janela.Consulta;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.transaction.Transactional.TxType;

import br.com.Bin.Produto.Produto;
import br.com.Janela.Cadastro.JFrmCadastroProduto;
import br.com.Persistence.Banco;
import br.com.TableModel.*;;

public class JFrmConsultaProduto extends JDialog implements ActionListener {

	private JPanel contentPane;
	private JTextField txtNomeBusca;
	private JTable tableProdutos;
	private JButton btnBuscar;
	private JButton btnSair;
	private JButton btnAlterar;
	private Banco banco = new Banco();
	private TMProdutoMateriala modelProd = new TMProdutoMateriala();
	private int a;
	private Produto produto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JFrmConsultaProduto dialog = new JFrmConsultaProduto("");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param Escolher 
	 */
	public JFrmConsultaProduto(String escolher) {
		setTitle("Consulta dos Produtos");
		setType(Type.UTILITY);
		// setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 64, 574, 300);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 574, 300);
		panel.add(scrollPane);

		tableProdutos = new JTable(modelProd);

		// tabela com colunas fixasv
		tableProdutos.getTableHeader().setReorderingAllowed(false);
		// tamanho especifico da coluna
		tableProdutos.getColumn("Descrição").setPreferredWidth(350);

		// seleciona apenas uma linha
		tableProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tableProdutos);

		txtNomeBusca = new JTextField();
		txtNomeBusca.setBounds(129, 10, 260, 20);
		contentPane.add(txtNomeBusca);
		txtNomeBusca.setColumns(10);

		JLabel lblNome = new JLabel("Nome Produto");
		lblNome.setBounds(10, 10, 97, 20);
		contentPane.add(lblNome);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(400, 10, 89, 20);
		contentPane.add(btnBuscar);
		btnBuscar.addActionListener(this);

		btnSair = new JButton("Sair");
		btnSair.setBounds(495, 375, 89, 20);
		contentPane.add(btnSair);
		btnSair.addActionListener(this);

		btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(399, 375, 89, 20);
		contentPane.add(btnAlterar);
		btnAlterar.addActionListener(this);
		setResizable(false);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		btnAlterar.setEnabled(false);
		if (escolher.equalsIgnoreCase("Escolher")) {
			btnSair.setText("Escolher");
			btnAlterar.setVisible(false);
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

		case "Sair":
			dispose();
			break;
		case "Alterar":
			altearar();
			break;
		case "Consultar":
			consultar();
			break;
		case "Escolher":
			retorno();
			break;

		default:
			break;
		}

	}

	private void retorno() {
		setProduto((Produto) banco.buscarPorId(Produto.class, (Integer) tableProdutos.getValueAt(
					tableProdutos.getSelectedRow(), 0)));
		getProduto();
		dispose();
	}

	private void consultar() {
		// TODO Não existe isso ainda, não vi a necessidade

	}

	private void altearar() {
		try {
			JFrmCadastroProduto c = new JFrmCadastroProduto( (Integer) tableProdutos.getValueAt(
					tableProdutos.getSelectedRow(), 0));
			txtNomeBusca.setText("");
			modelProd.removeTudo();
			c.setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, "ERRO ao alterar um produto.");
		}
	}

	private void buscar() {
		try {
			modelProd.removeTudo();
			a = 0;
			List<?> lista = banco.BuscaNome(Produto.class,
					txtNomeBusca.getText(), "descricao");
			for (int i = 0; i < lista.size(); i++) {
				Produto produto = (Produto) lista.get(i);
				modelProd.addRow(produto);
				a = 1;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, "ERRO ao buscar um produto.");
		}
		if (a==0) {
			btnAlterar.setEnabled(false);
		}else {
			btnAlterar.setEnabled(true);
		}
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
