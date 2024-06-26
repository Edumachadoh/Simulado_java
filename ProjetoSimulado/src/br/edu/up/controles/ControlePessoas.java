package br.edu.up.controles;

import java.util.List;

import br.edu.up.daos.GerenciadorArquivosPessoas;
import br.edu.up.modelos.Pessoa;

public class ControlePessoas {
     private GerenciadorArquivosPessoas gravadorArquivos = new GerenciadorArquivosPessoas();
    private List<Pessoa> pessoas;

    public ControlePessoas() {
        this.pessoas = gravadorArquivos.getPessoas();
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public boolean gravar() {
        return gravadorArquivos.gravar(pessoas);
    }

}
