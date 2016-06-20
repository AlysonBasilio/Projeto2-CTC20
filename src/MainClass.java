public class MainClass {

	public static void main(String[] args) {
		//Printando um grafo aleatório
		long inicio = System.currentTimeMillis();
		long fim = System.currentTimeMillis();
		Runtime rt = Runtime.getRuntime();
		long memoriaInicial = rt.freeMemory();
		long memoriaFinal = rt.freeMemory();
		Grafo g = new Grafo(6, 10);
		System.out.println("Grafo Aleatório: ");
		for(int k=0; k<g.numVertices; k++){
			for(int l=0; l<g.numVertices; l++){
				System.out.printf("%4d",g.arestas[k][l]);
			}
			System.out.println("");
		}
		
		inicio = System.nanoTime();
		//System.out.println("Tempo de execução: " + inicio);
		memoriaInicial = rt.freeMemory();
		g.forcaBruta(0);
		memoriaFinal = rt.freeMemory();
		fim = System.nanoTime();
		
		System.out.println("\nAlgoritmo Força Bruta: ");
		System.out.println("Percurso = ");
		for(int l=0; l<g.numVertices+1; l++){
			System.out.printf("%4d",g.percursoForcaBruta[l]);
		}
		System.out.println("\nCusto = "+g.custo);
		System.out.println("Tempo de execução: " + (fim-inicio) +" ns");
		System.out.println("Memória Usada: " + (memoriaInicial - memoriaFinal));
		
		/*inicio = System.nanoTime();
		//System.out.println("Tempo de execução: " + inicio);
		memoriaInicial = rt.freeMemory();*/
		HeldKarp h = new HeldKarp(g.arestas);
		//g.HeldKarp();
		System.out.println("\nAlgoritmo Held-Karp: ");
		System.out.println("Percurso = ");
		for(int l=0; l<g.numVertices+1; l++){
			System.out.printf("%4d",h.percursofinal[l]);
		}
		System.out.println("\nCusto = "+h.custo);/*memoriaFinal = rt.freeMemory();
		fim = System.nanoTime();
		System.out.println("Tempo de execução: " + (fim-inicio)+" ns");
		System.out.println("Memória Usada: " + (memoriaInicial - memoriaFinal));*/
	}	
}
