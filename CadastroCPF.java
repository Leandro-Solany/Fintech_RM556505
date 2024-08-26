import java.util.Scanner;

public class CadastroCPF {
    private String nome;
    private String cpf;


    public CadastroCPF() {}


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (isValidCPF(cpf)) {
            this.cpf = cpf;
        } else {
            throw new IllegalArgumentException("CPF inválido");
        }
    }

    // CPF
    public static boolean isValidCPF(String cpf) {
        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verificar se o CPF tem 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verificar se todos os dígitos são iguais
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Calcular os dígitos
        int[] pesos = {10, 9, 8, 7, 6, 5, 4, 3, 2};
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * pesos[i];
        }
        int primeiroDigitoVerificador = 11 - (soma % 11);
        primeiroDigitoVerificador = (primeiroDigitoVerificador > 9) ? 0 : primeiroDigitoVerificador;

        soma = 0;
        int[] pesos2 = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
        for (int i = 0; i < 10; i++) {
            soma += (cpf.charAt(i) - '0') * pesos2[i];
        }
        int segundoDigitoVerificador = 11 - (soma % 11);
        segundoDigitoVerificador = (segundoDigitoVerificador > 9) ? 0 : segundoDigitoVerificador;

        // Verificar se os dígitos são iguais aos calculados
        return cpf.charAt(9) - '0' == primeiroDigitoVerificador && cpf.charAt(10) - '0' == segundoDigitoVerificador;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nCPF: " + cpf;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        CadastroCPF cadastro = new CadastroCPF();

        // Solicitar nome do usuário
        System.out.print("Digite o nome: ");
        cadastro.setNome(scanner.nextLine());

        // Solicitar CPF do usuário
        System.out.print("Digite o CPF (somente números): ");
        String cpfInput = scanner.nextLine();
        try {
            cadastro.setCpf(cpfInput);
            System.out.println("Cadastro realizado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Exibir informações do cadastro
        System.out.println("\nInformações do Cadastro:");
        System.out.println(cadastro);

        scanner.close();
    }
}
