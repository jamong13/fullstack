package a260126;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class StudentManager {
    private static final String OUTPUT_FILE = "c:/Users/limeh/student/data.txt";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("=== 학생 관리 프로그램 ===");
            System.out.println("1. 학생 정보 등록 (새로 저장)");
            System.out.println("2. 학생 목록 읽기");
            System.out.println("3. 학생 목록 추가");
            System.out.println("4. 종료");
            System.out.print("선택 > ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    writeNewStudent(sc);
                    break;

                case 2:
                    readStudentList();
                    break;

                case 3:
                    appendStudentList(sc);
                    break;

                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    break;
            
                default:
                    System.out.println("잘못된 선택입니다.");
                    break;
            }
            System.out.println();
        }
    }

    private static void appendStudentList(Scanner sc) {
        System.out.println("학생 정보 입력(종료: 빈줄 입력)");
        StringBuilder content = new StringBuilder();
        String line;
        
        while (true) {
            line = sc.nextLine();
            if(line.isEmpty()){
                break;
            }
            content.append(line).append("\n");
        }

        File outputFile = new File(OUTPUT_FILE);
        File parentDir = outputFile.getParentFile();
        if(parentDir != null && !parentDir.exists()){
            parentDir.mkdirs();
            System.out.println("디렉토리가 생성되었습니다." + parentDir.getPath());
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE, true))) {
            bw.write(content.toString());

        } catch (Exception e) {
            System.out.println("파일 쓰기 오류: " + e.getMessage());
        }
    }

    private static void readStudentList() {
        File file = new File(OUTPUT_FILE);
        if(!file.exists()){
            System.out.println("파일이 존재하지 않습니다.");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(OUTPUT_FILE))) {
            System.out.println("=== 학생 목록 ===");
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("파일 읽기 오류: " + e.getMessage());
        }
    }

    private static void writeNewStudent(Scanner sc) {
        System.out.println("학생 정보 입력(종료: 빈줄 입력)");
        StringBuilder content = new StringBuilder();
        String line;
        
        while (true) {
            line = sc.nextLine();
            if(line.isEmpty()){
                break;
            }
            content.append(line).append("\n");
        }

        File outputFile = new File(OUTPUT_FILE);
        File parentDir = outputFile.getParentFile();
        if(parentDir != null && !parentDir.exists()){
            parentDir.mkdirs();
            System.out.println("디렉토리가 생성되었습니다." + parentDir.getPath());
        }

        boolean fileExists = outputFile.exists();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
            bw.write(content.toString());
            if (fileExists) {
                System.out.println("기존 파일 덮어쓰고 " + OUTPUT_FILE + "에 저장되었습니다.");
            }else {
                System.out.println("새 파일을 생성하여 " + OUTPUT_FILE + "에 저장되었습니다.");
            }
        } catch (Exception e) {
            System.out.println("파일 쓰기 오류: " + e.getMessage());
        }
    }
}
