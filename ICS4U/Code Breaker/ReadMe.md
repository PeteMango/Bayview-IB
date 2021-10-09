# Code-Breaker
## Instructions
Code-Breaker, more commonly known as Mastermind, is a `2 player` game where
one player creates a code (`1-8 pegs` in length) consisting of `1-8 colours` and the other player tries to guess the code in the least number of tries. After 
each guess, the person who creates the code will give feedback in three forms:
`Red, Black or Gray` pegs. The first type of response is a red peg, which symbolizes that one of the pegs is in the correct position and is of the correction colour. Black pegs mean that one of the pegs is correctly coloured but is not in the right position. Finally, gray pegs mean that one
of the pegs does not have the right colour and is not in the right position.

## Setting Up
When you open up your game, you will see a folder consisting of `5 files`. 
Three of the files are `.java` files, which are your actual program. When 
you want to play the game, you won't play, you would click on the `GUI.java` 
file. `Player.java` and `AI.java` are supplementary files to the main 
GUI file to ensure everything runs properly. There will also be two `.pdf`
files that contain the administrative related issues and the instructions
manual (Which you are reading right now!).

**NOTE:** 
- Please ensure that you have Java Version 1.8 or higher and to have JavaFX related files installed. Else the program will not run smoothly.
- Our program contains few images and will only load with internet, if you are offline, please be considerate that the icons will not load.

## How to Play
Our version of Mastermind is fairly simple, consisting of `2  game modes`
that comes with `2 customizations`. When you run the `GUI.java` file, you will
be greeted with a loading screen that asks for your name. When you enter your
name, you can press the submit button and will be introduced to the main screen.
The glorious main-screen will contain a large game-grid, don't be intimidated
tho, it is not the real game-board! At the top left of the screen, you will find
the menu bar, which contains `6 items`. If you want to create a code for
the AI to guess, then you should click on the first item, the `AI vs Player`
game-mode. However, if you want to guess a random code created by the AI, then
you should definitely click on the second item in the menu, the `Player vs AI`
game-mode. If you have any concerns about the rules, you can click on the third item
in the rules menu, the `Rules` menu, which will thoroughly explain
how Mastermind works and how to play as the guesser and the code-creator.
Forth item is for you to `customize the game`. In this item, you will be able to alter the length of the code and the number of colours available. If you ever 
want to save your progress and come back to it later, you can do that by
clicking on the fifth item that allows you to `save files` and find them later.
The final item in the is used when you are finished playing the game, which
will close the entire GUI program.
