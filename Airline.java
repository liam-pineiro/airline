package airlineReservationTools;

import java.util.*;

public class Airline {

	private static final int NUMBER_OF_CITIES=8;
	private static final int NEW_YORK = 0;
	private static final int CHICAGO = 1;
	private static final int MIAMI = 2;
	private static final int SAN_FRANCISCO = 3;
	private static final int DALLAS = 4;
	private static final int DENVER = 5;
	private static final int SAN_DIEGO = 6;
	private static final int LOS_ANGELES = 7;
	
	public static void main(String[] args) {
		Graph graph = createGraph();
		addEdges(graph);
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a starting city and a destination to see if there is a route to it!");
		System.out.printf("Starting City: ");
		String startingCity = input.nextLine();
		System.out.println("Destination: ");
		String destination = input.nextLine();
		
		int startCity = stringToCity(startingCity);
		int destinationCity = stringToCity(destination);
		
		checkRoutes(startCity, destinationCity, graph, startingCity, destination);
	}

	public static Graph createGraph() {
		Graph graph = new Graph(NUMBER_OF_CITIES);
		graph.setLabel(NEW_YORK, "New York");
		graph.setLabel(CHICAGO, "Chicago");
		graph.setLabel(MIAMI, "Miami");
		graph.setLabel(SAN_FRANCISCO, "San Francisco");
		graph.setLabel(DALLAS, "Dallas");
		graph.setLabel(DENVER, "Denver");
		graph.setLabel(SAN_DIEGO, "San Diego");
		graph.setLabel(LOS_ANGELES, "Los Angeles");
		return graph;
	}
	
	public static void addEdges(Graph graph) {
		graph.addEdge(NEW_YORK, CHICAGO, 75);
		graph.addEdge(NEW_YORK, MIAMI, 90);
		graph.addEdge(NEW_YORK, DALLAS, 125);
		graph.addEdge(NEW_YORK, DENVER, 100);
		graph.addEdge(CHICAGO, SAN_FRANCISCO, 25);
		graph.addEdge(CHICAGO, DENVER, 20);
		graph.addEdge(MIAMI, DALLAS, 50);
		graph.addEdge(DALLAS, SAN_DIEGO, 90);
		graph.addEdge(DALLAS, LOS_ANGELES, 80);
		graph.addEdge(DENVER, LOS_ANGELES, 100);
		graph.addEdge(DENVER, SAN_FRANCISCO, 75);
		graph.addEdge(SAN_FRANCISCO, LOS_ANGELES, 45);
		graph.addEdge(SAN_DIEGO, LOS_ANGELES, 45);
	}
	
	public static int stringToCity(String city) {
		int cityNum;
		if(city.toLowerCase().equals("new york")) {
			cityNum = NEW_YORK;
		}
		else if(city.toLowerCase().equals("miami")) {
			cityNum = MIAMI;
		}
		else if(city.toLowerCase().equals("chicago")) {
			cityNum = CHICAGO;
		}
		else if(city.toLowerCase().equals("dallas")) {
			cityNum = DALLAS;
		}
		else if(city.toLowerCase().equals("denver")) {
			cityNum = DENVER;
		}
		else if(city.toLowerCase().equals("san francisco")) {
			cityNum = SAN_FRANCISCO;
		}
		else if(city.toLowerCase().equals("los angeles") || city.toLowerCase().equals("la")) {
			cityNum = LOS_ANGELES;
		}
		else if(city.toLowerCase().equals("san diego")) {
			cityNum = SAN_DIEGO;
		}
		else {
			cityNum = -1;
		}
		return cityNum;
	}
	
	public static String cityToString(int city) {
		String cityName;
		if(city == NEW_YORK) {
			cityName = "New York";
		}
		else if(city == MIAMI) {
			cityName = "Miami";
		}
		else if(city == CHICAGO) {
			cityName = "Chicago";
		}
		else if(city == DALLAS) {
			cityName = "Dallas";
		}
		else if(city == DENVER) {
			cityName = "Denver";
		}
		else if(city == SAN_FRANCISCO) {
			cityName = "San Francisco";
		}
		else if(city == LOS_ANGELES) {
			cityName = "Los Angeles";
		}
		else if(city == SAN_DIEGO) {
			cityName = "San Diego";
		}
		else {
			cityName = "";
		}
		return cityName;
	}
	
	public static void checkRoutes(int cityOne, int cityTwo, Graph graph, String firstCity, String secondCity) {
		int count = 0;
		
		if(graph.isEdge(cityOne, cityTwo)) {
			count++;
		}
		
		int[] neighbors = graph.neighbors(cityOne);
		
		for(int city : neighbors) {
			if(graph.isEdge(city, cityTwo)) {
				count++;
			}
		}
		
		if(count > 0) {
			System.out.println("There is a route from " + firstCity + " to " + secondCity);
		}
		else {
			System.out.println("There are no routes from " + firstCity + " to " + secondCity);
		}
	}
}
