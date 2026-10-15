package codeorbit_tasks;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
	String name;
	double marks;

	public Student(String name, double marks) {
		this.name = name;
		this.marks = marks;
	}
}

public class StudentGradeManagement {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Student> studentList = new ArrayList<>();

		System.out.print("Enter total number of students: ");
		int total = scanner.nextInt();
		scanner.nextLine();

		for (int i = 0; i < total; i++) {
			System.out.println("\n--- Student #" + (i + 1) + " Details ---");
			System.out.print("Enter Name: ");
			String name = scanner.nextLine();

			System.out.print("Enter Marks: ");
			double marks = scanner.nextDouble();
			scanner.nextLine();

			studentList.add(new Student(name, marks));
		}

		if (!studentList.isEmpty()) {
			double totalSum = 0;
			double highest = studentList.get(0).marks;
			double lowest = studentList.get(0).marks;
			String topStudent = studentList.get(0).name;
			String lowStudent = studentList.get(0).name;

			for (Student s : studentList) {
				totalSum += s.marks;
				if (s.marks > highest) {
					highest = s.marks;
					topStudent = s.name;
				}
				if (s.marks < lowest) {
					lowest = s.marks;
					lowStudent = s.name;
				}
			}

			double average = totalSum / studentList.size();

			System.out.println("\n->------------------------------<-");
			System.out.println("     STUDENT SUMMARY REPORT      ");
			System.out.println("=================================");
			System.out.printf("%-15s %-10s\n", "Name", "Marks");
			System.out.println("->--------------------------------<-");
			for (Student s : studentList) {
				System.out.printf("%-15s %-10.2f\n", s.name, s.marks);
			}
			System.out.println("---------------------------------");
			System.out.printf("Average Marks : %.2f\n", average);
			System.out.printf("Highest Marks : %.2f (%s)\n", highest, topStudent);
			System.out.printf("Lowest Marks  : %.2f (%s)\n", lowest, lowStudent);
			System.out.println("=================================");
		}

		scanner.close();
	}
}