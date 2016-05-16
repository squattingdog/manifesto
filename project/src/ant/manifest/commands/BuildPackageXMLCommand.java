package ant.manifest.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ant.manifest.contexts.PackageContext;

public class BuildPackageXMLCommand extends Command {
	private PackageContext pkgContext;
	private final String PARAM_TEMPDIR = "tempDir";
	private final String PARAM_VERSION = "version";	
	private final String PARAM_FULL_NAME = "fullName";
	private final String PARAM_API_ACCESS_LEVEL = "apiAccessLevel";
	private final String PARAM_DESCRIPTION = "description";
	private final String PARAM_NAMESPACE_PREFIX = "namespacePrefix";
	private final String PARAM_POST_INSTALL_CLASS = "postInstallClass";	
	private final String PARAM_VERBOSE = "verbose";
	private final String PARAM_BLANK = "blank";
	 
	private final Map<String, String> SalesforceTypeNamesXML = new HashMap<String, String>()
	{{
		put("applications", "CustomApplication");
		put("classes", "ApexClass");
		put("components", "ApexComponent");
		put("labels", "CustomLabels");
		put("layouts", "Layout");
		put("objects", "CustomObject");
		put("pages", "ApexPage");
		put("profiles", "Profile");
		put("staticresources", "StaticResource");
		put("tabs", "CustomTab");
		put("documents", "Document");
		put("permissionsets", "PermissionSet");
		put("connectedApps", "ConnectedApp");
	}};	
	
	private String tempDirectoryPath = "";
    private String getVersion()
    {
        return (this.pkgContext.getArguments().containsKey(PARAM_VERSION) ? this.pkgContext.getArguments().get(PARAM_VERSION) : "31.0");
    }
    private String getFullName()
    {
    	return (this.pkgContext.getArguments().containsKey(PARAM_FULL_NAME) ? this.pkgContext.getArguments().get(PARAM_FULL_NAME) : "");
    }
    private String getApiAccessLevel()
    {
    	return (this.pkgContext.getArguments().containsKey(PARAM_API_ACCESS_LEVEL) ? this.pkgContext.getArguments().get(PARAM_API_ACCESS_LEVEL) : "");
    }
    private String getDescription()
    {
        return (this.pkgContext.getArguments().containsKey(PARAM_DESCRIPTION) ? this.pkgContext.getArguments().get(PARAM_DESCRIPTION) : "");
    }
    private String getNamespacePrefix()
    {
        return (this.pkgContext.getArguments().containsKey(PARAM_NAMESPACE_PREFIX) ? this.pkgContext.getArguments().get(PARAM_NAMESPACE_PREFIX) : "");
    }
    private String getPostInstallClass()
    {
        return (this.pkgContext.getArguments().containsKey(PARAM_POST_INSTALL_CLASS) ? this.pkgContext.getArguments().get(PARAM_POST_INSTALL_CLASS) : "");
    }
    private boolean getVerbose()
    {	
    	boolean r = false;
        if (this.pkgContext.getArguments().containsKey(PARAM_VERBOSE))
        {            
            r = Boolean.parseBoolean(this.pkgContext.getArguments().get(PARAM_VERBOSE));
        }
        return r;
    }
    private boolean getBlank()
    {
        boolean r = false;
        if (this.pkgContext.getArguments().containsKey(PARAM_BLANK))
        {
        	r = Boolean.parseBoolean(this.pkgContext.getArguments().get(PARAM_BLANK));
        }
        return r;
    }

    private List<String> customFieldKeys;
    private List<String> customLabelKeys;
    private List<String> customListViewKeys;
	
	public BuildPackageXMLCommand(){ }
	
	@Override
	public void init(PackageContext context) {
		super.init(context);
		this.requiredParamKeys.add(PARAM_TEMPDIR);
		this.customFieldKeys = new ArrayList<String>();
		this.customLabelKeys = new ArrayList<String>();
		this.customListViewKeys = new ArrayList<String>();
	}

	@Override
	public String validate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String execute() {
		// TODO Auto-generated method stub
		return null;
	}

}
