package xyz.invisraidinq.rocketapi.api.enums;

public enum Severity {

    CRITITAL("CRITITAL"),
    HIGH("High"),
    MEDIUM("Medium"),
    LOW("Low"),
    INFORMATION("Info"),
    WARNING("Warn");

    private final String format;

    /**
     * Enum constructor
     *
     * @param format The {@link Severity} format
     */
    Severity(String format) {
        this.format = format;
    }

    /**
     * Get the {@link Severity} format
     *
     * @return The format as a {@link String}
     */
    public String getFormat() {
        return this.format;
    }

}
