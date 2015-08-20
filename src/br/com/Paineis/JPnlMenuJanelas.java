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

import br.com.Janelas.Cadastro.JFrmCadastroCargo;
import br.com.Janelas.Cadastro.JFrmCadastroClassificacaoProduto;
import br.com.Janelas.Cadastro.JFrmCadastroCliente;
import br.com.Janelas.Cadastro.JFrmCadastroContato;
import br.com.Janelas.Cadastro.JFrmCadastroFornecedor;
import br.com.Janelas.Cadastro.JFrmCadastroFuncionario;
import br.com.Janelas.Cadastro.JFrmCadastroLocalArmazenamento;
import br.com.Janelas.Cadastro.JFrmCadastroProduto;

@SuppressWarnings("serial")
public class JPnlMenuJanelas extends JPanel implements ActionListener {

	private JMenuItem mntmCadastroDeCliente;
	private JMenuItem mntmCadastrarFornecedor;
	private JMenuItem mntmCadastrarContato;

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
		mntmCadastrarProduto.setBackground(new Color(230, 230, 250));
		mnProdutos.add(mntmCadastrarProduto);
		mntmCadastrarProduto.addActionListener(this);
		
		JMenuItem mntmCadatrarClasse = new JMenuItem("Cadatrar Classifica\u00E7\u00E3o de Produtos");
		mntmCadatrarClasse.setBackground(new Color(230, 230, 250));
		mntmCadatrarClasse.addActionListener(this);
		mnProdutos.add(mntmCadatrarClasse);
		
		JMenuItem mntmCadastraLocalDe = new JMenuItem("Cadastra Local de Armazenamento");
		mntmCadastraLocalDe.setBackground(new Color(230, 230, 250));
		mntmCadastraLocalDe.addActionListener(this);
		mnProdutos.add(mntmCadastraLocalDe);
		
		JMenuItem mntmConsultarProduto = new JMenuItem("Consultar Produto");
		mnProdutos.add(mntmConsultarProduto);
		
		JMenuItem mntmConsultarClassificaoDe = new JMenuItem("Consultar Classifica\u00E7\u00E3o de Produtos");
		mnProdutos.add(mntmConsultarClassificaoDe);
		
		JMenuItem mntmConsultarLocalDe = new JMenuItem("Consultar Local de Armazenamento");
		mnProdutos.add(mntmConsultarLocalDe);
		
		JMenu mntmNewMenuItem_3 = new JMenu("Funcionarios/Colaboradores");
		mnArquivo.add(mntmNewMenuItem_3);
		
		JMenuItem mntmCadastrarFuncionario = new JMenuItem("Cadastrar Funcionario");
		mntmCadastrarFuncionario.setBackground(new Color(230, 230, 250));
		mntmNewMenuItem_3.add(mntmCadastrarFuncionario);
		mntmCadastrarFuncionario.addActionListener(this);
		
		JMenuItem mntmConsultarFuncionario = new JMenuItem("Consultar Funcionario");
		mntmNewMenuItem_3.add(mntmConsultarFuncionario);
		
		JMenu mntmNewMenuItem_1 = new JMenu("Empresa");
		mnArquivo.add(mntmNewMenuItem_1);
		
		JMenuItem mntmCadastrarSetor = new JMenuItem("Cadastrar Setor");
		mntmNewMenuItem_1.add(mntmCadastrarSetor);
		
		JMenuItem mntmCadastrarCargo = new JMenuItem("Cadastrar Cargo");
		mntmCadastrarCargo.setBackground(new Color(230, 230, 250));
		mntmNewMenuItem_1.add(mntmCadastrarCargo);
		mntmCadastrarCargo.addActionListener(this);
		
		JMenuItem mntmConsultarSetor = new JMenuItem("Consultar Setor");
		mntmNewMenuItem_1.add(mntmConsultarSetor);
		
		JMenuItem mntmConsultarCargo = new JMenuItem("Consultar Cargo");
		mntmNewMenuItem_1.add(mntmConsultarCargo);
		
		JMenu mntmNewMenuItem = new JMenu("Clientes");
		mnArquivo.add(mntmNewMenuItem);
		
		mntmCadastroDeCliente = new JMenuItem("Cadastro de Cliente");
		mntmCadastroDeCliente.setBackground(new Color(230, 230, 250));
		mntmNewMenuItem.add(mntmCadastroDeCliente);
		
		JMenuItem mntmConsultarCliente = new JMenuItem("Consultar Cliente");
		mntmNewMenuItem.add(mntmConsultarCliente);
		mntmCadastroDeCliente.addActionListener(this);
		
		JMenu mnNewMenu = new JMenu("Fornecedores");
		mnArquivo.add(mnNewMenu);
		
		mntmCadastrarFornecedor = new JMenuItem("Cadastrar Fornecedor");
		mntmCadastrarFornecedor.setBackground(new Color(230, 230, 250));
		mnNewMenu.add(mntmCadastrarFornecedor);
		mntmCadastrarFornecedor.addActionListener(this);
		
		mntmCadastrarContato = new JMenuItem("Cadastrar Contato");
		mntmCadastrarContato.setBackground(new Color(230, 230, 250));
		mnNewMenu.add(mntmCadastrarContato);
		mntmCadastrarContato.addActionListener(this);
		
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
			case"Cadastrar Funcionario":
				JFrmCadastroFuncionario a = new JFrmCadastroFuncionario();
				a.setVisible(true);
			break;
			case"Cadastrar Cargo":
				JFrmCadastroCargo ar = new JFrmCadastroCargo();
				ar.setVisible(true);
			break;
			case"Cadastro de Cliente":
				JFrmCadastroCliente ccl = new JFrmCadastroCliente();
				ccl.setVisible(true);
			break;
			case"Cadastrar Fornecedor":
				JFrmCadastroFornecedor a1 = new JFrmCadastroFornecedor();
				a1.setVisible(true);
			break;
			case"Cadastrar Contato":
				JFrmCadastroContato a2 = new JFrmCadastroContato();
				a2.setVisible(true);
			break;
		default:
			break;
		}
		
	}
}
