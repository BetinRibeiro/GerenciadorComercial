package br.com.Janelas.Consulta;

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

import br.com.Bins.Produto.Produto;
import br.com.Persistence.Banco;
import br.com.TableModel.TMProduto;

public class JFrmConsultaProduto extends JDialog implements ActionListener {

	private JPanel contentPane;
	private JTextField txtNomeBusca;
	private JTable tableProdutos;
	private JButton btnBuscar;
	private JButton btnSair;
	private JButton btnAlterar;
	private JButton btnConsultar;
	private Banco banco = new Banco();
	private TMProduto modelProd = new TMProduto();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JFrmConsultaProduto dialog = new JFrmConsultaProduto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JFrmConsultaProduto() {
		setTitle("Cadastro de Cargo dos Funcinarios");
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

		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(300, 375, 89, 20);
		contentPane.add(btnConsultar);
		btnConsultar.addActionListener(this);
		setResizable(false);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
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

		default:
			break;
		}

	}

	private void consultar() {
		// TODO Auto-generated method stub

	}

	private void altearar() {
		// TODO Auto-generated method stub

	}

	private void buscar() {


			modelProd.removeTudo();
			List<?> lista = banco.BuscaNome(Produto.class,
					txtNomeBusca.getText(), "descricao");
			for (int i = 0; i < lista.size(); i++) {

				Produto produto = (Produto) lista.get(i);
				modelProd.addRow(produto);

			}
//		} catch (Exception e) {
//			setVisible(false);
//			JOptionPane.showMessageDialog(null, "ERRO ao buscar um produto.");
//			setVisible(true);
//		}

	}
}
