function [ custo, circuito ] = ForcaBruta( g )

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
end
