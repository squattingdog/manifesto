manifest.sf.ant

Sample target:
```xml
	<target name="testBuild">
		<sfBuild isDestructive="false" buildTemp="${build.temp}" sourcePath="${build.src}" verbose="true" >
			<task commandType="buildManifest" />
		</sfBuild>
	</target>
```
