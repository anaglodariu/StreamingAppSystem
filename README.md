# Streaming App System in Java

Data Input
==
- the main method of the project is in the ProiectPoo class
- the main method gets as parameters 3 csv files with the information about the
users, streamers and streams and a txt file with the commands that need to be implemented using that info for the app

Classes Structure
==
- **ProiectPoo** class: the main method
- **StreamingApp** class:
  - **manages** the streams, users, streamers
  - implements the **Singleton Design Pattern**
- **ReadFromFiles** class: reads from files the info about the streams, users, streamers and commands
- **Commands** class: implements the **Command Design Pattern** in order to incapsulate the commands read from files into objects:
  - **AddCommand** subclass
  - **DeleteCommand** subclass
  - **ListenCommand** subclass
  - **RecommendCommand** subclass
  - **SurpriseCommand** subclass
- **StreamersFactory** class: implements **Singleton** and **Factory** Design Patterns so that it creates streamer objects based ono their type
- **Streamer** class:
  - **AuthorAudioBook** subclass
  - **Musician** subclass
  - **Podcaster** subclass
- **User** class: creates user objects
- **Stream** class: creates stream objects
