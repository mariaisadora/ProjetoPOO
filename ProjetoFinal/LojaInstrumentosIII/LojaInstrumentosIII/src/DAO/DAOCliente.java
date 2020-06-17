package DAO;

import model.ModelCliente;
import conexoes.ConexaoMySql;
import java.util.ArrayList;

public class DAOCliente extends ConexaoMySql implements DAO<ModelCliente> {

    /**
     * grava Cliente
     *
     * @param entidade return int
     */
    public int salvar(ModelCliente entidade) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO tbl_cliente ("
                    + "cli_nome,"
                    + "cli_cpf,"
                    + "cli_endereco,"
                    + "cli_bairro,"
                    + "cli_cidade,"
                    + "cli_uf,"
                    + "cli_cep,"
                    + "cli_telefone"
                    + ") VALUES ("
                    + "'" + entidade.getNome() + "',"
                    + "'" + entidade.getCpf() + "',"
                    + "'" + entidade.getEndereco() + "',"
                    + "'" + entidade.getBairro() + "',"
                    + "'" + entidade.getCidade() + "',"
                    + "'" + entidade.getUf() + "',"
                    + "'" + entidade.getCep() + "',"
                    + "'" + entidade.getTelefone() + "'"
                    + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * recupera Cliente
     *
     * @param id return ModelCliente
     */
    public ModelCliente recuperar(int id) {
        ModelCliente modelCliente = new ModelCliente() {
        };
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_id_cliente,"
                    + "cli_nome,"
                    + "cli_cpf,"
                    + "cli_endereco,"
                    + "cli_bairro,"
                    + "cli_cidade,"
                    + "cli_uf,"
                    + "cli_cep,"
                    + "cli_telefone"
                    + " FROM"
                    + " tbl_cliente"
                    + " WHERE"
                    + " pk_id_cliente = '" + id + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCliente.setId(this.getResultSet().getInt(1));
                modelCliente.setNome(this.getResultSet().getString(2));
                modelCliente.setCpf(this.getResultSet().getString(3));
                modelCliente.setEndereco(this.getResultSet().getString(4));
                modelCliente.setBairro(this.getResultSet().getString(5));
                modelCliente.setCidade(this.getResultSet().getString(7));
                modelCliente.setUf(this.getResultSet().getString(7));
                modelCliente.setCep(this.getResultSet().getString(8));
                modelCliente.setTelefone(this.getResultSet().getString(9));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelCliente;
    }

    /**
     * recupera Cliente
     *
     * @param pNomeCliente return ModelCliente
     */
    public ModelCliente recuperar(String pNomeCliente) {
        ModelCliente modelCliente = new ModelCliente() {
        };
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_id_cliente,"
                    + "cli_nome,"
                    + "cli_cpf,"
                    + "cli_endereco,"
                    + "cli_bairro,"
                    + "cli_cidade,"
                    + "cli_uf,"
                    + "cli_cep,"
                    + "cli_telefone"
                    + " FROM"
                    + " tbl_cliente"
                    + " WHERE"
                    + " cli_nome = '" + pNomeCliente + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCliente.setId(this.getResultSet().getInt(1));
                modelCliente.setNome(this.getResultSet().getString(2));
                modelCliente.setCpf(this.getResultSet().getString(3));
                modelCliente.setEndereco(this.getResultSet().getString(4));
                modelCliente.setBairro(this.getResultSet().getString(5));
                modelCliente.setCidade(this.getResultSet().getString(6));
                modelCliente.setUf(this.getResultSet().getString(7));
                modelCliente.setCep(this.getResultSet().getString(8));
                modelCliente.setTelefone(this.getResultSet().getString(9));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelCliente;
    }

    /**
     * recupera uma lista de Cliente return ArrayList
     */
    public ArrayList<ModelCliente> listar() {
        ArrayList<ModelCliente> listamodelCliente = new ArrayList();
        ModelCliente modelCliente = new ModelCliente() {
        };
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_id_cliente,"
                    + "cli_nome,"
                    + "cli_cpf,"
                    + "cli_endereco,"
                    + "cli_bairro,"
                    + "cli_cidade,"
                    + "cli_uf,"
                    + "cli_cep,"
                    + "cli_telefone"
                    + " FROM"
                    + " tbl_cliente"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCliente = new ModelCliente() {
                };
                modelCliente.setId(this.getResultSet().getInt(1));
                modelCliente.setNome(this.getResultSet().getString(2));
                modelCliente.setCpf(this.getResultSet().getString(3));
                modelCliente.setEndereco(this.getResultSet().getString(4));
                modelCliente.setBairro(this.getResultSet().getString(5));
                modelCliente.setCidade(this.getResultSet().getString(6));
                modelCliente.setUf(this.getResultSet().getString(7));
                modelCliente.setCep(this.getResultSet().getString(8));
                modelCliente.setTelefone(this.getResultSet().getString(9));
                listamodelCliente.add(modelCliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelCliente;
    }

    /**
     * atualiza Cliente
     *
     * @param entidade return boolean
     */
    public boolean alterar(ModelCliente entidade) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE tbl_cliente SET "
                    + "pk_id_cliente = '" + entidade.getId() + "',"
                    + "cli_nome = '" + entidade.getNome() + "',"
                    + "cli_cpf = '" + entidade.getCpf() + "',"
                    + "cli_endereco = '" + entidade.getEndereco() + "',"
                    + "cli_bairro = '" + entidade.getBairro() + "',"
                    + "cli_cidade = '" + entidade.getCidade() + "',"
                    + "cli_uf = '" + entidade.getUf() + "',"
                    + "cli_cep = '" + entidade.getCep() + "',"
                    + "cli_telefone = '" + entidade.getTelefone() + "'"
                    + " WHERE "
                    + "pk_id_cliente = '" + entidade.getId() + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * exclui Cliente
     *
     * @param id return boolean
     */
    public boolean excluir(int id) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM tbl_cliente "
                    + " WHERE "
                    + "pk_id_cliente = '" + id + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
}
