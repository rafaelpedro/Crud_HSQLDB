import entidades.Animal;
import jakarta.persistence.criteria.CriteriaBuilder;
import servicos.AnimalServico;
import servicos.HibernateUtil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Integer opcao = 0;
        do {
            System.out.println("Bem-vindo ao SisPet");
            System.out.println("1 - Cadastrar animal");
            System.out.println("2 - Listar animais cadastrados");
            System.out.println("3 - Editar animal");
            System.out.println("4 - Excluir animal");
            System.out.println("5 - Sair");
            System.out.println();
            System.out.println("Digite a opção desejada: ");
            opcao = Integer.parseInt(ler.nextLine());
            switch (opcao) {
                case 1 -> cadastro();
                case 2 -> listarTodos();
                case 3 -> editarAnimal();
                case 4 -> excluir();
            }
        } while (opcao != 5);
    }


    public static void cadastro() {
        var animal = new Animal();
        var ler = new Scanner(System.in);
        var animalServico = new AnimalServico();
        System.out.println("Digite o nome do animal: ");
        animal.setNome(ler.nextLine());

        System.out.println("Digite a especie do animal: ");
        animal.setEspecie(ler.nextLine());

        System.out.println("Digite a cor do animal: ");
        animal.setCor(ler.nextLine());

        System.out.println("Digite o temperamento do animal: ");
        animal.setTemperamento(ler.nextLine());

        System.out.println("Digite o nome do responsavel pelo animal: ");
        animal.setNomeResponsavel(ler.nextLine());

        System.out.println("Digite o cpf do responsavel pelo animal: ");
        animal.setCpfResponsavel(ler.nextLine());

        System.out.println("Digite a data de nasciemento do animal: ");
        String dataDeNascimentoDigitada = ler.nextLine();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate dataNascimentoFormatada = LocalDate.parse(dataDeNascimentoDigitada, formato);
        animal.setDataNascimento(dataNascimentoFormatada);

        animalServico.inserir(animal);
    }


    public static void listarTodos(){
        var animalServico = new AnimalServico();
        var listaDeAnimais= animalServico.listarTodos();

        for(Animal animal : listaDeAnimais){
            System.out.print(animal.getId() + " |\t");
            System.out.print(animal.getNome() + " |\t");
            System.out.print(animal.getEspecie() + " |\t");
            System.out.print(animal.getDataNascimento() + " |\t");
            System.out.print(animal.getCor() + " |\t");
            System.out.print(animal.getTemperamento() + " |\t");
            System.out.print(animal.getNomeResponsavel() + " |\t");
            System.out.println(animal.getCpfResponsavel());
        }
    }

    public static void editarAnimal(){
        var ler = new Scanner(System.in);
        var animal = new Animal();
        var animalServico = new AnimalServico();
        System.out.println("Segue a lista de todos animais cadastrados: ");
        listarTodos();
        System.out.println("Digite o ID do animal que deseja alterar:");
        var id = Long.parseLong(ler.nextLine());
        var animalEncontrado = animalServico.encontrarAnimal(id);
        if (animalEncontrado != null) {
            Integer opcao = 0;
            while (opcao != 8){
                System.out.println("Qual das opcao deseja alterar?");
                System.out.println("1 - Nome");
                System.out.println("2 - Especie");
                System.out.println("3 - Cor");
                System.out.println("4 - Temperamento");
                System.out.println("5 - Nome do responsavel");
                System.out.println("6 - CPF do responsavel");
                System.out.println("7 - Data de nascimento");
                System.out.println("8 - Sair");
                System.out.println("Digite a opção desejada: ");
                opcao = Integer.parseInt(ler.nextLine());

                switch (opcao) {
                    case 1 -> {
                        System.out.println("Nome: [" + animalEncontrado.getNome() + "]");
                        var nome = ler.nextLine();
                        animalEncontrado.setNome(nome);
                    }
                    case 2 -> {
                        System.out.println("Especie: [" + animalEncontrado.getEspecie() + "]");
                        var especie = ler.nextLine();
                        animalEncontrado.setEspecie(especie);
                    }
                    case 3 -> {
                        System.out.println("Cor: [" + animalEncontrado.getCor() + "]");
                        var cor = ler.nextLine();
                        animalEncontrado.setCor(cor);
                    }
                    case 4  -> {
                        System.out.println("Temperamento: [" + animalEncontrado.getTemperamento() + "]");
                        var temperamento = ler.nextLine();
                        animalEncontrado.setTemperamento(temperamento);
                    }
                    case 5 -> {
                        System.out.println("Nome do Responsável: [" + animalEncontrado.getNomeResponsavel() + "]");
                        var nResponsavel = ler.nextLine();
                        animalEncontrado.setNomeResponsavel(nResponsavel);
                    }
                    case 6 -> {
                        System.out.println("CPF do Responsavel: [" + animalEncontrado.getCpfResponsavel() + "]");
                        var cpf = ler.nextLine();
                        animalEncontrado.setCpfResponsavel(cpf);
                    }
                    case 7 -> {
                        System.out.println("Data de Nascimento: [" + animalEncontrado.getDataNascimento() + "]");
                        String dataDeNascimentoDigitada = ler.nextLine();
                        DateTimeFormatter formato = DateTimeFormatter.ofPattern("d/MM/yyyy");
                        LocalDate dataNascimentoFormatada = LocalDate.parse(dataDeNascimentoDigitada, formato);
                        animal.setDataNascimento(dataNascimentoFormatada);
                    }
                }
                animalServico.alterar(animalEncontrado);
            }
        } else {
            System.out.println("Animal nao encontrado.");
        }
    }

    public static void excluir(){
        var ler = new Scanner(System.in);
        var animal = new Animal();
        var animalServico = new AnimalServico();
        System.out.println("Segue a lista de todos animais cadastrados: ");
        listarTodos();
        System.out.println("Digite o ID do animal que deseja alterar:");
        var id = Long.parseLong(ler.nextLine());
        animalServico.excluir(id);
    }
}
