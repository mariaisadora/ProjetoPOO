package DAO;

import model.ModelFuncionario;
import conexoes.ConexaoMySql;
import java.util.ArrayList;

public class DAOFuncionario extends ConexaoMySql implements DAO<ModelFuncionario> {

    /**
     * grava Funcionario
     *
     * @param entidade return int
     */
    public int salvar(ModelFuncionario entidade) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO tbl_funcionario ("
                    + "fun_nome,"
                    + "fun_cpf,"
                    + "fun_endereco,"
                    + "fun_bairro,"
                    + "fun_cidade,"
                    + "fun_uf,"
                    + "fun_cep,"
                    + "fun_telefone"
                    + "fun_salario"        
                    + ") VALUES ("
                    + "'" + entidade.getNome() + "',"
                    + "'" + entidade.getCpf() + "',"
                    + "'" + entidade.getEndereco() + "',"
                    + "'" + entidade.getBairro() + "',"
                    + "'" + entidade.getCidade() + "',"
                    + "'" + entidade.getUf() + "',"
                    + "'" + entidade.getCep() + "',"
                    + "'" + entidade.getTelefone() + "'"
                    + "'" + entidade.getSalario() + "'"
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
     * recupera Funcionario
     *
     * @param id return ModelFuncionario
     */
    public ModelFuncionario recuperar(int id) {
        ModelFuncionario modelFuncionario = new ModelFuncionario() {
        };
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_id_funcionario,"
                    + "fun_nome,"
                    + "fun_cpf,"
                    + "fun_endereco,"
                    + "fun_bairro,"
                    + "fun_cidade,"
                    + "fun_uf,"
                    + "fun_cep,"
                    + "fun_telefone"
                    + "fun_salario"        
                    + " FROM"
                    + " tbl_funcionario"
                    + " WHERE"
                    + " pk_id_funcionario = '" + id + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelFuncionario.setId(this.getResultSet().getInt(1));
                modelFuncionario.setNome(this.getResultSet().getString(2));
                modelFuncionario.setCpf(this.getResultSet().getString(3));
                modelFuncionario.setEndereco(this.getResultSet().getString(4));
                modelFuncionario.setBairro(this.getResultSet().getString(5));
                modelFuncionario.setCidade(this.getResultSet().getString(7));
                modelFuncionario.setUf(this.getResultSet().getString(7));
                modelFuncionario.setCep(this.getResultSet().getString(8));
                modelFuncionario.setTelefone(this.getResultSet().getString(9));
                modelFuncionario.setSalario(this.getResultSet().getDouble(10));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelFuncionario;
    }

    /**
     * recupera Funcionario
     *
     * @param pNomeFuncionario return ModelFuncionario
     */
    public ModelFuncionario recuperar(String pNomeFuncionario) {
        ModelFuncionario modelFuncionario = new ModelFuncionario() {
        };
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_id_funcionario,"
                    + "fun_nome,"
                    + "fun_cpf,"
                    + "fun_endereco,"
                    + "fun_bairro,"
                    + "fun_cidade,"
                    + "fun_uf,"
                    + "fun_cep,"
                    + "fun_telefone"
                    + "fun_salario"
                    + " FROM"
                    + " tbl_funcionario"
                    + " WHERE"
                    + " fun_nome = '" + pNomeFuncionario + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelFuncionario.setId(this.getResultSet().getInt(1));
                modelFuncionario.setNome(this.getResultSet().getString(2));
                modelFuncionario.setCpf(this.getResultSet().getString(3));
                modelFuncionario.setEndereco(this.getResultSet().getString(4));
                modelFuncionario.setBairro(this.getResultSet().getString(5));
                modelFuncionario.setCidade(this.getResultSet().getString(6));
                modelFuncionario.setUf(this.getResultSet().getString(7));
                modelFuncionario.setCep(this.getResultSet().getString(8));
                modelFuncionario.setTelefone(this.getResultSet().getString(9));
                modelFuncionario.setSalario(this.getResultSet().getDouble(10));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelFuncionario;
    }

    /**
     * recupera uma lista de Funcionario return ArrayList
     */
    public ArrayList<ModelFuncionario> listar() {
        ArrayList<ModelFuncionario> listamodelFuncionario = new ArrayList();
        ModelFuncionario modelFuncionario = new ModelFuncionario() {
        };
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_id_funcionario,"
                    + "fun_nome,"
                    + "fun_cpf,"
                    + "fun_endereco,"
                    + "fun_bairro,"
                    + "fun_cidade,"
                    + "fun_uf,"
                    + "fun_cep,"
                    + "fun_telefone"
                    + "fun_salario"        
                    + " FROM"
                    + " tbl_funcionario"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelFuncionario = new ModelFuncionario() {
                };
                modelFuncionario.setId(this.getResultSet().getInt(1));
                modelFuncionario.setNome(this.getResultSet().getString(2));
                modelFuncionario.setCpf(this.getResultSet().getString(3));
                modelFuncionario.setEndereco(this.getResultSet().getString(4));
                modelFuncionario.setBairro(this.getResultSet().getString(5));
                modelFuncionario.setCidade(this.getResultSet().getString(6));
                modelFuncionario.setUf(this.getResultSet().getString(7));
                modelFuncionario.setCep(this.getResultSet().getString(8));
                modelFuncionario.setTelefone(this.getResultSet().getString(9));
                modelFuncionario.setSalario(this.getResultSet().getDouble(10));
                listamodelFuncionario.add(modelFuncionario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelFuncionario;
    }

    /**
     * atualiza Funcionario
     *
     * @param entidade return boolean
     */
    public boolean alterar(ModelFuncionario entidade) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE tbl_funcionario SET "
                    + "pk_id_funcionario = '" + entidade.getId() + "',"
                    + "fun_nome = '" + entidade.getNome() + "',"
                    + "fun_cpf = '" + entidade.getCpf() + "',"
                    + "fun_endereco = '" + entidade.getEndereco() + "',"
                    + "fun_bairro = '" + entidade.getBairro() + "',"
                    + "fun_cidade = '" + entidade.getCidade() + "',"
                    + "fun_uf = '" + entidade.getUf() + "',"
                    + "fun_cep = '" + entidade.getCep() + "',"
                    + "fun_telefone = '" + entidade.getTelefone() + "'"
                    + "fun_salario = '" + entidade.getSalario() + "'"
                    + " WHERE "
                    + "pk_id_funcionario = '" + entidade.getId() + "'"
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
     * exclui Funcionario
     *
     * @param id return boolean
     */
    public boolean excluir(int id) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM tbl_funcionario "
                    + " WHERE "
                    + "pk_id_funcionario = '" + id + "'"
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
