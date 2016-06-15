import java.util.Random;
import java.util.Scanner;


public class Grafo {
	int numVertices;
	int numArestas;
	int arestas[][];
	int p;//posicao do percurso
	int percursoForcaBruta[];
	int custo;
	int percursoTemp[];
	int custoTemp;
	boolean vertices[];
	Random r;
	Scanner input;
	
	
	Grafo(int v, int a){
		input = new Scanner(System.in);
		numVertices = v;
		numArestas = a;
		arestas = new int[v][v];
		percursoForcaBruta = new int[v+1];
		percursoTemp = new int[v+1];
		vertices = new boolean[v];
		custo=10000000;
		for(int l=0; l<v; l++){
			vertices[l] = false;
		}
		p=0;
		for(int k=0; k<v; k++){
			for(int l=0; l<v; l++){
				arestas[k][l]=-1;
			}
		}
		r = new Random();
		int m=0;
		int i,j;
		
		while(m<a){
			i=r.nextInt(v);
			j=r.nextInt(v);
			if(arestas[i][j]==-1 & i!=j){
				arestas[i][j]=r.nextInt(10)+1;
				arestas[j][i]=arestas[i][j];
				m++;
			}
		}
	}
	
	void forcaBruta(int y){
		//System.out.println("p = "+p);
		if(percursoTemp[0]==y && p==numVertices){
			//System.out.println("Entrou nessa porra, custo= "+custoTemp);
			if(custoTemp<custo){
				percursoTemp[p]=y;
				custo=custoTemp;
				for(int l=0; l<numVertices+1; l++){
					percursoForcaBruta[l]=percursoTemp[l];
				}
				//System.out.println("Percurso Força Bruta Temporário, Custo = "+custo);
				for(int l=0; l<numVertices+1; l++){
					//System.out.printf("%4d",percursoForcaBruta[l]);
				}
				//System.out.println("");
				//input.nextLine();
			}
			return;
		}
		else if(p<numVertices){
			vertices[y]=true;
			for(int v=0; v<numVertices; v++){
				if(arestas[y][v]!=-1 && !vertices[v]){
					percursoTemp[p]=y;
					p++;
					custoTemp+=arestas[y][v];
					forcaBruta(v);
					vertices[v]=false;
					p--;
					custoTemp-=arestas[y][v];
				}
				else if(p==numVertices-1 && percursoTemp[0]==v && arestas[y][v]!=-1){
					percursoTemp[p]=y;
					p++;
					custoTemp+=arestas[y][v];
					//System.out.println("Vértice atual: "+y+" Próximo: "+v);
					forcaBruta(v);
					p--;
					custoTemp-=arestas[y][v];
				}
			}
		}
	}
	
}
