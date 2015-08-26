package br.com.Janelas.Cadastro;

import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JOptionPane;

import br.com.Bin.Produto.LocalizacaoProduto;
import br.com.Persistence.Banco;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class JFrmCadastroLocalArmazenamento extends JDialog implements ActionListener {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtDescricao;
	private JTextField txtObsLocal;
	private JTextField txtCodigoBusca;
	private JButton btnSalvar;
	private JButton btnDeletar;
	private JButton btnApagar;
	private JButton btnSair;
	private JButton btnBuscar;
	private Banco banco = new Banco();


	/**
	 * Create the frame.
	 * @param idLocal 
	 */
	public JFrmCadastroLocalArmazenamento(Integer idLocal) {
		setTitle("Cadastro do Local do Armazenamento do Prouto");
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
		panel.setBounds(10, 41, 374, 190);
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

		txtObsLocal = new JTextField();
		txtObsLocal.setBounds(10, 125, 355, 20);
		panel.add(txtObsLocal);
		txtObsLocal.setColumns(10);

		JLabel lblc = new JLabel("Observa\u00E7\u00E3o da localiza\u00E7\u00E3o");
		lblc.setBounds(10, 105, 299, 20);
		panel.add(lblc);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 160, 80, 20);
		panel.add(btnSalvar);

		btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(100, 160, 80, 20);
		panel.add(btnDeletar);

		btnApagar = new JButton("Apagar");
		btnApagar.setBounds(195, 160, 80, 20);
		panel.add(btnApagar);

		btnSair = new JButton("Sair");
		btnSair.setBounds(285, 160, 80, 20);
		panel.add(btnSair);

		JLabel lblPesquisarCdigo = new JLabel("C\u00F3digo do Local");
		lblPesquisarCdigo.setBounds(10, 11, 128, 20);
		contentPane.add(lblPesquisarCdigo);

		txtCodigoBusca = new JTextField();
		txtCodigoBusca.setBounds(122, 10, 145, 20);
		contentPane.add(txtCodigoBusca);
		txtCodigoBusca.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(294, 10, 89, 20);
		contentPane.add(btnBuscar);
		
		btnApagar.addActionListener(this);
		btnBuscar.addActionListener(this);
		btnDeletar.addActionListener(this);
		btnSair.addActionListener(this);
		btnSalvar.addActionListener(this);
		if (idLocal!=0) {
			txtCodigoBusca.setText(String.valueOf(idLocal));
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
		LocalizacaoProduto c = (LocalizacaoProduto) banco .buscarPorId(LocalizacaoProduto.class, Integer.parseInt(txtCodigo.getText()));
		if (a==0) {
			JOptionPane.showMessageDialog(contentPane, "classeficação "+c.getDescricao()+" foi deletada com sucesso!");
			banco.deletarObjeto(c);
			apagar();
			btnDeletar.setEnabled(false);
		}
		setVisible(true);
	}

	private void apagar() {
		txtCodigoBusca.setText("");
		txtCodigo.setText("");
		txtDescricao.setText("");
		txtObsLocal.setText("");
		setVisible(false);
		JOptionPane.showMessageDialog(contentPane,
				"Pode salvar um local de armazenamento novo agora!");
		setVisible(true);
		btnDeletar.setEnabled(false);
	}

	private void buscar() {
		try {
		LocalizacaoProduto c = (LocalizacaoProduto) banco.buscarPorId(LocalizacaoProduto.class, Integer.parseInt(txtCodigoBusca.getText()));
		System.out.println(c);
		if (c!=null) {
			txtObsLocal.setText(c.getObsLocal());
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
			LocalizacaoProduto c = new LocalizacaoProduto();
			c.setObsLocal(txtObsLocal.getText());
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
