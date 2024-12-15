# Sistema de Gerenciamento de Aeroportos e Voos

## Descrição
Este é um projeto desenvolvido em **Java** que utiliza a estrutura de dados **Grafos** com listas de adjacência para gerenciar voos e aeroportos. O programa oferece um menu interativo para adicionar e remover voos, listar aeroportos e trajetos, proporcionando uma solução eficiente para o gerenciamento de rotas aéreas.

## Funcionalidades
| Opção do Menu | Descrição                                     |
|-------------------|-------------------------------------------------|
| **1**             | Adicionar um novo aeroporto                    |
| **2**             | Adicionar um novo voo                          |
| **3**             | Remover um voo existente                       |
| **4**             | Listar todos os aeroportos                     |
| **5**             | Listar todos os voos de um aeroporto           |
| **6**             | Listar trajetos entre dois aeroportos          |
| **7**             | Encerrar o programa                            |

## Tecnologias Utilizadas
- **Java**
- **Estruturas de Dados** (Grafos com listas de adjacência)
- **VSCode** como IDE

## Execução do Projeto

### 1. Configuração do Ambiente
- Certifique-se de que o **Java JDK** esteja instalado.
- Instale a **extensão de Java** para o **VSCode**, caso ainda não tenha feito isso.

### 2. Clone o Repositório
```bash
git clone https://github.com/tiaguinzero/Grafos_ListaAdjacencia.git
cd Grafos_ListaAdjacencia
```

### 3. Compile e Execute o Projeto
1. Abra o projeto na **IDE VSCode**.
2. Compile o programa:
   ```bash
   javac Main.java
   ```
3. Execute o programa:
   ```bash
   java Main
   ```

## Estrutura do Projeto
```
projeto-aeroportos/
├── Main.java            # Arquivo principal que executa o menu
├── Grafo.java           # Implementação da estrutura de grafos
├── ListaEncadeada.java  # complementa o grafo com a Lista de Adjacencia 
├── Aeroporto.java       # Classe que representa um aeroporto
└── Voo.java             # Classe que representa um voo
├── README.md                # Documentação do projeto
└── .gitignore               # Arquivos e pastas ignorados pelo Git
```

## Exemplo de Uso
Ao executar o programa, o menu abaixo será exibido:
```plaintext
=== Sistema de Gerenciamento de Voos ===
1. Adicionar aeroporto
2. Adicionar voo
3. Remover voo
4. Listar aeroportos
5. Listar voos de um aeroporto
6. Listar trajetos entre aeroportos
7. Sair
Escolha uma opção:
```
Basta escolher a opção desejada e seguir as instruções fornecidas pelo programa.

## Contribuição
1. Realize um fork do repositório.
2. Crie uma branch para sua feature/bugfix:
   ```bash
   git checkout -b minha-feature
   ```
3. Realize suas alterações e faça o commit:
   ```bash
   git commit -m "Minha nova feature"
   ```
4. Envie suas alterações para o repositório remoto:
   ```bash
   git push origin minha-feature
   ```
5. Abra um pull request.

## Licença
Este projeto está licenciado sob a [MIT License](LICENSE).

