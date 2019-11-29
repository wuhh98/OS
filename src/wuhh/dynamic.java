package wuhh;

import java.util.Scanner;

public class dynamic {

	public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			String[][] table = new String[100][5];
			table[0][0]="0";
			table[0][1]=" ";
			table[0][2]="0";
			table[0][3]="1024";
			table[0][4]="0";
			int p =0;
			int k;
			int x;
			String name1;
			String name2;
			boolean pd = false;
			boolean pd1 = false;
		while(true) {
			System.out.println("1.�����ڴ�");
			System.out.println("2.�����ڴ�");
			System.out.println("3.��ʾ�ڴ�ʹ�����");
			System.out.println("4.�˳�");
			int n =in.nextInt();
			switch(n) {
				case 1:{
						k=p;
						System.out.println("��ҵ��(һ���ַ�)");
							name1 =  in.next();
						System.out.println("��ҵռ�ڴ��С(���1024)");	
							name2 =  in.next();
							for(int i=0;i<=p;i++) {			//���ڴ�
								if(table[i][4].equals("0")&&Integer.parseInt(name2)<Integer.parseInt(table[i][3])) {	
								String a = table[i][3];
								for(int j=p;j<=p&&j>i;j--) {
									table[j+1][0] = Integer.toString(Integer.parseInt(table[i][0])+1);
									table[j+1][1] = table[j][1];
									table[j+1][2] = table[j][2];
									table[j+1][3] = table[j][3];
									table[j+1][4] = table[j][4];
							}
								table[i][0] = Integer.toString(i);
								table[i][1] = name1;
								table[i][3] = name2;
								table[i][4] = "1";
								table[i+1][0]=Integer.toString(i+1);
								table[i+1][1]=" ";
								table[i+1][2]=Integer.toString(Integer.parseInt(table[i][3])+Integer.parseInt(table[i][2]));
								table[i+1][3]=Integer.toString(Integer.parseInt(a)-Integer.parseInt(table[i][3]));
								table[i+1][4]="0";
								System.out.println("����ɹ�����");
								p= k;
								p++;
								break;
								}
							}
								break;
								}
			
				  case 2:{
					  boolean pd2=false;
					  int i;
					System.out.println("����Ҫ���շ�������ҵ��(һ���ַ�):");
					String name =in.next();
					for(i=0;i<=p;i++) {
						if(table[i][1].equals(name)) {			
							table[i][1] = " ";
							table[i][4] = "0";
							System.out.println("���ճɹ�����");
							if((table[i][4].equals("0")&&table[i+1][4].equals("0")))		//���պ�Ѱ�����ڵ�������û����Ҫ�ϲ���
							{
								table[i][0] = Integer.toString(i);
								table[i][1] = " ";
								table[i][3] = Integer.toString(Integer.parseInt(table[i][3])+Integer.parseInt(table[i+1][3]));
								for(int j=0;j<5;j++) {
									table[i+1][j] = " ";
								}
								pd2 = true;
							}
							
							break;
						}
						
					}
					if(pd2&&i<p-1) {			//�жϺϲ��Ժ���滹��û�����ݣ��о���ǰ�ƶ�
						for(;i<p;i++) {
						table[i+1][0] = Integer.toString(Integer.parseInt(table[i+2][0])-1);
						table[i+1][1] = table[i+2][1];
						table[i+1][2] = table[i+2][0];
						table[i+1][3] = table[i+2][0];
						table[i+1][4] = table[i+2][0];
							}
					}
					
				}break;
				case 3:{			//��ӡ
					System.out.println("������   "+"��ҵ��   "+"��ʼ��ַ   "+"������С   "+"״̬");
					for(int i=0;i<=p;i++) {
						for(int j=0;j<5;j++) {
							System.out.print(table[i][j]+"  ");
							if(j==0)System.out.print("  ");
							if(j==1)System.out.print("    ");
							if(j==2)System.out.print(" ");
							if(j==3)System.out.print(" ");
						}
						System.out.println();
					}
				}break;
				case 4:return;
		
			}
}
}
}