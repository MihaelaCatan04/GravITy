# GravITy: A DSL for Physics Representation

![Gravity Project Logo](logo_final.png)
## Project Overview

Gravity is an advanced Domain-Specific Language (DSL) for Physics simulations, designed to make complex physical modeling accessible and intuitive. The project leverages ANTLR for lexical analysis and parsing, and Processing (Java) for rich, interactive visualizations.

## Team #2

- Catan Mihaela, FAF-231
- Cebotari Daniela, FAF-231
- Gurschi Gheorghe, FAF-231
- Vornicescu Ion, FAF-231

Mentored by associate prof., dr.Irina Cojuhari

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
- **Intepreter:** Java
- **Visualization**: Java Swing
- **GUI**: JFrame
- **Language**: Java

## Repository Structure

- `DSL_I/`: Contains implementation
- `src/main/java/src/GravITyIDE.java`: Running example

## Prerequisites

- Java Development Kit (JDK) 24
- ANTLR4

## Installation & Setup

1. Clone the repository
```bash
git clone https://github.com/MihaelaCatan04/GravITy
cd GravITy
```

## Running the Project
![Run GravITyIDE](/GIFs/gif1.gif)

## Main Application
Click New to start with an empty Canvas and click Run Simulation to see the output.
![Run Simulation](/GIFs/gif2.gif)

You can use predefined templates to run simulations and change their parameters. In case the parameters are invalid, an error will be displayed and the simulation will run with predefined parameters.
![Run Simulation from template](/GIFs/gif3.gif)

You can run any of the following simulations:
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

To use loops and conditionals, you can make a reference to aforementioned properties using `_` (underscore) following the structure:
```
<conditional_value> ::= "if" <condition> "then"
<simple_value> "else" <simple_value>
<loop_value> ::= <initial_value> "repeat" <integer> "times" "*" <multiplier>
<initial_value> ::= <number>
<multiplier> ::= <number> | <simple_value>
<condition> ::= <simple_value> <comparator> <simple_value>
<comparator> ::= ">" | "<" | "==" | ">=" | "<=" | "!="
<reference> ::= "_" <identifier>
```

![Run Simulation with loops and conditionals](/GIFs/gif4.gif)

P.S: There was an Easter Egg hidden in the IDE. Good luck finding it! <3

## Information

This project is part of the Elaboration of Domain-Specific Languages (PBL) course at the Technical University of Moldova, within the Faculty of Computers, Informatics, and Microelectronics, as part of the Software Engineering programme.
