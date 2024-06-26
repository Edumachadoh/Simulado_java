package br.edu.up.daos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.modelos.Pessoa;

public class GerenciadorArquivosPessoas {
    public class GerenciadorDeArquivosAeronaves {

    public GerenciadorDeArquivosAeronaves() {
       
    }
}

    public List<Pessoa> getPessoas() {
        List<Pessoa> pessoas = new ArrayList<>();

        try {
            File arquivoLeituraPessoa = new File("C:\\Users\\autologon\\Desktop\\Java\\ProjetoSimulado\\src\\br\\edu\\up\\docs\\Pessoas.csv");
            Scanner leitorPessoa = new Scanner(arquivoLeituraPessoa);

            

            while (leitorPessoa.hasNextLine()) {
                String linhaPessoas = leitorPessoa.nextLine();
                String[] dadosPessoas = linhaPessoas.split(";");

                int codigoPessoas = Integer.parseInt(dadosPessoas[0]);
                String nome = dadosPessoas[1];
                
                File arquivoLeituraEnderecos = new File("C:\\Users\\autologon\\Desktop\\Java\\ProjetoSimulado\\src\\br\\edu\\up\\docs\\Enderecos.csv");
                Scanner leitorEnderecos = new Scanner(arquivoLeituraEnderecos);
                
                while (leitorEnderecos.hasNextLine()) {
                    
                    String linhaEnderecos = leitorEnderecos.nextLine();
                    String[] dadosEnderecos = linhaEnderecos.split(";");

                    String rua = dadosEnderecos[0];
                    String cidade = dadosEnderecos[1];
                    int codigoEnderecos = Integer.parseInt(dadosEnderecos[2]);
                    
                    if (codigoEnderecos == codigoPessoas) {
                        Pessoa pessoa = new Pessoa(codigoEnderecos, nome, rua, cidade);
                        pessoas.add(pessoa);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo Pessoas nao encontrado!");
        }

        return pessoas;
    }

    public boolean gravar(List<Pessoa> pessoas) {
        try {
            FileWriter arquivoGravar = new FileWriter("C:\\Users\\autologon\\Desktop\\Java\\ProjetoSimulado\\src\\br\\edu\\up\\docs\\PessoasComEndereco.csv");
            PrintWriter gravador = new PrintWriter(arquivoGravar);

            for (Pessoa pessoa : pessoas) {
                gravador.println(pessoa.toCSV());
            }
            gravador.close();
            return true;

        } 
        catch (IOException e) {
            System.out.println("Não foi possível gravar o arquivo!");
        }

        return false;
    }
}