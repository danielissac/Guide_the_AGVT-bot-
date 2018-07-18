// A Java program for Dijkstra's
// single source shortest path 
// algorithm. The program is for
// adjacency matrix representation
// of the graph.
import java.util.*;
import java.sql.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
class GuideTheBot {
 
    private static final int NO_PARENT = -1;
 
    // Function that implements Dijkstra's
    // single source shortest path
    // algorithm for a graph represented 
    // using adjacency matrix
    // representation
    private static void dijkstra(String[][] adjacencyMatrix,
                                         int startVertex,ArrayList<Integer> list1)
    {
        int nVertices = adjacencyMatrix[0].length;
        // shortestDistances[i] will hold the
        // shortest distance from src to i
        int[] shortestDistances = new int[nVertices];
 
        // added[i] will true if vertex i is
        // included / in shortest path tree
        // or shortest distance from src to 
        // i is finalized
        boolean[] added = new boolean[nVertices];
 
        // Initialize all distances as 
        // INFINITE and added[] as false
        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++)
        {
            shortestDistances[vertexIndex] = Integer.MAX_VALUE;
            added[vertexIndex] = false;
        }
         
        // Distance of source vertex from
        // itself is always 0
        shortestDistances[startVertex] = 0;
 
        // Parent array to store shortest
        // path tree
        int[] parents = new int[nVertices];
 
        // The starting vertex does not 
        // have a parent
        parents[startVertex] = NO_PARENT;
 
        // Find shortest path for all 
        // vertices
        for (int i = 1; i < nVertices; i++)
        {
 
            // Pick the minimum distance vertex
            // from the set of vertices not yet
            // processed. nearestVertex is 
            // always equal to startNode in 
            // first iteration.
            int nearestVertex = -1;
            int shortestDistance = Integer.MAX_VALUE;
            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++)
            {
                if (!added[vertexIndex] &&
                    shortestDistances[vertexIndex] < shortestDistance) 
                {
                    nearestVertex = vertexIndex;
                    shortestDistance = shortestDistances[vertexIndex];
                }
            }
 
            // Mark the picked vertex as
            // processed
            added[nearestVertex] = true;
 
