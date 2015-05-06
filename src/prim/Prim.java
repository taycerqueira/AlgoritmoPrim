package prim;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prim {
	
	int matriz_adjacencia[][];
	int quant_vertices;
	public static final int INFINITO = Integer.MAX_VALUE;
	List<Integer> vert_visitados;
	private Scanner scan;
	
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
		scan = new Scanner(System.in);
		System.out.println("Insira o número do vértice por onde deseja iniciar: ");
        int verticeInicial = scan.nextInt();
        
        while(verticeInicial > quant_vertices || verticeInicial < 0){
        	
        	System.out.println("Vértice inválido! Insira um valor de 0 a " + (quant_vertices - 1));
        	System.out.println("Insira o número do vértice por onde deseja iniciar: ");
            verticeInicial = scan.nextInt();
            
        }
        
        v1 = verticeInicial;
		for(int i = 1; i < quant_vertices; i++){
			if(matriz_adjacencia[v1][i] > 0 && matriz_adjacencia[v1][i] < peso){
				peso = matriz_adjacencia[v1][i];
				v2 = i;
			}	
		}
		
		//imprimeMatrizAdjacencia();
		System.out.println("Aresta escolhida: [" + v1 + ", " + v2 + "] = " + peso);
		vert_visitados.add(v1); //Adiciono os vértices na lista de vértices visitados
		vert_visitados.add(v2);
		matriz_adjacencia[v1][v2] = -1; //marco como aresta escolhida
		matriz_adjacencia[v2][v1] = -1; //fazer isso pq a matriz é simétrica
		
		//Agora que a brincadeira foi iniciada e ja temos um inicio, 
		//Precisamos repetir o processo até que todos os vértices sejam visitados
		int v = -1;
		int custo_total = 0;
		//Enquando existir vértices não visitados...
		while(vert_visitados.size() < quant_vertices){
			//System.out.println("\n-> Iteração sobre os vértices visitados");
			//System.out.println("Quantidade de vértices visitados: " + vert_visitados.size());
			//imprimeMatrizAdjacencia();
			int p = INFINITO;
			//Pego os vértices visitados e verifico os adjacentes não visitados de cada um
			//Pego aquele vizinho que tem o menor peso e adiciono ele na lista de visitados
			/* Dentre os vértices visitados, escolho o vértice que não foi visitado com quem 
			 * ele forma a aresta de menor peso.
			 */
			for (int verticeVisitado : vert_visitados) {
				v = getVerticeAdjacenteMenorPeso(verticeVisitado);
				if(v > -1){ //Se o vértice existir...
					peso = matriz_adjacencia[verticeVisitado][v];
					//System.out.println("Menor adjacente de " + verticeVisitado + ": v = " + v + " | peso: " + peso);
					if(peso < p && peso > 0 && !vert_visitados.contains(v)){
						v1 = verticeVisitado;
						v2 = v;
						p = peso;
						//System.out.println("Candidato: [" + v1 + ", " + v2 + "] = " + p);
					}
				}
			}
			matriz_adjacencia[v1][v2] = -1; //marco como aresta escolhida
			matriz_adjacencia[v2][v1] = -1; //fazer isso pq a matriz é simétrica
			vert_visitados.add(v2); //Adiciono os vértices na lista de vértices visitados
			custo_total += p; //Incremento o valor do custo
			System.out.println("\nAresta escolhida: [" + v1 + ", " + v2 + "] = " + p);
			
			//imprimeVerticesVisitados();

		}
		
		//System.out.println("\n\nTodos os vértices foram visitados");
		System.out.println("\n=> Custo Total: " + custo_total);
	}
	
	//Busca e retorna o vertice adjacente ao vertice dado com aresta de menor custo e que não tenha sido visitado ainda
	private int getVerticeAdjacenteMenorPeso(int vertice){
		 int v = -1;
		 int peso = INFINITO;
		 
		 for(int i = 0; i < quant_vertices; i++){
			if(matriz_adjacencia[vertice][i] > 0 && matriz_adjacencia[vertice][i] < peso){
				if(!vert_visitados.contains(i)){
					peso = matriz_adjacencia[vertice][i];
					v = i;
					
				}

			}
		 }

		 return v;
	}
	
	//Método utilizado para imprimir a matriz de adjacência atualizada (se quiser)
	private void imprimeMatrizAdjacencia(){
		System.out.println("\nMatriz de adjacência: ");
		for(int m = 0; m < matriz_adjacencia.length; m++){
			for(int n = 0; n < matriz_adjacencia.length; n++){
				System.out.print(matriz_adjacencia[m][n] + " ");
				
			}
			System.out.print("\n");	
		}
		System.out.print("\n");
	}
	
	//Método utilizado para imprimir os vértices visitados (se quiser)
	private void imprimeVerticesVisitados(){
		System.out.println("\nVértices Visitados");
		for(int i = 0; i < vert_visitados.size(); i++){
			System.out.print("| " + vert_visitados.get(i) + " | ");
		}
	}

}
