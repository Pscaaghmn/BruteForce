import java.util.ArrayList;

public class HamiltonianCycle {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";

    private String vertices;
    private final char start;
    private ArrayList<String> cycles;

    public HamiltonianCycle(int n, int startIndex) {
        vertices = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(0,n);
        vertices = vertices.substring(0, startIndex) +
                vertices.substring(startIndex + 1);

        this.start = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(startIndex);
        cycles = new ArrayList<>();

        generateCycles(vertices, "");
    }

    private void generateCycles(String reduced, String permutation) {
        if (reduced.length()==0){
            String closedPermutation = start + permutation + start;

            if (!cycles.contains(closedPermutation) && !cycles.contains(new StringBuilder(closedPermutation).reverse().toString())){
                cycles.add(closedPermutation);
            }
            return;
        }

        for (int i = 0; i < reduced.length(); i++) {
            generateCycles(reduced.substring(0, i) +
                            reduced.substring(i + 1),
                    permutation + reduced.charAt(i));
        }
    }

    public void displayCycles(int[][] distances){
        Map map = new Map(distances);
        ArrayList<Integer> distancesList = new ArrayList<>();

        for (String cycle:
                cycles) {
            distancesList.add(map.getTotalEdgeLength(cycle));
        }

        sort(distancesList);

        System.out.println(ANSI_BLACK_BACKGROUND + "Number of Hamiltonian Cycles = " + cycles.size() + ANSI_RESET);
        for (String cycle:
             cycles) {
            System.out.println(ANSI_BLUE + cycle + ANSI_RESET + " = " + map.getTotalEdgeLength(cycle) + "km");
        }
    }

    private void sort(ArrayList<Integer> distanceList){
        int minimumI;
        for (int unsortedI = 0; unsortedI < distanceList.size() - 1; unsortedI++) {
            minimumI = unsortedI;

            for (int searchI = unsortedI + 1; searchI < distanceList.size(); searchI++) {
                if (distanceList.get(searchI) < distanceList.get(minimumI)){
                    minimumI = searchI;
                }
            }

            int tempDist = distanceList.get(unsortedI);
            String tempCycle = cycles.get(unsortedI);

            distanceList.set(unsortedI, distanceList.get(minimumI));
            cycles.set(unsortedI, cycles.get(minimumI));

            distanceList.set(minimumI, tempDist);
            cycles.set(minimumI, tempCycle);
        }

    }
}