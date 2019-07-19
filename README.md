Demonstrates a bug in the lombok 1.18.8 + java 11 + maven combination.

# How to Reproduce
## 1. ensure you are on java 11
```bash
javac -version
java -version
```
must both indicate java 11

## 2. observe the NPE

Run

```bash
mvn clean compile
```

or

```bash
mvn -X clean compile
```

and observe the following output

```
ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.1:compile (default-compile) on project a: Fatal error compiling: java.lang.NullPointerException -> [Help 1]
```

or more precisely

```
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.275 s
[INFO] Finished at: 2019-07-19T14:02:12+02:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.1:compile (default-compile) on project a: Fatal error compiling: java.lang.NullPointerException -> [Help 1]
org.apache.maven.lifecycle.LifecycleExecutionException: Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.1:compile (default-compile) on project a:
Fatal error compiling
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:215)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:156)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:148)
    at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject (LifecycleModuleBuilder.java:117)
    at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject (LifecycleModuleBuilder.java:81)
    at org.apache.maven.lifecycle.internal.builder.singlethreaded.SingleThreadedBuilder.build (SingleThreadedBuilder.java:56)
    at org.apache.maven.lifecycle.internal.LifecycleStarter.execute (LifecycleStarter.java:128)
    at org.apache.maven.DefaultMaven.doExecute (DefaultMaven.java:305)
    at org.apache.maven.DefaultMaven.doExecute (DefaultMaven.java:192)
    at org.apache.maven.DefaultMaven.execute (DefaultMaven.java:105)
    at org.apache.maven.cli.MavenCli.execute (MavenCli.java:956)
    at org.apache.maven.cli.MavenCli.doMain (MavenCli.java:288)
    at org.apache.maven.cli.MavenCli.main (MavenCli.java:192)
    at jdk.internal.reflect.NativeMethodAccessorImpl.invoke0 (Native Method)
    at jdk.internal.reflect.NativeMethodAccessorImpl.invoke (NativeMethodAccessorImpl.java:62)
    at jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke (DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke (Method.java:566)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced (Launcher.java:289)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launch (Launcher.java:229)
    at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode (Launcher.java:415)
    at org.codehaus.plexus.classworlds.launcher.Launcher.main (Launcher.java:356)
Caused by: org.apache.maven.plugin.MojoExecutionException: Fatal error compiling
    at org.apache.maven.plugin.compiler.AbstractCompilerMojo.execute (AbstractCompilerMojo.java:796)
    at org.apache.maven.plugin.compiler.CompilerMojo.execute (CompilerMojo.java:129)
    at org.apache.maven.plugin.DefaultBuildPluginManager.executeMojo (DefaultBuildPluginManager.java:137)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:210)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:156)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:148)
    at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject (LifecycleModuleBuilder.java:117)
    at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject (LifecycleModuleBuilder.java:81)
    at org.apache.maven.lifecycle.internal.builder.singlethreaded.SingleThreadedBuilder.build (SingleThreadedBuilder.java:56)
    at org.apache.maven.lifecycle.internal.LifecycleStarter.execute (LifecycleStarter.java:128)
    at org.apache.maven.DefaultMaven.doExecute (DefaultMaven.java:305)
    at org.apache.maven.DefaultMaven.doExecute (DefaultMaven.java:192)
    at org.apache.maven.DefaultMaven.execute (DefaultMaven.java:105)
    at org.apache.maven.cli.MavenCli.execute (MavenCli.java:956)
    at org.apache.maven.cli.MavenCli.doMain (MavenCli.java:288)
    at org.apache.maven.cli.MavenCli.main (MavenCli.java:192)
    at jdk.internal.reflect.NativeMethodAccessorImpl.invoke0 (Native Method)
    at jdk.internal.reflect.NativeMethodAccessorImpl.invoke (NativeMethodAccessorImpl.java:62)
    at jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke (DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke (Method.java:566)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced (Launcher.java:289)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launch (Launcher.java:229)
    at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode (Launcher.java:415)
    at org.codehaus.plexus.classworlds.launcher.Launcher.main (Launcher.java:356)
Caused by: org.codehaus.plexus.compiler.CompilerException: java.lang.NullPointerException
    at org.codehaus.plexus.compiler.javac.JavaxToolsCompiler.compileInProcess (JavaxToolsCompiler.java:191)
    at org.codehaus.plexus.compiler.javac.JavacCompiler.performCompile (JavacCompiler.java:169)
    at org.apache.maven.plugin.compiler.AbstractCompilerMojo.execute (AbstractCompilerMojo.java:785)
    at org.apache.maven.plugin.compiler.CompilerMojo.execute (CompilerMojo.java:129)
    at org.apache.maven.plugin.DefaultBuildPluginManager.executeMojo (DefaultBuildPluginManager.java:137)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:210)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:156)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:148)
    at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject (LifecycleModuleBuilder.java:117)
    at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject (LifecycleModuleBuilder.java:81)
    at org.apache.maven.lifecycle.internal.builder.singlethreaded.SingleThreadedBuilder.build (SingleThreadedBuilder.java:56)
    at org.apache.maven.lifecycle.internal.LifecycleStarter.execute (LifecycleStarter.java:128)
    at org.apache.maven.DefaultMaven.doExecute (DefaultMaven.java:305)
    at org.apache.maven.DefaultMaven.doExecute (DefaultMaven.java:192)
    at org.apache.maven.DefaultMaven.execute (DefaultMaven.java:105)
    at org.apache.maven.cli.MavenCli.execute (MavenCli.java:956)
    at org.apache.maven.cli.MavenCli.doMain (MavenCli.java:288)
    at org.apache.maven.cli.MavenCli.main (MavenCli.java:192)
    at jdk.internal.reflect.NativeMethodAccessorImpl.invoke0 (Native Method)
    at jdk.internal.reflect.NativeMethodAccessorImpl.invoke (NativeMethodAccessorImpl.java:62)
    at jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke (DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke (Method.java:566)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced (Launcher.java:289)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launch (Launcher.java:229)
    at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode (Launcher.java:415)
    at org.codehaus.plexus.classworlds.launcher.Launcher.main (Launcher.java:356)
Caused by: java.lang.RuntimeException: java.lang.NullPointerException
    at com.sun.tools.javac.api.JavacTaskImpl.handleExceptions (JavacTaskImpl.java:163)
    at com.sun.tools.javac.api.JavacTaskImpl.doCall (JavacTaskImpl.java:100)
    at com.sun.tools.javac.api.JavacTaskImpl.call (JavacTaskImpl.java:94)
    at org.codehaus.plexus.compiler.javac.JavaxToolsCompiler.compileInProcess (JavaxToolsCompiler.java:126)
    at org.codehaus.plexus.compiler.javac.JavacCompiler.performCompile (JavacCompiler.java:169)
    at org.apache.maven.plugin.compiler.AbstractCompilerMojo.execute (AbstractCompilerMojo.java:785)
    at org.apache.maven.plugin.compiler.CompilerMojo.execute (CompilerMojo.java:129)
    at org.apache.maven.plugin.DefaultBuildPluginManager.executeMojo (DefaultBuildPluginManager.java:137)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:210)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:156)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:148)
    at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject (LifecycleModuleBuilder.java:117)
    at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject (LifecycleModuleBuilder.java:81)
    at org.apache.maven.lifecycle.internal.builder.singlethreaded.SingleThreadedBuilder.build (SingleThreadedBuilder.java:56)
    at org.apache.maven.lifecycle.internal.LifecycleStarter.execute (LifecycleStarter.java:128)
    at org.apache.maven.DefaultMaven.doExecute (DefaultMaven.java:305)
    at org.apache.maven.DefaultMaven.doExecute (DefaultMaven.java:192)
    at org.apache.maven.DefaultMaven.execute (DefaultMaven.java:105)
    at org.apache.maven.cli.MavenCli.execute (MavenCli.java:956)
    at org.apache.maven.cli.MavenCli.doMain (MavenCli.java:288)
    at org.apache.maven.cli.MavenCli.main (MavenCli.java:192)
    at jdk.internal.reflect.NativeMethodAccessorImpl.invoke0 (Native Method)
    at jdk.internal.reflect.NativeMethodAccessorImpl.invoke (NativeMethodAccessorImpl.java:62)
    at jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke (DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke (Method.java:566)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced (Launcher.java:289)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launch (Launcher.java:229)
    at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode (Launcher.java:415)
    at org.codehaus.plexus.classworlds.launcher.Launcher.main (Launcher.java:356)
Caused by: java.lang.NullPointerException
    at com.sun.tools.javac.tree.TreeInfo.declarationFor (TreeInfo.java:688)
    at com.sun.tools.javac.model.JavacElements.getTreeAndTopLevel (JavacElements.java:713)
    at com.sun.tools.javac.model.JavacElements.getTreeAndTopLevel (JavacElements.java:733)
    at com.sun.tools.javac.api.JavacTrees.getPath (JavacTrees.java:382)
    at com.sun.tools.javac.api.JavacTrees.getPath (JavacTrees.java:372)
    at lombok.javac.apt.LombokProcessor.toUnit (LombokProcessor.java:392)
    at lombok.javac.apt.LombokProcessor.process (LombokProcessor.java:308)
    at lombok.core.AnnotationProcessor$JavacDescriptor.process (AnnotationProcessor.java:151)
    at lombok.core.AnnotationProcessor.process (AnnotationProcessor.java:201)
    at lombok.launch.AnnotationProcessorHider$AnnotationProcessor.process (AnnotationProcessor.java:99)
    at com.sun.tools.javac.processing.JavacProcessingEnvironment.callProcessor (JavacProcessingEnvironment.java:972)
    at com.sun.tools.javac.processing.JavacProcessingEnvironment.discoverAndRunProcs (JavacProcessingEnvironment.java:888)
    at com.sun.tools.javac.processing.JavacProcessingEnvironment$Round.run (JavacProcessingEnvironment.java:1214)
    at com.sun.tools.javac.processing.JavacProcessingEnvironment.doProcessing (JavacProcessingEnvironment.java:1326)
    at com.sun.tools.javac.main.JavaCompiler.processAnnotations (JavaCompiler.java:1258)
    at com.sun.tools.javac.main.JavaCompiler.compile (JavaCompiler.java:936)
    at com.sun.tools.javac.api.JavacTaskImpl.lambda$doCall$0 (JavacTaskImpl.java:104)
    at com.sun.tools.javac.api.JavacTaskImpl.handleExceptions (JavacTaskImpl.java:147)
    at com.sun.tools.javac.api.JavacTaskImpl.doCall (JavacTaskImpl.java:100)
    at com.sun.tools.javac.api.JavacTaskImpl.call (JavacTaskImpl.java:94)
    at org.codehaus.plexus.compiler.javac.JavaxToolsCompiler.compileInProcess (JavaxToolsCompiler.java:126)
    at org.codehaus.plexus.compiler.javac.JavacCompiler.performCompile (JavacCompiler.java:169)
    at org.apache.maven.plugin.compiler.AbstractCompilerMojo.execute (AbstractCompilerMojo.java:785)
    at org.apache.maven.plugin.compiler.CompilerMojo.execute (CompilerMojo.java:129)
    at org.apache.maven.plugin.DefaultBuildPluginManager.executeMojo (DefaultBuildPluginManager.java:137)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:210)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:156)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:148)
    at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject (LifecycleModuleBuilder.java:117)
    at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject (LifecycleModuleBuilder.java:81)
    at org.apache.maven.lifecycle.internal.builder.singlethreaded.SingleThreadedBuilder.build (SingleThreadedBuilder.java:56)
    at org.apache.maven.lifecycle.internal.LifecycleStarter.execute (LifecycleStarter.java:128)
    at org.apache.maven.DefaultMaven.doExecute (DefaultMaven.java:305)
    at org.apache.maven.DefaultMaven.doExecute (DefaultMaven.java:192)
    at org.apache.maven.DefaultMaven.execute (DefaultMaven.java:105)
    at org.apache.maven.cli.MavenCli.execute (MavenCli.java:956)
    at org.apache.maven.cli.MavenCli.doMain (MavenCli.java:288)
    at org.apache.maven.cli.MavenCli.main (MavenCli.java:192)
    at jdk.internal.reflect.NativeMethodAccessorImpl.invoke0 (Native Method)
    at jdk.internal.reflect.NativeMethodAccessorImpl.invoke (NativeMethodAccessorImpl.java:62)
    at jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke (DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke (Method.java:566)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced (Launcher.java:289)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launch (Launcher.java:229)
    at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode (Launcher.java:415)
    at org.codehaus.plexus.classworlds.launcher.Launcher.main (Launcher.java:356)
[ERROR]
[ERROR]
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoExecutionException
```

# Cause
The cause is the package-info.java file without a "package" statement - an easy mistake to make.

This should not crash the compiler.

In java 8, there is no problem with this: If you make sure that `javac -version` and `java -version` report 1.8, then

```bash
mvn -f pom.java8.xml clean compile
```
works just fine
