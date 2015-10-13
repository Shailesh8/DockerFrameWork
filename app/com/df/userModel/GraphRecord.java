package com.df.userModel;

import play.Logger;

import com.df.solid.model.exception.ExceptionStrings;
import com.df.solid.model.exception.IDNotSpecifiedException;
import com.df.solid.model.exception.NameNotSpecifiedException;
import com.df.utils.LoggerConstants;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;


@Entity
public class GraphRecord implements Cloneable{

	@Id
	private String id;
	private String name;

	public GraphRecord() {
    
	}

	public GraphRecord(String id, String name) throws IDNotSpecifiedException,
			NameNotSpecifiedException {
		super();
		setId(id);
		setName(name);
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) throws IDNotSpecifiedException {
		if (id == null || id.isEmpty()){
			throw new IDNotSpecifiedException(ExceptionStrings.graphRecordIDNull);
		}
			this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) throws NameNotSpecifiedException {
		if (name == null || name.isEmpty()){
			throw new NameNotSpecifiedException(
					ExceptionStrings.graphRecordNameNull);
		}
			this.name = name;

	}
	
	public void save(GraphRecord graphTableObj){
		Logger.of(LoggerConstants.OTNlogger).debug(LoggerConstants.methodEntry);
		Logger.of(LoggerConstants.OTNlogger).debug(LoggerConstants.inputParams+LoggerConstants.loggerSpace+LoggerConstants.loggerColon+LoggerConstants.loggerSpace+graphTableObj);
		MorphiaObject.datastore.save(graphTableObj);
		Logger.of(LoggerConstants.OTNlogger).debug(LoggerConstants.saveMessage);
		Logger.of(LoggerConstants.OTNlogger).debug(LoggerConstants.methodExit);
	}
	
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}

	public static GraphRecord findGraphRecordById(String id){
    	return  MorphiaObject.datastore.find(GraphRecord.class,"_id ==",id).get();
   	}
	
	public GraphRecord getGraphRecord(String Id) throws IDNotSpecifiedException {

		GraphRecord graphRecordObj = null;
		if (Id == null || Id.isEmpty()) {
			Logger.of("ODE").trace(this.getClass() + " Get - Id is null");
		throw new IDNotSpecifiedException(ExceptionStrings.iDNull);
			
		}
		
		
		graphRecordObj = MorphiaObject.datastore.get(this.getClass(), Id);
		//Cache.set(Id, graphRecordObj);

		return graphRecordObj;
	}
}
