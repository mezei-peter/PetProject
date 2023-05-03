package hu.mpb.backendpetproject.service.binarytree;

import hu.mpb.backendpetproject.model.PetNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

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
    public void deleteNode(PetNode petNode) {
        //TODO
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
