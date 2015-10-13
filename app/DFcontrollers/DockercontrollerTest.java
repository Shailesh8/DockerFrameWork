package DFcontrollers;

import static org.junit.Assert.assertEquals;
import static play.test.Helpers.status;
import org.junit.Test;
import play.mvc.Result;

public class DockercontrollerTest {
	
	@Test
	public void testCreateContainer() {
		
	Result result = Dockercontroller.createContainer();
	int status = status(result);
	assertEquals(200, status);
	}

	@Test
	public void  testListImage(){
		Result result = Dockercontroller.listImage();
		assertEquals(200, status(result));	
	}
	@Test
	public void testListContainer(){
		Result result = Dockercontroller.listContainer();
		assertEquals(200, status(result));	
	}
	@Test
	public void testDockerVersion(){
		Result result = Dockercontroller.dockerVersion();
		assertEquals(200, status(result));	
	}
	@Test
	public void testPingDockerServer(){
		Result result =Dockercontroller.pingDockerServer();
		assertEquals(200, status(result));	
		}
	/*	@Test
	public void testWaitContainerStringCase() {
	    String containerId=Dockercontroller.getCreateContainerId();
		Result result = Dockercontroller.waitContainer(containerId);
        assertEquals(200,status(result));
	}
  */  	
	@Test
	public void testWaitContainerNullCase(){
		Result result = Dockercontroller.waitContainer(null);
        assertEquals(401, status(result));
	} 
	
	@Test
	public void testWaitContainerEmptyCase(){
       Result result=Dockercontroller.waitContainer("");
       assertEquals(401, status(result));
    }
	
	@Test
	public void testRemoveContainerStringCase() {
		Result result = Dockercontroller.removeContainer("055bc5d8424d");
        assertEquals(200,status(result));
	}
	

	@Test
	public void testRemoveContainerNullCase(){
		Result result = Dockercontroller.removeContainer(null);
        assertEquals(401, status(result));
	} 
	
	@Test
	public void testremoveContainerEmptyCase(){
       Result result=Dockercontroller.removeContainer("");
       assertEquals(401, status(result));
    }
	
	@Test
	public void testRestartContainerStringCase() {
		Result result = Dockercontroller.restartContainer("044cb28eb739");
        assertEquals(200,status(result));
	}

	@Test
	public void testRestartContainerNullCase(){
		Result result = Dockercontroller.restartContainer(null);
        assertEquals(401, status(result));
	} 
	@Test
	public void testRestartContainerEmptyCase(){
       Result result=Dockercontroller.restartContainer("");
       assertEquals(401, status(result));
    }
    
	@Test
	public void testPauseContainerStringCase() {
		Result result = Dockercontroller.pauseContainer("044cb28eb739");
        assertEquals(200,status(result));
	}

	@Test
	public void testPauseContainerNullCase(){
		Result result = Dockercontroller.pauseContainer(null);
        assertEquals(401, status(result));
	} 
	@Test
	public void testPauseContainerEmptyCase(){
       Result result=Dockercontroller.pauseContainer("");
       assertEquals(401, status(result));
    }
	
	@Test
	public void testUnpauseContainerStringCase() {
		Result result = Dockercontroller.unpauseContainer("044cb28eb739");
        assertEquals(200,status(result));
	}

	@Test
	public void testUnpauseContainerNullCase(){
		Result result = Dockercontroller.unpauseContainer(null);
        assertEquals(401, status(result));
	} 
	@Test
	public void testUnpauseContainerEmptyCase(){
       Result result=Dockercontroller.unpauseContainer("");
       assertEquals(401, status(result));
    }	
    
	@Test
	public void testAttachContainerStringCase() {
		Result result = Dockercontroller.attachContainer("044cb28eb739");
        assertEquals(200,status(result));
	}

	@Test
	public void testAttachContainerNullCase(){
		Result result = Dockercontroller.attachContainer(null);
        assertEquals(401, status(result));
	} 
	@Test
	public void testAttachContainerEmptyCase(){
       Result result=Dockercontroller.attachContainer("");
       assertEquals(401, status(result));
    }
    
	@Test
	public void testContainerDiffCmdStringCase() {
		Result result = Dockercontroller.containerDiffCmd("044cb28eb739");
        assertEquals(200,status(result));
	}

	@Test
	public void testContainerDiffCmdNullCase(){
		Result result = Dockercontroller.containerDiffCmd(null);
        assertEquals(401, status(result));
	} 
	@Test
	public void testContainerDiffCmdEmptyCase(){
       Result result=Dockercontroller.containerDiffCmd("");
       assertEquals(401, status(result));
    }
   	
	@Test
	public void testRemoveImageStringCase() {
		Result result = Dockercontroller.removeImage("4e0eec2500a0");
        assertEquals(200,status(result));
	}

