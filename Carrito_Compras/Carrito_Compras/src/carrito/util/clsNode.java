package carrito.util;

public class clsNode {
	private Object nodeInfo;
	private clsNode nextNode;

	//Sobrecarga----------
	clsNode(Object nodeInfo){
		this(nodeInfo,null);
	}

	clsNode(Object nodeInfo, clsNode nextNode){
		this.nodeInfo=nodeInfo;
		this.nextNode=nextNode;
	}
	
	//  --------------
	
	void setNodeInfo(Object nodeInfo){
		this.nodeInfo=nodeInfo;
	}
	
	void setNextNode(clsNode nextNode){
		this.nextNode=nextNode;
	}
	
	Object getNodeInfo(){
		return this.nodeInfo;
	}
	
	clsNode getNextNode(){
		return this.nextNode;
	}

}
