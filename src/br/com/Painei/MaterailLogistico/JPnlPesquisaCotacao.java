package br.com.Painei.MaterailLogistico;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

public class JPnlPesquisaCotacao extends JPanel {

	/**
	 * Create the panel.
	 */
	public JPnlPesquisaCotacao() {

		setBounds(0, 0,  1060, 585);
		setLayout(null);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setBounds(10, 11, 89, 23);
		add(btnNovo);
		
		JLabel lblFornecedor = new JLabel("Fornecedor");
		lblFornecedor.setBounds(10, 67, 135, 14);
		add(lblFornecedor);
		
		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setBounds(10, 124, 123, 14);
		add(lblProduto);
	}
}
