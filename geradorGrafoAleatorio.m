function [ grafo ] = geradorGrafoAleatorio( vertices, arestas )

for i = 1:vertices
    for j = i:vertices
        grafo(i,j) = -1;
        grafo(j,i) = -1;
    end
end
m=0;
while m < arestas
    i = randi(vertices);
    j = randi(vertices);
    if(grafo(i,j) == -1 && i~=j)
        grafo(i,j) = randi(10);
        grafo(j,i) = grafo(i,j);
        m=m+1;
    end
end