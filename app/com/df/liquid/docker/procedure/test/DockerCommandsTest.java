package com.df.liquid.docker.procedure.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.df.liquid.docker.api.DockerConstants;
import com.df.liquid.docker.procedure.DockerCommands;
import com.df.logger.LoggerConstants;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;



public class DockerCommandsTest {
DockerCommands dockerCommands=new DockerCommands();

@Test
	public void testListContainer() {
		String result = dockerCommands.listContainer();
		assertEquals(LoggerConstants.SUCCESS, result);		
		} 		
	@Test
	public void testInfoCommand(){
		String result =dockerCommands.infoCmd();
		assertEquals(LoggerConstants.SUCCESS, result);
	}
	
	@Test
	public void testPingDockerServer(){
		String  result=dockerCommands.pingDockerServer();
		assertEquals(LoggerConstants.SUCCESSFULLSTATUS, result);
	}

	@Test
	public void testDockerVersion(){
		String result=dockerCommands.dockerVersion();
		assertEquals(LoggerConstants.SUCCESS, result);
		
	}
   @Test
   public void testListImage(){
	   String result=dockerCommands.listImage();
	   assertEquals(LoggerConstants.SUCCESS, result);
   }

 

    @Test
    public void testCreateContainerStringCaseForBothArg(){
    	String result=dockerCommands.createContainer(DockerConstants.dockerImage, DockerConstants.odeServerCommand);
    	assertEquals(LoggerConstants.SUCCESS, result);
    }
    
    @Test
    public void testCreateContainerStringCaseForImageArgNullForCmd(){
    	String result=dockerCommands.createContainer(DockerConstants.dockerImage, null);
    	assertEquals(null, result);
    }
   
    @Test
    public void testCreateContainerStringCaseForImageArgEmptyForCmd(){
    	String result=dockerCommands.createContainer(DockerConstants.dockerImage, "");
    	assertEquals(null, result);
    }
   
    @Test
    public void testCreateContainerNullForImageStringCaseForCmd(){
    	String result=dockerCommands.createContainer(null, DockerConstants.odeServerCommand);
    	assertEquals(null, result);
    }
 
    @Test
    public void testCreateContainerEmptyForImageStringCaseForCmd(){
    	String result=dockerCommands.createContainer("", DockerConstants.odeServerCommand);
    	assertEquals(null, result);
    }
    
    @Test
    public void testCreateContainerNullForImageNullForCmd(){
    	String result=dockerCommands.createContainer(null, null);
    	assertEquals(null, result);
    }
   
    @Test
    public void testCreateContainerEmptyForImageEmptyForCmd(){
    	String result=dockerCommands.createContainer("", "");
    	assertEquals(null, result);
    }

    @Test
    public void testInspectContainerStringCase(){
    	String result=dockerCommands.createContainer(DockerConstants.dockerImage, DockerConstants.odeServerCommand);
    //	JsonNode response=	dockerCommands.getCreateResponse();
    //	String containerId = new Gson().toJson(response);
    	String containerId=dockerCommands.getCreateResponse();
    	String result2=dockerCommands.inspectContainer(containerId);
    	assertEquals(LoggerConstants.SUCCESS, result2);	
    	}

   @Test
   public void testInspectContainerNullCase(){
	   String result= dockerCommands.inspectContainer(null);
	   assertEquals(null,result);
   }
   
   @Test
   public void testInspectContainerEmptyCase(){
	   String result= dockerCommands.inspectContainer("");
	   assertEquals(null,result);
   }
   
    @Test
    public void testTopContainerStringCase(){
	String result=dockerCommands.createContainer(DockerConstants.dockerImage, DockerConstants.odeServerCommand);
 //   JsonNode response=	dockerCommands.getCreateResponse().findPath("Id");
 //   	String containerId = new Gson().toJson(response);
    String containerId=dockerCommands.getCreateResponse();
	String result2=dockerCommands.startContainer(containerId);
    String result3=dockerCommands.topContainer(containerId);
   	assertEquals(LoggerConstants.SUCCESS, result3);
   	
   		
   	}

   @Test
   public void testTopContainerNullCase(){
	String result=dockerCommands.topContainer(null);
   		assertEquals(null, result);
   	} 
  
   @Test
   public void testTopContainerEmptyCase(){
	String result=dockerCommands.topContainer("");
   		assertEquals(null, result);
   	}

   @Test
   public void testContainerDiffCmdStringCase(){
	    String result=dockerCommands.createContainer(DockerConstants.dockerImage, DockerConstants.odeServerCommand);
	  //  JsonNode response=	dockerCommands.getCreateResponse().findPath("Id");
	  // 	String containerId = new Gson().toJson(response);
	   	String containerId=dockerCommands.getCreateResponse();
	   			
	    String result2=dockerCommands.containerDiffCmd(containerId);
	   	assertEquals(LoggerConstants.SUCCESS, result2);
	   	 
   }

