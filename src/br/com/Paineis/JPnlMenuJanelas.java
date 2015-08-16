package br.com.Paineis;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import br.com.Janelas.Cadastro.JFrmCadastroClassificacaoProduto;
import br.com.Janelas.Cadastro.JFrmCadastroLocalArmazenamento;
import br.com.Janelas.Cadastro.JFrmCadastroProduto;

public class JPnlMenuJanelas extends JPanel implements ActionListener {

	/**
	 * Create the panel.
	 */
	public JPnlMenuJanelas() {
		setBorder((Border) new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 1335, 80);
		setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(1, 1, this.getWidth()-2, 20);
		this.add(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		 
		menuBar.add(mnArquivo);
		
		JMenu mnProdutos = new JMenu("Produtos");
		mnArquivo.add(mnProdutos);
		
		JMenuItem mntmCadastrarProduto = new JMenuItem("Cadastrar Produto");
		mnProdutos.add(mntmCadastrarProduto);
		mntmCadastrarProduto.addActionListener(this);
		
		JMenuItem mntmCadatrarClasse = new JMenuItem("Cadatrar Classifica\u00E7\u00E3o de Produtos");
		mntmCadatrarClasse.addActionListener(this);
		mnProdutos.add(mntmCadatrarClasse);
		
		JMenuItem mntmCadastraLocalDe = new JMenuItem("Cadastra Local de Armazenamento");
		mntmCadastraLocalDe.addActionListener(this);
		mnProdutos.add(mntmCadastraLocalDe);
		
		JMenu mntmNewMenuItem_1 = new JMenu("Empresa");
		mnArquivo.add(mntmNewMenuItem_1);
		
		JMenu mntmNewMenuItem_3 = new JMenu("Funcionarios/Colaboradores");
		mnArquivo.add(mntmNewMenuItem_3);
		
		JMenu mntmNewMenuItem = new JMenu("Clientes");
		mnArquivo.add(mntmNewMenuItem);
		
		JMenu mnNewMenu = new JMenu("Fornecedores");
		mnArquivo.add(mnNewMenu);
		
		JMenu mnServios_1 = new JMenu("Servi\u00E7os");
		mnArquivo.add(mnServios_1);
		
		JMenu mnContratos = new JMenu("Contratos");
		mnArquivo.add(mnContratos);
		
		JMenu mnServios = new JMenu("Servi\u00E7os");
		mnArquivo.add(mnServios);
		
		JMenu mnImveis = new JMenu("Im\u00F3veis");
		mnArquivo.add(mnImveis);
		
		JMenuItem mnSair = new JMenuItem("Sair");
		mnArquivo.add(mnSair);
		
		JMenu mnConsulta = new JMenu("Consulta");
		menuBar.add(mnConsulta);
		
		JMenuItem mntmVendas = new JMenuItem("Vendas");
		mnConsulta.add(mntmVendas);
		
		JMenuItem mntmCompras = new JMenuItem("Compras");
		mnConsulta.add(mntmCompras);
		
		JMenuItem mntmEstoque = new JMenuItem("Estoque");
		mnConsulta.add(mntmEstoque);
		
		JMenuItem mntmCaixa = new JMenuItem("Caixa");
		mnConsulta.add(mntmCaixa);
		
		JMenu mnRelatrios = new JMenu("Relat\u00F3rios");
		menuBar.add(mnRelatrios);
		
		JMenuItem mntmFluxoDeCaixa = new JMenuItem("Fluxo de Caixa");
		mnRelatrios.add(mntmFluxoDeCaixa);
		
		JMenuItem mntmDemonstrativoRegularEm = new JMenuItem("Demonstrativo Regular em Exercicio");
		mnRelatrios.add(mntmDemonstrativoRegularEm);
		
		JMenuItem mntmBalanoPatrimonial = new JMenuItem("Balan\u00E7o Patrimonial");
		mnRelatrios.add(mntmBalanoPatrimonial);
		
		JMenu mnGrafico = new JMenu("Gr\u00E1fico");
		menuBar.add(mnGrafico);
		
		JMenuItem mntmCompras_1 = new JMenuItem("Compras");
		mnGrafico.add(mntmCompras_1);
		
		JMenuItem mntmVendas_1 = new JMenuItem("Vendas");
		mnGrafico.add(mntmVendas_1);
		
		JMenuItem mntmResultados = new JMenuItem("Resultados");
		mnGrafico.add(mntmResultados);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Despesas");
		mnGrafico.add(mntmNewMenuItem_5);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		mnAjuda.add(mntmHelp);
	}

	@Override
	public void actionPerformed(ActionEvent ac) {
		String acao = ac.getActionCommand();
		
		System.out.println(acao);
		
		switch (acao) {
		case "Cadastrar Produto":
			JFrmCadastroProduto c = new JFrmCadastroProduto();
			c.setVisible(true);
			
			break;
			
		case "Cadatrar Classifica\u00E7\u00E3o de Produtos":
			JFrmCadastroClassificacaoProduto t = new JFrmCadastroClassificacaoProduto();
			t.setVisible(true);
			
			break;
		case "Cadastra Local de Armazenamento":
			JFrmCadastroLocalArmazenamento y = new JFrmCadastroLocalArmazenamento();
			y.setVisible(true);
			
			break;
		default:
			break;
		}
		
	}

}
