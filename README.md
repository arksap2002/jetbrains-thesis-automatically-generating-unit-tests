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
  - Covered by tests
- `minDestination` in the `getClosestStation` method can be bigger than 100
  - Incorrect implementation
  - Covered by tests
- Fixed a bug in the `Car.driveTo` - no `Math.abs`. 
  - Creating an appropriate method in the `Location` class solves this problem
  - Covered by tests
- Fixed a bug in the `addEnergy` method: `refuel` must be before the driving to destination
  - Covered by tests
## Testing
I've corrected this code, I'm not sure what it was supposed to be, I still don't like some moments in the code. At a minimum, I would not fill in arrays of stations in the code itself. It seems to me that this should happen in tests, each different situation has its own set of points for stations. I would also implement this class a little differently - just 2 arrays of data that can be filled in from tests during init. It would also be logical to create a class “World” or something similar, in which persons, stations and cars would be stored, for example, because I don't like that inside the person there is work with “StationsPool”. This is a more understandable implementation, as well as more convenient for testing.
### Car test
- `badInitTest` - testing the `badInit` method. Checking all throws
- `driveToTest` - testing the `driveTo` method. Checking the car's location and energy value
- `refuelTest` - testing the `refuel` method. Checking the energy value
### Person test
- `goToWorkTest` - testing the `goToWork` method. Checking the car's location
- `goToHomeTest` - testing the `goToHome` method. Checking the car's location
- `addEnergyTest` - testing the `addEnergy` method. Checking the energy value
- `changeCarTest` - testing the `changeCar` method. Checking the locations of cars
- `testPerson` - was before
### Common test
- `commonTest` - a lot of roads between home and work. testing the `goToHome` method. Checking the car's location
