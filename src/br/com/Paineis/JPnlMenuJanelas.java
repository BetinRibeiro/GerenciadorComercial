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

import br.com.Janela.Cadastro.JFrmCadastroCargo;
import br.com.Janela.Cadastro.JFrmCadastroClassificacaoProduto;
import br.com.Janela.Cadastro.JFrmCadastroCliente;
import br.com.Janela.Cadastro.JFrmCadastroContato;
import br.com.Janela.Cadastro.JFrmCadastroFornecedor;
import br.com.Janela.Cadastro.JFrmCadastroFuncionario;
import br.com.Janela.Cadastro.JFrmCadastroLocalArmazenamento;
import br.com.Janela.Cadastro.JFrmCadastroProduto;
import br.com.Janela.Consulta.*;
import br.com.Janela.Movimentacao.JFrmCompraProduto;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class JPnlMenuJanelas extends JPanel implements ActionListener {

	private JMenuItem mntmCadastroDeCliente;
	private JMenuItem mntmCadastrarFornecedor;
	private JMenuItem mntmCadastrarContato;
	private JMenuItem mntmConsultarProduto;
	private JMenuItem mntmConsultarCargo;
	private JMenuItem mntmConsultafornecedor;
	private JMenuItem mntmConsultaContato;
	private JMenuItem mntmConsultaCfop;

	/**
	 * Create the panel.
	 */
	public JPnlMenuJanelas() {
		setBorder((Border) new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 1335, 80);
		setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(1, 1, this.getWidth() - 2, 20);
		this.add(menuBar);

		JMenu mnArquivo = new JMenu("Arquivo");

		menuBar.add(mnArquivo);

		JMenu mntmNewMenuItem_1 = new JMenu("Empresa");
		mnArquivo.add(mntmNewMenuItem_1);

		JMenuItem mntmCadastrarSetor = new JMenuItem("Cadastrar Setor");
		mntmNewMenuItem_1.add(mntmCadastrarSetor);

		JMenuItem mntmConsultarSetor = new JMenuItem("Consultar Setor");
		mntmNewMenuItem_1.add(mntmConsultarSetor);

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

		JMenu mnCadatro = new JMenu("Cadatro");
		menuBar.add(mnCadatro);

		JMenu mnProdutos = new JMenu("Produtos");
		mnCadatro.add(mnProdutos);
		mnProdutos.setForeground(SystemColor.textHighlight);

		JMenuItem mntmCadastrarProduto = new JMenuItem("Cadastrar Produto");
		mnProdutos.add(mntmCadastrarProduto);
		mntmCadastrarProduto.addActionListener(this);

		JMenuItem mntmCadatrarClasse = new JMenuItem(
				"Cadatrar Classifica\u00E7\u00E3o de Produtos");
		mntmCadatrarClasse.addActionListener(this);
		mnProdutos.add(mntmCadatrarClasse);

		JMenuItem mntmCadastraLocalDe = new JMenuItem(
				"Cadastra Local de Armazenamento");
		mntmCadastraLocalDe.addActionListener(this);
		mnProdutos.add(mntmCadastraLocalDe);

		JMenuItem mntmCadastrarCfop = new JMenuItem("Cadastrar CFOP");
		mnProdutos.add(mntmCadastrarCfop);

		mntmConsultarProduto = new JMenuItem("Consultar Produto");
		mnProdutos.add(mntmConsultarProduto);
		mntmConsultarProduto.addActionListener(this);

		JMenuItem mntmConsultarClassificaoDe = new JMenuItem(
				"Consultar Classifica\u00E7\u00E3o de Produtos");
		mnProdutos.add(mntmConsultarClassificaoDe);

		JMenuItem mntmConsultarLocalDe = new JMenuItem(
				"Consultar Local de Armazenamento");
		mnProdutos.add(mntmConsultarLocalDe);

		mntmConsultaCfop = new JMenuItem("Consulta CFOP");
		mnProdutos.add(mntmConsultaCfop);
		mntmConsultaCfop.addActionListener(this);

		JMenu mntmNewMenuItem_3 = new JMenu("Funcionarios/Colaboradores");
		mntmNewMenuItem_3.setForeground(SystemColor.textHighlight);
		mnCadatro.add(mntmNewMenuItem_3);

		JMenuItem mntmCadastrarFuncionario = new JMenuItem(
				"Cadastrar Funcionario");
		mntmNewMenuItem_3.add(mntmCadastrarFuncionario);
		mntmCadastrarFuncionario.addActionListener(this);

		JMenuItem mntmCadastrarCargo = new JMenuItem("Cadastrar Cargo");
		mntmNewMenuItem_3.add(mntmCadastrarCargo);
		mntmCadastrarCargo.addActionListener(this);

		JMenuItem mntmConsultarFuncionario = new JMenuItem(
				"Consultar Funcionario");
		mntmNewMenuItem_3.add(mntmConsultarFuncionario);

		mntmConsultarCargo = new JMenuItem("Consultar Cargo");
		mntmNewMenuItem_3.add(mntmConsultarCargo);
		mntmConsultarCargo.addActionListener(this);

		JMenu mntmNewMenuItem = new JMenu("Clientes");
		mntmNewMenuItem.setForeground(SystemColor.textHighlight);
		mnCadatro.add(mntmNewMenuItem);

		mntmCadastroDeCliente = new JMenuItem("Cadastro de Cliente");
		mntmNewMenuItem.add(mntmCadastroDeCliente);

		JMenuItem mntmConsultarCliente = new JMenuItem("Consultar Cliente");
		mntmNewMenuItem.add(mntmConsultarCliente);
		mntmConsultarCliente.addActionListener(this);

		JMenu mnNewMenu = new JMenu("Fornecedores");
		mnNewMenu.setForeground(SystemColor.textHighlight);
		mnCadatro.add(mnNewMenu);

		mntmCadastrarFornecedor = new JMenuItem("Cadastrar Fornecedor");
		mnNewMenu.add(mntmCadastrarFornecedor);
		mntmCadastrarFornecedor.addActionListener(this);

		mntmConsultafornecedor = new JMenuItem("Consulta Fornecedor");
		mnNewMenu.add(mntmConsultafornecedor);
		mntmConsultafornecedor.addActionListener(this);

		mntmCadastrarContato = new JMenuItem("Cadastrar Contato");
		mnNewMenu.add(mntmCadastrarContato);

		mntmConsultaContato = new JMenuItem("Consulta Contato");
		mnNewMenu.add(mntmConsultaContato);
		mntmConsultaContato.addActionListener(this);

		mntmCadastrarContato.addActionListener(this);
		mntmCadastroDeCliente.addActionListener(this);
		mntmConsultarFuncionario.addActionListener(this);

		mntmConsultarClassificaoDe.addActionListener(this);
		mntmConsultarLocalDe.addActionListener(this);

		JMenu mnMovimentao = new JMenu("Movimenta\u00E7\u00E3o");
		menuBar.add(mnMovimentao);

		JMenuItem mntmNovaCompra = new JMenuItem("Compra");
		mnMovimentao.add(mntmNovaCompra);
		mntmNovaCompra.addActionListener(this);

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

		JMenuItem mntmDemonstrativoRegularEm = new JMenuItem(
				"Demonstrativo Regular em Exercicio");
		mnRelatrios.add(mntmDemonstrativoRegularEm);

		JMenuItem mntmBalanoPatrimonial = new JMenuItem(
				"Balan\u00E7o Patrimonial");
		mnRelatrios.add(mntmBalanoPatrimonial);

		JMenu mnGrafico = new JMenu("Gr\u00E1fico");
		menuBar.add(mnGrafico);

		JMenuItem mntmCompras_1 = new JMenuItem("Compras");
		mnGrafico.add(mntmCompras_1);
		mntmCompras_1.addActionListener(this);

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
			JFrmCadastroProduto c = new JFrmCadastroProduto(0);
			c.setVisible(true);

			break;

		case "Cadatrar Classifica\u00E7\u00E3o de Produtos":
			JFrmCadastroClassificacaoProduto t = new JFrmCadastroClassificacaoProduto(
					0);
			t.setVisible(true);

			break;
		case "Cadastra Local de Armazenamento":
			JFrmCadastroLocalArmazenamento y = new JFrmCadastroLocalArmazenamento(
					0);
			y.setVisible(true);

			break;
		case "Cadastrar Funcionario":
			JFrmCadastroFuncionario a = new JFrmCadastroFuncionario(0);
			a.setVisible(true);
			break;
		case "Cadastrar Cargo":
			JFrmCadastroCargo ar = new JFrmCadastroCargo(0);
			ar.setVisible(true);
			break;
		case "Cadastro de Cliente":
			JFrmCadastroCliente ccl = new JFrmCadastroCliente(0);
			ccl.setVisible(true);
			break;
		case "Cadastrar Fornecedor":
			JFrmCadastroFornecedor a1 = new JFrmCadastroFornecedor(0);
			a1.setVisible(true);
			break;
		case "Cadastrar Contato":
			JFrmCadastroContato a2 = new JFrmCadastroContato(0);
			a2.setVisible(true);
			break;
		case "Consultar Produto":
			JFrmConsultaProduto a3 = new JFrmConsultaProduto("");
			a3.setVisible(true);
			break;
		case "Consultar Classifica\u00E7\u00E3o de Produtos":
			JFrmConsultaClasseProduto a4 = new JFrmConsultaClasseProduto();
			a4.setVisible(true);
			break;

		case "Consultar Local de Armazenamento":
			JFrmConsultalocalizacaoProduto a5 = new JFrmConsultalocalizacaoProduto();
			a5.setVisible(true);
			break;
		case "Compra":
			JFrmCompraProduto a6 = new JFrmCompraProduto();
			a6.setVisible(true);
			break;

		case "Consultar Funcionario":
			JFrmConsultaFuncionario a7 = new JFrmConsultaFuncionario();
			a7.setVisible(true);
			break;
		case "Consultar Cliente":
			JFrmConsultaCliente a8 = new JFrmConsultaCliente();
			a8.setVisible(true);
			break;
		case "Consultar Cargo":
			JFrmConsultaCargoFuncionario a9 = new JFrmConsultaCargoFuncionario();
			a9.setVisible(true);
			break;
		case "Consulta Fornecedor":
			JFrmConsultaFornecedor a10 = new JFrmConsultaFornecedor();
			a10.setVisible(true);
			break;
		case "Consulta Contato":
			JFrmConsultaContato a11 = new JFrmConsultaContato();
			a11.setVisible(true);
			break;
		case "Consulta CFOP":
			JFrmConsultaCFOP a12 = new JFrmConsultaCFOP("");
			a12.setVisible(true);
			break;

		default:
			break;
		}

	}
}
