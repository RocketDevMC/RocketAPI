package xyz.invisraidinq.rocketapi.api.enums;

public enum ColourEnum {

    WHITE((short) 0),
    ORANGE((short) 1),
    MAGENTA((short) 2),
    LIGHT_BLUE((short) 3),
    YELLOW((short) 4),
    LIME((short) 5),
    PINK((short) 6),
    GRAY((short) 7),
    SILVER((short) 8),
    CYAN((short) 9),
    PURPLE((short) 10),
    DARK_BLUE((short) 11),
    BROWN((short) 12),
    DARK_GREEN((short) 13),
    RED((short) 14),
    BLACK((short) 15);

    private final short data;

    /**
     * Constructor for the {@link ColourEnum}
     *
     * @param data The wool data
     */
    ColourEnum(short data) {
        this.data = data;
    }

    /**
     * Get the data of the wool
     *
     * @return The data of the wool
     */
    public short getData() {
        return this.data;
    }
}
