package modulos.arquivo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {

	public static void main(String[] args) throws IOException {

		Pessoa pessoa1 = new Pessoa();
		
		pessoa1.setNome("Everton");
		pessoa1.setEmail("everton@gmail.com");
		pessoa1.setIdade(25);
		
		Pessoa pessoa2 = new Pessoa();
		
		pessoa2.setNome("Jose");
		pessoa2.setEmail("jose@gmail.com");
		pessoa2.setIdade(39);
		
		Pessoa pessoa3 = new Pessoa();
		
		pessoa3.setNome("Joaquim");
		pessoa3.setEmail("joaquim@gmail.com");
		pessoa3.setIdade(27);
		
		/*Pode vim de um banco de dados, ou de qualquer fonte de dados.*/
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		
		File arquivo = new File("C:\\workspace-curso-java\\ModuloArquivo\\src\\arquivo.csv");
		
		if(!arquivo.exists()) {
			arquivo.createNewFile();
		}
		
		FileWriter escrever_no_arquivo = new FileWriter(arquivo);
		/*escrever_no_arquivo.write("Hello world");
		escrever_no_arquivo.write("\n");
		escrever_no_arquivo.write("Minha segunda linha \n");*/
		
		for (Pessoa p : pessoas) {
			escrever_no_arquivo.write(p.getNome() + ";" + p.getEmail() + ";" + p.getIdade() + "\n");
		}
		escrever_no_arquivo.flush();
		escrever_no_arquivo.close();
	}

}
