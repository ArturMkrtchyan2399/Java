package homework.myProject.config;

import java.nio.file.Path;
import java.nio.file.Paths;

public interface DBPaths {
    Path usersPath = Paths.get("C:\\Users\\Artur\\IdeaProjects\\Java\\src\\homework\\myProject\\files\\users.txt");
    Path studentsPath = Paths.get("C:\\Users\\Artur\\IdeaProjects\\Java\\src\\homework\\myProject\\files\\student.txt");
    Path managersPath = Paths.get("C:\\Users\\Artur\\IdeaProjects\\Java\\src\\homework\\myProject\\files\\manager.txt");
    Path programmersPath = Paths.get("C:\\Users\\Artur\\IdeaProjects\\Java\\src\\homework\\myProject\\files\\programmer.txt");
}
