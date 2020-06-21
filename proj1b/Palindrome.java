import java.util.ArrayDeque;
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
        Deque<Character> deque = wordToDeque(word);
        return isPalindromeHelper(deque);
    }

    /**
     * A fuction that helps to judge if word is palindrome recursively
     * @param d
     * @return true or false
     */
    private boolean isPalindromeHelper(Deque d)
    {
        char first, last;
        if(d.size() <= 1) return true;
        first =(char) d.removeFirst();
        last = (char) d.removeLast();
        if(Character.toLowerCase(first) != Character.toLowerCase(last)) return false;
        else return isPalindromeHelper(d);
    }

    public boolean isPalindrome(String word, CharacterComparator cc)
    {
        Deque deque = wordToDeque(word);
        return isPalindromeHelper(deque, cc);
    }

    private boolean isPalindromeHelper(Deque d, CharacterComparator cc)
    {
        char first, last;
        if(d.size() <= 1) return true;
        first =Character.toLowerCase((char)d.removeFirst());
        last = Character.toLowerCase((char) d.removeLast());
        if(!cc.equalChars(first, last)) return false;
        else return isPalindromeHelper(d, cc);
    }
}
