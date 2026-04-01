# Hands-On Practice 2: Object-Oriented Programming

## Exercise 1: Managing Student Collections
In this section, I developed a small program to manage a collection of `Student` objects, demonstrating the differences and uses of `List` and `Set` interfaces. The project includes:

* **The `Student` Class**: Contains basic properties (`id`, `firstName`, `lastName`). I customized the `equals()` and `hashCode()` methods to identify students strictly by their `id`. This ensures that sets and lists consider two student instances as identical if their ID matches. I also implemented `Comparable` to define a default sorting rule.
* **Main Application**: Starts by inserting students into an `ArrayList`, which happily accepts duplicates. To automatically filter out these identical entries, the list is converted into a `HashSet`, leveraging the custom `hashCode()` and `equals()`. Afterwards, `Collections.sort()` is utilized to sort the unique list twice: first by the default natural sorting (numerical ID order) and second by using a dynamically defined `Comparator` to sort alphabetically by name.

## Exercise 2: Word Frequency Analyzer
This exercise involves building a text analyzer to count how frequently each word appears in a string, using the `Map` data structure. The workflow is as follows:

1. **Sanitization**: Reads the input string, removes leading/trailing spaces via `trim()`, and converts it entirely to lowercase so the counting is case-insensitive.
2. **Tokenization**: The sentence is split into individual words using the regular expression `\\s+`, which correctly handles any extra consecutive white spaces.
3. **Tracking Occurrences**: As I iterate through the parsed words, they are fed into a `HashMap`. The `getOrDefault()` method gracefully handles the logic of initializing a word's count at 0 or incrementing its existing value.
4. **Discovering the Top Word**: Instead of iterating multiple times, the code parses the `entrySet()` once to identify the specific key-value pair that holds the maximum count.
5. **Alphabetical Sorting**: Finally, all unique words are extracted from the Map's keys into a new `ArrayList` where they are sorted alphabetically.

## Exercise 3: Road Network Graph Representation
Here, the objective was to simulate a road network connecting various Algerian cities. I leveraged the external graph library, **JGraphT**, to accomplish this. The structure is as follows:

* **Dependency Management**: A `pom.xml` file is included, using Maven to fetch the `jgrapht-core` dependency.
* **Basic Network Representation**: First, I explored a `SimpleGraph`. Using `addVertex()` and `addEdge()`, I established the cities and their connecting links. I demonstrated network traversal starting from "Alger" utilizing a `BreadthFirstIterator` (BFS). The behavior clearly showed that disconnected nodes (like "Oran" added without links) are isolated during the search.
* **Distance Processing**: To make things more realistic, I instantiated a `SimpleWeightedGraph`, enabling distances (in km) to be assigned to each link using `setEdgeWeight()`. Finally, I utilized `DijkstraShortestPath` to instantly compute the optimal shortest path and its total travel cost between specific cities.
