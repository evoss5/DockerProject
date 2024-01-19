package Tests;

import java.io.IOException;

public class Docker extends BaseTest {
    static Service service = new Service(driver);
    public static void main(String[] args) throws IOException, InterruptedException {
        String command = "cmd /c start " + service.dockerPath();
        Runtime.getRuntime().exec(command);
        Thread.sleep(5000);
        String dockerRunCommand = "docker start " + service.containerName();
        Runtime.getRuntime().exec(dockerRunCommand);
    }
    }







