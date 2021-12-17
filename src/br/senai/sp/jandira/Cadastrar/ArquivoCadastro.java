package br.senai.sp.jandira.Cadastrar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ArquivoCadastro {
	
public DadosDaConta objDadosDaConta = new DadosDaConta();
		
	
	
	// ISSOO SERVE PARA TRATAR O ERRO PARA NÃO CRACHAR O SITE !!!!
	//para não dar varios erros eu coloco para dar uma mensagem com erro escrito
	//cria o arquivo quando esse não existir e grava dados no arquivo
	
	public boolean escrever(String caminho, String texto){
		// estrutura try ()catch() ela faz com que haja um tratamento para ver 
		//se esta certo ou errado para o usuario, como se fosse uma forma mais amigavel de falar que
		//deu erro
		
		try {
			
			//OBJETO QUE REPRESENTA O ARQUIVO CLASSE QUE REPRESENTA O ARQUIVO
			FileWriter arquivo = new FileWriter(caminho);
			//OBJETO QUE REPRESENTA O OBJETO DE MANIPULAÇÃO
			
			PrintWriter escreverArq = new PrintWriter(arquivo);
			
			escreverArq.append(texto);
			escreverArq.close();
			return true;
		
			
		}catch(IOException e){
			
			System.out.println("Erro " + e.getMessage());
			return false;
		}
	
	}
	
	public DadosDaConta ler(String caminhopler) {
	
		
		try {
			// VAI REPRESENTAR UM ARQUIVO QUANDO EU FOR LER (EM MODO DE LEITURA)
			FileReader lerarquivo = new FileReader(caminhopler);
			//REPRESENTA O DADO DE LEITURA NA MÉMORIA DO PROGRAMA
			BufferedReader leituradamemoriadodoprograma =  new BufferedReader(lerarquivo);
			
			String linha  = "";
			
			linha = leituradamemoriadodoprograma.readLine();
	
			while(linha != null) {
				
			   String[] dadoslinha = linha.split(";");
				Cadastro objCadastro = new Cadastro();
			
				objCadastro.setNome(dadoslinha[0]);
				objCadastro.setEmail(dadoslinha[1]);
				objCadastro.setTelefone(dadoslinha[2]);
				objCadastro.setCidade(dadoslinha[3]);
				
				objDadosDaConta.Cadastrarcontatos(objCadastro);
				linha = leituradamemoriadodoprograma.readLine();
				
			}
			
			leituradamemoriadodoprograma.close();
			return objDadosDaConta ;
			
		}catch(IOException e){
			System.out.println("ERRO " + e.getMessage());
			return null;
		}
	
	}

}