   @Test
   public void testContainerDiffCmdNullCase(){
	   String result= dockerCommands.containerDiffCmd(null);
      assertEquals(null,result);
   }

   @Test
   public void testContainerDiffCmdEmptyCase(){
	   String result= dockerCommands.containerDiffCmd("");
      assertEquals(null,result);
   }

   @Test
   public void testStartContainerStringCase(){
	String result=dockerCommands.createContainer(DockerConstants.dockerImage, DockerConstants.odeServerCommand);
    String containerId=dockerCommands.getCreateResponse();
	String result2=dockerCommands.startContainer(containerId);
   	assertEquals("204", result2);	
   	}

   @Test
   public void testStartContainerNullCase(){
	String result=dockerCommands.startContainer(null);
   	assertEquals(null, result);	
   	 }
   
   @Test
   public void testStartContainerEmptyCase(){
	   String result=dockerCommands.startContainer("");
	   	assertEquals(null, result);   
   }

   @Test
   public void testStopContainerStringCase(){
	   String result=dockerCommands.createContainer(DockerConstants.dockerImage, DockerConstants.odeServerCommand);
	   String containerId= dockerCommands.getCreateResponse();	
	   String result2=dockerCommands.stopContainer(containerId);
	   assertEquals("304", result2);	   
   }
   
   @Test
   public void testStopContainerNullCase(){
	   String result=dockerCommands.stopContainer(null);
	   assertEquals(null, result);
   }
   
   @Test
   public  void testStopContainerEmptyCase(){
	   String result=dockerCommands.stopContainer("");
	   assertEquals(null, result);
   }
    
   @Test
   public void testAttachContainerStringCase(){
	   String result=dockerCommands.createContainer(DockerConstants.dockerImage, DockerConstants.odeServerCommand);
	   String containerId=dockerCommands.getCreateResponse();
	   String result2=dockerCommands.attachContainer(containerId);
	   assertEquals(LoggerConstants.SUCCESS, result2);
   }
   
   @Test
   public void testAttachContainerNullCase(){
	   String result=dockerCommands.attachContainer(null);
	   assertEquals(null,result);
   }

   @Test
   public void testAttachContainerEmptyCase(){
	   String result=dockerCommands.attachContainer("");
	   assertEquals(null,result);
   }
  
  @Test
  public void testPauseContainerStringCase(){
	    String result=dockerCommands.createContainer(DockerConstants.dockerImage, DockerConstants.odeServerCommand);
	   	String containerId=dockerCommands.getCreateResponse();
	    String result2=dockerCommands.pauseContainer(containerId);
	   	assertEquals("500", result2);
  }

  @Test
  public void testPauseContainerNullCase(){
	  String result = dockerCommands.pauseContainer(null);
      assertEquals(null,result);  
  }
  
  @Test
  public void testPauseContainerEmptyCase(){
	  String result = dockerCommands.pauseContainer("");
      assertEquals(null,result);  
  }

  @Test
  public void testUnpauseContainerStringCase(){
	  String result=dockerCommands.createContainer(DockerConstants.dockerImage, DockerConstants.odeServerCommand);
	  String containerId=dockerCommands.getCreateResponse(); 	
	  String result2=dockerCommands.unpauseContainer(containerId);
	  assertEquals("500", result2);
  }

  @Test
  public void testUnpauseContainerNullCase(){
	  String result=dockerCommands.unpauseContainer(null);
	  assertEquals(null,result);
  }
  
  @Test
  public void testUnpauseContainerEmptyCase(){
	  String result=dockerCommands.unpauseContainer("");
	  assertEquals(null,result);
  }

  @Test
  public void testRestartContainerStringCase(){
	  String result=dockerCommands.createContainer(DockerConstants.dockerImage, DockerConstants.odeServerCommand);
	  String containerId=dockerCommands.getCreateResponse(); 
	  String result2=dockerCommands.restartContainer(containerId);
	  assertEquals("204", result2); 
  }
  
  @Test
   public void testRestartContainerNullCase(){
	   String result=dockerCommands.restartContainer(null);
	   assertEquals(null,result);
   }
   
  @Test 
  public void testRestartContainerEmptyCase(){
	   String result=dockerCommands.restartContainer("");
       assertEquals(null,result);
   }

    @Test
    public void testWaitContainerStringCase(){
    	String result=dockerCommands.createContainer(DockerConstants
    			.dockerImage, DockerConstants.odeServerCommand);
	   String containerId=dockerCommands.getCreateResponse();
    	String result2=dockerCommands.waitContainer(containerId);
	   	assertEquals("200", result2);
    }

   @Test
   public void testWaitContainerNullCase(){
	   String result=dockerCommands.waitContainer(null);
	   assertEquals(null, result);
   }
   
   @Test
   public void testWaitContainerEmptyCase(){
	   String result=dockerCommands.waitContainer(null);
	   assertEquals(null, result);
   }

