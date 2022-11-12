# TestAssignment

## Requirements
- Java 11
- Maven

## Fixing
- Reformatted Code
  - It is necessary to write beautiful formatted code for more understanding of the code by the programmer and other people
- Added `final` to immutable class fields
  - Many fields, such as `location` or `id` for objects are often immutable. They need to be made `final'
- Created the `Location` class because the 2D space in the problem
  - The description of the problem says that location has 2 coordinates
- Extracted magic numbers and strings to the `Utils` class
  - The code uses a lot of numeric parameters, as well as string error messages and logs. They must be moved to a separate place so that they can be conveniently changed
- Add `IllegalArgumentException` in the `Car` init 
  - Asymmetric validation of the parameter for correctness
- `minDestination` in the `getClosestStation` method can be bigger than 100
  - Incorrect implementation
  - Added a new test
- Fixed a bug in the `Car.driveTo` - no `Math.abs`. 
  - Creating an appropriate method in the `Location` class solves this problem
  - Added a new test
## Testing
### Regression tests
### Unit tests
### Class integration tests
