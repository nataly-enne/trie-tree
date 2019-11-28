# Tree Trie
>  Implementação de uma estrutura de dados chamada _trie_, também conhecida como árvore digital, para a disciplina de Estruturas de Dados Básicas II, ministrada pelo professor Waldson Patricio, no Instituto Metrópole Digital, na Universidade Federal do Rio Grande do Norte.

# What is it? 
Uma árvore digital é uma árvore genérica onde cada nó pode ter quaisquer quantidade de filhos. Ela é utilizada para armazenar palavras que podem ser pesquisadasa partir de um prefixo comum. Esta propriedade faz dela uma estrutura eficiente
para completar palavras.

### Funcionamento:
Supondo que queremos armazenar as seguintes palavras: `a, ama, amar, ame, amei, ameixa, oi, oito, eu, ele, ela, eles, elas`. Ao invés de armazenar as palavras diretamente, uma trie armazena o caminho da raiz até a palavra dividindo-a em seus caracteres.

# Compilação:

```bash
  java -jar tree-trie.jar palavras.txt [prefixo] 
```
Onde:
- `prefixo:` é uma string que deve ser utilizada na busca

#### Exemplo:
```bash
  java -jar tree-trie.jar palavras.txt am 
```
