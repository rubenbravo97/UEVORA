lista([]).
lista([_|T]):- lista(T).

prefixo([],_).
prefixo([X|A],[X|B]):-prefixo(A,B).

sufixo(A,A).
sufixo(A,[_|B]) :- sufixo(A,B).


sublista(A,B):- prefixo(L,A),sufixo(B,L).

concatenar([],A,A).
concatenar([X|B], A ,[X|C]) :- concatenar(B,A,C).

inverte([],[]).
inverte([X|T],B) :- inverte(T,Y), concatenar(Y,[X],B).

invertert(L,R) :- invertert(L,[],R).
invertert( [],R,R).
invertert([A|B],X,R) :- invertert(B, [A|X], R).

lenlist([],0).
lenlist([_|T],X) :- lenlist(T, Y), X is Y+1.
