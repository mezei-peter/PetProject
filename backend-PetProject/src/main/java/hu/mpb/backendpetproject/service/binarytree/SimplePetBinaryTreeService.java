package hu.mpb.backendpetproject.service.binarytree;

import hu.mpb.backendpetproject.model.PetNode;

import java.util.LinkedList;
import java.util.Queue;

public class SimplePetBinaryTreeService implements PetBinaryTreeService {
    @Override
    public void addNodeToRoot(PetNode root, int weight, String name) {
        addNodeToRoot(root, weight, name, new LinkedList<>());
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
