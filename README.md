# ISMiner

This repository implements algorithms for mining interesting sequences in dynamic attributed graphs. The program is designed to calculate the frequency of subgraphs within graphs and can be run with different interestingness measures.

## Requirements

1. **Java 8 or higher** is required to run the program.
2. Ensure that all necessary libraries and dependencies are set up in your project.

## Running the Program

### Step 1: Open the Project in IntelliJ IDEA

If you're using IntelliJ IDEA, simply open the project directory in the IDE. IntelliJ will automatically detect the `.java` files and compile them when you run the program. No need for a manual compilation step.

### Step 2: Run the `MainISMiner.java`

To run the program, execute the `MainISMiner.java` file. This file is the entry point for testing the subgraph mining algorithm.

In IntelliJ IDEA:
1. Right-click on the `MainISMiner.java` file.
2. Select **Run 'MainISMiner'** from the context menu.

Alternatively, you can use the **Run** button in the IDE toolbar after opening `MainISMiner.java`.

### Step 3: Configure the Parameters

Before running the program, you can configure the following parameters to customize the mining process:

- **discretizationThreshold**: The discretization threshold is an anti-interference coefficient to set trends. For example, if the value is 0.1, it means when (next_value - cur_value) >= 0.1, the trend is '+'. When (next_value - cur_value) <= -0.1, the trend is '-'. Otherwise, the trend is '='.
  
- **minInitSup**: The threshold for the support of the first item to filter infrequent patterns in advance.

- **minHeadSup**: A frequent sequence should satisfy the support threshold.

- **minAll**: The all-confidence threshold.

- **exhibit_supporting_points**: If it is true, then output extra supporting points for frequent graph sequences.

### Details
After running the `MainISMiner.java`, users can choose whether to run the `GraphToDot.java` to obtain the GraphViz (DOT) Files. GraphViz is a graph description language that uses the “DOT format” to define and represent graphs for analysis and visualization. These files describe graphs using a simple text-based syntax, making them easy to create and edit.

### Example Command

To run the program with minimum head support and an all-confidence, the command would look like:

```bash
float discretizationThreshold = 0.1f;
float minInitSup = 0.005f; 
float minHeadSup = 0.01f;  
float minAll = 0.04f;  
boolean exhibit_supporting_points = true;


