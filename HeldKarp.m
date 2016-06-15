function [custo, circuito ] = HeldKarp( g )
    %Gerar todos os subconjuntos de g:
    K(length(g))=0;
    for i = 1:length(g)
        K1=nchoosek(1:length(g),i);
        if(length(g)-i~=0)
            m(nchoosek(length(g),i),length(g)-i)=0;
            K1=horzcat(K1,m);
        end
        K=vertcat(K,K1);
        clear m;
        clear K1;
    end
    K
    custo =0;
    circuito =0;
end