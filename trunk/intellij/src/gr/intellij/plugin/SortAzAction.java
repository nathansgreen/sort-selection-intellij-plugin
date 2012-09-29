package gr.intellij.plugin;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Sort to az.
 *
 * @author Manos Papantonakos
 * @version 1.0
 * @since 05/2012
 */
public class SortAzAction extends SortAction {

    public String sort(final String sort) {
        if (sort != null) {
            String[] lines = sort.split("\n");
            List<String> list = new LinkedList<String>();
            for (String s : lines) {
                list.add(s);
            }
            Collections.sort(list);
            StringBuilder sb = new StringBuilder();
            for (String s : list) {
                sb.append(s).append("\n");
            }
            return sb.toString();
        }
        return null;
    }
}
