# JavaFX Mini Calculator

A desktop calculator application developed using **Java** and **JavaFX**.  
This project includes a graphical user interface, button event handling, and custom calculation logic.

## Features

- Graphical user interface built with JavaFX
- Basic arithmetic operations:
  - Addition (+)
  - Subtraction (-)
  - Multiplication (*)
  - Division (/)
  - Modulo (%)
  - Power (^)
- Clear button
- Delete last character button
- Error detection for invalid expressions
- Custom expression processing and calculation engine

## Technologies Used

- Java
- JavaFX
- CSS (for interface styling)

## Project Structure
src/
├── CalculatorInterface.java # JavaFX user interface
└── Calculation.java # Calculation logic

CalculatorInterfaceCss/
└── CalculatorInterface.css # Interface styling

## How It Works

The project is divided into two main parts:

- **CalculatorInterface**
  - Creates the graphical interface.
  - Handles button clicks.
  - Displays the user's input and results.

- **Calculation**
  - Processes the mathematical expression.
  - Performs the requested operations.
  - Returns the calculated result.

## Screenshot

CalculatorApp/src/Calculator.png


## Future Improvements

- Support decimal numbers
- Add operator priority (PEMDAS)
- Support parentheses
- Add keyboard input
- Improve error messages

## Author

Mahmoud Chaabani
