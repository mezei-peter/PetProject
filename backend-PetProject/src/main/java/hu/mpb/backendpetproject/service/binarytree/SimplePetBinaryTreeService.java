package hu.mpb.backendpetproject.service.binarytree;

import hu.mpb.backendpetproject.model.generic.Pair;
import hu.mpb.backendpetproject.model.pettree.ChildDirection;
import hu.mpb.backendpetproject.model.pettree.PetBinaryTree;
import hu.mpb.backendpetproject.model.pettree.PetNode;

import java.util.*;

public class SimplePetBinaryTreeService implements PetBinaryTreeService {
    @Override
    public void addNodeToRoot(PetNode root, int weight, String name) {
        addNodeToRoot(root, weight, name, new LinkedList<>());
    }

    @Override
    public Set<PetNode> convertToSet(PetNode root) {
        Set<PetNode> result = new HashSet<>();
        putSubTreeIntoSetDfs(root, result);
        return result;
    }

    @Override
    public void deleteNode(PetNode petNode, PetBinaryTree tree) {
        //TODO: root, but has children!
        if (petNode == tree.getRoot() && !petNode.hasAnyChild()) {
            tree.emptyRoot();
            return;
        }
        try {
            while (petNode.hasAnyChild()) {
                Pair<PetNode, ChildDirection> parentData = findParentData(petNode, tree);
                PetNode parent = parentData.getFirst();
                ChildDirection direction = parentData.getSecond();
                if (petNode.hasLeftChild()) {
                    swapNodeWithChild(ChildDirection.LEFT, petNode, parent, direction);
                } else {
                    swapNodeWithChild(ChildDirection.RIGHT, petNode, parent, direction);
                }
            }
            Pair<PetNode, ChildDirection> newParentData = findParentData(petNode, tree);
            PetNode newParent = newParentData.getFirst();
            ChildDirection newDirection = newParentData.getSecond();
            newParent.removeChild(newDirection);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private void swapNodeWithChild(ChildDirection childDirection, PetNode petNode, PetNode parent,
                                   ChildDirection directionFromParent) {
        PetNode child = switch (childDirection) {
            case LEFT -> petNode.getLeftChild();
            case RIGHT -> petNode.getRightChild();
        };
        Pair<PetNode, PetNode> childChildren = child.getLeftAndRightChild();

        switch (directionFromParent) {
            case LEFT -> parent.setLeftChild(child);
            case RIGHT -> parent.setRightChild(child);
        }
        switch (childDirection) {
            case LEFT -> {
                child.setLeftChild(petNode);
                child.setRightChild(petNode.getRightChild());
            }
            case RIGHT -> {
                child.setLeftChild(petNode.getLeftChild());
                child.setRightChild(petNode);
            }
        }
        petNode.setLeftAndRightChild(childChildren.getFirst(), childChildren.getSecond());
    }

    private Pair<PetNode, ChildDirection> findParentData(PetNode petNode, PetBinaryTree tree) throws Exception {
        UUID uuid = petNode.getUuid();
        PetNode root = tree.getRoot();
        PetNode parent = findParentNodeInSubTree(root, petNode);
        if (parent == null) {
            throw new Exception("Parent not found for node " + uuid);
        }
        if (parent.hasLeftChild(petNode.getUuid())) {
            return new Pair<>(parent, ChildDirection.LEFT);
        } else {
            return new Pair<>(parent, ChildDirection.RIGHT);
        }
    }

    private PetNode findParentNodeInSubTree(PetNode subTreeRoot, PetNode petNode) {
        if (subTreeRoot.hasLeftChild(petNode.getUuid()) || subTreeRoot.hasRightChild(petNode.getUuid())) {
            return subTreeRoot;
        }
        if (subTreeRoot.hasLeftChild()) {
            PetNode leftResult = findParentNodeInSubTree(subTreeRoot.getLeftChild(), petNode);
            if (leftResult != null) {
                return leftResult;
            }
        }
        if (subTreeRoot.hasRightChild()) {
            PetNode rightResult = findParentNodeInSubTree(subTreeRoot.getRightChild(), petNode);
            if (rightResult != null) {
                return rightResult;
            }
        }
        return null;
    }

    @Override
    public PetNode findNodeInSubTree(PetNode subTreeRoot, UUID uuid) {
        if (subTreeRoot.hasUUID(uuid)) {
            return subTreeRoot;
        }
        if (subTreeRoot.hasLeftChild()) {
            PetNode leftResult = findNodeInSubTree(subTreeRoot.getLeftChild(), uuid);
            if (leftResult != null) {
                return leftResult;
            }
        }
        if (subTreeRoot.hasRightChild()) {
            PetNode rightResult = findNodeInSubTree(subTreeRoot.getRightChild(), uuid);
            if (rightResult != null) {
                return rightResult;
            }
        }
        return null;
    }

    private void putSubTreeIntoSetDfs(PetNode subRoot, Set<PetNode> set) {
        set.add(subRoot);
        if (subRoot.hasLeftChild()) {
            putSubTreeIntoSetDfs(subRoot.getLeftChild(), set);
        }
        if (subRoot.hasRightChild()) {
            putSubTreeIntoSetDfs(subRoot.getRightChild(), set);
        }
    }


    private void addNodeToRoot(PetNode root, int weight, String name, Queue<PetNode> nodeQueue) {
        do {
            PetNode node = nodeQueue.size() == 0 ? root : nodeQueue.poll();
            PetNode left = node.getLeftChild();
            PetNode right = node.getRightChild();

            if (left == null) {
                node.setLeftChild(new PetNode(name, weight));
                return;
            }
            if (right == null) {
                node.setRightChild(new PetNode(name, weight));
                return;
            }
            nodeQueue.add(node.getLeftChild());
            nodeQueue.add(node.getRightChild());
        } while (nodeQueue.size() > 0);
    }
}
