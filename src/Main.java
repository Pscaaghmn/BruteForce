public class Main {

    public static void main(String[] args) {

        int[][] distances = new int[6][6];
        distances[0] = new int[]{   0, 191, 441, 1067, 1085, 615};
        distances[1] = new int[]{ 191,   0, 349,  975,  994, 623};
        distances[2] = new int[]{ 441, 349,   0,  618,  655, 361};
        distances[3] = new int[]{1067, 975, 618,    0,  206, 530};
        distances[4] = new int[]{1085, 994, 655,  206,    0, 529};
        distances[5] = new int[]{ 615, 623, 361,  530,  529,   0};


        HamiltonianCycle hamiltonianCycle = new HamiltonianCycle(distances.length, 0);
        hamiltonianCycle.displayCycles(distances);
    }
}
