# UpSkill-campus---Rupa-Prajapati
# Banking Information System

This is a simple **Banking Information System** built using **Core Java** and **Java Swing**. The project demonstrates key functionalities of a real-world banking system, such as user registration, login, account management, deposits, withdrawals, and fund transfers, with a graphical user interface.

## Features

1. **User Registration**: Users can register by providing a username and password.
2. **User Login**: Existing users can log in using their credentials.
3. **Deposit**: Users can deposit money into their accounts.
4. **Withdraw**: Users can withdraw money from their accounts (as long as they have sufficient funds).
5. **Balance Inquiry**: Users can check their current account balance.
6. **Logout**: Users can safely log out of their session.
7. **Error Handling**: Basic error handling for invalid inputs and insufficient funds.
8. **User Interface**: Simple and easy-to-use GUI built using Java Swing.

## Tech Stack

- **Java**: Core Java is used to handle the business logic and operations of the banking system.
- **Swing**: Java Swing library is used to create the graphical user interface (GUI).

## Getting Started

Follow these instructions to get a copy of the project up and running on your local machine.

### Prerequisites

- Java Development Kit (JDK) installed (JDK 8 or later).
- Any Java IDE (e.g., IntelliJ IDEA, Eclipse, or NetBeans) or a simple text editor to run the code.

### Installation

1. Clone the repository to your local machine:
    ```bash
    git clone https://github.com/yourusername/banking-information-system.git
    ```

2. Open the project in your preferred Java IDE or text editor.

3. Compile and run the project:
    - If using an IDE, right-click the `BankingSystemUI.java` file and choose "Run".
    - If using the terminal, navigate to the project folder and run the following command to compile:
      ```bash
      javac BankingSystemUI.java
      ```
      Then, run the program:
      ```bash
      java BankingSystemUI
      ```

## Project Structure

```bash
.
├── src
│   ├── BankingSystemUI.java        # Main class with GUI logic
│   ├── BankSystem.java             # Class for managing users and login
│   ├── User.java                   # Class representing individual users
│   └── BankAccount.java            # Class representing the bank account of a user
├── README.md                       # Project description and instructions
└── .gitignore                      # Files and directories to ignore in the repository
