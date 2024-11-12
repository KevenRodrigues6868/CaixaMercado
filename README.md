
# Sistema de Caixa de Supermercado

Este é um projeto acadêmico de um sistema de caixa para um supermercado, implementado em Java. 
O sistema permite o gerenciamento de produtos e operações de caixa, incluindo abertura e fechamento 
de caixa, registro de vendas e atualização de estoque.

## Funcionalidades

### Cadastro de Produtos
- **Tipos de Produtos**:
  - **Alimentos**: Inclui código, nome, preço por unidade e validade (em dias).
  - **Utensílios**: Inclui código, nome, preço por unidade e validade.
  - **Eletroeletrônicos**: Inclui código, nome, preço por unidade e garantia (tempo de validade da garantia).
- Os produtos cadastrados são armazenados em uma `ArrayList` e incluem unidades em estoque.

### Busca de Produtos
- Sistema de busca de produtos por nome ou código, utilizando o método `contains` para facilitar a pesquisa.

### Remoção de Produtos
- Permite a remoção de um produto do sistema usando seu código.

### Operação de Caixa
- **Abertura de Caixa**: Inicia o caixa com um valor específico.
- **Registro de Vendas**:
  - Permite iniciar uma nova venda, onde os produtos são adicionados ao carrinho, somando o total da venda e exibindo o subtotal a cada adição.
  - Durante a venda, permite a exclusão de itens adicionados no caixa.
  - Ao encerrar a compra, exibe o resumo dos itens com quantidades e valores totais.
  - O sistema permite iniciar uma nova venda após finalizar uma.

### Atualização de Estoque
- A cada venda realizada, o estoque é atualizado automaticamente, debitando as unidades vendidas.

### Fechamento de Caixa
- Calcula o total das vendas finalizadas, exibindo o valor inicial e o saldo final do caixa. O lucro é calculado e exibido como parte do fechamento.

### Aba do Gestor
- **Validade de Produtos**: Verifica os produtos cuja validade está dentro de um período especificado (por exemplo, até 20 dias).
- **Quantidade de Estoque**: Permite verificar produtos com baixo estoque, auxiliando no planejamento de reposição.

## Exemplo de Código

```java
// Cadastro de produtos e exibição
produtoList.addProduto(ProdutoFactory.tipodeProduto(1, "Bolacha Rancheiro", 1, 10.50f, "45 dias", null, null));
produtoList.addProduto(ProdutoFactory.tipodeProduto(2, "Colher", 2, 5.20f, null, "360 dias", null));
produtoList.addProduto(ProdutoFactory.tipodeProduto(3, "Sanduicheira", 3, 120.75f, null, null, "2 anos"));

// Exibição dos produtos cadastrados e total de valores
produtoList.printProduto();
```

## Estrutura de Classes

- **Produto**: Classe abstrata base para os produtos.
- **Alimento, Utensílios, Eletroeletrônicos**: Classes derivadas que representam cada tipo específico de produto.
- **ProdutoFactory**: Fábrica para criar instâncias de produtos.
- **ProdutosList**: Gerencia a lista de produtos, incluindo adição, impressão e cálculo do valor total dos produtos.
- **Main**: Classe principal onde o sistema é inicializado e testado.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **ArrayList**: Estrutura de dados utilizada para armazenamento e manipulação dos produtos.
