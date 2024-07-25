import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        ReadFile file = new ReadFile();
        Scanner scanner = new Scanner(System.in);
        int opt = 0;

        do {
            System.out.println("Escolha 1 para HeapSort, 2 para Árvore Binária, e 3 para sair");
            opt = scanner.nextInt();

            if (opt == 1 || opt == 2) {
                // Use caminho absoluto para o arquivo
                String filename = "dados500_mil.txt";
                File fileObj = new File(filename);

                if (!fileObj.exists()) {
                    System.out.println("Arquivo não encontrado: " + filename);
                    continue;
                }

                int[] array = file.readArrayFromFile(filename);

                if (array != null) {
                    switch (opt) {
                        case 1:
                            System.out.println("Array antes da ordenação:");
                            heapSort.printArray(array);

                            long startTimeHeap = System.currentTimeMillis();
                            heapSort.sort(array);
                            long endTimeHeap = System.currentTimeMillis();

                            System.out.println("Array após a ordenação:");
                            heapSort.printArray(array);
                            System.out.println("Tempo de execução: " + (endTimeHeap - startTimeHeap) + " milissegundos");
                            System.out.println("Quantidade de comparações: " + heapSort.getComparisonCount());
                            System.out.println("Quantidade de movimentações: " + heapSort.getMovementCount());
                            break;
                        case 2:
                            BinaryTree binaryTree = new BinaryTree();
                            System.out.println("Inserindo elementos na árvore binária...");

                            long startTimeTreeInsert = System.currentTimeMillis();
                            for (int value : array) {
                                binaryTree.insert(value);
                            }
                            long endTimeTreeInsert = System.currentTimeMillis();

                            System.out.println("Tempo de execução da inserção: " + (endTimeTreeInsert - startTimeTreeInsert) + " milissegundos");

                            long startTimeTreeInorder = System.currentTimeMillis();
                            System.out.println("Impressão em-ordem da árvore binária:");
                            binaryTree.inorder();
                            long endTimeTreeInorder = System.currentTimeMillis();

                            System.out.println("Tempo de execução da impressão em-ordem: " + (endTimeTreeInorder - startTimeTreeInorder) + " milissegundos");
                            System.out.println("Quantidade de comparações: " + binaryTree.getComparisonCount());
                            System.out.println("Quantidade de movimentações: " + binaryTree.getMovementCount());
                            break;
                    }
                } else {
                    System.out.println("Falha ao ler os dados do arquivo.");
                }
            } else if (opt != 3) {
                System.out.println("Opção inválida");
            }
        } while (opt != 3);

        System.out.println("Saindo");
        scanner.close();
    }
}
