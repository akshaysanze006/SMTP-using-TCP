import java.io.*; 
import java.net.*; 
public class Server2 extends Thread 
{ 
int flag; 
Thread t; 
ServerSocket svr; 
Socket client; 
public static Clientthreads[] ths=new Clientthreads[15];  
public static Socket cmm; 
public Server2(int portno) //constructor 
{ 
try 
{ svr=new ServerSocket(portno); 
cmm=new Socket("127.0.0.1",4444); 
System.out.println("Connected to gmail server"); 
for(int i=0;i<15;i++) 
ths[i]=null; 
} 
catch(Exception e) 
{ 
System.out.println("error :"+e); 
}

} 
public void run() 
{ 
try 
{ int i=0; 
while(true) 
{ 
client=svr.accept(); 
BufferedReader br=new BufferedReader(new  
InputStreamReader(client.getInputStream())); 
PrintWriter pout=new PrintWriter(client.getOutputStream(),true); 
String a=br.readLine(); 
BufferedReader fin=new BufferedReader(new FileReader("login2.txt")); String line; 
while((line=fin.readLine())!=null) 
{ 
if(a.equals(line)) 
{ pout.println("1"); //login successful 
flag=1; 
break; 
} 
} 
if(flag!=1) 
{ pout.println("0"); 
client.close(); 
continue; 
} 
if(ths[i]==null) 
{ ths[i]=new Clientthreads(client,ths,i,cmm); 
ths[i].t1=new Thread(ths[i]); 
ths[i].t2=new Thread(ths[i]); 
ths[i].t1.start(); 
ths[i].t2.start(); 
i++; 
} 
} 
} 
catch(Exception e) 
{ 
System.out.println("Error !!:"+e); 
} 
}

public static void main(String args[]) 
{ 
Server2 s=new Server2(6666); 
s.t=new Thread(s); 
s.t.start(); 
} 
} 
class Clientthreads extends Thread 
{ 
BufferedReader buf; 
PrintWriter out; 
String str,a; 
String sendmsg[]; 
Socket client; 
Clientthreads[] ths; 
int id; 
Thread t1,t2; 
public static String[] names=new String[15]; 
public static Socket cmm; 
public static BufferedReader bmm; 
public static PrintWriter pmm;  
public Clientthreads(Socket client,Clientthreads[] threads,int i,Socket cmm) { 
try 
{ 
this.client=client; 
ths=threads; 
id=i; 
this.cmm=cmm; 
bmm=new BufferedReader(new InputStreamReader(cmm.getInputStream())); pmm=new PrintWriter(cmm.getOutputStream(),true); 
buf=new BufferedReader(new InputStreamReader(client.getInputStream())); out=new PrintWriter(client.getOutputStream(),true); 
} 
catch(Exception e) 
{ System.out.println("Error :"+e); 
} 
} 
public void run() 
{ 
if(Thread.currentThread()==t1) 
{

while(true) 
{ 
try 
{ 
str=buf.readLine(); 
if(str.equals("logout")) 
{ 
ths[id]=null; 
break; 
} 
pmm.println(str); 
} 
catch(Exception e) 
{ System.out.println("error :"+e); 
} 
} 
} 
else 
{ 
while(true) 
{ 
try 
{ 
a=bmm.readLine(); 
for(int i=0;ths[i]!=null;i++) 
{ 
ths[i].out.println(a); 
} 
} 
catch(Exception e) 
{ System.out.println("error :"+e); 
} 
} 
} 
} 
} 
