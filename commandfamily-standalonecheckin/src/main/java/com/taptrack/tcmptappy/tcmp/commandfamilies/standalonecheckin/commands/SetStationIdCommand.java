package com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.commands;

import com.taptrack.tcmptappy.tcmp.MalformedPayloadException;
import com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.AbstractStandaloneCheckinMessage;
import com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.utils.ByteFormatConverters;

public class SetStationIdCommand extends AbstractStandaloneCheckinMessage {
    public static final byte COMMAND_CODE = 0x03;
    public int stationId;

    public SetStationIdCommand() {
        stationId = 0;
    }

    public SetStationIdCommand(int stationId) {
        this.stationId = stationId;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    @Override
    public void parsePayload(byte[] payload) throws MalformedPayloadException {
        if(payload.length != 2)
            throw new MalformedPayloadException("Payload is incorrect length, must contain two bytes");
        stationId = ByteFormatConverters.bytePairToUnsignedInt16(payload[0], payload[1]);
    }

    @Override
    public byte[] getPayload() {
        return ByteFormatConverters.unsignedInt16ToByteArray(stationId);
    }

    @Override
    public byte getCommandCode() {
        return COMMAND_CODE;
    }
}
