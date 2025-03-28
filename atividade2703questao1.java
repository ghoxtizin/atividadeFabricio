// Classe que representa um nó (elemento) da pilha
class No {
    String pagina;  // Armazena o endereço da página
    No proximo;     // Aponta para o próximo nó na pilha

    // recebe o endereço da página
    public No(String pagina) {
        this.pagina = pagina;
        this.proximo = null; // inicialmente, o nó não aponta para nenhum outro
    }
}

// Classe que implementa a pilha usando uma lista encadeada
class Pilha {
    private No topo; // Referência para o topo da pilha

    // Construtor que inicia a pilha vazia
    public Pilha() {
        topo = null;
    }

    // Método para empurrar (push) uma nova página para o topo da pilha
    public void push(String pagina) {
        No novoNo = new No(pagina); // Cria um novo nó com a página
        novoNo.proximo = topo;       // O novo nó aponta para o antigo topo
        topo = novoNo;               // Atualiza o topo para o novo nó
    }

    // Método para remover (pop) a página do topo da pilha
    public String pop() {
        if (topo == null) { // Se a pilha estiver vazia, retorna null
            return null;
        }
        String pagina = topo.pagina; // Guarda a página que está no topo
        topo = topo.proximo;         // Atualiza o topo para o próximo nó
        return pagina;               // Retorna a página removida
    }

    // Método que verifica se a pilha está vazia
    public boolean isEmpty() {
        return topo == null;
    }

    // Método para limpar a pilha (eliminar todos os nós)
    public void clear() {
        topo = null;
    }
}

// Classe que simula o navegador com os botões de voltar e avançar
class Navegador {
    private Pilha voltar;   // Pilha para armazenar as páginas para "voltar"
    private Pilha avancar;  // Pilha para armazenar as páginas para "avançar"

    // Construtor que inicia o navegador com as duas pilhas vazias
    public Navegador() {
        voltar = new Pilha();
        avancar = new Pilha();
    }

    // Método para adicionar uma nova página no navegador
    public void adicionarPagina(String pagina) {
        // Ao navegar para uma nova página, a pilha de avançar deve ser limpa
        avancar.clear();
        // Empurra a nova página para a pilha de voltar
        voltar.push(pagina);
        System.out.println("Página atual: " + pagina);
        exibirBotoes();
    }

    // Método que simula clicar no botão "voltar"
    public void voltar() {
        // Se a pilha de voltar não estiver vazia, remove o topo
        if (!voltar.isEmpty()) {
            String pagina = voltar.pop();
            // Empurra essa página para a pilha de avançar
            avancar.push(pagina);
            System.out.println("Voltando para a página: " + pagina);
        } else {
            System.out.println("Não há páginas para voltar.");
        }
        exibirBotoes();
    }

    // Método que simula clicar no botão "avançar"
    public void avancar() {
        // Se a pilha de avançar não estiver vazia, remove o topo
        if (!avancar.isEmpty()) {
            String pagina = avancar.pop();
            // Empurra essa página de volta para a pilha de voltar
            voltar.push(pagina);
            System.out.println("Avançando para a página: " + pagina);
        } else {
            System.out.println("Não há páginas para avançar.");
        }
        exibirBotoes();
    }

    // Método auxiliar para exibir o estado (ativado ou desativado) dos botões
    private void exibirBotoes() {
        if (voltar.isEmpty()) {
            System.out.println("Botão Voltar desativado.");
        } else {
            System.out.println("Botão Voltar ativado.");
        }
        if (avancar.isEmpty()) {
            System.out.println("Botão Avançar desativado.");
        } else {
            System.out.println("Botão Avançar ativado.");
        }
    }

    // Método principal para testar o comportamento do navegador
    public static void main(String[] args) {
        Navegador navegador = new Navegador();
        
        // Adiciona páginas, simulando navegação
        navegador.adicionarPagina("Página Inicial");
        navegador.adicionarPagina("Página 1");
        navegador.adicionarPagina("Página 2");
        
        // Testa as operações de voltar e avançar
        navegador.voltar();   // Deveria voltar para "Página 1"
        navegador.voltar();   // Deveria voltar para "Página Inicial"
        navegador.avancar();  // Deveria avançar para "Página 1"
        navegador.avancar();  // Deveria avançar para "Página 2"
    }
}
