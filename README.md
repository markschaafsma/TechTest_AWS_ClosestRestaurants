# TechTest_AWS_ClosestRestaurants

### Overview



### Problem 

A diner wants to know the closest restaurants to his current location. A set of coordinates for each restaurant 
relative to the diner's current position is provided. This function should determine the closest restaurants to 
diner and return those coordinates.

### Function Description

This function will be supplied the total number of restaurants in the area, the coordinates of those restaurants 
relative to the diner, and the number of restaurants to be returned.
 
### Input

 - n    - the number of input coordinate pairs
 - list - the list of coordinate pairs
 - x -    the number of coordinate pairs to return

### Output

 - list - the list of closest coordinate pairs

### Testcases

 - Testcase 0
   - Input(stdin)
     - 2
     - [2,3],[3,1]
     - 1
   - Expected Output
     - [3,1]
 
 - Testcase 1
   - Input(stdin)
     - 3
     - [2,3],[3,1],[-1,5]
     - 2
   - Expected Output
     - [2,3],[3,1]
