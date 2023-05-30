package br.edu.up.front;

import br.edu.up.front.Console;
import br.edu.up.entidades.Motorista;
import br.edu.up.persistencia.MotoristaPersistencia;
import br.edu.up.persistencia.RotaPersistencia;
import java.util.List;

public class AppMotorista {
    public static void main(String[] args) {
        int opc;
        MotoristaPersistencia motoristaDAO = new MotoristaPersistencia();
        RotaPersistencia rotaDAO = new RotaPersistencia();
        do {
            System.out.println("\n\nMenu Motorista:");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Listar");
            System.out.println("5 - Voltar");

            opc = Console.readInt("Informe a opção: ");

            switch (opc) {
                case 1:
                    // Lógica para cadastrar motorista
                    Motorista motorista = new Motorista();
                    // Preencha os dados do motorista, por exemplo:
                    System.out.println("\n\nInforme os dados do motorista abaixo, lembrando que o CPF deve conter apenas 11 dígitos!");
                    motorista.setNome(Console.readString("\nInforme o nome do motorista:"));
                    motorista.setCpf(Console.readString("Informe o CPF do motorista:"));
                    motorista.setNumero(Console.readString("Informe o número do motorista:"));
                    motoristaDAO.incluir(motorista);
                    System.out.println("\nMotorista cadastrado com sucesso!");
                    break;
                case 2:
                    // Lógica para atualizar motorista
                    // Crie um objeto Motorista e preencha com os dados do motorista que você deseja atualizar
                    int idMotoristaAtualizar = Console.readInt("\nInforme o ID do motorista que deseja atualizar:");
                    Motorista motoristaAtualizar = motoristaDAO.procurarPorId(idMotoristaAtualizar);
                    if (motoristaAtualizar != null) {
                        motoristaAtualizar.setNome(Console.readString("Informe o novo nome do motorista:"));
                        motoristaAtualizar.setCpf(Console.readString("Informe o novo CPF do motorista:"));
                        motoristaAtualizar.setNumero(Console.readString("Informe o novo número do motorista:"));
                        motoristaDAO.alterar(motoristaAtualizar);
                        System.out.println("\nMotorista atualizado com sucesso!");
                    } else {
                        System.out.println("\nNão existe um motorista com esse ID!");
                    }
                    break;
                case 3:
                    // Lógica para excluir motorista
                    int idMotoristaExcluir = Console.readInt("\nInforme o ID do motorista que deseja excluir:");
                    Motorista motoristaExcluir = motoristaDAO.procurarPorId(idMotoristaExcluir);
                    if (motoristaExcluir != null) {
                        boolean confirmacao = Console.readBoolean("\nDeseja excluir também as rotas associadas a este motorista? (true/false):");
                        if (confirmacao) {
                            rotaDAO.deleteByMotoristaID(motoristaExcluir.getId());
                        }
                        motoristaDAO.excluir(motoristaExcluir);
                        System.out.println("\nMotorista deletado com sucesso!");
                    } else {
                        System.out.println("\nNão existe um motorista com esse ID!");
                    }
                    break;
                case 4:
                    // Lógica para listar motoristas
                    String nome = Console.readString("\nInforme o nome do motorista ou deixe em branco para listar todos:");
                    System.out.println("\nLista de Motoristas:");
                    List<Motorista> motoristas = motoristaDAO.getMotoristas(nome);
                    if (!motoristas.isEmpty()) {
                        for (Motorista m : motoristas) {
                            System.out.println("ID: " + m.getId());
                            System.out.println("Motorista: " + m.getNome());
                            System.out.println("CPF: " + m.getCpf());
                            System.out.println("Número: " + m.getNumero());
                        }
                    } else {
                        System.out.println("Nenhum motorista encontrado.");
                    }
                    break;
                case 5:
                	Principal.main(args);
                    System.out.println("\nVoltando...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opc != 5);
    }
}
