Overview
For this assignment, I would like you to use a Test-Driven-Development (ish) approach to complete some features in a Tic Tac Toe program.

Project Setup
A semi-implemented Tic Tac Toe game can be found in this repo (Links to an external site.). Please clone this repository and then make your own separate repository (not a fork) on GitHub that you can push an updated version to. The semi-implementation for this project already includes the libraries you'll need to complete this assignment.
Note: You will need Java 17 specifically for this project. Sorry! I realized some nice Java features were only introduced in 14+

Expected Game Play
When the Tic Tac Toe program is complete, you should have a CLI Tic Tac Toe game. It will "render" the board on the console and allow the user to input moves as coordinates. It should also detect when the game is over.

Implementation
The goal for this assignment is to complete the Tic Tac Toe program. Luckily for you, the structure for the program is already defined and you should just be able to add some code to implement different methods. Each method that requires an implementation is marked with a TODO method that defines what is needed. Furthermore, most methods that you will need to implement have a few unit tests that define the expected behavior. Once you write your implementations, you should be able to run the tests and make sure they pass.

Additional Testing
The InputParser class has already been implemented for you. It takes a coordinate that the user has previously input as a string. The string specifies the coordinate on the Tic Tac Toe board that the user wants to pick. It should be of the form "row,col" where row and col are integers between 0 and 2. If the user inputs a valid coordinate, InputParser converts it to a CellSelection object. If the user inputs something invalid, the InputParser throws an exception. See the code and the test class for more details about the kinds of errors it checks for.

Please write tests for the different behaviors called out in the InputParserTest TODO comment

Submitting
Similar to the past assignments, please make a private GitHub repository for your solution (not a fork) and submit a link to that repo. Please don't forget to make me a collaborator!
