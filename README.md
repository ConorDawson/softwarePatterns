# Multi-Card Game Platform – Refactored Web Application

## Overview
This project is a complete refactor and modernization of a legacy Object-Oriented Programming project originally developed in Java.  
The initial implementation featured a single card game, **Knock 31**, running locally. The goal of this refactor is to transform that standalone game into a **scalable, web-based multi-card game platform** capable of hosting multiple card games such as **Knock 31** and **Blackjack**, with the flexibility to add more games in the future.

The project focuses on improving the **software architecture** and **design patterns** to ensure better maintainability, modularity, and extensibility.  
Additionally, the project integrates the **Deck of Cards API** to handle card logic dynamically, reducing code duplication and improving system efficiency.

---

## Purpose
The objective of this refactor was to:
- Re-engineer a legacy Java-based desktop application into a web-based platform.
- Implement industry-standard **architectural designs** and **software design patterns**.
- Improve **maintainability**, **scalability**, and **readability** of the system.
- Apply practical knowledge of software design principles to a real-world project.

---

## System Architecture

### Architectural Patterns Used
The project primarily adopts a **Microservices** and **N-Tier (MVC)** architecture to ensure separation of concerns and modularity.

1. **Microservices Architecture**  
   Each card game operates as an independent service, allowing for:
   - Easier scaling and deployment of individual games.
   - Decoupled logic for each component.
   - Flexibility to add or remove games without affecting the entire system.

2. **N-Tier (MVC) Architecture**  
   The application follows a clear separation between:
   - **Model:** Data structures and game logic.  
   - **View:** Frontend interface for interacting with users.  
   - **Controller:** Routes and APIs connecting user actions with backend logic.  

This hybrid approach enhances maintainability and allows efficient integration with external services like the Deck of Cards API.

---

## Design Patterns Implemented

The refactor strategically employs multiple design patterns, each serving a specific purpose within the architecture:

| Pattern | Description | Use Case |
|----------|--------------|----------|
| **Singleton Pattern** | Ensures only one instance of key classes (e.g., API handler, database connection) exists throughout the system. | Used for managing the Deck of Cards API and shared resources. |
| **Factory Pattern** | Provides an interface for creating objects without specifying their concrete classes. | Used for generating different card games dynamically. |
| **Observer Pattern** | Establishes a one-to-many relationship between objects for event-driven communication. | Used for game state updates, such as notifying players of card draws or score changes. |
| **Module Pattern** | Encapsulates logic and variables within self-contained modules to avoid namespace pollution. | Used extensively in the Node.js and frontend logic. |
| **Microservice Pattern** | Breaks the system into smaller, independent components that can be maintained and deployed separately. | Used to structure each game and service independently. |

---

## Technologies Used

| Technology | Purpose |
|-------------|----------|
| **Frontend:** HTML, CSS, JavaScript, React | User interface and interaction handling |
| **Backend:** Node.js, Express | API management, routing, and server logic |
| **API:** Deck of Cards API | External API for managing card decks and gameplay |
| **Architecture:** Microservices, MVC | Structural and organizational design |
| **Version Control:** Git, GitHub | Code management and collaboration |
| **Testing:** Jest / Postman | Testing API endpoints and logic consistency |

---

## Reasoning and Implementation

This project was refactored to better align with modern software development standards. The primary reasoning behind the chosen patterns and architecture was to:

1. **Improve Maintainability**  
   The previous monolithic Java structure made it difficult to modify or extend functionality. The new modular structure isolates components, allowing for easier updates and debugging.

2. **Enhance Scalability**  
   The Microservice approach allows each game to run independently. Future games can be integrated without refactoring existing logic.

3. **Promote Code Reusability**  
   Through the Factory and Module patterns, shared functionality such as deck creation and game state management can be reused across multiple games.

4. **Improve Flexibility**  
   Integrating the Deck of Cards API abstracts away lower-level card logic, allowing the developer to focus on game mechanics rather than repetitive logic.

5. **Adopt Industry Practices**  
   Applying patterns like Observer and Singleton ensures that the system adheres to standard development conventions found in professional software projects.

---

## Lessons Learned

Throughout the development of this project, several key insights were gained:

- **Microservices and N-Tier architectures** offer significant flexibility but require careful coordination between components to prevent over-engineering.
- The **Observer** and **Factory** patterns proved highly effective for managing game state and creating new game instances dynamically.
- While the project was more complex than initially planned, it demonstrated the benefits of maintainable and scalable system design.
- Understanding how frameworks like **Express** and external APIs inherently use design patterns deepened the appreciation for pattern-driven architecture.

---

## Conclusion

This refactor successfully transformed a single-game, monolithic Java project into a modular, web-based card game platform.  
The project demonstrates the practical application of multiple **architectural patterns** and **design principles**, emphasizing reusability, scalability, and maintainability.

While the process involved challenges and a degree of over-engineering, the resulting application provides a flexible foundation for future expansion.  
This project solidified understanding of architectural concepts like Microservices and MVC, and enhanced the ability to apply design patterns effectively in real-world software systems.

---

## Author
**Conor Dawson**  
BSc (Hons) in Software Development  
