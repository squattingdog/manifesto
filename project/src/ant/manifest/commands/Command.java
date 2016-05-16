package ant.manifest.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ant.manifest.contexts.PackageContext;

public abstract class Command {
	private Map<String, String> arguments = new HashMap<String, String>();
	private PackageContext packageContext = null;
	private String cmdType;
	protected boolean failBuild = false;

	public Map<String, String> getArguments() {return this.arguments;}
	public PackageContext getContext() {return this.packageContext;}
	public String getType(){return this.cmdType;}
	public void setType(String t){this.cmdType=t;}
	protected List<String> requiredParamKeys = new ArrayList<String>();
	
	public void init(PackageContext context){
		this.packageContext = context;
	}
	public abstract String validate();
	public abstract String execute();
}
