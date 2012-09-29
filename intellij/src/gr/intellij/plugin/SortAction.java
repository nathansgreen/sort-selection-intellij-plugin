package gr.intellij.plugin;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.CommandProcessor;
import com.intellij.openapi.command.UndoConfirmationPolicy;
import com.intellij.openapi.editor.Editor;

/**
 * The sort action.
 *
 * @author Manos Papantonakos
 * @version 1.0
 * @since 06/2012
 */
public abstract class SortAction extends AnAction {
    public void actionPerformed(AnActionEvent e) {

        final Editor editor = DataKeys.EDITOR.getData(e.getDataContext());
        if (editor == null) {
            return;
        }
        final String newText = sort(editor.getSelectionModel().getSelectedText());
        if (newText == null) {
            return;
        }
        final int start = editor.getSelectionModel().getSelectionStart();
        final int end = editor.getSelectionModel().getSelectionEnd();

//        ApplicationManager.getApplication().runWriteAction( new Runnable() {
//            @Override
//            public void run() {
//                editor.getDocument().replaceString(start, end, newText);
//            }});
        CommandProcessor.getInstance().executeCommand(editor.getProject(), new Runnable() {
            @Override
            public void run() {
                ApplicationManager.getApplication().runWriteAction( new Runnable() {
                    @Override
                    public void run() {
                        editor.getDocument().replaceString(start, end, newText);
                    }});
            }
        }, "", null, UndoConfirmationPolicy.DO_NOT_REQUEST_CONFIRMATION);
    }

    protected abstract String sort(final String selectedText);
}
