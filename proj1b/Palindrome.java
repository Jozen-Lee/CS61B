import java.util.Deque;

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
        Deque temp = new ArrayDeque<>();
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
        Deque<E> deque = wordToDeque(word);
        for(int i = 0; i < deque.size(); i++) deque[i] = Character.toLowerCase(deque[i]);
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
        else if(d.removeFirst() != d.removeLast()) return false;
        else return isPalindromeHelper(d);
    }

    public boolean isPalindrome(String word, CharacterComparator cc)
    {
        Deque<E> deque1 = wordToDeque(word);
        for(int i = 0; i < deque1.size(); i++) deque1[i] = Character.toLowerCase(deque1[i]);
        return isPalindromeHelper(deque1, cc);
    }

    private boolean isPalindromeHelper(Deque d, CharacterComparator cc)
    {
        if(d.size() <= 1) return true;
        else if(!cc.equalChars((char)d.removeFirst(), (char)d.removeLast())) return false;
        else return isPalindromeHelper(d, cc);
    }
}
