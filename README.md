# Rock-Paper-Scissors
An attempt to implement the well-known game in Java as console application

It is based on the globally known [Game] [wikipedia], in which two contrahents 
simultaneously choose one out of three hand signs which defeat each other 
following dedicated rules.

## Getting Started

1. Checkout the project
2. Change to project path
3. Build the project

        $ mvn clean install
        
After successful building a new sub folder ```target``` is generated within 
projects folder. It contains now the new built JAR file 
(```rock-paper-scissors-1.0.jar```)


## Running the application

1. Start of application

        $ java -jar /<PROJECT-PATH>/target/rock-paper-scissors-1.0-SNAPSHOT.jar

2. Entering the desired game strategy for each user 

    One feature is, that each user being able to define its own game strategy. 
    Possible options are:

        [C]hance, [R]ock, [P]aper or [S]cissors

    The implemented logic has been optimized to only needing to enter the first 
    letter of each strategy. Upper and lower case can be ignored here.
    Further, also incorrect entries are being proved, so that each user strictly 
    has to choose one game strategy.

    Subsequently, the entry needs to be confirmed with ```Enter```.
    
3. (opt) Entering the number of rounds

    In case of at least one player deciding for ```[C]hance``` (Random), it is 
    possible to enter the number rounds to be played.

    If no value is entered, only one run will be started. A limit of ```30``` 
    runs is implemented, so that also values of above ```30``` will be limited 
    to this threshold.

4. Output of the game's run

    Another feature is, to display the result after the game's run. 
    Therefore, a tabular form was chosen in which the following criteria were 
    used:

    * Wins of player A
    * Wins of player B
    * Number of ties
    * Number of runs
    * Percentage of wins for player A
    * Percentage of wins for player B

    Example:
    
        +---------------------------------------------------------------------------------------------------------------+
        |  Game for Java application:  ROCK, PAPER, SCISSORS                                                            |
        +---------------------------------------------------------------------------------------------------------------+
        Step #01 - Please select the game strategy [C]hance, [R]ock, [P]aper or [S]cissors for User1: P
        Step #02 - Please select the game strategy [C]hance, [R]ock, [P]aper or [S]cissors for User2: S
         -------
         Run #01 - SCISSORS beats PAPER. User2 wins!
        +---------------------------------------------------------------------------------------------------------------+
        |    WINS User1  |    WINS User2  |    TIES  |  GAMES PLAYED  |  WIN PERCENTAGE User1  |  WIN PERCENTAGE User2  |
        |----------------+----------------+----------+----------------+------------------------+------------------------|
        |             0  |             1  |       0  |             1  |                 0,00%  |               100,00%  |
        +---------------------------------------------------------------------------------------------------------------+



[wikipedia]: https://de.wikipedia.org/wiki/Schere,_Stein,_Papier "Wikipedia"


