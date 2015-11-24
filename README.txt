How to compile the code:

Note: This guide assumes you have both java and ant installed.

1. Unzip the file.

2. Download the following libraries and put them in a directory called "lib" in the root directory:
    - commons-lang3-3.4.jar
    - junit-4.10.jar

3. Create a new file called build.properties and put it in the root directory.

4. Add the following lines to the file:

        # Build Directories
        binDirectory=/Users/ryosua/java/bin
        distDirectory=/Users/ryosua/java/dist
        srcDirectory=/Users/ryosua/java/src/program-test-242-1
        libDirectory=/Users/ryosua/java/lib
        docDirectory=/Users/ryosua/java/doc
        testDirectory=/Users/ryosua/java/src/program-test-242-1/test

        #Executable class name
        mainClass=controller.Main

        # jar app name
        appName=ProgramTest


5. Edit the paths to reflect where you unzipped the source code to and save.

6. Download the example code from http://acs.ist.psu.edu/courses/ist412/source/java-tester-demo.zip

7. There are two "src" directories in this new zip folder. Find the second one and cut and paste it into the the first folder that was unzipped under the directory titled "program-test-242-1".

8. Open up the command prompt/terminal, navigate to the root directory and enter the command "ant". This will run the 
default ant target for the project "run-all".

9. Once you have opened the program click on the help tab in the menu bar for instructions on how to use the program.