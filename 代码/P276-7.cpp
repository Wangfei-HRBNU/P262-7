#include<iostream>
#include<fstream>
#include<string>
#include<stdlib.h>
#include<ctime>

using namespace std;

const int MAX=100;//定义最大值

int Marking();
void SaveScore(int i);
int ReadScore();
void Delay(int);

struct strScore
	{
	int SNo;//学号
	int Score;//成绩
	int Flag;//答案合法标志,0-合法，1-答案过短，2-答案过长，3-含有非法字符
	}strS[MAX];//建立成绩结构体数组;

int main()
	{
	char cFlag;//功能选择标志
start:
	cout<<"\t\t\t单选题自动判卷系统"<<endl;
	cout<<"  \t\t\t1-开始判卷\n"<<"  \t\t\t2-读取上次判卷成绩\n"<<"  \t\t\t3-退出系统\n"<<"  \t\t\t  请选择："<<endl;
	cin>>cFlag;
	switch(cFlag)
		{
		case '1':Marking();break;
		case '2':ReadScore();break;
		case '3':return 0;
		default:
			system("Cls");//清屏
			cout<<"输入无效！请稍候重新选择！"<<endl;
			Delay(2);//延时
		}
	system("Cls");
	goto start;
	return 0;
	}

int Marking()//判卷函数
	{	
	ifstream fin;
	system("Cls");
	char cFlag;
	fin.open("exams.txt");
	cout<<"学号\t\t\t成绩\n";
	char sAns[MAX];//学生答案
	char sSAns[MAX];//标准答案
	int i,j;
	fin.getline(sSAns,MAX,'\n');//读取标准答案
	for(i=0;(!fin.eof())&&i<MAX;i++)//读取学生循环
		{
		fin>>strS[i].SNo;//读取学生学号
		strS[i].Score=0;//初始化学生成绩
		strS[i].Flag=0;
		fin.ignore(1,' ');//忽略空格
		fin.getline(sAns,MAX,'\n');//读取学生答案
		if(strlen(sAns)<strlen(sSAns))//判断答案合法性
			strS[i].Flag=1;
		else if(strlen(sAns)>strlen(sSAns))
			strS[i].Flag=2;
		else
		for(j=0;j<strlen(sAns);j++)//判分循环
			if(sAns[j]<'a'||sAns[j]>'f')
				{strS[i].Flag=3;break;}
			else if(sAns[j]==sSAns[j])
				strS[i].Score++;//给分
		cout<<strS[i].SNo<<"\t\t\t";//输出学号
		switch(strS[i].Flag)//输出成绩
			{
			case 0:cout<<strS[i].Score<<'\n';break;
			case 1:cout<<"该学生答案过短"<<'\n';break;
			case 2:cout<<"该学生答案过长"<<'\n';break;
			case 3:cout<<"该学生答案非法"<<'\n';
			}
		}

exitMarking:
	cout<<"\n判卷完成！是否保存数据？\n";
	cout<<"1-保存并退出判卷\n2-不保存并退出判卷\n";
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
	fout<<"学号\t\t\t成绩\n";
	int j=i;
	while(i>0)
		{
		fout<<strS[j-i].SNo<<"\t\t\t";
		switch(strS[j-i].Flag)
			{
			case 0:fout<<strS[j-i].Score<<'\n';break;
			case 1:fout<<"该学生答案过短"<<'\n';break;
			case 2:fout<<"该学生答案过长"<<'\n';break;
			case 3:fout<<"该学生答案非法"<<'\n';
			}
		i--;
		}
	fout.close();
	}

int ReadScore()//读取上次判卷成绩
	{
	system("Cls");
	ifstream fin;
	ofstream fout;
	fin.open("scores.txt");
	if(fin.eof())
		{
		cout<<"上次判卷成绩不存在！稍候回归主界面！"<<endl;
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
	cout<<"\n上次判卷成绩读取完成，按0回到主界面"<<endl;
	while(a!='0')cin.get(a);
	fin.close();
	return 0;
	}

void Delay(int time)//延时程序，以秒为单位
	{
	clock_t now=clock();
	while(clock()-now<time*1000);
	}