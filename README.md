# Microserviço de Usuários

O objetivo deste projeto é possibilitar o cadastro e realizações de doações, permitindo que os usuários possam requisitar e transferir entre si para sanar suas necessidades requeridas. A aplicação permite que o usuário crie, edite, e cancele uma doação e que o mesmo possa doar para as solicitações disponibilizadas por outros usuários.

## Tecnologias Utilizadas
- **Java** (versão 17 ou superior)
- **Spring Boot** (framework para a construção do microserviço)
- **Lombok** (para redução de código boilerplate)
- **H2 Database** (banco de dados em memória para desenvolvimento e testes)
- **Spring Data JPA** (para persistência de dados)
- **Spring Validation** (para validação dos dados recebidos)
- **Spring Web** (para implementação das rotas REST)

## Estrutura do Projeto
O projeto segue uma arquitetura em camadas:

- **Controller**: Responsável pelas requisições HTTP e interação com os serviços.
- **Service**: Lógica de negócio. A camada de serviço manipula os dados e chama os repositórios.
- **Repository**: Camada de persistência de dados, que faz o acesso direto ao banco.
- **DTO (Data Transfer Object)**: Objetos de transferência para garantir que apenas dados necessários sejam enviados ou recebidos pela API.
- **Mapper**: Mapeia objetos do tipo modelo para DTOs e vice-versa.

## Endpoints

### 1. Criar Usuário
- **Método**: POST
- **Endpoint**: `/usuarios`
- **Status HTTP**: `201 CREATED`

**Corpo da Requisição (JSON)**:
```json
{
  "nome": "João Silva",
  "email": "joao.silva@example.com",
  "senha": "senhaSegura123"
}

  ```
* **Resposta (201 - Created):**
  ```json
  {
    "id": 1,
    "nome": "João Silva",
    "email": "joao.silva@example.com"
  }
  ```

**2. Listar Usuários (GET /usuarios)**

* **Requisição:**  (pode incluir parâmetros de paginação)
* **Resposta (200 - OK):**
  ```json
  [
    {
      "id": 1,
      "nome": "João Silva",
      "email": "joao.silva@example.com"
    },
    {
      "id": 2,
      "nome": "Maria Oliveira",
      "email": "maria.oliveira@example.com"
    }
  ]
  ```

**3. Obter Usuário por ID (GET /usuarios/{id})**

* **Requisição:**
* **Resposta (200 - OK):**  (ou 404 - Not Found se o usuário não existir)
  ```json
  {
    "id": 1,
    "nome": "João Silva",
    "email": "joao.silva@example.com"
  }
  ```

**4. Atualizar Usuário (PUT /usuarios/{id})**

* **Requisição:**
  ```json
  {
    "nome": "João da Silva Santos",
    "email": "joao.silva.santos@example.com"
  }
  ```
* **Resposta (200 - OK):** (ou 404 - Not Found)

**5. Deletar Usuário (DELETE /usuarios/{id})**

* **Requisição:**
* **Resposta (204 - No Content):** (ou 404 - Not Found)

### 6. Criar Doação
- **Método**: POST
- **Endpoint**: `/doacoes`
- **Status HTTP**: `201 CREATED`

**Corpo da Requisição (JSON)**:
```json
  {
  	"titulo": "Titulo da Doacao",
    "descricao": "Nova doação",
    "localizacao": "Criciúma",
    "empresa": "SATC",
    "imagem": "codigoDaImagem",
    "tempo": "25 dias",
    "valor": "25000",
    "usuarioId": "16d220b4-8721-4a5d-bf66-7ee36fbe42b6"
  }

  ```
* **Resposta (201 - Created):**
  ```json
  {
  	"id": "afe45db0-041a-4d43-8305-79003ac3834e",
  	"titulo": "Titulo da Doacao",
  	"descricao": "Nova doação",
  	"localizacao": "Criciúma",
  	"empresa": "SATC",
  	"tempo": "25 dias",
  	"valor": 25000.0,
  	"usuarioId": "16d220b4-8721-4a5d-bf66-7ee36fbe42b6"
  }
  ```

**7. Listar Doações (GET /doacoes)**

* **Requisição:**  (pode incluir parâmetros de paginação)
* **Resposta (200 - OK):**
  ```json
  [
  	{
  		"id": "dad1a481-b6cc-4264-a2b7-31dab119d2ce",
  		"titulo": "Doacao",
  		"descricao": "donation01",
  		"localizacao": "Guaripaba",
  		"empresa": "SATEC",
  		"tempo": "Muitho",
  		"valor": 15000.0,
  		"usuarioId": "16d220b4-8721-4a5d-bf66-7ee36fbe42b6"
  	},
  	{
  		"id": "ed7312af-0d38-46e8-a236-f6b296c4124a",
  		"titulo": "Titulo da Doacao",
  		"descricao": "Nova doação",
  		"localizacao": "Criciúma",
  		"empresa": "SATC",
  		"tempo": "25 dias",
  		"valor": 25000.0,
  		"usuarioId": "16d220b4-8721-4a5d-bf66-7ee36fbe42b6"
  	}
  ]
  ```

