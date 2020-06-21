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
        Deque temp = wordToDeque(word);
        return isPalindromeHelper(temp);
    }

    /**
     * A fuction that helps to judge if word is palindrome recursively
     * @param d
     * @return true or false
     */
    private boolean isPalindromeHelper(Deque d)
    {
        if(d.size() <= 1) return true;
        else if(d.removeFirst() != d.removeLast()) return false;
        else return isPalindromeHelper(d);
    }

    public boolean isPalindrome(String word, CharacterComparator cc)
    {
        Deque d = wordToDeque(word);
        return isPalindromeHelper(d, cc);
    }

    private boolean isPalindromeHelper(Deque d, CharacterComparator cc)
    {
        if(d.size() <= 1) return true;
        else if(!cc.equalChars((char)d.removeFirst(), (char)d.removeLast())) return false;
        else return isPalindromeHelper(d, cc);
    }
}
