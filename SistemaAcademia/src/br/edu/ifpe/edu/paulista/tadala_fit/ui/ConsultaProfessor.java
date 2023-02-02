package br.edu.ifpe.edu.paulista.tadala_fit.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import br.edu.ifpe.paulista.tadala_fit.core.Aluno;
import br.edu.ifpe.paulista.tadala_fit.core.Professor;
import br.edu.ifpe.paulista.tadala_fit.core.ReadController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaProfessor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField Pesquisar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConsultaProfessor dialog = new ConsultaProfessor();
			dialog.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					if (JOptionPane.showConfirmDialog(null, "deseja encerrar as consultas","confirmação", JOptionPane.YES_NO_OPTION) == 0) {
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					}else {
						dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
					}
				}
			});			
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConsultaProfessor() {
		setBounds(100, 100, 1024, 769);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 79, 157));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Integer pesquisa = Integer.parseInt(Pesquisar.getText());
					table.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
								"Matrícula", "Nome"
							}
						));
					DefaultTableModel modelo = (DefaultTableModel) table.getModel();
					Professor pesquisaProfessor = ReadController.getProfessorFiltered(pesquisa);
						modelo.addRow(new Object[]{
								pesquisaProfessor.getMatricula(),
								pesquisaProfessor.getNome(),
						});	
						
				} catch (NumberFormatException e5) {
					JOptionPane.showMessageDialog(null,"Insira uma matrícula válida pra realizar a pesquisa!");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RuntimeException e1) {
					JOptionPane.showMessageDialog(null,"preencha o campo!");
				}
							
			}
		});
		btnPesquisar.setBackground(new Color(255, 255, 255));
		btnPesquisar.setFont(new Font("Arial", Font.BOLD, 13));
		btnPesquisar.setBounds(528, 62, 142, 26);
		contentPanel.add(btnPesquisar);
		
		JButton btnConsultar = new JButton("Consultar Professores");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Matrícula", "Nome"
						}
					));
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				ArrayList<Professor> professor;
				try {
					professor = ReadController.getAllProfessor();
					for(Professor p: professor) {				
						modelo.addRow(new Object[]{
								p.getMatricula(),
								p.getNome(),
						});
					}	
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		btnConsultar.setBackground(new Color(255, 255, 255));
		btnConsultar.setFont(new Font("Arial", Font.BOLD, 13));
		btnConsultar.setBounds(752, 302, 186, 36);
		contentPanel.add(btnConsultar);
		
		JButton btnExcluir = new JButton("Excluir Cadastro");
		btnExcluir.setBackground(new Color(255, 255, 255));
		btnExcluir.setEnabled(false);
		btnExcluir.setFont(new Font("Arial", Font.BOLD, 13));
		btnExcluir.setBounds(752, 439, 186, 36);
		contentPanel.add(btnExcluir);
		
		JButton btnPerfil = new JButton("Ver Perfil");
		btnPerfil.setBackground(new Color(255, 255, 255));
		btnPerfil.setEnabled(false);
		btnPerfil.setFont(new Font("Arial", Font.BOLD, 13));
		btnPerfil.setBounds(752, 368, 186, 36);
		contentPanel.add(btnPerfil);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(504, 223, -294, -211);
		contentPanel.add(scrollPane);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(78, 99, 592, 592);
		contentPanel.add(scroll);
		
		table = new JTable();
		table.setFont(new Font("Arial", Font.BOLD, 13));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Matr\u00EDcula", "Nome"
			}
		));
		scroll.setViewportView(table);
		table.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				btnExcluir.setEnabled(true);
				btnPerfil.setEnabled(true);
			}
		});
		
		Pesquisar = new JTextField();
		Pesquisar.setBounds(78, 62, 440, 26);
		contentPanel.add(Pesquisar);
		Pesquisar.setColumns(10);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(ConsultaProfessor.class.getResource("/assets_loginFrame/logotipo200x200.png")));
		logo.setBounds(752, 82, 200, 139);
		contentPanel.add(logo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
		}
	}
}