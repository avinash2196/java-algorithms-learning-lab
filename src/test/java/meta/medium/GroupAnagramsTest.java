package meta.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class GroupAnagramsTest {

    private GroupAnagrams groupAnagrams;

    @BeforeEach
    void setUp() {
        groupAnagrams = new GroupAnagrams();
    }

    @Test
    void classicExample() {
        List<List<String>> result = groupAnagrams.groupAnagrams(
                new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});

        assertEquals(3, result.size());

        Set<Set<String>> groups = toSetOfSets(result);
        assertTrue(groups.contains(new HashSet<>(Arrays.asList("bat"))));
        assertTrue(groups.contains(new HashSet<>(Arrays.asList("nat", "tan"))));
        assertTrue(groups.contains(new HashSet<>(Arrays.asList("ate", "eat", "tea"))));
    }

    @Test
    void singleEmptyString() {
        List<List<String>> result = groupAnagrams.groupAnagrams(new String[]{""});
        assertEquals(1, result.size());
        assertEquals(List.of(""), result.get(0));
    }

    @Test
    void singleCharacterStrings() {
        List<List<String>> result = groupAnagrams.groupAnagrams(new String[]{"a"});
        assertEquals(1, result.size());
    }

    @Test
    void noAnagramsAmongStrings() {
        List<List<String>> result = groupAnagrams.groupAnagrams(
                new String[]{"abc", "def", "ghi"});
        assertEquals(3, result.size());
    }

    // ── Helper ────────────────────────────────────────────────────────────────

    private Set<Set<String>> toSetOfSets(List<List<String>> groups) {
        Set<Set<String>> result = new HashSet<>();
        for (List<String> group : groups) {
            result.add(new HashSet<>(group));
        }
        return result;
    }
}
