package org.example;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Koby Montenegro
 */

import java.util.ArrayList;
import java.util.Scanner;

class App
{

    public static int max(ArrayList<Integer> inputs)
    {
        int Max = -999999;

        //cycles through all the numbers to find the max
        for (int i = 0; i < inputs.size(); i++)
        {
            if(inputs.get(i) > Max)
            {
                Max = inputs.get(i);
            }
        }

        return Max;
    }

    public static int min(ArrayList<Integer> inputs)
    {
        int Min = 999999;

        //cycles through all the numbers to find the min
        for (int i = 0; i < inputs.size(); i++)
        {
            if(inputs.get(i) < Min)
            {
                Min = inputs.get(i);
            }
        }

        return Min;
    }

    public static double average(ArrayList<Integer> inputs)
    {
        int average;
        int sum = 0;

        //cycles through all the numbers to add
        for (int i = 0; i < inputs.size(); i++)
        {
            sum = sum + inputs.get(i);
        }

        //gets the average
        average = sum / inputs.size();
        return average;
    }

    public static double std(ArrayList<Integer> inputs)
    {
        double sum = 0.0;
        double standardDeviation = 0.0;

        for (int i = 0; i < inputs.size(); i++)
        {
            sum += inputs.get(i);
        }

        double mean = average(inputs);

        for (int i = 0; i < inputs.size(); i++)
        {
            standardDeviation += Math.pow(inputs.get(i)- mean, 2);
        }

        return Math.sqrt(standardDeviation/inputs.size());
    }


    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> inputs = new ArrayList<>();
        String input = "";


        while(!(input.equals("done")))
        {
            try {
                System.out.print("Enter a number: ");
                input = scan.nextLine();
                inputs.add(Integer.parseInt(input));
            }
            catch(NumberFormatException exception)
            {
                break;
            }
        }

        System.out.print("Numbers: ");

        for( int i = 0; i < inputs.size(); i++)
        {
            if(inputs.get(i).equals(inputs.get(inputs.size()-1)))
            {
                System.out.print(inputs.get(i));
                continue;
            }
                System.out.print(inputs.get(i) + ", ");
        }

        System.out.println("\nThe average is " + average(inputs));
        System.out.println("The minimum is " + min(inputs));
        System.out.println("The maximum is " + max(inputs));
        System.out.println("The standard deviation is " + Math.round(std(inputs)*100.00)/100.00);
    }
}
