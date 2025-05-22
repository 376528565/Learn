package com.dataStructure.TreeNode;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LQL
 * @Date: 2025/01/02
 * @Description: 树节点，通过迭代实现父子级关系
 */
@Data
public class TreeNode {

    private Integer id;
    private Integer parentId;
    private String name;
    private List<TreeNode> children = new ArrayList<>();

    public TreeNode(Integer id, Integer parentId, String name) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", children=" + children +
                '}';
    }
}
