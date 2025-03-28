# Navegador - Sistema de Navegação com Botões de Voltar e Avançar

## 1. Introdução

### Descrição do Problema:
O sistema simula a funcionalidade dos botões de "voltar" e "avançar" de um navegador, utilizando pilhas para controlar a navegação entre páginas. O desafio consiste em implementar a navegação, com a funcionalidade de adicionar páginas, voltar, avançar e gerenciar o estado dos botões com base nas pilhas.

### Visão Geral do Programa:
O programa utiliza duas pilhas:
- **Pilha de Voltar:** Armazena as páginas que o usuário visitou anteriormente.
- **Pilha de Avançar:** Armazena as páginas para as quais o usuário pode avançar após clicar no botão "voltar".

### Funcionalidades:
- Adicionar páginas ao navegador.
- Voltar para páginas anteriores.
- Avançar para páginas que foram "voltadas".
- Ativar/desativar os botões de "voltar" e "avançar" conforme o estado das pilhas.

---

## 2. Implementação

### Estruturas de Dados Utilizadas:
#### Lista Encadeada (Classe `No`):
Cada nó armazena um valor (o endereço da página) e uma referência para o próximo nó, formando uma lista encadeada.

#### Pilha (Classe `Pilha`):
A pilha é implementada com a lista encadeada. O método `push()` adiciona páginas ao topo, e `pop()` remove páginas do topo.

### Funcionalidades Principais:
- **adicionarPagina(String pagina):** Adiciona uma nova página ao navegador.
- **voltar():** Retorna à página anterior (última página visitada).
- **avancar():** Avança para a página seguinte (última página voltada).
- **exibirBotoes():** Exibe o estado atual dos botões de voltar e avançar (ativados ou desativados).

### Formato de Entrada e Saída:
- **Entrada:** O usuário interage com o sistema chamando os métodos de navegação.
- **Saída:** Mensagens indicam a navegação, como "Voltando para a página X" ou "Avançando para a página Y". Também é mostrado o estado dos botões.

---

## 3. Testes Executados

### Teste 1: Navegação e Voltar
- **Ação:** Adiciona páginas e simula o botão "voltar".
- **Resultado Esperado:** As páginas são visitadas e o "voltar" funciona corretamente.

### Teste 2: Navegação e Avançar
- **Ação:** Após voltar, avança para as páginas anteriores.
- **Resultado Esperado:** O "avançar" funciona como esperado, avançando para a página seguinte.

### Teste 3: Estado dos Botões
- **Ação:** Verifica se os botões de "voltar" e "avançar" são ativados/desativados corretamente.
- **Resultado Esperado:** Os botões são ativados quando possível e desativados quando não há mais páginas para voltar ou avançar.

---

## 4. Conclusão

### Comentários Gerais:
O sistema é uma implementação simples que demonstra como gerenciar a navegação de páginas em um navegador utilizando pilhas. A estrutura FIFO (First In, First Out) é eficaz para lidar com as operações de "voltar" e "avançar", mantendo o controle das páginas de maneira clara e eficiente.

### Dificuldades Encontradas:
- Gerenciar o estado das pilhas e garantir que as operações de voltar e avançar fossem realizadas corretamente.

---

## 5. Bibliografia
- **Documentação Java**: [Oracle Java Documentation](https://docs.oracle.com/javase/8/docs/)
- **Estruturas de Dados**: Weiss, Mark Allen. "Data Structures and Algorithm Analysis in Java."
- **Tutoriais e Exemplos**: Sites e fóruns de programação que auxiliaram na implementação de listas encadeadas e pilhas.

---



# Sistema de Controle de Senhas para Atendimento Hospitalar

Este projeto implementa um sistema de controle de senhas para gerenciar a fila de atendimento em hospitais, utilizando listas encadeadas sem bibliotecas externas.

## Funcionalidades
- Gerar senhas sequenciais
- Chamar o próximo paciente (removendo da fila)
- Manter um histórico das senhas chamadas
- Reiniciar a contagem de senhas

## Estrutura de Dados
A implementação utiliza **listas encadeadas** para representar a fila e o histórico de chamadas. Cada nó contém um número de senha e um ponteiro para o próximo nó.

## Código Exemplo
```java
class No {
    int dado;
    No proximo;
    
    public No(int dado) {
        this.dado = dado;
        this.proximo = null;
    }
}

class Fila {
    No inicio, fim;
    
    public void adicionar(int dado) {
        No novoNo = new No(dado);
        if (fim != null) fim.proximo = novoNo;
        fim = novoNo;
        if (inicio == null) inicio = novoNo;
    }
}
```

## Como Usar
1. Clone o repositório
2. Compile e execute o código Java
3. Utilize os métodos disponíveis para gerar senhas e gerenciar a fila

## Contribuição
Sinta-se à vontade para abrir issues e pull requests para melhorias!

## Licença
Este projeto está sob a licença MIT.
