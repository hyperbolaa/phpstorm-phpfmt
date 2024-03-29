package com.phpfmt.fmt;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.components.StoragePathMacros;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Shaked on 12/13/15.
 */
@State(name = "phpfmtSettings",
        storages = {
                @Storage(file = StoragePathMacros.APP_CONFIG + "/phpfmt_settings.xml")})
public class Settings implements PersistentStateComponent<Settings> {
    @Nullable
    @Override
    public Settings getState() {
        return this;
    }

    @Override
    public void loadState(Settings settings) {
        XmlSerializerUtil.copyBean(settings, this);
    }

    private String pharPath = "";
    private String customPharPath = "";
    private String version = "";
    private String extensions = "php";

    public String getCustomPharPath() {
        return customPharPath;
    }

    public void setCustomPharPath(String customPharPath) {
        this.customPharPath = customPharPath;
    }

    public boolean isFormatOnSave() {
        return formatOnSave;
    }

    public void setFormatOnSave(boolean formatOnSave) {
        this.formatOnSave = formatOnSave;
    }

    private boolean formatOnSave = false;

    public ArrayList<String> getExtensions() {
        return new ArrayList<String>(Arrays.asList(extensions.split(",")));
    }

    public void setExtensions(String extensions) {
        this.extensions = extensions.replace(".", "");
    }

    private String optionsFile = "";

    private String phpExecutable = "/usr/local/bin/php";

    private boolean activated = true;
    private boolean debug = false;
    private boolean psr1 = false;
    private boolean psr1Naming = false;
    private boolean psr2 = false;
    private boolean indentWithSpace = false;
    private int indentWithSpaceSize = 0;
    private boolean enableAutoAlign = false;
    private boolean visibilityOrder = false;
    private boolean smartLinebreakAfterCurly = false;
    private boolean yoda = false;
    private String settersGettersType = "";
    private boolean autoImport = false;
    private String oracleFileName = "";
    private String ignoreFilesExtensions = "";
    private boolean autoUpdatePhar = false;

    public String getIgnoreFilesExtensions() {
        return ignoreFilesExtensions;
    }

    public boolean isAutoUpdatePhar() {
        return autoUpdatePhar;
    }

    public void setAutoUpdatePhar(boolean autoUpdatePhar) {
        this.autoUpdatePhar = autoUpdatePhar;
    }

    public void setIgnoreFilesExtensions(String ignoreFilesExtensions) {
        this.ignoreFilesExtensions = ignoreFilesExtensions;
    }

    public String getOracleFileName() {
        return oracleFileName;
    }

    public void setOracleFileName(String oracleFileName) {
        this.oracleFileName = oracleFileName;
    }

    public boolean isInstalled(String version) {
        return pharPath != "" && this.version == version;
    }

    public String getPharPath() {
        return pharPath;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setPharPath(String pharPath) {
        this.pharPath = pharPath;
    }

    private String passes = "";
    private String exclude = "";

    public boolean isActivated() {
        return activated;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public boolean isPsr1() {
        return psr1;
    }

    public void setPsr1(boolean psr1) {
        this.psr1 = psr1;
    }

    public boolean isPsr1Naming() {
        return psr1Naming;
    }

    public void setPsr1Naming(boolean psr1Naming) {
        this.psr1Naming = psr1Naming;
    }

    public boolean isPsr2() {
        return psr2;
    }

    public void setPsr2(boolean psr2) {
        this.psr2 = psr2;
    }

    public boolean isSpaceIndentation() {
        return indentWithSpace;
    }

    public void setSpaceIndentation(boolean indentWithSpace) {
        this.indentWithSpace = indentWithSpace;
    }

    public void setSpaceIndentationSize(int indentWithSpace) {
        this.indentWithSpaceSize = indentWithSpace;
    }

    public int getSpaceIndentationSize() {
        return this.indentWithSpaceSize;
    }

    public String getPasses() {
        return passes.trim();
    }

    public void setPasses(String passes) {
        this.passes = passes;
    }

    public String getExclude() {
        return exclude.trim();
    }

    public void setExclude(String exclude) {
        this.exclude = exclude;
    }

    public boolean isActivate() {
        return this.activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public boolean isAutoAlign() {
        return enableAutoAlign;
    }

    public void setAutoAlign(boolean enableAutoAlign) {
        this.enableAutoAlign = enableAutoAlign;
    }

    public boolean isVisibilityOrder() {
        return visibilityOrder;
    }

    public void setVisibilityOrder(boolean visibilityOrder) {
        this.visibilityOrder = visibilityOrder;
    }

    public boolean isSmartLinebreakAfterCurly() {
        return smartLinebreakAfterCurly;
    }

    public void setSmartLinebreakAfterCurly(boolean smartLinebreakAfterCurly) {
        this.smartLinebreakAfterCurly = smartLinebreakAfterCurly;
    }

    public boolean isYoda() {
        return yoda;
    }

    public void setYoda(boolean yoda) {
        this.yoda = yoda;
    }

    public String getSettersGettersType() {
        return settersGettersType;
    }

    public void setSettersGettersType(String settersGettersType) {
        this.settersGettersType = settersGettersType;
    }

    public boolean isAutoImport() {
        return autoImport;
    }

    public void setAutoImport(boolean autoImport) {
        this.autoImport = autoImport;
    }

    public String getOptionsFile() {
        return optionsFile;
    }

    public void setOptionsFile(String optionsFile) {
        this.optionsFile = optionsFile;
    }

    public String getPhpExecutable() {
        return phpExecutable;
    }

    public void setPhpExecutable(String phpExecutable) {
        this.phpExecutable = phpExecutable;
    }

    public String toString() {
        return "State" + this.getState() + "\n" +
                "Extensions" + this.getExtensions() + "\n" +
                "IgnoreFilesExtensions" + this.getIgnoreFilesExtensions() + "\n" +
                "OracleFileName" + this.getOracleFileName() + "\n" +
                "PharPath" + this.getPharPath() + "\n" +
                "Version" + this.getVersion() + "\n" +
                "SpaceIndentationSize" + this.getSpaceIndentationSize() + "\n" +
                "Passes" + this.getPasses() + "\n" +
                "Exclude" + this.getExclude() + "\n" +
                "SettersGettersType" + this.getSettersGettersType() + "\n" +
                "OptionsFile" + this.getOptionsFile() + "\n" +
                "PhpExecutable" + this.getPhpExecutable() + "\n";
    }
}
