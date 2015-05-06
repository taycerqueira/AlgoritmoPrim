package prim;

import java.util.ArrayList;
import java.util.List;

public class Prim {
	
	int matriz_adjacencia[][];
	int quant_vertices;
	List<Integer> vert_nao_visitados;
	
	public Prim(int quant, int matriz[][]){
		this.matriz_adjacencia = matriz;
		vert_nao_visitados = new ArrayList<Integer>();
		for(int i = 0; i< quant; i++){
			vert_nao_visitados.add(i);
		}
	}
	
	public void init(){
		System.out.println("\n ====== Algoritmo de Prim ====== \n");
		
		int peso;
		int v1 = 0;
		int v2 = 0;
		//Pego o primeiro vértice e vejo qual o outro vértice com quem ele forma uma aresta de menor peso
		boolean stop = false;
		
		peso = matriz_adjacencia[v1][v2];
		for(int i = 1; i < quant_vertices; i++){
			peso = matriz_adjacencia[v1][i];
			System.out.print("[" + v1 + ", " + i + "] = " + peso);
			if(matriz_adjacencia[v1][i] > 0){
				peso = matriz_adjacencia[v1][i];
				v2 = i;
				System.out.print("entrei no if");
				break;
			}	
		}
		System.out.print("[" + v1 + ", " + v2 + "] = " + peso);
		vert_nao_visitados.remove(v1);
		vert_nao_visitados.remove(v2);
		
		//Agora que a brincadeira foi iniciada e ja temos um inicio, 
		//Precisamos repetir o processo até que todos os vértices sejam visitados
		/*while(vert_nao_visitados.size() > 0){
			int peso1 = -1;
			int peso2 = -1;
			
		}*/

	}
	
	//Busca e retorna o vertice adjacente ao vertice dado com aresta de menor custo e que não tenha sido visitado ainda
	private int getVerticeAdjacente(int vertice){
		 int v = -1;
		 
		 int aux = matriz_adjacencia[vertice][0];
		 for(int i = 1; i < quant_vertices; i++){
			 if(aux > matriz_adjacencia[vertice][i]){ 
				 aux = matriz_adjacencia[vertice][i];
				 v = i;
			 }
		 }

		 return v;
	}

}
