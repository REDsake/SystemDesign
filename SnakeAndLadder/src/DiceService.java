public class DiceService {
    public static int throwDice() {
        return (int) (Math.random()*6) + 1;
    }
}
