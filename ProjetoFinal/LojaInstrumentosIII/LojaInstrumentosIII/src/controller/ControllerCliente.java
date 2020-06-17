package controller;

import model.ModelCliente;
import DAO.DAOCliente;
import java.util.ArrayList;

public class ControllerCliente {

    private DAOCliente daoCliente = new DAOCliente();

    /**
     * grava Cliente
     *
     * @param entidade return int
     */
    public int salvarClienteController(ModelCliente entidade) {
        return this.daoCliente.salvar(entidade);
    }

    /**
     * recupera Cliente
     *
     * @param id return ModelCliente
     */
    public ModelCliente getClienteController(int id) {
        return this.daoCliente.recuperar(id);
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
     * @param entidade return boolean
     */
    public boolean atualizarClienteController(ModelCliente entidade) {
        return this.daoCliente.alterar(entidade);
    }

    /**
     * exclui Cliente
     *
     * @param id return boolean
     */
    public boolean excluirClienteController(int id) {
        return this.daoCliente.excluir(id);
    }
}
