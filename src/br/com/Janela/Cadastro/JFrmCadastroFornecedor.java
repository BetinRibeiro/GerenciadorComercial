package br.com.Janela.Cadastro;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.ComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
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
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import com.toedter.calendar.JDateChooser;

import br.com.Bin.Fornecedor.*;
import br.com.Bin.Endereco;
import br.com.Bin.Telefone;
import br.com.Bin.Funcionario.*;
import br.com.Persistence.Banco;

public class JFrmCadastroFornecedor extends JDialog implements ActionListener {

	private JPanel contentPane;
	private JTextField txtCodPesq;
	private JTextField txtId;
	private JTextField txtRazaoSocial;
	private JTextField txtRazaoSocialFant;
	private JTextField txtCnpj;
	private JTextField txtInscricaoEstadual;
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
	private ArrayList<Integer> listaCargo = new ArrayList<Integer>();
	private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	private JTextField txtCep;
	private JComboBox boxUf;
	private JLabel lblEmail;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrmCadastroFornecedor frame = new JFrmCadastroFornecedor(0);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param idFOrneced 
	 */
	public JFrmCadastroFornecedor(Integer idFOrneced) {
		setTitle("Cadastro de Fornecedors");
		// setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCdigoCargo = new JLabel("C\u00F3digo Fornecedor\r\n");
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
		panel.setBounds(10, 40, 614, 394);
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

		JLabel lblRazaoSocial = new JLabel("RazaoSocial");
		lblRazaoSocial.setBounds(10, 55, 132, 20);
		panel.add(lblRazaoSocial);

		JLabel lblNomeFantasia = new JLabel("Nome Fantasia");
		lblNomeFantasia.setBounds(223, 55, 148, 20);
		panel.add(lblNomeFantasia);

		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setBounds(10, 100, 60, 20);
		panel.add(lblCnpj);

		JLabel lblCpf = new JLabel("Insc. Estadual");
		lblCpf.setBounds(10, 145, 120, 20);
		panel.add(lblCpf);

		txtRazaoSocial = new JTextField();
		txtRazaoSocial.setBounds(10, 75, 203, 20);
		panel.add(txtRazaoSocial);
		txtRazaoSocial.setColumns(10);

		txtRazaoSocialFant = new JTextField();
		txtRazaoSocialFant.setColumns(10);
		txtRazaoSocialFant.setBounds(223, 75, 203, 20);
		panel.add(txtRazaoSocialFant);

		txtCnpj = new JTextField();
		txtCnpj.setColumns(10);
		txtCnpj.setBounds(10, 120, 203, 20);
		panel.add(txtCnpj);

		txtInscricaoEstadual = new JTextField();
		txtInscricaoEstadual.setColumns(10);
		txtInscricaoEstadual.setBounds(10, 165, 203, 20);
		panel.add(txtInscricaoEstadual);

		String[] a = { "Solteiro(a)", "Casado(a)", "Divorciado(a)", "Viuvo(a)",
				"Separado(a)" };

		String[] b = { "Ensino fundamental incompleto",
				"Ensino fundamental completo", "Ensino médio incompleto",
				"Ensino médio completo", "Ensino superior incompleto",
				"Ensino superior completo", "Pós-graduação", "Mestrado",
				"Doutorado" };

		String[] c = { "Masculino", "Feminino" };

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 198, 594, 154);
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
		btnSalvar.setBounds(221, 363, 89, 20);
		panel.add(btnSalvar);

		btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(317, 363, 89, 20);
		panel.add(btnDeletar);

		btnApagar = new JButton("Apagar");
		btnApagar.setBounds(416, 363, 89, 20);
		panel.add(btnApagar);

		btnSair = new JButton("Sair");
		btnSair.setBounds(515, 363, 89, 20);
		panel.add(btnSair);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(223, 100, 74, 20);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setText("");
		txtEmail.setColumns(10);
		txtEmail.setBounds(223, 120, 203, 20);
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
		if (idFOrneced != 0) {
			txtCodPesq.setText(String.valueOf(idFOrneced));
			buscar();
		}

	}

	private String[] listarCargos() {
		@SuppressWarnings("unchecked")
		List<Object> listaObj = (List<Object>) banco.listarObjetos(Cargo.class,
				"descricao");
		String[] lista = new String[listaObj.size()];
		for (int i = 0; i < listaObj.size(); i++) {
			Cargo listProdut = (Cargo) listaObj.get(i);
			lista[i] = listProdut.getDescricao();
			listaCargo.add(listProdut.getId());
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
					"Pode salvar um Fornecedor novo agora!");

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
		Fornecedor c = (Fornecedor) banco.buscarPorId(Fornecedor.class,
				Integer.parseInt(txtId.getText()));
		if (a == 0) {
			JOptionPane.showMessageDialog(contentPane, "Fornecedor " + c.getRazaoSocial()
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
			txtInscricaoEstadual.setText("");
			txtEnd.setText("");
			txtFone1.setText("");
			txtId.setText("");
			txtRazaoSocial.setText("");
			txtEmail.setText("");
			txtCnpj.setText("");
			txtRazaoSocialFant.setText("");
			txtCep.setText("");
			boxUf.setSelectedIndex(0);

			btnDeletar.setEnabled(false);
		} catch (Exception e) {
			System.out.println("Erro - " + e);
		}
	}

	private void buscar() {
		try {

			Fornecedor c = (Fornecedor) banco.buscarPorId(Fornecedor.class,
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

				txtInscricaoEstadual.setText(String.valueOf(c.getInscEstadual()));
				txtId.setText(String.valueOf(c.getId()));
				txtRazaoSocial.setText(c.getRazaoSocial());
				txtRazaoSocialFant.setText(c.getNomeFantasia());
				txtCnpj.setText(c.getCnpj());

				txtEmail.setText(c.getEmail());

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
		
		Fornecedor f = new Fornecedor();
		f.setInscEstadual(txtInscricaoEstadual.getText());
		f.setEnd(end);
		f.setFone(telefones);
		f.setRazaoSocial(txtRazaoSocial.getText());
		f.setCnpj(txtCnpj.getText());
		f.setEmail(txtEmail.getText());
		f.setNomeFantasia(txtRazaoSocialFant.getText());

		System.out.println(telefones.getId());

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
