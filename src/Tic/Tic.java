package Tic;

import java.util.Scanner;
import java.util.Random;

public class Tic {public static boolean isStringDouble(String s) {
	try {
		Double.parseDouble(s);
		return true;
	} catch (NumberFormatException e) {
		return false;
	}
}
public static void main(String[] args) {

	//p1 vs p2 이긴 횟수 변수
	int p1_cnt=0; 
	int p2_cnt=0;
	//player vs com 이긴 횟수 켠수
	int p_cnt=0;
	int com_cnt=0;
	//draw 변수
	int pDraw_cnt=0;
	int cDraw_cnt=0;

	while(true)
	{
		int k=0;

		int num=0;
		System.out.println("1. vs Com");
		System.out.println("2. vs User");
		System.out.println("3. vs score");
		System.out.println("4. Exit");

		System.out.println("Select NUM.  ");
		Scanner a= new Scanner(System.in);

		k=a.nextInt();
		if(k<1 || k>4)
		{
			System.out.println(" 잘못된 숫자 입력. 메뉴 다시 보고 제대로 입력하세요 ");
			continue  ;
		}
		if(k==4)
		{
			System.out.println("게임 끝 ");
			return ;
		}
		if(k==3) // score board
		{
			System.out.println(" =====Score Board=====  ");
			System.out.println(" << player vs com >> ");
			System.out.println(" plyaer : " + p_cnt);
			System.out.println(" computer : " + com_cnt);
			System.out.println(" draw : " + cDraw_cnt);
			System.out.println(" ");
			System.out.println(" << player1 vs player2 >> ");
			System.out.println(" plyaer1 : " + p1_cnt);
			System.out.println(" player2 : " + p2_cnt);
			System.out.println(" draw : " + pDraw_cnt);

		}
		if(k==2) // user vs user
		{
			String[][] board ={{"1","2","3"},{"4","5","6"},{"7","8","9"}}; // 게임판을 나타내는 2차원 배열
			int cnt=0;
			String x;
			String com;
			String m;
			String z;
			int n;

			Scanner scan  = new Scanner(System.in);

			System.out.println("p1 부터 시작 합니다.");

			while(true){

				// 게임판을 그린다.
				for(int i=0;i<3;i++)
				{
					for(int j=0; j<3;j++)
					{
						System.out.print(board[i][j]+" ");

					}
					System.out.println();

				}
				System.out.println("상대방이 둔 위치를 제외한 좌표를 입력해야 합니다");
				System.out.print("p1 좌표 입력: ");

				x = scan.nextLine();
				int numInt = Integer.parseInt(x); 
				while(numInt>9 || numInt<1) // 잘못된 범위 입력했을 경우 예외 처리
				{
					System.out.println("잘못된 범위의 수입니다. 다시 제대로 바둑판 보고 입력하세요");
					System.out.print("p1 좌표 입력: ");
					x = scan.nextLine();
					numInt = Integer.parseInt(x);
				}
				// p1이 바둑돌을 둔다
				for(int i=0;i<3;i++)
				{
					for(int j=0;j<3;j++)
					{
						if(x.equals(board[i][j]))
						{
							board[i][j]="O";
						}
					}
				}
				++cnt;// 비길경우를 위해 바둑돌을 둘때마다 카운트르 해줌
				for(int i=0;i<3;i++) //잘 두었는지 확인 
				{
					for(int j=0; j<3;j++)
					{
						System.out.print(board[i][j]+" ");

					}
					System.out.println();

				} 
				//  player 1이 이겼는지 판별 해줌
				if(board[0][0].equals("O")&& board[0][0].equals(board[1][0]) && board[0][0].equals(board[2][0]))
				{

					p1_cnt++;
					System.out.println("PLYAER1 승리"); break;
				}

				else if(board[0][0].equals("O")&& board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]))
				{

					p1_cnt++;
					System.out.println("PLYAER1 승리"); break;
				}

				else if(board[0][0].equals("O")&& board[0][0].equals(board[0][1]) && board[0][0].equals(board[0][2]))
				{

					p1_cnt++;
					System.out.println("PLYAER1 승리"); break;
				}

				// [0][0]=>O 일때 플레이어 승리
				else if(board[0][1].equals("O")&& board[0][1].equals(board[1][1]) && board[0][1].equals(board[2][1]))
				{

					p1_cnt++;
					System.out.println("PLYAER1 승리"); break;
				}

				else if(board[0][2].equals("O")&& board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]))
				{

					p1_cnt++;
					System.out.println("PLYAER1 승리"); break;
				}

