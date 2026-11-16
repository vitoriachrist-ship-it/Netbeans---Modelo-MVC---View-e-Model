package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Agendamento {

    private int id;
    private Cliente cliente;
    private Servico servico;
    private float valor;
    private Date data;
    private String hora;
    private String observacao;

    public Agendamento(int id, Cliente cliente, Servico servico, float valor, String data, String hora, String observacao) {
        this.id = id;
        this.cliente = cliente;
        this.servico = servico;
        this.valor = valor;
        this.hora = hora;
        this.observacao = observacao;
        try {
            String formato = data.contains(":") ? "dd/MM/yyyy HH:mm" : "dd/MM/yyyy";
            this.data = new SimpleDateFormat(formato).parse(data);
        } catch (ParseException e) {
            System.err.println("Erro ao converter data do agendamento: " + e.getMessage());
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    public String getDataFormatada() {
    if (this.data == null) {
        return "";
    }
    return new SimpleDateFormat("dd/MM/yyyy").format(this.data);
}

public String getHoraFormatada() {
    if (this.data == null) {
        return this.hora != null ? this.hora : "";
    }
    return new SimpleDateFormat("HH:mm").format(this.data);
}
}