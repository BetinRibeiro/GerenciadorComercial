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

import br.com.Bin.Funcionario.*;
import br.com.Bin.Endereco;
import br.com.Bin.Telefone;
import br.com.Bin.Funcionario.Funcionario;
import br.com.Persistence.Banco;

public class JFrmCadastroFuncionario extends JDialog implements ActionListener {

	private JPanel contentPane;
	private JTextField txtCodPesq;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtRg;
	private JTextField txtCpf;
	private JTextField txtValorSalario;
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
	private JComboBox boxCargo;
	private JComboBox boxSexo;
	private JComboBox boxEscola;
	private JComboBox boxEstadoCivil;
	private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	private JDateChooser jdc;
	private JTextField txtCep;
	private JComboBox boxUf;
	private JLabel lblEmail;
	private JTextField txtEmail;

	/**
	 * Create the frame.
	 * 
	 * @param idFuncionario
	 */
	public JFrmCadastroFuncionario(int idFuncionario) {
		setTitle("Cadastro de Funcionarios");
		// setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCdigoCargo = new JLabel("C\u00F3digo Funcionario\r\n");
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
		panel.setBounds(10, 40, 614, 480);
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

		JLabel lblRg = new JLabel("RG");
		lblRg.setBounds(10, 100, 60, 20);
		panel.add(lblRg);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 145, 60, 20);
		panel.add(lblCpf);

		JLabel lblDataNasc = new JLabel("Data Nasc");
		lblDataNasc.setBounds(10, 190, 75, 20);
		panel.add(lblDataNasc);

		jdc = new JDateChooser();
		jdc.setBounds(10, 210, 140, 20);
		panel.add(jdc);

		JLabel lblEstadoCivil = new JLabel("Estado Civil");
		lblEstadoCivil.setBounds(223, 100, 83, 20);
		panel.add(lblEstadoCivil);

		JLabel lblEscolaridade = new JLabel("Escolaridade");
		lblEscolaridade.setBounds(223, 145, 83, 20);
		panel.add(lblEscolaridade);

		JLabel lblValorDoSalario = new JLabel("Valor do Salario");
		lblValorDoSalario.setBounds(295, 190, 99, 20);
		panel.add(lblValorDoSalario);

		txtNome = new JTextField();
		txtNome.setBounds(10, 75, 203, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);

		txtSobrenome = new JTextField();
		txtSobrenome.setColumns(10);
		txtSobrenome.setBounds(223, 75, 203, 20);
		panel.add(txtSobrenome);

		txtRg = new JTextField();
		txtRg.setColumns(10);
		txtRg.setBounds(10, 120, 203, 20);
		panel.add(txtRg);

		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(10, 165, 203, 20);
		panel.add(txtCpf);

		txtValorSalario = new JTextField();
		txtValorSalario.setColumns(10);
		txtValorSalario.setBounds(295, 210, 130, 20);
		panel.add(txtValorSalario);

		String[] a = { "Solteiro(a)", "Casado(a)", "Divorciado(a)", "Viuvo(a)",
				"Separado(a)" };
		boxEstadoCivil = new JComboBox(a);
		boxEstadoCivil.setBounds(223, 120, 203, 20);
		panel.add(boxEstadoCivil);

		String[] b = { "Ensino fundamental incompleto",
				"Ensino fundamental completo", "Ensino médio incompleto",
				"Ensino médio completo", "Ensino superior incompleto",
				"Ensino superior completo", "Pós-graduação", "Mestrado",
				"Doutorado" };
		boxEscola = new JComboBox(b);
		boxEscola.setBounds(223, 165, 203, 20);
		panel.add(boxEscola);

		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(160, 193, 71, 14);
		panel.add(lblSexo);

		String[] c = { "Masculino", "Feminino" };
		boxSexo = new JComboBox(c);
		boxSexo.setBounds(160, 210, 125, 20);
		panel.add(boxSexo);

		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setBounds(262, 236, 56, 14);
		panel.add(lblCargo);

