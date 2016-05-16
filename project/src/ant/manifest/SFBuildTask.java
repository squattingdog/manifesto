package ant.manifest;

import java.util.Iterator;
import java.util.Vector;

import org.apache.tools.ant.*;
import ant.manifest.contexts.PackageContext;

public class SFBuildTask extends org.apache.tools.ant.Task {
	private boolean isDestructive = false;
	private String buildPath = "";
	private String sourcePath = "";
	private Project antProject = null;
	private boolean verbose = false;
	
	public void setIsDestructive(boolean isDelete){this.isDestructive = isDelete;}
	public void setBuildTemp(String path){this.buildPath = path;}
	public void setSourcePath(String path){this.sourcePath = path;}
	public void setProject(Project project){this.antProject = project;}
	public void setVerbose(boolean isVerbose){this.verbose = isVerbose;}
	Vector<Task> tasks = new Vector<Task>();
	
	//hook into ant's init method
	public void init() {
		if(this.antProject != null){
			this.antProject.log(this.antProject.getProperty("ant.project.name") + "\n\n", Project.MSG_INFO);
		}
	}
	
	//hook into ant's execute (main method)
	public void execute() {
		String sourcePathKey = this.sourcePath;
		String buildPathKey = this.buildPath;
		
		//get sourcePath property value
		if(this.sourcePath.startsWith("${")){			
			sourcePathKey = this.sourcePath.substring(2, this.sourcePath.length() - 1);
		}
		this.sourcePath = this.antProject.getProperty(sourcePathKey);
		
		//get buildPath property value
		if(this.buildPath.startsWith("${")){
			buildPathKey = this.buildPath.substring(2, this.buildPath.length() - 1);
		}
		this.buildPath = this.antProject.getProperty(buildPathKey);

		PackageContext packageContext = new PackageContext("", "", this.sourcePath, this.buildPath, this.isDestructive);
		
		if(this.verbose) {
			this.antProject.log("*****  PackageContext ******", Project.MSG_INFO);
			this.antProject.log(packageContext.toString(), Project.MSG_INFO);
			this.antProject.log("\n\n");
		}
		
		//iterate over commands
		for(Iterator<Task> i=this.tasks.iterator(); i.hasNext();){
			Task t = i.next();
			
			//execute commands
			t.getCommand().init(packageContext);
			
			t.getCommand().validate();
			
			t.getCommand().execute();
		}		
	}
	
	//factory to create Commands based on build xml
	public Task createTask() {
		Task t = new Task();
		this.tasks.add(t);
		return t;
	}
}
