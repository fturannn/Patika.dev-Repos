import java.util.Random;
public class Snake extends Obstacle{
    public Snake() {
        super(4, "Yılan", (int)(Math.random() * 4) + 3, 12,0);
    }
}
