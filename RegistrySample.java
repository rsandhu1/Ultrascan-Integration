// Adding a resource
stampedeResourceId = registerComputeHost("stampede.tacc.xsede.org", "TACC Stampede Cluster",
                    ResourceJobManagerType.SLURM, "push", "/usr/bin", SecurityProtocol.GSI, 2222, "/usr/local/bin/ibrun");
// Setup Module   
ultrascanModuleId = airavataClient.registerApplicationModule(
                    RegisterSampleApplicationsUtils.createApplicationModule(
                    
// Setup Inputs                    
InputDataObjectType input1 = RegisterSampleApplicationsUtils.createAppInput("input", null,
                    DataType.URI, null, false, "input tar file", null);
InputDataObjectType input2 = RegisterSampleApplicationsUtils.createAppInput("walltime", null,
                    DataType.STRING, null, false, "walltime of application", null);
InputDataObjectType input3 = RegisterSampleApplicationsUtils.createAppInput("mgcount", null,
                    DataType.STRING, null, false, "Montecarlo grouping", null);
           
List<InputDataObjectType> applicationInputs = new ArrayList<InputDataObjectType>();
applicationInputs.add(input1);
applicationInputs.add(input2);
applicationInputs.add(input3);

// Setup Outputs
OutputDataObjectType output1 = RegisterSampleApplicationsUtils.createAppOutput("output",
                    "", DataType.URI);

List<OutputDataObjectType> applicationOutputs = new ArrayList<OutputDataObjectType>();
    applicationOutputs.add(output1);

// Register Input/output to application interface
ultrascanAppId = airavataClient.registerApplicationInterface(
                    RegisterSampleApplicationsUtils.createApplicationInterfaceDescription("ultrascan", "ultrascan application",
                            appModules, applicationInputs, applicationOutputs));

// Application location
String ultascanStamplede = airavataClient.registerApplicationDeployment(RegisterSampleApplicationsUtils.createApplicationDeployment(ultrascanModuleId,
					stampedeResourceId, "/home1/01623/us3/bin/us_mpi_analysis", ApplicationParallelismType.MPI, "ultrascan application"));
  
// Register Gateway properties 
ComputeResourcePreference stampedeResourcePreferences = RegisterSampleApplicationsUtils.
                    createComputeResourcePreference(stampedeResourceId, "TG-MCB070039N", false, null, null, null,
GatewayResourceProfile gatewayResourceProfile = new GatewayResourceProfile();
gatewayResourceProfile.setGatewayName("ULTRASCAN");
gatewayResourceProfile.addToComputeResourcePreferences(stampedeResourcePreferences);
                            "/scratch/01623/us3/jobs/");
