package ant.manifest.contexts;

import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.*;
import org.apache.tools.ant.BuildException;

public class PackageContext {
	private Map<String, String> arguments = new HashMap<String, String>();
	private String sourceFilePath;
	private String destinationFilePath;
	private String name;
	private String namespace;
	private boolean isDestructive = false;

    public Map<String, String> getArguments(){ return this.arguments; }
    public String getSourceFilePath(){return this.sourceFilePath;}
    public String getDestinationFilePath(){return this.destinationFilePath;}
    public String getName(){return this.name;}
    public String getNamespace(){return this.namespace;}
    public boolean getIsDestructive(){return this.isDestructive;}
	
	public PackageContext(String name, String ns, String filePath, boolean isDestructive){
		this(name, ns, filePath, filePath, isDestructive);
	}
	public PackageContext(String name, String ns, String sourceFilePath, String destinationFilePath, boolean isDestructive){
		this.name = name;
		this.namespace = ns;
		this.sourceFilePath = sourceFilePath;
		this.destinationFilePath = destinationFilePath;
		this.isDestructive = isDestructive;
		
		this.Validate();
	}
	
	private void Validate(){
		String errorMsg = "";
		
		if(!Files.isDirectory(Paths.get(this.sourceFilePath))){
			errorMsg += "\n\tPackageContext - Source directory does not exist.\n\t\t" + this.sourceFilePath + "\n\n";
		}
		
		if(this.sourceFilePath != this.destinationFilePath){
			if(!Files.isDirectory(Paths.get(this.destinationFilePath))){
				errorMsg += "\tPackageContext - Destination directory does not exist.\n\t\t" + this.destinationFilePath + "\n\n";
			}
		}
		
		if(StringUtils.isNotEmpty(errorMsg)){
			throw new BuildException(errorMsg);
		}
	}
	
	public String toString(){
		return "\tName: " + this.name 
			+ "\n\tNameSpace: " + this.namespace 
			+ "\n\tSource: " + this.sourceFilePath 
			+ "\n\tDestination: " + this.destinationFilePath
			+ "\n\tDestructive: " + this.isDestructive;
	}
}
