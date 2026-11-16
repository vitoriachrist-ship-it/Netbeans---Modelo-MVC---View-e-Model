package view;

import model.Agendamento;
import model.Cliente;
import model.Servico;
import model.Usuario;

public class Main {

    public static void main(String[] args) {
        Cliente cliente = new Cliente(
            1,
            "Carlos Silva",
            'M',
            "15/05/1995",
            "(11) 99999-1234",
            "carlos@email.com",
            "12.345.678-9",
            "Rua das Flores, 100",
            "01001-000"
        );

        Usuario usuario = new Usuario(
            1,
            "Ana Souza",
            'F',
            "20/08/1990",
            "(11) 98888-4321",
            "ana@empresa.com",
            "98.765.432-1",
            "senha123",
            "Administrador"
        );

        Servico servico = new Servico(1, "Corte e Barba", 55.00f);

        Agendamento agendamento = new Agendamento(
            1,
            cliente,
            servico,
            servico.getValor(),
            "20/11/2026 14:30",
            "14:30",
            "Cliente prefere tesoura"
        );

        // Coloque o breakpoint na linha abaixo para inspecionar os objetos
        System.out.println("Agendamento criado para: " + agendamento.getCliente().getNome());
    }
}