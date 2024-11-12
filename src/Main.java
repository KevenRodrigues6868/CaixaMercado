import java.util.ArrayList;

abstract class Produto {
    final float MINIMUM = 0;
    String name;
    int codigo;
    float valor;
    
    // Ajuste para calcular o valor
    float calcValor() {
        return valor; // Retorna o valor atribuído
    }
    
    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + name + " " + valor;
    }
}

class Alimento extends Produto {
    String validadeAlimento;
    
    Alimento(String name, int codigo, float valor, String validadeAlimento) {
        this.name = name;
        this.codigo = codigo;
        this.valor = valor; // Atribui o valor ao produto
        this.validadeAlimento = validadeAlimento;
    }

    // Sobrescreve o calcValor para Alimento, mas pode usar a lógica de valor diretamente
    @Override
    float calcValor() {
        return valor; // Pode implementar outras lógicas de cálculo, se necessário
    }
}

class Utensilios extends Produto {
    String validadeUten;
    
    Utensilios(String name, int codigo, float valor, String validadeUten) {
        this.name = name;
        this.codigo = codigo;
        this.valor = valor; // Atribui o valor ao produto
        this.validadeUten = validadeUten;
    }

    // Sobrescreve o calcValor para Utensílios
    @Override
    float calcValor() {
        return valor; // Lógica para utensílios
    }
}

class Eletroeletronicos extends Produto {
    String garantia;
    
    Eletroeletronicos(String name, int codigo, float valor, String garantia) {
        this.name = name;
        this.codigo = codigo;
        this.valor = valor; // Atribui o valor ao produto
        this.garantia = garantia;
    }

    // Sobrescreve o calcValor para Eletroeletrônicos
    @Override
    float calcValor() {
        return valor; // Lógica para eletroeletrônicos
    }
}

class ProdutosList {
    private ArrayList<Produto> produtos = new ArrayList<>();
    
    void addProduto(Produto produto) {
        produtos.add(produto);
    }
    
    void printProduto() {
        float totalCalc = 0;
        // Estrutura que irá percorrer a lista de produtos
        for (Produto produto : produtos) {
            // Printando todos os produtos cadastrados
            System.out.println(produto);
            // Faz o cálculo total do valor dos produtos
            totalCalc += produto.calcValor();
        }
        System.out.println("\nTotal de itens na loja: " + totalCalc);
    }
}

class ProdutoFactory {
    static Produto tipodeProduto(int action, String name, int codigo, float valor, String validadeAlimento, String validadeUten, String garantia) {
        switch (action) {
            case 1: // Alimento
                return new Alimento(name, codigo, valor, validadeAlimento);
            case 2: // Utensílio
                return new Utensilios(name, codigo, valor, validadeUten);
            case 3: // Eletroeletrônico
                return new Eletroeletronicos(name, codigo, valor, garantia);
            default:
                throw new IllegalArgumentException("Valor Inserido Invalido");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ProdutosList produtoList = new ProdutosList();

        // Aqui, estamos criando produtos com valores diferentes
        produtoList.addProduto(ProdutoFactory.tipodeProduto(1, "Bolacha Rancheiro", 1, 10.50f, "45 dias", null, null));
        produtoList.addProduto(ProdutoFactory.tipodeProduto(2, "Colher", 2, 5.20f, null, "360 dias", null));
        produtoList.addProduto(ProdutoFactory.tipodeProduto(3, "Sanduicheira", 3, 120.75f, null, null, "2 anos"));

        // Exibe todos os produtos e o total de valores
        produtoList.printProduto();
    }
}
