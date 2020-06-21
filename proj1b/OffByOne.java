public class OffByOne implements CharacterComparator
{
    /**
     * return if x is equal to y
     * @param x
     * @param y
     * @return true of false
     */
    @Override
    public boolean equalChars(char x, char y)
    {
        int diff = x - y;
        return (Math.abs(diff) == 1 ? true : false);
    }
}
