import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        int N = 20;
        int M = 100;

        //SparseGraph
        SparseGraph g1 = new SparseGraph(N, false);

        for (int i = 0; i < M; i++) {

            int a = (int) (Math.random() * N);
            int b = (int) (Math.random() * N);
            g1.addEdge(a, b);
        }

        for (int v = 0; v < N; v++) {
            System.out.print(v + ":");
            Iterator it = g1.adj(v).iterator();
            while (it.hasNext()) {
                System.out.print(it.next() + " ");
            }

            System.out.println();
        }

        System.out.println();

        //DenseGraph
        DenseGraph g2 = new DenseGraph(N,false);

        for (int i = 0; i < M; i++) {

            int a = (int) (Math.random() * N);
            int b = (int) (Math.random() * N);
            g2.addEdge(a, b);
        }

        for (int v = 0; v < N; v++) {
            System.out.print(v + ":");
            Iterator it = g2.adj(v).iterator();
            while (it.hasNext()) {
                System.out.print(it.next() + " ");
            }

            System.out.println();
        }

    }
}
