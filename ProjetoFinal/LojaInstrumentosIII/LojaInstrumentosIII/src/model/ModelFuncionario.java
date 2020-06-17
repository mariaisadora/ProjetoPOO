package model;

public class ModelFuncionario extends ModelUsuario {

    private double salario;

    public ModelFuncionario() {

    }

    public ModelFuncionario(double salario, int id, String nome, String endereco, String cpf, String bairro,
            String cidade, String uf, String cep, String telefone) {
        super(id, nome, endereco, cpf, bairro, cidade, uf, cep, telefone);
        this.salario = salario;

    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}
