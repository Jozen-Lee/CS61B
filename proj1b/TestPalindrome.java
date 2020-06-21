import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } /**Uncomment this class once you've created your Palindrome class. */

    @Test
    public void testIsPalindrome()
    {
        assertTrue(palindrome.isPalindrome("abccba"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertFalse(palindrome.isPalindrome("baby"));
        assertFalse(palindrome.isPalindrome("Jozen"));
    }

    @Test
    public void testPalindrome()
    {
        OffByOne ob = new OffByOne();
        assertTrue(palindrome.isPalindrome("flake", ob));
        assertFalse(palindrome.isPalindrome("aaabbbaaa", ob));
        assertTrue(palindrome.isPalindrome("", ob));
        assertTrue(palindrome.isPalindrome("&", ob));
    }

    @Test
    public void testPalindromeByN() {
        OffByN offByN = new OffByN(6);
        assertTrue(palindrome.isPalindrome("gmdjgm", offByN));
        assertFalse(palindrome.isPalindrome("aaabbbaa", offByN));
        assertTrue(palindrome.isPalindrome("", offByN));
        assertTrue(palindrome.isPalindrome("&", offByN));
    }
}
