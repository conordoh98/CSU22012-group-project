# Design Document - CSU22012 Project

_A document explaining the design decisions (a choice of data structures and algorithms used to implement each of the 3 main features), justifying them based on specific space/time trade-offs between alternatives you have considered_

<ins>Shortest paths</ins>

    I had Considered using a single source single path algorithm such as as greedy best first search
    or A*. However the values given and the "cost" of the edges did not allow me to use these algorithms
    as I could no use them to calculate an approprite heuristic.
    I also condidered using an all sources all paths algorithms such as floyd-warshall, however they performed significantly worse when only one source is needed both in terms of memory and time.
    This left me with Dijkstra or Bellman-Ford , so I decided to go with Dijkstra since I was most familiar with it from the previous assignment.


    For data structures I used the already available ArrayList class. It eliminated any need to create custom functions and classes that support iteration which is needed for the Dijkstra algorithm.
    I also used it to do alot of preprocessing on the algorithm to optimise the speed at the cost of space. I chose to sacrifice space as the scale of the project wouldn't cause any major memory issues.

<ins>Ternary Search Tree</ins>

<ins>Searching With a Given Arrival Time</ins>

I originally designed the algoithm with serial search. I then realised that binary search would be far quicker for an ordered list. I then redesigned the algorithm. After getting strange results, I realised that the list was never ordered! Back to the drawing board... 

The final version of the function uses serial search as this is the quickest way to search an unordered list without using parallelism. It has time complexity O(N). I considered ordering the list and then using binary search, but realised this would be have to be longer than serial search.
I have also implemented the checks required.

I use an arrayList of arrays to store the results as an arrayList is resizeable. This is useful as we don't know how many results there will be. We then use arrays inside it because we know every result has 8 fields.
