import java.util.Random;

public class HillClimbing {
    public static void main(String[] args) {
        // Define the problem domain and initial solution
        int[] initialSolution = {2, 5, 8, 3, 1, 6, 4, 7};
        int maxIterations = 1000;

        // Call the hill climbing function to find the best solution
        int[] bestSolution = hillClimbing(initialSolution, maxIterations);

        // Print the best solution
        System.out.println("Best Solution: ");
        printArray(bestSolution);
    }

    // Hill Climbing Algorithm
    public static int[] hillClimbing(int[] initialSolution, int maxIterations) {
        int[] currentSolution = initialSolution.clone();
        int currentObjective = evaluate(currentSolution);

        for (int i = 0; i < maxIterations; i++) {
            int[] neighborSolution = getNeighborSolution(currentSolution);
            int neighborObjective = evaluate(neighborSolution);

            // Move to the better neighbor if it improves the objective
            if (neighborObjective > currentObjective) {
                currentSolution = neighborSolution;
                currentObjective = neighborObjective;
            }
        }

        return currentSolution;
    }

    // Generate a neighboring solution by swapping two random elements
    public static int[] getNeighborSolution(int[] solution) {
        int[] neighborSolution = solution.clone();
        Random random = new Random();
        int i = random.nextInt(solution.length);
        int j = random.nextInt(solution.length);

        // Swap two elements in the array to get a neighbor solution
        int temp = neighborSolution[i];
        neighborSolution[i] = neighborSolution[j];
        neighborSolution[j] = temp;

        return neighborSolution;
    }

    // Evaluate the quality of a solution using an objective function
    public static int evaluate(int[] solution) {
        // Objective function: higher values are better
        int score = 0;
        for (int i = 0; i < solution.length - 1; i++) {
            if (solution[i] < solution[i + 1]) {
                score++;
            }
        }
        return score;
    }

    // Print an array of integers
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
