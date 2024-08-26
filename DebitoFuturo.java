import java.util.Scanner;

public class DebitoFuturo {
    private String nomeBoleto;
    private String valorBoleto;
    private String dataVencimento;

    // Construtor padrão
    public DebitoFuturo() {}


    public String getNomeBoleto() {
        return nomeBoleto;
    }

    public void setNomeBoleto(String nomeBoleto) {
        this.nomeBoleto = nomeBoleto;
    }

    public String getValorBoleto() {
        return valorBoleto;
    }

    public void setValorBoleto(String valorBoleto) {
        this.valorBoleto = valorBoleto;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    @Override
    public String toString() {
        return "Nome do boleto: '" + nomeBoleto + '\'' +
                ", Valor do boleto: '" + valorBoleto + '\'' +
                ", Data de vencimento: '" + dataVencimento + '\'';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DebitoFuturo debitoFuturo = new DebitoFuturo();

        // Solicitar o nome do boleto
        System.out.print("Digite o nome do boleto: ");
        debitoFuturo.setNomeBoleto(scanner.nextLine());

        // Solicitar o valor do boleto
        System.out.print("Digite o valor do boleto: ");
        debitoFuturo.setValorBoleto(scanner.nextLine());

        // Solicitar a data de vencimento
        System.out.print("Digite a data de vencimento (dd/mm/yyyy): ");
        debitoFuturo.setDataVencimento(scanner.nextLine());

        // Exibir informações do boleto
        System.out.println("\nInformações do Boleto:");
        System.out.println(debitoFuturo);

        scanner.close();
    }
}
