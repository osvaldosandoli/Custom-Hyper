package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.DAO;
import net.proteanit.sql.DbUtils;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import javax.swing.JTextPane;

public class Sobre extends JDialog {
	private JLabel lblHora;
	private JLabel lblStatus;
	private JLabel lblData;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	public static void main(String[] args) {
		try {
			Sobre dialog = new Sobre();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Sobre() {
		setTitle("HYPER CUSTOM - AGRADECIMENTO");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Lista.class.getResource("/icones/icone.png")));
		getContentPane().setBounds(new Rectangle(100, 100, 870, 570));
		setBounds(new Rectangle(100, 100, 870, 570));
		setModal(true);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 884, 67);
		panel.setBackground(Color.GRAY);
		getContentPane().add(panel);
		panel.setLayout(null);

		lblData = new JLabel("");
		lblData.setBounds(38, 11, 294, 29);
		panel.add(lblData);

		lblHora = new JLabel("");
		lblHora.setBounds(382, 11, 132, 29);
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel.add(lblHora);

		lblStatus = new JLabel("");
		lblStatus.setBounds(791, 11, 86, 56);
		lblStatus.setToolTipText("Conex\u00E3o");
		panel.add(lblStatus);

		lblNewLabel = new JLabel("AGRADE");
		lblNewLabel.setBounds(276, 78, 117, 36);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Microsoft JhengHei", Font.ITALIC, 25));
		getContentPane().add(lblNewLabel);

		lblNewLabel_1 = new JLabel("CIMENTO");
		lblNewLabel_1.setBounds(377, 86, 160, 20);
		lblNewLabel_1.setFont(new Font("Microsoft JhengHei", Font.ITALIC, 25));
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Sobre.class.getResource("/icones/Hyper.png")));
		lblNewLabel_2.setToolTipText("Logo");
		lblNewLabel_2.setBounds(695, 365, 149, 155);
		getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Sobre.class.getResource("/icones/equipeHyper.jpg")));
		lblNewLabel_3.setBounds(250, 114, 287, 229);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Esse \u00E9 o nosso projeto integrador!");
		lblNewLabel_4.setFont(new Font("Microsoft JhengHei", Font.ITALIC, 25));
		lblNewLabel_4.setBounds(20, 397, 589, 28);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Agradecemos a todos os professores");
		lblNewLabel_4_1.setFont(new Font("Microsoft JhengHei", Font.ITALIC, 25));
		lblNewLabel_4_1.setBounds(20, 428, 589, 36);
		getContentPane().add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("SENAC - TATUAPE");
		lblNewLabel_4_1_1.setFont(new Font("Microsoft JhengHei", Font.ITALIC, 25));
		lblNewLabel_4_1_1.setBounds(20, 475, 589, 28);
		getContentPane().add(lblNewLabel_4_1_1);
		

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				setarData();
				status();
			}

		});
	}

	private void setarData() {
		Date dataLabel = new Date();
		DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
		lblData.setText(formatador.format(dataLabel));

		Calendar c = Calendar.getInstance();
		Date hora = c.getTime();
		DateFormat horaFormatador = DateFormat.getTimeInstance();
		lblHora.setText(horaFormatador.format(dataLabel));

	}

	DAO dao = new DAO();
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;

	private void status() {

		try {
			Connection con = dao.conectar();

			System.out.println("Banco Conectado");

			if (con == null) {
				lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/desconectou.png")));
			} else {
				lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/conectou.png")));
			}
			con.close();
		} catch (com.mysql.cj.jdbc.exceptions.CommunicationsException ex) {
			JOptionPane.showMessageDialog(null, "Servidor Indisponivel");
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}