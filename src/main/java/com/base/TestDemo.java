package com.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.xmlunit.util.Nodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: LQL
 * @Date: 2025/02/11
 * @Description:
 */
public class TestDemo {

    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        Node node1 = new Node("1",null,new ArrayList<>());
        Node node2 = new Node("2","1",new ArrayList<>());
        Node node3 = new Node("3","2",new ArrayList<>());
        Node node4 = new Node("4","1",new ArrayList<>());
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);
        TestDemo testDemo = new TestDemo();
        List<Node> trees = testDemo.mapBuildTree(nodes,null);
        System.out.println(trees.get(0));
    }


    public List<Node> buildTree(List<Node> nodesList,String parentId){
        List<Node> tree = new ArrayList<>();
        for (Node node : nodesList){
            //父节点是否为根节点，为根节点时判断当前节点的父节点是否为根节点，是则存入，
            // 不是根节点时，判断当前节点的父节点是否为parentID，是则存入，否则忽略
            if (parentId == null ? node.getParentId() == null : parentId.equals(node.getParentId())){

                node.setNodes(buildTree(nodesList,node.getId()));
                tree.add(node);
            }
        }
        return tree;
    }

    public List<Node> mapBuildTree(List<Node> nodes,String parentId){
        Map<String,Node> nodeMap = new HashMap<>();
        List<Node> rootNodes = new ArrayList<>();

        for (Node node : nodes){
            nodeMap.put(node.getId(),node);
            node.setNodes(new ArrayList<>());
        }

        for (Node node : nodes){
            if (node.getParentId() == parentId || !nodeMap.containsKey(node.getParentId())){
                rootNodes.add(node);
            }else {
                Node parentNode = nodeMap.get(node.getParentId());
                parentNode.getNodes().add(node);
            }
        }
        return rootNodes;
    }
}

