package br.com.Paineis;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JPnlRodaPe extends JPanel {

	private JLabel data;

	/**
	 * Create the panel.
	 */
	public JPnlRodaPe() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 1335, 40);
		setLayout(null);
		
		
		JLabel lblEmailDaEmpresa = new JLabel("contatocomercial@gmail.com");
		lblEmailDaEmpresa.setBounds(511, 11, 179, 14);
		add(lblEmailDaEmpresa);
		
		JLabel lblLinkDeContato = new JLabel("Link - A escalabilidade que voc\u00EA precisa");
		lblLinkDeContato.setForeground(new Color(65, 105, 225));
		lblLinkDeContato.setBounds(1095, 11, 230, 14);
		add(lblLinkDeContato);
		
		Date valorData = new Date() ;
        String dataz = "dd/MM/yyyy";
        SimpleDateFormat formatas = new SimpleDateFormat(dataz );
        String adata = formatas.format(valorData );

		data = new JLabel(adata);
		data.setBounds(10, 11, 120, 14);
		add(data);

	}
}
