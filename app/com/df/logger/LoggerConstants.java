package com.df.logger;

public class LoggerConstants {

	/**
	 * Logger Names
	 */
	public final static String DF = "DockerFramework";
	
	
	public final static String LOGGERCOLON = ":";
	public final static String LOGGERSPACE = " ";
	public final static String LOGGERCOMMA = ",";
	
	
	/**
	 * Entry & Exit String constants
	 */
	public final static String METHODENTRY = "Entered into method";
	public final static String METHODEXIT = "Exit from method";
	public final static String RETURNOBJ = "Retruned is { } :";
	public final static String INPUTPARAMS = "Input parameters are";
	public final static String SAVEMESSAGE = "Data saved successfully";
	
	/**
	 * Clone String constants
	 */
	public final static String CLONERETURNED = "Cloned returned { }";
	public final static String ABSTRACTGRAPHCLONEENTRY = "Entered into AbstractGraphObject Clone";
	public final static String abstractGraphCloneExit = "Exit from AbstractGraphObject Clone";
	public final static String COORDINATECLONEENTRY = "Entered into Coordinate Clone";
	public final static String COORDIANTECLONEEXIT = "Exit from Coordinate Clone";
	public final static String DEMANDCLONEENTRY = "Entered into Demand Clone";
	public final static String DEMANDCLONEEXIT = "Exit from Demand Clone";
	
	/*
	 * Info Statements 
	 * 
	 */
	
	public final static String MONGODBINTILIZATION = "Morphia Object Intilizing";
	public final static String MONGODBINTILIZATIONERROR = "Morphia Database Exceptions are..";
	public final static String MONGODBCREATED = "Databse created";
	public final static String GSONBUILDERINTILIZATION = "GSON Builder Intilised";
	public final static String GLOBALCLASSINTILIZATION = "Global class Intilised...";
	public final static String TESTDATAINSERT = "Inserting Testing Data";
	public final static String USERTESTDATAINSERTING = "Users Test data Inserted";
	public final static String PENDINGTESTDATAINSERTING = "Pending Request test data Inserted";
	public final static String ADMINLOGINANDRENDER = "Logged in as Admin & rendered to AdminDashboard";
	public final static String ADMINLOGINFAILED = "Trying to login as admin but redirected to Login page due Invalid Credentails";
	public final static String AUTHENTICATED = "Session Authenticated & Admin credentials Authenticated";
	public final static String ADMINAUTHENTICATED = "Admin Authenticated Successfully";
	public final static String SESSIONCREATED = "Session Established Successfully";
	public final static String RENDERTOPENDINGREQUEST = "Rendering into Pending Request";
	public final static String RETURNPENDINGREQUEST = "Returning Pending request data to view";
	public final static String JSONDATAINVALID = "Invalid JSON";
	public final static String JSONDATAITERATING = "Iterating JSON Data";
	public final static String ACCEPTEDUSER = "Admin Accepted Requested User";
	public final static String DENYUSER = "Admin Deny User";
	/*
	 * DockerConstants
	 */
    public final static String DOCKERLOGGER="Docker";	
    public final static String NULLOUTPUT="output is null";
    public final static String CREATECONTAINER="Entered into createContainer method";
    public final static String LISTCONTAINER="Entered into listContainer method";
    public final static String LISTIMAGE="Entered into listImage method";
    public final static String REMOVEIMAGE="Entered into removeImage method";
    public final static String INSPECTIMAGE="Entered into inspectImage method";
    public final static String CONTAINERDIFFCMD="Entered into containerDiffCmd method";
    public final static String COPYFILEFROMCONTAINER="Entered into copyFileFromContainer method";
    public final static String DOCKERVERSION="Entered into dockerVersion method";
    public final static String PAUSECONTAINER="Entered into pauseContainer method";
    public final static String WAITCONTAINER="Entered into waitContainer method";
    public final static String REMOVECONTAINER="Entered into removeContainer method";
    public final static String UNPAUSECONTAINER="Entered into unpauseContainer method";
    public final static String STARTCONTAINER="Entered into startContainer method";
    public final static String STOPCONTAINER="Entered into stopContainer method";
    public final static String INSPECTCONTAINER="Entered into inspectContainer method";
    public final static String KILLCONTAINER="Entered into killContainer method";
    public final static String TOPCONTAINER="Entered into topContainer method";
    public final static String ATTACHCONTAINER="Entered into attachContainer method";
    public final static String RESTARTCONTAINER="Entered into restartContainer method";
    public final static String INFOCOMMAND="Entered into infoCommand method";
    public final static String PINGDOCKERSERVER="Entered into pingDockerServer Method";
    public final static String KILLEDCONTAINER="container is killed";
    public final static String PAUSEDCONTAINER="container is paused";
    public final static String INSPECTEDIMAGE="image is inspected";
    public final static String LISTEDCONTAINER="got the list of container";
    public final static String REMOVEDIMAGE="image is removed";
    public final static String RESTARTEDCONTAINER="container is restarted";
    public final static String UNPAUSEDCONTAINER="container is unpaused";
    public final static String WAITEDCONTAINER="container is waiting";
    public final static String REMOVEDCONTAINER="container is removed";
    public final static String INSPECTEDCONTAINER="container is inspected";
    public final static String TOPPEDCONTAINER="got the list of process running inside the container";
    public final static String ATTACHEDCONTAINER="container is attached";
    public final static String LISTEDIMAGE="got the list of image";
    public final static String STOPPEDCONTAINER="container is stopped";
    public final static String STARTEDCONTAINER="container is started";
    public final static String CREATEDCONTAINER="container is created";
    public final static String COPIEDFILEFROMCONTAINER="file is copied from container";
    public final static String PINGEDDOCKERSERVER="docker server is pinged";
    public final static String INVALIDPARAMETER="parameter is invalid";
    public final static String DOCKEREXCEPTION="Exception comes through docker";
    public final static String EXCEPTION="General Exception";
    public final static String ATTACHCONTAINERRESPONSE=" get response of attach container command";
    public final static String CREATECONTAINERRESPONSE=" get response of create container command";
    public final static String JSONMAPCREATECONTAINERRESPONSE=" map json to CreateContainerResponse class";  
    public final static String  NOCONTENTEXCEPTION="no content in result for mapping";
    public final static String INSPECTCONTAINERRESPONSE=" get response of inspectcontainer command";
    public final static String JSONMAPINSPECTCONTAINERRESPONSE=" map json to InspectContainerResponse class";
    public final static String KILLCONTAINERRESPONSE=" get response of killcontainer command";
    public final static String STARTCONTAINERRESPONSE="get response of startcontainer command";
    public final static String STOPCONTAINERRESPONSE="get response of stopcontainer command";
    public final static String INVALIDRESULT="result is invalid";
    public final static String SUCCESS="output comes successfully";
    public final static String NEEDUNPAUSECONTAINER="need to unpause the container";
    public final static String NEEDRESTARTCONTAINER="need to restart the container";
    public final static String ALREADYUNPAUSECONTAINER="container is already unpause";  
    public static final String SUCCESSFULLSTATUS="200";         
    public static final String SERVERERRORSTATUS="500";
    public static final String RESOURCE="Data.txt";
}
