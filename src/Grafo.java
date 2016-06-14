import java.util.Random;


public class Grafo {
	int numVertices;
	int numArestas;
	int arestas[][];
	boolean arestasb[][];
	Random r;
	
	
	Grafo(int v, int a){
		numVertices = v;
		numArestas = a;
		arestas = new int[v][v];
		arestasb = new boolean[v][v];
		for(int k=0; k<v; k++){
			for(int l=0; l<v; l++){
				arestasb[k][l]=false;
			}
		}
		r = new Random();
		int m=0;
		int i,j;
		
		while(m<a){
			i=r.nextInt(v);
			j=r.nextInt(v);
			if(!arestasb[i][j] & i!=j){
				arestas[i][j]=r.nextInt(10)+1;
				arestas[j][i]=arestas[i][j];
				m++;
				arestasb[i][j]=true;
				arestasb[j][i]=true;
			}
		}
		
		for(int k=0; k<v; k++){
			for(int l=k; l<v; l++){
				if(!arestasb[k][l]){
					arestas[k][l]=-1;
					arestas[l][k]=-1;
				}
			}
		}
	}
	
	boolean verificaHamilton(){
		int ordem = numVertices;
		if(ordem>=3){
			for(int k=0; k<numVertices; k++){
				int cont=0;
				for(int l=0; l<numVertices; l++){
					if(arestasb[k][l])
						cont++;
				}
				if(cont<ordem/2)
					return false;
			}
		}
		return true;
	}
}
