package finall;
import places.*;
import time.*;
import money.*;
import java.util.*;
import java.io.*;
import kruskal.*;
import floyd.*;
class invalidstring extends Exception
{
	invalidstring(String s)
	{
		super(s);
	}
}
class invalidstate extends Exception{
	invalidstate(String s)
	{
		super(s);
	}
}
public class project3
{
	String source;
	String destination;
	project3()
	{}
	project3(String n1,String n2)
	{
		source = n1;
		destination = n2;
	}
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		project obj=new project(25);
		System.out.println(" Service available in following states: ");
		obj.display1();
		System.out.println(" Service available in following places: ");
		obj.display();
		System.out.println("Enter plan to schedule a new journey or see to have a look at the scheduled journey and stop to exit..... ");
		String choice=s.nextLine();
		try(FileWriter f=new FileWriter("java.txt"))
		{}
		catch(Exception ex)
		{}
		while(!choice.equals("stop"))
		{
			try
			{
			if(choice.equals("plan"))
			{
				System.out.println("Enter the date of journey:");
				String date=s.nextLine();
				System.out.println("Enter the time: ");
				String time3=s.nextLine();
		System.out.println("Enter the state: ");
		String state=s.nextLine();
		try
		{
			if(obj.retstate(state)!="-1")
			{
				System.out.print("Airports in "+state+" : ");
				System.out.println(obj.retstate(state));
			}
			else
				throw new invalidstate(state);
		}
		catch(invalidstate e)
		{
			System.out.println(e.getMessage()+" is not a state");
			System.out.println("Enter the correct state...");
			return;
		}
		System.out.println("Enter all for an All India Tour and single for a journey from ur place to a different place ... ");
		try
		{
			String p=s.nextLine();
			if(p.equals("all"))
			{
				int temp;
				System.out.println("Enter the boarding point: ");
				String source=s.nextLine();
				int i=obj.retind(source);
				if(i==-1)
				{
					System.out.println(source+" is not a place....");
					return;
				}
				project1 p1=new project1(obj.retvert());
				p1.set();
				project2 p2=new project2(obj.retvert());
				p2.set();			
				kruskal k=new kruskal(p1.rettime(),obj.retvert());
				kruskal kk=new kruskal(p2.retmoney(),obj.retvert());
				int mintime=2*(k.kruskals(i,i,0));
				int mincost=2*(kk.kruskals(i,i,0));
				int hr1=mintime/60;
				int min1=mintime%60;
				System.out.print("All India tour takes atleast "+mincost+" Rs if you book today...");
				if(min1!=0)
					System.out.println(" and it is a "+hr1+" hour "+min1+" minutes toor...");
				else
					System.out.println(" and it is a "+hr1+" hours toor... ");
				System.out.println("Do you want to book now? ");
				String q=s.nextLine();
				if(q.equals("yes"))
				{
				try(FileWriter fout=new FileWriter("java.txt",true))
				{
					fout.write("Date:"+ date);
					fout.write("\t \t \t \t \t \tTime:"+time3);
					fout.write('\n');
					fout.write("All India Trip");
					fout.write('\n');
					fout.write(" Cost: "+ mincost+" Rs or above");
					fout.write('\n');
					fout.write(" Time: "+mintime+" minutes or more....");
					fout.write("\n \n");
				}
				catch(Exception e)
				{
					System.out.println("File couldn't be opened....");
				}
			}
			else
				break;
			}
			else if(p.equals("single"))
			{	
				System.out.println("Enter the boarding point: ");
				String source=s.nextLine();
				System.out.println("Enter the dropping point: ");
				String desti=s.nextLine();
				System.out.println("Enter time if u prefer a fast journey and money if u prefer a cheaper journey...");
				String opt=s.nextLine();
				project3 obj1=new project3(source,desti);
				int i=obj.retind(obj1.source);
				int j=obj.retind(obj1.destination);
				if(i==-1)
				{
					System.out.println(obj1.source+" is not a place in "+state);
					return;
				}
				if(j==-1)
				{
					System.out.println(obj1.destination+" is not a place in "+state);
					return;
				}
				try
				{
					if(opt.equals("time"))
					{
						project1 t1=new project1(obj.retvert());
						t1.set();
						kruskal k1=new kruskal(t1.rettime(),obj.vertices);
						int time1=k1.kruskals(i,j,1);
						int time2=floyd.floyds(t1.rettime(),i,j,obj.vertices);
						int time=floyd.min(time1,time2);
						int hr=time/60;
						int min=time%60;
						if(min!=0)
							System.out.println("Faster journey from "+obj1.source+" to "+obj1.destination+" takes "+time+" minutes.. i.e, "+hr+" hours and "+min+" minutes ...");
						else
							System.out.println("Faster journey from "+obj1.source+" to "+obj1.destination+" takes "+time+" minutes.. i.e, "+hr+" hours... ");
						System.out.println("Do you want to book now? ");
						String q2=s.nextLine();
						if(q2.equals("yes"))
						{
							try(FileWriter fout2=new FileWriter("java.txt",true))
							{
							fout2.write("Date:"+ date);
							fout2.write("\t \t \t \t \t \tTime:"+time3);
							fout2.write('\n');
							fout2.write("Boarding point: "+obj1.source);
							fout2.write('\n');
							fout2.write("Dropping point: "+obj1.destination);
							fout2.write('\n');
							fout2.write(" Time: "+ time+" minutes or more");
							fout2.write("\n \n");
							}
					catch(Exception e)
					{
						System.out.println("File couldn't be opened....");
					}
					}
						else
							break;
					}
					else if(opt.equals("money"))
					{
						project2 t2=new project2(obj.retvert());
						t2.set();
						kruskal k2=new kruskal(t2.retmoney(),obj.vertices);
						int cost1=k2.kruskals(i,j,1);
						int cost2=t2.floyds(t2.retmoney(),i,j,obj.vertices);
						int cost=floyd.min(cost1,cost2);
						System.out.println("Cheper journey from "+obj1.source+" to "+obj1.destination +" takes "+cost+" Rs...");
						System.out.println("Do you want to book now? ");
						String q1=s.nextLine();
						if(q1.equals("yes"))
						{
							try(FileWriter fout1=new FileWriter("java.txt",true))
							{
							fout1.write("Date:"+ date);
							fout1.write("\t \t \t \t \t \tTime:"+time3);
							fout1.write('\n');
							fout1.write("Boarding point: "+obj1.source);
							fout1.write('\n');
							fout1.write("Dropping point: "+obj1.destination);
							fout1.write('\n');
							fout1.write(" Cost: "+ cost+" Rs or above");
							fout1.write("\n \n");
							}
				catch(Exception e)
				{
					System.out.println("File couldn't be opened....");
				}
				}
						else
							break;
					}
					else if(!opt.equals("money") || !opt.equals("time"))
						throw new invalidstring(opt);
				}
				catch(invalidstring e)
				{
					System.out.println(e.getMessage()+" is an Invalid Option....");
				}
			}
			else if(!p.equals("single") || !p.equals("all"))
						throw new invalidstring(p);
		}
		catch(invalidstring e)
		{
				System.out.println(e.getMessage()+" is an Invalid Option....");
		}
		}
		else if(choice.equals("see"))
		{
			try(FileReader fin=new FileReader("java.txt"))
			{
				int j;
				System.out.print("\n \n");
				while((j=fin.read())!=-1)
					System.out.print((char)j);
				System.out.println("\n ");
			}
			catch(Exception e)
			{
				System.out.println("File couldn't be opened....");
				System.out.println("\n \n");
			}
		}
		else
			throw new invalidstring(choice);
	}
	catch(invalidstring e)
	{
		System.out.println(e.getMessage()+" is an Invalid Option....");
	}
		System.out.println("Enter plan to schedule a new journey or see to have a look at the scheduled journey and stop to exit..... ");
		choice=s.nextLine();
	}
	}
}
