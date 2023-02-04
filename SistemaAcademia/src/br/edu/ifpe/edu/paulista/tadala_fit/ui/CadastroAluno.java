package br.edu.ifpe.edu.paulista.tadala_fit.ui;

import java.awt.EventQueue;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Desktop;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import br.edu.ifpe.paulista.tadala_fit.core.Aluno;
import br.edu.ifpe.paulista.tadala_fit.core.CreateController;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

import org.apache.commons.validator.routines.DateValidator;
import org.apache.commons.validator.routines.EmailValidator;


public class CadastroAluno extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFormattedTextField txtnome;
	private JFormattedTextField txttelefone;
	private JFormattedTextField txtcpf;
	private JFormattedTextField txtdata;
	private JFormattedTextField txtpeso;
	private JFormattedTextField txtcomorbidade;
	private JFormattedTextField txtsexo;
	private JFormattedTextField txtaltura;
	private JFormattedTextField txtbf;
	private JFormattedTextField txtemail;
	private JFormattedTextField txtuser;
	private Aluno alunoCadastrado;
	private static JDialog dialog;
	private JLabel lblfoto;
	private java.sql.Blob imagemBlob = null;
	private JPasswordField txtpassword;
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					try {
						dialog = new CadastroAluno();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						dialog.setVisible(true);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 * @throws ParseException 
	 */
	public CadastroAluno() throws ParseException {
		getContentPane().setBackground(new Color(0, 65, 130));
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadastroAluno.class.getResource("/assets_loginFrame/logotipo200x200.png")));
		setTitle("Tadalafit - Versão 1.0");
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(null, "deseja voltar pro menu?","confirmação", JOptionPane.YES_NO_OPTION) == 0) {
					setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				}else {
					setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		setBounds(100, 100, 1024, 768);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 79, 157));
		panel.setBounds(10, 11, 988, 707);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblfoto = new JLabel("");
		lblfoto.setIcon(new ImageIcon(CadastroAluno.class.getResource("/assets_loginFrame/user.png")));
		lblfoto.setBounds(55, 101, 150, 150);
		panel.add(lblfoto);
		
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
		lblCep.setBounds(556, 227, 72, 24);
		panel.add(lblCep);
		
		JLabel lblBairro = new JLabel("ALTURA:");
		lblBairro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBairro.setForeground(Color.WHITE);
		lblBairro.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblBairro.setBounds(666, 227, 72, 24);
		panel.add(lblBairro);
		
		JLabel lblUf = new JLabel("BF:");
		lblUf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUf.setForeground(Color.WHITE);
		lblUf.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblUf.setBounds(748, 227, 83, 24);
		panel.add(lblUf);
		
		JLabel lblCidade_1 = new JLabel("COMORBIDADE:");
		lblCidade_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCidade_1.setForeground(Color.WHITE);
		lblCidade_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblCidade_1.setBounds(191, 227, 132, 24);
		panel.add(lblCidade_1);
		
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
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(CadastroAluno.class.getResource("/assets_loginFrame/logotipo200x200.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(22, 566, 200, 130);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Copyright (c) 2023 Tadalafit  All Rights Reserved");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(370, 667, 324, 40);
		panel.add(lblNewLabel_2);
		
		JButton btnfinalizar = new JButton("Finalizar Matrícula");
		btnfinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String telefone = txttelefone.getText();
					String data = txtdata.getText();
					String nome = txtnome.getText();					
					String nometrim = nome.trim();
					Double peso = Double.parseDouble(txtpeso.getText());					
					String cpf = txtcpf.getText();					
					String email = txtemail.getText();
					String emailstrip = email.strip();
					Double altura = Double.parseDouble(txtaltura.getText());
					Double bf = Double.parseDouble(txtbf.getText());
					String sexo = txtsexo.getText();
					String comorbidade = txtcomorbidade.getText();
					String user = txtuser.getText();
					String userstrip = user.strip();
					String password = new String(txtpassword.getPassword());	
					String passwordstrip = password.strip();
					EmailValidator emailvalidator = EmailValidator.getInstance();
					DateValidator datevalidator = DateValidator.getInstance();
					if (!emailvalidator.isValid(email)) {
							JOptionPane.showMessageDialog(null,"Email inválido");
					}else if(!datevalidator.isValid(data)) {
							JOptionPane.showMessageDialog(null,"Data inválida");
					}
					if(emailvalidator.isValid(email) && datevalidator.isValid(data)) {
						alunoCadastrado = CreateController.createAluno(userstrip, passwordstrip, nometrim, sexo, cpf, telefone, emailstrip, data, altura, peso, bf, comorbidade,imagemBlob);
						if (alunoCadastrado == null) {
							JOptionPane.showMessageDialog(null, "Usuário já existe no banco");
						}else{
							JOptionPane.showMessageDialog(null, "Aluno(a) cadastrado com sucesso!");
							dispose();
						}
					}

				} catch (NumberFormatException e5) {
					JOptionPane.showMessageDialog(null, "Preencha os Campos ALTURA, PESO E BF corretamente.");
					
				} catch (RuntimeException e2) {
					e2.getMessage();
					JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
			
				} catch (SQLException e3) {
					e3.getMessage();
					
				} catch (ClassNotFoundException e1) {
					e1.getMessage();
				} catch (Exception e1) {
					e1.getMessage();
				}
			}
		});
		btnfinalizar.setFocusPainted(false);
		btnfinalizar.setFont(new Font("Arial", Font.BOLD, 16));
		btnfinalizar.setBackground(Color.WHITE);
		btnfinalizar.setBounds(599, 579, 218, 32);
		panel.add(btnfinalizar);
		
		JButton btngeraboleto = new JButton("Gerar Boleto");
		btngeraboleto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nome = txtnome.getText();
				String boleto = ("Boleto de Cobrança Mensalidade no valor de R% 50,00  para o Aluno:"+ nome);
				new PDF(boleto, nome);
				try {
					Desktop.getDesktop().open(new File("C:/Users/Matheus/Desktop/sistema-academia/SistemaAcademia/"+nome+".pdf"));
				} catch (IOException e1) {
					 //TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btngeraboleto.setFocusPainted(false);
		btngeraboleto.setFont(new Font("Arial", Font.BOLD, 16));
		btngeraboleto.setBackground(Color.WHITE);
		btngeraboleto.setBounds(324, 579, 218, 32);
		panel.add(btngeraboleto);
		
		JCheckBox pago = new JCheckBox("Pagamento Já Efetuado");
		pago.setFocusPainted(false);
		pago.setFont(new Font("Arial", Font.BOLD, 13));
		pago.setBounds(456, 528, 218, 32);
		panel.add(pago);
		
		JLabel lblsexo = new JLabel("SEXO:");
		lblsexo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblsexo.setForeground(Color.WHITE);
		lblsexo.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblsexo.setBounds(251, 278, 72, 24);
		panel.add(lblsexo);
		
		JButton btnfoto = new JButton("Tirar Foto");
		btnfoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WebCam webcam = new WebCam();
				if(webcam.getWebcam() != null) {
					webcam.setModal(true);
					webcam.setVisible(true);
					try {
						imagemBlob = WebCam.imgemBlob();
						lblfoto.setIcon(new ImageIcon(WebCam.carregarFoto()));
					}catch (NullPointerException e1) {
						System.out.print("Exceção tratada");
					}
					
				}
			}
		});
		btnfoto.setBorder(null);
		btnfoto.setBounds(88, 261, 93, 20);
		panel.add(btnfoto);
		
		
		MaskFormatter mascaraNome = new MaskFormatter("********************************************************");
		mascaraNome.setValidCharacters("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopsrtuvwxyz ");
		txtnome = new JFormattedTextField(mascaraNome);
		txtnome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtnome.setBounds(333, 86, 542, 21);
		panel.add(txtnome);
		
 
		MaskFormatter mascaraTelefone = new MaskFormatter("(##)#####-####");
	    mascaraTelefone.setPlaceholderCharacter('_');
		txttelefone = new JFormattedTextField(mascaraTelefone);
		txttelefone.setText("");
		txttelefone.setBounds(333, 135, 209, 21);
		panel.add(txttelefone);
		
		
		MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
		mascaraCpf.setPlaceholderCharacter('_');
		txtcpf = new JFormattedTextField(mascaraCpf);
		txtcpf.setBounds(636, 135, 239, 21);
		panel.add(txtcpf);
		
		MaskFormatter mascaraData = new MaskFormatter("##/##/####");
		mascaraData.setPlaceholderCharacter('_');
		txtdata = new JFormattedTextField(mascaraData);
		txtdata.setText("");
		txtdata.setBounds(333, 186, 209, 21);
		panel.add(txtdata);
		
		MaskFormatter mascaraPeso = new MaskFormatter("**.*");
		mascaraPeso.setValidCharacters("012345679 ");
		mascaraPeso.setAllowsInvalid(false);
		mascaraPeso.setValueContainsLiteralCharacters(false);
		txtpeso = new JFormattedTextField(mascaraPeso);
		txtpeso.setBounds(637, 230, 37, 21);
		panel.add(txtpeso);
		
		MaskFormatter mascaraComorbidade = new MaskFormatter("***************************************");
		mascaraComorbidade.setValidCharacters("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopsrtuvwxyz ");
		txtcomorbidade = new JFormattedTextField(mascaraComorbidade);
		txtcomorbidade.setBounds(333, 230, 209, 21);
		panel.add(txtcomorbidade);
		
		MaskFormatter mascaraSexo = new MaskFormatter("?????????");
		txtsexo = new JFormattedTextField(mascaraSexo);
		txtsexo.setBounds(333, 281, 209, 21);
		panel.add(txtsexo);
		
		MaskFormatter mascaraAltura = new MaskFormatter("#.##");
		txtaltura = new JFormattedTextField(mascaraAltura);
		txtaltura.setBounds(748, 230, 45, 21);
		panel.add(txtaltura);
		
		MaskFormatter mascaraBf = new MaskFormatter("##");
		txtbf = new JFormattedTextField(mascaraBf);
		txtbf.setBounds(838, 230, 37, 21);
		panel.add(txtbf);
		
		MaskFormatter mascaraEmail = new MaskFormatter("*********************************************************");
		txtemail = new JFormattedTextField(mascaraEmail);
		txtemail.setBounds(636, 186, 236, 21);
		panel.add(txtemail);
		
		MaskFormatter mascaraUser = new MaskFormatter("******************");
		txtuser = new JFormattedTextField(mascaraUser);
		txtuser.setBounds(336, 402, 209, 21);
		panel.add(txtuser);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(638, 402, 218, 20);
		panel.add(txtpassword);
		}
}