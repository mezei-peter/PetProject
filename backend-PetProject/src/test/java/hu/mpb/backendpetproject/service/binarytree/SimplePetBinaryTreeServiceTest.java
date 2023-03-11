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

        PetNode result1 = root.getLeft();
        PetNode result2 = root.getRight();
        PetNode result3 = root.getLeft().getLeft();
        PetNode result4 = root.getLeft().getRight();
        PetNode result5 = root.getRight().getLeft();
        PetNode result6 = root.getRight().getRight();
        PetNode result7 = root.getLeft().getLeft().getLeft();
        PetNode result8 = root.getLeft().getLeft().getRight();
        PetNode result9 = root.getLeft().getRight().getLeft();
        PetNode result10 = root.getLeft().getRight().getRight();

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