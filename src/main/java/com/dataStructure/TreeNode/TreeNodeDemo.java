package com.dataStructure.TreeNode;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: LQL
 * @Date: 2025/01/02
 * @Description:
 */
public class TreeNodeDemo {

    public static void main(String[] args) {
        // 模拟输入数据
        List<TreeNode> nodes = Arrays.asList(
                new TreeNode(1, null, "Root 1"),
                new TreeNode(2, 1, "Child 1.1"),
                new TreeNode(3, 1, "Child 1.2"),
                new TreeNode(4, 2, "Child 1.1.1"),
                new TreeNode(5, null, "Root 2"),
                new TreeNode(6, 5, "Child 2.1")
        );

        // 构建树
        List<TreeNode> tree = TreeBuilder.builderTree(nodes);

        // 输出树形结构
        System.out.println(tree);
    }

}
