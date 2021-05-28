package modulos.arquivo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\workspace-curso-java\\ModuloArquivo\\src\\arquivo_excel.xls");
		
		
		if(!file.exists()) {
			file.createNewFile();
		}
		
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
		
		Pessoa pessoa4 = new Pessoa();
		
		pessoa4.setNome("Lorenzo");
		pessoa4.setEmail("lorenzo@gmail.com");
		pessoa4.setIdade(23);
		
		/*Pode vim de um banco de dados, ou de qualquer fonte de dados.*/
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		pessoas.add(pessoa4);
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(); /*Vai ser usado para escrever a planilha*/
		HSSFSheet linhasPessoa = hssfWorkbook.createSheet("Planilha de pessoas Jdev Treinamento"); /*Criar a planilha*/
		
		int numeroLinha = 0;
		for(Pessoa p : pessoas) {
			 Row linha = linhasPessoa.createRow(numeroLinha ++); /*Criando a linha na planilha*/
			 
			 int celula = 0;
			 
			 Cell celNome = linha.createCell(celula ++);/*Célula 1*/
			 celNome.setCellValue(p.getNome());
			 
			 Cell celEmail = linha.createCell(celula ++);/*Célula 2*/
			 celEmail.setCellValue(p.getEmail());
			 
			 Cell celIdade = linha.createCell(celula ++);/*Célula 3*/
			 celIdade.setCellValue(p.getIdade());
		} /*Termino de montar a planilha*/
		
		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkbook.write(saida);/*Escreve planilha em arquivo*/
		saida.flush();
		saida.close();
		
		System.out.println("Planilha foi criada");
		
	}
}
