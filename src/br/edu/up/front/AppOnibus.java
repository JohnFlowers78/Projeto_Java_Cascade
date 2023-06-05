package br.edu.up.front;

import br.edu.up.front.Console;
import br.edu.up.entidades.Onibus;
import br.edu.up.persistencia.OnibusPersistencia;
import br.edu.up.persistencia.RotaPersistencia;
import java.util.List;

public class AppOnibus {
    public static void main(String[] args) {
        int opc;
        OnibusPersistencia onibusDAO = new OnibusPersistencia();
        RotaPersistencia rotaDAO = new RotaPersistencia();
        
        do {
            System.out.println("\n\nMenu Ônibus:");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Listar");
            System.out.println("5 - Voltar");

            opc = Console.readInt("Informe a opção: ");

            switch (opc) {
                case 1:
                    // Lógica para cadastrar ônibus
                    Onibus onibus = new Onibus();
                    // Preencha os dados do ônibus, por exemplo:
                    onibus.setNomeLinha(Console.readString("\nInforme o nome da linha:"));
                    onibus.setNumeroLinha(Console.readInt("Informe o número da linha:"));
                    onibusDAO.incluir(onibus);
                    System.out.println("\nÔnibus cadastrado com sucesso!");
                    break;
                case 2:
                    // Lógica para atualizar ônibus
                    int idOnibusAtualizar = Console.readInt("\nInforme o ID do ônibus que deseja atualizar:");
                    Onibus onibusAtualizar = onibusDAO.procurarPorId(idOnibusAtualizar);                                                                     //AQUI
                    if (onibusAtualizar != null) {
                        onibusAtualizar.setNomeLinha(Console.readString("Informe o novo nome da linha:"));
                        onibusAtualizar.setNumeroLinha(Console.readInt("Informe o novo número da linha:"));
                        onibusDAO.alterar(onibusAtualizar);
                        System.out.println("\nÔnibus atualizado com sucesso!");
                    } else {
                        System.out.println("\nNão existe um ônibus com esse ID!");
                    }
                    break;
                case 3:
                    // Lógica para excluir ônibus
                    int idOnibusExcluir = Console.readInt("\nInforme o ID do ônibus que deseja excluir:");
                    Onibus onibusExcluir = onibusDAO.procurarPorId(idOnibusExcluir);                                                                          //AQUI
                    if (onibusExcluir != null) {
                        boolean confirmacao = Console.readBoolean("\nDeseja excluir também as rotas associadas a este Ônibus? (true/false):");
                        if (confirmacao) {
                            rotaDAO.deleteByOnibusID(onibusExcluir.getId());
                        }
                        onibusDAO.excluir(onibusExcluir);
                        System.out.println("\nÔnibus deletado com sucesso!");
                    } else {
                        System.out.println("\nNão existe um ônibus com esse ID!");
                    }
                    break;
                case 4:
                    // Lógica para listar ônibus
                    System.out.println("\nLista de Ônibus:");
                    List<Onibus> onibusList = onibusDAO.getOnibus();
                    if (!onibusList.isEmpty()) {
                        for (Onibus o : onibusList) {
                            System.out.println("ID: " + o.getId());
                            System.out.println("Nome da linha: " + o.getNomeLinha());
                            System.out.println("Número da linha: " + o.getNumeroLinha());
                        }
                    } else {
                        System.out.println("Nenhum ônibus encontrado.");
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
