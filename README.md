University Student & Campus Management System 
CIT300 - Data Structures and Algorithms 

Project Overview 
This project is a Java console-based application created for the CIT300 - Data Structures and Algorithms module. It is designed to manage university student records, service requests, and campus locations using various fundamental data structures. 
Key Features: 
Student Record Management: Add, update, delete, and display student records. 
Service Requests: Queue-based service request processing and stack-based system logs/recent actions. 
Efficient Searching & Display: Quick student lookup using Hashing (Linear Probing) and organized display using a Binary Search Tree (BST). 
Campus Navigation: Manage campus locations and connections, with BFS (Breadth-First Search) traversal using Graph. 
Group Members 
No
Name 
Student ID 
Main Responsibility 
1
H W N Sewwandi 
23DA2-0047  
Linked List and Student Management 
2
H M S Pramodaya 
23DA2-0117 
Queue and Stack 
3
M D I Asunthara De Silva 
23DA2-0002 
BST and Hashing 
4
K D Himasha Darshani 
23DA2-0227 
Graph and BFS 




Project Overview 
The main purpose of this project is to create a simple system for managing university  student records and campus information. 


The system can: 
• Add student records 
• Update student records 
• Delete student records 
• Display student records 
• Add and process service requests 
• Display recent system actions 
• Search students using hashing
• Add and remove campus locations 
• Display students using a Binary Search Tree 
• Add and remove campus connections 
• Display campus connections 
• Traverse campus locations using BFS 
Data Structures Used 
The following data structures are used in this project: 

1. Singly Linked List 
The Singly Linked List is used to store and manage student records. It supports: 
• Add student 
• Update student 
• Delete student 
• Search student 				• Display students 
2. Queue 
A Queue is used to manage student service requests. 
It follows the FIFO (First In, First Out) principle. 
The first request added to the queue is processed first. 
3. Stack 
A Stack is used to store recent system actions. 
It follows the LIFO (Last In, First Out) principle. 
The latest action is displayed first. 
4. Binary Search Tree 
The Binary Search Tree is used to organize student records according to Student ID.
It supports: 
• Insert student 
• Search student 
• Delete student 
• Display students in sorted order 
5. Hash Table 
The Hash Table is used for fast student searching. 
This project uses Linear Probing to handle collisions. 
6. Graph 
The Graph is used to represent campus locations and connections between them. It supports: 


• Add location 
• Remove location 
• Add connection 
• Remove connection 
• Display connections 
• BFS traversal

Individual Contributions 
Member 1 - H W N Sewwandi 
Student ID: 23DA2-0047 
Responsible for: 
• Singly Linked List 			• Student record management 
• Adding students 			• Updating students
• Deleting students 			• Displaying student records 
Main files: 
• Student.java 
• StudentLinkedList.java 
Member 2 - H M S Pramodaya 
Student ID: 23DA2-0117 
Responsible for: 
• Queue implementation 
• Stack implementation 
• Student service requests 
• Processing service requests 
• Displaying recent actions 
Main files: 
• ServiceRequest.java 
• ServiceQueue.java 			• ActionStack.java 


 Member 3 - M D I Asunthara De Silva

Student Id: 23DA2-0002
Responsible for:
• Binary Search Tree implementation 
• Hash Table implementation 
• Student searching 
• Organizing student records using BST
• Hashing using Linear Probing 


Main files: 
• BST.java 
• StudentHashTable.java 
Member 4 - K D Himasha Darshani 
Student ID: 23DA2-0227 
Responsible for: 
• Graph implementation 
• Campus locations 
• Campus connections 
• Removing locations and connections 
• Breadth-First Search (BFS) 
Main file: 
• CampusGraph.java 
Main Menu 
The system contains following main menu options:

1. Add Student Record 
2. Update Student Record 
3. Delete Student Record 
4. Display All Records 
5. Add Service Request 
6. Process Next Service Request 
7. Display Recent Actions 
8. Display Students using BST
9. Search Student using Hashing
10. Add Campus Location 
11. Remove Campus Location 
12. Add Campus Connection 
13. Remove Campus Connection
14. Display Campus Connections
15. Traverse Campus using BFS
16. Exit





Project Structure 

University-Student-Campus-Management/
│
├── README.md
└── src/
    └── university/
        └── system/
            ├── Main.java
            ├── ConsoleUI.java
            ├── Student.java
            ├── StudentLinkedList.java
            ├── ServiceRequest.java
            ├── ServiceQueue.java
            ├── ActionStack.java
            ├── BST.java
            ├── StudentHashTable.java
            └── CampusGraph.java
Main Menu Options
Add Student Record
Update Student Record
Delete Student Record
Display All Records
Add Service Request
Process Next Service Request
Display Recent Actions
Display Students using BST
Search Student using Hashing
Add Campus Location
Remove Campus Location
Add Campus Connection
Remove Campus Connection
Display Campus Connections
Traverse Campus using BFS
Exit
Common Components 
Main.java 
Main.java connects all the parts of the system. 
It contains the main menu and calls the required methods from different classes. 
ConsoleUI.java 
ConsoleUI.java is a common class used by the project. 
It is used for: 
• Console colors 				• Headers 
• Section titles 				• Success messages 
• Error messages 			• Warning messages 
• Information messages 
All group members can use this class when displaying messages README.md


This file contains information about: 
• The project 				• Group members 
• Individual responsibilities 		• Data structures 
• Main features 				• Project structure

Input Validation 
Student ID, Name, and Programme cannot be empty.
Marks must be within valid numeric ranges.
Duplicate Student IDs are prevented.
Service requests require a valid, existing Student ID.
Confirmation prompt required before deleting records.
Testing 
The main functions of the system were tested during development. The following functions were tested :
• Adding students 			• Updating students 
• Deleting students 			• Displaying students using Linked List 
• Displaying students using BST 	• Searching students using Hash Table 
• Adding service requests 		• Processing requests using Queue 
• Displaying recent actions using Stack 
• Adding Campus location		• Adding Campus connection
• Removing campus connections 	• Removing campus locations 
• BFS campus traversal 
The tests were used to check whether the data structures and system functions work  correctly. 


Example Campus Network 
An example campus network can contain locations such as: 
Library 
Main Gate 
Computer Lab 
Cafeteria 
Example connections: 
Library ---- Main Gate 
Main Gate ---- Computer Lab 
Computer Lab ---- Cafeteria 
Library ---- Cafeteria 
BFS can be used to visit the connected campus locations from a selected starting location. 
Collaboration 
This project was developed as a group project. 
Each member worked on their assigned data structure and related system functions. The project can be managed using GitHub branches and commits. 

Example branches: 
main
Member1-  linkedlist 
Member2-  queue-stack 
Member3-  bst-hashing 
Member4-  graph 
Each member can commit their work and the completed parts can be merged into the  main branch. 

Technologies Used 
Language: Java
IDE: Eclipse
Version Control: Git & GitHub
Concept: Data Structures & Algorithms
Project Objectives 
The main objectives of this project are: 
• To understand different data structures. 
• To implement data structures using Java. 
• To use data structures in a practical system. 
• To improve problem-solving skills. 
• To practice teamwork and collaboration. 
• To understand how data structures can be used in real applications. 
Conclusion 
This project helped us understand how different data structures can be used together in  one system. 
The project combines Linked List, Queue, Stack, Binary Search Tree, Hash Table, and  Graph to manage students, service requests, and campus information.
It also helped us gain practical experience in Java programming, testing, debugging,  teamwork, and project development.


