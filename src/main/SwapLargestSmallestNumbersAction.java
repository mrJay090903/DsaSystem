package main; // Package declaration

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwapLargestSmallestNumbersAction implements ActionListener {
    private JFrame menuFrame; // Reference to the menu frame for displaying messages

    // Constructor to initialize the SwapLargestSmallestNumbersAction with a menu frame
    public SwapLargestSmallestNumbersAction(JFrame menuFrame) {
        this.menuFrame = menuFrame; // Initialize the menu frame reference
    }

    public void actionPerformed(ActionEvent e) {
        String input = JOptionPane.showInputDialog(menuFrame, "Enter 10 numbers separated by spaces:"); // Prompt the user for input

        try {
            String[] numberStrings = input.split(" "); // Split the input into an array of number strings
            if (numberStrings.length != 10) {
                // Display an error message if the user did not provide exactly 10 numbers
                JOptionPane.showMessageDialog(menuFrame, "Please enter exactly 10 numbers separated by spaces.");
                return; // Exit the action if the input does not contain exactly 10 numbers
            }

            int[] numbers = new int[10]; // Create an array to store the parsed numbers

            // Loop to parse and store the numbers
            for (int i = 0; i < 10; i++) {
                numbers[i] = Integer.parseInt(numberStrings[i]); // Parse the number string as an integer
            }

            int smallestIndex = 0; // Initialize the index of the smallest number
            int largestIndex = 0; // Initialize the index of the largest number

            // Loop to find the indices of the smallest and largest numbers among the user-input numbers
            for (int i = 1; i < numbers.length; i++) {
                if (numbers[i] < numbers[smallestIndex]) {
                    smallestIndex = i; // Update the index of the smallest number if a smaller one is found
                } else if (numbers[i] > numbers[largestIndex]) {
                    largestIndex = i; // Update the index of the largest number if a larger one is found
                }
            }

            // Swap the smallest and largest numbers in the array
            int temp = numbers[smallestIndex];
            numbers[smallestIndex] = numbers[largestIndex];
            numbers[largestIndex] = temp;

            // Create a message to display the swapped numbers
            StringBuilder result = new StringBuilder("Swapped smallest and largest numbers: ");
            for (int number : numbers) {
                result.append(number).append(" ");
            }

            // Display the result in a dialog box
            JOptionPane.showMessageDialog(menuFrame, result.toString());
        } catch (NumberFormatException ex) {
            // Display an error message if the input is not valid numbers separated by spaces
            JOptionPane.showMessageDialog(menuFrame, "Invalid input. Please enter 10 valid numbers separated by spaces.");
        }
    }
}
