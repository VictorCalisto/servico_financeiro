# Sistema de Precificação de Serviços Profissionais

## Descrição

Este projeto foi desenvolvido em **Ruby**, com foco no paradigma de **Programação Orientada a Objetos (POO)**, como requisito para a disciplina de **POO (Programação Orientada a Objetos)** da **PUC Goiás - Turma 2025/1**, sob orientação do professor **Leonardo Guedes**.

O sistema permite calcular preços de serviços profissionais com base em fatores como:

- Complexidade
- Urgência
- Valor/hora base
- Quantidade de horas estimadas

Inclui simulações de:

- Ajuste de urgência
- Aplicação de descontos

## Autoria

- Desenvolvido por **Victor Calisto**
- Com suporte perprogram da IA ChatGPT 3.5
- Refatorado utilizando a gem/biblioteca **Rubocop**, através do comando:

```bash
rubocop -A
```
- Posteriormente convertido para Java utilizando a IA Gemini 2.5


## Tecnologias Utilizadas:

- Ruby (linguagem principal)
- Rubocop (para linting e refatoração automática)
- Java (versão convertida posteriormente)
- ChatGPT 3.5 (suporte perprogram)
- Gemini 2.5 (onversão Ruby → Java)


## Objetivo Acadêmico:

Este projeto tem fins exclusivamente acadêmicos, com o objetivo de praticar:
- Modelagem de classes
- Aplicação de conceitos de herança, encapsulamento e polimorfismo
- Criação de interfaces e abstrações
- Aplicação de boas práticas com ferramentas de linting e refatoração automatizada (Rubocop)


## Estrutura de Classes:

- ServicoProfissional (Classe Abstrata)
  - Métodos para cálculo de preço, simulações de urgência e desconto
- ProjetoEngenharia (Herda de ServicoProfissional)
- AnaliseTecnologica (Herda de ServicoProfissional)
- ConsultoriaLegal (Herda de ServicoProfissional)
- Interface/Module SimulavelFinanceiramente

## Licença:

Uso acadêmico — livre distribuição e modificação para fins educacionais.

## Executando o Projeto:

## Pré-requisitos

- [Git](https://git-scm.com/)
- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)

## Clonando o projeto

```bash
git clone https://github.com/VictorCalisto/slots.git
cd slots
```

## Subindo o container

```bash
docker compose up -d
```

## Acessando o terminal do container
```bash
docker exec -it java bash
```
## Executando o programa Java
```bash
java Main
```
## Parando o container
```bash
docker compose down
```
---

## Estrutura do Projeto

```plaintext
.
├── app
│   ├── AnaliseTecnologica.class
│   ├── ConsultoriaLegal.class
│   ├── Main.class
│   ├── Main.java
│   ├── ProjetoEngenharia.class
│   ├── ServicoProfissional.class
│   └── SimulavelFinanceiramente.class
├── docker-compose.yml
├── dockerfile
├── README.md
└── servico_financeiro_original.rb

1 directory, 11 files
