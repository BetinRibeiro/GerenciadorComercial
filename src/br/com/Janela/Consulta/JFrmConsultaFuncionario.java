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
import br.com.Bin.Funcionario.*;
import br.com.Janela.Cadastro.*;

public class JFrmConsultaFuncionario extends JDialog implements
		ActionListener {

	private JPanel contentPane;
	private JTextField txtNomeBusca;
	private JButton btnBuscar;
	private JButton btnSair;
	private JButton btnAlterar;
	private Banco banco = new Banco();
	private TMFuncionario modelProd = new TMFuncionario();
	private int a;
	private JTable tableFuncionarios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JFrmConsultaFuncionario dialog = new JFrmConsultaFuncionario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JFrmConsultaFuncionario() {
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

		tableFuncionarios = new JTable(modelProd);

		// tabela com colunas fixasv
		tableFuncionarios.getTableHeader().setReorderingAllowed(false);
		// tamanho especifico da coluna
		tableFuncionarios.getColumn("Nome")
				.setPreferredWidth(150);

		// seleciona apenas uma linha
		tableFuncionarios
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tableFuncionarios);

		txtNomeBusca = new JTextField();
		txtNomeBusca.setBounds(129, 10, 260, 20);
		contentPane.add(txtNomeBusca);
		txtNomeBusca.setColumns(10);

		JLabel lblNome = new JLabel("Nome Funcionario");
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
			JFrmCadastroFuncionario c = new JFrmCadastroFuncionario(
					(Integer) tableFuncionarios.getValueAt(
							tableFuncionarios.getSelectedRow(), 0));
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
			List<?> lista = banco.BuscaNome(Funcionario.class,
					txtNomeBusca.getText(), "nome");
			for (int i = 0; i < lista.size(); i++) {
				Funcionario classif = (Funcionario) lista
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
