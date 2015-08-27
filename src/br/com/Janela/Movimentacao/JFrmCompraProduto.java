package br.com.Janela.Movimentacao;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import br.com.Bin.Produto.CFOP;
import br.com.Bin.Produto.Produto;
import br.com.Janela.Consulta.JFrmConsultaCFOP;
import br.com.Janela.Consulta.JFrmConsultaProduto;

import com.toedter.calendar.JDateChooser;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JFrmCompraProduto extends JDialog implements ActionListener {
	private JPanel contentPane;
	private JTextField txtCodComp;
	private JTextField txtNumDoc;
	private JTextField txtCodCFOP;
	private DecimalFormat df = new DecimalFormat("0.00");
	private SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
	private JDateChooser dtEntrada;
	private JTextField txtIdProd;
	private JTextField txtNomeProd;
	private JTextField txtCustoUnit;
	private JTextField txtTotal;
	private JTextField txtQuant;
	private JTable table;
	private JButton btnBuscarProd;
	private JButton btnBuscarCFOP;
	private JButton btnRecalcularTotal;
	private JButton btnFinalizarEntrada;
	private JButton btnCancelar;
	private JButton btnConfirmarProduto;
	private JButton btnExcluirProduto;
	private JButton btnInserirProduto;
	private JButton btnNovaEntrada;

	public static void main(String[] args) {
		try {
			JFrmCompraProduto dialog = new JFrmCompraProduto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the panel.
	 * @param escolher 
	 */
	public JFrmCompraProduto() {
		setTitle("Compra de Produtos");
		getContentPane().setLayout(null);
		setType(Type.UTILITY);
		// setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setResizable(false);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(5, 5, 230, 250);
		getContentPane().add(panel);
		contentPane.setLayout(null);
		panel.setLayout(null);

		btnNovaEntrada = new JButton("Nova Entrada");
		btnNovaEntrada.setBounds(10, 11, 210, 23);
		panel.add(btnNovaEntrada);

		btnInserirProduto = new JButton("Inserir Produto");
		btnInserirProduto.setBounds(10, 45, 210, 23);
		panel.add(btnInserirProduto);

		btnExcluirProduto = new JButton("Excluir Produto");
		btnExcluirProduto.setBounds(10, 79, 210, 23);
		panel.add(btnExcluirProduto);

		btnCancelar = new JButton("Cancelar Entrada");
		btnCancelar.setBounds(10, 113, 210, 23);
		panel.add(btnCancelar);

		btnConfirmarProduto = new JButton("Confirmar Produto");
		btnConfirmarProduto.setBounds(10, 147, 210, 23);
		panel.add(btnConfirmarProduto);

		btnFinalizarEntrada = new JButton("Finalizar Entrada");
		btnFinalizarEntrada.setBounds(10, 182, 210, 23);
		panel.add(btnFinalizarEntrada);

		btnRecalcularTotal = new JButton("Recalcular Total");
		btnRecalcularTotal.setBounds(10, 216, 210, 23);
		panel.add(btnRecalcularTotal);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(245, 5, 530, 250);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblCdigoDaEntrada = new JLabel("C\u00F3digo da Entrada");
		lblCdigoDaEntrada.setBounds(10, 10, 111, 14);
		panel_1.add(lblCdigoDaEntrada);

		JLabel lblNumeroNf = new JLabel("Num Documento");
		lblNumeroNf.setBounds(10, 55, 111, 14);
		panel_1.add(lblNumeroNf);

		JLabel lblTipoDeDocumento = new JLabel("Tipo de Documento");
		lblTipoDeDocumento.setBounds(216, 10, 111, 14);
		panel_1.add(lblTipoDeDocumento);

		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setBounds(10, 145, 111, 14);
		panel_1.add(lblProduto);

		JLabel lblDataDoDocumento = new JLabel("Data do Documento");
		lblDataDoDocumento.setBounds(10, 100, 111, 14);
		panel_1.add(lblDataDoDocumento);

		JLabel lblDataDaEntrada = new JLabel("Data da Entrada");
		lblDataDaEntrada.setBounds(216, 100, 111, 14);
		panel_1.add(lblDataDaEntrada);

		dtEntrada = new JDateChooser(new java.util.Date());
		dtEntrada.setEnabled(false);
		dtEntrada.setBounds(216, 115, 140, 20);
		panel_1.add(dtEntrada);

		JLabel lblCdigoCfop = new JLabel("C\u00F3digo CFOP");
		lblCdigoCfop.setBounds(216, 55, 111, 14);
		panel_1.add(lblCdigoCfop);

		JLabel lblToalDoPedido = new JLabel("Toal do Pedido");
		lblToalDoPedido.setBounds(330, 190, 120, 14);
		panel_1.add(lblToalDoPedido);

		txtCodComp = new JTextField();
		txtCodComp.setEnabled(false);
		txtCodComp.setBounds(10, 25, 161, 20);
		panel_1.add(txtCodComp);
		txtCodComp.setColumns(10);

		txtNumDoc = new JTextField();
		txtNumDoc.setText("0000000");
		txtNumDoc.setColumns(10);
		txtNumDoc.setBounds(10, 70, 161, 20);
		panel_1.add(txtNumDoc);
		String[] listaDoc = { "NF Simples", "NF Eletronica", "Doc. Não fiscal" };

		JComboBox boxTipoDoc = new JComboBox(listaDoc);
		boxTipoDoc.setBounds(216, 25, 267, 20);
		panel_1.add(boxTipoDoc);

		txtCodCFOP = new JTextField();
		txtCodCFOP.setEnabled(false);
		txtCodCFOP.setColumns(10);
		txtCodCFOP.setBounds(216, 70, 161, 20);
		panel_1.add(txtCodCFOP);

		JLabel lblCustoUnitario = new JLabel("Custo Unitario");
		lblCustoUnitario.setBounds(10, 190, 111, 14);
		panel_1.add(lblCustoUnitario);

		JDateChooser dtDoc = new JDateChooser(new java.util.Date());
		dtDoc.setBounds(10, 115, 140, 20);
		panel_1.add(dtDoc);

		txtIdProd = new JTextField();
		txtIdProd.setEnabled(false);
		txtIdProd.setBounds(10, 160, 71, 20);
		panel_1.add(txtIdProd);
		txtIdProd.setColumns(10);

		txtNomeProd = new JTextField();
		txtNomeProd.setEnabled(false);
		txtNomeProd.setBounds(91, 160, 286, 20);
		panel_1.add(txtNomeProd);
		txtNomeProd.setColumns(10);

		txtCustoUnit = new JTextField();
		txtCustoUnit.setText("0.00");
		txtCustoUnit.setColumns(10);
		txtCustoUnit.setBounds(10, 205, 86, 20);
		panel_1.add(txtCustoUnit);

		txtTotal = new JTextField();
		txtTotal.setText("0.00");
		txtTotal.setBounds(332, 205, 120, 20);
		panel_1.add(txtTotal);
		txtTotal.setColumns(10);

		btnBuscarCFOP = new JButton("Buscar");
		btnBuscarCFOP.setBounds(387, 69, 96, 23);
		panel_1.add(btnBuscarCFOP);

		btnBuscarProd = new JButton("Pesquisar");
		btnBuscarProd.setBounds(387, 159, 96, 23);
		panel_1.add(btnBuscarProd);

		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(131, 190, 111, 14);
		panel_1.add(lblQuantidade);

		txtQuant = new JTextField();
		txtQuant.setText("0.00");
		txtQuant.setColumns(10);
		txtQuant.setBounds(131, 205, 86, 20);
		panel_1.add(txtQuant);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(5, 260, 770, 191);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1, 1, 768, 189);
		panel_2.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnBuscarCFOP.addActionListener(this);
		btnBuscarProd.addActionListener(this);
		btnCancelar.addActionListener(this);
		btnConfirmarProduto.addActionListener(this);
		btnExcluirProduto.addActionListener(this);
		btnFinalizarEntrada.addActionListener(this);
		btnInserirProduto.addActionListener(this);
		btnNovaEntrada.addActionListener(this);
		btnRecalcularTotal.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		switch (acao) {
		case "Nova Entrada":

			break;
		case "Inserir Produto":

			break;

		case "Excluir Produto":

			break;

		case "Cancelar Entrada":

			break;

		case "Confirmar Produto":

			break;

		case "Finalizar Entrada":

			break;

		case "Recalcular Total":

			break;

		case "Buscar":
			buscarCFOP();

			break;

		case "Pesquisar":
			buscarProd();
			break;

		default:
			break;
		}

	}

	private void buscarProd() {
		JFrmConsultaProduto prod = new JFrmConsultaProduto("Escolher");	
		prod.setModal(true);
		prod.setVisible(true);
		
		Produto p = prod.getProduto();
		txtIdProd.setText(String.valueOf(p.getId()));
		txtNomeProd.setText(String.valueOf(p.getDescricao()));
		prod.dispose();
	}

	private void buscarCFOP() {
		JFrmConsultaCFOP cfop =new JFrmConsultaCFOP("Escolher");
		cfop.setModal(true);
		cfop.setVisible(true);
		txtCodCFOP.setText(String.valueOf(cfop.getCfop().getCod()));
		cfop.dispose();
		
	}
}
