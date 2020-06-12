# JavaRpgGameDemo
This project was made in 2016-17 during high school as my first real exploration into programming a game from scratch. 
at the time I had never used git before, so these files stayed on my desktop for a long while.
## About the Game
The game is called Wild, and it is currently much different than my original intention. I wanted to make an rpg game as I had 
grown up playing Pokemon and dragon quest, but I wanted the player character to go through a story that was a little more
serious than those found in Pokemon. 
## Programing tasks
I creating the game engine, which could handle a tile based overworld with keyboard and
mouse controls, a sounds and animation system, a combat and menu system, a map creation program, and a png based text rendering system.
The engine ran very quickly in both the overworld and combat (as to be expectid with the relatively low resolution) but my engine had
several limits due to my inexpirience with developing engines. 
## Art and music
- In order to create a game alone, I had to learn a lot about composing music from keys to chord progressions and at first I did this
learning in FLstudio. I later learned that FLstudio would not allow for the commercial redistribution of their samples and so I switched
to a much more minimal program called Bosca Ceoil. This limit along with my new understanding of music theory made for some pretty strange
tracks, but overall I was happy with how things turned out at the time. looking back the mixing was pretty terrible but lessons 
were learned
- I also had to learn about pixel art and art in general including some color theory and along with that I learned to use tools 
like Pyxel Edit for creating both sprites and maps for my game. 
- I also learned the basics of animation from the 12 basic principles of animation to some tricks when dealing with pixel art.
## limits of the engine
- The overworld was limited to 1 background layer and 1 forground layer. This means that it was impossible to may a rock sprite and 
place it over both grass and sand and have the background work correctly because only the background layer had colision. 
- The combat engine could only handle 3 vs 3 turn based battles and the GUI I had programed was somewhat limited.
- I used the CPU for rendering 
- Java is not the fastest language
- I did not know how to pass functions as arguments so I had to work around this by using less efficient algorithms in some cases
such as collision.
- adding new tiles required new classes and my engine was created with an object oriented paradigm because I did not know about the
entity component system and I did not know about CPU cache misses or programming with a data driven approach. This engine did
not handle a large numebr of entities at any given time and I did not run into the diamond of death so it was ok.
## The reason for stopping this project
- after creating the game engine, I as assigned a project in Irish Lit where I had to make something creative that would be
informative on Irish culture and myths I used this game engine to create a simple game about an old Irish story involving
a hero named Cuchulain. 
- In creating this project I realized the limits of the engine and also the rushed nature of my sprites and 
I decided to do a complete asset overhaul for me real game after the project was done. While I was redoing the sprites (which never
got added to the game) I was taking an AI class and found out about genetic algorithms and machine learning and it stole
my interest and I forgot about this game until I repurposed some of the assets for a new game written in C++ I am making called
ThePathWeTraveled. (also on my github)
