package br.edu.up.front;

import br.edu.up.entidades.Onibus;
import br.edu.up.entidades.Motorista;

import br.edu.up.front.Console;
import br.edu.up.entidades.Rota;
import br.edu.up.persistencia.RotaPersistencia;
import br.edu.up.persistencia.MotoristaPersistencia;
import br.edu.up.persistencia.OnibusPersistencia;
import java.util.List;

public class AppRota {
    public static void main(String[] args) {
        int opc;
        RotaPersistencia rotaDAO = new RotaPersistencia();
        MotoristaPersistencia motoristaDAO = new MotoristaPersistencia();
        OnibusPersistencia onibusDAO = new OnibusPersistencia();

        do {
            System.out.println("\n\nMenu Rotas:");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Listar");      //    33, 42, 47
            System.out.println("5 - Voltar");

            opc = Console.readInt("Informe a opção: ");

            switch (opc) {
                case 1:
                    
                    Rota rota = new Rota();
                    int idOnibus = Console.readInt("\nInforme o ID do ônibus:");
                    int idMotorista = Console.readInt("Informe o ID do motorista:");

                    if (!onibusDAO.onibusExiste(idOnibus)) {
                        System.out.println("ID do ônibus inválido. Não existe um ônibus com esse ID!");
                        break;
                    }

                    if (!motoristaDAO.motoristaExiste(idMotorista)) {
                        System.out.println("ID do motorista inválido. Não existe um motorista com esse ID!");
                        break;
                    }
                    
                    Onibus onibus = OnibusPersistencia.procurarPorId(idOnibus);
                    rota.setOnibus(onibus);
                    
                    Motorista motorista = MotoristaPersistencia.procurarPorId(idMotorista);
                    rota.setMotorista(motorista);
                    
                    rota.setNomeRota(Console.readString("Informe o nome da rota:"));
                    rotaDAO.incluir(rota);
                    System.out.println("\nRota cadastrada com sucesso!");
                    break;
                case 2:
                    // Lógica para atualizar rota
                    Rota rotaAtualizada = new Rota();
                    rotaAtualizada.setId(Console.readInt("\nInforme o ID da rota que deseja atualizar:"));
                    //rotaAtualizada.setOnibus(new Onibus(Console.readInt("Informe o novo ID do ônibus:")));
                    rotaAtualizada.setOnibus(new Onibus());
                    // rotaAtualizada.setMotorista(new Motorista(Console.readInt("Informe o novo ID do motorista:")));
                    rotaAtualizada.setMotorista(new Motorista());
                    rotaAtualizada.setNomeRota(Console.readString("Informe o novo nome da rota:"));
                    rotaDAO.alterar(rotaAtualizada);
                    System.out.println("\nRota atualizada com sucesso!");
                    break;
                case 3:
                    // Lógica para excluir rota
                    int idRotaExcluir = Console.readInt("\nInforme o ID da rota que deseja excluir:");
                    Rota rotaExcluir = rotaDAO.procurarPorId(idRotaExcluir);                                                   //AQUI
                    if (rotaExcluir != null) {
                        rotaDAO.excluir(rotaExcluir);
                        System.out.println("\nRota deletada com sucesso!");
                    } else {
                        System.out.println("\nNão existe uma rota com esse ID!");
                    }
                    break;
                case 4:
                    // Lógica para listar rotas
                    List<Rota> rotas = rotaDAO.getRotas();
                    if (!rotas.isEmpty()) {
                        System.out.println("\nLista de Rotas:");
                        for (Rota r : rotas) {
                            System.out.println("ID: " + r.getId());
                            System.out.println("ID do ônibus: " + r.getOnibus());
                            System.out.println("ID do motorista: " + r.getMotorista());
                            System.out.println("Nome da rota: " + r.getNomeRota());
                            System.out.println();
                        }
                    } else {
                        System.out.println("Nenhuma rota encontrada.");
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
