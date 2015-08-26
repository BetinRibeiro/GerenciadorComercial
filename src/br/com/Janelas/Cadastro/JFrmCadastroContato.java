package br.com.Janelas.Cadastro;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;


import br.com.Bin.Endereco;
import br.com.Bin.Telefone;
import br.com.Bin.Contato;
import br.com.Bin.Fornecedor.Fornecedor;
import br.com.Persistence.Banco;

public class JFrmCadastroContato extends JDialog implements ActionListener {

	private JPanel contentPane;
	private JTextField txtCodPesq;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtEnd;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtFone1;
	private JTextField txtCel;
	private JButton btnBuscar;
	private JButton btnSalvar;
	private JButton btnDeletar;
	private JButton btnApagar;
	private JButton btnSair;
	private Banco banco = new Banco();
	private ArrayList<Integer> listaFornecedor = new ArrayList<Integer>();
	private JComboBox boxSexo;
	private JComboBox boxFornecedor;
	private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	private JTextField txtCep;
	private JComboBox boxUf;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrmCadastroContato frame = new JFrmCadastroContato();
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
	public JFrmCadastroContato() {
		setTitle("Cadastro de Contatos");
		// setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCdigoCargo = new JLabel("C\u00F3digo Contato\r\n");
		lblCdigoCargo.setBounds(10, 10, 128, 20);
		contentPane.add(lblCdigoCargo);

		txtCodPesq = new JTextField();
		txtCodPesq.setBounds(122, 10, 150, 20);
		contentPane.add(txtCodPesq);
		txtCodPesq.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(295, 10, 89, 20);
		contentPane.add(btnBuscar);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 40, 614, 391);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("C\u00F3digo");
		label.setBounds(10, 10, 60, 20);
		panel.add(label);

		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setColumns(10);
		txtId.setBounds(10, 30, 120, 20);
		panel.add(txtId);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(436, 10, 168, 169);
		panel.add(panel_1);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 55, 60, 20);
		panel.add(lblNome);

		JLabel lblSobrenome = new JLabel("Sobrenome");
		lblSobrenome.setBounds(223, 55, 74, 20);
		panel.add(lblSobrenome);

		JLabel lblEstadoCivil = new JLabel("Fornecedor");
		lblEstadoCivil.setBounds(223, 100, 83, 20);
		panel.add(lblEstadoCivil);

		txtNome = new JTextField();
		txtNome.setBounds(10, 75, 203, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);

		txtSobrenome = new JTextField();
		txtSobrenome.setColumns(10);
		txtSobrenome.setBounds(223, 75, 203, 20);
		panel.add(txtSobrenome);

		
		boxFornecedor = new JComboBox(listaFornecedor());
		boxFornecedor.setBounds(223, 120, 203, 20);
		panel.add(boxFornecedor);


		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(223, 10, 71, 20);
		panel.add(lblSexo);

		String[] c = { "Masculino", "Feminino" };
		boxSexo = new JComboBox(c);
		boxSexo.setBounds(223, 30, 125, 20);
		panel.add(boxSexo);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 190, 594, 155);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblRua = new JLabel("Endere\u00E7o");
		lblRua.setBounds(10, 10, 111, 14);
		panel_2.add(lblRua);

		txtEnd = new JTextField();
		txtEnd.setBounds(10, 30, 414, 20);
		panel_2.add(txtEnd);
		txtEnd.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(434, 10, 82, 14);
		panel_2.add(lblBairro);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(10, 55, 92, 14);
		panel_2.add(lblCidade);

		txtBairro = new JTextField();
		txtBairro.setBounds(434, 30, 150, 20);
		panel_2.add(txtBairro);
		txtBairro.setColumns(10);

		txtCidade = new JTextField();
		txtCidade.setBounds(10, 75, 250, 20);
		panel_2.add(txtCidade);
		txtCidade.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone ");
		lblTelefone.setBounds(10, 106, 82, 14);
		panel_2.add(lblTelefone);

		txtFone1 = new JTextField();
		txtFone1.setColumns(10);
		txtFone1.setBounds(10, 126, 150, 20);
		panel_2.add(txtFone1);

		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(170, 106, 98, 14);
		panel_2.add(lblCelular);

		txtCel = new JTextField();
		txtCel.setColumns(10);
		txtCel.setBounds(170, 126, 150, 20);
		panel_2.add(txtCel);
		
		txtCep = new JTextField();
		txtCep.setText("");
		txtCep.setColumns(10);
		txtCep.setBounds(270, 75, 150, 20);
		panel_2.add(txtCep);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(270, 55, 82, 14);
		panel_2.add(lblCep);
		
		JLabel lblUf = new JLabel("UF");
		lblUf.setBounds(434, 55, 46, 14);
		panel_2.add(lblUf);
		String[] uf = { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES",
				"GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR",
				"RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" };
		
		boxUf = new JComboBox(uf);
		boxUf.setBounds(434, 75, 71, 20);
		panel_2.add(boxUf);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(223, 356, 89, 20);
		panel.add(btnSalvar);

		btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(319, 356, 89, 20);
		panel.add(btnDeletar);

		btnApagar = new JButton("Apagar");
		btnApagar.setBounds(418, 356, 89, 20);
		panel.add(btnApagar);

		btnSair = new JButton("Sair");
		btnSair.setBounds(517, 356, 89, 20);
		panel.add(btnSair);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 100, 74, 20);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setText("");
		txtEmail.setColumns(10);
		txtEmail.setBounds(10, 120, 203, 20);
		panel.add(txtEmail);
		setResizable(false);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);

		btnApagar.addActionListener(this);
		btnBuscar.addActionListener(this);
		btnDeletar.addActionListener(this);
		btnSair.addActionListener(this);
		btnSalvar.addActionListener(this);

		apagar();

	}


	private String[] listaFornecedor() {
		@SuppressWarnings("unchecked")
		List<Object> listaObj = (List<Object>) banco.listarObjetos(Fornecedor.class,
				"nomeFantasia");
		String[] lista = new String[listaObj.size()];
		for (int i = 0; i < listaObj.size(); i++) {
			Fornecedor listProdut = (Fornecedor) listaObj.get(i);
			lista[i] = listProdut.getNomeFantasia();
			listaFornecedor.add(listProdut.getId());
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
			setVisible(false);
			JOptionPane.showMessageDialog(contentPane,
					"Pode salvar um Contato novo agora!");

			setVisible(true);
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
		Contato c = (Contato) banco.buscarPorId(Contato.class,
				Integer.parseInt(txtId.getText()));
		if (a == 0) {
			JOptionPane.showMessageDialog(contentPane, "Contato " + c.getNome()
					+ " foi deletado com sucesso!");
			banco.deletarObjeto(c);
			apagar();
			btnDeletar.setEnabled(false);
		}
		setVisible(true);
	}

	private void apagar() {
		try {

			txtBairro.setText("");
			txtCel.setText("");
			txtCidade.setText("");
			txtCodPesq.setText("");
			txtEnd.setText("");
			txtFone1.setText("");
			txtId.setText("");
			txtNome.setText("");
			txtEmail.setText("");
			txtSobrenome.setText("");
			txtCep.setText("");
			boxFornecedor.setSelectedIndex(0);
			boxUf.setSelectedIndex(0);

			btnDeletar.setEnabled(false);
		} catch (Exception e) {
			System.out.println("Erro - " + e);
		}
	}

	private void buscar() {
		try {

			Contato c = (Contato) banco.buscarPorId(Contato.class,
					Integer.parseInt(txtCodPesq.getText()));

			if (c != null) {
				Endereco end = c.getEnd();
				txtBairro.setText(end.getBairro());
				txtEnd.setText(end.getEnd());
				txtCidade.setText(end.getCidade());
				txtCep.setText(end.getCep());
				boxUf.setSelectedItem(end.getUf());

				Telefone fone = c.getFone();
				txtFone1.setText(fone.getTelefone());
				txtCel.setText(fone.getCelular());

				txtEmail.setText(c.getEmail());
				txtId.setText(String.valueOf(c.getId()));
				txtNome.setText(c.getNome());
				txtSobrenome.setText(c.getSobrenome());


				boxFornecedor.setSelectedItem(c.getFornecedor().getNomeFantasia());
				boxSexo.setSelectedItem(c.getSexo());

				btnDeletar.setEnabled(true);
			}
			if (c == null) {
				setVisible(false);
				JOptionPane.showMessageDialog(contentPane, "Código Inexistente!");
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
		// try {

		confereIntegridadeDosDados();
		Fornecedor forn = (Fornecedor) banco.buscarPorId(Fornecedor.class, listaFornecedor.get(boxFornecedor.getSelectedIndex()));
		
		
		Telefone telefones = new Telefone();
		telefones.setCelular(txtCel.getText());
		telefones.setTelefone(txtFone1.getText());
		banco.salvarObjeto(telefones);
		System.out.println(telefones.getId());
		System.out.println(telefones.getCelular());
		System.out.println(telefones.getTelefone());

		Endereco end = new Endereco();
		end.setBairro(txtBairro.getText());
		end.setCidade(txtCidade.getText());
		end.setEnd(txtEnd.getText());
		end.setCep(txtCep.getText());
		end.setUf(String.valueOf(boxUf.getSelectedItem()));
		System.out.println("Bairro "+end.getBairro());
		System.out.println(end.getCidade());
		System.out.println(end.getEnd());
		banco.salvarObjeto(end);
		
		Contato f = new Contato();

		f.setEnd(end);
		f.setFone(telefones);
		f.setNome(txtNome.getText());
		f.setSexo(String.valueOf(boxSexo.getSelectedItem()));
		f.setSobrenome(txtSobrenome.getText());
		f.setEmail(txtEmail.getText());
		f.setFornecedor(forn);


		if (!txtId.getText().equalsIgnoreCase("")) {
			f.setId(Integer.valueOf(txtId.getText()));
			banco.salvarOuAtualizarObjeto(f);
			setVisible(false);
			JOptionPane.showMessageDialog(contentPane,
					"Produto salvo com sucesso!");
			JOptionPane.showMessageDialog(contentPane, "tem um id "+String.valueOf(f.getId()));
			setVisible(true);
			txtId.setText(String.valueOf(f.getId()));
			apagar();
		}
		else {
			
			banco.salvarOuAtualizarObjeto(f);
			setVisible(false);
			JOptionPane.showMessageDialog(contentPane,
					"Produto salvo com sucesso!");
			JOptionPane.showMessageDialog(contentPane, "não tem um id");
			setVisible(true);
			apagar();
		}
		
		
		

	}

	private void confereIntegridadeDosDados() {
		// TODO Auto-generated method stub

	}
}
