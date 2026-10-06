import java.util.Scanner;

public class MonitoramentoIceCube {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Declaração do vetor para 10 sensores
        double[] energias = new double[10];
        double somaEnergia = 0.0;
        int sensoresAltaEnergia = 0;

        System.out.println("=== SISTEMA DE MONITORAMENTO DE NEUTRINOS - ICECUBE ===");
        System.out.println("Informe os níveis de energia registrados (em TeV):\n");

        // 2. Leitura dos dados e preenchimento do vetor
        for (int i = 0; i < energias.length; i++) {
            System.out.print("Sensor [" + i + "]: ");
            energias[i] = scanner.nextDouble();
            somaEnergia += energias[i]; // Acumula para o cálculo da média
        }

        // Inicialização das variáveis para encontrar o maior valor
        double maiorEnergia = energias[0];
        int indiceMaior = 0;

        // 3. Processamento do vetor
        for (int i = 0; i < energias.length; i++) {
            // Verifica o maior valor registrado
            if (energias[i] > maiorEnergia) {
                maiorEnergia = energias[i];
                indiceMaior = i;
            }

            // Conta detecções acima de 100 TeV
            if (energias[i] > 100.0) {
                sensoresAltaEnergia++;
            }
        }

        // Cálculo da média
        double mediaEnergia = somaEnergia / energias.length;

        // 4. Exibição dos resultados
        System.out.println("\n=== RELATÓRIO DE DETECÇÃO DE PARTÍCULAS FANTASMA ===");
        System.out.printf("Média de energia captorada: %.2f TeV\n", mediaEnergia);
        System.out.printf("Maior pico de energia: %.2f TeV (registrado no Sensor [%d])\n", maiorEnergia, indiceMaior);
        System.out.println("Total de sensores com evento > 100 TeV: " + sensoresAltaEnergia);

        scanner.close();
    }
}