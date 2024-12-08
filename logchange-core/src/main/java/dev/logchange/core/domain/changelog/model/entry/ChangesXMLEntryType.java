package dev.logchange.core.domain.changelog.model.entry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.java.Log;

/**
 * Enum for types supported by Changes.xml.
 */
@Log
@Getter
@AllArgsConstructor
public enum ChangesXMLEntryType {

    ADD("add", 1),
    FIX("fix", 2),
    UPDATE("update", 3),
    REMOVE("remove", 4);

    private final String type;
    private final Integer order;

    public static ChangesXMLEntryType getXmlTypeFromMarkdownEntryType(ChangelogEntryType markdownEntryType) {
        switch (markdownEntryType) {
            case ADDED:
                return ChangesXMLEntryType.ADD;
            case CHANGED:
            case FIXED:
                return ChangesXMLEntryType.FIX;
            case DEPRECATED:
            case SECURITY:
            case DEPENDENCY_UPDATE:
            case OTHER:
                return ChangesXMLEntryType.UPDATE;
            case REMOVED:
                return ChangesXMLEntryType.REMOVE;
        }
        log.severe("Wrong change type: " + markdownEntryType);
        throw new IllegalArgumentException("Wrong change type");
    }
}
