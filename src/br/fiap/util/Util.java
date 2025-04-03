package br.fiap.util;

import br.fiap.fornecedor.Fornecedor;
import br.fiap.produto.Produto;

import static javax.swing.JOptionPane.*;
import static java.lang.Long.parseLong;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;

public class Util {
    private Fornecedor[] fornecedor = new Fornecedor[5];
    private Produto[] produto = new Produto[5];
    private int idxFornecedor = 0;
    private int idxProduto = 0;

    public void opcoes() {
        int opcao = 0;
        String menu = ("1. Cadastrar produto\n2. Pesquisar produto por nome\n3. Pesquisar fornecedor por CNPJ\n4. Finalizar");

        while (true) {
            opcao = parseInt(showInputDialog(menu));
            if (opcao == 4) {
                return;
            }

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    pesquisarProduto();
                    break;
                case 3:
                    pesquisarFornecedor();
                    break;
                default:
                    showMessageDialog(null, "Opção inválida");
            }
        }
    }

    private void cadastrarProduto() {
        String nome;
        int qtdEstoque;
        double valorUnitario;

        Fornecedor fornecedor = pesquisarFornecedor();
        if (fornecedor == null) {
            fornecedor = cadastrarFornecedor();
        }

        nome = showInputDialog("Digite o nome do produto:");
        qtdEstoque = parseInt(showInputDialog("Informe a sua quantidade no estoque:"));
        valorUnitario = parseDouble(showInputDialog("Informe o valor do produto"));

        produto[idxProduto] = new Produto(nome, qtdEstoque, valorUnitario, fornecedor);
        idxProduto++;
    }

    private Fornecedor cadastrarFornecedor() {
        showMessageDialog(null, "CADASTRAR FORNECEDOR");
        String nome = showInputDialog("Digite o nome do fornecedor");
        long cnpj = parseLong(showInputDialog("Digite o CNPJ"));

        fornecedor[idxFornecedor] = new Fornecedor(nome, cnpj);
        idxFornecedor++;

        showMessageDialog(null, fornecedor[idxFornecedor-1].getNome() + " cadastrado com sucesso!");

        return fornecedor[idxFornecedor - 1];
    }

    private void pesquisarProduto() {
        String aux = "Produto não encontrado!";
        String nome = showInputDialog("Nome do produto:");

        for (int i = 0; i < idxProduto; i++) {
            if (produto[i].getNome().equalsIgnoreCase(nome)) {
                aux = "";
                aux += "Nome do produto: " + nome + "\n";
                aux += "Valor unitário: " + produto[i].getValorUnitario() + "\n";
                aux += "Fornecedor: " + produto[i].getFornecedor().getNome() + "\n";
            }
        }

        showMessageDialog(null, aux);

    }

    private Fornecedor pesquisarFornecedor() {
        long cnpj = parseLong(showInputDialog("Digite o CNPJ do fornecedor:"));
        for (int i = 0; i < idxFornecedor; i++) {
            if (cnpj == fornecedor[i].getCnpj()) {
                showMessageDialog(null, "Fornecedor: " + fornecedor[i].getNome());
                return fornecedor[i];
            }
        }
        showMessageDialog(null, "Fornecedor não cadastrado!");
        return null;
    }
}