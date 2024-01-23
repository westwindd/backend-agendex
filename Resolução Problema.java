import java.util.*;

public class Vizinhanca {
    private String[] vertices;
    private int[][] adjacencyMatrix;
    private int size;
    private int capacity;

    public Vizinhanca() {
        this.capacity = 10;
        this.vertices = new String[capacity];
        this.adjacencyMatrix = new int[capacity][capacity];
        this.size = 0;
    }

    public void adicionar(String str1, String str2) {
        if (!contains(str1)) {
            if (size >= capacity) {
                expandCapacity();
            }
            vertices[size] = str1;
            size++;
        }
        if (!contains(str2)) {
            if (size >= capacity) {
                expandCapacity();
            }
            vertices[size] = str2;
            size++;
        }

        int index1 = getIndex(str1);
        int index2 = getIndex(str2);

        adjacencyMatrix[index1][index2] = 1;
        adjacencyMatrix[index2][index1] = 1;
    }

    public String listar() {
        Set<String> visited = new HashSet<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < size; i++) {
            if (!visited.contains(vertices[i])) {
                result.append(dfs(i, visited)).append("\n");
            }
        }

        return result.toString();
    }

    private String dfs(int vertex, Set<String> visited) {
        visited.add(vertices[vertex]);
        StringBuilder result = new StringBuilder(vertices[vertex] + " -> ");
        for (int i = 0; i < size; i++) {
            if (adjacencyMatrix[vertex][i] == 1 && !visited.contains(vertices[i])) {
                result.append(dfs(i, visited)).append(", ");
            }
        }
        if (result.charAt(result.length() - 2) == '-') {
            result.append("Isolado");
        } else {
            result.setLength(result.length() - 2);
        }
        return result.toString();
    }

    private boolean contains(String str) {
        for (int i = 0; i < size; i++) {
            if (vertices[i] != null && vertices[i].equals(str)) {
                return true;
            }
        }
        return false;
    }

    private int getIndex(String str) {
        for (int i = 0; i < size; i++) {
            if (vertices[i].equals(str)) {
                return i;
            }
        }
        return -1;
    }

    private void expandCapacity() {
        capacity *= 2;
        vertices = Arrays.copyOf(vertices, capacity);
        int[][] newAdjacencyMatrix = new int[capacity][capacity];
        for (int i = 0; i < size; i++) {
            newAdjacencyMatrix[i] = Arrays.copyOf(adjacencyMatrix[i], capacity);
        }
        adjacencyMatrix = newAdjacencyMatrix;
    }

    public static void main(String[] args) {
        Vizinhanca vizinhanca = new Vizinhanca();
        vizinhanca.adicionar("Casa", "Rua");
        vizinhanca.adicionar("Rua", "Jardim");
        vizinhanca.adicionar("Jardim", "Parque");
        vizinhanca.adicionar("Parque", "Praia");
        vizinhanca.adicionar("Praia", "Rua");
        vizinhanca.adicionar("Praia", "Guarapuava");
        vizinhanca.adicionar("Guarapuava", "Praia");
        vizinhanca.adicionar("Guarapuava", "Floresta");
        vizinhanca.adicionar("Floresta", "Lago");
        vizinhanca.adicionar("Lago", "Montanha");
        vizinhanca.adicionar("Deserto", "Oásis");
        vizinhanca.adicionar("Oásis", "Deserto");
        vizinhanca.adicionar("Oásis", "Montanha");
        System.out.println(vizinhanca.listar());
    }
}
