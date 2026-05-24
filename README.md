# AI Labor Rights Guide ⚖️🤖

An intelligent, RAG-based (Retrieval-Augmented Generation) digital assistant designed to answer complex questions regarding Greek Labor Law.

Built with **Spring Boot**, **Spring AI**, **DeepSeek LLM**, and **ChromaDB**, this project allows employees to describe their work situations (e.g., working hours, firing conditions, leaves) and receive legally accurate, empathetic, and actionable advice.

## 🌟 Key Features

- **Context-Aware Memory (Sliding Window):** The AI remembers the context of the current conversation, allowing for natural, multi-turn follow-up questions.
- **RAG Architecture:** Leverages Chroma Vector Database to search through ingested `.md` files containing Greek labor laws, ensuring the AI's responses are strictly grounded in legal facts, minimizing hallucinations.
- **Manual Document Ingestion:** Custom document parser and chunker for `.md` files that skips restrictive auto-splitters, ensuring 100% data retention.
- **Prompt Engineering:** Specially crafted System Prompts that force the AI to execute mathematical reasoning (e.g., calculating severance pay or overtime percentages) without revealing the underlying RAG mechanics to the user.
- **Infrastructure as Code:** Ready-to-use Docker Compose configuration for seamless database deployment.

## 🛠️ Tech Stack

- **Backend:** Java 25, Spring Boot 4
- **AI Integration:** Spring AI
- **LLM:** DeepSeek API (`deepseek-chat`)
- **Vector Database:** ChromaDB (via Docker)
- **Frontend (Optional/Separate):** Angular Standalone Components

## 🚀 Quick Start Guide

### 1. Prerequisites
- Docker & Docker Compose
- Java 25 or higher
- Maven
- A DeepSeek API Key

### 2. Setup ChromaDB (Vector Database)
The project includes a `docker-compose.yml` file to quickly spin up the ChromaDB database. The database will run on port `8000` and save its data locally in a `chroma_data/` folder.

Open your terminal in the project's root directory and run:
```bash
docker compose up -d
```

### 3. Configure Environment Variables

To keep your API key secure, the application reads it from your system's environment variables. Set the DEEPSEEK_API_KEY before running the app:

On Linux/macOS:
```bash
export DEEPSEEK_API_KEY="sk-your-actual-api-key-here"
```

On Windows (Command Prompt):
```bash
set DEEPSEEK_API_KEY="sk-your-actual-api-key-here"
```

On Windows (PowerShell):
```bash
$env:DEEPSEEK_API_KEY="sk-your-actual-api-key-here"
```

### 4. Run the Application

Start the Spring Boot backend using Maven:
```bash
mvn spring-boot:run
```
The server will start on `http://localhost:8080`.

## 📚 Document Ingestion (Feeding the Knowledge Base)

Before chatting, you need to feed the AI with your labor law documents.

1. Place your markdown files (.md) inside the src/main/resources/docs/ folder.

2. Trigger the ingestion endpoint using curl or Postman:

```bash
curl -X POST http://localhost:8080/api/admin/ingest
```

The application will read the files, chunk them into paragraphs, create vector embeddings, and store them securely in ChromaDB. You should see a success message indicating the number of chunks saved.

## 💬 API Endpoints

### Chat Endpoint

- ### URL ### ```POST /api/chat```
- ### Body: ###
```json
{
  "messages": [
    {
      "role": "user",
      "content": "I work 9 hours a day, 5 days a week. Am I entitled to overtime pay?"
    }
  ]
}
```
- ### Response: ###
```json
{
  "role": "ai",
  "content": "According to the Greek labor law (N. 5053/2023), the 9th hour..."
}
```

## 🤝 Contributing ##

Contributions, issues, and feature requests are welcome! Feel free to fork this repository and submit pull requests.