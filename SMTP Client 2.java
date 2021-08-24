import java.io.*; 
import java.net.*; 
public class Client2 extends Thread 
{

public static int i; 
Socket sock; 
Thread t1,t2; 
BufferedReader br; 
String line,usr,pwd; 
BufferedReader buff;  
PrintWriter pout; 
 public Client2() 
{ try 
{ 
sock=new Socket("127.0.0.1",6666); 
System.out.println("server connected");  
br=new BufferedReader(new InputStreamReader(sock.getInputStream())); buff=new BufferedReader(new InputStreamReader(System.in)); 
pout=new PrintWriter(sock.getOutputStream(),true); 
System.out.println("enter username : "); 
usr=buff.readLine(); 
System.out.println("enter password : "); 
pwd=buff.readLine(); 
pout.println(usr+"//"+pwd); 
line=br.readLine(); 
i=Integer.valueOf(line); 
if(i==1) 
System.out.println("Login Successful!!\n"); 
else 
{ 
System.out.println("Login failed"); 
} 
} 
catch(IOException e) 
{ 
 System.err.println("error"+e); 
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
 line=br.readLine(); //read from socket

 String rcmsg[]; 
rcmsg=line.split("//"); 
System.out.println("\nIncoming message!!\n"); 
System.out.println("To :"+rcmsg[0]); 
System.out.println("From :"+rcmsg[1]); 
System.out.println("Message :"+rcmsg[2]); 
} 
catch(Exception e) 
{ 
 System.err.println("error"+e); 
} 
} 
} 
else 
{ 
while(true) 
{ 
try 
{ String to,from,msg; 
System.out.println("\nenter mail to send a message"); 
String str=buff.readLine(); //to read from terminal 
if(str.equals("mail")) 
{ 
System.out.println("To :"); 
to=buff.readLine(); 
System.out.println("From :"); 
from=buff.readLine();  
System.out.println("Message :"); 
msg=buff.readLine(); 
pout.println(to+"//"+from+"//"+msg); //to write to  
socket 
} 
else if(str.equals("logout")) 
{ 
pout.println(str); 
t1=null; 
t2=null; 
break; 
} 
} 
catch(Exception e) 
{

 System.err.println("error"+e); 
} 
} 
} 
} 
public static void main(String args[]) 
{ 
Client2 ss=new Client2(); 
if(i==1) //if logged in 
{ 
ss.t1=new Thread(ss); 
ss.t2=new Thread(ss); 
ss.t1.start(); 
ss.t2.start(); 
} 
} 
} 
