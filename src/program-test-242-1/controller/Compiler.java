package controller;

import java.io.*;
import java.util.*;
import java.lang.ProcessBuilder.Redirect;
import model.Student;

public class Compiler
{
  private final Student student;
 
  private int success;
    
  public Compiler(Student student)
  {
    this.student = student;
    success = 1;  // Outcome of compilation, success = 0
  }
    
  public int compileJava()
  {
    try
    {
//    create new bin directory
      boolean createBin = new File(student.getClassPath()).mkdirs();

//    create new javac ProcessBuilder        
//      ProcessBuilder pb =
//      new ProcessBuilder("javac", "-d", classPath, "./" + studentPath + "/*.java");

      ProcessBuilder pbDir = new ProcessBuilder("dir");
//    Determine current working directory
	  File srcAbsPath = new File(student.getSourcePath());
	  String srcAbsPathName = srcAbsPath.getAbsolutePath();
	  //System.out.println("source path: " + sourcePath); 
	  //System.out.println("source absolute path: " + srcAbsPathName);

	  
      File cwd = pbDir.directory();
//    debug code - to confirm correct directory       
//    TestTools.dir(cwd);
//    NB - ProcessBuilder default is to return a null  
//    pointer for the abstract path to indicate that it 
//    is using System.Properties "user.dir", i.e., the 
//    current system working directory; hence the
//    critical need to handle a NullPointerException.
//    Also returns a null pointer if the directory
//    doesn't exist.

      File nwd = TestTools.cd(cwd, student.getStudentPath());
      String studentPathName = nwd.getAbsolutePath();
	  File nwdPath = new File(student.getStudentPath());
//    System.out.println("studentPathName: " + studentPathName);
//    debug code to test new working directory
//    TestTools.dir(nwd);

	  FileFilter filter = new FileFilter();
	  String[] javaFileList = nwdPath.list(filter); 
//    set up output file      
      File outputFile = new File(student.getOutputFileName());
//    System.out.println(outputFileName);
      outputFile.delete();
	  
	  for(int k = 0; k < javaFileList.length; k++)
	  {
	    try
		{
		  if(filter.accept(nwdPath, javaFileList[k]) == true)
		  { 
	        //System.out.println("Compiling: " + javaFileList[k]);

            ProcessBuilder pb =
            new ProcessBuilder("javac", "-d", student.getClassPath(), student.getPath() + "/" + javaFileList[k]);
	  
//          Create environment map and set environmental variables         
            Map<String, String> env = pb.environment();       
            env.clear();
            env.put("PATH", student.getPath());
            env.put("CLASSPATH", student.getClassPath());
//          env.put("SOURCEPATH", sourcePath);
//          env.remove("OTHERVAR");

            pb.redirectErrorStream(true);
            pb.redirectOutput(Redirect.appendTo(outputFile));
            
            // Save output file for later.
            student.getResults().addFile(outputFile);

//          start javac process        
            Process p = pb.start();
        
//          need other processes to wait for compilation to finish
//          basically joins the thread to the javac process to force sequential
//          execution - need to be careful - if any process hangs, whole run hangs
            success = p.waitFor();

            assert pb.redirectInput() == Redirect.PIPE;
            assert pb.redirectOutput().file() == outputFile;
            assert p.getInputStream().read() == -1;
		  } 
		} catch(Exception e)
          {
            System.out.println("Compile Exception: " + javaFileList[k]);
            e.printStackTrace();
          }	
      }      
	} catch(Exception e)
      {
        System.out.println("Compile Exception");
        e.printStackTrace();
      }
    return success;
  }
}