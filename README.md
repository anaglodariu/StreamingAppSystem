# Streaming App System in Java
Overview
--
The purpose of this project is to create a recommendation system for streams (music, podcasts or audiobooks)
based on existing data about the application's users (listeners) and the creators of streams (musicians, podcast moderators, authors) or 
those accumulated during the running of the application.

Data Input
--
- the main method of the project is in the ProiectPoo class
- the main method gets as parameters 3 csv files with the information about the
users, streamers and streams and a txt file with the commands that need to be implemented using that info for the app

Classes Structure
--
- **ProiectPoo** class: the main method
- **StreamingApp** class:
  - **manages** the streams, users, streamers
  - implements the **Singleton Design Pattern**
- **ReadFromFiles** class: reads from files the info about the streams, users, streamers and commands
- **Commands** abstract class: implements the **Command Design Pattern** _in order to incapsulate the commands read from files into objects_, each subclass will override the executeCommand generic method
  - **AddCommand** subclass
  - **DeleteCommand** subclass
  - **ListenCommand** subclass
  - **RecommendCommand** subclass
  - **SurpriseCommand** subclass
- **StreamersFactory** class: implements **Singleton** and **Factory** Design Patterns so that _it creates streamer objects based on their type_
- **Streamer** class:
  - **AuthorAudioBook** subclass
  - **Musician** subclass
  - **Podcaster** subclass
- **User** class: creates user objects
- **Stream** class: creates stream objects
- **Request** class: creates requests based on the List command
- **ListRequestHandler** interface: declares methods that will be implemented by the handlers
- **ConcreteStreamerIdHandler** class: handles requests for streamers (lists the streams of a streamer), it implements the **ListRequestHandler** interface
- **ConcreteUserIdHandler** class: handles requests for the users (lists the streams listened by the user), it implements the **ListRequestHandler** interface
- **ListRequest** class: implements the **Chain of Responsibility** Design Pattern, _each handler in the chain will try to solve or pass the request_

OOP Concepts used
--
- **Abstraction**: the Command class is abstract to avoid creating pure Command objects, since the objects from the subclasses were needed
- **Encapsulation**: the instance fields in the classes are declared private, can only be accessed through the public getters and setters
- **Inheritance**: by creating subclasses
- **Polymorphism**: each subclass of the Command class overrides the executeCommand method

Design Patterns used
--
- **Creational Design Patterns**: Singleton, Factory
- **Behavioral Design Patterns**: Command, Chain of Responsibility

