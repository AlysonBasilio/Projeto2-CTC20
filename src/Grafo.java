import java.util.Random;
import java.util.Scanner;


public class Grafo {
	int numVertices;
	int numArestas;
	int arestas[][];
	int p;
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
		if(percursoTemp[0]==y && p==numVertices){
			if(custoTemp<custo){
				percursoTemp[p]=y;
				custo=custoTemp;
				for(int l=0; l<numVertices+1; l++){
					percursoForcaBruta[l]=percursoTemp[l];
				}
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
					forcaBruta(v);
					p--;
					custoTemp-=arestas[y][v];
				}
			}
		}
	}
	
	void HeldKarp(){
		Grupo g[] = new Grupo[numVertices];
		Grupo gtemp[] = new Grupo[numVertices];
		int n1=0;
		int tam=0;
		for(int k=1; k<numVertices; k++){
			if(arestas[0][k]!=-1){
				g[n1].verticeEntrada=k;
				g[n1].menorDistancia=arestas[0][k];
				g[n1++].grupoSaida=g[0];
			}
		}
		int n2=n1;
		tam=n2;
		n1=0;
		
		/*for(int k=0; k<tam; k++){
			gtemp[k].verticeEntrada=gtemp[k].verticeEntrada;
			gtemp[k].menorDistancia=g[k].menorDistancia;
			gtemp[k].grupoSaida=g[k].grupoSaida;
		}*/
		
		for(int j=1; j<numVertices; j++){	
			for(int k=n1; k<n2; k++){
				for(int l=j+1; l<numVertices; l++){	
					if(arestas[l][g[k].verticeEntrada]!=-1){
						g[tam].verticeEntrada=l;
						g[tam].grupoSaida=g[k];
						g[tam++].menorDistancia=arestas[j][g[k].verticeEntrada]+g[k].menorDistancia;
					}
				}
			}
			n1=n2;
			n2=tam;
		}
	}
}