	@Test
	public void testRemoveImageNullCase(){
		Result result = Dockercontroller.removeImage(null);
        assertEquals(401, status(result));
	} 
	@Test
	public void testRemoveImageEmptyCase(){
       Result result=Dockercontroller.removeImage("");
       assertEquals(401, status(result));
    }
	
	
	
	@Test
	public void testTopContainerStringCase() {
		Result result = Dockercontroller.topContainer("044cb28eb739");
        assertEquals(200,status(result));
	}

	@Test
	public void testTopContainerNullCase(){
		Result result = Dockercontroller.topContainer(null);
        assertEquals(401, status(result));
	} 
	@Test
	public void testTopContainerEmptyCase(){
       Result result=Dockercontroller.topContainer("");
       assertEquals(401, status(result));
    }	
	
	@Test
	public void testStopContainerStringCase() {
		Result result = Dockercontroller.stopContainer("044cb28eb739");
        assertEquals(200,status(result));
	}

	@Test
	public void testStopContainerNullCase(){
		Result result = Dockercontroller.stopContainer(null);
        assertEquals(401, status(result));
	} 
	@Test
	public void testStopContainerEmptyCase(){
       Result result=Dockercontroller.stopContainer("");
       assertEquals(401, status(result));
    }
    
	@Test
    public void testStartContainerStringCase() {
    Result result = Dockercontroller.startContainer("044cb28eb739");
    assertEquals(200, status(result));
    }
	@Test
    public void testStartContainerNullCase() {
    Result result = Dockercontroller.startContainer(null);
    assertEquals(401, status(result));
    }
	@Test
    public void testStartContainerEmptyCase() {
    Result result = Dockercontroller.startContainer("");
    assertEquals(401, status(result));
    }
	@Test
	public void testInspectContainerStringCase() {
     Result result=Dockercontroller.inspectContainer("044cb28eb739");
     assertEquals(200,status(result));
	}
	@Test
    public void testInspectContainerNullCase() {
    Result result = Dockercontroller.inspectContainer(null);
    assertEquals(401, status(result));
    }
	@Test
    public void testInspectContainerEmptyCase() {
    Result result = Dockercontroller.inspectContainer("");
    assertEquals(401, status(result));
    } 
	@Test
	public void testKillContainerStringCase() {
		Result result = Dockercontroller.killContainer("95b591aa4e35");
        assertEquals(200,status(result));
	}
	@Test
	public void testKillContainerNullCase() {
		Result result = Dockercontroller.killContainer(null);
        assertEquals(401,status(result));
	}
	@Test
	public void testKillContainerEmptyCase() {
		Result result = Dockercontroller.killContainer("");
        assertEquals(401,status(result));
	} 
   @Test
   public void testCopyFileFromContainerStringCaseForBothArg(){
	   Result result=Dockercontroller.copyFileFromContainer("044cb28eb739", "Data.txt");
	   assertEquals(200,status(result));
   }
   @Test
   public void testCopyFileFromContainerStringCaseForContainerIdFArg(){
	   Result result=Dockercontroller.copyFileFromContainer("044cb28eb739", null);
	   assertEquals(401,status(result));
   }
   @Test
   public void testCopyFileFromContainerStringCaseForContainerIdSArg(){
	   Result result=Dockercontroller.copyFileFromContainer("044cb28eb739", "");
	   assertEquals(401,status(result));
   }
   @Test
   public void testCopyFileFromContainerStringCaseForResourceFArg(){
	   Result result=Dockercontroller.copyFileFromContainer(null, "Data.txt");
	   assertEquals(401,status(result));
   }
   @Test
   public void testCopyFileFromContainerStringCaseForResourceSArg(){
	   Result result=Dockercontroller.copyFileFromContainer("", "Data.txt");
	   assertEquals(401,status(result));
   }
   @Test
   public void testCopyFileFromContainerNullCaseForBothArg(){
	   Result result=Dockercontroller.copyFileFromContainer(null, null);
	   assertEquals(401,status(result));
   }
   @Test
   public void testCopyFileFromContainerNullCaseForFArgEmptyCaseForSArg(){
	   Result result=Dockercontroller.copyFileFromContainer(null, "");
	   assertEquals(401,status(result));
   }
   @Test
   public void testCopyFileFromContainerEmptyCaseForFArgNullCaseForSArg(){
	   Result result=Dockercontroller.copyFileFromContainer("", null);
	   assertEquals(401,status(result));
   }
   @Test
   public void testCopyFileFromContainerEmptyCaseForBothArg(){
	   Result result=Dockercontroller.copyFileFromContainer("", "");
	   assertEquals(401,status(result));
   }
  
}
