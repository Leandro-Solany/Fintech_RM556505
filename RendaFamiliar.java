import java.util.Scanner;

public class RendaFamiliar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a renda média declarada: ");
        double rendaMediaDeclarada = scanner.nextDouble();

        // Quantidade de membros da familia)
        System.out.print("Digite a quantidade de membros da familia: ");
        double quantidadeMembros = scanner.nextDouble();

        // Calcula a média de renda familiar
        double mediaRendaFamiliar = rendaMediaDeclarada / quantidadeMembros;

        System.out.println("A média de renda familiar é: " + mediaRendaFamiliar);

        scanner.close();
    }
}