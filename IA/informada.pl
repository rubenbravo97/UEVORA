%Descricao do problema:

%estado_inicial(Estado)
estado_inicial([1, 1]).

%estado_final(Estado)
estado_final([4, 4]).


%representacao dos operadores
%op(Eact,OP,Eseg,Custo)

op([X,Y], direita, [Z,Y], 1):- X < 4 , Z is X + 1 , bloqueado(X,Y,direita).

op([X,Y], baixo, [X,W], 1):- Y < 4 , W is Y + 1 , bloqueado1(X,Y,baixo).

op([X,Y], esquerda, [Z,Y], 1):- X > 1 , Z is X - 1 , bloqueado(X,Y, esquerda).

op([X,Y], cima, [X,W], 1):- Y > 1 , W is Y - 1 , bloqueado(X,Y,cima).


bloqueado(X,Y,direita):-
(X =\= 3 ; Y =\=1).

bloqueado(X,Y,esquerda):-
(X =\= 4 ; Y =\=1).

bloqueado1(X,Y,baixo):-
(X =\= 4 ; Y =\=2),
(X =\= 1 ; Y =\=1),
(X =\= 2 ; Y =\=1),
(X =\= 3 ; Y =\=2).

bloqueado1(X,Y,cima):-
(X =\= 1 ; Y =\=2),
(X =\= 2 ; Y =\=2),
(X =\= 3 ; Y =\=3),
(X =\= 4 ; Y =\=3).



pesquisa_aux(_, [no(E,Pai,Op,C,P)|_],no(E,Pai,Op,C,P)) :- 
	estado_final(E).
pesquisa_aux(N, [no(E,Pai,Op,C,P)|R],Sol):- 
	P < N,
	expande(no(E,Pai,Op,C,P),Lseg),
        insere_inicio(Lseg,R,LFinal),
        pesquisa_aux(N, LFinal,Sol).
pesquisa_aux(N, [no(_,_,_,_,P)|R],Sol):- 
	P == N,
        pesquisa_aux(N, R, Sol).


expande(no(E,Pai,Op,C,P),L):- 
	findall(no(En,no(E,Pai,Op,C,P), Opn, Cnn, P1),
                (op(E,Opn,En,Cn), P1 is P+1, Cnn is Cn+C),
                L).

p_iterativa(N, S0, S) :-
	pesquisa_aux(N, S0, S).

p_iterativa(N, S0, S) :-
	N1 is N + 1,
	p_iterativa(N1, S0, S).

pesquisa :-
	estado_inicial(S0),
	p_iterativa(1, [no(S0,[],[],0,0)], S),
	write(S), nl.


insere_inicio(A,B,C) :- append(A, B, C).
insere_fim(A,B,C) :- append(B, A, C).
