package br.com.Janela.Movimentacao;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import com.toedter.calendar.JDateChooser;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JFrmCompraProduto extends JDialog {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private DecimalFormat df = new DecimalFormat("0.00");
	private SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy" );
	private JDateChooser jdc;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTable table;
	
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
		
		JButton btnNovaEntrada = new JButton("Nova Entrada");
		btnNovaEntrada.setBounds(10, 11, 210, 23);
		panel.add(btnNovaEntrada);
		
		JButton btnInserirProduto = new JButton("Inserir Produto");
		btnInserirProduto.setBounds(10, 45, 210, 23);
		panel.add(btnInserirProduto);
		
		JButton btnExcluirProduto = new JButton("Excluir Produto");
		btnExcluirProduto.setBounds(10, 79, 210, 23);
		panel.add(btnExcluirProduto);
		
		JButton btnCancelar = new JButton("Cancelar Entrada");
		btnCancelar.setBounds(10, 113, 210, 23);
		panel.add(btnCancelar);
		
		JButton btnConfirmarProduto = new JButton("Confirmar Produto");
		btnConfirmarProduto.setBounds(10, 147, 210, 23);
		panel.add(btnConfirmarProduto);
		
		JButton btnFinalizarEntrada = new JButton("Finalizar Entrada");
		btnFinalizarEntrada.setBounds(10, 182, 210, 23);
		panel.add(btnFinalizarEntrada);
		
		JButton btnRecalcularTotal = new JButton("Recalcular Total");
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
		
		jdc = new JDateChooser();
		jdc.setBounds(216, 115, 140, 20);
		panel_1.add(jdc);
		
		JLabel lblCdigoCfop = new JLabel("C\u00F3digo CFOP");
		lblCdigoCfop.setBounds(216, 55, 111, 14);
		panel_1.add(lblCdigoCfop);
		
		JLabel lblToalDoPedido = new JLabel("Toal do Pedido");
		lblToalDoPedido.setBounds(330, 190, 120, 14);
		panel_1.add(lblToalDoPedido);
		
		textField = new JTextField();
		textField.setBounds(10, 25, 161, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 70, 161, 20);
		panel_1.add(textField_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(216, 25, 267, 20);
		panel_1.add(comboBox);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(216, 70, 161, 20);
		panel_1.add(textField_2);
		
		JLabel lblCustoUnitario = new JLabel("Custo Unitario");
		lblCustoUnitario.setBounds(10, 190, 111, 14);
		panel_1.add(lblCustoUnitario);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(10, 115, 140, 20);
		panel_1.add(dateChooser);
		
		textField_3 = new JTextField();
		textField_3.setBounds(10, 160, 71, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(91, 160, 286, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(10, 205, 86, 20);
		panel_1.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setBounds(332, 205, 120, 20);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(387, 69, 96, 23);
		panel_1.add(btnBuscar);
		
		JButton button = new JButton("Buscar");
		button.setBounds(387, 159, 96, 23);
		panel_1.add(button);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(131, 190, 111, 14);
		panel_1.add(lblQuantidade);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(131, 205, 86, 20);
		panel_1.add(textField_7);
		
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

	}
}
