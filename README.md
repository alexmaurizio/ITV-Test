# ITV-Test
A simple assignment for a test in Java

___

The MVP consists in a file loader (-hardcoded paths for now-) which loads two easily switchable "database" files, which are actually semicolon-separated text files (not exactly CSVs but you get the idea..)

Using those data, the program populates an internal database of Products and then starts the Scan Engine.

The method .acceptScan(SKU) for the controller simulates a bar scanner input: it reads a string, and matches it against the internal database, populating a temporary invoice without calculating prices.  

When the scan is completed, the .calculate() method can be called, which will print out a nice invoice with all the prices, special discount offers, and the total, of course.

___

### Database File Structure

#####PRODUCT_DB
The file **product_db** contains a list of products that will be loaded by the scanner.

Each line is a product, values semicolon-separated.

_structure_: SKU;NAME;PRICE

_PRICE is decimal, dot separated_

#####SPECIAL_PRICES
The file **special_prices** contains a list of special prices for some products, that will be matched against the original database and populated when needed

Each line is a product, values semicolon-separated.

_structure_: SKU;TRIGGER;SPECIALPRICE

_SPECIALPRICE is decimal, dot separated_

NOTE: Trigger is the "Number of Products that are discounted together"

EG: If you buy 3 (trigger) the special price will be applied

NOTE: If you buy multiple special offers, those will be counted! You can buy as many special offers you want (eg: 9 x specialprice x3 + 1 non-special priced)