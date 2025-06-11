package com.cyber009.common.utility;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class DataTime {
    public static LocalDateTime nowUtc() {
        return LocalDateTime.now(ZoneId.of("UTC"));
    }
}
