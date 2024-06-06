# SnakeGame
 
This project showcases a game of snake I programmed after finishing my first OOP Java/Swing course back in 2022. 

This was also my first ever serious project and I'm still proud of the fact that I finished it, as well as how I implemented some of the things in it. (Even though I see now that there are a couple of easy to fix bugs related to unexpected user behavior) \
It's filled to the brim with many atrocities and inconsistencies in the code-writing style.

## File structure and how to run this project

This project was made as an IntelliJ project so I'm unsure if it'll work out of the box for other IDEs.
It currently includes 2 packages, _first_ and _second_ (amazing naming conventions, I know), of which _first_ is basically just trash code which I gave up on after it became too spaghetti for me. 

Everything needed for the game is in the _second_ package and the main method is "cleverly" hidden in the SnakeFrame class file.

One day I might put aside a couple of hours to add a _third_ package, which will be my reimplementation of this game in the same fashion, but in a neater, more structured way, using the knowledge I have now.

## About the project

This game is entirely made in the Java's Swing library and *without* any overriding of any paint methods or anything of that sort. \
So how does it accomplish the graphics part? 

***JPanels that act as rudimentary pixels***

Basically, there is a grid of JPanels that are colored a certain color. \
Dark green signifies the head of the snake, while light green is the body of it. \
Red is the _food_, which is an apple (like many of the old versions of snake game). \
The rest of the squares is gray.

This game has many interesting features that were tough to implement for me as a beginner, such as a **timed game loop**, a **main menu**, a **scoreboard**, and even the ability to **import and export previous highscores**. \
The import/export of highscores is done into a txt document and there is a hard-coded default list of high-scores which my friends, family and I set while testing the game. \
_Even my **grandma** set a score! (check the baka entry)_

### Game loop
All i have to say is thank god Java threads share memory amongst themselves and I didn't run into any of the _shmget_-similar problems I tackled a year later during my Operating systems course. \
This allowed me to run the JFrame window in the main thread and start a new one that would count time and update the game data when needed. \
Not to brag, but this means that _my first project was a **multi-threaded** one_. 

I also remember the pain of figuring out how to properly refresh the JFrame. I remember trying to manipulate the references to my JPanels and wondering why they still look the same. The answer? _You need to repaint it, dingus!_ \
This led to me having specific data-changing methods, which now, looking back, had the same idea as the observer design pattern.

### Main menu and highscore screens
I mentioned that the game has a main menu and a highscore screen. They were pretty fun to implement as I could let out my artistic side and designed a quick logo for the game: a snake with an apple in its mouth. \
The highscore screen is a bit clunky and the import of highscores from the text file is not validated, but _it works_ and that's all that mattered to me at the time.

### Finals thoughts
This project was the result of restlessness after the end of the exam season, when I had just passed the OOP course in question. It took me around a week of trying to get it to work (for around 5 hours a day) to finish this, and to this day it's one of the most satisfying things and/or projects I've ever done.

## Key takeaways

I still remember the things I learned while working on this thing and remember feeling like the things I learned in the OOP course only settled into my brain _after_ I finished this.

Almost everyone says this, but this project confirmed for me that **the best way to learn programming is to do a project**.

Finally, I want to nudge you to try to do that project that you've been thinking about. Maybe it is a weird idea, but one thing is for sure: you will probably learn a lot and have fun doing it. After all, it can't be as bad of an idea as _using JPanels as pixels_.