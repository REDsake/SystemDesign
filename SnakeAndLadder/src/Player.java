public class Player {
    private int id;

    private String name;
    private int currPosition = 0;
    public Player getBuilder() {
        return this;
    }

    public Player setId(int id) {
        this.id = id;
        return this;
    }

    public Player setName(String name) {
        this.name = name;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCurrPosition() {
        return currPosition;
    }
    public void setCurrPosition(int currPosition) {
        this.currPosition = currPosition;
    }
}
