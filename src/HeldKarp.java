import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class HeldKarp {
	int numVertices;
	int arestas[][];
	int custoHeldKarp;
	String percursoHeldKarp;
	
	HeldKarp(int a[][]){
		numVertices = a.length;
		arestas = a;
		heldkarp_function();
	}
	
	void heldkarp_function(){
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
