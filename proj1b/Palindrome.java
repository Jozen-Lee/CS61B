public class Palindrome
{
    /**
     * Return a Deque where the characters
     * appear in the same order as in the String.
     * @param word
     * @return Deque<Character>
     */
    public Deque<Character> wordToDeque(String word)
    {
        Deque<Character> temp = new ArrayDeque<>();
        for(int i = 0; i < word.length(); i++)
        {
            temp.addLast(word.charAt(i));
        }
        return temp;
    }

    /**
     * Judge if word is palindrome
     * @param word
     * @return true or false
     */
    public boolean isPalindrome(String word)
    {
        Deque deque = wordToDeque(word);
        return isPalindromeHelper(deque);
    }

    /**
     * A fuction that helps to judge if word is palindrome recursively
     * @param d
     * @return true or false
     */
    private boolean isPalindromeHelper(Deque d)
    {
        if(d.size() <= 1) return true;
        char first = (char) d.removeFirst();
        char last = (char) d.removeLast();
        if(Character.toLowerCase(first)!= Character.toLowerCase(last)) return false;
        else return isPalindromeHelper(d);
    }

    public boolean isPalindrome(String word, CharacterComparator cc)
    {
        Deque deque = wordToDeque(word);
        return isPalindromeHelper(deque, cc);
    }

    private boolean isPalindromeHelper(Deque d, CharacterComparator cc)
    {
        if(d.size() <= 1) return true;
        char first = (char) d.removeFirst();
        char last = (char) d.removeLast();
        if(!cc.equalChars(Character.toLowerCase(first),Character.toLowerCase(last))) return false;
        else return isPalindromeHelper(d, cc);
    }
}
