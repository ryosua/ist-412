Setup:
1. To run this application, you must put the extracted folder in the Windows C-drive.

2. Once you set the folder in C:\, open the java folder. Go to src, then progem-test-242-1. 

3. Open cmdxp.exe and you should see C:\java\src\program-test-242-1>. Type setup7 and hit enter.

4. After the setup runs, type cd../ until you get to C:\java. Type ant and hit enter.
	a. If an error has occured, you must do two things:
		- Go to Windows and search for system variables.
		- Click on Environment Variables and under System variables, click New..
		- Name your variable ant and put your ant folder location on the value. Hit Ok on both Windows.
	b. Next go to program-test-242-1 folder and edit your setup7.bat using Notepad++.
		- set Path= C:\java\jdk1.7.0_71\bin;%ant%/bin
		- Save and run ant again.

5. Your application is now ready to run.