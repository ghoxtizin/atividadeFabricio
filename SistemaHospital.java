// Classe que representa um nó da lista encadeada 
class No {
   int senha;      // armazena o número da senha
   No proximo;     // aponta para o próximo nó

   //  inicializa o nó com a senha e define o próximo como null
   public No(int senha) {
       this.senha = senha;
       this.proximo = null;
   }
}

// Implementação de uma fila usando uma lista encadeada
class Fila {
   private No inicio;  // Primeiro elemento da fila (o que será atendido)
   private No fim;     // Último elemento da fila (última senha gerada)

   //  inicia a fila vazia
   public Fila() {
       inicio = null;
       fim = null;
   }

   // Método para adicionar uma nova senha ao final da fila 
   public void enqueue(int senha) {
       No novo = new No(senha);
       if (isEmpty()) {
           inicio = novo;
           fim = novo;
       } else {
           fim.proximo = novo;
           fim = novo;
       }
   }

   // Método para remover a senha do início da fila 
   public int dequeue() {
       if (isEmpty()) {
           return -1; // Retorna -1 se a fila estiver vazia
       }
       int valor = inicio.senha;
       inicio = inicio.proximo;
       if (inicio == null) {  // Se a fila ficar vazia, atualiza o fim
           fim = null;
       }
       return valor;
   }

   // Verifica se a fila está vazia
   public boolean isEmpty() {
       return inicio == null;
   }

   // Limpa a fila (remove todos os nós)
   public void clear() {
       inicio = null;
       fim = null;
   }

   // Método para representar a fila em formato de string
   public String toString() {
       String s = "";
       No atual = inicio;
       while (atual != null) {
           s += atual.senha + " ";
           atual = atual.proximo;
       }
       return s.trim();
   }
}

// Implementação de uma estrutura para armazenar o histórico de chamadas usando uma lista encadeada
class Historico {
   private No inicio;  // Primeiro elemento do histórico

   // Construtor: inicia o histórico vazio
   public Historico() {
       inicio = null;
   }

   // Adiciona uma nova senha ao final do histórico
   public void add(int senha) {
       No novo = new No(senha);
       if (inicio == null) {
           inicio = novo;
       } else {
           No atual = inicio;
           while (atual.proximo != null) {
               atual = atual.proximo;
           }
           atual.proximo = novo;
       }
   }

   // Retorna o histórico como uma string
   public String toString() {
       String s = "";
       No atual = inicio;
       while (atual != null) {
           s += atual.senha + " ";
           atual = atual.proximo;
       }
       return s.trim();
   }
}

// Classe principal que simula o sistema de controle de senhas do hospital
public class SistemaHospital {
   private Fila fila;           // Fila de espera dos pacientes
   private Historico historico; // Histórico das senhas chamadas
   private int contador;        // Contador para gerar novas senhas

   // Construtor: inicializa a fila, o histórico e o contador
   public SistemaHospital() {
       fila = new Fila();
       historico = new Historico();
       contador = 0;
   }

   // Gera uma nova senha e a adiciona à fila de espera
   public void gerarSenha() {
       contador++;            // Incrementa o contador para nova senha
       fila.enqueue(contador); // Adiciona a nova senha ao final da fila
       System.out.println("Senha gerada: " + contador);
   }

   // Chama o próximo paciente: remove a senha do início da fila e a registra no histórico
   public void chamarProximo() {
       if (!fila.isEmpty()) {
           int senha = fila.dequeue();
           historico.add(senha);
           System.out.println("Chamando senha: " + senha);
       } else {
           System.out.println("Fila vazia, não há pacientes para chamar.");
       }
   }

   // Reinicia a contagem: limpa a fila e zera o contador
   public void reiniciarContagem() {
       fila.clear();
       contador = 0;
       System.out.println("Contagem reiniciada.");
   }

   // Exibe o histórico de chamadas
   public void exibirHistorico() {
       System.out.println("Histórico de chamadas: " + historico.toString());
   }

   // Exibe a fila atual de senhas
   public void exibirFila() {
       System.out.println("Fila atual: " + fila.toString());
   }

   // Método main para testar as funcionalidades do sistema
   public static void main(String[] args) {
       SistemaHospital sistema = new SistemaHospital();

       // Gerando senhas para os pacientes
       sistema.gerarSenha(); // Senha 1
       sistema.gerarSenha(); // Senha 2
       sistema.gerarSenha(); // Senha 3

       sistema.exibirFila(); // Exibe: 1 2 3

       // Chamando os pacientes
       sistema.chamarProximo(); // Chama senha 1
       sistema.chamarProximo(); // Chama senha 2

       sistema.exibirHistorico(); // Histórico: 1 2
       sistema.exibirFila();      // Fila: 3

       // Gerando mais senhas
       sistema.gerarSenha(); // Senha 4
       sistema.gerarSenha(); // Senha 5

       sistema.exibirFila(); // Exibe: 3 4 5

       // Chamando os pacientes restantes
       sistema.chamarProximo(); // Chama senha 3
       sistema.chamarProximo(); // Chama senha 4
       sistema.chamarProximo(); // Chama senha 5
       sistema.chamarProximo(); // Fila vazia, não chama ninguém

       sistema.exibirHistorico(); // Histórico: 1 2 3 4 5

       // Reiniciando a contagem
       sistema.reiniciarContagem();
       sistema.exibirFila(); // Fila vazia
   }
}
