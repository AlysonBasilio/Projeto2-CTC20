function [custo, percurso] = HeldKarp( grafo )
   %Calculando número de sets
   numSets = 2^length(grafo);
   G(numSets).custo;
   G(numSets).vertPartida;
   G(numSets).set=[];
   G(numSets).indiceSetAnterior;
   G(numSets).m;
   
   G(1).custo = 0;
   G(1).vertPartida = 0;
   G(1).set = [];
   G(1).indiceSetAnterior = 0;
   
   for k = 2:length(g)
       G(k).custo = grafo(1,k);
       G(k).vertPartida = k;
       G(k).set = [k];
       G(k).indiceSetAnterior = 1;
   end
   
   k = length(g)+1;
   n1=2;
   n2=length(g);
   
   for i = 3:length(g)
       for j = n1:n2
           for l = 1:length(G(j).set)
               G(k).custo = min([]);
               G(k).vertPartida = k;
               G(k).set = [k];
               G(k).indiceSetAnterior = 1;
           end    
       end
       n1=n2+1;
       n2=k;
   end
   
end

