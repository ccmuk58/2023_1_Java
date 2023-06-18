import java.util.Scanner;

public class Main {
    public static void PrintTitle(){
        System.out.println("======================");
        System.out.println("=    MAZE DUNGEON    =");
        System.out.println("======================");
    }
    public static void PrintMenu(){
        System.out.println("1: 게임 시작(미로 선택)");
        System.out.println("2: 미로 만들기");
        System.out.println("3: 크레딧");
        System.out.println("4: 게임 종료");
    }
    public static void main(String[] args) {
        GameManager gm = GameManager.GetInstance();
        Scanner scn = new Scanner(System.in);
        MazeManager mazeManager = new MazeManager("mazeData.txt");
        mazeManager.Load();

        PrintTitle();
        while(true)
        {
            PrintMenu();
            gm.PrintLine();
            char select = scn.next().charAt(0);
            gm.PrintLine();

            switch (select)
            {
                case '1' -> {
                    mazeManager.Show();
                    int mazeIdx = scn.nextInt();
                    if(mazeIdx > mazeManager.GetSize())
                    {
                        System.out.println("잘못된 입력입니다.");
                        gm.PrintLine();
                        break;
                    }
                    gm.SetMaze(mazeManager.GetMaze(mazeIdx));
                    gm.PrintLine();
                    System.out.println("탐험 시작 !!");
                    gm.PrintLine();
                    System.out.println("왼쪽 위에서 출발 해 오른쪽 아래에 도착하면 클리어합니다.");
                    gm.PrintLine();
                    System.out.println("P : 플레이어, O : 빈 방, E : 적, I : 아이템");
                    gm.PrintLine();
                    System.out.println("w : 위, a : 왼쪽, s : 아래, d : 오른쪽");
                    gm.PrintLine();
                    gm.Init();

                    while(!gm.GameClear() && !gm.GameOver())
                    {
                        gm.GetMaze().Print();
                        GameManager.GetInstance().Move();
                    }
                }
                case '2' ->
                {
                    mazeManager.AddInput();
                }
                case '3' ->
                {
                    PrintTitle();
                    System.out.println("2023-1 자바프로그래밍[01]");
                    System.out.println("=== 20201554 최장현 ===");
                    System.out.println("=== 20201084 안형진 ===");
                    System.out.println("===   THANK  YOU   ===");
                    System.out.println("======================\n");

                }
                case '4' ->
                {
                    System.out.println("게임을 종료합니다.");
                    return;
                }
                default -> {
                    System.out.println("잘못된 입력입니다.");
                }
            }
        }
    }
}
