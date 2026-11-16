package Controller.Helper;

import model.Usuario;
import View.Login;

public class LoginHelper {

    private final Login view;

    public LoginHelper(Login view) {
        this.view = view;
    }

    public Usuario obterModelo() {
        String nome = view.getTextUsuario().getText();
        String senha = new String(view.getTextSenha().getPassword());
        return new Usuario(0, nome, senha, "");
    }

    public void setarModelo(Usuario modelo) {
        view.getTextUsuario().setText(modelo.getNome());
        view.getTextSenha().setText(modelo.getSenha());
    }

    public void limparTela() {
        view.getTextUsuario().setText("");
        view.getTextSenha().setText("");
    }
}