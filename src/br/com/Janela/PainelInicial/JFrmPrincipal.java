package br.com.Janela.PainelInicial;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

import java.awt.Component;

import javax.swing.Box;
import javax.transaction.Transactional.TxType;

import org.jboss.jandex.Main;

import br.com.Paineis.JPnlMenuJanelas;
import br.com.Paineis.JPnlRodaPe;

import com.jtattoo.plaf.aero.AeroLookAndFeel;
import com.jtattoo.plaf.smart.SmartLookAndFeel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class JFrmPrincipal extends JFrame {

	private JPanel contentPane;
	private JLabel foto;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// com.jtattoo.plaf.luna.LunaLookAndFeel azulado simples
					// com.jtattoo.plaf.smart.SmartLookAndFeel o padrão que eu
					// usava muito
					// com.jtattoo.plaf.hifi.HiFiLookAndFeel preto bem massa!!
					// com.jtattoo.plaf.graphite.GraphiteLookAndFeel preto com
					// detalhes marrons
					// com.jtattoo.plaf.fast.FastLookAndFeel cinza basico
					// com.jtattoo.plaf.aluminium.AluminiumLookAndFeel -
					// com.jtattoo.plaf.acryl.AcrylLookAndFeel - um pouco
					// transparente detalhes em preto, bonito
					// com.jtattoo.plaf.bernstein.BernsteinLookAndFeel bonito
					// detalhes em amarelo laranja
					// com.jtattoo.plaf.mcwin.McWinLookAndFeel interface do
					// MacOs
					// com.jtattoo.plaf.mint.MintLookAndFeel basico cores cinsas
					// padrao
					// com.jtattoo.plaf.noire.NoireLookAndFeel preto com detalhe
					// em laranja
					// com.jtattoo.plaf.smart.SmartLookAndFeel tons em azul
					// com.jtattoo.plaf.texture.TextureLookAndFeel banco gelo
					// com detalhes em preto fosco muito massa
					Properties props = new Properties();
					props.put("logoString", "");  
					SmartLookAndFeel.setCurrentTheme(props);
					
					
					UIManager
							.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
					JFrmPrincipal frame = new JFrmPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrmPrincipal() {
		setTitle("Gerenciador Comercial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(0, 0, screenSize.width, screenSize.height);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		JPanel panelMenuJanelas = new JPanel();
		panelMenuJanelas.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMenuJanelas.setBounds(5, 5, 1335, 80);
		contentPane.add(panelMenuJanelas);
		panelMenuJanelas.setLayout(null);

		// TODO - temos que passar aqui os botões que sãoliberados isso depende
		// do usuario que está logado
		// a mesma coisa para os botões que estão nessa janela
		JPnlMenuJanelas pmj = new JPnlMenuJanelas();
		panelMenuJanelas.add(pmj);

		JPanel panelMenuSetor = new JPanel();
		panelMenuSetor.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMenuSetor.setBounds(5, 90, 270, 585);
		contentPane.add(panelMenuSetor);
		panelMenuSetor.setLayout(null);

		 button = new JButton("Produ\u00E7\u00E3o");
		button.setBounds(10, 10, 250, 25);
		panelMenuSetor.add(button);

		 button_1 = new JButton("Servi\u00E7o");
		button_1.setBounds(10, 40, 250, 30);
		panelMenuSetor.add(button_1);

		 button_2 = new JButton("Comercial");
		button_2.setBounds(10, 75, 250, 25);
		panelMenuSetor.add(button_2);

		 button_3 = new JButton("Marketing");
		button_3.setBounds(10, 105, 250, 25);
		panelMenuSetor.add(button_3);

		JButton button_4 = new JButton("Financeira");
		button_4.setBounds(10, 135, 250, 25);
		panelMenuSetor.add(button_4);

		 button_5 = new JButton("Material");
		button_5.setBounds(10, 165, 250, 25);
		panelMenuSetor.add(button_5);

		 button_6 = new JButton("Logisica");
		button_6.setBounds(10, 195, 250, 25);
		panelMenuSetor.add(button_6);

		 button_7 = new JButton("Recursos Humanos");
		button_7.setBounds(10, 225, 250, 25);
		panelMenuSetor.add(button_7);

		 button_8 = new JButton("Juridico-Legal");
		button_8.setBounds(10, 255, 250, 25);
		panelMenuSetor.add(button_8);

		JPanel panelRodaPe = new JPanel();
		panelRodaPe.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelRodaPe.setBounds(5, 680, 1335, 40);
		contentPane.add(panelRodaPe);
		panelRodaPe.setLayout(null);

		JPnlRodaPe r = new JPnlRodaPe();
		panelRodaPe.add(r);

		JPanel panelSetorial = new JPanel();
		panelSetorial.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelSetorial.setBounds(280, 90, 1060, 585);
		contentPane.add(panelSetorial);
		panelSetorial.setLayout(null);

		foto = new JLabel();
		foto.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		foto.setBounds(0, 0, 1060, 585);
		ImageIcon imagem = new ImageIcon(
				Main.class.getResource("/br/com/Img/img1.jpg"));
		Image img = imagem.getImage().getScaledInstance(foto.getWidth(),
				foto.getHeight(), Image.SCALE_DEFAULT);
		foto.setIcon(new ImageIcon(img));
		panelSetorial.add(foto);

	}
}
