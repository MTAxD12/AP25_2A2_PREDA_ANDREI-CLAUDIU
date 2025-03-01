Homework

Q:
Create a n x n matrix, representing the adjacency matrix of random graph graph G, having the following properties (if it is possible):
It contains at least one clique of size k.
It contains at least one stable set of size k.

A:
Clique: Creem matricea si punem la primele k elemente conditia sa fie ciclu adica a[i][j] = a[i][j] = 1 Orice i si j < k
Stable set: Facem lucrul opus pentru ultimele k elemente astfel incat acestea sa fie 0
Pot aparea probleme daca 2*k > n pentru ca solutia de clique va fi suprapusa de stable set


Q:
Implement a method that builds a string representation of the matrix, at your own choice. Display on the screen the generated matrix. You might want to use the geometric shapes from the Unicode chart to create a "pretty" representation of the matrix.

A:
Folosim String builder pentru ca daca am folosi System.out.println() ar da automat un new line. Desigur putem folosi System.out.print(), dar e String builderu in curs.


Q:
Display the number of edges m.

A:
Numaram elementele cu valori de 1 din prima jumatate a matricii


Q:
Display the maximum and the minimum degree of a vertex, Δ(G) and δ(G) (use the greek letters).
Verify that the sum of the degrees equals the value 2 * m .

A:
IntSummaryStatistics ne permite sa luam min si max dintr-un array fara sa mai scriem noi functiile


Bonus

Q:
Write an algorithm that finds if a graph has a clique of size at least k. Test you algorithm for randomly generated instances of various sizes.

A:
Facem backtracking cu nr de elemente kBonus astfel incat sa obtinem orice combinatie de noduri. Dupa fiecare set complet il testam verificand daca acele noduri formeaza un graf complet.


Q:
Use the algoithm above to check if a graph has a stable set of size at least k.

A:
Acelasi lucru ca la nr de clica doar ca inversam graful astfel incat 1 devine 0 si 0 devine 1. 