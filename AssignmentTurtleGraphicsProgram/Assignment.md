[Refer to the assignment spec on myBeckett](https://drive.google.com/file/d/1ooGVFk3eAOXwvRC950gcW1g2m1jtAKIX/view)

[There is useful information in the assignment spec directoty on myBeckett, including help videos](https://my.leedsbeckett.ac.uk/ultra/courses/_167312_1/cl/outline)

[OOPGraphics documentation](https://lbu-oop.github.io/OOPturtleGraphicsLibrary/uk/ac/leedsbeckett/oop/OOPGraphics.html)

# Your Task:
For this assignment you are required to develop a programmatic solution, using the Java
programming language, to the problem below. You will be required to produce a YouTube
demonstration video according to a provided Google Form Script, which MUST be
shown being filled in the video. 

The video must be uploaded to your student
YouTube account and the link pasted into the submission box. Note that some aspects
of this assignment, notably the more advanced marks in a section, may require that you find
out for yourself how to achieve a solution.

# Overview
The overall aim of this assignment is to implement a simple graphics tool. This must be built
as a graphical application using the Java Swing and/or AWT classes. The software will allow
users to type in simple commands which cause a virtual pen (sometimes it is also called a
turtle after the Logo programming language which was popular in schools in the 1980s) to
move around a virtual canvas area drawing lines as it moves.

## Requirement 1 – basic application 20 marks

The first requirement is to produce a Java project which uses OOPGraphics, which is
provided in a jar file available on the OOP myBeckett page, under Assessments. 

This class will do all the drawing and displaying when your class calls its methods (ensure
you always have the latest version of the jar file, as with any software it may be
updated). 

There is also documentation for this class in the same place on myBeckett,
which has simple instructions on how to use it. Note this documentation shows
facilities that will be of use and some that may not be needed and seem confusing
(just like the standard Java documentation).

### Mark Breakdown
Project complete using the provided Jar file OOPGraphics.jar. Your project should also have
a main class (MainClass.java) which sets up the OOPGraphics class correctly. You should
call the “about()” method in OOPGraphics which will output a simple graphic.

(10 marks)
-[x] Done

You should now make another class called TurtleGraphics.java that uses inheritance to extend
the OOPGraphics class and it should function as above (note you can go straight to this and
still get the marks for the above).

(5 marks)
-[x] Done

### Command Processing
The OOPGraphics panel has a text field and a button. You should be able to respond to text
typed into this text field. The OOPGraphics system will call your program’s
“processCommand()” method when the user presses return on the text field or clicks the ok
button. You should make it so that your program only calls the “about()” (which displays a
simple graphic) method (to draw the dancing turtle when the user types “about” into the text
field and either presses return or clicks the “ok” button.)

(5 marks)
-[x] Done

## Requirement 2 – command support 15 marks
The second requirement is to implement some basic commands to allow drawing. The
user should be able to type in these commands within the text field provided by
OOPGraphics. The application should be able to spot invalid commands and report
this to the user. 

- The commands to be supported are very explicit and MUST match those shown in the following table. 
  -[ ] Done
- The command MUST be typed in by the user and  not selected from a menu as some of them will 
have parameters which MUST be typed together with the command, for example “forward 90”. 
  - [ ] Done
- The parameters MUST not be entered separately, either after the command or in a separate text field. 
  -[ ] Done

  - Note that these commands involve calling the methods inside the OOPGraphics object. 
  - You should look at the documentation for OOPGraphics.

- When the program first runs or the reset command is issued, the turtle/pen
should be set to the middle of the canvas and point down the screen and the
pen should be set to “down”.
  -[ ] Done
  - Hence, if the first command was “forward 100” a line
  from the middle of the screen to nearer the bottom would be drawn.

## Requirement 3 Validating Commands. 10 Marks
-[ ] Reports invalid commands (i.e. something not on the commands list above). (2 marks)

-[ ] Detects valid command with missing parameter. (2 marks)

-[ ] Detects non numeric data for a parameter. (3 marks)

-[ ] Correctly bounds parameters (i.e. negative or non sensible values are reported as errors). (3
marks)

## Requirement 4 – loading, saving and exiting. 15 marks
- “Load” and “Save” should allow the user save and load the image and to save and
load a set of commands that the user has typed in.

- The current image should be saved to a file and also be able to be loaded back into
the system and drawing recommenced. 
- If the user attempts to load a new image without the current one been saved 
first then a warning should be shown to the user, which should provide the opportunity 
for the current image to be saved first. 
- [ ] Save Image (to suitable image graphics format such as png or jpeg). (2 Marks)
- [ ] Load Image and redisplayed on the display. (2 marks)
- [ ] Saves all commands previously typed as a text file. (2 marks)
- [ ] Loads a text file of commands and executes them. (5 marks)
- [ ] Warning if the current image/commands is not saved. (2 marks)
- [ ] Use of GUI dialogues. (2 marks)

## Requirement 5 – extending OOPGraphics using inheritance. 20 marks
You have so far used OOPGraphics.jar, which is a precompiled file of a class I have written
called OOPGraphics.java (technically a jar file is like a zip file and if you open it with a zip
program you will see it has OOPGraphics.class inside it, or open it in the project explorer of
Eclipse).

You have already used inheritance because you have extended the OOPGraphics class. This
is because you have been forced to add a processCommands(String) method. Without putting
it you would get a syntax error because OOPGraphics needs to call it when it detects an event
on the button or text field. You can do much more with inheritance however. 

You can add new methods and you can replace existing methods.

All of the following should be implemented as methods in your code but also as commands that the user can type at run time.
-[ ] Override the about() method so that it still does the same “dance” but appends a message
that contains your name.
about
   (4 marks)
-[ ] Make a square command that takes a parameter for the length and draws a square. The turtle
should remain in the original position after this command has been issued.
square <length>
(2 marks)
-[ ] A pencolour Command that takes three parameters, one for red, one for green and one
for blue to make an RGB colour.
pencolour <red>,<green>,<blue>
(5 marks)
-[ ] A penwidth command that takes a width for the pen so that all further drawing operations
are of the new width.
penwidth <width>
(2 marks)
-[ ] A triangle command that draws equilateral triangles with one parameter.
triangle <size>
(3 marks)
-[ ] A further triangle command which specified three sides that draws any triangle (hint –
look at polygons).
triangle <side1>,<side2>,<side3>
(4 marks)

NOTE the reset command should reset all pen colours and widths back to what they were at
the start.