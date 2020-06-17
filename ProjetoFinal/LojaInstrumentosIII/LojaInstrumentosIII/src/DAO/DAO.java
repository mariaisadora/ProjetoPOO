package DAO;

import java.util.ArrayList;

public interface DAO<T> {
    public int salvar(T entidade);
    public T recuperar(int id);
    public ArrayList<T> listar();
    public boolean alterar(T entidade);
    public boolean excluir(int id);
}
