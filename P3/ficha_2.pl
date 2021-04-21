minimo(X,Y,X) :- X =< Y.
minimo(X,Y,Y) :- Y =< X.

member(X,[X|_]).
member(X,[_|T]) :- member(X,T).

membercheck(X, [X|_]).
membercheck(X,[H|T]) :- H \= X ,membercheck(X,T).


nonmember(X,Y) :- \+membercheck(X,Y).


fact(N,F) :- fact(N,1,F).
fact(0,F,F).
fact(N,T,F) :-
	N > 0, 
	T1 is T*N,
	N1 is N-1,
	fact(N1,T1,F).


sumlist([],0) .
sumlist([H|T],X) :- sumlist(T,Y), X is H + Y.

lenlist([],0).
lenlist([_|T],X) :- lenlist(T, Y), X is Y+1.



