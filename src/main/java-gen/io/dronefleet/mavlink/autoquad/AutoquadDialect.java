package io.dronefleet.mavlink.autoquad;

import io.dronefleet.mavlink.MavlinkDialect;
import io.dronefleet.mavlink.common.CommonDialect;
import java.lang.Class;
import java.lang.IllegalArgumentException;
import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final class AutoquadDialect implements MavlinkDialect {
    /**
     * A list of dialects that this dialect depends on.
     */
    private final List<MavlinkDialect> dependencies = Arrays.asList(
            new CommonDialect());

    /**
     * {@inheritDoc}
     */
    @Override
    public final String name() {
        return "autoquad";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean supports(int messageId) {
        switch (messageId) {
            case 150:
            case 152:
                return true;
        }
        return dependencies.stream()
                .anyMatch(d -> d.supports(messageId));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final Class resolve(int messageId) {
        switch (messageId) {
            case 150: return AqTelemetryF.class;
            case 152: return AqEscTelemetry.class;
        }
        return dependencies.stream()
                .map(d -> d.resolve(messageId))
                .filter(Objects::nonNull)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(getClass().getSimpleName() + " does not support message of ID " + messageId));
    }
}
