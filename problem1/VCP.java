package problem1;

import java.util.Arrays;
import java.util.Scanner;

public class VCP {
	public static void main(String[] args) {
		Directory directory = new Directory("home");
		DirectoryTree directoryTree = new DirectoryTree(directory);
		String command = new String();
		Scanner scanner = new Scanner(System.in);
		directoryTree.addChild(new Directory("com"));
		directoryTree.addChild(new Directory("org"));
		directoryTree.changeDirectory("com");
		directoryTree.addChild(new Directory("metacube"));
		directoryTree.changeDirectory("bk");
		directoryTree.changeDirectory("org");
		directoryTree.addChild(new Directory("metacube"));
		directoryTree.addChild(new Directory("google"));
		directoryTree.changeDirectory("bk");
		while (true) {
			String cwd = getCurrentPath(directoryTree);
			System.out.println(cwd + ">");
			command = scanner.nextLine();
			String commands[] = command.split(" ", 2);
			switch (commands[0]) {
			case "cd":
				if (commands.length < 2) {
					System.out.println("Invalid command");
				} else {
					if (!directoryTree.changeDirectory(commands[1])) {
						System.out.println("No such directory");
					}
				}
				break;

			case "bk":
				if (!directoryTree.changeDirectory(commands[0])) {
					System.out.println("you already in root directory");
				}

				break;

			case "mkdir":
				if (commands.length < 2) {
					System.out.println("Invalid command");
				} else if (!directoryTree.addChild(new Directory(commands[1]))) {
					System.out.println("directory already exists ");
				}
				break;

			case "ls":
				directoryTree.displaySubDirectory();
				break;

			case "tree":
				directoryTree.displayTree(directoryTree.getCurrentNode());
				break;

			case "find":
				if (commands.length < 2) {
					System.out.println("Invalid command");
				} else {
					directoryTree.findDirectory(commands[1]);
				}
				break;

			case "exit":
				return;
			default:
				System.out.println("command does not exist");

			}

		}
	}

	private static String getCurrentPath(DirectoryTree directoryTree) {
		String cwd = new String();
		Node temp = directoryTree.getCurrentNode();
		while (temp != null) {
			cwd = temp.getKey().getDirectoryName() + "\\" + cwd;
			temp = temp.getParent();
		}

		return cwd;
	}
}
