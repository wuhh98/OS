package wuhh;

import java.util.Scanner;
public class Scheduling {
	public static void main(String[] ages) {
		Scanner out = new Scanner(System.in);
		String[][] data = {{"A","B","C","D","E"},{"0","2","4","6","8"},{"3","6","4","5","2"}};// �������ơ�����ʱ�䡢����ʱ��
		double[][] data1 = new double[3][5];	//������̵����ʱ�䡢��תʱ�䡢��Ȩ��תʱ��
		int sum1=0;		//�������������ʱ��
		while(true) {		//�˵�ѡ��
			System.out.printf("���̵���ģ�����\r\n" + "\r\n" + "        1. ������ҵ���\r\n" + "\r\n" + "        2. ��ʾ��ҵ���\r\n" + "\r\n" + "        3. �����ȷ����㷨\r\n" + "\r\n" + "        4. ����ҵ�����㷨\r\n" + "\r\n" + "        5. ����Ӧ�������㷨\r\n" + "\r\n" + "        6. ʱ��Ƭ��ת�㷨\r\n" + "\r\n" + "        7. �༶�������е���\r\n" + "\r\n" + "        8. �㷨����Ա�\r\n" + "\r\n" + "        0. �˳�");
			int n = out.nextInt();
			switch(n) {
			case 0:	System.exit(0); break;
			case 1: 	{		//����������ơ�����ʱ�䡢����ʱ��
				for(int i=0;i<5;i++) {
					System.out.printf("����"+i+"\n"+"��������"+"\n");
					data[0][i] = out.next();
					System.out.println("����ʱ�䣺");
					data[1][i] = out.next();
					System.out.println("����ʱ�䣺");
					data[2][i] = out.next();
				}
				break;
			}
			case 2:{		//��ӡ�������ơ�����ʱ�䡢����ʱ��
				System.out.printf("������\t" );
				for(int i=0;i<5;i++) {
					System.out.printf(data[0][i]+"\t");
				}
				System.out.printf("\n");
				System.out.printf("����ʱ��\t");
				for(int i=0;i<5;i++) {
					System.out.printf(data[1][i]+"\t");
				}
				System.out.printf("\n");
				System.out.printf("����ʱ��\t");
				for(int i=0;i<5;i++) {
					System.out.printf(data[2][i]+"\t");
				}
				System.out.printf("\n");
				break;
			}	
			case 3:	{		//�����ȷ���
						String x;	//���������м����
						int time = 0;	//ʱ��
						for(int i=0;i<5;i++) {	//��data���鰴�յ���ʱ������
							for(int j=0;j<4-i;j++) {
								int t = Integer.parseInt(data[1][j]);
								int y = Integer.parseInt(data[1][j+1]);
								if(t>y){
									x = data[0][j];
									data[0][j] = data[0][j+1]; 
									data[0][j+1] = x;
									x = data[1][j];
									data[1][j] = data[1][j+1]; 
									data[1][j+1] = x;
									x = data[2][j];
									data[2][j] = data[2][j+1]; 
									data[2][j+1] = x;
								} 
							}
						}
						System.out.printf("������\t" );		//��ӡ������data����
						for(int i=0;i<5;i++) {
							System.out.printf(data[0][i]+"\t");
						}
						System.out.printf("\n");
						System.out.printf("����ʱ��\t");
						for(int i=0;i<5;i++) {
							System.out.printf(data[1][i]+"\t");
						}
						System.out.printf("\n");
						System.out.printf("����ʱ��\t");
						for(int i=0;i<5;i++) {
							System.out.printf(data[2][i]+"\t");
						}
						System.out.printf("\n");
						for(int i =0;i<5;i++) {				//�������������ʱ��
							sum1 +=Integer.parseInt(data[2][i]);
						}
						
						data1[0][0] = Integer.parseInt(data[2][0]);  //���ȵ���Ľ��̵ķ���ʱ�䱣�������data1
						try {
							for(int i=1;i<5;i++) {				//������߳����ʱ��
							data1[0][i] = data1[0][i-1]+Integer.parseInt(data[2][i]);
						}
						
						}catch(Exception e) {}
						
						while(true) {
							for(int i=0;i<5;i++) {
							try {		//�ж�ÿ���߳��Ƿ񵽴ִ�С�����������ӡ
							if(Integer.parseInt(data[1][i]) == time) System.out.println(time+"\t"+"����"+data[0][i]+"�����ڴ�");
							if(Integer.parseInt(data[1][i]) == 0 && time == 0) System.out.println(time+"\t"+"����"+data[0][i]+"��ʼִ��");
							if(time == data1[0][i]) 
								System.out.println(time+"\t"+"����"+data[0][i]+"������");
							if(time == data1[0][i]) System.out.println(time+"\t"+"����"+data[0][i+1]+"��ʼִ��");
							}
							catch(Exception e) {}
						}	
							time++;
							if(time>sum1) break;
						} time = 0;
						try {
							for(int i=0;i<5;i++) {		//����ÿ���̵߳���תʱ��ʹ�Ȩ��תʱ��
								data1[1][i] = data1[0][i] - Integer.parseInt(data[1][i]);
						        data1[2][i] =  (double)Math.round(data1[1][i]/Double.parseDouble(data[2][i])*100)/100;
							}
							
						}catch(Exception e) {}
					System.out.printf("������\t����ʱ��\t����ʱ��\t���ʱ��\t��תʱ��\t��Ȩ��ת\n");		//��ӡ
					for(int i=0;i<5;i++) {
						System.out.printf(data[0][i]+"\t");
						System.out.printf(data[1][i]+"\t");
						System.out.printf(data[2][i]+"\t");
						System.out.printf(data1[0][i]+"\t");
						System.out.printf(data1[1][i]+"\t");
						System.out.printf(data1[2][i]+"\n");
					}
					double sum2 = 0;
					double sum3 = 0;
					for(int i=0;i<5;i++) {		//����ƽ����תʱ��
						sum2 +=data1[1][i];
					} sum2 /= 5;
					for(int i=0;i<5;i++) {		//����ƽ����Ȩ��תʱ��
						sum3 +=data1[2][i];
					}sum3 /= 5;
					System.out.printf("ƽ����תʱ�䣺\t"+sum2+"\n");		//��ӡ
					System.out.printf("ƽ����תʱ�䣺\t"+sum3+"\n");
			}
				break;
			case 4:		{
				String[][] data2 ={{"A","B","C","D","E"},{"0","2","4","6","8"},{"3","6","4","5","2"}};
				boolean judge = true;
				String[][] data3 = new String[4][5];
				double[] data4 = new double[5];
				String arrive = null;
				String site = null;
				int time=0;		//����ʱ��
				int time1 = 0;
				int q = -7;
				int k=-1;
				int p = 0;
				String x;	//���������м����
				System.out.printf("������\t" );		//��ӡ������data����
				for(int i=0;i<5;i++) {
					System.out.printf(data[0][i]+"\t");
				}
				System.out.printf("\n");
				System.out.printf("����ʱ��\t");
				for(int i=0;i<5;i++) {
					System.out.printf(data[1][i]+"\t");
				}
				System.out.printf("\n");
				System.out.printf("����ʱ��\t");
				for(int i=0;i<5;i++) {
					System.out.printf(data[2][i]+"\t");
				}
				System.out.printf("\n");
				for(int i =0;i<5;i++) {				//�������������ʱ��
					sum1 +=Integer.parseInt(data[2][i]);
				}
				for(int i =1;i<data2[0].length;i++) {
					data2[2][i] +="999";
				}

				while(true) {
					for(int i=0;i<5;i++) {
					try {		//�ж�ÿ���߳��Ƿ񵽴ִ�С�����������ӡ
						if(Integer.parseInt(data[1][i]) == time)
						{
							System.out.println(time+"\t"+"����"+data[0][i]+"�����ڴ�");
							arrive += data[0][i];
							site =data2[0][0];
							for(int j=1;j<5;j++) {
								site +=data2[0][j];
							}
							//System.out.println(site);
							k = site.indexOf(data[0][i]);
							//System.out.println(k);
							data2[2][k] = data[2][i];
							//k = -1;
							

						}
						
						if(time1+q == time) 
							{	time1 = q = 0;
								
								System.out.println(time+"\t"+"����"+data2[0][0]+"������");
								data2[2][0] += "999";
								for(int h=0;h<data2[0].length;h++) {	//��data���鰴�շ���ʱ������
									for(int j=0;j<data2[0].length-1-h;j++) {
										int t = Integer.parseInt(data2[2][j]);
										int y = Integer.parseInt(data2[2][j+1]);
										if(t>y){
											x = data2[0][j];
											data2[0][j] = data2[0][j+1]; 
											data2[0][j+1] = x;
											x = data2[1][j];
											data2[1][j] = data2[1][j+1]; 
											data2[1][j+1] = x;
											x = data2[2][j];
											data2[2][j] = data2[2][j+1]; 
											data2[2][j+1] = x;
										} 
									}
								}
//								for(int t=0;t<data2[0].length;t++) {
//									System.out.printf(data2[0][t]);
//								}
//								System.out.printf("\n");
								judge = true;

								
							}
						if(judge && arrive.indexOf(data2[0][0])!=-1 && time<sum1) {
							System.out.println(time+"\t"+"����"+data2[0][0]+"��ʼִ��");
							judge = false;
							 time1= time;
							 q = Integer.parseInt(data2[2][0]);
							 data3[0][p] = data2[0][0];
							 data3[1][p++] = Integer.toString(time1+q);
						}
						}
						catch(Exception e) {}
					}	
						time++;
						if(time>sum1) break;
					}
				
				for(int h=0;h<data3[0].length;h++) {	//��data���鰴�շ���ʱ������
					for(int j=0;j<data3[0].length-1-h;j++) {
						if(data3[0][j].compareTo(data3[0][j+1])>0){
							x = data3[0][j];
							data3[0][j] = data3[0][j+1]; 
							data3[0][j+1] = x;
							x = data3[1][j];
							data3[1][j] = data3[1][j+1]; 
							data3[1][j+1] = x;
							
						} 
					}
				}
//				for(int i=0;i<5;i++) {
//					System.out.print(data3[0][i]+"\t");
//				}
//				for(int i=0;i<5;i++) {
//					System.out.print(data3[1][i]+"\t");
//				}
				try {
					for(int i=0;i<5;i++) {		//����ÿ���̵߳���תʱ��ʹ�Ȩ��תʱ��
						data3[2][i] = Integer.toString((int) (Integer.parseInt(data3[1][i]) - Integer.parseInt(data[1][i])));
				        data4[i]=  (double)Math.round(Integer.parseInt(data3[2][i])/Double.parseDouble(data[2][i])*100)/100;
					}
					
				}catch(Exception e) {}
				System.out.printf("������\t����ʱ��\t����ʱ��\t���ʱ��\t��תʱ��\t��Ȩ��ת\n");		//��ӡ
				for(int i=0;i<5;i++) {
					System.out.printf(data[0][i]+"\t");
					System.out.printf(data[1][i]+"\t");
					System.out.printf(data[2][i]+"\t");
					System.out.printf(data3[1][i]+"\t");
					System.out.printf(data3[2][i]+"\t");
					System.out.printf(data4[i]+"\n");
				}
				double sum2 = 0;
				double sum3 = 0;
				for(int i=0;i<5;i++) {		//����ƽ����תʱ��
					sum2 +=Integer.parseInt(data3[2][i]);
				} sum2 /= 5;
				for(int i=0;i<5;i++) {		//����ƽ����Ȩ��תʱ��
					sum3 +=data4[i];
				}sum3 /= 5;
				System.out.printf("ƽ����תʱ�䣺\t"+sum2+"\n");		//��ӡ
				System.out.printf("ƽ����תʱ�䣺\t"+sum3+"\n");
				}
			
			break;
	
			case 5:		{
				String[][] data2 ={{"A","B","C","D","E"},{"0","2","4","6","8"},{"3","6","4","5","2"}};
				boolean judge = true;
				double y;
				double[] RR = new double[5];
				String[][] data3 = new String[4][5];
				double[] data4 = new double[5];
				String arrive = null;
				String site = null;
				int time=0;		//����ʱ��
				int time1 = 0;
				int q = -7;
				int k=-1;
				int p = 0;
				String x;	//���������м����
				System.out.printf("������\t" );		//��ӡ������data����
				for(int i=0;i<5;i++) {
					System.out.printf(data[0][i]+"\t");
				}
				System.out.printf("\n");
				System.out.printf("����ʱ��\t");
				for(int i=0;i<5;i++) {
					System.out.printf(data[1][i]+"\t");
				}
				System.out.printf("\n");
				System.out.printf("����ʱ��\t");
				for(int i=0;i<5;i++) {
					System.out.printf(data[2][i]+"\t");
				}
				System.out.printf("\n");
				for(int i =0;i<5;i++) {				//�������������ʱ��
					sum1 +=Integer.parseInt(data[2][i]);
				}
				for(int i =1;i<data2[0].length;i++) {
					data2[2][i] +="999";
				}

				while(true) {
					for(int i=0;i<5;i++) {
					try {		//�ж�ÿ���߳��Ƿ񵽴ִ�С�����������ӡ
						if(Integer.parseInt(data[1][i]) == time)
						{
							System.out.println(time+"\t"+"����"+data[0][i]+"�����ڴ�");
							arrive += data[0][i];
							site =data2[0][0];
							for(int j=1;j<5;j++) {
								site +=data2[0][j];
							}
							//System.out.println(site);
							k = site.indexOf(data[0][i]);
							//System.out.println(k);
							data2[2][k] = data[2][i];
//							arrivetime[i] = time;
							//k = -1;
							

						}
						
						if(time1+q == time) 
							{	time1 = q = 0;
								
								System.out.println(time+"\t"+"����"+data2[0][0]+"������");
								data2[2][0] += "999";
								for(int m=0;m<data2[0].length;m++) {
									RR[m] = 1.0+((double)time-(double)Integer.parseInt(data2[1][m]))/(double)Integer.parseInt(data2[2][m]);
								}
								
								for(int h=0;h<data2[0].length;h++) {	//��data���鰴�շ���ʱ������
									for(int j=0;j<data2[0].length-1-h;j++) {
										//int t = Integer.parseInt(data2[2][j]);
										//int y = Integer.parseInt(data2[2][j+1]);
										if(RR[j]<RR[j+1]){
											x = data2[0][j];
											data2[0][j] = data2[0][j+1]; 
											data2[0][j+1] = x;
											x = data2[1][j];
											data2[1][j] = data2[1][j+1]; 
											data2[1][j+1] = x;
											x = data2[2][j];
											data2[2][j] = data2[2][j+1]; 
											data2[2][j+1] = x;
											y = RR[j];
											RR[j] = RR[j+1]; 
											RR[j+1] = y;
										} 
									}
								}
//								for(int t=0;t<data2[0].length;t++) {
//									System.out.printf(data2[0][t]);
//								}
//								System.out.printf("\n");
								judge = true;

								
							}
						if(judge && arrive.indexOf(data2[0][0])!=-1 && time<sum1) {
							System.out.println(time+"\t"+"����"+data2[0][0]+"��ʼִ��");
							judge = false;
							 time1= time;
							 q = Integer.parseInt(data2[2][0]);
							 data3[0][p] = data2[0][0];
							 data3[1][p++] = Integer.toString(time1+q);
						}
						}
						catch(Exception e) {}
					}	
						time++;
						if(time>sum1) break;
					}
				
				for(int h=0;h<data3[0].length;h++) {	//��data���鰴�շ���ʱ������
					for(int j=0;j<data3[0].length-1-h;j++) {
						if(data3[0][j].compareTo(data3[0][j+1])>0){
							x = data3[0][j];
							data3[0][j] = data3[0][j+1]; 
							data3[0][j+1] = x;
							x = data3[1][j];
							data3[1][j] = data3[1][j+1]; 
							data3[1][j+1] = x;
							
						} 
					}
				}
//				for(int i=0;i<5;i++) {
//					System.out.print(data3[0][i]+"\t");
//				}
//				for(int i=0;i<5;i++) {
//					System.out.print(data3[1][i]+"\t");
//				}
				try {
					for(int i=0;i<5;i++) {		//����ÿ���̵߳���תʱ��ʹ�Ȩ��תʱ��
						data3[2][i] = Integer.toString((int) (Integer.parseInt(data3[1][i]) - Integer.parseInt(data[1][i])));
				        data4[i]=  (double)Math.round(Integer.parseInt(data3[2][i])/Double.parseDouble(data[2][i])*100)/100;
					}
					
				}catch(Exception e) {}
				System.out.printf("������\t����ʱ��\t����ʱ��\t���ʱ��\t��תʱ��\t��Ȩ��ת\n");		//��ӡ
				for(int i=0;i<5;i++) {
					System.out.printf(data[0][i]+"\t");
					System.out.printf(data[1][i]+"\t");
					System.out.printf(data[2][i]+"\t");
					System.out.printf(data3[1][i]+"\t");
					System.out.printf(data3[2][i]+"\t");
					System.out.printf(data4[i]+"\n");
				}
				double sum2 = 0;
				double sum3 = 0;
				for(int i=0;i<5;i++) {		//����ƽ����תʱ��
					sum2 +=Integer.parseInt(data3[2][i]);
				} sum2 /= 5;
				for(int i=0;i<5;i++) {		//����ƽ����Ȩ��תʱ��
					sum3 +=data4[i];
				}sum3 /= 5;
				System.out.printf("ƽ����תʱ�䣺\t"+sum2+"\n");		//��ӡ
				System.out.printf("ƽ����תʱ�䣺\t"+sum3+"\n");
			}break;
			case 6:		break;
			case 7:		break;
			case 8:		break;
			}
		}
	}
}
