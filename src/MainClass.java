
public class MainClass {

	public static void main(String[] args) {
		//Printando um grafo aleatório
		Grafo g = new Grafo(6, 10);
		for(int k=0; k<g.numVertices; k++){
			for(int l=0; l<g.numVertices; l++){
				System.out.printf("%4d",g.arestas[k][l]);
			}
			System.out.println("");
		}
		g.forcaBruta(0);
		
		System.out.println("");
		for(int l=0; l<g.numVertices+1; l++){
			System.out.printf("%4d",g.percursoForcaBruta[l]);
		}
		System.out.println("\nCusto = "+g.custo);
	}
	
}
