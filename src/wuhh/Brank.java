package wuhh;

import java.util.Scanner;

public class Brank {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[][] persentMax = {{7,5,3},{3,2,2},{9,0,2},{2,2,2},{4,3,3}}; //���������Դ����
		int[][] persentAllo = {{0,1,0},{2,0,0},{3,0,2},{2,1,1},{0,0,2}};	//�ѷ�����Դ����
		int[][] persentNeed = {{7,4,3},{1,2,2},{6,0,0},{0,1,1},{4,3,1}};	//����Ҫ����Դ����
		int[] request= new int[3];	//������Դ����
		int[] persentAvalia = {3,3,2};	//�����õ���Դ����
		int[][] safeWork = new int[5][3];	//������Դ��ʣ��Ŀ�����Դ����
		int[][] safeAvalia = new int[5][3];	//persentAllo + work
		int[][] safeAllo = new int [5][3];	//������ѷ�����Դ
		int[][] safeNeed = new int [5][3];	//���������Դ
		boolean[] Finish = {false,false,false,false,false};	//��ʾ���
		String[] safeName = new String[5];
		while(true)
		{
			
			int n;
			System.out.println("1.��ʼ��");
			System.out.println("2.�鿴��ǰ��Դ�����");
			System.out.println("3.������Դ");
			System.out.println("4.�˳�");
			n = in.nextInt();
			switch(n)
			{
				case 1:{															//����
							
							for(int i=0;i<5;i++) {
								System.out.println("�������P"+i+"����Դ�������(3����Դ���ո����)");
								System.out.println("Max:");
								for(int j=0;j<3;j++) {
									persentMax[i][j] = in.nextInt();
								}
								System.out.println("Allocation:");
								for(int j=0;j<3;j++) {
									persentAllo[i][j] = in.nextInt();
								}
								for(int j=0;j<3;j++) {
									persentNeed[i][j] =	persentMax[i][j] - persentAllo[i][j];
								}
							}
							
				}break;
				case 2:{															//��ӡ
					System.out.print("     Max"+"      Allo"+"     Need"+"   Avalia"+"\n");
					for(int i=0;i<5;i++) {
						if(i==0) {System.out.print("P0"+" ");}
						if(i==1) {System.out.print("P1"+" ");}
						if(i==2) {System.out.print("P2"+" ");}		
						if(i==3) {System.out.print("P3"+" ");}
						if(i==4) {System.out.print("P4"+" ");}
						for(int j=0;j<3;j++) {
							System.out.print(persentMax[i][j]+" ");
						}
						System.out.print("|"+"  ");
						for(int j=0;j<3;j++) {
							System.out.print(persentAllo[i][j]+" ");
						}
						System.out.print("|"+"  ");
						for(int j=0;j<3;j++) {
							System.out.print(persentNeed[i][j]+" ");
						}
						System.out.print("|"+"  ");
						if(i==0)System.out.print(persentAvalia[i]+" ");
						System.out.println();
					}
					
				}break;
				case 3:{													//����
							System.out.println("������������Դ�Ľ��̺�:");
							String name = in.next();
							int k;		//����ѡ���˵ڼ�������
							int k1=0;
							if(name.equals("P0")) k =0;			//�ж���������ĸ�����
							else if(name.equals("P1")) k =1;
							else if(name.equals("P2")) k =2;
							else if(name.equals("P3")) k =3;
							else if(name.equals("P4")) k =4;
							else {System.err.println("δ�ҵ��˽��̣���");break;}
							System.out.println("������������Դ��������������Դ���ո������");
							for(int i=0;i<3;i++) {				//����������Դ����������
								request[i] = in.nextInt();
							}
							for(int i=0;i<3;i++){				//�ж����������������Ƿ�С�ڵ�ǰ�������Need��ֵ
								if(request[i]>persentNeed[k][i]) {System.out.println("������Դ����Need����������ʧ�ܣ���");break;}
							}
							for(int i=0;i<3;i++) {				//�ж����������������Ƿ�С��Available����
								if(request[i]>persentAvalia[i]) {System.out.println("������Դ����Available����������ʧ�ܣ���");break;}
								if(request[i]==persentAvalia[i]) k1++; 
							}
							if(k1 == 3) {
								for(int i=0;i<3;i++)
								if(request[i] < persentNeed[k][i]) {System.out.println("ϵͳ�����벻��ȫģʽ������ʧ�ܣ���");break;}
							}
							for(int i=0;i<3;i++) {
								persentAvalia[i] -= request[i];		//��������Դ-������Դ
								persentAllo[k][i] += request[i];	//�ѷ�����Դ+������Դ
								persentNeed[k][i] -= request[i];	//����Ҫ��Դ-������Դ
								safeWork[0][i] = persentAvalia[i];
							}
							for(int i=0;i<3;i++) {
								System.out.println(persentAvalia[i]);
								System.out.println(persentNeed[1][i]);
							}
							
							for(int z=0;z<5;z++) {
							for(int i=0;i<5;i++)
							{	
								
									if(safeWork[z][0]>=persentNeed[i][0] && safeWork[z][1]>=persentNeed[i][1] && safeWork[z][2]>=persentNeed[i][2] && !Finish[i])
								{
									Finish[i]=true;
									if(i==0) {safeName[z] = "P0";}
									if(i==1) {safeName[z] = "P1";}
									if(i==2) {safeName[z] = "P2";}		
									if(i==3) {safeName[z] = "P3";}
									if(i==4) {safeName[z] = "P4";}
									for(int j=0;j<3;j++) {						
										safeNeed[z][j] = persentNeed[i][j];
									}
									for(int j=0;j<3;j++) {
										safeAllo[z][j] = persentAllo[i][j];
									}
									for(int j =0;j<3;j++) {
										safeAvalia[z][j] = safeWork[z][j] + safeAllo[z][j];
									}
									for(int j=0;j<3;j++) {
										if(z<4) {
											safeWork[z+1][j] = safeAvalia[z][j];
										}
										}
									break;
								}
							}
							}
							System.out.print("     Work"+"      Need"+"     Allo"+"     W+A"+"     Finish"+"\n");
							for(int i=0;i<5;i++) {
								System.out.printf(safeName[i]+" ");
								for(int j=0;j<3;j++) {
									System.out.print(safeWork[i][j]+" ");
								}
								System.out.print("|"+"  ");
								for(int j=0;j<3;j++) {
									System.out.print(safeNeed[i][j]+" ");
								}
								System.out.print("|"+"  ");
								for(int j=0;j<3;j++) {
									System.out.print(safeAllo[i][j]+" ");
								}
								System.out.print("|"+"  ");
								for(int j=0;j<3;j++) {
									System.out.print(safeAvalia[i][j]+" ");
								}
								System.out.print("|"+"  ");
								System.out.print(Finish[i]+" ");
								System.out.println();
							}
							
				}
				
				case 4:	return;
				
			}
			
		}
	}

}
