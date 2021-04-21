%define membro de uma lista
member(X,[X|_]).
member(X,[_|T]) :- member(X,T).

%soma duas listas
concatenar([],A,A).
concatenar([X|B], A ,[X|C]) :- concatenar(B,A,C).

%cria uma lista para com os valores vazios entre H e T
val([],_).
val([H|T],Set):-member(H,Set),val(T,Set).

%combinaçoes possiveis 
comb(Set, L):- length(L,_), val(L,Set).

%apaga no codigo se o prefixo for igual
apagar([],L,L).
apagar([H|T],[H|T1],L) :- apagar(T,T1,L).

%funçao que le a palavra
palavra(_,_,[],[]):-!.
palavra(P,[(K,V)|T],M,T1):- apagar(V,M,L), palavra(P,P,L,T2), concatenar([K],T2,T1).
palavra(P,[(K,V)|T],M,T1) :- palavra(P,T,M,T1).

ambiguo(A,M,T1,T2) :- comb([0,1],M),findall(X,palavra(A,A,M,X),[T1,T2|_]).

