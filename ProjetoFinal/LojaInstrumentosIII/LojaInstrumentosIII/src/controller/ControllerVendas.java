package controller;

import model.ModelVendas;
import DAO.DAOVendas;
import java.util.ArrayList;

public class ControllerVendas {

    private DAOVendas daoVendas = new DAOVendas();

    /**
     * grava Vendas
     *
     * @param pModelVendas return int
     */
    public int salvarVendasController(ModelVendas pModelVendas) {
        return this.daoVendas.salvar(pModelVendas);
    }

    /**
     * recupera Vendas
     *
     * @param pIdVenda return ModelVendas
     */
    public ModelVendas getVendasController(int pIdVenda) {
        return this.daoVendas.recuperar(pIdVenda);
    }

    /**
     * recupera uma lista deVendas
     *
     * @param pIdVenda return ArrayList
     */
    public ArrayList<ModelVendas> getListaVendasController() {
        return this.daoVendas.listar();
    }

    /**
     * atualiza Vendas
     *
     * @param pModelVendas return boolean
     */
    public boolean atualizarVendasController(ModelVendas pModelVendas) {
        return this.daoVendas.alterar(pModelVendas);
    }

    /**
     * exclui Vendas
     *
     * @param pIdVenda return boolean
     */
    public boolean excluirVendasController(int pIdVenda) {
        return this.daoVendas.excluir(pIdVenda);
    }

    /**
     * Gerar o relatorio da venda
     *
     * @param codigoVenda
     * @return
     */
    public boolean gerarRelatorioVenda(int codigoVenda) {
        return this.daoVendas.relatorio(codigoVenda);

    }
}
