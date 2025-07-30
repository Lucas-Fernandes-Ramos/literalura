# 📚 LiterAlura - Projeto API Gutendex

Este é um projeto Spring Boot que consome a [API pública Gutendex](https://gutendex.com/), armazena os dados em um banco PostgreSQL e fornece funcionalidades para consulta e filtragem de livros e autores.

---

## 🚀 Funcionalidades

O sistema apresenta um **menu interativo** com as seguintes opções:

```text
1 - Buscar Livro pelo Título na Web
2 - Listar Livros Registrados
3 - Listar Autores Registrados
4 - Buscar Autor vivo em determinado ano
5 - Buscar Livro pelo idioma
0 - Sair

## 🛠️ Tecnologias Utilizadas

- **Java 17+**  
  Linguagem principal do projeto, utilizada com recursos modernos como `record`, `switch` aprimorado e Stream API.

- **Spring Boot 3.x**  
  Framework que facilita a criação de aplicações Java com configuração mínima e servidor embutido.

- **Spring Data JPA**  
  Abstração de persistência baseada no padrão JPA, com suporte ao Hibernate, queries automáticas e repositórios.

- **PostgreSQL**  
  Banco de dados relacional utilizado para armazenar os livros e autores da aplicação.

- **Jackson**  
  Biblioteca de serialização e desserialização de objetos Java para JSON, essencial para consumir APIs externas.

- **RestTemplate**  
  Cliente HTTP fornecido pela Spring Framework, usado para consum


### 1. Pré-requisitos

- Java 17+
- PostgreSQL
- Maven

### 2. Configurar o banco PostgreSQL

```sql
CREATE DATABASE literalura_db;
spring.datasource.url=jdbc:postgresql://localhost:5432/literalura_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

./mvnw spring-boot:run
## 📚 Detalhamento das opções do menu

### 1️⃣ Buscar Livro pelo Título na Web

Consulta o título digitado na [API Gutendex](https://gutendex.com/), converte os dados em entidades (`Livro`, `Autor`) e salva no banco, caso ainda não exista.

---

### 2️⃣ Listar Livros Registrados

Exibe todos os livros armazenados no banco de dados com as seguintes informações:

- Título  
- Autor  
- Idioma  
- Número de downloads

---

### 3️⃣ Listar Autores Registrados

Mostra a lista completa de autores registrados, com:

- Nome  
- Ano de nascimento  
- Ano de falecimento

---

### 4️⃣ Buscar Autor vivo em determinado ano

Recebe um ano como entrada (ex: `1900`) e retorna todos os autores que:

- Nasceram antes ou no ano informado  
- Ainda estavam vivos naquele ano (ou seja, sem data de falecimento ou posterior ao ano informado)

---

### 5️⃣ Buscar Livro pelo idioma

Permite filtrar e listar os livros por idioma. Os idiomas disponíveis são controlados por um `enum`, como:

- `EN` (Inglês)  
- `PT` (Português)  
- `ES` (Espanhol)  
- `FR` (Francês)  
-  
- ...

---

### 0️⃣ Sair

Encerra o menu interativo ou a execução da aplicação no terminal.

## 📚 Materiais de Apoio e Documentação

Caso deseje aprofundar seus conhecimentos ou personalizar o projeto LiterAlura, aqui estão links úteis e oficiais sobre as tecnologias utilizadas:

### 🔗 Documentações Oficiais

- 📘 [Java 17+](https://dev.java/learn/)  
  Guia oficial de aprendizado da linguagem Java com foco em boas práticas modernas.

- 🌱 [Spring Boot](https://spring.io/projects/spring-boot)  
  Framework principal da aplicação, com guia de criação, estrutura e auto-configuração.

- 🗃️ [Spring Data JPA](https://spring.io/projects/spring-data-jpa)  
  Documentação para trabalhar com persistência de dados em bancos relacionais com ORM.

- 🌐 [RestTemplate](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/client/RestTemplate.html)  
  Cliente HTTP usado para consumir a API do Gutendex.

- 🐘 [PostgreSQL](https://www.postgresql.org/docs/)  
  Documentação oficial do banco de dados usado no projeto.

- 🔄 [Jackson (JSON)](https://github.com/FasterXML/jackson)  
  Biblioteca para serialização e desserialização de objetos Java ↔ JSON.

---

### 📘 Tutoriais e Guias Recomendados

- 🎓 [Guia Spring Boot para Iniciantes - Alura](https://www.alura.com.br/artigos/spring-boot)  
  Explicação acessível sobre como o Spring Boot funciona.

- 💻 [Como usar Spring Data JPA na prática](https://www.baeldung.com/the-persistence-layer-with-spring-data-jpa)  
  Tutorial completo com exemplos práticos.

- 🔧 [CRUD com Spring Boot, JPA e PostgreSQL (YouTube)](https://www.youtube.com/results?search_query=spring+boot+jpa+postgresql+crud)  
  Busque vídeos de referência com exemplos visuais passo a passo.

- 📖 [API Gutendex - Documentação JSON](https://gutendex.com/)  
  Acesso direto à API pública usada para obter os livros do Projeto Gutenberg.

---

### 👨‍🏫 Cursos Recomendados

- [Formação Java + Spring da Alura](https://www.alura.com.br/formacao-java-spring)  
- [Java Backend Developer (Oracle Next Education)](https://www.oracle.com/br/education/oracle-next-education/)

---

### 🤝 Comunidades e Fóruns

- [Stack Overflow - Spring Boot](https://stackoverflow.com/questions/tagged/spring-boot)  
- [Spring Boot no Reddit](https://www.reddit.com/r/SpringBoot/)  
- [Comunidade Java Brasil (Discord e Telegram)](https://javadevbrasil.com.br)

---

> 💬 Se você deseja contribuir com o projeto ou aprender mais sobre alguma parte específica, fique à vontade para abrir issues ou sugestões!


## 👨‍💻 Desenvolvido por

Projeto desenvolvido por **Lucas Fernandes Ramos**, com base na proposta **LiterAlura** do programa [ONE - Oracle Next Education + Alura](https://www.alura.com.br/empresas/oracle-next-education).

> 💡 Este projeto tem fins educacionais e demonstra o uso de Spring Boot, JPA e consumo de APIs REST em aplicações reais.