		boxCargo = new JComboBox(listarCargos());
		boxCargo.setBounds(262, 253, 164, 20);
		panel.add(boxCargo);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 284, 594, 154);
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
		String[] uf = { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO",
				"MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ",
				"RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" };

		boxUf = new JComboBox(uf);
		boxUf.setBounds(434, 75, 71, 20);
		panel_2.add(boxUf);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(223, 449, 89, 20);
		panel.add(btnSalvar);

		btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(319, 449, 89, 20);
		panel.add(btnDeletar);

		btnApagar = new JButton("Apagar");
		btnApagar.setBounds(418, 449, 89, 20);
		panel.add(btnApagar);

		btnSair = new JButton("Sair");
		btnSair.setBounds(517, 449, 89, 20);
		panel.add(btnSair);

		lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 233, 60, 20);
		panel.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setText("");
		txtEmail.setColumns(10);
		txtEmail.setBounds(10, 253, 242, 20);
		panel.add(txtEmail);
		setResizable(false);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);

		btnApagar.addActionListener(this);
		btnBuscar.addActionListener(this);
		btnDeletar.addActionListener(this);
		btnSair.addActionListener(this);
		btnSalvar.addActionListener(this);
		boxEscola.setSelectedIndex(3);

		apagar();
		if (idFuncionario != 0) {
			txtCodPesq.setText(String.valueOf(idFuncionario));
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
			break;
		case "Sair":
			dispose();
			break;

		default:
			break;
		}

	}

	private void deletar() {
		try {
			setVisible(false);
			int a = JOptionPane.showConfirmDialog(contentPane,
					"Tem certeza que deseja deletar?");
			System.out.println(a);
			Funcionario c = (Funcionario) banco.buscarPorId(Funcionario.class,
					Integer.parseInt(txtId.getText()));
			if (a == 0) {
				JOptionPane.showMessageDialog(contentPane,
						"Funcionario " + c.getNome()
								+ " foi deletado com sucesso!");
				banco.deletarObjeto(c);
				apagar();
				btnDeletar.setEnabled(false);
			}
			setVisible(true);
		} catch (Exception e) {
			System.out.println("Selecione um item primeiro para poder excluir");
		}
	}

	private void apagar() {
		try {

			txtBairro.setText("");
			txtCel.setText("");
			txtCidade.setText("");
			txtCodPesq.setText("");
			txtCpf.setText("");
			txtEnd.setText("");
			txtFone1.setText("");
			txtId.setText("");
			txtNome.setText("");
			txtEmail.setText("");
			txtRg.setText("");
			txtSobrenome.setText("");
			txtValorSalario.setText("788.68");
			jdc.setDate(new java.util.Date());
			txtCep.setText("");
			boxCargo.setSelectedIndex(0);
			boxEscola.setSelectedIndex(3);
			boxEstadoCivil.setSelectedIndex(0);
			boxUf.setSelectedIndex(0);

			btnDeletar.setEnabled(false);
		} catch (Exception e) {
			System.out.println("Erro - " + e);
		}
	}

	private void buscar() {
		try {

			Funcionario c = (Funcionario) banco.buscarPorId(Funcionario.class,
					Integer.parseInt(txtCodPesq.getText()));
			for (int i = 0; i < listaCargo.size(); i++) {
				if (listaCargo.get(i).equals(c.getCargo().getId())) {
					boxCargo.getModel().setSelectedItem(
							c.getCargo().getDescricao());
				}
			}

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

				txtCpf.setText(String.valueOf(c.getCpf()));
				txtId.setText(String.valueOf(c.getId()));
				txtNome.setText(c.getNome());
				txtSobrenome.setText(c.getSobrenome());
				txtRg.setText(c.getRg());
				jdc.setDate(c.getDataNasc());
				txtValorSalario.setText(String.valueOf(c.getValorSalario()));

				for (int i = 0; i < listaCargo.size(); i++) {
					if (listaCargo.get(i).equals(c.getCargo().getId())) {
						boxCargo.getModel().setSelectedItem(
								c.getCargo().getDescricao());
					}
				}

				boxEstadoCivil.setSelectedItem(c.getEstadoCivil());
				boxEscola.setSelectedItem(c.getEscolaridade());
				boxSexo.setSelectedItem(c.getSexo());
				txtEmail.setText(c.getEmail());

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


			Cargo cargo = (Cargo) banco.buscarPorId(Cargo.class,
					listaCargo.get(boxCargo.getSelectedIndex()));
			System.out.println("Cargo " + cargo.getId());

			Telefone telefones = new Telefone();
			telefones.setCelular(txtCel.getText());
			telefones.setTelefone(txtFone1.getText());
			banco.salvarObjeto(telefones);

			Endereco end = new Endereco();
			end.setBairro(txtBairro.getText());
			end.setCidade(txtCidade.getText());
			end.setEnd(txtEnd.getText());
			end.setCep(txtCep.getText());
			end.setUf(String.valueOf(boxUf.getSelectedItem()));
			banco.salvarObjeto(end);

			Funcionario f = new Funcionario();

			f.setCargo(cargo);
			f.setCpf(txtCpf.getText());
			f.setDataNasc(Date.valueOf(df.format(jdc.getDate())));
			f.setEnd(end);
			f.setEscolaridade(String.valueOf(boxEscola.getSelectedItem()));
			f.setEstadoCivil(String.valueOf(boxEstadoCivil.getSelectedItem()));
			f.setFone(telefones);
			f.setNome(txtNome.getText());
			f.setRg(txtRg.getText());
			f.setEmail(txtEmail.getText());
			f.setSexo(String.valueOf(boxSexo.getSelectedItem()));
			f.setSobrenome(txtSobrenome.getText());
			f.setValorSalario(Float.parseFloat(txtValorSalario.getText()
					.replace(",", ".")));

			if (!txtId.getText().equalsIgnoreCase("")) {
				f.setId(Integer.valueOf(txtId.getText()));
				banco.salvarOuAtualizarObjeto(f);
				JOptionPane.showMessageDialog(contentPane,
						"Produto salvo com sucesso!");
				txtId.setText(String.valueOf(f.getId()));
				apagar();
			} else {

				banco.salvarOuAtualizarObjeto(f);
				setVisible(false);
				JOptionPane.showMessageDialog(contentPane,
						"Produto salvo com sucesso!");
				JOptionPane.showMessageDialog(contentPane, "não tem um id");
				apagar();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane,
					"Erro ao salvar, verifique a integridade dos dados.");
		}

	}

}
