<h1 align="center">📚 Sistema de Controle de Biblioteca Escolar</h1>

<p align="center">
  Um sistema moderno para gerenciamento de biblioteca escolar como projeto de trabalho de faculdade 📖<br>
  Controle de livros, alunos e empréstimos de forma simples e eficiente.
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white"/>
  <img src="https://img.shields.io/badge/Arquitetura-MVC-blue?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/status-%20pronto-yellow?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/license-MIT-green?style=for-the-badge"/>
</p>

---

## ✨ Visão Geral

Este projeto foi desenvolvido com foco em **organização, boas práticas e evolução de arquitetura**, começando com uma versão simples e evoluindo para o padrão **MVC**.

---

## 🚀 Funcionalidades

- 📖 Cadastro de livros  
- 👨‍🎓 Cadastro de alunos  
- 🔄 Empréstimos e devoluções  
- 📊 Consulta de livros emprestados  
- 📋 Alunos com pendências  

---

## 🧱 Modelagem do Sistema

### 📘 Livro

| Campo | Tipo | Descrição |
|------|------|----------|
| id | int | Identificador único |
| titulo | String | Nome do livro |
| autor | String | Autor |
| quantidadeTotal | int | Total de exemplares |
| quantidadeDisponivel | int | Disponível |

---

### 👨‍🎓 Aluno

| Campo | Tipo | Descrição |
|------|------|----------|
| id | int | Identificador |
| nome | String | Nome completo |
| matricula | String | Matrícula |

---

### 🔄 Empréstimo

| Campo | Tipo | Descrição |
|------|------|----------|
| id | int | Identificador |
| aluno | Aluno | Relacionamento |
| livro | Livro | Relacionamento |
| dataEmprestimo | String | Data |
| dataDevolucao | String | Data |
| devolvido | boolean | Status |

---

## 📏 Regras de Negócio

- ✅ Livro deve ter título  
- ✅ Quantidade ≥ 0  
- ❌ Não emprestar sem estoque  
- 🔄 Devolução atualiza estoque  
- 📊 Listar empréstimos em aberto  
- 📋 Alunos com pendência  
- ⚠️ Nome do aluno obrigatório  

---

## 🧠 Arquitetura
🔹 Projeto 1
- Simples
- Sem separação de camadas

🔹 Projeto 2 (MVC)
- Model → Dados
- Repository → Persistência
- Controller → Regras
- View → Interface

---
## 🗂️ Estrutura do Projeto

```bash
biblioteca-escolar/
├── README.md
├── projeto1/          # Versão simples
│   └── src/main/java/biblioteca/
│       ├── Livro.java
│       ├── Aluno.java
│       ├── Emprestimo.java
│       ├── SistemaBiblioteca.java
│       └── Main.java
│
└── projeto2/          # Versão MVC
    └── src/main/java/biblioteca/
        ├── model/
        ├── repository/
        ├── controller/
        ├── view/
        └── Main.java
````
<p align="center"> <strong>Alisson Junior</strong><br> 💻 Desenvolvedor em evolução </p>

