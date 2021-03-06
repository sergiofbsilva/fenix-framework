package dml.maven;

import java.io.File;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;

/**
 * Generate base main classes from the main DML files
 * 
 * @goal generate-domain
 * @phase generate-sources
 * @requiresDependencyResolution runtime
 * @threadSafe
 */
public class DmlCodeGeneratorMojo extends AbstractDmlCodeGeneratorMojo {

    /**
     * Maven Project
     * 
     * @parameter default-value="${project}"
     */
    private MavenProject mavenProject;

    /**
     * File Source Directory
     * 
     * @parameter default-value="${basedir}/src/main/dml"
     * @readonly
     * @required
     */
    private File dmlSourceDirectory;

    /**
     * File Destination Directory
     * 
     * @parameter default-value="${basedir}/src/main/java"
     * @readonly
     * @required
     */
    private File sourcesDirectory;

    /**
     * Base File Destination Directory
     * 
     * @parameter default-value="${project.build.directory}/generated-sources/dml-maven-plugin"
     * @readonly
     * @required
     */
    private File generatedSourcesDirectory;

    /**
     * Domain Model Class Name
     * 
     * @parameter expression="${generate-domain.domainModelClassName}"
     *            default-value="pt.ist.fenixframework.pstm.dml.FenixDomainModelWithOCC"
     */
    private String domainModelClassName;

    /**
     * Code Generator Class Name
     * 
     * @parameter expression="${generate-domain.codeGeneratorClassName}"
     *            default-value="pt.ist.fenixframework.pstm.dml.FenixCodeGeneratorOneBoxPerObject"
     */
    private String codeGeneratorClassName;

    /**
     * Package name
     * 
     * @parameter expression="${generate-domain.packageName}"
     */
    private String packageName = "";

    /**
     * Generate Finals Flag
     * 
     * @parameter expression="${generate-domain.generateFinals}" default-value="false"
     */
    private boolean generateFinals;

    /**
     * Verbose Mode Flag
     * 
     * @parameter expression="${verbose}" default-value="false"
     */
    private boolean verbose;

    /**
     * Generate Project Properties Flag
     * 
     * @parameter expression="${generate-domain.generateProjectProperties}" default-value="false"
     */
    private boolean generateProjectProperties;

    @Override
    public void execute() throws MojoExecutionException {
        super.execute();
        getMavenProject().addCompileSourceRoot(getGeneratedSourcesDirectory().getAbsolutePath());
    }

    @Override
    protected File getDmlSourceDirectory() {
        return dmlSourceDirectory;
    }

    @Override
    protected String getCodeGeneratorClassName() {
        return codeGeneratorClassName;
    }

    @Override
    protected String getDomainModelClassName() {
        return domainModelClassName;
    }

    @Override
    protected File getGeneratedSourcesDirectory() {
        return generatedSourcesDirectory;
    }

    @Override
    protected File getSourcesDirectory() {
        return sourcesDirectory;
    }

    @Override
    protected String getPackageName() {
        return packageName;
    }

    @Override
    protected boolean verbose() {
        return verbose;
    }

    @Override
    protected boolean generateFinals() {
        return generateFinals;
    }

    @Override
    protected boolean generateProjectProperties() {
        return generateProjectProperties;
    }

    @Override
    protected MavenProject getMavenProject() {
        return mavenProject;
    }

    @Override
    protected String getOutputDirectoryPath() {
        return mavenProject.getBuild().getOutputDirectory();
    }
}
