package dev.logchange.core.domain.changelog.model.entry;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ChangelogEntryType {

    ADDED("added", 1),
    CHANGED("changed", 2),
    DEPRECATED("deprecated", 3),
    REMOVED("removed", 4),
    FIXED("fixed", 5),
    SECURITY("security", 6),
    DEPENDENCY_UPDATE("dependency_update", 7),
    OTHER("other", 8);


    @Deprecated
    private final String type;
    private final Integer order;

    public static ChangelogEntryType from(String orderNumber) {
        for (ChangelogEntryType type : values()) {
            if (type.getOrder().toString().equals(orderNumber)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Incorrect type!");
    }

    public static ChangelogEntryType fromNameIgnoreCase(String name) {
        for (ChangelogEntryType type : values()) {
            if (type.name().equalsIgnoreCase(name)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Incorrect type!");
    }

    @Override
    public String toString() {
        return order + ". " + type;
    }
}
