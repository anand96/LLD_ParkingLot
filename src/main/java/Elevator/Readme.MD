

## Requirements

### Elevator should move up and down 
### Button to control the car
    1. Inside elevator car on the button panel
    2. On Floor to the elevator 
### Dispatcher unit Algo
### 100 floors building and 20 elevators
### zone wise divivde 1--20 ==> e1, 21-40 ==>e2
### Door Open closed 
### Limitions on car




### UML Diagram

Elevator Car

Button Panel
Door

boolean isMoving
boolean isMovingUp
int currentFloor
int startFloor
int endFloor

moveToFloor(int floorToMoveTo)

Dispatcher Unit

interface  ButtonPanel

boolean
sendInstructionToDispatcher(int currFloor,int destFloor, int isMoving)

for floor

boolean isMovingUp
sendInstructionToDispatcher(null, currFloor,boolean isMovingUp)

for lift

Map<int,boolean> floorstatus
sendInstrcutions(currFloor,oestFloor, calisMovingUp)

Door ==>

boolean isOpen
boolean closeTheDoor()
boolean openTheDoor()


Elevator LLD

List<Elevator> allElevators
List<Floors> allFloors

startElvatorSystem()
stopSystem()

Floor   ==>

int currentFloor
ButtonPanel buttonPanel

callElevator(int currentFloor, button panel)


Algorithms

1. First come First Serve // works for 1 elevator


# NEW VIDEO

Think Software : https://www.youtube.com/watch?v=siqiJAJWUVg&t=36s

## Requirement

 1. States : Idle, 
 2. Transfer passengers from one floor to another
 3. Open Door <- when idle at a floor
 4. 200 Elevators floor + 50 elevator cars
 5. Specs of Elevator car : No Of Passengers, Maximum load and max speed
 6. Minimize  : Wait Time of System, Wait time of Passenger
 7. Throughput
 8. Power Uses Minimize
 9. Divide into operational zones 