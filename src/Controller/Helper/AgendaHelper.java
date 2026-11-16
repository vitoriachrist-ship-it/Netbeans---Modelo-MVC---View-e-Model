package Controller.Helper;

import model.Agendamento;
import model.Cliente;
import model.Servico;
import View.Agenda;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;

public class AgendaHelper {

    private final Agenda view;

    public AgendaHelper(Agenda view) {
        this.view = view;
    }

    public void preencherTabela(ArrayList<Agendamento> agendamentos) {
        DefaultTableModel tableModel = (DefaultTableModel) view.getTableAgendamentos().getModel();
        tableModel.setNumRows(0);

        for (Agendamento agendamento : agendamentos) {
            tableModel.addRow(new Object[]{
                agendamento.getId(),
                agendamento.getCliente().getNome(),
                agendamento.getServico().getDescricao(),
                agendamento.getValor(),
                agendamento.getDataFormatada(),
                agendamento.getHoraFormatada(),
                agendamento.getObservacao()
            });
        }
    }
    public void preencherCliente(ArrayList<Cliente> clientes) {
    DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getJComboBoxCliente().getModel();
    comboBoxModel.removeAllElements();

    for (Cliente cliente : clientes) {
        comboBoxModel.addElement(cliente);
    }
    }

    public void preencherServico(ArrayList<Servico> servicos) {
    DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getJComboBoxServico().getModel();
    comboBoxModel.removeAllElements();

    for (Servico servico : servicos) {
        comboBoxModel.addElement(servico);
    }
    }
    public Servico obterServico() {
        return (Servico) view.getJComboBoxServico().getSelectedItem();
    }

    public void setarValor(float valor) {
        view.getTxtValor().setText(String.valueOf(valor));
}
}