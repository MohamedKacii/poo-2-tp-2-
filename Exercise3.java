package com.exercice;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.traverse.BreadthFirstIterator;

public class Exercise3 {

    public static void main(String[] args) {

        Graph<String, DefaultEdge> cityGraph = new SimpleGraph<>(DefaultEdge.class);

        cityGraph.addVertex("Alger");
        cityGraph.addVertex("Blida");
        cityGraph.addVertex("Tipaza");
        cityGraph.addVertex("Boumerdes");
        cityGraph.addVertex("Medea");

        cityGraph.addEdge("Alger", "Blida");
        cityGraph.addEdge("Alger", "Tipaza");
        cityGraph.addEdge("Alger", "Boumerdes");
        cityGraph.addEdge("Blida", "Medea");

        System.out.println("Graph vertices: " + cityGraph.vertexSet());
        System.out.println("Graph edges: " + cityGraph.edgeSet());

        System.out.println("BFS traversal from Alger:");
        BreadthFirstIterator<String, DefaultEdge> searchOne = new BreadthFirstIterator<>(cityGraph, "Alger");
        while (searchOne.hasNext()) {
            System.out.print(searchOne.next() + " ");
        }
        System.out.println();

        cityGraph.addVertex("Oran");

        System.out.println("BFS traversal after adding Oran (unconnected node):");
        BreadthFirstIterator<String, DefaultEdge> searchTwo = new BreadthFirstIterator<>(cityGraph, "Alger");
        while (searchTwo.hasNext()) {
            System.out.print(searchTwo.next() + " ");
        }
        System.out.println();

        cityGraph.addEdge("Tipaza", "Medea");
        System.out.println("BFS traversal after connecting Tipaza and Medea:");
        BreadthFirstIterator<String, DefaultEdge> searchThree = new BreadthFirstIterator<>(cityGraph, "Alger");
        while (searchThree.hasNext()) {
            System.out.print(searchThree.next() + " ");
        }
        System.out.println();

        Graph<String, DefaultWeightedEdge> weightedCityGraph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

        String[] mappedCities = { "Alger", "Blida", "Tipaza", "Boumerdes", "Medea" };
        for (String city : mappedCities) {
            weightedCityGraph.addVertex(city);
        }

        DefaultWeightedEdge edgeA = weightedCityGraph.addEdge("Alger", "Blida");
        weightedCityGraph.setEdgeWeight(edgeA, 50.0);

        DefaultWeightedEdge edgeB = weightedCityGraph.addEdge("Alger", "Tipaza");
        weightedCityGraph.setEdgeWeight(edgeB, 70.0);

        DefaultWeightedEdge edgeC = weightedCityGraph.addEdge("Alger", "Boumerdes");
        weightedCityGraph.setEdgeWeight(edgeC, 45.0);

        DefaultWeightedEdge edgeD = weightedCityGraph.addEdge("Blida", "Medea");
        weightedCityGraph.setEdgeWeight(edgeD, 90.0);

        DefaultWeightedEdge edgeE = weightedCityGraph.addEdge("Boumerdes", "Tipaza");
        weightedCityGraph.setEdgeWeight(edgeE, 80.0);

        DefaultWeightedEdge edgeF = weightedCityGraph.addEdge("Tipaza", "Medea");
        weightedCityGraph.setEdgeWeight(edgeF, 60.0);

        DijkstraShortestPath<String, DefaultWeightedEdge> pathSolver = new DijkstraShortestPath<>(weightedCityGraph);

        System.out.println("\nShortest path between Alger and Medea:");
        GraphPath<String, DefaultWeightedEdge> firstPath = pathSolver.getPath("Alger", "Medea");
        System.out.println("Path route: " + firstPath.getVertexList());
        System.out.println("Total distance: " + firstPath.getWeight());

        System.out.println("\nShortest path between Boumerdes and Blida:");
        GraphPath<String, DefaultWeightedEdge> secondPath = pathSolver.getPath("Boumerdes", "Blida");
        System.out.println("Path route: " + secondPath.getVertexList());
        System.out.println("Total distance: " + secondPath.getWeight());
    }
}
