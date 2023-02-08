package lt.code.academy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File("users.json");
        try {if(!file.exists()) {
            file.createNewFile();
        }
}catch (IOException e) {System.out.println("Cant create file" + e.getMessage());
            try {

                objectMapper.readValue(file, User.class);
            }catch (IOException r){
                System.out.println("Cant read from file" + r.getMessage());
            }
        }

        try {objectMapper.writeValue(file, users);
    }catch (IOException t){
            System.out.println("Cant write to file" + t.getMessage());
        }
    }
    public void menu(Scanner scanner){
        System.out.println("""
                1. Register
                2. Show all users
                """);
    }
    private void action(String userInput, Scanner scanner, List<User>users){
        switch(userInput){
            case "1" -> register(scanner, users);

            case "2" -> System.out.println("Users");
            case "3" -> System.out.println("baigti programa");
        }
    }
    private void register (Scanner scanner, List<User> users){
        System.out.println("Iveskite varda");
        String name = scanner.nextLine();
        System.out.println("Iveskite pavarde");
        String surname =scanner.nextLine();
        System.out.println("Iveskite asmens koda");
        String personId = scanner.nextLine();
        User user = new User(name, surname, personId);
        users.add(user);
    }
    private void endProgram(){

    }
}