# SMTP-using-TCP

Most of the internet systems use SMTP as a method to transfer mail from one user to another.  SMTP is a push protocol and is used to send the mail whereas POP (post office protocol) or  IMAP (internet message access protocol) are used to retrieve those mails at the receiver’s  side.SMTP is an application layer protocol. The client who wants to send the mail opens a TCP  connection to the SMTP server and then sends the mail across the connection. The SMTP  server is always on listening mode. As soon as it listens for a TCP connection from any client,  the SMTP process initiates a connection on that port (25). After successfully establishing the  TCP connection the client process sends the mail instantly. 


Algorithm: 
• Client 
 1.Create client socket. 
 2. Accept username and password from user and send to clients output stream.  3. Get response from server to ‘response’. 
 4. If response= “success” then 
 5. start readmessage thread. 
 6. start createmessage thread. 
 7. else 
 8. Print “Login failed”. 
 Thread_write_message 
 1. Read message from user. 
 2. Write mail to server.  
 Thread_read_message 
 1. Read mail from user 
 2. Print mail. 
• Server 
 1. Create server socket. 
 2. Get username and password. 
 3. If valid then 
 4. send response “success” to client. 
 5. accept mail from client mail. 
 6. create client socket for server2. 
 7. send mail to server2 
 8. If mail received from server2 then
 9. send mail to client 

SERVER 1
login1.txt 
dolly@gmail.com//dolly 
rohan@gmail.com//rohan 
nikki@gmail.com//nikki 
sunny@gmail.com//sunny 
• login2.txt 
chandler@yahoo.com//chandler 
monica@yahoo.com//monica 
phoebe@yahoo.com//phoebe 
rachel@yahoo.com//rachel 
ross@yahoo.com//ross 
joey@yahoo.com//joey 

