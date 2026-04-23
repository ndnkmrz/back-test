## Mars Rover refactoring kata

## How to build
```bash
./gradlew build
```

## How to run
```bash
./gradlew run -q --console=plain
```

## How to test
```bash
./gradlew test
```

## Test coverage report
```bash
./gradlew test jacocoTestReport
```

Report will be at `build/reports/jacoco/test/html/index.html`

## Project structure
```
src/main/java/marsrover/
├── MarsRover.java              # Entry point
├── domain/                     # Business logic
│   ├── Rover.java
│   ├── Position.java
│   ├── Direction.java
│   ├── Planet.java
│   ├── Obstacles.java
│   └── command/
│       ├── Command.java
│       ├── MoveForward.java
│       └── ...
└── infrastructure/
    └── ConsoleAdapter.java     # Console I/O
```