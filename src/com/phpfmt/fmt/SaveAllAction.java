package com.phpfmt.fmt;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.DumbAware;
import org.apache.log4j.Level;
import org.jetbrains.annotations.NotNull;

public class SaveAllAction extends AnAction implements DumbAware {
    final public static String id = "phpfmt";
    private volatile boolean isActionPerformed = false;

    public static final Logger LOGGER = Logger.getInstance(SaveAllAction.class);
    static {
        LOGGER.setLevel(Level.DEBUG);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        try {
            this.isActionPerformed = true;
            LOGGER.debug("Saving....!");
            ApplicationManager.getApplication().saveAll();
        } finally {
            this.isActionPerformed = false;
        }
    }

    public boolean isActionPerformed(){
        return this.isActionPerformed;
    }
}