package Pages.Utilities;

public enum Languages {

    POLISH("Język Polski", "PL"),
    FRENCH("Français", "FR"),
    SPANISH("Español", "SP");

    private final String displayName;
    private String languageNameShortcut;

    Languages(String displayName) {
        this.displayName = displayName;
    }

    Languages(String displayName, String languageNameShortcut) {
        this.displayName = displayName;
        this.languageNameShortcut = languageNameShortcut;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getLanguageNameShortcut() {
        return languageNameShortcut;
    }
}