   @Test
    public void testRemoveContainerStringCase(){
	   String result=dockerCommands.createContainer(DockerConstants.dockerImage, DockerConstants.odeServerCommand);
	   String containerId=dockerCommands.getCreateResponse();	
	   String result2=dockerCommands.removeContainer(containerId);
	   assertEquals("204", result2);
   }
  
   @Test
   public void testRemoveContainerNullCase(){
	   String result=dockerCommands.removeContainer(null);
	   assertEquals(null,result);
   }

   @Test
   public void testRemoveContainerEmptyCase(){
	   String result=dockerCommands.removeContainer("");
	   assertEquals(null,result);
   }

   @Test
   public void testKillContainerStringCase(){
	    String result=dockerCommands.createContainer(DockerConstants.dockerImage, DockerConstants.odeServerCommand);
	    String containerId=dockerCommands.getCreateResponse();
	    String result2=dockerCommands.killContainer(containerId);
	   	assertEquals("204", result2); 
   }

   @Test
   public void testKillContainerNullCase(){
	   String result=dockerCommands.killContainer(null);
	   assertEquals(null,result);
   }
 
   @Test
   public void testKillContainerEmptyCase(){
	   String result =dockerCommands.killContainer("");
	   assertEquals(null,result);
   }
   
  @Test
  public void testCopyFileFromContainerStringCaseForBothArg(){
	  String result=dockerCommands.createContainer(DockerConstants.dockerImage, DockerConstants.odeServerCommand);
	  String containerId=dockerCommands.getCreateResponse(); 
      String result2=dockerCommands.copyFileFromContainer(containerId,LoggerConstants.RESOURCE);  
      assertEquals(LoggerConstants.SUCCESS,result2); 
  }
   
   @Test
   public void testCopyFileFromContainerStringCaseForContainerIdNullCaseForResource(){ 
	   String result=dockerCommands.createContainer(DockerConstants.dockerImage, DockerConstants.odeServerCommand);
	   String containerId=dockerCommands.getCreateResponse();
	   String result2=dockerCommands.copyFileFromContainer(containerId, null);
	  assertEquals(null,result2); 
   }

    @Test
    public void testCopyFileFromContainerStringCaseForContainerIdEmptyCaseForResource(){
       String result=dockerCommands.createContainer(DockerConstants.dockerImage, DockerConstants.odeServerCommand);
 	   String containerId=dockerCommands.getCreateResponse();
       String result2=dockerCommands.copyFileFromContainer(containerId, ""); 
      assertEquals(null, result2);
    }
   
    @Test
    public void testCopyFileFromContainerNullCaseForContainerIdStringCaseForResource(){
    	String result=dockerCommands.copyFileFromContainer(null,LoggerConstants.RESOURCE);
    	assertEquals(null, result);
    }

    @Test
    public void testCopyFileFromContainerEmptyCaseForContainerIdStringCaseForResource(){
    	String result=dockerCommands.copyFileFromContainer("",LoggerConstants.RESOURCE);
    	assertEquals(null, result);
    }

    @Test
    public void testCopyFileFromContainerNullCaseForBothArg(){
    	String result=dockerCommands.copyFileFromContainer(null,null);
    	assertEquals(null, result);
    }
   
    @Test
    public void testCopyFileFromContainerEmptyCaseForBothArg(){
    	String result=dockerCommands.copyFileFromContainer("","");
    	assertEquals(null, result);
    } 
 
    @Test
    public void testCopyFileFromContainerEmptyCaseForContainerIdNullCaseForResource(){
      String result=dockerCommands.copyFileFromContainer("", null);
      assertEquals(null,result);
    }


   @Test
   public void testCopyFileFromContainerNullCaseForContainerIdEmptyCaseForResource(){
	      String result=dockerCommands.copyFileFromContainer(null, "");
	      assertEquals(null,result);
	    }

   @Test
   public void testRemoveImageStringCase(){
    String result=dockerCommands.listImage();
    String imageId=dockerCommands.getImageId();
    String result2=dockerCommands.removeImage(imageId);
    assertEquals("200", result2);	   
   }

    @Test
    public void testRemoveImageNullCase(){
    	String result=dockerCommands.removeImage(null);
    	assertEquals(null,result);
    }

    @Test
    public void testRemoveImageEmptyCase(){
    	String result=dockerCommands.removeImage("");
    	assertEquals(null,result);
    }

    @Test
    public void testInspectImageStringCase(){
    	String result=dockerCommands.listImage();
        String imageId=dockerCommands.getImageId();
        String result2=dockerCommands.inspectImage(imageId);
        	assertEquals(LoggerConstants.SUCCESS,result2);	
    }

    @Test
    public void testInspectImageNullCase(){
    	String result=dockerCommands.inspectImage(null);
    	assertEquals(null,result);
    }

   @Test
   public void testInspectImageEmptyCase(){
	   String result=dockerCommands.inspectImage("");
      assertEquals(null,result);
   }
   
 
}


