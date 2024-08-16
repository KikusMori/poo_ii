
### Atividade POO II - Petisko

---

## Apresentação do Projeto:

Este projeto é uma aplicação para gerenciar doações de animais. Ele permite que os usuários cadastrem animais para adoção, visualizem animais disponíveis e registrem adoções.

---

### Tutorial

## 1. Clonagem do Repositório:

   # Pode-se usar este código para executar a clonagem do repositório.
   
    
   ```bash
      git clone https://github.com/usuario/poo_ii.git
   ```

   # Ou usar o GitHub Desktop e clonar através da url.
   
   ```bash
   https://github.com/KikusMori/poo_ii
   ```

---

## 2. Banco de Dados:

Execute o script SQL para criar as tabelas e inserir os dados:
   
   ```bash
   mysql -u usuario -p < C:\caminho_do_arquivo\db.sql
   ```
**Observação 1: Você poderá encontrar o arquivo "db.sql" neste caminho:

```bash
   https://github.com/KikusMori/poo_ii/blob/master/src/main/java/IFG/db.sql
```

**Observação 2:** Substitua `usuario` pelas suas credenciais.

---

## 3. Conexão:

   No arquivo "banco.java", troque o usuário e a senha que estão pré-definidos pelas informações que você definiu:
   ```bash 
     return DriverManager.getConnection("jdbc:mysql://localhost:3306/petisko","megauser","mysql123");
   ```

---

## 4. Execução:

   Utilize o arquivo "Aplicacap.java" para executar o código.
   Após executá-lo, aparecerá as seguintes informações:
   
   ```bash
      Menu:
       (1) C -> Create
       (2) R -> Select
       (3) U -> Update
       (4) D -> Delete
       Escolha uma opção: 
   ```
   Agora você poderá escolher uma das 4 opções através do número indicador, neste caso sendo o 1, 2, 3 ou 4. Contudo, cada umas destas opções apresentará um outro menu que perguntará para tabela do banco você deseja executar a ação escolhida. Este "novo" menu seguirá a mesma lógica de utilizar os números apresentados para selecionar.
   Por fim, depois de escolher a ação e a tabela a ser utilizada, preencha os dados requisitados e estará pronto a execução e comunicação com o banco de dados!
   
---
### Autores:

Lucas Rodrigues & Yuri Rodrigues;
Última Atualização: 15/08/2024;

### Acabou :D


