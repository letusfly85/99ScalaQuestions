resolvers += "Sonatype OSS Snapshots" at
  "https://oss.sonatype.org/content/repositories/releases"

  libraryDependencies += "com.storm-enroute" %% "scalameter" % "0.6"

  testFrameworks += new TestFramework("org.scalameter.ScalaMeterFramework")

  parallelExecution in Test := false
