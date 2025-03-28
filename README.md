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
