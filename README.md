# ITV-Test
A simple assignment for a test in Java

**THIS IS THE GUI BRANCH - IT'S JUST EXPERIMENTS FOR MAKING IT WORK WITH SWING. IGNORE IT UNTIL STABLE! CHECK MASTER :)**

___

The MVP consists in a file loader (-hardcoded paths for now-) which loads two easily switchable "database" files, which are actually semicolon-separated text files (not exactly CSVs but you get the idea..)

Using those data, the program populates an internal database of Products and then starts the Scan Engine.

The method .acceptScan(SKU) for the controller simulates a bar scanner input: it reads a string, and matches it against the internal database, populating a temporary invoice without calculating prices.  

When the scan is completed, the .calculate() method can be called, which will print out a nice invoice with all the prices, special discount offers, and the total, of course.

