package com.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: LQL
 * @Date: 2025/01/02
 * @Description:
 */
public class TreeBuilder {

    public static List<TreeNode> builderTree(List<TreeNode> nodes){
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        List<TreeNode> rootNodes = new ArrayList<>();

        // 将所有节点放入 Map 中，方便快速查找
        for (TreeNode node : nodes) {
            nodeMap.put(node.getId(), node);
        }

        // 遍历所有节点，构建树形结构
        for (TreeNode node : nodes) {
            if (node.getParentId() == null) {
                // 如果没有 parentId，则是根节点
                rootNodes.add(node);
            } else {
                // 否则找到父节点，将当前节点加入其子节点列表
                TreeNode parent = nodeMap.get(node.getParentId());
                if (parent != null) {
                    parent.getChildren().add(node);
                }
            }
        }
        return rootNodes;
    }

}
