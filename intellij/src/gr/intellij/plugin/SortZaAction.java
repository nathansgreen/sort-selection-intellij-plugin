package gr.intellij.plugin;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Insert Comment Here!
 *
 * @author Manos Papantonakos
 * @version 1.0.0
 * @since 06/2012
 */
public class SortZaAction extends SortAction {
    @Override
    public String sort(final String sort) {
        if (sort != null) {
            String[] lines = sort.split("\n");
            List<String> list = new LinkedList<String>();
            for (String s : lines) {
                list.add(s);
            }
            Collections.sort(list);
            StringBuilder sb = new StringBuilder();
            for (int i = list.size() - 1; i >= 0; i--) {
                sb.append(list.get(i)).append("\n");
            }
            return sb.toString();
        }
        return null;
    }
}
