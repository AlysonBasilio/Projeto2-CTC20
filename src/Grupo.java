
public class Grupo {
	int Set[];
	int custo;
	int verticeEntrada;
	Grupo grupoFilho;
	int menorDistancia;
	
	Grupo(int v, int SetE[], Grupo TabelaMemoria[], int grafo[][]){
		for(int i=0; i<SetE.length; i++)
			Set[i]=SetE[i];
	}
}
