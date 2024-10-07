class MalhaAerea {
    Aeroporto[] aeroportos;
    int numAeroportos;

    public MalhaAerea(int capacidade) {
        aeroportos = new Aeroporto[capacidade];
        numAeroportos = 0;
    }

    // Cadastrar um novo aeroporto
    public void cadastrarAeroporto(String nome, int codigo) {
        aeroportos[numAeroportos] = new Aeroporto(nome, codigo);
        numAeroportos++;
    }

    // Encontrar o índice de um aeroporto pelo código
    public int buscarAeroportoPorCodigo(int codigo) {
        for (int i = 0; i < numAeroportos; i++) {
            if (aeroportos[i].codigo == codigo) {
                return i;
            }
        }
        return -1; //não encotrou
    }

    // Cadastrar um voo entre dois aeroportos
    public void cadastrarVoo(int codigoOrigem, int codigoDestino, int numeroVoo) {
        if(codigoOrigem == codigoDestino){
            System.out.println(" erro : origem = destino, abortar");
        }
        int indiceOrigem = buscarAeroportoPorCodigo(codigoOrigem);
        int indiceDestino = buscarAeroportoPorCodigo(codigoDestino);
        if (indiceOrigem != -1 && indiceDestino != -1) {
            aeroportos[indiceOrigem].voosPartindo.adicionarVoo(codigoOrigem, codigoDestino, numeroVoo);
            aeroportos[indiceDestino].voosChegando.adicionarVoo(codigoOrigem, codigoDestino, numeroVoo);
        }
    }

    // Remover um voo pelo número
    public void removerVoo(int codigoOrigem, int numeroVoo) {
        int indiceOrigem = buscarAeroportoPorCodigo(codigoOrigem);

        if (indiceOrigem != -1) {
            aeroportos[indiceOrigem].voosPartindo.removerVoo(numeroVoo);
        }
    }

    // Listar todos os voos saindo de um aeroporto
    public void listarVoos(int codigoOrigem) {
        int indiceOrigem = buscarAeroportoPorCodigo(codigoOrigem);

        if (indiceOrigem != -1) {
            System.out.println("Voos saindo de " + aeroportos[indiceOrigem].nome + ":");
            aeroportos[indiceOrigem].voosPartindo.listarVoos(obterNomesAeroportos());
        }
    }

    // retorna um array para usar em outros métodos
    public String[] obterNomesAeroportos() {
        String[] nomes = new String[numAeroportos];
        for (int i = 0; i < numAeroportos; i++) {
            nomes[i] = aeroportos[i].nome;
        }
        return nomes;
    }

    // retorna uma array para o terminal
    public void exibirAeroportos() {
        System.out.println("=== Aeroportos Cadastrados ===");
        
        // Verifica se existem aeroportos cadastrados
        if (numAeroportos == 0) {
            System.out.println("Nenhum aeroporto cadastrado.");
            return;
        }
    
        // Percorre e exibe os aeroportos cadastrados
        for (int i = 0; i < numAeroportos; i++) {
            Aeroporto aeroporto = aeroportos[i];
            System.out.println(aeroporto.codigo + " - " + aeroporto.nome);
        }
    }
    

    // Listar trajetos possíveis de um aeroporto até outro (diretos ou indiretos)
    public void listarTrajetos(int codigoOrigem, int codigoDestino) {
    Aeroporto origem= new Aeroporto(codigoOrigem);
    Aeroporto destino = new Aeroporto(codigoDestino);

    //passo1 verifica se tem conexão direta

    //criador do objeto aeroporto origem
    for (int i = 0; i < numAeroportos; i++) {
        if (aeroportos[i].codigo == codigoOrigem) {
             origem = aeroportos[i];
        }
    }
    //criador do objeto aeroporto destino
    for (int j = 0; j < numAeroportos; j++) {
            if (aeroportos[j].codigo == codigoDestino) {
             destino = aeroportos[j];
            }
    }

    //verificador de ambas as listas de voos dos aeroportos
    for (int s = 0; s < origem.voosPartindo.tamanho; s++ ){
        for (int y = 0; y < destino.voosChegando.tamanho; y++){
            if(origem.voosPartindo.obterVooPorPosicao(s).numeroVoo == destino.voosChegando.obterVooPorPosicao(y).numeroVoo){
                System.out.println("Existe uma conexão direta entre esses aeroportos através do Voo " + origem.voosPartindo.obterVooPorPosicao(s).numeroVoo);
                return;
            }
        }
    }

    //passo2 verifica se existe um aeroporto que tenha como chegada o primeiro voo, e saida com destino o segundo aeroporto
    for (int a = 0; a < numAeroportos; a++) {
        Aeroporto aeroportoMeio = aeroportos[a];
        if (aeroportoMeio.codigo != destino.codigo & aeroportoMeio.codigo != origem.codigo){
            for(int h = 0; h < aeroportoMeio.voosChegando.tamanho; h++){
                System.out.println(aeroportoMeio.voosChegando.obterVooPorPosicao(h).indiceOrigem + "---" + origem.codigo);
                if (aeroportoMeio.voosChegando.obterVooPorPosicao(h).indiceOrigem == origem.codigo){
                    for(int l = 0; l < aeroportoMeio.voosPartindo.tamanho; l++){
                        if(aeroportoMeio.voosPartindo.obterVooPorPosicao(l).indiceDestino == destino.codigo){
                            System.out.println("Conexão existente: Voo " + aeroportoMeio.voosChegando.obterVooPorPosicao(h).numeroVoo + " entre " + origem.nome + " e " + aeroportoMeio.nome + ", depois Voo " + aeroportoMeio.voosPartindo.obterVooPorPosicao(l).numeroVoo + " para " + destino.nome);
                            return;
                        }
                    }
                }
            
        }
    }

    //passo 3 não tendo bem sucedido anteriormente, a partir da lista dos aeroportos conectados ao primeiro 
    //procura os aeroportos com conexoes a estes para entao verificar conexoes com aeroporto final
   /*  int[] arrayPartidasDestinos = new int[10];
    int colocador = 0;
    for(int o = 0; o < origem.voosPartindo.tamanho; o++ ){
        int colocar = origem.voosPartindo.obterVooPorPosicao(o).indiceDestino;
      arrayPartidasDestinos[colocador] = colocar;
      colocador++;
    }
    for(int b = 0; b < numAeroportos; b++){
       for(int c = 0; c <arrayPartidasDestinos.length; c++){
        if (aeroportos[b].codigo == arrayPartidasDestinos[c]){
            Aeroporto aeroportoMeio2 = aeroportos[b];
            if (aeroportoMeio2.codigo != destino.codigo & aeroportoMeio2.codigo != origem.codigo){
                for(int d = 0; d < aeroportoMeio2.voosChegando.tamanho; d++){
                    //System.out.println(aeroportoMeio2.voosChegando.obterVooPorPosicao(d).indiceOrigem + "---" + origem.codigo);
                    if (aeroportoMeio2.voosChegando.obterVooPorPosicao(d).indiceOrigem == origem.codigo){
                        for(int l = 0; l < aeroportoMeio2.voosPartindo.tamanho; l++){
                            if(aeroportoMeio2.voosPartindo.obterVooPorPosicao(l).indiceDestino == destino.codigo){
                                System.out.println("Conexão existente: Voo " + aeroportoMeio2.voosChegando.obterVooPorPosicao(d).numeroVoo + " entre " + origem.nome + " e " + aeroportoMeio2.nome + ", depois Voo " + aeroportoMeio2.voosPartindo.obterVooPorPosicao(l).numeroVoo + " para " + aeroportoMeio2.nome + " depois " + aeroportoMeio2.voosPartindo.obterVooPorPosicao(l).numeroVoo + " para " + destino.nome);
                            }
                        }
                    }
                */
            }
        }
        }
        
