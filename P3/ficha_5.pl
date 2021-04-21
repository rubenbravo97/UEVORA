seq(A,B,L) :- seq(A,B,[B],L).

seq(X,X,L,L).
seq(A,B,L,R) :- A =< B, C is B-1, seq(A,C,[C|L],R).
seq(A,B,L,R) :- A >= B, C is B+1, seq(A,C,[C|L],R).


concatenar([],A,A).
concatenar([X|B], A ,[X|C]) :- concatenar(B,A,C).


double([],[]).
double(L1,L) :-concatenar(L1,L1,L2),sort(L2,L).

adj(E1,E2,L) :- concatenar(_,[E1,E2|_],L).
adj(E1,E2,L) :- concatenar(_,[E2,E1|_],L).


sel(X,[X|T],T).
sel(X,[Y|L1],[Y|L2]) :- sel(X,L1,L2).

somatorio([],0).
somatorio([H|T],S) :- somatorio(T,S1), S is S1 + H.

ord([]).
ord([_]).
ord([X,Y|T]) :- X =< Y, ord([Y|T]).
ord([X,Y|T]) :- X >= Y, ord([Y|T]).

perm([],[]).
perm(L1,[X|L2]):- sel(X,L1,L), perm(L,L2).

sort(L1,L2) :-perm(L1,L2), ord(L2).


