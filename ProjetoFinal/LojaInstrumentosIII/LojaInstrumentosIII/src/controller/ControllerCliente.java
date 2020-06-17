package controller;

import model.ModelCliente;
import DAO.DAOCliente;
import java.util.ArrayList;

public class ControllerCliente {

    private DAOCliente daoCliente = new DAOCliente();

    /**
     * grava Cliente
     *
     * @param pModelCliente return int
     */
    public int salvarClienteController(ModelCliente pModelCliente) {
        return this.daoCliente.salvar(pModelCliente);
    }

    /**
     * recupera Cliente
     *
     * @param pIdCliente return ModelCliente
     */
    public ModelCliente getClienteController(int pIdCliente) {
        return this.daoCliente.recuperar(pIdCliente);
    }

    /**
     * recupera Cliente
     *
     * @param pNomeCliente return ModelCliente
     */
    public ModelCliente getClienteController(String pNomeCliente) {
        return this.daoCliente.recuperar(pNomeCliente);
    }

    /**
     * recupera uma lista deCliente
     *
     * @param pIdCliente return ArrayList
     */
    public ArrayList<ModelCliente> getListaClienteController() {
        return this.daoCliente.listar();
    }

    /**
     * atualiza Cliente
     *
     * @param pModelCliente return boolean
     */
    public boolean atualizarClienteController(ModelCliente pModelCliente) {
        return this.daoCliente.alterar(pModelCliente);
    }

    /**
     * exclui Cliente
     *
     * @param pIdCliente return boolean
     */
    public boolean excluirClienteController(int pIdCliente) {
        return this.daoCliente.excluir(pIdCliente);
    }
}