            // Update dist value of the
            // adjacent vertices of the
            // picked vertex.
            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) 
            {
					
					char adjval = adjacencyMatrix[nearestVertex][vertexIndex].charAt(0);
					int edgeDistance = Character.getNumericValue(adjval);
					if (edgeDistance > 0
						&& ((shortestDistance + edgeDistance) < 
							shortestDistances[vertexIndex])) 
					{
						parents[vertexIndex] = nearestVertex;
						shortestDistances[vertexIndex] = shortestDistance + edgeDistance;
					}
            }
        }
 
        printSolution(startVertex, shortestDistances, parents,list1);
    }
 
    // A utility function to print 
    // the constructed distances
    // array and shortest paths
    private static void printSolution(int startVertex,
                                      int[] distances,
                                        int[] parents,ArrayList<Integer> list1)
    {
        int nVertices = distances.length;
        //System.out.print("Vertex\t Distance\tPath");
        
		int max = 100;
		int vertexIndexg = 0;
        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) 
        {
            if (vertexIndex != startVertex) 
            {
                //System.out.print("\n" + startVertex + " -> ");
                //System.out.print(vertexIndex + " \t\t ");
                //System.out.print(distances[vertexIndex] + "\t\t");
				//if(vertexIndex==orderplaced)
				//{
					if(distances[vertexIndex]<max && list1.contains(vertexIndex))
					{
						max=distances[vertexIndex];
						vertexIndexg = vertexIndex;
					}
                //printPath(vertexIndex, parents);
				//}
            }
        }
		printPath(vertexIndexg,parents);
		rowcount++;
		list1.remove(new Integer(vertexIndexg));
		if(list1.size()>0)
		{
			dijkstra(adjacencyMatrix,vertexIndexg,list1);
		}
		else if(list1.size()==0 && flag==0)
		{
			flag=1;
			list1.add(starting);
			dijkstra(adjacencyMatrix,vertexIndexg,list1);
		}
		else
		{
			System.out.println("The shortest path from source to any node");
			for(int j=0;j<size+1;j++)
			{
				String dirstr="";
				for(int k=0;k<patharray[j].length-1;k++)
				{
					if(patharray[j][k]==null)
						break;
					else
					{
						System.out.print(patharray[j][k]+"--->");
						if(patharray[j][k+1]==null)
							continue;
						int st = Integer.parseInt(patharray[j][k]);
						int et = Integer.parseInt(patharray[j][k+1]);
						dirstr += ""+adjacencyMatrix[st][et].charAt(1);
					}
				}
				directionarray[j]=dirstr;
				System.out.println();
			}
		}
		
		
    }
 
    // Function to print shortest path
    // from source to currentVertex
    // using parents array
	static String[][] patharray = new String[100][100];
	static String[] directionarray = new String[100];
	static int colcount;
	static int rowcount=0;
    private static void printPath(int currentVertex,
                                      int[] parents)
    {
        // Base case : Source node has
        // been processed
		colcount=0;
        if (currentVertex == NO_PARENT)
        {
            return;
        }
        printPath(parents[currentVertex], parents);
		patharray[rowcount][colcount++] = ""+currentVertex;
    }
	
	static String[][] adjacencyMatrix = null;
	static ArrayList<Integer> list;
	static ArrayList<String> binlist = new ArrayList<String>();
	static int size;
	static int starting;
	static int binsize;
	static int flag=0;
	static String[][] orderarr = new String[100][100]; //contains the orderdetails in 2d format
    public static void main(String[] args)
    {
		starting = 0;
		list = new ArrayList<Integer>();
		try
		{
			xlsxreader("Orders.xlsx",1);
			xlsxreader("pathmatrixsmall.xlsx",2);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		binsize = binlist.size();
		int temp;
		for(int i=0;i<binsize;i++)
		{
			temp = bin_rfid_conversion(binlist.get(i));
			System.out.println(binlist.get(i)+"----"+temp);
			list.add(new Integer(temp));
		}
		Set<Integer> s = new HashSet<Integer>();
		s.addAll(list);
		list.clear();
		list.addAll(s);
		size = list.size();
        dijkstra(adjacencyMatrix,starting,list);
		for(int j=0;j<size+1;j++)
			correctify(directionarray[j],sstatus);
		for(int j=0;j<size+1;j++)
		{
			int k=0;
			for(;k<correctify[j].length();k++)
			{
				patharray[j][k]=rfid_unique_conversion(Integer.parseInt(patharray[j][k]));
				command_for_bot += patharray[j][k]+"@"+correctify[j].charAt(k)+"@@";
			}
			patharray[j][k]=rfid_unique_conversion(Integer.parseInt(patharray[j][k]));
			command_for_bot += patharray[j][k]+"<br>";
		}
		System.out.println(command_for_bot);
		//patharray[productid][productid(rfid)] 2d array contains the rfid information
		//correctify[productid] is a string array for directions
		//orderarr[][] orderdetails array in 2d format
		//adjacencyMatrix is hardcoded
		//command_for_bot string variable holds entire order path information with directions
    }
	static String command_for_bot = "";
	static String[] correctify = new String[100];
	static int flag1=0;
	static String sstatus="w";
	public static void correctify(String input,String status)
	{

				String result="";

				char d;




				for(int i=0;i<input.length();i++)

				{

					d =input.charAt(i);

				   

				switch(status)

				{

					case "w":

					{

					   

					if(d=='F')

					{

					   

					  

						status="w";

						break;

					}

					 if(d=='B')

					{

					  

						status="w";

						break;

					}

					 if(d=='R')

					{

					   

						status="n";

						break;

					}

					 if(d=='L')

					{

					   

						status="s";

						break;

					}

					}

					break;

				   

				case "n":

					{

					   

					if(d=='F')

					{

					   

						d='L';

						status="w";

						break;

					}

					 if(d=='B')

					{

						d='R';

						status="e";

						break;

					}

					 if(d=='R')

					{

						d='F';

						status="n";

						break;

					}

					 if(d=='L')

					{

						d='B';

						status="n";

						break;

					}

					}

					break;

					case "e":

					{

					if(d=='L')

					{

						d='R';

						status="s";

						break;

					}

					 if(d=='R')

					{

						d='L';

						status="n";

						break;

					}

					 if(d=='F')

					{

						d='B';

						status="e";

						break;

					}

					 if(d=='B')

					{

						d='F';

						status="e";

						break;

					}

					}

					break;

					case "s":

					{

					if(d=='F')

					{

						d='R';

						status="w";

						break;

					}

					 if(d=='B')

					{

						d='L';

						status="e";

						break;

					}

					 if(d=='R')

					{

						d='B';

						status="s";

						break;

					}

					 if(d=='L')

					{

						d='F';

						status="s";

						break;

					}

					}

					break;

				}


				result=result+d;

				}


				sstatus = status;   
				correctify[flag1]=result;
				flag1++;
	}
	public static void xlsxreader(String filelocation,int flag) throws IOException
	{
		try
		{
		InputStream ExcelFileToRead = new FileInputStream(filelocation); //mention the xlsx file location
		XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
		
		XSSFWorkbook test = new XSSFWorkbook(); 
		
		
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row; 
		XSSFCell cell;

		Iterator rows = sheet.rowIterator();
		int count = sheet.getPhysicalNumberOfRows();
		adjacencyMatrix = new String[count][count];
		int rown=0;
		boolean rowflag=false;
		while (rows.hasNext())
		{
			if(!rowflag)
			{
				rowflag=true;
				continue;
			}
			row=(XSSFRow) rows.next();
			Iterator cells = row.cellIterator();
			int coln=0;
			boolean colflag=false;
			while (cells.hasNext())
			{
				if(!colflag)
				{
					colflag=true;
					continue;
				}
				cell=(XSSFCell) cells.next();
		
				if (cell.getCellTypeEnum() == CellType.STRING)
				{
					if(flag==1)
					{
						String binlocation=cell.getStringCellValue().replaceAll("\"","");
						if(coln==3)
						{
							binlist.add(new String(binlocation));
						}
						orderarr[rown][coln]=binlocation;
					}
					if(flag==2)
					{
						String pathpos=cell.getStringCellValue().replaceAll("\"","");
						adjacencyMatrix[rown][coln]=pathpos;
					}
					//System.out.println(orderarr[rown][coln]);
				}
				/*else if(cell.getCellTypeEnum() == CellType.NUMERIC)
				{
					if(coln==3)
					{
						String binlocation=cell.getStringCellValue()+"";
						binlist.add(new String(binlocation.replace("\"","")));
						orderarr[rown][coln]= binlocation;
					}
					orderarr[rown][coln]=cell.getNumericCellValue()+"";
				}*/
				coln++;
			}
			rown++;
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	static String rfid_unique_conversion(int a)//command_for_bot
	{
		String val = null;  
			try
			{
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ych","root","praisethelord");  //use your db credentials
				Statement stmt=con.createStatement();  
				ResultSet rs=stmt.executeQuery("select unique_rfid from location_info where reference="+a);
				rs.next();
				val = rs.getString(1); 
				con.close();  
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return val;
	}
	static int bin_rfid_conversion(String bin)//order xlsx - internal process
	{
		int val = -1;
			try
			{
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/ych","root","praisethelord");  //use your db credentials
				Statement stmt=con.createStatement();  
				ResultSet rs=stmt.executeQuery("select reference from location_info where bin_location='"+bin+"'");  
				rs.next();
				val = rs.getInt(1); 
				con.close();  
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return val;
	}
	static String[] unique_bin(String str)
	{
		String[] arr=null;
		try{  
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/ych","root","praisethelord");  //use your db credentials
				Statement stmt=con.createStatement();  
				ResultSet rs=stmt.executeQuery("select bin_location from location_info where unique_rfid='"+str+"'");
				rs.last();
				int count = rs.getRow();
				rs.beforeFirst();
				arr = new String[count];
				int i = 0;
				while(rs.next())
				{
					arr[i] = rs.getString(1); 
					i++;
				}
				con.close();  
				}catch(Exception e){ System.out.println(e);}  
			
			return arr;
	}
}