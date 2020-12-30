package homework.myProject.service;

import homework.myProject.config.DBPaths;
import homework.myProject.main.User;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService implements DBPaths {

    private static final UserService instance = new UserService();

    private UserService() {

    }

    public static UserService getInstance() {
        return instance;
    }

    public void addUser(String fullName, String username, String email, String password) {
        String validate = validation(fullName, username, email, password);
        if (!validate.isEmpty()) {
            System.out.println(validate);
            return;
        }
        User user = new User(fullName, username, email, password);
        String data = String.join(",", user.getFullName(), user.getUsername(), user.getEmail(), hashingPassword(user.getPassword())) + "\n";
        try {
            Files.write(usersPath, data.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("You are successfully registered");
    }

    public User getUser(String username, String password) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(usersPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //fullname,username,email,password
        for (String line : lines) {
            String[] current = line.split(",");
            if (username.equals(current[1])) {
                if (hashingPassword(password).equals(current[3])) {
                    return new User(current[0], current[1], current[2], password);
                }
                return null;
            }
        }
        return null;
    }

    private boolean checkUserName(String username) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(usersPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, User> map = new HashMap<>();
        for (String line : lines) {
            String[] current = line.split(",");
            User user = new User(current[0], current[1], current[2], current[3]);
            map.put(current[1], user);
        }
        return map.containsKey(username);

    }

    private String validation(String fullName, String username, String email, String password) {
        if (!(fullName.matches("[A-Z][a-z]+\\s+[A-Z][a-z]+"))) {
            return "Invalid Full Name";
        }
        if (!(username.length() > 10)) {
            return "Please enter a valid username.";
        }

        if (checkUserName(username)) {
            return "This username already is used";
        }
        if (!email.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])")) {
            return "Please enter a valid email address.";
        }
        if ((!(password.length() > 8) || !password.matches("^(.*?[A-Z]){2,}.*$") ||
                !password.matches("^(.*?\\d){2,}.*$") || password.contains(" "))) {
            return "Invalid password. Password must contain 2 uppercase letters, 3 numbers, not contain space and be longer than 8 symbols";
        }

        return "";

    }

    private String hashingPassword(String password) {
        String hashtext = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);

            hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashtext;
    }

}
