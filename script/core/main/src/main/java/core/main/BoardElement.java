package core.main;

public abstract class BoardElement {

    private String title;
    private boolean isPinned = false;

    /**
     * Creates a new board element. <code>title = ""</code> and
     * <code>isPinned = false</code> by default.
     */
    public BoardElement() {
        title = "";
        isPinned = false;
    }

    /**
     * Sets the title of a board element.
     *
     * @param title a String that becomes the title of the board element
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the title of the board element.
     *
     * @return the title of the board element as a String
     */
    public String getTitle() {
        return title;
    }

    /**
     * Pins the board element, which prioritizes it over other board elements.
     */
    public void pin() {
        isPinned = true;
    }

    /**
     * Removes the board element's priority over other board elements.
     */
    public void unPin() {
        isPinned = false;
    }

    /**
     * Checks if a board element is pinned.
     *
     * @return <code>true</code> if board element is pinned, otherwise
     *         <code>false</code>
     */
    public boolean isPinned() {
        return isPinned;
    }

}
