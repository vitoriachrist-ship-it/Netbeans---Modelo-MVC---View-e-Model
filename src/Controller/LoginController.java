package Controller;

import Controller.Helper.LoginHelper;
import Model.DAO.UsuarioDAO;
import model.Usuario;
import View.Login;
import View.MenuPrincipal;

public class LoginController {

    private final Login view;
    private final LoginHelper helper;

    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }

    public void entrarNoSistema() {
        // 1. Pega o usuário digitado na View
        Usuario usuario = helper.obterModelo();

        // 2. Pesquisa o usuário no Banco através do DAO
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioAutenticado = usuarioDAO.selectPorNomeESenha(usuario);

        // 3. Se existir no banco, abre o MenuPrincipal e fecha o Login
        if (usuarioAutenticado != null) {
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
            this.view.dispose();
        } else {
            view.exibeMensagem("Usuário ou senha inválidos!");
            helper.limparTela();
        }
    }
}