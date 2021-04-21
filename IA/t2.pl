%Descricao do problema:

%estado_inicial(Estado)
estado_inicial([1,1]).
count(1).
%estado_final(Estado)
estado_final([1, 4]).


%representacao dos operadores
%op(Eact,OP,Eseg,Custo)

op([X,Y], direita, [X,W], 1):- Y < 4 , W is Y + 1 , bloqueado1(X,Y,direita).

op([X,Y], baixo, [Z,Y], 1):- X < 4 , Z is X + 1 , bloqueado2(X,Y,baixo).

op([X,Y], esquerda, [X,W], 1):- Y > 1 , W is Y - 1 , bloqueado3(X,Y,esquerda).

op([X,Y], cima, [Z,Y], 1):- X > 1 , Z is X - 1 , bloqueado4(X,Y, cima).


bloqueado1(X,Y,direita):-
(X == 1 ; Y ==1),
(X == 3 ; Y ==2),
(X == 4 ; Y ==2),
(X == 2 ; Y ==1).

bloqueado3(X,Y,esquerda):-
(X == 1 ; Y ==2),
(X == 2 ; Y ==2),
(X == 3 ; Y ==3),
(X == 4 ; Y ==3).

bloqueado2(X,Y,baixo):-
(X == 3 ; Y ==1).

bloqueado4(X,Y,cima):-
(X == 4 ; Y ==1).




%representacao dos nos
%no(Estado,no_pai,Operador,Custo,CustoHeur,Profundidade)

heur([X,Y], (X - 1) + (4 - Y)).

pesquisa_local_hillclimbingSemCiclos(E,C, ) :- 
    estado_final(E),
    write(E), write(' Nquartosvisitados: '), write(C).

pesquisa_local_hill_climbingSemCiclos(E,C, L) :- 
    write(E), write(' '),
    expande(E,LSeg),
    sort(3, @=<, LSeg, LOrd),
    obtemno(LOrd, no(ES, Op, )),
    + member(ES, L),
    write(Op), nl,
    T is C +1,

    (pesquisa_local_hillclimbingSemCiclos(ES,T,[E|L]) ; write(undo(Op)), write(' '), fail).

expande(E, L):- 
    findall(no(En,Opn, Heur),
                (op(E,Opn,En,), heur(En, Heur)),
                L).

obtemno([H|], H).
obtemno([|T], H1) :-
    obtem_no(T, H1).

pesquisa :-
    estado_inicial(S0),
    count(C),
    pesquisa_local_hill_climbingSemCiclos(S0,C, []).
