package br.senai.sp.jandira.Cadastrar;

import java.awt.BorderLayout;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class FrameCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtnome;
	private JTextField txtemail;
	private JTextField txttelefone;
	private JTextField txtcidade;

	//ATRIBUTOS REFERENTES A CRIA플O/GRAVA플O DE CONTATOS
	
	Cadastro contato = null;
	DadosDaConta objDAdosContato = null;
	ArquivoCadastro objArquivo = null;
	String texto;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
				  
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameCadastro() {
		
		contato = new Cadastro();
		objArquivo = new ArquivoCadastro();
		objDAdosContato = new DadosDaConta();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 435);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CADASTRO DE CONTATOS");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(38, 11, 301, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNome.setBounds(38, 75, 85, 14);
		contentPane.add(lblNome);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setBounds(38, 111, 85, 14);
		contentPane.add(lblEmail);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTelefone.setBounds(38, 155, 85, 14);
		contentPane.add(lblTelefone);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCidade.setBounds(38, 195, 85, 14);
		contentPane.add(lblCidade);
		
		txtnome = new JTextField();
		txtnome.setBounds(117, 74, 248, 20);
		contentPane.add(txtnome);
		txtnome.setColumns(10);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(117, 110, 248, 20);
		contentPane.add(txtemail);
		
		txttelefone = new JTextField();
		txttelefone.setColumns(10);
		txttelefone.setBounds(117, 154, 134, 20);
		contentPane.add(txttelefone);
		
		txtcidade = new JTextField();
		txtcidade.setColumns(10);
		txtcidade.setBounds(117, 194, 134, 20);
		contentPane.add(txtcidade);
		
		JButton btnNewButton = new JButton("CADASTRAR");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(72, 61, 139));
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//A플O DO BOT홒 CADASTRAR
				//CAPTURA DOS DADOS PARA O OBJETO DE CONTATO
				
				contato.setNome(txtnome.getText());
				contato.setEmail(txtemail.getText());
				contato.setCidade(txtcidade.getText());
				contato.setTelefone(txttelefone.getText());
				
				//PREPARA플O DOS DADOS PARA A GRAVA플O  NO ARQUIVO TXT
				
				/*String texto = contato.getNome() + ";"+ contato.getEmail() + ";" + 
				contato.getTelefone() + ";" 
				+ contato.getCidade() + "\n";*/
				
				//GRAVA플O DOS DADOS NO ARQUIVO TX
			
				/*objArquivo.escrever(caminho, texto);*/
				
				String caminhho = "C:\\Users\\21276377\\eclipse-workspace\\AQV\\gravou.txt";
				
				/*teste leitura arquivo*/
				objDAdosContato = objArquivo.ler(caminhho);
						
						objDAdosContato.Cadastrarcontatos(contato);
				
				ArrayList<Cadastro> contatos = objDAdosContato.listarContatos();
				
				contatos.forEach(contato ->  {
					
					texto += contato.getNome() +";"+
					        contato.getEmail() +";"+
				            contato.getTelefone() +";"+
				            contato.getCidade() +"\n";
			
		});
				objArquivo.escrever(caminhho, texto);
				contatos = null;
			
				
			}
		});
		btnNewButton.setBounds(38, 263, 149, 39);
		contentPane.add(btnNewButton);
		
	}
}

