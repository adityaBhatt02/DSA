/*
There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of 
the gas stations.
Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists
a solution, it is guaranteed to be unique.

Example 1:
Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
Output: 3

Example 2:
Input: gas = [2,3,4], cost = [3,4,3]
Output: -1


Approach is that first of all its a circular loop like so after last station it goes to station 0 so whatever the station which doesnt give us -ve till the last station like the gas.length - 1
that station is the answer for eg if we start with station 4 then goes to station 5 then calculate the net and add if at last station its not -ve then station from that it is started is the 
answer becz we already saturated that is the answer even possible at the start doing totalGas and totalCost and then starts with station 0 and then goes till we have no -ve currentGas becz if we 
found -ve in currentGas means it can not be that station from where we started and anything in b/w where we are currently so thats why i + 1 and then currentGas starting from 0 again.
*/

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;

        for(int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if(totalGas < totalCost) return -1;

        int currentGas = 0, station = 0;
        for(int i = 0; i < gas.length; i++) {
            currentGas += gas[i] - cost[i];

            if(currentGas < 0) {
                station = i + 1;
                currentGas = 0;
            }
        }
        return station; 
    }
}
