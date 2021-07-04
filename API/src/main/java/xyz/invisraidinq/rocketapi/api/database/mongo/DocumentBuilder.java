package xyz.invisraidinq.rocketapi.api.database.mongo;

import org.bson.Document;

public class DocumentBuilder {

    private final Document document;

    /**
     * Instantiate an {@link DocumentBuilder} class
     *
     * @param document The {@link Document} to build off
     */
    public DocumentBuilder(Document document) {
        this.document = document;
    }

    /**
     * Instantiate an {@link DocumentBuilder class}
     */
    public DocumentBuilder() {
        this(new Document());
    }

    /**
     * Put a key/value into the document
     *
     * @param key The key to insert
     * @param value The value to insert
     * @return The {@link DocumentBuilder}
     */
    public DocumentBuilder put(String key, Object value) {
        this.document.put(key, value);
        return this;
    }

    /**
     * Append a key/value into the document
     *
     * @param key The key to insert
     * @param value The value to insert
     * @return The {@link DocumentBuilder}
     */
    public DocumentBuilder append(String key, Object value) {
        this.document.append(key, value);
        return this;
    }

    /**
     * Remove a key from the document
     *
     * @param key The key to remove
     * @return The {@link DocumentBuilder}
     */
    public DocumentBuilder remove(String key) {
        this.document.remove(key);
        return this;
    }


}
