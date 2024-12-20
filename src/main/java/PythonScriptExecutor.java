import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class PythonScriptExecutor {
    public static void main(String[] args) {
        // Path to the Python script
        String scriptPath = "scripts/db_seed.py"; // Adjust the path if necessary

        // Command to execute the Python script
        String[] command = {"python", scriptPath};

        try {
            // Create a ProcessBuilder instance
            ProcessBuilder processBuilder = new ProcessBuilder(command);

            // Redirect error stream to capture both output and errors
            processBuilder.redirectErrorStream(true);

            // Start the process
            Process process = processBuilder.start();

            // Capture the output
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()))) {

                String line;
                System.out.println("Output from Python script:");
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }

            // Wait for the process to finish and capture the exit code
            int exitCode = process.waitFor();
            System.out.println("Python script exited with code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            System.err.println("An error occurred while executing the Python script:");
            e.printStackTrace();
        }
    }
}
