package com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.commands;

import com.taptrack.tcmptappy.tcmp.MalformedPayloadException;
import com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.AbstractStandaloneCheckinMessage;
import com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.utils.MicrochipRtcFormatter;

public class SetTimeAndDateCommand extends AbstractStandaloneCheckinMessage {
    public static final byte COMMAND_CODE = 0x08;
    protected int timestamp;

    public SetTimeAndDateCommand() {
        timestamp = 0;
    }

    public SetTimeAndDateCommand(int unixTimestamp) {
        this.timestamp = unixTimestamp;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public void parsePayload(byte[] payload) throws MalformedPayloadException {
        if(payload.length != 7)
            throw new MalformedPayloadException("Payload must be seven bytes");

        MicrochipRtcFormatter formatter = new MicrochipRtcFormatter(payload[0],
                payload[1],
                payload[2],
                payload[3],
                payload[4],
                payload[5]);
        timestamp = formatter.getUnixTimestamp();
    }

    @Override
    public byte[] getPayload() {
        MicrochipRtcFormatter formatter = new MicrochipRtcFormatter(timestamp);
        return formatter.getMicrochipRtcFormatted(true,true);
    }

    @Override
    public byte getCommandCode() {
        return COMMAND_CODE;
    }
}
