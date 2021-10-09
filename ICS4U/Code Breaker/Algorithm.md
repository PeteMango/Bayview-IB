    # Algorithm

## Player Vs Computer
- Start up screen pops up, asks for users name, and also a rule book 
    - after user presses start game button, window changes into game screen
- game screen will consist of a user input row at the bottom, and list of already completed rows at the top
    - submit button to submit the row
    - Exit button to exit the game  
    - Color wheel to select peg color for user input row
    - Pop up window for error inputs
    - Colored pegs at the side of each completed row
    - Column numbers on the side
- Game plays by following the rules of codebreaker
- If user wins, change to win screen (if user correctly guesses the code under or in 10 guesses)
- If user lose, change to lose screen (if user didn't get the code under or in 10 guesses)
- Redirect user back to main screen after verdict of the game


```
Method generateSolution(): (returns string)
Have an arraylist picked
create random
string response

while the picked size is less than the solutions length 
	the choice equals to the random index of choices
	if picked has this choice already
		continue
 	add the choice to picked
return the randomnly generated code   	

method getGuess:
Parse the guess and get the guess
check to see if the guess is valid
returns the parsed guess

method askGuess
Ask the user for the guess

method analyzeGuess(String solution, String guess) {
check to see if the guess is equal to the solution
Check to see which pegs are in the right position, right color, or just completely wrong

return the result

main method
Print rules (introduction/instructions)
generate a random code
while the game is running
	if the user uses more than the MAX_GUESSES
		break the loop
	get the guess from the user
	if the guess is the solution
		tell the user that they have won
		break the loop
	get the feedback(black/white/red pegs) from the users guess
	display the analysis/feedback to the user
	increment guesses (used to check if the user has used too many guesses)

```
## Computer vs Player
- Computer uses 3 levels of AI, they all use some version of the 5-guess algorithm 
    - Low - doesn't use minimax
    - Medium - doesn't start on optimal guesses such as `1122`
    - High - uses the full 5-guess algorithm
    - The user chooses the difficulty from the menu bar on the top of the window
- gets input from user after each guess
    - Feedback pegs
    - Checks for user input, if errorneous, tell user to re-enter
- checks to see if it has won (low difficulty should lose sometimes, high difficulty should never lose)
- after game has ended, re-direct user back to main screen

## Player Class
- contains information of the player (name)
- includes input and interactions with the other classes
- storage class

## AI Class
- Has bustcode method that guesses the code and collects information from the user
    - Uses the donald knuth 5-guess algorithm
        - generates all possible Sets of colours
        - Chooses `1122` as the start color
        - uses minimax algorithm to get the next guess
        - average 5-guess solve
- Has getHint method to interact with the gui and user input
- generates random code when player vs computer
    - Also checks user code and gives correct feedback in form of pegs 


## GUI Class
- Color wheel
   - Use either the mouse wheel or arrow keys to spin wheel to desired color 
   - Use keyboard listener to update a global variable for how turned the wheel is
   - Based on an array of colors and how turned the wheel is, Make the color at 90 degrees ont he wheel the selected color
   - Use javaFx arc to draw the individual segments of the wheel
- end screen
    - win screen
    - lose screen
    - Have an Endscreen method for all of these with a strng for the exact method. These will all redirect back to main menu
- game screen
    - draws all of the Rows with guesses
    - Make sure these variables are global so that they can be accesed
    - Have a method to draw / send a new guess from the input row to the previous rows array
    - Have a speperate row for user input
- startup screen
    - Inititally ask for user info (name, etc.) 
    - then change to menu screen
        - have Links to a screen for rules
            - Screen with pdf file handling
        - Links to PvAI game screen, AIvP gamescreen
- interacts will all classes
