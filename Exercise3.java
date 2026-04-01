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

        cityGraph.addVertex("Algiers");
        cityGraph.addVertex("costantine");
        // personal fav
        cityGraph.addVertex("Jijel");
        cityGraph.addVertex("setif");
        cityGraph.addVertex("media");

        cityGraph.addVertex("costantine");
        cityGraph.addVertex("Jijel");
        cityGraph.addVertex("setif");
        cityGraph.addVertex("media");

        System.out.println("Graph vertices: " + cityGraph.vertexSet());
        System.out.println("Graph edges: " + cityGraph.edgeSet());

        System.out.println("BFS traversal from Algiers:");
        BreadthFirstIterator<String, DefaultEdge> searchOne = new BreadthFirstIterator<>(cityGraph, "Algiers");
        while (searchOne.hasNext()) {
            System.out.print(searchOne.next() + " ");
        }
        System.out.println();

        cityGraph.addVertex("Tamanrasset");

        System.out.println("BFS traversal after adding Tamanrasset (unconnected node):");
        BreadthFirstIterator<String, DefaultEdge> searchTwo = new BreadthFirstIterator<>(cityGraph, "Algiers");
        while (searchTwo.hasNext()) {
            System.out.print(searchTwo.next() + " ");
        }
        System.out.println();

        cityGraph.addEdge("Jijel", "media");
        System.out.println("BFS traversal after connecting Jijel and media:");
        BreadthFirstIterator<String, DefaultEdge> searchThree = new BreadthFirstIterator<>(cityGraph, "Algiers");
        while (searchThree.hasNext()) {
            System.out.print(searchThree.next() + " ");
        }
        System.out.println();

        Graph<String, DefaultWeightedEdge> weightedCityGraph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

        String[] mappedCities = { "Algiers", "costantine", "Jijel", "setif", "media" };
        for (String city : mappedCities) {
            weightedCityGraph.addVertex(city);
        }

        DefaultWeightedEdge edgeA = weightedCityGraph.addEdge("Algiers", "costantine");
        weightedCityGraph.setEdgeWeight(edgeA, 20.0);

        DefaultWeightedEdge edgeB = weightedCityGraph.addEdge("Algiers", "costantine");
        weightedCityGraph.setEdgeWeight(edgeB, 50.0);

        DefaultWeightedEdge edgeC = weightedCityGraph.addEdge("Algiers", "setif");
        weightedCityGraph.setEdgeWeight(edgeC, 45.0);

        DefaultWeightedEdge edgeD = weightedCityGraph.addEdge("costantine", "media");
        weightedCityGraph.setEdgeWeight(edgeD, 90.0);

        DefaultWeightedEdge edgeE = weightedCityGraph.addEdge("costantine", "Jijel");
        weightedCityGraph.setEdgeWeight(edgeE, 80.0);

        DefaultWeightedEdge edgeF = weightedCityGraph.addEdge("Jijel", "media");
        weightedCityGraph.setEdgeWeight(edgeF, 60.0);

        DijkstraShortestPath<String, DefaultWeightedEdge> pathSolver = new DijkstraShortestPath<>(weightedCityGraph);

        System.out.println("\nShortest path between Algiers and Jijel:");
        GraphPath<String, DefaultWeightedEdge> firstPath = pathSolver.getPath("Algiers", "Jijel");
        System.out.println("Path route: " + firstPath.getVertexList());
        System.out.println("Total distance: " + firstPath.getWeight());

        System.out.println("\nShortest path between costantine and Jiejl:");
        GraphPath<String, DefaultWeightedEdge> secondPath = pathSolver.getPath("costantine", "Jijel");
        System.out.println("Path route: " + secondPath.getVertexList());
        System.out.println("Total distance: " + secondPath.getWeight());
    }
}
