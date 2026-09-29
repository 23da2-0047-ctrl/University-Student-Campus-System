package university.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CampusGraph {

    // ============================================================
    // GRAPH DATA
    // ============================================================

    private Map<String, List<String>> adjacencyList;


    // ============================================================
    // CONSTRUCTOR
    // ============================================================

    public CampusGraph() {

        adjacencyList =
            new HashMap<>();
    }


    // ============================================================
    // ADD CAMPUS LOCATION
    // ============================================================

    public boolean addLocation(String location) {

        if (location == null ||
            location.trim().isEmpty()) {

            return false;
        }

        location = location.trim();

        if (adjacencyList.containsKey(location)) {

            return false;
        }

        adjacencyList.put(
            location,
            new ArrayList<>()
        );

        return true;
    }


    // ============================================================
    // REMOVE CAMPUS LOCATION
    // ============================================================

    public boolean removeLocation(String location) {

        if (location == null ||
            location.trim().isEmpty()) {

            return false;
        }

        location = location.trim();

        if (!adjacencyList.containsKey(location)) {

            return false;
        }

        // Remove the location
        adjacencyList.remove(location);

        // Remove all connections to this location
        for (List<String> connections :
                adjacencyList.values()) {

            connections.remove(location);
        }

        return true;
    }


    // ============================================================
    // ADD CAMPUS CONNECTION
    // ============================================================

    public boolean addConnection(
            String location1,
            String location2) {

        if (location1 == null ||
            location2 == null) {

            return false;
        }

        location1 = location1.trim();
        location2 = location2.trim();

        if (location1.isEmpty() ||
            location2.isEmpty()) {

            return false;
        }

        if (location1.equals(location2)) {

            return false;
        }

        if (!adjacencyList.containsKey(location1) ||
            !adjacencyList.containsKey(location2)) {

            return false;
        }

        if (adjacencyList
                .get(location1)
                .contains(location2)) {

            return false;
        }

        // Undirected graph
        adjacencyList
            .get(location1)
            .add(location2);

        adjacencyList
            .get(location2)
            .add(location1);

        return true;
    }


    // ============================================================
    // REMOVE CAMPUS CONNECTION
    // ============================================================

    public boolean removeConnection(
            String location1,
            String location2) {

        if (location1 == null ||
            location2 == null) {

            return false;
        }

        location1 = location1.trim();
        location2 = location2.trim();

        if (!adjacencyList.containsKey(location1) ||
            !adjacencyList.containsKey(location2)) {

            return false;
        }

        boolean removed =
            adjacencyList
                .get(location1)
                .remove(location2);

        adjacencyList
            .get(location2)
            .remove(location1);

        return removed;
    }


    // ============================================================
    // DISPLAY CAMPUS CONNECTIONS
    // ============================================================

    public void displayConnections() {

        if (adjacencyList.isEmpty()) {

            ConsoleUI.warning(
                "No campus locations available."
            );

            return;
        }

        System.out.println();

        for (String location :
                adjacencyList.keySet()) {

            System.out.print(
                location + " → "
            );

            List<String> connections =
                adjacencyList.get(location);

            if (connections.isEmpty()) {

                System.out.println(
                    "No connections"
                );

            } else {

                System.out.println(
                    String.join(
                        ", ",
                        connections
                    )
                );
            }
        }
    }


    // ============================================================
    // BFS TRAVERSAL
    // ============================================================

    public void bfs(String startLocation) {

        if (startLocation == null ||
            startLocation.trim().isEmpty()) {

            ConsoleUI.error(
                "Starting location cannot be empty."
            );

            return;
        }

        startLocation =
            startLocation.trim();

        if (!adjacencyList.containsKey(
                startLocation)) {

            ConsoleUI.error(
                "Campus location not found."
            );

            return;
        }

        Set<String> visited =
            new HashSet<>();

        Queue<String> queue =
            new LinkedList<>();

        visited.add(startLocation);
        queue.add(startLocation);

        System.out.println();

        System.out.println(
            "BFS Traversal:"
        );

        while (!queue.isEmpty()) {

            String current =
                queue.poll();

            System.out.print(
                current
            );

            List<String> connections =
                adjacencyList.get(current);

            for (String neighbour :
                    connections) {

                if (!visited.contains(
                        neighbour)) {

                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }

            if (!queue.isEmpty()) {
                System.out.print(" → ");
            }
        }

        System.out.println();
    }


    // ============================================================
    // CHECK WHETHER GRAPH IS EMPTY
    // ============================================================

    public boolean isEmpty() {

        return adjacencyList.isEmpty();
    }
}
