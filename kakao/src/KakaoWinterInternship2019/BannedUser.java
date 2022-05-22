package KakaoWinterInternship2019;

import java.util.*;

public class BannedUser {
    private Set<Set<String>> result;
    public int solution(String[] user_id, String[] banned_id) {
        result = new HashSet<>();
        dfs(user_id, banned_id, new LinkedHashSet<>());

        return result.size();
    }

    private void dfs(String[] users, String[] bannedIds, LinkedHashSet<String> bannedUserSet) {
        if (bannedUserSet.size() == bannedIds.length) {
            if (isBannedUsersOnly(bannedUserSet, bannedIds)) {
                result.add(new HashSet<>(bannedUserSet));
            }
            return;
        }

        for (String userId : users) {
            if (!bannedUserSet.contains(userId)) {
                bannedUserSet.add(userId);
                dfs(users, bannedIds, bannedUserSet);
                bannedUserSet.remove(userId);
            }
        }
    }
    private boolean isBannedUsersOnly(Set<String> set, String[] banned_id) {
        int i = 0;

        for (String user : set) {
            if (!isBannedUser(user, banned_id[i++])) {
                return false;
            }
        }

        return true;
    }

    private boolean isBannedUser(String userId, String bannedId) {
        if (userId.length() != bannedId.length()) {
            return false;
        }

        for (int i = 0 ; i < bannedId.length(); i++) {
            if (bannedId.charAt(i) == '*') {
                continue;
            }
            if (userId.charAt(i) != bannedId.charAt(i)) {
                return false;
            }
        }

        return true;
    }


}
