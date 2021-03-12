package problem1;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

public class VCPTest {

	@Test
	public void test() {
		Directory directory = new Directory("home");
		DirectoryTree directoryTree = new DirectoryTree(directory);
		// test for adding new directory
		assertEquals(true, directoryTree.addChild(new Directory("org")));
		// test for adding existing directory
		assertEquals(false, directoryTree.addChild(new Directory("org")));
		// test for adding new directory
		assertEquals(true, directoryTree.addChild(new Directory("com")));
		// test for changing directory which is not sub directory
		assertEquals(false, directoryTree.changeDirectory("google"));
		// test for changing directory which is a sub directory
		assertEquals(true, directoryTree.changeDirectory("com"));
		// test for Moving to parent directory
		assertEquals(true, directoryTree.changeDirectory("bk"));
		// test for Moving to parent directory when no more parent directory
		// exist
		assertEquals(false, directoryTree.changeDirectory("bk"));
	}

}
