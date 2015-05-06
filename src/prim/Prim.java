package prim;

import java.util.ArrayList;
import java.util.List;

public class Prim {
	
	int matriz_adjacencia[][];
	int quant_vertices;
	public static final int INFINITO = Integer.MAX_VALUE;
	List<Integer> vert_visitados;
	
	public Prim(int quant, int matriz[][]){
		this.quant_vertices = quant;
		this.matriz_adjacencia = matriz;
		vert_visitados = new ArrayList<Integer>();

	}
	
	public void init(){
		System.out.println("\n ====== Algoritmo de Prim ====== \n");
		
		int peso = INFINITO;
		int v1 = 0;
		int v2 = 0;
		
		//Pego o primeiro vértice e vejo qual o outro vértice com quem ele forma uma aresta de menor peso
		for(int i = 1; i < quant_vertices; i++){
			if(matriz_adjacencia[v1][i] > 0 && matriz_adjacencia[v1][i] < peso){
				peso = matriz_adjacencia[v1][i];
				v2 = i;
			}	
		}
		
		System.out.print("[" + v1 + ", " + v2 + "] = " + peso);
		vert_visitados.add(v1);
		vert_visitados.add(v2);
		matriz_adjacencia[v1][v2] = -1; //marco como aresta escolhida
		matriz_adjacencia[v2][v1] = -1; //fazer isso pq a matriz é simétrica
		
		//Agora que a brincadeira foi iniciada e ja temos um inicio, 
		//Precisamos repetir o processo até que todos os vértices sejam visitados
		while(vert_visitados.size() < quant_vertices){
			//Pego os vértices visitados e verifica os adjacentes não visitados de cada um
			//Pego aquele vizinho que tem o menor peso e adiciono ele na lista de visitados
			for (int verticeVisitado : vert_visitados) {
				int v = getVerticeAdjacenteMenorPeso(verticeVisitado);
			}
			
		}

	}
	
	//Busca e retorna o vertice adjacente ao vertice dado com aresta de menor custo e que não tenha sido visitado ainda
	private int getVerticeAdjacenteMenorPeso(int vertice){
		 int v = -1;
		 int peso = INFINITO;
		 
		 for(int i = 0; i < quant_vertices; i++){
			if(matriz_adjacencia[vertice][i] > 0 && matriz_adjacencia[vertice][i] < peso){
				peso = matriz_adjacencia[vertice][i];
				v = i;
			}
		 }

		 return v;
	}

}
