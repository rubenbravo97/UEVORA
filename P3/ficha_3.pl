num(z).
num(s(_)):- num(z).

le(z, _).
le(s(A),s(B)):-le(A,B).

lt(z,s(_)).
lt(s(A),s(B)) :- lt(A,B).

soma(z,X,X).
soma(s(A),B,s(C)) :- soma(A,B,C).


sub(A,B,C) :- soma(C,B,A).

mult(z,_,z).
mult(s(A),B,X):- mult(A,B,Y),soma(Y,B,X).

div(A,B,C) :- mult(C,B,A).

num(z,0). 
num(s(X),N) :- num(X,N1), N is N1 +1.