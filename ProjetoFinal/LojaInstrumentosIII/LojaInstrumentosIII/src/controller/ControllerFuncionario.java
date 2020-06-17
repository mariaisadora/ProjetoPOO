package controller;

import DAO.DAOFuncionario;
import java.util.ArrayList;
import model.ModelFuncionario;

public class ControllerFuncionario {
    private DAOFuncionario daoFuncionario = new DAOFuncionario();

    /**
     * grava Funcionario
     *
     * @param entidade return int
     */
    public int salvarFuncionarioController(ModelFuncionario entidade) {
        return this.daoFuncionario.salvar(entidade);
    }

    /**
     * recupera Funcionario
     *
     * @param id return ModelFuncionario
     */
    public ModelFuncionario getFuncionarioController(int id) {
        return this.daoFuncionario.recuperar(id);
    }

    /**
     * recupera Funcionario
     *
     * @param pNomeFuncionario return ModelFuncionario
     */
    public ModelFuncionario getFuncionarioController(String pNomeFuncionario) {
        return this.daoFuncionario.recuperar(pNomeFuncionario);
    }

    /**
     * recupera uma lista deFuncionario
     *
     * @param pIdFuncionario return ArrayList
     */
    public ArrayList<ModelFuncionario> getListaFuncionarioController() {
        return this.daoFuncionario.listar();
    }

    /**
     * atualiza Funcionario
     *
     * @param entidade return boolean
     */
    public boolean atualizarFuncionarioController(ModelFuncionario entidade) {
        return this.daoFuncionario.alterar(entidade);
    }

    /**
     * exclui Funcionario
     *
     * @param id return boolean
     */
    public boolean excluirFuncionarioController(int id) {
        return this.daoFuncionario.excluir(id);
    }
    
}
