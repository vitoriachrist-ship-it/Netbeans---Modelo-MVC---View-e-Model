package Controller;

import Controller.Helper.AgendaHelper;
import model.Agendamento;
import Model.DAO.AgendamentoDAO;
import View.Agenda;
import java.util.ArrayList;
import model.Cliente;
import model.Servico;
import Model.DAO.ClienteDAO;
import Model.DAO.ServicoDAO;

public class AgendaController {

    private final Agenda view;
    private final AgendaHelper helper;

    public AgendaController(Agenda view) {
        this.view = view;
        this.helper = new AgendaHelper(view);
    }

    public void atualizaTabela() {
        // 1. Busca a lista de agendamentos do banco em memória
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        ArrayList<Agendamento> agendamentos = agendamentoDAO.selectAll();

        // 2. Envia a lista para o Helper preencher a JTable
        helper.preencherTabela(agendamentos);
    }
    public void atualizaCliente() {
    // 1. Busca os clientes do banco em memória
    ClienteDAO clienteDAO = new ClienteDAO();
    ArrayList<Cliente> clientes = clienteDAO.selectAll();

    // 2. Envia a lista para o Helper preencher o JComboBox
    helper.preencherCliente(clientes);
    }

    public void atualizaServico() {
        // 1. Busca os serviços do banco em memória
        ServicoDAO servicoDAO = new ServicoDAO();
        ArrayList<Servico> servicos = servicoDAO.selectAll();

        // 2. Envia a lista para o Helper preencher o JComboBox
        helper.preencherServico(servicos);
    }
    public void atualizaValor() {
        Servico servico = helper.obterServico();
        if (servico != null) {
            helper.setarValor(servico.getValor());
        }
}
}