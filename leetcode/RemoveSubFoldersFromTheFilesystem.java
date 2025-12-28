import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
1233. Remove Sub-Folders from the Filesystem
* */
public class RemoveSubFoldersFromTheFilesystem {
    List<String> list;

    public List<String> removeSubfolders(String[] folder) {

        list = new ArrayList<>();

        Arrays.sort(folder);
        list.add(folder[0]);
        for (int i = 1; i < folder.length; i++) {
            String l = list.get(list.size() - 1);
            if (!folder[i].startsWith(l + "/")) {
                list.add(folder[i]);
            }
        }
        return list;
    }
}
