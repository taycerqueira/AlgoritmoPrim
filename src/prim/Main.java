package prim;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		try {
			BufferedReader dados = new BufferedReader(new FileReader("matriz.txt"));
			
			System.out.println("Lendo arquivo da matriz de adjacência... ");
			int quant;
			int matriz[][] = null;
			
			String linha = dados.readLine();
			quant = Integer.parseInt(linha);
			System.out.println("Matriz de tamanho " + quant + "x" + quant);
			matriz = new int[quant][quant];
			
			int i = 0;
			while (dados.ready()) { 

				linha = dados.readLine();
				
				if (linha.matches("\\s*")){
					continue; 
				}

			   StringTokenizer token = new StringTokenizer(linha, " ");
			   int j = 0;
			   while (token.hasMoreTokens()) {
					
					String peso = new String(token.nextToken());
					//System.out.println("Peso: " + Integer.parseInt(peso) + " i=" + i + " | j=" + j);
					matriz[i][j] = Integer.parseInt(peso);
					
					j++;
					
				}
				
				i++;

			}
			
			System.out.println("Matriz de adjacência: ");
			for(int m = 0; m < matriz.length; m++){
				for(int n = 0; n < matriz.length; n++){
					System.out.print(matriz[m][n] + " ");
					
				}
				System.out.print("\n");
				
			}
			
			Prim algoritmoPrim = new Prim(quant, matriz);
			algoritmoPrim.init();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
