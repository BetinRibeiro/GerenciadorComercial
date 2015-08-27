package br.com.Janela.Consulta;

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
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import br.com.Persistence.Banco;
import br.com.TableModel.*;
import br.com.Bin.Produto.*;
import br.com.Janela.Cadastro.*;

public class JFrmConsultaClasseProduto extends JDialog implements
		ActionListener {

	private JPanel contentPane;
	private JTextField txtNomeBusca;
	private JTable tableClassificacaoProdutos;
	private JButton btnBuscar;
	private JButton btnSair;
	private JButton btnAlterar;
	private Banco banco = new Banco();
	private TMClassificacaoProduto modelProd = new TMClassificacaoProduto();
	private int a;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JFrmConsultaClasseProduto dialog = new JFrmConsultaClasseProduto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JFrmConsultaClasseProduto() {
		setTitle("Consulta de Classifica\u00E7\u00E3o dos Produtos");
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

		tableClassificacaoProdutos = new JTable(modelProd);

		// tabela com colunas fixasv
		tableClassificacaoProdutos.getTableHeader().setReorderingAllowed(false);
		// tamanho especifico da coluna
		tableClassificacaoProdutos.getColumn("Descrição")
				.setPreferredWidth(350);

		// seleciona apenas uma linha
		tableClassificacaoProdutos
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tableClassificacaoProdutos);

		txtNomeBusca = new JTextField();
		txtNomeBusca.setBounds(129, 10, 260, 20);
		contentPane.add(txtNomeBusca);
		txtNomeBusca.setColumns(10);

		JLabel lblNome = new JLabel("Nome Classe");
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
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		System.out.println(acao);
		switch (acao) {
		case "Buscar":
			System.out.println("entrou aqui");
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

		default:
			break;
		}

	}

	private void consultar() {
		// TODO Não existe isso ainda, não vi a necessidade

	}

	private void altearar() {
		try {
			JFrmCadastroClassificacaoProduto c = new JFrmCadastroClassificacaoProduto(
					(Integer) tableClassificacaoProdutos.getValueAt(
							tableClassificacaoProdutos.getSelectedRow(), 0));
			txtNomeBusca.setText("");
			modelProd.removeTudo();
			c.setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane,
					"ERRO ao alterar um produto.");
		}
	}

	private void buscar() {
		try {
			modelProd.removeTudo();
			a = 0;
			List<?> lista = banco.BuscaNome(ClassificacaoProduto.class,
					txtNomeBusca.getText(), "descricao");
			for (int i = 0; i < lista.size(); i++) {
				ClassificacaoProduto classif = (ClassificacaoProduto) lista
						.get(i);
				modelProd.addRow(classif);
				a = 1;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane,
					"ERRO ao buscar um classificação.");
		}
		if (a == 0) {
			btnAlterar.setEnabled(false);
		} else {
			btnAlterar.setEnabled(true);
		}
	}
}
