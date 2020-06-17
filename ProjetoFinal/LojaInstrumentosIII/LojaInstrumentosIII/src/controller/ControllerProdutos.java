package controller;

import DAO.DAOProdutos;
import java.util.ArrayList;
import model.ModelProdutos;

public class ControllerProdutos {

    private DAOProdutos daoProdutos = new DAOProdutos();

    /**
     * Salvar produtos controller
     *
     * @param pModelProdutos
     * @return int
     */
    public int salvarProdutoController(ModelProdutos pModelProdutos) {
        return this.daoProdutos.salvar(pModelProdutos);
    }

    /**
     * excluir um produto pelo código
     *
     * @param pCodigo
     * @return boolean
     */
    public boolean excluirProdutoController(int pCodigo) {
        return this.daoProdutos.excluir(pCodigo);
    }

    /**
     * alterar um produto
     *
     * @param pModelProdutos
     * @return boolean
     */
    public boolean alterarProdutoController(ModelProdutos pModelProdutos) {
        return this.daoProdutos.alterar(pModelProdutos);
    }

    /**
     * retornar produto pelo código
     *
     * @param pCodigo
     * @return model produto
     */
    public ModelProdutos retornarProdutoController(int pCodigo) {
        return this.daoProdutos.recuperar(pCodigo);
    }

    /**
     * retornar produto pelo código
     *
     * @param pNomeProduto
     * @return model produto
     */
    public ModelProdutos retornarProdutoController(String pNomeProduto) {
        return this.daoProdutos.recuperar(pNomeProduto);
    }

    /**
     * retornar uma lista de produtos
     *
     * @return lista Model produtos
     */
    public ArrayList<ModelProdutos> retornarListaProdutoController() {
        return this.daoProdutos.listar();
    }

    /**
     * Alterar lista de produtos no banco
     *
     * @param pListaModelProdutoses
     * @return
     */
    public boolean alterarEstoqueProdutoController(ArrayList<ModelProdutos> pListaModelProdutoses) {
        return this.daoProdutos.alterarEstoqueProdutosDAO(pListaModelProdutoses);
    }

}
