package br.edu.ifpe.edu.paulista.tadala_fit.ui;

import java.awt.EventQueue;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CadastroAluno extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JTextField txtnome;
	protected JTextField txttelefone;
	protected JTextField txtdata;
	protected JTextField txtpeso;
	protected JTextField txtcpf;
	protected JTextField txtemail;
	protected JTextField txtaltura;
	protected JTextField txtbf;
	protected JTextField txtcomorbidade;
	protected JTextField txtuser;
	protected JPasswordField txtpassword;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroAluno dialog = new CadastroAluno();
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public CadastroAluno() {
		getContentPane().setBackground(new Color(0, 65, 130));
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadastroAluno.class.getResource("/assets_loginFrame/logotipo200x200.png")));
		setTitle("Tadalafit - Versão 1.0");
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(null, "deseja interromper o cadastro?","confirmação", JOptionPane.YES_NO_OPTION) == 0) {
					setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				}else {
					setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 79, 157));
		panel.setBounds(10, 11, 988, 707);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(CadastroAluno.class.getResource("/assets_loginFrame/user.png")));
		lblNewLabel_3.setBounds(55, 101, 150, 150);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("NOME:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel.setBounds(251, 86, 72, 20);
		panel.add(lblNewLabel);
		
		JLabel lblRg = new JLabel("TELEFONE:");
		lblRg.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRg.setForeground(Color.WHITE);
		lblRg.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblRg.setBounds(239, 132, 87, 24);
		panel.add(lblRg);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpf.setForeground(Color.WHITE);
		lblCpf.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblCpf.setBounds(556, 132, 72, 24);
		panel.add(lblCpf);
		
		JLabel lblDataNasc = new JLabel("DATA NASC:");
		lblDataNasc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataNasc.setForeground(Color.WHITE);
		lblDataNasc.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblDataNasc.setBounds(222, 183, 101, 24);
		panel.add(lblDataNasc);
		
		JLabel lblEmail = new JLabel("EMAIL:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblEmail.setBounds(556, 182, 72, 26);
		panel.add(lblEmail);
		
		JLabel lblCep = new JLabel("PESO:");
		lblCep.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCep.setForeground(Color.WHITE);
		lblCep.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblCep.setBounds(251, 227, 72, 24);
		panel.add(lblCep);
		
		JLabel lblBairro = new JLabel("ALTURA:");
		lblBairro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBairro.setForeground(Color.WHITE);
		lblBairro.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblBairro.setBounds(556, 227, 72, 24);
		panel.add(lblBairro);
		
		JLabel lblUf = new JLabel("BF:");
		lblUf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUf.setForeground(Color.WHITE);
		lblUf.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblUf.setBounds(726, 227, 72, 24);
		panel.add(lblUf);
		
		JLabel lblCidade_1 = new JLabel("COMORBIDADE:");
		lblCidade_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCidade_1.setForeground(Color.WHITE);
		lblCidade_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblCidade_1.setBounds(191, 278, 132, 24);
		panel.add(lblCidade_1);
		
		txtnome = new JTextField();
		txtnome.setBorder(null);
		txtnome.setFont(new Font("Arial Black", Font.BOLD, 13));
		txtnome.setColumns(10);
		txtnome.setBounds(333, 83, 514, 25);
		panel.add(txtnome);
		
		txttelefone = new JTextField();
		txttelefone.setFont(new Font("Arial Black", Font.BOLD, 13));
		txttelefone.setColumns(10);
		txttelefone.setBorder(null);
		txttelefone.setBounds(333, 135, 209, 25);
		panel.add(txttelefone);
		
		txtdata = new JTextField();
		txtdata.setFont(new Font("Arial Black", Font.BOLD, 13));
		txtdata.setColumns(10);
		txtdata.setBorder(null);
		txtdata.setBounds(333, 182, 209, 25);
		panel.add(txtdata);
		
		txtpeso = new JTextField();
		txtpeso.setFont(new Font("Arial Black", Font.BOLD, 13));
		txtpeso.setColumns(10);
		txtpeso.setBorder(null);
		txtpeso.setBounds(333, 226, 209, 25);
		panel.add(txtpeso);
		
		txtcpf = new JTextField();
		txtcpf.setFont(new Font("Arial Black", Font.BOLD, 13));
		txtcpf.setColumns(10);
		txtcpf.setBorder(null);
		txtcpf.setBounds(636, 132, 211, 25);
		panel.add(txtcpf);
		
		txtemail = new JTextField();
		txtemail.setFont(new Font("Arial Black", Font.BOLD, 13));
		txtemail.setColumns(10);
		txtemail.setBorder(null);
		txtemail.setBounds(636, 182, 211, 25);
		panel.add(txtemail);
		
		txtaltura = new JTextField();
		txtaltura.setFont(new Font("Arial Black", Font.BOLD, 13));
		txtaltura.setColumns(10);
		txtaltura.setBorder(null);
		txtaltura.setBounds(636, 226, 121, 25);
		panel.add(txtaltura);
		
		txtbf = new JTextField();
		txtbf.setFont(new Font("Arial Black", Font.BOLD, 13));
		txtbf.setColumns(10);
		txtbf.setBorder(null);
		txtbf.setBounds(810, 226, 37, 25);
		panel.add(txtbf);
		
		txtcomorbidade = new JTextField();
		txtcomorbidade.setFont(new Font("Arial Black", Font.BOLD, 13));
		txtcomorbidade.setColumns(10);
		txtcomorbidade.setBorder(null);
		txtcomorbidade.setBounds(333, 277, 209, 25);
		panel.add(txtcomorbidade);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		panel_2.setBackground(new Color(0, 65, 130));
		panel_2.setBounds(22, 348, 956, 10);
		panel.add(panel_2);
		
		JLabel lblUser = new JLabel("USUÁRIO: ");
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUser.setForeground(Color.WHITE);
		lblUser.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblUser.setBounds(194, 399, 132, 24);
		panel.add(lblUser);
		
		JLabel lblSenha = new JLabel("SENHA:");
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblSenha.setBounds(496, 399, 132, 24);
		panel.add(lblSenha);
		
		txtuser = new JTextField();
		txtuser.setFont(new Font("Arial Black", Font.BOLD, 13));
		txtuser.setColumns(10);
		txtuser.setBorder(null);
		txtuser.setBounds(333, 399, 209, 25);
		panel.add(txtuser);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(CadastroAluno.class.getResource("/assets_loginFrame/logotipo200x200.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(22, 566, 200, 130);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Copyright (c) 2022 Tadalafit  All Rights Reserved");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(370, 667, 324, 40);
		panel.add(lblNewLabel_2);
		
		JButton btnfinalizar = new JButton("Finalizar Matrícula");
		btnfinalizar.setFocusPainted(false);
		btnfinalizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nome = txtnome.getText();
				String telefone = txttelefone.getText();
				String data = txtdata.getText();
				String peso = txtpeso.getText();
				String cpf = txtcpf.getText();
				String email = txtemail.getText();
				String altura = txtaltura.getText();
				String bf = txtbf.getText();
				String comorbidade = txtcomorbidade.getText();
				String user = txtuser.getText();
				String password = new String(txtpassword.getPassword());
				
				if (nome.isBlank() || telefone.isBlank() || data.isBlank() || peso.isBlank() || cpf.isBlank() || email.isBlank() || altura.isBlank() || bf.isBlank() ||
						comorbidade.isBlank() || user.isBlank() || password.isBlank()) {
					JOptionPane.showMessageDialog(null,"Preencha todos os campos");
				}else {
					txtnome.setText("");
					txttelefone.setText("");
					txtdata.setText("");
					txtpeso.setText("");
					txtcpf.setText("");
					txtemail.setText("");
					txtaltura.setText("");
					txtbf.setText("");
					txtcomorbidade.setText("");
					txtuser.setText("");
					txtpassword.setText("");
					JOptionPane.showMessageDialog (null, "Cadastro Efetuado");
				}
			}
		});
		btnfinalizar.setFont(new Font("Arial", Font.BOLD, 16));
		btnfinalizar.setBackground(Color.WHITE);
		btnfinalizar.setBounds(599, 579, 218, 32);
		panel.add(btnfinalizar);
		
		JButton btnfinalizarecriartreinos = new JButton("Finalizar e Criar Treinos");
		btnfinalizarecriartreinos.setFocusPainted(false);
		btnfinalizarecriartreinos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nome = txtnome.getText();
				String telefone = txttelefone.getText();
				String data = txtdata.getText();
				String peso = txtpeso.getText();
				String cpf = txtcpf.getText();
				String email = txtemail.getText();
				String altura = txtaltura.getText();
				String bf = txtbf.getText();
				String comorbidade = txtcomorbidade.getText();
				String user = txtuser.getText();
				String password = new String(txtpassword.getPassword());
				if (nome.isBlank() || telefone.isBlank() || data.isBlank() || peso.isBlank() || cpf.isBlank() || email.isBlank() || altura.isBlank() || bf.isBlank() ||
						comorbidade.isBlank() || user.isBlank() || password.isBlank()) {
					JOptionPane.showMessageDialog(null,"Preencha todos os campos");
				}else {
					txtnome.setText("");
					txttelefone.setText("");
					txtdata.setText("");
					txtpeso.setText("");
					txtcpf.setText("");
					txtemail.setText("");
					txtaltura.setText("");
					txtbf.setText("");
					txtcomorbidade.setText("");
					txtuser.setText("");
					txtpassword.setText("");
					JOptionPane.showMessageDialog (null, "Cadastro Efetuado");
				}
			}
		});
		btnfinalizarecriartreinos.setFont(new Font("Arial", Font.BOLD, 16));
		btnfinalizarecriartreinos.setBackground(Color.WHITE);
		btnfinalizarecriartreinos.setBounds(324, 579, 218, 32);
		panel.add(btnfinalizarecriartreinos);
		
		JButton btngeraboleto = new JButton("Gerar Boleto");
		btngeraboleto.setFocusPainted(false);
		btngeraboleto.setFont(new Font("Arial", Font.BOLD, 16));
		btngeraboleto.setBackground(Color.WHITE);
		btngeraboleto.setBounds(324, 525, 218, 32);
		panel.add(btngeraboleto);
		
		JCheckBox pago = new JCheckBox("Pagamento Já Efetuado");
		pago.setFocusPainted(false);
		pago.setFont(new Font("Arial", Font.BOLD, 13));
		pago.setBounds(599, 525, 218, 32);
		panel.add(pago);
		
		txtpassword = new JPasswordField();
		txtpassword.setFont(new Font("Arial", Font.BOLD, 13));
		txtpassword.setBorder(null);
		txtpassword.setBounds(637, 400, 210, 23);
		panel.add(txtpassword);

	}
}
