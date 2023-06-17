import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MazeManager {
    private ArrayList<Maze> list;
    private String filename;

    public MazeManager(String file) {
        filename = file;
        list = new ArrayList<>();
    }
    public void Add(Maze maze) {
        list.add(maze);
    }
    public void AddInput() {
        Scanner scn = new Scanner(System.in);
        System.out.println("미로 이름");
        System.out.println("Ex) 소환사의 협곡");
        String mazeName = scn.nextLine();
        System.out.println("미로 크기(N*N)");
        System.out.println("Ex) 5");
        String size = scn.nextLine();
        System.out.println("미로 구성(N*N)");
        System.out.println("Tip) 왼쪽 위와 오른쪽 아래는 빈공간이어야 하며, 이어지는 길이 있어야 합니다.");
        System.out.println("Ex) Empty Slime Sword Slime Wall Wall Slime Empty Empty");
        String names = scn.nextLine();

        Add(new Maze(mazeName, size, names));
        Save();
    }
    public void Show() {
        int cnt = 0;
        for(Maze maze : list)
        {

            System.out.println("미로 이름 : " + maze.GetName());
            System.out.println("미로 번호 : " + ++cnt);
            maze.Print();
        }
    }
    public Maze GetMaze(int index)
    {
        return list.get(index-1);
    }
    public void Save() {
        StringBuilder prevString = new StringBuilder();
        try {
            FileReader reader = new FileReader(filename);
            BufferedReader buf = new BufferedReader(reader);
            String line;
            while ((line = buf.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, ",");
                prevString.append(tokenizer.nextToken()).append(",");
                prevString.append(tokenizer.nextToken()).append(",");
                prevString.append(tokenizer.nextToken());
            }
            prevString.append("\n");
        } catch(FileNotFoundException e) {
            System.out.println(filename + "파일이 없습니다.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileWriter writer = new FileWriter(filename); // 기록용도로 파일 생성
            BufferedWriter buf = new BufferedWriter(writer);
            // buf를 이용해서 데이터를 파일에 기록하기
            for(Maze maze : list) {  // maze 객체 하나씩 파일에 기록하기
                // CSV 파일 형식으로 기록
                buf.write(maze.GetName() + ',');  // 여행1,
                buf.write(maze.GetSize() + ",");  // 여행1,
                buf.write(maze.GetObjectNames() + "");  // 여행1,
                buf.newLine();  // 엔터. 다음 줄로 내림.
            }
            buf.close();  // 파일 닫기
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void Load() {
        try {
            FileReader reader = new FileReader(filename);
            BufferedReader buf = new BufferedReader(reader);
            String line;
            while ((line = buf.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, ",");
                String mazeName = tokenizer.nextToken(); // 여행1
                String size = tokenizer.nextToken();
                String names = tokenizer.nextToken();
                Add(new Maze(mazeName, size, names));
            }
        } catch(FileNotFoundException e) {
            System.out.println(filename + "파일이 없습니다.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int GetSize()
    {
        return list.size();
    }
}









