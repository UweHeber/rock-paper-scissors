# Project "Rock, Paper, Scissors"

An attempt to implement the well-known game in Java.

It is based on the globaly known 
[Game](https://de.wikipedia.org/wiki/Schere,_Stein,_Papier "Wikipedia"), in 
which two contrahents simultaneously choose one out of three hand signs which 
defeat each other following dedicated rules.

The project has been realized in Java to be platform independent. Therefore, it
can be run under Windows or Linux/Unix.

## Getting Started

These instructions provide you with a copy of the project running on your 
local machine for development and testing purposes.

### Prerequisites

It is required, that following programs are availabe/configured on the used 
system host:

1. Operating System Windows 7/10 or Linux/Unix
2. Java JDK 8 or JDK 9
3. (opt.) Maven 3.3+

Please note: Maven is only required, if the project should be built from the 
provided source code. Otherwise, only conditions \[1\] and \[2\] are required.

In case of Java or Maven not being installed yet, you can find the necessary 
instructions to do so here:

* Installation of [Java](https://www.java.com/en/download/help/download_options.xml)
* Installation of [Maven](https://maven.apache.org/install.html)


### Deliverables

For simplicity, the project is currently only delivered as ZIP file 
(``HeberIT.Game.zip``). In principle, however, a delivery via a GIT or Nexus 
repository would be conceivable.

The structure of the ZIP file is as follow

        HeberIT.Game
        └───rock-paper-sciccors-1.0
        |   └───apidocs
        |       |   rock-paper-scissors-1.0.jar
        |       |   rock-paper-scissors-1.0-javadoc.jar
        └───rock-paper-sciccors-1.0-src
            └───src
                |   pom.xml
                |   README.md


**Explanation**

1. The first sub folder (```rock-papaer-sciccors-1.0```) already contains the  
built JAR-File ```rock-paper-scissors-1.0.jar``` which can be started via 
command line immediately after unpacking. This folder also contains the  
documentation of the classes (API) in JavaDoc as
    - HTML representation (Sub folder ```apidocs```)
    - aggregated JAR file ```rock-paper-scissors-1.0-javadoc.jar``` to include it 
into an IDE for further development and the 3rd party libraries to ensure 
funtionality and test
    
2. The second sub folder (```rock-papaer-sciccors-1.0-src```) contains the  
source code incluing the ```pom.xml``` to build this project from scratch via 
Maven.


### Installation / Build


#### _Windows_

1. Saving of the delivered ZIP file in a folder of choice 
(Example: ```C:\%userprofile%\<PATH-TO-INSTALL>```)

2. Move to installation location within Windows Explorer
        
        C:\%userprofile%\<PATH-TO-INSTALL>

3. Extraction of ZIP file using Windows context menu 'Extract all'

        # creates a project folder 'HeberIT.Game'

4. Open Windows console (CMD) and move to projects source folder

        cd C:\%userprofile%\<PATH-TO-INSTALL>\HeberIT.Game\rock-papaer-sciccors-1.0-src

5. Build the project

        # loads all required dependencies and executes available Unit tests
        mvn clean install

After successful building a new sub folder ```target``` is generated within 
projects source folder (see step \[4\] above). It contains now the new built 
JAR file (```rock-paper-scissors-1.0.jar```)


#### _Linux/Unix_

1. Saving of the delivered ZIP file in a folder of choice 
(Example: ```/<PATH-TO-INSTALL>```) and open the console

2. Move to installation location
        
        $ cd /<PATH-TO-INSTALL>

3. Extraction of ZIP file

        # creates a project folder 'HeberIT.Game'
        $ unzip HeberIT.Game.zip

4. Move to projects source folder

        $ cd /<PATH-TO-INSTALL>/HeberIT.Game/rock-papaer-sciccors-1.0-src

5. Build the project

        # loads all required dependencies and executes available Unit tests
        $ mvn clean install
 
After successful building a new sub folder ```target``` is generated within 
projects source folder (see step \[4\] above). It contains now the new built 
JAR file (```rock-paper-scissors-1.0.jar```)


## Running the application

There are two ways to start the application:

1. Use of the newly built JAR (```rock-paper-scissors-1.0.jar```), which is now 
within projects source folder 
        
        # Windows
        C:\%userprofile%\<PATH-TO-INSTALL>\HeberIT.Game\rock-papaer-sciccors-1.0-src/target

        # Linux/Unix
        /<PATH-TO-INSTALL>/HeberIT.Game/rock-papaer-sciccors-1.0-src/target

2. Use of the already delivered JAR (```rock-paper-scissors-1.0.jar```), which 
is located in the unzipped project folder under ```/<PATH-TO-INSTALL>/HeberIT.Game\rock-papaer-sciccors-1.0```

For the next steps option \[2\] is used, to start the application. The following 
steps are necessary:

1. Change to the unzipped project folder

        # Windows console (CMD)
         cd C:\%userprofile%\<PATH-TO-INSTALL>\HeberIT.Game\rock-papaer-sciccors-1.0

        # Linux/Unix
        $ cd /<PATH-TO-INSTALL>/HeberIT.Game/rock-papaer-sciccors-1.0

    **Note:** From here on, the following steps are the same for both operating systems

2. Start of application

        $ java -jar RockPaperScissors-1.0.jar

3. Entering the desired game strategy for each user 

    One requirement was each user being able to define its own game strategy. 
    Possible options are:

        [C]hance, [R]ock, [P]aper or [S]cissors

    The implemented logic has been optimized to only needing to enter the first 
    letter of each strategy. Upper and lower case can be ignored here.
    Further, also incorrect entries are being proved, so that each user strictly 
    has to choose one game strategy.

    Subsequently, the entry needs to be confirmed with ```Enter```.

4. (opt) Entering the number of rounds

    In case of at least one player deciding for ```[C]hance``` (Random), it is 
    possible to enter the number rounds to be played.

    If no value is entered, only one run will be started. A limit of ```30``` 
    runs is implemented, so that also values of above ```30``` will be limited 
    to this threshold.

5. Output of the game's run

    Another requirement was, to display the result after the game's run. 
    Therefore, a tabular form was chosen in which the following criteria were 
    used:

    * Wins of player A
    * Wins of player B
    * Number of ties
    * Number of runs
    * Percentage of wins for player A
    * Percentage of wins for player B



## Running the tests

This project provides some Unit tests to ensure the correct behavior for 
important business logic. To trigger the tests, please complete the following 
steps:

1. Switch into the unzipped project folder

        # Windows console (CMD)
        cd C:\%userprofile%\<PATH-TO-INSTALL>\HeberIT.Game\rock-papaer-sciccors-1.0-src

        # Linux/Unix
        $ cd /<PATH-TO-INSTALL>/HeberIT.Game/rock-papaer-sciccors-1.0-src

2. Start Maven Test target

        $ mvn clean test

The target should finished successfully and contain a summary of tests executed.


## Built With

* [Java](https://www.java.com/) - Program language
* [Maven](https://maven.apache.org/) - Dependency Management


## Versioning

Usually, we use [SVN](https://subversion.apache.org/) or 
[GIT](https://github.com/) for software versioning. But for this small project 
we have not yet generated a version tag. 

## Authors

* **Uwe Heber** - *Initial work* - [Uwe Heber](mailto:uwe@heber.it)


## License

This project is licensed under the MIT License - see the 
[LICENSE.md](https://opensource.org/licenses/MIT) file for details