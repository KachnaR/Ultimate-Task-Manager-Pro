# Introduction #
We are developing a simple Task List program for a Java class.
A console application that reads and writes records to a csv file. Includes basic input validation and exception handling.
# Features #
* Add record to list
* Remove record from list
* List list
* Save to csv file
* Load from csv file
* Date input validation (upcoming)
* Sort list (upcoming)
# Techniques #
We will practice the following Java techniques:
* Scanner for stdin: 
```
Scanner scan = new Scanner(System.in);
try {
    int number = scan.nextInt();
    System.out.println(number);
} catch (InputMismatchException e) {
    System.out.println("Invaliid input");
}
```
* Scanner for csv files w/ StringBuilder
```
File file = new File("readFile.txt");
StringBuilder reading = new StringBuilder();
try {
    Scanner scan = new Scanner(file);
    while (scan.hasNextLine()) {
        reading.append(scan.nextLine() + "\n");
    }
} catch (FileNotFoundException e) {
    System.out.println("Brak pliku.");
}
System.out.println(reading.toString());
```
To be expanded