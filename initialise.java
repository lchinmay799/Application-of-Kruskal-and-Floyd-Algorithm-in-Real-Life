package places;
import java.util.*;
public class project
{
public static String[] places;
	Hashtable <String, String> state;
	public int vertices;
	public project()
	{}
	public project(int a)
	{
		vertices=a;
		places=new String[vertices];
		state=new Hashtable<String, String>();
		places[0]="Banglore";
		places[1]="Vishakapattanam";
		places[2]="Chennai";
		places[3]="Mumbai";
		places[4]="Goa";
		places[5]="Manglore";
		places[6]="Mysore";
		places[7]="Agra";
		places[8]="Trivendram";
		places[9]="Kolkatta";
		places[10]="Srinagar";
		places[11]="Odisha";
		places[12]="Chandigarh";
		places[13]="Kota";
		places[14]="Patna";
		places[15]="Hyderabad";
		places[16]="Ranchi";
		places[17]="Gangtok";
		places[18]="Gandhinagar";
		places[19]="Ahmadabad";
		places[20]="Surat";
		places[21]="Jaipur";
		places[22]="Lucknow";
		places[23]="Nagpur";
		places[24]="Varanasi";


		state.put("Karnataka","Banglore, Mysore and Manglore");
		state.put("Rajasthan","Kota and Jaipur");
		state.put("West Bengal","Kolkatta");
		state.put("Andra Pradesh","Vishakapattanam and Hyderabad");
		state.put("Tamil Nadu","Chennai");
		state.put("Gujarat","Surat, Gandhi Nagar and Ahmadabad");
		state.put("Uttar Pradesh","Lucknow, Varanasi and Agra");
		state.put("Maharashtra","Mumbai and Nagpur");
		state.put("Kerala","Trivendram");
		state.put("Jammu & Kashmir","Srinagar");
		state.put("Orissa","Odisha");
		state.put("Jharkhand","Ranchi");
		state.put("Chandigarh","Chandigarh");
		state.put("Sikkim","Gangtok");
		state.put("Goa","Goa");
		state.put("Bihar","Patna");
	}
	public String retpla(int i)
	{
		return places[i];
	}
	public int retind(String name)
	{

		int flag=0,i;
		for(i=0;i<vertices;i++)
		{
			if(name.equals(places[i]))
			{
				flag=1;
				break;
			}	
		}
		if(flag==1)
			return i;
		else
			return -1;
	}
	public int retvert()
	{
		return vertices;
	}
	public String retstate(String name)
	{
		if(state.containsKey(name))
		{
			String stat="";
			stat=stat+state.get(name);
			return stat;
		}
		return "-1";
	}
	public static String retplace(int i)
	{
			return places[i];
	}
	public void display()
	{
		for(int i=0;i<25;i++)
			System.out.println("				"+places[i]);
	}
	public void display1()
	{
		Enumeration e=state.keys();
		while(e.hasMoreElements())
			System.out.println("									"+e.nextElement());
	}

}
