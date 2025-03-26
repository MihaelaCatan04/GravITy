# GravITy: A DSL for Physics Representation
## Project Overview

Gravity is an advanced Domain-Specific Language (DSL) for Physics simulations, designed to make complex physical modeling accessible and intuitive. The project leverages ANTLR for lexical analysis and parsing, and Processing (Java) for rich, interactive visualizations.

## Team #2

- Catan Mihaela, FAF-231
- Cebotari Daniela, FAF-231
- Cebotari Daniil, FAF-231
- Gurschi Gheorghe, FAF-231
- Vornicescu Ion, FAF-231

Mentored by associate prof., Irina Cojuhari

## Project Features

Gravity supports 12 comprehensive physics simulations:

1. **Collision Simulation**
2. **Electrostatic Field**
3. **Drag Force**
4. **Attraction Force**
5. **Wave Dynamics**
6. **Uniform Motion**
7. **Accelerated Motion**
8. **Circular Motion**
9. **Gravity**
10. **Spring Dynamics**
11. **Pendulum Motion**
12. **Rolling Uphill**

## Technology Stack

- **Lexer & Parser**: ANTLR
- **Visualization**: Processing (Java)
- **Language**: Java

## Repository Structure

- `DSL_I/`: Contains lexer and parser implementation
  - `src/main/java/src/Main.java`: Running example
- `ProcessingExamples/`: Individual simulation visualizations which will be later connected to the interpreter

## Prerequisites

- Java Development Kit (JDK) 11 or higher
- ANTLR4
- Processing Library

## Installation & Setup

1. Clone the repository
```bash
git clone https://github.com/MihaelaCatan04/GravITy
cd GravITy
```

2. Compile the project
```bash
javac DSL_I/src/main/java/src/*.java
```

## Running the Project

### Main Application
Navigate to the project root and run:
```bash
java -cp DSL_I/src/main/java src.Main
```

### Individual Simulation Visualizations
Navigate to `ProcessingExamples/` and run specific simulations:

```bash
# Example for Accelerated Uniform Motion
java AcceleratedUniformMotion
```

Replace `AcceleratedUniformMotion` with any of the following:
- `Collision`
- `ElectrostaticField`
- `DragForce`
- `AttractionForce`
- `Wave`
- `UniformMotion`
- `CircularMotion`
- `Gravity`
- `Spring`
- `Pendulum`
- `RollingUphill`

## Information

This project is part of the Elaboration of Domain-Specific Languages (PBL) course at the Technical University of Moldova, within the Faculty of Computers, Informatics, and Microelectronics, as part of the Software Engineering programme.
