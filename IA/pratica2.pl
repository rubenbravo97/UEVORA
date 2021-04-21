%Descricao do problema:

%estado_inicial(Estado)
estado_inicial([0,0]).

%estado_final(Estado)
estado_final([0,1]).

capacidade(1,3).
capacidade(2,2).

%representacao dos operadores
%op(Eact,OP,Eseg,Custo)

op([X,Y], encher(1), [C,Y], 1):- capacidade(1, C), X < C.
op([X,Y], encher(2), [X,C], 1):- capacidade(2, C), Y < C.

op([X,Y], despejar(1), [0,Y], 1):- X > 0.
op([X,Y], despejar(2), [X,0], 1):- Y > 0.

op([X,Y], despejar(1,2), [0,W], 1):- capacidade(2, C), C >= X + Y, W is X + Y.	
op([X,Y], despejar(1,2), [W,Z], 1):- capacidade(2, C), C < X + Y, Z is Y - (C + Y), W is C.

op([X,Y], despejar(2,1), [W,0], 1):- capacidade(1, C), C >= X + Y, W is X + Y.
op([X,Y], despejar(2,1), [Z,W], 1):- capacidade(1, C), C < X + Y, Z is X - (C - Y), W is C.



%representacao dos nos
%no(Estado,no_pai,Operador,Custo,Profundidade)

pesquisa_largura([no(E,Pai,Op,C,P)|_],no(E,Pai,Op,C,P)) :- 
	estado_final(E).
pesquisa_largura([E|R],Sol):- 
	expande(E,Lseg),
        insere_fim(Lseg,R,LFinal),
        pesquisa_largura(LFinal,Sol).

expande(no(E,Pai,Op,C,P),L):- 
	findall(no(En,no(E,Pai,Op,C,P), Opn, Cnn, P1),
                (op(E,Opn,En,Cn), P1 is P+1, Cnn is Cn+C),
                L).

pesquisa :-
	estado_inicial(S0),
	pesquisa_largura([no(S0,[],[],0,0)], S),
	write(S), nl.


insere_fim([],L,L).
insere_fim(L,[],L).
insere_fim(R,[A|S],[A|L]):- insere_fim(R,S,L).
