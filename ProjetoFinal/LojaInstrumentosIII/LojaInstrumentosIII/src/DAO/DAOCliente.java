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
                    + "'" + entidade.getCliNome() + "',"
                    + "'" + entidade.getCliCpf() + "',"
                    + "'" + entidade.getCliEndereco() + "',"
                    + "'" + entidade.getCliBairro() + "',"
                    + "'" + entidade.getCliCidade() + "',"
                    + "'" + entidade.getCliUf() + "',"
                    + "'" + entidade.getCliCep() + "',"
                    + "'" + entidade.getCliTelefone() + "'"
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
                modelCliente.setIdCliente(this.getResultSet().getInt(1));
                modelCliente.setCliNome(this.getResultSet().getString(2));
                modelCliente.setCliCpf(this.getResultSet().getString(3));
                modelCliente.setCliEndereco(this.getResultSet().getString(4));
                modelCliente.setCliBairro(this.getResultSet().getString(5));
                modelCliente.setCliCidade(this.getResultSet().getString(7));
                modelCliente.setCliUf(this.getResultSet().getString(7));
                modelCliente.setCliCep(this.getResultSet().getString(8));
                modelCliente.setCliTelefone(this.getResultSet().getString(9));
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
                modelCliente.setIdCliente(this.getResultSet().getInt(1));
                modelCliente.setCliNome(this.getResultSet().getString(2));
                modelCliente.setCliCpf(this.getResultSet().getString(3));
                modelCliente.setCliEndereco(this.getResultSet().getString(4));
                modelCliente.setCliBairro(this.getResultSet().getString(5));
                modelCliente.setCliCidade(this.getResultSet().getString(6));
                modelCliente.setCliUf(this.getResultSet().getString(7));
                modelCliente.setCliCep(this.getResultSet().getString(8));
                modelCliente.setCliTelefone(this.getResultSet().getString(9));
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
                modelCliente.setIdCliente(this.getResultSet().getInt(1));
                modelCliente.setCliNome(this.getResultSet().getString(2));
                modelCliente.setCliCpf(this.getResultSet().getString(3));
                modelCliente.setCliEndereco(this.getResultSet().getString(4));
                modelCliente.setCliBairro(this.getResultSet().getString(5));
                modelCliente.setCliCidade(this.getResultSet().getString(6));
                modelCliente.setCliUf(this.getResultSet().getString(7));
                modelCliente.setCliCep(this.getResultSet().getString(8));
                modelCliente.setCliTelefone(this.getResultSet().getString(9));
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
                    + "pk_id_cliente = '" + entidade.getIdCliente() + "',"
                    + "cli_nome = '" + entidade.getCliNome() + "',"
                    + "cli_cpf = '" + entidade.getCliCpf() + "',"
                    + "cli_endereco = '" + entidade.getCliEndereco() + "',"
                    + "cli_bairro = '" + entidade.getCliBairro() + "',"
                    + "cli_cidade = '" + entidade.getCliCidade() + "',"
                    + "cli_uf = '" + entidade.getCliUf() + "',"
                    + "cli_cep = '" + entidade.getCliCep() + "',"
                    + "cli_telefone = '" + entidade.getCliTelefone() + "'"
                    + " WHERE "
                    + "pk_id_cliente = '" + entidade.getIdCliente() + "'"
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
