package model;

public class ModelCliente extends ModelUsuario {

    public ModelCliente() {

    }

    public ModelCliente(int id, String nome, String endereco, String cpf, String bairro,
            String cidade, String uf, String cep, String telefone) {
        super(id, nome, endereco, cpf, bairro, cidade, uf, cep, telefone);

    }

}
