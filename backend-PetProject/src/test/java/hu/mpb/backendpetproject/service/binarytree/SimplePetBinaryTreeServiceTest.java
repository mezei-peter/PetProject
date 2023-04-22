package hu.mpb.backendpetproject.service.binarytree;

import hu.mpb.backendpetproject.model.PetNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimplePetBinaryTreeServiceTest {
    private SimplePetBinaryTreeService service = new SimplePetBinaryTreeService();

    @Test
    void testAddTenNodes() {
        PetNode root = new PetNode("root", 1000);

        service.addNodeToRoot(root, 1, "exp1");
        service.addNodeToRoot(root, 2, "exp2");
        service.addNodeToRoot(root, 3, "exp3");
        service.addNodeToRoot(root, 4, "exp4");
        service.addNodeToRoot(root, 5, "exp5");
        service.addNodeToRoot(root, 6, "exp6");
        service.addNodeToRoot(root, 7, "exp7");
        service.addNodeToRoot(root, 8, "exp8");
        service.addNodeToRoot(root, 9, "exp9");
        service.addNodeToRoot(root, 10, "exp10");

        PetNode result1 = root.getLeftChild();
        PetNode result2 = root.getRightChild();
        PetNode result3 = root.getLeftChild().getLeftChild();
        PetNode result4 = root.getLeftChild().getRightChild();
        PetNode result5 = root.getRightChild().getLeftChild();
        PetNode result6 = root.getRightChild().getRightChild();
        PetNode result7 = root.getLeftChild().getLeftChild().getLeftChild();
        PetNode result8 = root.getLeftChild().getLeftChild().getRightChild();
        PetNode result9 = root.getLeftChild().getRightChild().getLeftChild();
        PetNode result10 = root.getLeftChild().getRightChild().getRightChild();

        assertAll(
                () -> assertEquals(1, result1.getWeight()),
                () -> assertEquals("exp1", result1.getName()),
                () -> assertEquals(2, result2.getWeight()),
                () -> assertEquals("exp2", result2.getName()),
                () -> assertEquals(3, result3.getWeight()),
                () -> assertEquals("exp3", result3.getName()),
                () -> assertEquals(4, result4.getWeight()),
                () -> assertEquals("exp4", result4.getName()),
                () -> assertEquals(5, result5.getWeight()),
                () -> assertEquals("exp5", result5.getName()),
                () -> assertEquals(6, result6.getWeight()),
                () -> assertEquals("exp6", result6.getName()),
                () -> assertEquals(7, result7.getWeight()),
                () -> assertEquals("exp7", result7.getName()),
                () -> assertEquals(8, result8.getWeight()),
                () -> assertEquals("exp8", result8.getName()),
                () -> assertEquals(9, result9.getWeight()),
                () -> assertEquals("exp9", result9.getName()),
                () -> assertEquals(10, result10.getWeight()),
                () -> assertEquals("exp10", result10.getName())
        );
    }
}