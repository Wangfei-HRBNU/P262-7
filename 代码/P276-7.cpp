#include<iostream>
#include<fstream>
#include<string>
#include<stdlib.h>
#include<ctime>

using namespace std;

const int MAX=100;//�������ֵ

int Marking();
void SaveScore(int i);
int ReadScore();
void Delay(int);

struct strScore
	{
	int SNo;//ѧ��
	int Score;//�ɼ�
	int Flag;//�𰸺Ϸ���־,0-�Ϸ���1-�𰸹��̣�2-�𰸹�����3-���зǷ��ַ�
	}strS[MAX];//�����ɼ��ṹ������;

int main()
	{
	char cFlag;//����ѡ���־
start:
	cout<<"\t\t\t��ѡ���Զ��о�ϵͳ"<<endl;
	cout<<"  \t\t\t1-��ʼ�о�\n"<<"  \t\t\t2-��ȡ�ϴ��о�ɼ�\n"<<"  \t\t\t3-�˳�ϵͳ\n"<<"  \t\t\t  ��ѡ��"<<endl;
	cin>>cFlag;
	switch(cFlag)
		{
		case '1':Marking();break;
		case '2':ReadScore();break;
		case '3':return 0;
		default:
			system("Cls");//����
			cout<<"������Ч�����Ժ�����ѡ��"<<endl;
			Delay(2);//��ʱ
		}
	system("Cls");
	goto start;
	return 0;
	}

int Marking()//�о���
	{	
	ifstream fin;
	system("Cls");
	char cFlag;
	fin.open("exams.txt");
	cout<<"ѧ��\t\t\t�ɼ�\n";
	char sAns[MAX];//ѧ����
	char sSAns[MAX];//��׼��
	int i,j;
	fin.getline(sSAns,MAX,'\n');//��ȡ��׼��
	for(i=0;(!fin.eof())&&i<MAX;i++)//��ȡѧ��ѭ��
		{
		fin>>strS[i].SNo;//��ȡѧ��ѧ��
		strS[i].Score=0;//��ʼ��ѧ���ɼ�
		strS[i].Flag=0;
		fin.ignore(1,' ');//���Կո�
		fin.getline(sAns,MAX,'\n');//��ȡѧ����
		if(strlen(sAns)<strlen(sSAns))//�жϴ𰸺Ϸ���
			strS[i].Flag=1;
		else if(strlen(sAns)>strlen(sSAns))
			strS[i].Flag=2;
		else
		for(j=0;j<strlen(sAns);j++)//�з�ѭ��
			if(sAns[j]<'a'||sAns[j]>'f')
				{strS[i].Flag=3;break;}
			else if(sAns[j]==sSAns[j])
				strS[i].Score++;//����
		cout<<strS[i].SNo<<"\t\t\t";//���ѧ��
		switch(strS[i].Flag)//����ɼ�
			{
			case 0:cout<<strS[i].Score<<'\n';break;
			case 1:cout<<"��ѧ���𰸹���"<<'\n';break;
			case 2:cout<<"��ѧ���𰸹���"<<'\n';break;
			case 3:cout<<"��ѧ���𰸷Ƿ�"<<'\n';
			}
		}

exitMarking:
	cout<<"\n�о���ɣ��Ƿ񱣴����ݣ�\n";
	cout<<"1-���沢�˳��о�\n2-�����沢�˳��о�\n";
	cin>>cFlag;
	switch(cFlag)
		{
		case '1':SaveScore(i);
		case '2':break;
		default:system("Cls");goto exitMarking;
		}
	fin.close();
	return 0;
	}

void SaveScore(int i)
	{
	ofstream fout;
	fout.open("scores.txt");
	fout<<"ѧ��\t\t\t�ɼ�\n";
	int j=i;
	while(i>0)
		{
		fout<<strS[j-i].SNo<<"\t\t\t";
		switch(strS[j-i].Flag)
			{
			case 0:fout<<strS[j-i].Score<<'\n';break;
			case 1:fout<<"��ѧ���𰸹���"<<'\n';break;
			case 2:fout<<"��ѧ���𰸹���"<<'\n';break;
			case 3:fout<<"��ѧ���𰸷Ƿ�"<<'\n';
			}
		i--;
		}
	fout.close();
	}

int ReadScore()//��ȡ�ϴ��о�ɼ�
	{
	system("Cls");
	ifstream fin;
	ofstream fout;
	fin.open("scores.txt");
	if(fin.eof())
		{
		cout<<"�ϴ��о�ɼ������ڣ��Ժ�ع������棡"<<endl;
		Delay(2);
		return 1;
		}

	char a;
	do
		{
		fin.get(a);
		if(fin.eof())
			break;
		cout<<a;
		}while(!fin.eof());
	cout<<"\n�ϴ��о�ɼ���ȡ��ɣ���0�ص�������"<<endl;
	while(a!='0')cin.get(a);
	fin.close();
	return 0;
	}

void Delay(int time)//��ʱ��������Ϊ��λ
	{
	clock_t now=clock();
	while(clock()-now<time*1000);
	}