package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumFlagSet;
import java.lang.Object;
import java.lang.Override;
import java.util.Objects;

/**
 * This message sets the control surfaces for selective passthrough mode. 
 */
@MavlinkMessageInfo(
        id = 181,
        crc = 104
)
public final class CtrlSrfcPt {
    private final int target;

    private final EnumFlagSet<ControlSurfaceFlag> bitfieldpt;

    private CtrlSrfcPt(int target, EnumFlagSet<ControlSurfaceFlag> bitfieldpt) {
        this.target = target;
        this.bitfieldpt = bitfieldpt;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * The system setting the commands 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int target() {
        return this.target;
    }

    /**
     * Bitfield containing the passthrough configuration, see {@link io.dronefleet.mavlink.slugs.ControlSurfaceFlag CONTROL_SURFACE_FLAG} ENUM. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2
    )
    public final EnumFlagSet<ControlSurfaceFlag> bitfieldpt() {
        return this.bitfieldpt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        CtrlSrfcPt other = (CtrlSrfcPt)o;
        if (!Objects.deepEquals(target, other.target)) return false;
        if (!Objects.deepEquals(bitfieldpt, other.bitfieldpt)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(target);
        result = 31 * result + Objects.hashCode(bitfieldpt);
        return result;
    }

    public static final class Builder {
        private int target;

        private EnumFlagSet<ControlSurfaceFlag> bitfieldpt;

        /**
         * The system setting the commands 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1
        )
        public final Builder target(int target) {
            this.target = target;
            return this;
        }

        /**
         * Bitfield containing the passthrough configuration, see {@link io.dronefleet.mavlink.slugs.ControlSurfaceFlag CONTROL_SURFACE_FLAG} ENUM. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2
        )
        public final Builder bitfieldpt(EnumFlagSet<ControlSurfaceFlag> bitfieldpt) {
            this.bitfieldpt = bitfieldpt;
            return this;
        }

        public final CtrlSrfcPt build() {
            return new CtrlSrfcPt(target, bitfieldpt);
        }
    }
}
