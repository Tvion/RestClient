package com.netcracker;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Scanner;

public class CalculationRestClient {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Accept operations: add, div, mul, sub, exit");
            System.out.println("Example: add 2 3");
            while (true) {
                String operation = scanner.next();
                if (operation.equals("exit")) break;
                int a = Integer.parseInt(scanner.next());
                int b = Integer.parseInt(scanner.next());
                calc(operation, a, b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }


    private static void calc(String operation, int a, int b) {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://localhost:8080/rest").path(operation + "/" + a + "/" + b);
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.post(null);
        String string = response.readEntity(String.class);
        System.out.println(string);
    }
}