**8. Obter Doações por Usuário (GET doacoes/usuario/{id})**

* **Requisição:**
* **Resposta (200 - OK):**  (ou 404 - Not Found se o usuário não existir)
  ```json
  [
  	{
  		"id": "dad1a481-b6cc-4264-a2b7-31dab119d2ce",
  		"titulo": "Doacao",
  		"descricao": "donation01",
  		"localizacao": "Guaripaba",
  		"empresa": "SATEC",
  		"tempo": "Muitho",
  		"valor": 15000.0,
  		"usuarioId": "16d220b4-8721-4a5d-bf66-7ee36fbe42b6"
  	},
  	{
  		"id": "ed7312af-0d38-46e8-a236-f6b296c4124a",
  		"titulo": "Titulo da Doacao",
  		"descricao": "Nova doação",
  		"localizacao": "Criciúma",
  		"empresa": "SATC",
  		"tempo": "25 dias",
  		"valor": 25000.0,
  		"usuarioId": "16d220b4-8721-4a5d-bf66-7ee36fbe42b6"
  	}
  ]
  ```

**9. Atualizar Usuário (PUT /doacoes/{id})**

* **Requisição:**
  ```json
  {
  	"titulo": "Doacao",
    "descricao": "donation01",
    "localizacao": "Guarcxvxcvipaba",
    "empresa": "SATEC",
    "imagem": null,
    "tempo": "Muitho",
    "valor": "15000"
  }
  ```
* **Resposta (200 - OK):** (ou 404 - Not Found)

**10. Deletar Doação (DELETE /doacoes/{id})**

* **Requisição:**
* **Resposta (204 - No Content):** (ou 404 - Not Found)

### 11. Criar Transferência
- **Método**: POST
- **Endpoint**: `/transferencia`
- **Status HTTP**: `201 CREATED`

**Corpo da Requisição (JSON)**:
```json
  {
    "valor": 150.00,
    "contaOrigemId": 1,
    "contaDestinoId": 2,
    "descricao": "Pagamento de fatura"
  }   
```

* **Resposta (201 - Created):**
  ```json
  {
    "id": 1,
    "valor": 150.00,
    "contaOrigemId": 1,
    "contaDestinoId": 2,
    "descricao": "Pagamento de fatura",
    "dataTransferencia": "2024-11-26T14:30:00"
  }
  ```

**12. Listar Transferência**
- **Método**: GET
- **Endpoint**: `/transferencia`
- **Status HTTP**: `200 OK`

* **Resposta (200 - OK):**
  ```json
  [
  {
    "id": 1,
    "valor": 150.00,
    "contaOrigemId": 1,
    "contaDestinoId": 2,
    "descricao": "Pagamento de fatura",
    "dataTransferencia": "2024-11-26T14:30:00"
  },
  {
    "id": 2,
    "valor": 200.00,
    "contaOrigemId": 3,
    "contaDestinoId": 1,
    "descricao": "Transferência entre amigos",
    "dataTransferencia": "2024-11-25T11:15:00"
  }
  ]

  ```

**13. Obter Transferência por ID**
- **Método**: GET
- **Endpoint**: `/transferencia/{id}`
- **Status HTTP**: `200 OK (ou 404 Not Found se a transferência não for encontrada)`

* **Resposta (200 - OK):**
  ```json
  {
  "id": 1,
  "valor": 150.00,
  "contaOrigemId": 1,
  "contaDestinoId": 2,
  "descricao": "Pagamento de fatura",
  "dataTransferencia": "2024-11-26T14:30:00"
  }

  ```

**14. Atualizar Transferência**
- **Método**: PUT
- **Endpoint**: `/transferencia/{id}`
- **Status HTTP**: `200 OK (ou 404 Not Found se a transferência não for encontrada)`

**Corpo da Requisição (JSON)**:
```json
  {
  "valor": 175.00,
  "contaOrigemId": 1,
  "contaDestinoId": 2,
  "descricao": "Pagamento de fatura atualizado"
  }
```

* **Resposta (200 - OK):**
  ```json
  {
  "id": 1,
  "valor": 175.00,
  "contaOrigemId": 1,
  "contaDestinoId": 2,
  "descricao": "Pagamento de fatura atualizado",
  "dataTransferencia": "2024-11-26T14:30:00"
  }

  ```

**15. Deletar Transferência**
- **Método**: DELETE
- **Endpoint**: `/transferencia/{id}`
- **Status HTTP**: `200 OK (ou 404 Not Found se a transferência não for encontrada)`

* **Resposta (204 - No Content):**
  ```json
  {}
  ```
