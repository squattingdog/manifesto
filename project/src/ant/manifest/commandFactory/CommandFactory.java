package ant.manifest.commandFactory;

import ant.manifest.commands.*;

public class CommandFactory {
	private static CommandFactory commandFactory = new CommandFactory();
	public static CommandFactory instance() { return commandFactory; }
	
	public CommandFactory() { }
	
	public Command getCommand(String commandType) {
		Command cmd = null;
		switch(commandType) {
		case "buildManifest":
			cmd = new BuildPackageXMLCommand();
			break;
		case "retrieve":
			cmd = new BuildRetrievePackageXmlCommand();
		}
		
		return cmd;
	}
}
