package br.edu.up.telas;

import java.util.List;

import br.edu.up.controles.ControlePessoas;
import br.edu.up.modelos.Pessoa;

public class Menu {
    public static void executar() {
        ControlePessoas ControlePessoas = new ControlePessoas();

        List<Pessoa> listaDePessoas = ControlePessoas.getPessoas();

        System.out.println("\nNome / Cidade / Codigo / Rua");
        for (Pessoa pessoa : listaDePessoas) {
            System.out.println(pessoa.getNome() + " / " + pessoa.getCidade() + " / " + pessoa.getCodigo() + " / " + pessoa.getRua());
         }
        
         if (ControlePessoas.gravar()) {
            System.out.println("Gravado com sucesso");
        }


    }
}
