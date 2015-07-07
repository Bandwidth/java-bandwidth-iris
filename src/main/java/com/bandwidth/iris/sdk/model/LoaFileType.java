package com.bandwidth.iris.sdk.model;

public enum LoaFileType {
    PDF("application/pdf"),
    PLAIN("text/plain"),
    JPG("image/jpeg"),
    TIFF("image/tiff"),
    CSV("text/csv"),
    XML("application/xml"),
    WAV("audio/x-wav"),
    ZIP("application/zip");

    private final String val;

    private LoaFileType(String val) {
        this.val = val;
    }

    public String toString() {
        return val;
    }
}
