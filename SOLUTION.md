# MY SOLUTION

## Architecture

The solution follows Hexagonal Architecture principles with clear separation between domain logic and infrastructure (console I/O).

**Infrastructure:**
- ConsoleAdapter (I/O)

**Domain:**
- Rover
- Command
- Planet
- Obstacles

**Value Objects:**
- Position
- Direction
- RoverState

## Design Patterns

- **Command Pattern**: `MoveForward`, `MoveBackward`, `TurnLeft`, `TurnRight` — each command is an object, easy to extend
- **Value Objects**: `Position`, `Direction`, `RoverState` — immutable records, thread-safe by design
- **Aggregate**: `Rover` — encapsulates state and coordinates domain logic
- **Sealed Interface**: `CommandResult` (Success | ObstacleDetected) — exhaustive pattern matching, compiler-verified

## Key Design Decisions

1. Immutable value objects — `Position`, `RoverState` are records; safe to share, no defensive copying needed
2. Direction enum with behavior — `deltaX()`, `deltaY()`, `rotateLeft()`, `rotateRight()` keep related logic cohesive
3. Planet owns wrapping — spherical topology is Planet's responsibility, not Rover's
4. ConsoleAdapter separates I/O — domain has no dependency on Scanner/PrintStream

## Refactoring Approach

Used Strangler Fig pattern — replaced legacy code incrementally:

1. Added characterization tests to lock existing behavior
2. Fixed bug: rotation commands were cascading through all if-conditions
3. Extracted value objects (`Direction`, `Position`)
4. Moved behavior into value objects (`Direction.deltaX()`, `Position.move()`)
5. Extracted `Planet` with wrapping logic
6. Extracted Command pattern
7. Extracted `Rover` aggregate
8. Added obstacle detection (bonus feature)
9. Separated infrastructure (`ConsoleAdapter`)

Each commit compiles and passes tests.

## Test Coverage

- Domain: 90%+ coverage
- Commands: 95%+ coverage
- Parameterized tests for all movement/rotation combinations
- Dedicated tests for obstacle detection and edge wrapping

## Future Improvements

- REST/GraphQL adapter (domain unchanged)
- Multiple rovers with collision detection
- Different terrain types (slow, impassable)
- Event sourcing for command history
- Undo/redo functionality
