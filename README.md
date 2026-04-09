# 🚀 QR Code Generator API

Uma API robusta e escalável desenvolvida em **Spring Boot** para a geração de QR Codes dinâmicos, com armazenamento em nuvem via **AWS S3** e conteinização total utilizando **Docker**.

---

## 📝 Sobre o Projeto

Este projeto foi desenvolvido com o objetivo de automatizar o processo de criação e armazenamento de QR Codes. A aplicação recebe uma URL ou texto, gera a imagem correspondente, realiza o upload para um bucket na nuvem e retorna o link de acesso público.

Ideal para sistemas que precisam de geração de convites, links de pagamento ou compartilhamento de informações de forma rápida e segura.

## 🛠️ Tecnologias e Ferramentas

*   **Backend:** Java com Spring Boot 3.x
*   **Geração de QR:** ZXing (Zebra Crossing)
*   **Cloud Storage:** AWS S3 (Simple Storage Service)
*   **Infrastructure:** Docker & Docker Compose
*   **Documentação:** Swagger/OpenAPI (opcional)
*   **Gerenciamento de Dependências:** Maven

## 📦 Estrutura de Conteinização

A aplicação está totalmente "dockerizada", o que garante que ela rode da mesma forma em qualquer ambiente.

*   **Dockerfile:** Configura o ambiente Java e gera o build da aplicação.
*   **Docker Compose:** Orquestra a aplicação e facilita a configuração de variáveis de ambiente.

---

## 🚀 Como Executar

### 1. Pré-requisitos
*   **Docker** instalado.
*   Credenciais de um usuário IAM na **AWS** com permissão de escrita no S3.

### 2. Configuração
Crie um arquivo `.env` na raiz do projeto (ou edite o `docker-compose.yml`) com as seguintes chaves:

```env
AWS_ACCESS_KEY=sua_chave_de_acesso
AWS_SECRET_KEY=sua_chave_secreta
AWS_REGION=us-east-1
AWS_BUCKET_NAME=nome-do-seu-bucket
````

### 3. Rodando com Docker
No terminal, execute o comando:

```
docker-compose up -d
````

A API estará disponível em: http://localhost:8080

### 🛣️ Endpoints Principais
Gerar QR Code
* POST /api/v1/qrcode/generate

Corpo da Requisição (JSON):

````Json
{
  "nomeArquivo": "meu-primeiro-qrcode",
  "conteudo": "[https://github.com/seu-usuario](https://github.com/seu-usuario)"
}
````

O Gemini disse
Aqui está o conteúdo estruturado para o seu arquivo README.md. Você pode copiar o código abaixo e colar diretamente no seu arquivo.

Markdown
# 🚀 QR Code Generator API

Uma API robusta e escalável desenvolvida em **Spring Boot** para a geração de QR Codes dinâmicos, com armazenamento em nuvem via **AWS S3** e conteinização total utilizando **Docker**.

---

## 📝 Sobre o Projeto

Este projeto foi desenvolvido com o objetivo de automatizar o processo de criação e armazenamento de QR Codes. A aplicação recebe uma URL ou texto, gera a imagem correspondente, realiza o upload para um bucket na nuvem e retorna o link de acesso público.

Ideal para sistemas que precisam de geração de convites, links de pagamento ou compartilhamento de informações de forma rápida e segura.

## 🛠️ Tecnologias e Ferramentas

*   **Backend:** Java com Spring Boot 3.x
*   **Geração de QR:** ZXing (Zebra Crossing)
*   **Cloud Storage:** AWS S3 (Simple Storage Service)
*   **Infrastructure:** Docker & Docker Compose
*   **Documentação:** Swagger/OpenAPI (opcional)
*   **Gerenciamento de Dependências:** Maven

## 📦 Estrutura de Conteinização

A aplicação está totalmente "dockerizada", o que garante que ela rode da mesma forma em qualquer ambiente.

*   **Dockerfile:** Configura o ambiente Java e gera o build da aplicação.
*   **Docker Compose:** Orquestra a aplicação e facilita a configuração de variáveis de ambiente.

---

## 🚀 Como Executar

### 1. Pré-requisitos
*   **Docker** instalado.
*   Credenciais de um usuário IAM na **AWS** com permissão de escrita no S3.

### 2. Configuração
Crie um arquivo `.env` na raiz do projeto (ou edite o `docker-compose.yml`) com as seguintes chaves:

```env
AWS_ACCESS_KEY=sua_chave_de_acesso
AWS_SECRET_KEY=sua_chave_secreta
AWS_REGION=us-east-1
AWS_BUCKET_NAME=nome-do-seu-bucket
````

3. Rodando com Docker
No terminal, execute o comando:

Bash
docker-compose up -d
A API estará disponível em: http://localhost:8080

🛣️ Endpoints Principais
Gerar QR Code
POST /api/v1/qrcode/generate

Corpo da Requisição (JSON):

````JSON
{
  "nomeArquivo": "meu-primeiro-qrcode",
  "conteudo": "[https://github.com/seu-usuario](https://github.com/seu-usuario)"
}
````

* Resposta (200 OK):
````Json
  {
  "urlS3": "[https://meu-bucket.s3.amazonaws.com/meu-primeiro-qrcode.png](https://meu-bucket.s3.amazonaws.com/meu-primeiro-qrcode.png)",
  "status": "Sucesso"
}
````

### 🎯 Diferenciais Técnicos
* POO: Utilização de padrões de projeto para manter o código limpo e extensível.

* Segurança: As chaves de acesso não ficam expostas no código (uso de variáveis de ambiente).

* Escalabilidade: Pronto para ser implantado em serviços como AWS ECS ou Kubernetes.
  