				else if(board[0][2].equals("O")&& board[0][2].equals(board[1][2]) && board[0][2].equals(board[2][2]))
				{

					p1_cnt++;

					System.out.println("PLYAER1 승리"); break;
				}

				else if(board[1][0].equals("O")&& board[1][0].equals(board[1][1]) && board[1][0].equals(board[1][2]))
				{

					p1_cnt++;

					System.out.println("PLYAER1 승리"); break;
				}

				else if(board[2][0].equals("O")&& board[2][0].equals(board[2][1]) && board[2][0].equals(board[2][2]))
				{
					p1_cnt++;

					System.out.println("PLYAER1 승리"); break;
				}
				//p1 부터 시작해서 p1이 9번째 마지막 바둑돌을 두었는데도  승패가 결정 되지 않았을 경우 draw
				else if(cnt==9)
				{
					
					pDraw_cnt++;
					System.out.println("DRAW"); break;
				}
				System.out.println("상대방이 둔 위치를 제외한 좌표를 입력해야 합니다");
				System.out.print("p2 좌표 입력: ");

				m=scan.nextLine(); //p2가 바둑돌을 둔다
				int numInteg = Integer.parseInt(m); 
				while(numInteg<1 || numInteg>9) //잘못된 범위 입력했을때 예외 처리
				{
					System.out.println("잘못된 범위의 수 입니다. 다시 제대로 바둑판 보고 입력하세요");
					System.out.print("p2 좌표 입력: ");
					m=scan.nextLine(); 
					numInteg = Integer.parseInt(m);
						
				}
				for(int i=0;i<3;i++)
				{
					for(int j=0;j<3;j++)
					{
						if(m.equals(board[i][j]))
						{
							board[i][j]="X";
						}
					}
				}
				cnt++;
				//p2가 이겼을 경우를 따져준다.
				if(board[0][0].equals("X")&& board[0][0].equals(board[1][0]) && board[0][0].equals(board[2][0]))
				{
					for(int i=0;i<3;i++)
					{
						for(int j=0; j<3;j++)
						{
							System.out.print(board[i][j]+" ");

						}
						System.out.println();

					}
					p2_cnt++;
					System.out.println("PLAYER2 승리"); break;
				}
				else if(board[0][0].equals("X")&& board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]))
				{
					for(int i=0;i<3;i++)
					{
						for(int j=0; j<3;j++)
						{
							System.out.print(board[i][j]+" ");

						}
						System.out.println();

					}
					p2_cnt++;
					System.out.println("PLAYER2 승리"); break;
				}
				else if(board[0][0].equals("X")&& board[0][0].equals(board[0][1]) && board[0][0].equals(board[0][2]))
				{
					for(int i=0;i<3;i++)
					{
						for(int j=0; j<3;j++)
						{
							System.out.print(board[i][j]+" ");

						}
						System.out.println();

					}
					p2_cnt++;
					System.out.println("PLAYER2 승리"); break;
				}
				else if(board[0][1].equals("X")&& board[0][1].equals(board[1][1]) && board[0][1].equals(board[2][1]))
				{
					for(int i=0;i<3;i++)
					{
						for(int j=0; j<3;j++)
						{
							System.out.print(board[i][j]+" ");

						}
						System.out.println();

					}
					p2_cnt++;
					System.out.println("PLAYER2 승리"); break;
				}
				else if(board[0][2].equals("X")&& board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]))
				{
					for(int i=0;i<3;i++)
				{
					for(int j=0; j<3;j++)
					{
						System.out.print(board[i][j]+" ");

					}
					System.out.println();

				}

					p2_cnt++;
					System.out.println("PLAYER2 승리"); break;
				}
				else if(board[0][2].equals("X")&& board[0][2].equals(board[1][2]) && board[0][2].equals(board[2][2]))
				{
					for(int i=0;i<3;i++)
					{
						for(int j=0; j<3;j++)
						{
							System.out.print(board[i][j]+" ");

						}
						System.out.println();

					}
					p2_cnt++;
					System.out.println("PLAYER2 승리"); break;
				}
				else if(board[1][0].equals("X")&& board[1][0].equals(board[1][1]) && board[1][0].equals(board[1][2]))
				{
					for(int i=0;i<3;i++)
					{
						for(int j=0; j<3;j++)
						{
							System.out.print(board[i][j]+" ");

						}
						System.out.println();

					}
					p2_cnt++;
					System.out.println("PLAYER2 승리"); break;
				}
				else if(board[2][0].equals("X")&& board[2][0].equals(board[2][1]) && board[2][0].equals(board[2][2])) 
				{
					for(int i=0;i<3;i++)
					{
						for(int j=0; j<3;j++)
						{
							System.out.print(board[i][j]+" ");

						}
						System.out.println();

					}
					p2_cnt++;
					System.out.println("PLAYER2 승리"); break;
				}


			}


		}

		if(k==1) // user vs com
		{
			String[][] board ={{"1","2","3"},{"4","5","6"},{"7","8","9"}}; // 게임판을 나타내는 2차원 배열
			int cnt=0;
			String x;
			String com;
			String m;
			String z;
			int n;

			String[]cIn=new String[10];
			String[]uIn=new String[10];

			Scanner scan  = new Scanner(System.in);


			while(true){

				// 게임판을 그린다.

				for(int i=0;i<3;i++)
				{
					for(int j=0; j<3;j++)
					{
						System.out.print(board[i][j]+" ");

					}
					System.out.println();

				}
				System.out.print("player 차례 !! 1~9까지의 좌표를 입력하되 숫자로 되어있는 빈 공간좌표 입력 : ");
				x = scan.nextLine();
				int numInt = Integer.parseInt(x); 
				while(numInt>9 || numInt<1) // 잘못된 범위 입력했을 경우 예외 처리
				{
					System.out.println("잘못된 범위의 수입니다. 다시 제대로 바둑판 보고 입력하세요");
					System.out.print("p1 좌표 입력: ");
					x = scan.nextLine();
					numInt = Integer.parseInt(x);
				}
				
				// user가 바둑돌을 둔다
				for(int i=0;i<3;i++)
				{
					for(int j=0;j<3;j++)
					{
						if(x.equals(board[i][j]))
						{
							board[i][j]="O";
						}
					}
				}
				cnt++;
				//PLAYER가 이겼을 경우를 따져준다
				if(board[0][0].equals("O")&& board[0][0].equals(board[1][0]) && board[0][0].equals(board[2][0]))
				{
					for(int c=0;c<3;c++)
					{
						for(int b=0; b<3;b++)
						{
							System.out.print(board[c][b]+" ");

						}
						System.out.println();

					}
					p_cnt++;
					System.out.println("PLYAER 승리"); break;
				}

				else if(board[0][0].equals("O")&& board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]))
				{
					for(int c=0;c<3;c++)
					{
						for(int b=0; b<3;b++)
						{
							System.out.print(board[c][b]+" ");

						}
						System.out.println();

					}
					p_cnt++;
					System.out.println("PLYAER 승리"); break;
				}

				else if(board[0][0].equals("O")&& board[0][0].equals(board[0][1]) && board[0][0].equals(board[0][2]))
				{
					for(int c=0;c<3;c++)
					{
						for(int b=0; b<3;b++)
						{
							System.out.print(board[c][b]+" ");

						}
						System.out.println();

					}
					p_cnt++;
					System.out.println("PLYAER 승리"); break;
				}

				else if(board[0][1].equals("O")&& board[0][1].equals(board[1][1]) && board[0][1].equals(board[2][1]))
				{
					for(int c=0;c<3;c++)
					{
						for(int b=0; b<3;b++)
						{
							System.out.print(board[c][b]+" ");

						}
						System.out.println();

					}
					p_cnt++;
					System.out.println("PLYAER 승리"); break;
				}

				else if(board[0][2].equals("O")&& board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]))
				{
					for(int c=0;c<3;c++)
					{
						for(int b=0; b<3;b++)
						{
							System.out.print(board[c][b]+" ");

						}
						System.out.println();

					}
					p_cnt++;
					System.out.println("PLYAER 승리"); break;
				}

				else if(board[0][2].equals("O")&& board[0][2].equals(board[1][2]) && board[0][2].equals(board[2][2]))
				{
					for(int c=0;c<3;c++)
					{
						for(int b=0; b<3;b++)
						{
							System.out.print(board[c][b]+" ");

						}
						System.out.println();

					}
					p_cnt++;
					System.out.println("PLYAER 승리"); break;
				}

				else if(board[1][0].equals("O")&& board[1][0].equals(board[1][1]) && board[1][0].equals(board[1][2]))
				{
					for(int c=0;c<3;c++)
					{
						for(int b=0; b<3;b++)
						{
							System.out.print(board[c][b]+" ");

						}
						System.out.println();

					}
					p_cnt++;
					System.out.println("PLYAER 승리"); break;
				}

				else if(board[2][0].equals("O")&& board[2][0].equals(board[2][1]) && board[2][0].equals(board[2][2]))
				{
					for(int c=0;c<3;c++)
					{
						for(int b=0; b<3;b++)
						{
							System.out.print(board[c][b]+" ");

						}
						System.out.println();

					}
					p_cnt++;
					System.out.println("PLYAER 승리"); break;
				}

				else if(cnt==9)
				{
					for(int c=0;c<3;c++)
					{
						for(int b=0; b<3;b++)
						{
							System.out.print(board[c][b]+" ");

						}
						System.out.println();

					}
					cDraw_cnt++;
					System.out.println("DRAW"); break;
				}
				
				int whileCounter=0;
				int i=0,j=0;
				while(whileCounter==0) // com이 바둑돌을 둔다
				{
					i=0;
					j=0;
					n = 1 + (int)(Math.random() * 9); 
					//System.out.println(n);
					com = String.valueOf(n);
					// 컴퓨터가 생성한 정수가 2차원 배열의 첫번째 줄에 위치하고 그 위치가 바둑돌이 놓여져 있는지를 검사하여 놓여져 있으면 돌아가고 놓여져 있지 않다면 바둑돌을 둔다
					if(i==0)  
					{
						for(j=0;j<3;j++)
						{
							if(j+1==n)
							{
								if(isStringDouble(board[i][j]))
								{
									board[i][j]="X";
									whileCounter=1;
								}

							}
						}
						i=1;
					}


					if(i==1)
					{
						for(j=0;j<3;j++)
						{
							if(j+4==n)
							{
								if(isStringDouble(board[i][j]))
								{
									board[i][j]="X";
									whileCounter=1;
								}

							}
						}
						i=2;
					}
					if(i==2)
					{
						for(j=0;j<3;j++)
						{
							if(j+7==n)
							{
								if(isStringDouble(board[i][j]))
								{
									board[i][j]="X";
									whileCounter=1;
								}

							}

						}

					}

				}// 컴퓨터가 놓은 위치를 결정
				cnt++;
				//com 이 이겼을 경우를 따져준다
				if(board[0][0].equals("X")&& board[0][0].equals(board[1][0]) && board[0][0].equals(board[2][0]))
				{
					for(int c=0;c<3;c++)
					{
						for(int b=0; b<3;b++)
						{
							System.out.print(board[c][b]+" ");

						}
						System.out.println();

					}
					com_cnt++;
					System.out.println("COM 승리"); break;
				}
				else if(board[0][0].equals("X")&& board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]))
				{
					for(int c=0;c<3;c++)
					{
						for(int b=0; b<3;b++)
						{
							System.out.print(board[c][b]+" ");

						}
						System.out.println();

					}
					com_cnt++;
					System.out.println("COM 승리"); break;
				}
				else if(board[0][0].equals("X")&& board[0][0].equals(board[0][1]) && board[0][0].equals(board[0][2]))
				{
					for(int c=0;c<3;c++)
					{
						for(int b=0; b<3;b++)
						{
							System.out.print(board[c][b]+" ");

						}
						System.out.println();

					}
					com_cnt++;
					System.out.println("COM 승리"); break;
				}
				else if(board[0][1].equals("X")&& board[0][1].equals(board[1][1]) && board[0][1].equals(board[2][1]))
				{
					for(int c=0;c<3;c++)
					{
						for(int b=0; b<3;b++)
						{
							System.out.print(board[c][b]+" ");

						}
						System.out.println();

					}
					com_cnt++;
					System.out.println("COM 승리"); break;
				}
				else if(board[0][2].equals("X")&& board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]))
				{
					for(int c=0;c<3;c++)
					{
						for(int b=0; b<3;b++)
						{
							System.out.print(board[c][b]+" ");

						}
						System.out.println();

					}
					com_cnt++;
					System.out.println("COM 승리"); break;
				}
				else if(board[0][2].equals("X")&& board[0][2].equals(board[1][2]) && board[0][2].equals(board[2][2]))
				{
					for(int c=0;c<3;c++)
					{
						for(int b=0; b<3;b++)
						{
							System.out.print(board[c][b]+" ");

						}
						System.out.println();

					}
					com_cnt++;
					System.out.println("COM 승리"); break;
				}
				else if(board[1][0].equals("X")&& board[1][0].equals(board[1][1]) && board[1][0].equals(board[1][2]))
				{
					for(int c=0;c<3;c++)
					{
						for(int b=0; b<3;b++)
						{
							System.out.print(board[c][b]+" ");

						}
						System.out.println();

					}
					com_cnt++;
					System.out.println("COM 승리"); break;
				}
				else if(board[2][0].equals("X")&& board[2][0].equals(board[2][1]) && board[2][0].equals(board[2][2]))
				{
					for(int c=0;c<3;c++)
					{
						for(int b=0; b<3;b++)
						{
							System.out.print(board[c][b]+" ");

						}
						System.out.println();

					}
					com_cnt++;
					System.out.println("COM 승리"); break;
				}
			}

		}



	}	
}
}
