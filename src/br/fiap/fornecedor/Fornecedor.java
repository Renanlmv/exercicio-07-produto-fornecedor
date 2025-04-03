package br.fiap.fornecedor;

public class Fornecedor {

    private String nome;
    private long cnpj;

    public Fornecedor(String nome, long cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }
    // atalho para gerar get e set é Alt + Insert
    // método de acesso é sempre público
    // get - não recebe parâmetro
    public String getNome() {
        return nome;
    }

    // set - recebe como parâmetro o valor que vai ser alterado
    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }
}
