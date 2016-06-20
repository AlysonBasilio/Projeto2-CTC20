import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;


public class Grafo {
	int numVertices;
	int numArestas;
	int arestas[][];
	int p;
	int percursoForcaBruta[];
	int custo;
	int percursoTemp[];
	int custoTemp;
	int custoHeldKarp;
	boolean vertices[];
	Random r;
	Scanner input;
	String percursoHeldKarp;
	
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
		percursoHeldKarp = "";
		Map<String, Integer> mapa = new HashMap<String, Integer>();
		Map<String, Integer> temp = new HashMap<String, Integer>();
		
		for (int k=1; k<numVertices; k++){
			if(arestas[0][k]!=-1)
				mapa.put("0"+k, arestas[0][k]);
		}
		
		for (int w=2; w<numVertices+1; w++){
			Set<String> chaves = mapa.keySet();
			for (String chave : chaves)
			{
				if(chave.length() == w){
					//System.out.println("1)Chave="+chave+" Valor= "+ mapa.get(chave));
					for(int i=1; i<numVertices; i++){
						if(chave.indexOf(Character.forDigit(i, 10))==-1){
							String s = "";
							s+=chave.charAt(chave.length()-1);
							if(arestas[i][Integer.parseInt(s)] != -1){
								temp.put(chave+""+i, arestas[i][Integer.parseInt(s)] + mapa.get(chave));
							}
						}
					}
				}
			}
			chaves = temp.keySet();
			for (String chave : chaves)
			{
				//System.out.println("Chave="+chave+" Valor= "+ temp.get(chave));
				mapa.put(chave, temp.get(chave));
			}
			temp.clear();
		}
		Set<String> chaves = mapa.keySet();
		custoHeldKarp = 100000;
		for (String chave : chaves)
		{
			if(chave.length() == numVertices){
				//System.out.println("2)Chave="+chave+" Valor= "+ mapa.get(chave));
				char c = chave.charAt(chave.length()-1);
				//System.out.println("2)Caractere: "+c);
				int x = Character.digit(c, 10);
				//System.out.println("2)Ultima cidade="+x);
				if(arestas[x][0]!= -1){
					int custo = mapa.get(chave)+arestas[x][0];
					if(custo<custoHeldKarp){
						percursoHeldKarp = chave+"0";
						custoHeldKarp = custo;
					}
				}
			}
		}
	}
}
