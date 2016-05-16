package ant.manifest;

import org.apache.tools.ant.BuildException;

import ant.manifest.commandFactory.CommandFactory;
import ant.manifest.commands.Command;
import ant.manifest.contexts.PackageContext;

//container class to get command specific config values.
public class Task {
	private String commandType;
	private Command command;
	private PackageContext packageContext;

	public void setCommandType(String cmdType){
		this.commandType = cmdType; 
		this.loadCommand();
	}
	
	public String getCommandType(){return this.commandType;}
	public Command getCommand(){return this.command;}
	
	public Task(){ }
	
	private void loadCommand() {
		Command cmd = CommandFactory.instance().getCommand(this.getCommandType());
		if(cmd==null){
			throw new BuildException("SF Build Task: invalid command type");
		}
		this.command = cmd;		
	}
}
