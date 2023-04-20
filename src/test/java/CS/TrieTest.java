package CS;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static PracticeProblems.DSImplementations.Trie.*;
import static org.junit.jupiter.api.Assertions.*;

class TrieTest {

//    @Test
//    void insert() {
//    }

    /*
    *Trie.containsWord(String word){}
    * */
    @Test
    @DisplayName("APPLE_True")
    void containsWord_ValidAPPLE() throws IOException {
        createsTrie("sowpods.txt");
        assertTrue(containsWord("APPLE"));
    }
    @Test
    @DisplayName("ZZZS_True")
    void containsWord_ValidZZZS() throws IOException {
        createsTrie("sowpods.txt");
        assertTrue(containsWord("ZZZS"));
    }
    @Test
    @DisplayName("APPE_False")
    void containsWord_InvalidAPPE() throws IOException {
        createsTrie("sowpods.txt");
        assertFalse(containsWord("APPE"));
    }
    @Test
    @DisplayName("NULL_False")
    void containsWord_InvalidNULL() throws IOException {
        createsTrie("sowpods.txt");
        assertFalse(containsWord(null));
    }
    @Test
    @DisplayName("EMPTYSTRING_False")
    void containsWord_InvalidEmptyString() throws IOException {
        createsTrie("sowpods.txt");
        assertFalse(containsWord(""));
    }
    @Test
    @DisplayName("*%3+_False")
    void containsWord_InvalidChars() throws IOException {
        createsTrie("sowpods.txt");
        assertFalse(containsWord("*%3+"));
    }

    /*
     *Trie.containsWordWithPrefix(String prefix){}
     * */
    @Test
    @DisplayName("APP_True")
    void containsWordWithPrefix_ValidAPP() throws IOException {
        createsTrie("sowpods.txt");
        assertTrue(containsWordWithPrefix("APP"));
    }
    @Test
    @DisplayName("APPETI_True")
    void containsWordWithPrefix_ValidAPPETI() throws IOException {
        createsTrie("sowpods.txt");
        assertTrue(containsWordWithPrefix("APPETI"));
    }
    @Test
    @DisplayName("APZD_False")
    void containsWordWithPrefix_InvalidAPZD() throws IOException {
        createsTrie("sowpods.txt");
        assertFalse(containsWordWithPrefix("APZD"));
    }
    @Test
    @DisplayName("EMPTYSTRING_False")
    void containsWordWithPrefix_InvalidEMPTYSTRING() throws IOException {
        createsTrie("sowpods.txt");
        assertFalse(containsWordWithPrefix(""));
    }
    @Test
    @DisplayName("NULL_False")
    void containsWordWithPrefix_InvalidNULL() throws IOException {
        createsTrie("sowpods.txt");
        assertFalse(containsWordWithPrefix(null));
    }
    @Test
    @DisplayName("*%3+_False")
    void containsWordWithPrefix_InvalidChars() throws IOException {
        createsTrie("sowpods.txt");
        assertFalse(containsWordWithPrefix("*%3+"));
    }

    /*
     *Trie.validEntry(String entry){}
     * */
    @Test
    @DisplayName("VALIDSTRING_True")
    void validEntry_ValidVALIDSTRING() {
        assertTrue(validEntry("VALIDSTRING"));
    }
    @Test
    @DisplayName("NULL_False")
    void validEntry_InvalidNULL() {
        assertFalse(validEntry(null));
    }
    @Test
    @DisplayName("EMPTYSTRING_False")
    void validEntry_InvalidEMPTYSTRING() {
        assertFalse(validEntry(""));
    }

//
//    @Test
//    @DisplayName("")
//    void createsTrie_() {
//
//    }
}