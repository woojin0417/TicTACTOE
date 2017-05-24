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

	//p1 vs p2 �̱� Ƚ�� ����
	int p1_cnt=0; 
	int p2_cnt=0;
	//player vs com �̱� Ƚ�� �Ҽ�
	int p_cnt=0;
	int com_cnt=0;
	//draw ����
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
			System.out.println(" �߸��� ���� �Է�. �޴� �ٽ� ���� ����� �Է��ϼ��� ");
			continue  ;
		}
		if(k==4)
		{
			System.out.println("���� �� ");
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
			String[][] board ={{"1","2","3"},{"4","5","6"},{"7","8","9"}}; // �������� ��Ÿ���� 2���� �迭
			int cnt=0;
			String x;
			String com;
			String m;
			String z;
			int n;

			Scanner scan  = new Scanner(System.in);

			System.out.println("p1 ���� ���� �մϴ�.");

			while(true){

				// �������� �׸���.
				for(int i=0;i<3;i++)
				{
					for(int j=0; j<3;j++)
					{
						System.out.print(board[i][j]+" ");

					}
					System.out.println();

				}
				System.out.println("������ �� ��ġ�� ������ ��ǥ�� �Է��ؾ� �մϴ�");
				System.out.print("p1 ��ǥ �Է�: ");

				x = scan.nextLine();
				int numInt = Integer.parseInt(x); 
				while(numInt>9 || numInt<1) // �߸��� ���� �Է����� ��� ���� ó��
				{
					System.out.println("�߸��� ������ ���Դϴ�. �ٽ� ����� �ٵ��� ���� �Է��ϼ���");
					System.out.print("p1 ��ǥ �Է�: ");
					x = scan.nextLine();
					numInt = Integer.parseInt(x);
				}
				// p1�� �ٵϵ��� �д�
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
				++cnt;// ����츦 ���� �ٵϵ��� �Ѷ����� ī��Ʈ�� ����
				for(int i=0;i<3;i++) //�� �ξ����� Ȯ�� 
				{
					for(int j=0; j<3;j++)
					{
						System.out.print(board[i][j]+" ");

					}
					System.out.println();

				} 
				//  player 1�� �̰���� �Ǻ� ����
				if(board[0][0].equals("O")&& board[0][0].equals(board[1][0]) && board[0][0].equals(board[2][0]))
				{

					p1_cnt++;
					System.out.println("PLYAER1 �¸�"); break;
				}

				else if(board[0][0].equals("O")&& board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]))
				{

					p1_cnt++;
					System.out.println("PLYAER1 �¸�"); break;
				}

				else if(board[0][0].equals("O")&& board[0][0].equals(board[0][1]) && board[0][0].equals(board[0][2]))
				{

					p1_cnt++;
					System.out.println("PLYAER1 �¸�"); break;
				}

				// [0][0]=>O �϶� �÷��̾� �¸�
				else if(board[0][1].equals("O")&& board[0][1].equals(board[1][1]) && board[0][1].equals(board[2][1]))
				{

					p1_cnt++;
					System.out.println("PLYAER1 �¸�"); break;
				}

				else if(board[0][2].equals("O")&& board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]))
				{

					p1_cnt++;
					System.out.println("PLYAER1 �¸�"); break;
				}

				else if(board[0][2].equals("O")&& board[0][2].equals(board[1][2]) && board[0][2].equals(board[2][2]))
				{

					p1_cnt++;

					System.out.println("PLYAER1 �¸�"); break;
				}

				else if(board[1][0].equals("O")&& board[1][0].equals(board[1][1]) && board[1][0].equals(board[1][2]))
				{

					p1_cnt++;

					System.out.println("PLYAER1 �¸�"); break;
				}

				else if(board[2][0].equals("O")&& board[2][0].equals(board[2][1]) && board[2][0].equals(board[2][2]))
				{
					p1_cnt++;

					System.out.println("PLYAER1 �¸�"); break;
				}
				//p1 ���� �����ؼ� p1�� 9��° ������ �ٵϵ��� �ξ��µ���  ���а� ���� ���� �ʾ��� ��� draw
				else if(cnt==9)
				{
					
					pDraw_cnt++;
					System.out.println("DRAW"); break;
				}
				System.out.println("������ �� ��ġ�� ������ ��ǥ�� �Է��ؾ� �մϴ�");
				System.out.print("p2 ��ǥ �Է�: ");

				m=scan.nextLine(); //p2�� �ٵϵ��� �д�
				int numInteg = Integer.parseInt(m); 
				while(numInteg<1 || numInteg>9) //�߸��� ���� �Է������� ���� ó��
				{
					System.out.println("�߸��� ������ �� �Դϴ�. �ٽ� ����� �ٵ��� ���� �Է��ϼ���");
					System.out.print("p2 ��ǥ �Է�: ");
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
				//p2�� �̰��� ��츦 �����ش�.
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
					System.out.println("PLAYER2 �¸�"); break;
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
					System.out.println("PLAYER2 �¸�"); break;
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
					System.out.println("PLAYER2 �¸�"); break;
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
					System.out.println("PLAYER2 �¸�"); break;
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
					System.out.println("PLAYER2 �¸�"); break;
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
					System.out.println("PLAYER2 �¸�"); break;
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
					System.out.println("PLAYER2 �¸�"); break;
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
					System.out.println("PLAYER2 �¸�"); break;
				}


			}


		}

		if(k==1) // user vs com
		{
			String[][] board ={{"1","2","3"},{"4","5","6"},{"7","8","9"}}; // �������� ��Ÿ���� 2���� �迭
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

				// �������� �׸���.

				for(int i=0;i<3;i++)
				{
					for(int j=0; j<3;j++)
					{
						System.out.print(board[i][j]+" ");

					}
					System.out.println();

				}
				System.out.print("player ���� !! 1~9������ ��ǥ�� �Է��ϵ� ���ڷ� �Ǿ��ִ� �� ������ǥ �Է� : ");
				x = scan.nextLine();
				int numInt = Integer.parseInt(x); 
				while(numInt>9 || numInt<1) // �߸��� ���� �Է����� ��� ���� ó��
				{
					System.out.println("�߸��� ������ ���Դϴ�. �ٽ� ����� �ٵ��� ���� �Է��ϼ���");
					System.out.print("p1 ��ǥ �Է�: ");
					x = scan.nextLine();
					numInt = Integer.parseInt(x);
				}
				
				// user�� �ٵϵ��� �д�
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
				//PLAYER�� �̰��� ��츦 �����ش�
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
					System.out.println("PLYAER �¸�"); break;
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
					System.out.println("PLYAER �¸�"); break;
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
					System.out.println("PLYAER �¸�"); break;
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
					System.out.println("PLYAER �¸�"); break;
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
					System.out.println("PLYAER �¸�"); break;
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
					System.out.println("PLYAER �¸�"); break;
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
					System.out.println("PLYAER �¸�"); break;
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
					System.out.println("PLYAER �¸�"); break;
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
				while(whileCounter==0) // com�� �ٵϵ��� �д�
				{
					i=0;
					j=0;
					n = 1 + (int)(Math.random() * 9); 
					//System.out.println(n);
					com = String.valueOf(n);
					// ��ǻ�Ͱ� ������ ������ 2���� �迭�� ù��° �ٿ� ��ġ�ϰ� �� ��ġ�� �ٵϵ��� ������ �ִ����� �˻��Ͽ� ������ ������ ���ư��� ������ ���� �ʴٸ� �ٵϵ��� �д�
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

				}// ��ǻ�Ͱ� ���� ��ġ�� ����
				cnt++;
				//com �� �̰��� ��츦 �����ش�
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
					System.out.println("COM �¸�"); break;
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
					System.out.println("COM �¸�"); break;
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
					System.out.println("COM �¸�"); break;
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
					System.out.println("COM �¸�"); break;
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
					System.out.println("COM �¸�"); break;
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
					System.out.println("COM �¸�"); break;
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
					System.out.println("COM �¸�"); break;
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
					System.out.println("COM �¸�"); break;
				}
			}

		}



	}	
}
}
