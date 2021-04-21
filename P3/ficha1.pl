homem(joao).
homem(rui).
homem(manuel).
homem(ricardo).
mulher(maria).
mulher(ana).
mulher(rita).
mulher(silvia).

progenitor(joao, maria).
progenitor(joao, rui).
progenitor(manuel, joao).
progenitor(ricardo, manuel).
progenitor(ana, rui).
progenitor(rita, joao).
progenitor(rita, silvia).



pai(X, Y) :- homem(X), progenitor(X, Y).

avos(A,B):- progenitor(A,X), 
	progenitor(X,B).

irmao(A,B) :- progenitor(X,A), progenitor(X,B), A \= B. 

tio(A,B) :- irmao(A,X), progenitor(X,B).