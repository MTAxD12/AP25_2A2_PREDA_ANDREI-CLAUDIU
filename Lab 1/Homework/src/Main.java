import java.util.*;

public class Main {
    int n, k;
    int[][] adjMatrix;
    List<Integer> noduriClica = new ArrayList<>();
    List<Integer> noduriSet = new ArrayList<>();

    Main(int n, int k) {
        this.n = n;
        this.k = k;
        this.adjMatrix = new int[n][n];
        createAdjMatrix();
    }

    private void clica() {
        for(int i = 0; i < k; i++) {
            noduriClica.add(i);
        }
        for(int i = 0; i < k; i++) {
            for(int j = i + 1; j < k; j++) {
                adjMatrix[noduriClica.get(i)][noduriClica.get(j)] = 1;
                adjMatrix[noduriClica.get(j)][noduriClica.get(i)] = 1;
            }
        }
    }

    private void stableSet() {
        for(int i = n-k; i < n; i++) {
            noduriSet.add(i);
        }
        for(int i = 0; i < k; i++) {
            for(int j = i + 1; j < k; j++) {
                adjMatrix[noduriSet.get(i)][noduriSet.get(j)] = 0;
                adjMatrix[noduriSet.get(j)][noduriSet.get(i)] = 0;
            }
        }
    }

    private void randomFill() {
        Random rand = new Random();
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(!noduriSet.contains(i) && !noduriSet.contains(j) &&
                !noduriClica.contains(i) && !noduriClica.contains(j)) {
                    int aux = rand.nextInt(2);
                    adjMatrix[i][j] = aux;
                    adjMatrix[j][i] = aux;
                }
            }
        }
    }

    public void createAdjMatrix() {
        clica();
        stableSet();
        randomFill();
    }

    public void printGraph() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(adjMatrix[i][j] == 0) {
                    sb.append("□ ");
                }
                else {
                    sb.append("■ ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public void printGraphInfo() {
        int m = 0;
        int[] grade = new int[n];
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(adjMatrix[i][j] == 1) {
                    grade[i]++;
                    grade[j]++;
                    m++;
                }
            }
        }
        IntSummaryStatistics stats = Arrays.stream(grade).summaryStatistics();
        System.out.println("Numarul de muchii: " + m);
        System.out.println("Δ(G) = " + stats.getMin() + ", δ(G) = " + stats.getMax());
        System.out.println("suma gradelor = 2 * m ? | " + stats.getSum() + " = " + 2 * m);
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Main <n> <k>");
            return;
        }

        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        long start = System.currentTimeMillis();

        Main graph = new Main(n, k);

        if (n < 30000) {
            graph.printGraph();
        }
        graph.printGraphInfo();

        long end = System.currentTimeMillis();

        if(n >= 30000)
            System.out.println(end - start + "ms");
    }
}