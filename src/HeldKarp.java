
public class HeldKarp {
	int numVertices;
	int arestas[][];
	int p;
	int percursofinal[];
	int custo;
	int percursoTemp[];
	int custoTemp;
	boolean vertices[];
	
	HeldKarp(int a[][]){
		numVertices = a.length;
		arestas = a;
		percursofinal = new int[numVertices+1];
		percursoTemp = new int[numVertices+1];
		vertices = new boolean[numVertices];
		custo=10000000;
		custoTemp=0;
		p=0;
		for(int l=0; l<numVertices; l++){
			vertices[l] = false;
		}
		heldkarp_function(0);
	}
	
	void heldkarp_function(int y){
		if(percursoTemp[0]==y && p==numVertices){
			if(custoTemp<custo){
				percursoTemp[p]=y;
				custo=custoTemp;
				for(int l=0; l<numVertices+1; l++){
					percursofinal[l]=percursoTemp[l];
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
					heldkarp_function(v);
					vertices[v]=false;
					p--;
					custoTemp-=arestas[y][v];
				}
				else if(p==numVertices-1 && percursoTemp[0]==v && arestas[y][v]!=-1){
					percursoTemp[p]=y;
					p++;
					custoTemp+=arestas[y][v];
					heldkarp_function(v);
					p--;
					custoTemp-=arestas[y][v];
				}
			}
		}
	}
}
