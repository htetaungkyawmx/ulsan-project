import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PythonScriptExecutor {
    public static void main(String[] args) {

        String scriptPath = "scripts/db_seed.py";

        String[] command = {"python", scriptPath};

        try {

            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.environment().put("DB_HOST", "localhost");
            processBuilder.environment().put("DB_PORT", "3306");
            processBuilder.environment().put("DB_NAME", "db_aioceaneye_java");
            processBuilder.environment().put("DB_USERNAME", "root");
            processBuilder.environment().put("DB_PASSWORD", "");

            processBuilder.redirectErrorStream(true);

            Process process = processBuilder.start();

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()))) {

                String line;
                System.out.println("Output from Python script:");
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }

            int exitCode = process.waitFor();
            System.out.println("Python script exited with code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            System.err.println("An error occurred while executing the Python script:");
            e.printStackTrace();
        }
    }
}
