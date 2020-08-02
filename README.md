This type code does not run if executed from an IDE.

Following steps are required to execute this code:
1.Paste the code into some directory
2.Open the ubuntu terminal and move to that directory.
3.Type the following commands:
	a. $javac *.java (For compiling the program)
	b. $rmic Bank (Generates skeletons and stubs)
	c. $rmiregistry &
	d. $java Initializer (For running the Target program)
4. Now, open the second terminal.
5. Type the following commands in the second terminal:
	a. $javac Source.java (For compiling the Source class)
	b. $java Source (For running the Source program)
6. It will be observed that the client-side code will send request for the target service, the output of which will be displayed to server side as well.
