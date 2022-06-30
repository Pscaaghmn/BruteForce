public class Map {
    private String vertices;
    private final int[][] distances;

    public Map(int[][] distances) {
        this.distances = distances;
        vertices = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(0, distances.length);
    }



    public int getTotalEdgeLength(String locations){
        int totalDistance = 0;
        for (int i = 0; i < locations.length() - 1; i++) {
            totalDistance = totalDistance + distances[vertices.indexOf(locations.charAt(i))][vertices.indexOf(locations.charAt(i+1))];
        }
        return totalDistance;
    }
}
