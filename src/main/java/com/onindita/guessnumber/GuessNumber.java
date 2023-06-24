package com.onindita.guessnumber;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber{

	public static void main(String[] args) {

		int lowerBound = 1;
		int upperBound = 10;
		int number = generateRandNumber(lowerBound, upperBound);

		final int totalAttempt = 3;
		int attempt = 0;
		int userInput = 0;

		System.out.println("You have maximum " + totalAttempt + " attempts to guess the correct number.");

		while(attempt < totalAttempt) {

			userInput = takeInput(lowerBound, upperBound);

			if(compareNumber(userInput, number)) break;

			attempt++;
		}

		if(attempt == totalAttempt) {
			System.out.println("Sorry you lost :(");
			System.out.println("The correct number was " + number);
		}
	}

	private static int generateRandNumber(int lowerBound, int upperBound) {
		int number = 0;
		Random rand = new Random();
		number = rand.nextInt(lowerBound, upperBound);
		return number;
	}

	public static boolean compareNumber(int userInput, int number){
		if(userInput < number) {
			System.out.println("The guessed number is smaller than the correct number. ");
		} else if (userInput > number){
			System.out.println("The guessed number is greater than the correct number. ");
		} else {
			System.out.println("Yay!!! You guessed the right number!");
			return true;
		}
		return false;
	}

	public static int takeInput(int lowerBound, int upperBound){
		Scanner scanner = new Scanner(System.in);
		int userInput = 0;
		System.out.println("Guess a number between " + lowerBound + " and " + upperBound + ": ");

		do {
			userInput = scanner.nextInt();
			if(userInput >= lowerBound && userInput <= upperBound){
				break;
			}
			System.out.println("Enter a valid number between " + lowerBound + " and " + upperBound + ": ");
		} while(userInput < lowerBound || userInput > upperBound);

		return userInput;
	}
}
