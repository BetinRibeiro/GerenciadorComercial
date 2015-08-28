package br.com.Janela.Movimentacao;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.TableModel;

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
import br.com.TableModel.*;

import com.toedter.calendar.JDateChooser;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;

public class JFrmCompraProduto extends JDialog implements ActionListener {
	private JPanel contentPane;
	private JTextField txtCodComp;
	private JTextField txtNumDoc;
	private JTextField txtCodCFOP;
	private DecimalFormat df = new DecimalFormat("0.00");
	private SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
	private JDateChooser dtEntrada;
	private JTable table;
	private JButton btnBuscarCFOP;
	private JButton btnRecalcularTotal;
	private JButton btnFinalizarEntrada;
	private JButton btnCancelar;
	private JButton btnExcluirProduto;
	private JButton btnInserirProduto;
	private JButton btnNovaEntrada;
	private TMCompraProduto model = new TMCompraProduto();
	private JLabel lblTotalGeral;
	private JTextField txtTotalGeral;
	private JPanel panel_3;
	private JTextField txtIdProduto;
	private JTextField txtNomeProduto;
	private JTextField txtTotal;
	private JTextField txtQuant;
	private JTextField txtCusto;
	private JButton btnPesquisar;

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
	 * 
	 * @param escolher
	 */
	public JFrmCompraProduto() {
		setTitle("Compra de Produtos");
		getContentPane().setLayout(null);
		setType(Type.UTILITY);
		// setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setResizable(false);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(5, 5, 230, 272);
		getContentPane().add(panel);
		contentPane.setLayout(null);
		panel.setLayout(null);

		btnNovaEntrada = new JButton("Nova Entrada");
		btnNovaEntrada.setBounds(10, 11, 210, 23);
		panel.add(btnNovaEntrada);

		btnInserirProduto = new JButton("Inserir Produto");
		btnInserirProduto.setBounds(10, 45, 210, 23);
		panel.add(btnInserirProduto);

		btnExcluirProduto = new JButton("Retirar Produto");
		btnExcluirProduto.setBounds(10, 79, 210, 23);
		panel.add(btnExcluirProduto);

		btnCancelar = new JButton("Cancelar Entrada");
		btnCancelar.setBounds(10, 113, 210, 23);
		panel.add(btnCancelar);

		btnFinalizarEntrada = new JButton("Finalizar Entrada");
		btnFinalizarEntrada.setBounds(10, 182, 210, 23);
		panel.add(btnFinalizarEntrada);

		btnRecalcularTotal = new JButton("Recalcular Total");
		btnRecalcularTotal.setBounds(10, 216, 210, 23);
		panel.add(btnRecalcularTotal);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(245, 5, 530, 272);
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

		JDateChooser dtDoc = new JDateChooser(new java.util.Date());
		dtDoc.setBounds(10, 115, 140, 20);
		panel_1.add(dtDoc);

		btnBuscarCFOP = new JButton("Buscar");
		btnBuscarCFOP.setBounds(387, 69, 96, 23);
		panel_1.add(btnBuscarCFOP);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(10, 146, 510, 115);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label = new JLabel("Produto");
		label.setBounds(10, 11, 111, 14);
		panel_3.add(label);
		
		txtIdProduto = new JTextField();
		txtIdProduto.setEnabled(false);
		txtIdProduto.setColumns(10);
		txtIdProduto.setBounds(10, 26, 71, 20);
		panel_3.add(txtIdProduto);
		
		txtNomeProduto = new JTextField();
		txtNomeProduto.setEnabled(false);
		txtNomeProduto.setColumns(10);
		txtNomeProduto.setBounds(91, 26, 286, 20);
		panel_3.add(txtNomeProduto);
		
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(387, 25, 96, 23);
		panel_3.add(btnPesquisar);
		
		txtTotal = new JTextField();
		txtTotal.setText("0.00");
		txtTotal.setColumns(10);
		txtTotal.setBounds(332, 71, 120, 20);
		panel_3.add(txtTotal);
		
		txtQuant = new JTextField();
		txtQuant.setText("0.00");
		txtQuant.setColumns(10);
		txtQuant.setBounds(131, 71, 86, 20);
		panel_3.add(txtQuant);
		
		JLabel label_1 = new JLabel("Quantidade");
		label_1.setBounds(131, 56, 111, 14);
		panel_3.add(label_1);
		
		JLabel label_2 = new JLabel("Custo Unitario");
		label_2.setBounds(10, 56, 111, 14);
		panel_3.add(label_2);
		
		txtCusto = new JTextField();
		txtCusto.setText("0.00");
		txtCusto.setColumns(10);
		txtCusto.setBounds(10, 71, 86, 20);
		panel_3.add(txtCusto);
		
		JLabel label_3 = new JLabel("Total ");
		label_3.setBounds(330, 56, 120, 14);
		panel_3.add(label_3);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(5, 288, 770, 191);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1, 1, 768, 189);
		panel_2.add(scrollPane);

		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		lblTotalGeral = new JLabel("Total Geral");
		lblTotalGeral.setBounds(565, 490, 80, 14);
		contentPane.add(lblTotalGeral);
		
		txtTotalGeral = new JTextField();
		txtTotalGeral.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTotalGeral.setText("0.00");
		txtTotalGeral.setColumns(10);
		txtTotalGeral.setBounds(655, 485, 120, 20);
		contentPane.add(txtTotalGeral);

		btnBuscarCFOP.addActionListener(this);
		btnCancelar.addActionListener(this);
		btnExcluirProduto.addActionListener(this);
		btnFinalizarEntrada.addActionListener(this);
		btnInserirProduto.addActionListener(this);
		btnNovaEntrada.addActionListener(this);
		btnRecalcularTotal.addActionListener(this);
		btnPesquisar.addActionListener(this);

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
		try {
			JFrmConsultaProduto prod = new JFrmConsultaProduto("Escolher");
			prod.setModal(true);
			prod.setVisible(true);

			Produto p = prod.getProduto();
			txtIdProduto.setText(String.valueOf(p.getId()));
			txtNomeProduto.setText(String.valueOf(p.getDescricao()));
			prod.dispose();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void buscarCFOP() {
		try {

			JFrmConsultaCFOP cfop = new JFrmConsultaCFOP("Escolher");
			cfop.setModal(true);
			cfop.setVisible(true);
			txtCodCFOP.setText(String.valueOf(cfop.getCfop().getCod()));
			cfop.dispose();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
